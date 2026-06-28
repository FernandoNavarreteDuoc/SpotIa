CREATE TABLE clientes (
    rut VARCHAR(12) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono INTEGER NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contraseña VARCHAR(20) NOT NULL
);

INSERT INTO clientes (rut, nombre, direccion, telefono, correo, contraseña) VALUES ('12345678-9', 'Felipe Acosta', 'Bernardo Ohiggins 173', 123456789, 'felipe.acosta@example.com', 'password123');
INSERT INTO clientes (rut, nombre, direccion, telefono, correo, contraseña) VALUES ('98765432-1', 'Maria Gomez', 'Los Libertadores 426', 987654321, 'maria.gomez@example.com', 'c987654321');
INSERT INTO clientes (rut, nombre, direccion, telefono, correo, contraseña) VALUES ('11111111-1', 'Juan Perez', 'Trebulco 759', 849583745, 'juan.perez@example.com', 'pelusitatequiero123');
INSERT INTO clientes (rut, nombre, direccion, telefono, correo, contraseña) VALUES ('22222222-2', 'Ana Rodriguez', 'Juan Tenorio 123', 938465098, 'ana.rodriguez@example.com', 'soymuyfeliz6345');
INSERT INTO clientes (rut, nombre, direccion, telefono, correo, contraseña) VALUES ('33333333-3', 'Carlos Sanchez', 'Alcantara 426', 349805674, 'carlos.sanchez@example.com', 'arribalavida734');