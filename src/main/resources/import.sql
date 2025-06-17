-- Ejemplo en import.sql
INSERT INTO roles (id, nombre) VALUES (UUID(), 'ROL_USER');
INSERT INTO roles (id, nombre) VALUES (UUID(), 'ROLE_CLIENTE');
INSERT INTO roles (id, nombre) VALUES (UUID(), 'ROLE_FREELANCER'); -- ¡Asegúrate de que este rol exista!
INSERT INTO roles (id, nombre) VALUES (UUID(), 'ROL_ADMIN');
-- ... otros inserts