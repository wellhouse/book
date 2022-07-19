# :ledger:Recipe Book
Simple application for managing your Recipes

# :rocket: Getting started
This project uses **lombok** for reducing the boilerplate code. If you have any problems with this, go to [lombok website](https://projectlombok.org/) and see how to install it on your favorite IDE.

We are using Hibernate Search for fulltext searchs on the database. You are going to need config the directory of your preference to save the .db file. You just need to put the path on the ***application.properties*** as shown below.
```
spring.datasource.url=jdbc:h2:file:<yourpath>/demodb.db.mv.db
```
You also need change another directory configuration for saving the index generated by Hibernate Search. It's the archive **application.yml**
```
directory.root: ./data/index
```

# :thought_balloon:Architectural Choices
## :card_file_box:Data Base architecture
The decision of having just one large text field for keeping the ingredients and the instructions was based on a briefly research on some websites that have the same proposal as this application. Just let the users put the ingredients and amounts separated per lines. It was not interresting keep a huge table of all the ingredients inserted by the users.
Using Hibernate Search Made the complex queries with many filters easiear to maintain. It also brings to application the fuzzy query, that can search for a word even when its written wrong or with lack of letters.
Fore more informations about this framework you can consult the official web site [Hibernate Search](https://hibernate.org/search/)

## **Database Design**
<img src="https://user-images.githubusercontent.com/7095754/179591592-dcf3fedc-edd1-4e1a-bae3-cd77fde857f1.jpeg" width="300" height="300">

## :triangular_ruler:Architectural patterns
The MVC architecture was chosen for this project for being known by the majority of developers, making tests easy to do and easy maintenance. Putting a service layer to encapsulate the domain logic is useful for unit tests and in case of some business logic or even repository has to be changed.
SOLID principles are being used also. As a reusability and single responsibility principle. There are some codes that has to be improved but those are totally separated and easy to find the modification point.

## :globe_with_meridians: Stack
- Java17
- Spring Boot 2x
- Maven 3
- H2 Database

Notes
 - There's a postman collection in the root of the project **RecipeBook.postman_collection.json**
 - You also can acccess the api documentation on swagger by http://localhost:8082/swagger-ui.html (8080 for dev profile)
