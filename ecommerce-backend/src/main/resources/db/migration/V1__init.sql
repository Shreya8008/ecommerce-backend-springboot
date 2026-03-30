CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DOUBLE PRECISION,
    stock INTEGER,
    category_id INTEGER,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    total_amount DOUBLE PRECISION,
    status VARCHAR(50),
    user_id INTEGER,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_item (
    id SERIAL PRIMARY KEY,
    quantity INTEGER,
    price DOUBLE PRECISION,
    product_id INTEGER,
    order_id INTEGER,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(id)
);