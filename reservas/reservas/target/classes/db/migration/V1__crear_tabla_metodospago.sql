CREATE TABLE metodospago (
   idMetodoPago INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(100) NOT NULL
);

INSERT INTO metodospago (nombre, descripcion) VALUES ('Tarjeta de Crédito', 'Pago mediante tarjeta de crédito');
INSERT INTO metodospago (nombre, descripcion) VALUES ('Tarjeta de Débito', 'Pago mediante tarjeta de débito');
INSERT INTO metodospago (nombre, descripcion) VALUES ('Transferencia Bancaria', 'Pago mediante transferencia bancaria');
INSERT INTO metodospago (nombre, descripcion) VALUES ('Efectivo', 'Pago en efectivo al momento de la reserva');
INSERT INTO metodospago (nombre, descripcion) VALUES ('PayPal', 'Pago mediante la plataforma de PayPal');
