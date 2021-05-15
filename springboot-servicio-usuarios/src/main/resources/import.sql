INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('juan123', '$2a$10$MTA6sPa7tBE0OCSmd7P0qOcfu2OMV2g0A1AQCsWxQdGV5Jf1MVKd.', 1, 'Juan', 'Perez', 'jperez@mail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('maria567', '$2a$10$T4tlRH8NIoVI8UDjhCuLteoghS8OrNLRUR3tfUBaj0Ry.GIH1q8GG', 1, 'Maria', 'Lopez', 'mlopez@mail.com');

INSERT INTO roles (nombre) values ('ROLE_USER');
INSERT INTO roles (nombre) values ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);