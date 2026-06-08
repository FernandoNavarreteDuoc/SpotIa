CREATE TABLE tiposlocales (
   idTipoLocal INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(30) NOT NULL,
   descripcion VARCHAR(50) NOT NULL
);

INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Restaurante', 'Local dedicado a la preparación y venta de alimentos y bebidas para consumo en el lugar');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Bar', 'Local dedicado a la venta de bebidas alcohólicas y no alcohólicas para consumo en el lugar');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Cafetería', 'Local dedicado a la venta de café, té, pasteles y otros productos para consumo en el lugar');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Gimnasio', 'Local dedicado a la práctica de actividades físicas y deportivas para el mantenimiento de la salud y el bienestar');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Piscina', 'Local dedicado a la práctica de actividades acuáticas para el entretenimiento y la relajación');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Sala de reuniones', 'Local dedicado a la realización de eventos, conferencias y reuniones de negocios');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Salón de eventos', 'Local dedicado a la realización de eventos sociales, como bodas, cumpleaños y fiestas');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Spa', 'Local dedicado a la prestación de servicios de relajación, belleza y bienestar para los huéspedes del hotel');
INSERT INTO tiposlocales (nombre, descripcion) VALUES ('Hotel', 'Local dedicado a la prestación de servicios de alojamiento, alimentación y otros servicios para los huéspedes del hotel');
