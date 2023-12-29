package com.application.webapi.service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.application.webapi.model.Deposit;
import com.application.webapi.model.Dokumen;
import com.application.webapi.model.User;
import com.application.webapi.repository.DepositRepository;
import com.application.webapi.repository.ElasticRepository;
import com.application.webapi.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class DepositService {
    private final DepositRepository depositRepository;
    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;
    private final ElasticRepository elasticRepository;
    public DepositService(DepositRepository depositRepository,KafkaProducer kafkaProducer,UserRepository userRepository,ElasticRepository elasticRepository) {
        this.depositRepository = depositRepository;
        this.kafkaProducer = kafkaProducer;
        this.userRepository = userRepository;
        this.elasticRepository = elasticRepository;
         }

    /* caching in redis ,to get update data must clear cache */     
    @Cacheable(cacheNames = "listDeposit")     
    public List<Deposit> getAllDeposit() {
        return depositRepository.findAll();
        }
    
    public Iterable<Dokumen> getAllDepositElastic() {
        return elasticRepository.findAll();
        }    
        
    public Deposit saveDeposit(Deposit deposit) {
        long timestamp = System.currentTimeMillis();
        int timeNow = (int) (timestamp / 1000); 
        User u = userRepository.findById(deposit.getUserId()).orElseThrow(() -> new RuntimeException("ID tidak ditemukan"));
        Double balanceBefore = u.getBalance().doubleValue();;
        Double newBalance = balanceBefore + deposit.getAmount().doubleValue();
        BigDecimal updateBalance = new BigDecimal(newBalance);
        u.setBalance(updateBalance);
        
        /* Update balance User */
        userRepository.save(u);
        deposit.setCreatedAt(timeNow);
        deposit.setUpdatedAt(timeNow);

        /* Insert to Elastic Search */
        Dokumen dokumen = new Dokumen();
        Random random = new Random();
        int id = random.nextInt(100);
        dokumen.setId(id);
        dokumen.setUserId(deposit.getUserId());;
        dokumen.setAmount(deposit.getAmount());
        dokumen.setSource(deposit.getSource());
        dokumen.setStatus(deposit.getStatus());
        dokumen.setCreatedAt(timeNow);
        dokumen.setUpdatedAt(timeNow);
        elasticRepository.save(dokumen);

        /*Produce message to kafka */
        kafkaProducer.sendMessage("ProduceTopic", deposit);
        /* save into Mongodb */
        return depositRepository.save(deposit);
    }   
    
}
