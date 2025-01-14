INSERT INTO categories (name, description) VALUES
                                                            ('Electrónica', 'Dispositivos electrónicos y accesorios'),
                                                            ('Hogar', 'Productos para el hogar y decoración'),
                                                            ('Juguetes', 'Juguetes y entretenimiento para niños'),
                                                            ('Ropa', 'Ropa y accesorios de moda');

INSERT INTO products (name, description, price, stock, sku) VALUES
                                                                            ('Teléfono Inteligente', 'Smartphone de última generación', 699.99, 50, 'ELEC001'),
                                                                            ('Auriculares Bluetooth', 'Auriculares inalámbricos con cancelación de ruido', 149.99, 30, 'ELEC002'),
                                                                            ('Cámara Deportiva', 'Cámara 4K resistente al agua', 199.99, 20, 'ELEC003'),
                                                                            ('Cafetera Automática', 'Cafetera con funciones programables', 89.99, 15, 'HOGAR001'),
                                                                            ('Lámpara LED', 'Lámpara de escritorio con luz ajustable', 29.99, 40, 'HOGAR002'),
                                                                            ('Sofá de Tela', 'Sofá cómodo para sala de estar', 499.99, 5, 'HOGAR003'),
                                                                            ('Muñeca Articulada', 'Muñeca con accesorios intercambiables', 24.99, 25, 'JUG001'),
                                                                            ('Juego de Construcción', 'Set de bloques de construcción para niños', 39.99, 20, 'JUG002'),
                                                                            ('Pelota de Fútbol', 'Pelota de fútbol de alta calidad', 19.99, 35, 'JUG003'),
                                                                            ('Camiseta Deportiva', 'Camiseta de entrenamiento unisex', 14.99, 50, 'ROP001'),
                                                                            ('Pantalón Deportivo', 'Pantalón de entrenamiento cómodo', 29.99, 45, 'ROP002'),
                                                                            ('Chaqueta de Invierno', 'Chaqueta cálida con capucha', 89.99, 10, 'ROP003'),
                                                                            ('Reloj Inteligente', 'Reloj inteligente con monitor de salud', 129.99, 25, 'ELEC004'),
                                                                            ('Aspiradora Robot', 'Aspiradora automática con programación inteligente', 299.99, 10, 'HOGAR004'),
                                                                            ('Puzzle de 1000 Piezas', 'Puzzle para adultos y niños', 19.99, 30, 'JUG004'),
                                                                            ('Juguete de Peluche', 'Peluche suave y tierno', 14.99, 40, 'JUG005'),
                                                                            ('Zapatos Deportivos', 'Zapatos para correr de alta resistencia', 79.99, 20, 'ROP004'),
                                                                            ('Bolso de Mano', 'Bolso elegante para mujer', 49.99, 15, 'ROP005'),
                                                                            ('Audífonos Gamer', 'Audífonos con micrófono para videojuegos', 99.99, 20, 'ELEC005'),
                                                                            ('Mesa de Centro', 'Mesa de centro moderna de madera', 149.99, 10, 'HOGAR005');

INSERT INTO customers (customer_id, first_name, last_name, email, password, address, phone_number) VALUES
                                                                                                       (1, 'Juan', 'López', 'juan.lopez@example.com', 'password1', 'Calle Falsa 123', '555123456'),
                                                                                                       (2, 'María', 'González', 'maria.gonzalez@example.com', 'password2', 'Avenida Siempre Viva 456', NULL),
                                                                                                       (3, 'Carlos', 'Pérez', 'carlos.perez@example.com', 'password3', 'Plaza Mayor 789', '555987654'),
                                                                                                       (4, 'Ana', 'Hernández', 'ana.hernandez@example.com', 'password4', 'Calle Luna 321', NULL);

INSERT INTO orders (order_id, customer_id, order_total, order_date) VALUES
    (1, 1, 469.97, CURRENT_TIMESTAMP);

INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
                                                                                        (1, 1, 1, 699.99),
                                                                                        (1, 2, 2, 149.99),
                                                                                        ( 1, 7, 3, 24.99);


INSERT INTO cart_items (cart_item_ic, customer_id, product_id, quantity) VALUES
                                                                             (1, 1, 8, 1),
                                                                             (2, 1, 10, 2),
                                                                             (3, 2, 14, 1),
                                                                             (4, 3, 16, 3);
