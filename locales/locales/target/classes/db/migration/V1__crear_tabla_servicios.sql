CREATE TABLE servicios (
   idServicio INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(150) NOT NULL,
   precio INT NOT NULL
);

INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio al cuarto', 'Comida y bebida a la habitacion', 10000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Lavanderia', 'Lavado y planchado de ropa', 5000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Transporte', 'Traslado desde y hacia el aeropuerto', 15000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Spa', 'Masajes y tratamientos de belleza', 20000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Excursiones', 'Organizacion de excursiones y actividades turisticas', 30000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Alquiler de coches', 'Alquiler de coches para desplazamientos', 25000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Desayuno', 'Desayuno buffet en el restaurante del hotel', 8000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Cena', 'Cena a la carta en el restaurante del hotel', 12000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Bar', 'Bebidas y cocteles en el bar del hotel', 7000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Gimnasio', 'Acceso al gimnasio del hotel', 5000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Piscina', 'Acceso a la piscina del hotel', 6000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Sala de reuniones', 'Alquiler de sala para eventos y conferencias', 40000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Wifi', 'Acceso a internet inalambrico en habitaciones', 3000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Estacionamiento', 'Estacionamiento para los huespedes del hotel', 4000);