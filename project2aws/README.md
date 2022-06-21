# Project 2

Project 2 will be a group project. Groups will consist of 3 - 4 people.

Each team must designate one member of the team to act as Team Leader. Then decide on a team name.

Each team will choose a project from one of their member's Project 1's.

Teams are allowed to create new namespaces on the SRE Cluster for Project 2.
If done, the selected project must be deployed in the new namespace.

Each team will follow an Agile approach, and track needed tasks with JIRA. Daily Standups will happen separately for each group, led by the Team Leader. Each team must have a kanban board.
It is recommended to track the team's velocity.
___
>## Requirements
>
>- Each team must configure Prometheus to retrieve metrics from the deployed application
>
>- Teams must create custom metrics through the micrometer API
   >    - 3 member teams must create at least 1 custom metric
>    - 4 member teams must create at least 2 custom metrics
>    - These will be incorporated into the SLOs, so they should indicate something about the quality of the application
>    - Must be approved by the Trainer
>
>- Each team must define an SLO for their application.
   >    - Must include error rates as well as latencies
>    - Must include their custom metrics
>
>- Each team must define custom recording and alerting rules based on their SLOs
   >    - These must follow the multi-window, multi-burn rate approach
>
>- Each team must have a full DevOps pipeline built using Jenkins
   >    - This pipeline must be configured through a Jenkinsfile and triggered in response to a webhook
>    - The pipeline must also be configured with a SonarCloud quality gate
       >        - This additionally means that the project must have unit tests
>        - The only requirement will be to have minimum 70% test coverage for the service package
>    - The project will be deployed with a canary deployment model
       >        - Custom Dockerfiles must be designed and used
>        - No more usage of `mvn spring-boot:build-image`
           >            - However, teams may design their Dockerfiles based on it
>
>- Each team must create at least 1 Grafana dashboard to track all of the metrics associated with their SLO
   >    - Teams with 4 members must also have additional panels
          >        - Could be in a second dashboard
>    - The details for the additional panels must be approved by the Trainer
>    - Examples could be tracking relevant logs of the application or cpu/memory usage from Prometheus
>    - The more closely this additional dashboard indicates potential issue scenarios, the better
>    - The idea is to have visualizations that might indicate that a problem might occur soon, even if an alert has not fired yet
---
>## SLI (_Service Level Indicator_)
1) Assurance of various metrics monitoring (AlertManagerFailing)
2) Disk space reliability (DiskAlmostFull)
3) Node space reliability (NodeMemoryFull)
4) Suspicious or high traffic monitoring (HostNetworkTooMuchData)
5) Comprehensive traffic monitoring
6) Full application analysis
>## SLO (_Service Level Objective_)
1) 90% guaranteed uptime whenever we can afford to host
2) Guaranteed monitoring of traffic, health metrics, and error tracking
3) Prevention of host disk running out of space by alerting you when disk space is 10% or below
4) Prevention of nodes running out of space by alerting you when 10% or below
5) Alert notification for high amounts of traffic or potential DDoS attacks
6) Accurate traffic monitoring by tallying the exact number of requests and the specific kind of requests(GET,POST,etc...)
7) Complete application metrics coverage including data aggregation of basic, memory, GC, HikariCP, HTTP, Tomcat, and Logback statistics
____
>## Technologies Used:
1) Spring Framework:
   1) Developer Tools:
      1) SpringBoot DevTools
      2) Lombok
   2) Web:
      1) Spring Web
   3) Spring Boot Data JPA
   4) Spring Boot Actuator 
2) AWS
   1) RDS
3) Logback
4) Logcack-classic
5) Logback-core
6) slf4j
7) DBeaver
8) Postman
9) Grafana
10) Prometheus
11) Alert Manager
12) nssm

>## Secondary applications required :
1) Postman
2) DBeaver

>## How to use application:

>## Postman commands:
1) Navigate to project2aws > src > main > java > com.project2aws.training.revature > Project2AwsApplication
2) Run the application
3) Start Postman application
4) Start DBeaver and create new connection with the remote database hosted on AWS

How to use implemented features: (Body data must be sent in JSON format)
1) Login as Admin:
   1) POST - localhost:8091/users/login
   2) Body - {
      "username": "me@yahoo.com",
      "password": "notyou"
      }
2) Login as Customer:
   1) POST = localhost:8091/users/login
   2) Body - {
      "username": "a@yahoo.com",
      "password": "a"
      }
3) Register user as Admin: (You have to fill out userId, username, and password)
   1) POST - localhost:8091/users/registerUser
   2) Body - {
      "userId": ,
      "username": "@yahoo.com",
      "password": "",
      "role": "ADMIN"
      }
4) Register user as Customer: (You have to fill out userId, username, and password)
   1) POST - localhost:8091/users/registerUser
   2) Body - {
      "userId": ,
      "username": "@yahoo.com",
      "password": "",
      "role": "CUSTOMER"
      }
5) Get all users and their cart items:
   1) GET - http://localhost:8091/users/getUsers
6) Get items available in store:
   1) GET - http://localhost:8091/items/getItems
7) Add item to cart: (Put the userId at then end of request / You have to fill out username, cartId, and itemId)
   1) PUT - http://localhost:8091/users/addItemToCart/{userId}
   2) Body - {
      "username": "@yahoo.com",
      "cart":
      {
      "cartId": ,
      "itemList":
      [  
      {
      "itemId":
      }
      ]
      }
      }
8) Add item to store: (You must fill out itemId, itemName, itemPrice, and stock)
   1) POST - http://localhost:8091/items/addItem/
   2) Body - {
      "itemId": ,
      "itemName": "",
      "itemPrice": ,
      "stock":
      }
9) Delete item from store: (Put the itemId at then end of request)
   1) DELETE - http://localhost:8091/items/deleteItem/{itemId}
10) Add item stock: (You must fill out itemId, itemName, itemPrice, and stock)
    1) POST - http://localhost:8091/items/addStock
    2) Body - {
       "itemId": ,
       "itemName": "",
       "itemPrice": ,
       "stock": 
       }
11) Get users carts:
    1) GET - http://localhost:8091/carts/getCarts
12) Logout: 
    1) POST - localhost:8091/users/logout