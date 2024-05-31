CREATE TABLE IF NOT EXISTS country (
    id SERIAL PRIMARY KEY,
    code VARCHAR(100) NOT NULL,
    country_name VARCHAR(100) NOT NULL,
    continent_name VARCHAR(100) NOT NULL,
    UNIQUE (code)
    );

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL ,
    created_at DATE NOT NULL,
    UNIQUE(email),
    country_id INT,
    FOREIGN KEY(country_id) REFERENCES country(id)

    );

CREATE  TABLE  IF NOT EXISTS  merchant(
    id SERIAL PRIMARY KEY,
    merchant_name VARCHAR(100) NOT NULL,
    created_at DATE NOT NULL,
    admin_id INT,
    country_id INT,
    FOREIGN KEY (admin_id) REFERENCES users(id),
    FOREIGN KEY (country_id) REFERENCES country(id)
    );

CREATE TABLE IF NOT EXISTS  orden (
    id SERIAL PRIMARY KEY,
    status VARCHAR(100) NOT NULL,
    create_at DATE NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS  products(
    id SERIAL PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) DEFAULT 0.00,
    status VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    merchant_id INT,
    FOREIGN KEY  (merchant_id) references merchant(id)
    );

CREATE TABLE IF NOT EXISTS  orderItems(
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    order_id INT,
    product_id INT,
    FOREIGN KEY(order_id) REFERENCES orden(id),
    FOREIGN KEY (product_id) REFERENCES products(id)

    );