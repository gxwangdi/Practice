
Spring Demo Tutorial. 

Hello World Demo: https://www.youtube.com/watch?v=px5rfwi4yYk

MySQL & spring-security Demo: https://www.youtube.com/watch?v=Dt0ZaeO3_y8

application.properties
"
spring.jpa.hibernate.ddl-auto=none
# Need to explicitly set serverTimezone. Or mysql will think there are multiple timezone. 
spring.datasource.url=jdbc:mysql://localhost:3306/salesdb?serverTimezone=UTC
spring.datasource.username=${username}
spring.datasource.password=${password}
#logging.level.root=WARN
"

