package com.application.webapi.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.application.webapi.model.User;
public interface UserRepository extends MongoRepository<User,String>{
    boolean existsById(String id);
}
