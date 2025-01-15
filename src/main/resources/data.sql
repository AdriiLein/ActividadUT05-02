
-- Insertar categorías
INSERT INTO categories (id, name, description) VALUES
                                                   (1, 'Electronics', 'Devices and gadgets'),
                                                   (2, 'Books', 'Fiction and non-fiction books'),
                                                   (3, 'Clothing', 'Men and women apparel'),
                                                   (4, 'Home & Kitchen', 'Furniture and appliances');

-- Insertar productos
INSERT INTO products (id, name, description, price, stock, sku, category_id) VALUES
                                                                                 (1, 'Smartphone', 'Latest model smartphone', 699.99, 50, 'ELEC001', 1),
                                                                                 (2, 'Laptop', 'High-performance laptop', 1299.99, 30, 'ELEC002', 1),
                                                                                 (3, 'Tablet', '10-inch tablet', 399.99, 20, 'ELEC003', 1),
                                                                                 (4, 'E-reader', '6-inch e-reader', 89.99, 100, 'BOOK001', 2),
                                                                                 (5, 'Novel', 'Bestselling novel', 19.99, 200, 'BOOK002', 2),
                                                                                 (6, 'Cookbook', 'Recipe collection', 25.99, 150, 'BOOK003', 2),
                                                                                 (7, 'T-Shirt', '100% Cotton T-shirt', 14.99, 500, 'CLOT001', 3),
                                                                                 (8, 'Jeans', 'Slim-fit jeans', 39.99, 300, 'CLOT002', 3),
                                                                                 (9, 'Jacket', 'Winter jacket', 89.99, 100, 'CLOT003', 3),
                                                                                 (10, 'Blender', 'Kitchen blender', 59.99, 120, 'HOME001', 4),
                                                                                 (11, 'Microwave', 'Compact microwave', 89.99, 80, 'HOME002', 4);

-- Relación productos-categorías
INSERT INTO products_categories (category_id, product_id) VALUES
                                                              (1, 1), (1, 2), (1, 3),
                                                              (2, 4), (2, 5), (2, 6),
                                                              (3, 7), (3, 8), (3, 9),
                                                              (4, 10), (4, 11);

-- Insertar clientes
INSERT INTO customers (id, first_name, last_name, email, password, address, phone_number) VALUES
                                                                                              (1, 'Juan', 'López', 'juan.lopez@example.com', 'password1', 'Calle Falsa 123', '555123456'),
                                                                                              (2, 'María', 'González', 'maria.gonzalez@example.com', 'password2', 'Avenida Siempre Viva 456', NULL),
                                                                                              (3, 'Carlos', 'Pérez', 'carlos.perez@example.com', 'password3', 'Plaza Mayor 789', '555987654'),
                                                                                              (4, 'Ana', 'Hernández', 'ana.hernandez@example.com', 'password4', 'Calle Luna 321', NULL);

-- Insertar pedidos
INSERT INTO orders (id, customer_id, order_total, order_date) VALUES
    (1, 1, 300.00, '2025-01-15 10:00:00');

-- Insertar productos en pedidos
INSERT INTO order_items (id, order_id, product_id, quantity, unit_price) VALUES
                                                                             (1, 1, 1, 1, 699.99),
                                                                             (2, 1, 2, 1, 1299.99),
                                                                             (3, 1, 4, 1, 89.99);

-- Insertar listas de deseos
INSERT INTO wishlists (id, name, shared, customer_id) VALUES
    (1, 'My Wishlist', TRUE, 2);

-- Insertar productos en listas de deseos
INSERT INTO wishlist_products (wishlist_id, product_id) VALUES
                                                            (1, 1), (1, 4), (1, 6);

-- Insertar productos en el carrito
INSERT INTO cart_items (id, customer_id, product_id, quantity) VALUES
                                                                   (1, 3, 7, 2),
                                                                   (2, 3, 8, 1),
                                                                   (3, 3, 10, 3),
                                                                   (4, 4, 11, 1);
