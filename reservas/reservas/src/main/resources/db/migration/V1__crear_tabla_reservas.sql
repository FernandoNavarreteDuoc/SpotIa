CREATE TABLE reservas (
   idReserva INT AUTO_INCREMENT PRIMARY KEY,
   fechaReserva DATE NOT NULL,
   horaReserva TIME NOT NULL,
   cantidadPersonas INT NOT NULL,
   total INT NOT NULL,
);

INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total) VALUES ('2024-07-01', '19:00:00', 4, 200000);
INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total) VALUES ('2024-07-02', '20:00:00', 2, 100000);
INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total) VALUES ('2024-07-03', '18:30:00', 6, 300000);
INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total) VALUES ('2024-07-04', '21:00:00', 3, 150000);
INSERT INTO reservas (fechaReserva, horaReserva, cantidadPersonas, total) VALUES ('2024-07-05', '19:30:00', 5, 250000);
