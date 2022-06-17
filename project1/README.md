README file
Project 1

Objectives:
1)	Set up the backend for an online store to buy items.
2)	Users can register and login to add items to their cart.
3)	Then they can place orders.
4)	Registered users are stored in the Users table.
5)	Items that users can buy are stored in the Items table.
6)	User’s carts are stored in the Cart table.
7)	User’s orders are stored in the Orders table.

Features to be Implemented:
1) Register – register new users
2) Login/Logout – login and logout users
3) Get Users/Cart items – get all users and their cart items
4) Get Items – get all items that are available in the store
5) Add Item to Cart – adds selected item to the cart

Technologies Used:
1) Java
2) Maven
3) Spring Framework:
   1) Developer Tools:
      1) SpringBoot DevTools
      2) Lombok
   2) Web:
      1) Spring Web
   3) Spring Boot Data JPA
   4) Spring Boot Actuator
   5) Spring AOP
4) Logback
5) Logcack-classic
6) Logback-core
7) Log4J
8) PostgreSQL
9) DBeaver
10) Postman
11) Git

Secondary applications required :
1) Postman
2) DBeaver
3) PostgreSQL

How to use application:
1) Navigate to project1aws > src > main > java > com.project1aws.training.revature > Project1AwsApplication
2) Run the application
3) Start Postman application
4) Start DBeaver and create new connection with PostgreSQL

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