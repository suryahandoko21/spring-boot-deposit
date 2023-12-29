Requirement
o Spring IoC,
o Java Stream,
o Advance Native SQL query,
o containerization & microservices
o Kafka & Stream Based Application
o Redis, Caching Strategy & Data Grid
o Elastic & Other Non Relational DB

==== Run Application ====
- docker-compose up -d
- mvn spring-boot:run
=========================

Feature
- crud user
- deposit user
- caching to redis "localhost:7071/deposits" and remove cache "localhost:7071/clear-cache"
- Stream log kafka when hit post user and deposit
- update balance when user deposit
  
API List
- [GET]localhost:7071 =  root Application
- [GET]localhost:7071/clear-cache = remove all cache in redis
- [GET]localhost:7071/users = list all user
- [POST]localhost:7071/users = { "id":"1","name":"user1","balance":0 }
- [POST]localhost:7071/deposits = { "userId":"1","source":"VA","amount":1000,"status":"SUCCESS"}
- [GET]localhost:7071/deposits = list all deposit (mongodb)
- [GET]localhost:7071/deposits/elastic-list = list all deposit (Elastic)

  
