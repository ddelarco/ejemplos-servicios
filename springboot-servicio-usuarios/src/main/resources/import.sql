INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('juan123', '12345', 1, 'Juan', 'Perez', 'jperez@mail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('maria567', '12345', 1, 'Maria', 'Lopez', 'mlopez@mail.com');

INSERT INTO roles (nombre) values ('ROLE_USER');
INSERT INTO roles (nombre) values ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);