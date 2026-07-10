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

INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total, rut_cliente, id_local, id_servicio, id_metodo_pago, id_estado)
VALUES ('2026-07-01', '19:00:00', 4, 200000, '12345678-9', 1, 1, 1, 1);

INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total, rut_cliente, id_local, id_servicio, id_metodo_pago, id_estado)
VALUES ('2026-07-02', '20:00:00', 2, 100000, '98765432-1', 2, 2, 2, 1);

INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total, rut_cliente, id_local, id_servicio, id_metodo_pago, id_estado)
VALUES ('2026-07-03', '18:30:00', 6, 300000, '11111111-1', 3, 3, 3, 2);