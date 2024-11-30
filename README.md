# Elevar Full-stack Technical Test

An application that allows all CRUD operations for products and related categories.

## Implementation Checklist
- [x] Complete CRUD for products
- [x] Responsiveness
- [x] Search filters
- [x] Product categorization
- [x] Category-based search filters
- [ ] User login and management
- [ ] Authentication

## Table of Contents
- [Front-End](#front-end)
- [Back-End](#back-end)

## Front-End
Built with Angular 18


### Installation 
#### Prerequisites
- [Node](https://nodejs.org/en/)

#### Compiling the Project
- In the root directory of the project, run:
```bash
npm install
```

- To execute, run:
```bash
npm start
```

## Back-End
Built with Java and PostgreSQL.
![image](https://github.com/user-attachments/assets/a2c99a88-4da0-496d-a464-d62548c2237e)


### Installation
#### Prerequisites
- [Java JDK 8](https://www.oracle.com/br/java/technologies/downloads/archive/)
- [Apache Maven](https://maven.apache.org/download.cgi)

#### Compiling the Project
- In the root directory of the project, run:
```bash
mvn clean install
```
-To execute, run:
```
mvn spring-boot:run
```

### Documentation 

#### API Endpoints Preview

- Categories
```text

GET /api/category/{id} - Retrieve a specific category by its ID.

PUT /api/category/{id} - Update a specific category by its ID.

DELETE /api/category/{id} - Delete a specific category by its ID.

GET /api/category - Retrieve a list of all categories.

POST /api/category - Create a new category.

POST /api/category/{parentId}/subcategories - Create a subcategory under a specific parent category.
```
- Products

```
GET /api/products/{id} - Retrieve a specific product by its ID.

PUT /api/products/{id} - Update a specific product by its ID.

DELETE /api/products/{id} - Delete a specific product by its ID.

GET /api/products - Retrieve a paginated list of products with optional filters.

POST /api/products - Create a new product.

```
###Screenshots
![image](https://github.com/user-attachments/assets/9d933f61-60b1-48a0-803b-79533de1f700)

![image](https://github.com/user-attachments/assets/efdf20be-2d7a-4cb0-aae7-12ca80e90773)

![image](https://github.com/user-attachments/assets/6ba88deb-10da-473d-b857-3dc673b56db1)

![image](https://github.com/user-attachments/assets/ba2ccfeb-2f26-4f69-bbd2-387600e2ebf7)

#### OpenAPI Documentation
- To view the full API documentation, including endpoints and data schemas, open the Swagger UI at:
  `/swagger-ui/index.html`

- For API documentation in JSON format suitable for tools like Postman, Insomnia, and other API clients, go to: `/v3/api-docs`.
