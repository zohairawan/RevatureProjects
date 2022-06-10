README file
Project 2 readme

Objectives:
1) 

Features to be Implemented:
1) 

Technologies Used:
1) Spring Framework:
   1) Developer Tools:
      1) SpringBoot DevTools
      2) Lombok
   2) Web:
      1) Spring Web
   3) Spring Boot Data JPA
   4) Spring Boot Actuator
2) FluentD 
3) Logback
4) Logcack-classic
5) Logback-core
6) slf4j
7) PostgreSQL
8) DBeaver
9) Postman

Secondary applications required :
1) Postman
2) DBeaver

How to use application:
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