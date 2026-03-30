CREATE TABLE payments (
    id SERIAL PRIMARY KEY,
    amount DOUBLE PRECISION,
    method VARCHAR(50),
    status VARCHAR(50),
    transaction_id VARCHAR(255),
    order_id INTEGER UNIQUE,
    CONSTRAINT fk_order_payment FOREIGN KEY (order_id) REFERENCES orders(id)
);