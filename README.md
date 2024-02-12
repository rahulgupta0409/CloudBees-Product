# CloudBees Product Application README
This is a Product application build for the CloudBees Hiring Assignment with Springboot. It is based on MVC Architecture. It offers **CRUD APIs** for efficient retrieval and insertion of Product data. It also consists of mechanism to calculate the price of any product in Product catalog based on the tax or discount with the help of another update API.



## Prerequisites
* Java-19 or later
* Docker (for containerization)
* Postman or any client tool for testing

## Quick Start

You can get this application up and running with just one command, assuming you have Docker installed.
```bash
docker run -it -p 8080:8080 rahul0409/cloudbees-product:v1
```

## Getting Started
Follow these steps to run and test this Product application.

### 1. Clone the Repository
Clone the repository using the command
~~~ 
git clone https://github.com/rahulgupta0409/totality-assignment.git
~~~
```
cd cloudbees-product
```
### 2. Build the Docker Image
Build the Docker image for the application.

```bash
docker build -t cloudbees-product .
```
### 3. Run the Docker Container
Run a Docker container based on the image, mapping service port (e.g., 8080) to a port on your host machine (e.g. 8080).

```bash
docker run -p 8080:8080 cloudbees-product
```
### 4. Test the Product Service
Use a client or Postman to connect to the Product service.


### Method 1: Create Product
* Input: Product details (Name, Description, Price, Quantity Available)
* Output: Product details (ProductID , Name, Description, Price, Quantity Available) an error message if creation fails.

#### CURL
```
curl --location 'http://localhost:8080/v1/product/createProduct' \
--header 'Content-Type: application/json' \
--data '{
    "name":"The Adventure",
    "description":"This is a new fiction book",
    "price":20.0,
    "quantityAvailable":20
}'
```


### Method 2: Read Product
* Input: ProductID of the product to retrieve
* Output: Product details (ProductID, Name, Description, Price, Quantity Available) or an error message if the product is not found.


#### CURL
```
curl --location 'http://localhost:8080/v1/product/getProductByProductId/1'
```


### Method 3: Update Product
* Input: Product details (ProductID , Name, Description, Price, Quantity Available) an error message if update fails.
* Output: Output: Success/Failure message


#### CURL
```
curl --location --request PUT 'http://localhost:8080/v1/product/updateProduct/1' \
--header 'Content-Type: application/json' \
--data '{
    "name":"The Incredible India",
    "description":"This is a new history book",
    "price":100.0,
    "quantityAvailable":50
}'
```

### Method 4: Delete Product
* Input: ProductID of the product to delete.
* Output: Output: Success/Failure message


#### CURL
```
curl --location --request DELETE 'http://localhost:8080/v1/product/deleteProduct/1'
```

### Method 5: Update Product (Tax)
* Input: ProductID of the product and Tax percentage.
* Output: Output: Success/Failure message with updated Product Details.


#### CURL
```
curl --location --request PUT 'http://localhost:8080/v1/product/updateProductTax/2?tax=2.0'
```

### Method 6: Update Product (Discount)
* Input: ProductID of the product and Discount percentage.
* Output: Output: Success/Failure message with updated Product Details.


#### CURL
```
curl --location --request PUT 'http://localhost:8080/v1/product/updateProductTax/2?discount=2.0'
```






## Acknowledgments
Thanks to the CloudBees hiring team for giving me the opportunity to showcase my skills.