CREATE DATABASE sales_database;

USE sales_database;

CREATE TABLE sales (
                       id int not null AUTO_INCREMENT PRIMARY KEY,
                       product VARCHAR(100),
                       price DECIMAL(10,2),
                       quantity int
);

INSERT INTO sales (product, price, quantity)
VALUES ('Laptop', 1000, 5);

INSERT INTO sales (product, price, quantity)
VALUES ('Phone', 700, 3);

INSERT INTO sales (product, price, quantity)
VALUES ('Tablet', 500, 2);

INSERT INTO sales (product, price, quantity)
VALUES ('Printer', 300, 4);

SELECT * FROM sales;

SELECT * FROM sales LIMIT 2;

SELECT SUM(price * quantity) FROM sales;

SELECT product,
       SUM(quantity),
       AVG(price)
FROM sales
GROUP BY product;