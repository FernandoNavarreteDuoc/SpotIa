CREATE TABLE tiposlocales (
   idTipoLocal INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(150) NOT NULL
);

INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Restaurante', 'Local dedicado a la venta de alimentos y bebidas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Bar', 'Local dedicado a la venta de bebidas alcoholicas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Cafeteria', 'Local dedicado a la venta de cafe y pasteles');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Gimnasio', 'Local dedicado a la practica de actividades fisicas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Piscina', 'Local dedicado a la practica de actividades acuaticas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Sala de reuniones', 'Local dedicado a eventos y reuniones de negocios');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Salon de eventos', 'Local dedicado a eventos sociales como bodas y fiestas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Spa', 'Local dedicado a servicios de relajacion y bienestar');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Hotel', 'Local dedicado a servicios de alojamiento y alimentacion');