-- Inserción de categorías
INSERT INTO categories (name, description) VALUES
                                               ('Electrónica', 'Dispositivos electrónicos y accesorios'),
                                               ('Hogar', 'Productos para el hogar y decoración'),
                                               ('Juguetes', 'Juguetes y entretenimiento para niños'),
                                               ('Ropa', 'Ropa y accesorios de moda');

-- Inserción de productos
INSERT INTO products (name, description, price, stock, sku) VALUES
                                                                ('Teléfono Inteligente', 'Smartphone de última generación', 699.99, 50, 'ELEC001'),
                                                                ('Auriculares Bluetooth', 'Auriculares inalámbricos con cancelación de ruido', 149.99, 30, 'ELEC002'),
                                                                ('Cámara Deportiva', 'Cámara 4K resistente al agua', 199.99, 20, 'ELEC003'),
                                                                ('Cafetera Automática', 'Cafetera con funciones programables', 89.99, 15, 'HOGAR001'),
                                                                ('Lámpara LED', 'Lámpara de escritorio con luz ajustable', 29.99, 40, 'HOGAR002'),
                                                                ('Muñeca Articulada', 'Muñeca con accesorios intercambiables', 24.99, 25, 'JUG001'),
                                                                ('Juego de Construcción', 'Set de bloques de construcción para niños', 39.99, 20, 'JUG002'),
                                                                ('Pelota de Fútbol', 'Pelota de fútbol de alta calidad', 19.99, 35, 'JUG003'),
                                                                ('Camiseta Deportiva', 'Camiseta de entrenamiento unisex', 14.99, 50, 'ROP001'),
                                                                ('Zapatos Deportivos', 'Zapatos para correr de alta resistencia', 79.99, 20, 'ROP004');

-- Relación productos-categorías (products_categories)
INSERT INTO products_categories (category_id, product_id) VALUES
                                                              (1, 1), -- Teléfono Inteligente en Electrónica
                                                              (1, 2), -- Auriculares Bluetooth en Electrónica
                                                              (1, 3), -- Cámara Deportiva en Electrónica
                                                              (2, 4), -- Cafetera Automática en Hogar
                                                              (2, 5), -- Lámpara LED en Hogar
                                                              (3, 6), -- Muñeca Articulada en Juguetes
                                                              (3, 7), -- Juego de Construcción en Juguetes
                                                              (4, 8), -- Pelota de Fútbol en Ropa
                                                              (4, 9), -- Camiseta Deportiva en Ropa
                                                              (2, 10), -- Zapatos Deportivos en Hogar
                                                              (4, 10); -- Zapatos Deportivos también en Ropa

-- Inserción de clientes
INSERT INTO customers (customer_id, first_name, last_name, email, password, address, phone_number) VALUES
                                                                                                       (1, 'Juan', 'López', 'juan.lopez@example.com', 'password1', 'Calle Falsa 123', '555123456'),
                                                                                                       (2, 'María', 'González', 'maria.gonzalez@example.com', 'password2', 'Avenida Siempre Viva 456', NULL),
                                                                                                       (3, 'Carlos', 'Pérez', 'carlos.perez@example.com', 'password3', 'Plaza Mayor 789', '555987654'),
                                                                                                       (4, 'Ana', 'Hernández', 'ana.hernandez@example.com', 'password4', 'Calle Luna 321', NULL);

-- Inserción de pedido y sus items
INSERT INTO orders (order_id, customer_id, order_total, order_date) VALUES
    (1, 1, 469.97, CURRENT_TIMESTAMP);

INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
                                                                         (1, 1, 1, 699.99),
                                                                         (1, 2, 2, 149.99),
                                                                         (1, 6, 3, 24.99);

-- Inserción de lista de deseos y sus productos
INSERT INTO wishlists (wishlist_id, name, shared, customer_id) VALUES
    (1, 'Lista de deseos de Juan', true, 1);

INSERT INTO wishlist_products (wishlist_id, product_id) VALUES
                                                            (1, 1), -- Teléfono Inteligente
                                                            (1, 2), -- Auriculares Bluetooth
                                                            (1, 3); -- Cámara Deportiva

-- Inserción de productos en el carro de la compra
INSERT INTO cart_items (cart_item_ic, customer_id, product_id, quantity) VALUES
                                                                             (1, 1, 4, 1), -- Cafetera Automática
                                                                             (2, 1, 5, 2), -- Lámpara LED
                                                                             (3, 2, 6, 1), -- Muñeca Articulada
                                                                             (4, 3, 7, 3); -- Juego de Construcción