# News Provider
A Microservice Spring boot Application for news providing to mail

## Description
There are multiple services in this microservice architechture. 

## Dapr Configuration
Find the .dapr folder in C drive. The path mostly looks like this >> C:\Users\Faysal\.dapr (Faysal will be replaced by your Pc Name). Inside this folder replace the component folder with the component folder in the file.
## Installation Guide
Open up your terminal from the root folder.
### Step 1:
Run MySql server in port 3306. Create a DB named `security`. 

To Run the DB from Docker Image, go to standalone folder. and RUN

       docker-compose -f ./db-docker-compose.yml up -d
    
### Step 2:
Change the DB credentials in application.yml file for both "Security-Service" and "News-Service" ( username and password)
### Step 3:
Open the command Prompt in administration Mode and RUN:
```
dapr run --app-id publisher --app-port 8080 --dapr-http-port 3500
```
Open another command Prompt window in administration Mode and RUN:

```
dapr run --app-id subscriber --app-port 8081 --dapr-http-port 3501
```
Note: Make sure you are running the news service in 8080 port and the mail service in 8081 port. Otherwise cahnge the app-port value in the command.
### Step 4:
Run all service from the IDE 

or from the terminal using the command 
Example: Go inside the service > discovery-server open cmd and run
```
mvn spring-boot:run
```
### Step 5:
After running all services, Tables will be created automatically.
Now insert values in preference table.
```
INSERT INTO security.preference (`category`) 
values ("Sprots"),("Weather"),("Politics"),("Top");
```

### Service Details

#### API-GATEWAY
```
port : 8000
```
### Call the api from postman through gateway


# Register a user
POST - http://localhost:8000/auth/register
	request body:
  ```
	{
		"email": "faysalstat04@gmail.com",
		"password": "admin",
		"preferences":[
			{
				"id":1,
				"category":"sport"
			}
	  ]
	}
 ```

# Login
POST - http://localhost:8000/auth/token
	request body:
  ```
	{
		"username": "faysalstat04@gmail.com",
		"password": "admin"
	}
```
# Validate the Token
GET - http://localhost:8000/auth/validate

Request Param:

Param name: token
Param value: Collect the token from Login response.

# Third Party API used
## News Provider
- https://newsdata.io/api/1/latest

Query Params:

    apikey  : pub_485357e364b279ba3fb92729ea004c3f609f7
    q       : Sports
    language: en

## Sumerization AI based API
- https://portal.ayfie.com/api/summarize

Headers:

    X-API-KEY:
        QCSDQTdMxOBuNCQYTFLkBvfMRuSRrjsDwTHaBmjmojbGQFMQof

Note: If this API-KEY doesn't work for you, create an account in the https://portal.ayfie.com and collect the API-KEY. change it inside News-Service.

## Dockerization
### Create Docker Image for API-GATEWAY 
1. Navigate to the api-gateway folder using the command:
    ```
    cd service/api-gateway
    ```
3. Build the application using Maven:
    ```
    mvn clean install
    ```
4. Finally, build the Docker image with the following command:
    ```
    docker build -t api-gateway .
    ```
### Create Docker Image for Discovery-Service 
1. Navigate to the discovery-server folder using the command:
    ```
    cd service/discovery-server
    ```
3. Build the application using Maven:
    ```
    mvn clean install
    ```
4. Finally, build the Docker image with the following command:
    ```
    docker build -t discovery-service .
    ```
### Create Docker Image for Security-Service 
1. Navigate to the discovery-server folder using the command:
    ```
    cd service/security-server
    ```
3. Build the application using Maven:
    ```
    mvn clean install
    ```
4. Finally, build the Docker image with the following command:
    ```
    docker build -t security-service .
    ```
### Create Docker Image for mail-service 

1. Navigate to the user-service folder using the command:
    ```
    cd service/mail-service
    ```

2. Navigate to the user-service folder using the command:
    ```
    cd service/mail-service
    ```
3. Build the application using Maven:
    ```
    mvn clean install
    ```
9. Finally, build the Docker image with the following command:
    ```
    docker build -t mail-service .
    ```
### Run All docker
1. Run The DB from Docker Compose
    ```
    docker-compose -f ./local-db-compose.yml up -d
    ```

2. Go back to standalone folder and run the command from terminal
 
    ```
    docker-compose -f ./docker-compose-all.yml up -d
    ```



