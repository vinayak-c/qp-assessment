### Prerequisites to Run the Application on Local Machine

Before running the application on your local machine, ensure that you have the following prerequisites installed:

1. **Maven**: 
   - Install Maven from [Maven official website](https://maven.apache.org/install.html).

2. **Docker**: 
   - Install Docker from [Docker official website](https://www.docker.com/get-started).

### Technologies Used

The application utilizes the following technologies:

1. Java
2. Spring Boot
3. H2 In-memory database

### Steps to Build and Run the Application

Follow these steps to build and run the application on your local machine:

1. **Clone the Repository**: 
   - Clone the repository to your local machine using Git:
     ```
     git clone <repository-url>
     ```

2. **Navigate to the Repository**: 
   - Open a terminal or command prompt and navigate to the cloned repository:
     ```
     cd <repository-directory>
     ```

3. **Build Docker Image**: 
   - Run the following Maven command to build the Docker image of the application:
     ```
     mvn clean compile jib:dockerBuild
     ```

4. **Run Docker Image**: 
   - Once the Docker image is built, run the Docker container with the following command:
     ```
     docker run -p 8080:8080 qpassessment/grocery-qpassessment
     ```

5. **Access the Application**: 
   - Once the application is up and running, you can access the APIs using the following base URL:
     ```
     http://localhost:8080
     ```
6. **Access the H2 database**: 
   - Once the application is up and running, you can access the APIs using the following base URL:
     ```
     http://localhost:8080
     ```

### Application APIs

The application provides the following APIs:

#### Admin API Endpoint: `http://localhost:8080/api/admin/inventory/`

1. **Create New Product**: 
   - Use the POST method to create new products in the system.
   - Request Body:
     ```json
     {
         "name": "Iphone",
         "price": 23000,
         "quantity": 100
     }
     ```

2. **View Existing Items**: 
   - Use the GET method to view existing items.

3. **Delete Item**: 
   - Use the DELETE method to delete an item by passing the Item ID as a path variable.

4. **Update Product Details**: 
   - Use the PUT method to update existing product details by passing the new changes as the request body and the item ID as a path variable.
   - Example Request Body:
     ```json
     {
         "name": "Iphone",
         "price": 53000,
         "quantity": 100
     }
     ```

5. **Manage Inventory Levels**: 
   - Use the PATCH method to manage inventory levels by passing the required new quantity and the item ID as a path variable.
   - Example Request Body:
     ```json
     {
         "quantity": 200
     }
     ```

#### User API Endpoint: `http://localhost:8080/api/user/order`

1. **View Available Items**: 
   - Use the GET method to view the items available.

2. **Book Order**: 
   - Use the POST method to book an order.
   - Multiple items can be booked in a single order by passing a list of items as the request body in a single request.
   - Example Request Body:
     ```json
     {
         "items": [
             {
                 "itemId": 1,
                 "quantity": 1
             },
             {
                 "itemId": 2,
                 "quantity": 2
             }
         ]
     }
     ```

Ensure that the application is running and the necessary prerequisites are met before accessing the APIs.
