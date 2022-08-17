# Sistema Odontológico 🦷 - Programação WEB 2
Projeto relacionado ao curso de Sistemas para Internet, durante o 4º período, na matéria de Programação WEB 2, ministrada pelo professor Francisco Júnior. 

# Informações 📝
- Projeto básico utilizando Spring.

# Dependências
- Spring Data JPA 
- Spring Boot DevTools
- MySQL Driver

# Conexão Database
- Deve ir no arquivo "application.properties".
- Pesquisar por "Jpa Spring application MySQL" para encontrar a configuração pronta.
- Cola as informações de acordo com o banco de dados:
    - spring.jpa.hibernate.ddl-auto=update
    - spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example?useTimezona=true&
    - spring.datasource.username=springuser
    - spring.datasource.password=ThePassword
    - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    - #spring.jpa.show-sql: true
- Banco configurado.

# Padrão de projeto
- MVP
- Singleton
https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
