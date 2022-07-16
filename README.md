# Navneet_BMS

Book My show

In order to clone the project :

> git clone https://github.com/shrnav/Navneet_BMS.git

-------------------------------------------------------

# Publicly available Docker images::

---------------------------------------------------------

navneet204/bms-namingserver:latest

navneet204/bms-gateway:latest

navneet204/bms-api:latest

navneet204/bms-client:latest

--------------------------------------------------------

# Ports used:

---------------------------------------------------------

bms-api : 8080

bms-client : 8888

bms-namingserver : 8761

bms-gateway : 8766

-----------------------------------------------------------

# Quickest way to execute the BMS project (Make sure your machine is installed with docker):

-----------------------------------------------------------------------------------------
1) Go to the path where docker-compose-only-execute.yml exist.

2) Execute the below command to up all the required services.

>docker-compose -f docker-compose-only-execute.yml up

if you want to build and run the image (both) then go to the path where docker-compose.yml exist and execute. (Make sure you have taken the latest code and build via mvm clean install).

>docker-compose up


3) Hit the URL http://localhost:8761 to confirm if all three services are up.

4) Queries to get the information from movies, screen and screening table loaded at startup:

	http://localhost:8080/getAllMovies

	http://localhost:8080/getAllScreen

	http://localhost:8080/getAllScreening
	
	http://localhost:8080/getAllTheatre


5) Problem : Browse theatres currently running the show (movie selected) in the town, including show timing by a chosen date.

http://localhost:8766/BMS-CLIENT/bms-client/INOX/Noida/Sudden%20Death/2022-06-28/10:00:00


6)Get TheatreId by theatreName and city.

http://localhost:8766/BMS-CLIENT/bms-client/INOX/Noida/Twelve%20Monkeys/2022-07-18/10:00:00


•	Probolem : Theatres can create, update, and delete shows for the day.

6) To create movie show for the day.

http://localhost:8080/create/INOX/Noida/2022-07-16   (Movie name would be "Force" and time show is default)

7) Update the show times by date.

http://localhost:8080/update/2022-07-16/12:00:00

8) Delete the show for the day.

http://localhost:8080/delete/2022-07-16

9) Show the loadbalancer vi API gateway.

http://localhost:8766/BMS-CLIENT/bms-client/PVR/Noida



>docker-compose down.

-------------------------------------------------------------------------------------

# Technologies used :

-------------------------------------------------------------------------------------------

Core Java,

Spring boot

Lombok

JPA

h2 ( for demo purpose only).

Tomcat as web server.

Docker for containerization.

Idea Intellej

Test coverage via Intellej

Git for version control.

Maven as build tool.

Docker file, Docker compose and  Jib client to create and execute docker image. 

Eureka discovery client

Feign Client

Dev tools

API Gateway

For security : We can use okta.

------------------------------------------------------------------------------------------

# Other ways to execute the project.

1) Clone the project

2) Build all projects using mvn clean install

3)Open command prompt and start all services via

> mvn spring-boot:run

------------------------------------------------------------------------------

# SONAR SUPPORT::

Added Sonar support to check code coverage.

After starting Sonar cube server.

Execute below command 

mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=generated_token

browse localhost:9000. You will see navneet-atm project listed.

----------------------------------------------------------
