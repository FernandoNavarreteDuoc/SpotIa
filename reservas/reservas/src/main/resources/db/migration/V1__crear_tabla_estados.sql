CREATE TABLE estados (
   idEstado INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE metodospago (
   idMetodoPago INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE reservas (
   idReserva INT AUTO_INCREMENT PRIMARY KEY,
   fechaReserva DATE NOT NULL,
   horaReserva TIME NOT NULL,
   cantidadPersonas INT NOT NULL,
   total INT NOT NULL,
   rut_cliente VARCHAR(12) NOT NULL,
   id_local INT NOT NULL,
   id_servicio INT NOT NULL,
   id_metodo_pago INT NOT NULL,
   id_estado INT NOT NULL
);


INSERT INTO estados (nombre, descripcion) VALUES ('Pendiente', 'La reserva está pendiente para utilizar');
INSERT INTO estados (nombre, descripcion) VALUES ('En Proceso', 'La reserva está siendo utilizada');
INSERT INTO estados (nombre, descripcion) VALUES ('Finalizada', 'La reserva ha sido utilizada y finalizada exitosamente');


INSERT INTO metodospago (nombre, descripcion) VALUES ('Tarjeta de Crédito', 'Pago mediante tarjeta de crédito');
INSERT INTO metodospago (nombre, descripcion) VALUES ('Tarjeta de Débito', 'Pago mediante tarjeta de débito');
INSERT INTO metodospago (nombre, descripcion) VALUES ('Transferencia Bancaria', 'Pago mediante transferencia bancaria');
INSERT INTO metodospago (nombre, descripcion) VALUES ('Efectivo', 'Pago en efectivo al momento de la reserva');
INSERT INTO metodospago (nombre, descripcion) VALUES ('PayPal', 'Pago mediante la plataforma de PayPal');


INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total, rut_cliente, id_local, id_servicio, id_metodo_pago, id_estado)
VALUES ('2026-07-01', '19:00:00', 4, 200000, '12345678-9', 1, 1, 1, 1);

INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total, rut_cliente, id_local, id_servicio, id_metodo_pago, id_estado)
VALUES ('2026-07-02', '20:00:00', 2, 100000, '98765432-1', 2, 2, 2, 1);

INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total, rut_cliente, id_local, id_servicio, id_metodo_pago, id_estado)
VALUES ('2026-07-03', '18:30:00', 6, 300000, '11111111-1', 3, 3, 3, 2);