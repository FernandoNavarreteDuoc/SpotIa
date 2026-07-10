CREATE TABLE locales (
    idLocal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150) NOT NULL,
    capacidad INT NOT NULL,
    id_tipo_local INT NOT NULL,
    id_ubicacion INT NOT NULL
);

CREATE TABLE servicios (
   idServicio INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(150) NOT NULL,
   precio INT NOT NULL
);

CREATE TABLE tiposlocales (
   idTipoLocal INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(150) NOT NULL
);

INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('Le Voleign', 'Comida italiana de alta calidad', 100, 1, 1);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('La Casona', 'Salón con jardín para eventos', 100, 7, 2);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('El Mirador', 'Terraza con vista panorámica', 60, 1, 3);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('El Jardín', 'Espacio al aire libre para eventos', 80, 7, 4);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('Blue Five', 'Bar con música en vivo', 60, 2, 5);


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


INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Restaurante', 'Local dedicado a la venta de alimentos y bebidas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Bar', 'Local dedicado a la venta de bebidas alcoholicas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Cafeteria', 'Local dedicado a la venta de cafe y pasteles');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Gimnasio', 'Local dedicado a la practica de actividades fisicas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Piscina', 'Local dedicado a la practica de actividades acuaticas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Sala de reuniones', 'Local dedicado a eventos y reuniones de negocios');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Salon de eventos', 'Local dedicado a eventos sociales como bodas y fiestas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Spa', 'Local dedicado a servicios de relajacion y bienestar');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Hotel', 'Local dedicado a servicios de alojamiento y alimentacion');