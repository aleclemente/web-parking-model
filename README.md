# web-parking-model

<h1>Java API project to simulate a web vehicle parking model to host on Heroku cloud application platform to practice and learn more about a RESTful API using Spring framework. The application manage entrance and exit of vehicle in a parking storing data in a postgres database.</h1>

<p>💎 The main goal is to practice a RESTful Java API with Spring framework and other stacks listed below.</p>

<h2>🛑 Stacks:</h2>

<p>
✅ IntelliJ IDE<br>
✅ Java JDK 11<br>
✅ Maven<br>
✅ Spring Web<br>
✅ Spring Data JPA<br>
✅ Spring Security<br>
✅ Spring Cloud<br>
✅ Docker<br>
✅ Hibernate Validator<br>
✅ Lombok<br>
✅ Postgres Driver database<br>
✅ Postman<br>
✅ Git<br>
✅ GitHub<br>
</p>

# Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

# Stop Database
docker stop parking-db

# Start Database
docker start parking-db

# Show running containers
docker ps

------------
