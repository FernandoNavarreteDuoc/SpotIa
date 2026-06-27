CREATE TABLE servicios (
   idServicio INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(30) NOT NULL,
   descripcion VARCHAR(50) NOT NULL,
   precio INT NOT NULL
);

INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio al cuarto', 'Servicio de comida y bebida a la habitación', 10000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de lavandería', 'Servicio de lavado y planchado de ropa', 5000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de transporte', 'Servicio de transporte desde y hacia el aeropuerto', 15000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de spa', 'Servicio de masajes y tratamientos de belleza', 20000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de excursiones', 'Servicio de organización de excursiones y actividades turísticas', 30000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de alquiler de coches', 'Servicio de alquiler de coches para desplazamientos durante la estancia', 25000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de desayuno', 'Servicio de desayuno buffet en el restaurante del hotel', 8000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de cena', 'Servicio de cena a la carta en el restaurante del hotel', 12000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de bar', 'Servicio de bebidas y cócteles en el bar del hotel', 7000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de gimnasio', 'Servicio de acceso al gimnasio del hotel', 5000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de piscina', 'Servicio de acceso a la piscina del hotel', 6000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de sala de reuniones', 'Servicio de alquiler de sala de reuniones para eventos y conferencias', 40000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de wifi', 'Servicio de acceso a internet inalámbrico en las habitaciones y áreas comunes del hotel', 3000);
INSERT INTO servicios (nombre, descripcion, precio) VALUES ('Servicio de estacionamiento', 'Servicio de estacionamiento para los huéspedes del hotel', 4000);