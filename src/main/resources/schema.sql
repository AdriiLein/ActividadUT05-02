
-- Desactivar restricciones de claves foráneas
SET REFERENTIAL_INTEGRITY FALSE;

-- Eliminar tablas en el orden correcto
DROP TABLE IF EXISTS wishlist_products CASCADE;
DROP TABLE IF EXISTS wishlists CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS order_items CASCADE;
DROP TABLE IF EXISTS products_categories CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS shipments CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS products CASCADE;

-- Crear tablas nuevamente
CREATE TABLE categories (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            description TEXT
);

CREATE TABLE products (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price DOUBLE NOT NULL,
                          stock INT NOT NULL,
                          sku VARCHAR(50) NOT NULL,
                          category_id BIGINT,
                          FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE products_categories (
                                     product_id BIGINT NOT NULL,
                                     category_id BIGINT NOT NULL,
                                     PRIMARY KEY (product_id, category_id),
                                     FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
                                     FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);


CREATE TABLE customers (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,
                           email VARCHAR(100) NOT NULL,
                           password VARCHAR(100) NOT NULL,
                           phone_number VARCHAR(20),
                           address TEXT
);

CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        customer_id BIGINT NOT NULL,
                        order_total DOUBLE NOT NULL,
                        order_date TIMESTAMP NOT NULL,
                        FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE order_items (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             order_id BIGINT NOT NULL,
                             product_id BIGINT NOT NULL,
                             quantity INT NOT NULL,
                             unit_price DOUBLE NOT NULL,
                             FOREIGN KEY (order_id) REFERENCES orders(id),
                             FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE shipments (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           order_id BIGINT NOT NULL,
                           shipment_date TIMESTAMP NOT NULL,
                           zip_code VARCHAR(20),
                           city VARCHAR(100),
                           country VARCHAR(100),
                           state VARCHAR(100),
                           address TEXT,
                           FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE wishlists (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           shared BOOLEAN NOT NULL,
                           customer_id BIGINT NOT NULL,
                           FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE wishlist_products (
                                   wishlist_id BIGINT NOT NULL,
                                   product_id BIGINT NOT NULL,
                                   PRIMARY KEY (wishlist_id, product_id),
                                   FOREIGN KEY (wishlist_id) REFERENCES wishlists(id),
                                   FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE cart_items (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            customer_id BIGINT NOT NULL,
                            product_id BIGINT NOT NULL,
                            quantity INT NOT NULL,
                            FOREIGN KEY (customer_id) REFERENCES customers(id),
                            FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Reactivar restricciones de claves foráneas
SET REFERENTIAL_INTEGRITY TRUE;
