# Search Service
# Instruction to run the project
  - Install JDK 8 or higher on your machine 
  - Install Maven on your machine
  - Install any IDE Tool ( IntelliJ)
  - Install MongoDB

 # Steps to run the service 
   
  - Apply command (maven clean install)
  - Start MongoDB
  - Start the server from the IDE , Server will be up and running on port 8080  , you can view the swagger through this URL   
              http://localhost:8080/swagger-ui/index.html/
              
  # What is Purpose of This service 
  
  - This service is mainly integrating with https://run.mocky.io/v3/b755c334-9627-4b09-84f2-548cb1918184 that provide data on Mobile Handsets and initialize MongoDB with it, if you don't want to init the database please comment the line at the run method at SearchApplication class.
  - Provide dynamic search criteria over mobile handset data with any field to provide needed data for the user.
 
  # Technology used 
  
  - Spring Boot version 2.5.6
  - Swagger Documentation 
  - Lombok
  - Spring boot test
  - Spring cloud openfeign for client integration 
