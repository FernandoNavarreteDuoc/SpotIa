CREATE TABLE comunas (
   idComuna INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   idRegion INT NOT NULL
);

CREATE TABLE regiones (
   idRegion INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL
);


CREATE TABLE ubicaciones (
   idUbicacion INT AUTO_INCREMENT PRIMARY KEY,
   direccion VARCHAR(100) NOT NULL,
   referencia VARCHAR(100) NOT NULL,
   idComuna INT NOT NULL
);


INSERT INTO comunas (nombre, idRegion) VALUES ('Talagante', 1);
INSERT INTO comunas (nombre, idRegion) VALUES ('Providencia', 1);
INSERT INTO comunas (nombre, idRegion) VALUES ('Ñuñoa', 1);
INSERT INTO comunas (nombre, idRegion) VALUES ('Maipú', 1);
INSERT INTO comunas (nombre, idRegion) VALUES ('Valparaíso', 2);
INSERT INTO comunas (nombre, idRegion) VALUES ('Viña del Mar', 2);
INSERT INTO comunas (nombre, idRegion) VALUES ('Concepción', 3);
INSERT INTO comunas (nombre, idRegion) VALUES ('Talcahuano', 3);
INSERT INTO comunas (nombre, idRegion) VALUES ('Temuco', 4);
INSERT INTO comunas (nombre, idRegion) VALUES ('Pucón', 4);
INSERT INTO comunas (nombre, idRegion) VALUES ('Antofagasta', 5);
INSERT INTO comunas (nombre, idRegion) VALUES ('Calama', 5);
INSERT INTO comunas (nombre, idRegion) VALUES ('Iquique', 6);
INSERT INTO comunas (nombre, idRegion) VALUES ('Arica', 6);
INSERT INTO comunas (nombre, idRegion) VALUES ('Rancagua', 7);
INSERT INTO comunas (nombre, idRegion) VALUES ('San Fernando', 7);
INSERT INTO comunas (nombre, idRegion) VALUES ('La Serena', 8);
INSERT INTO comunas (nombre, idRegion) VALUES ('Coquimbo', 8);
INSERT INTO comunas (nombre, idRegion) VALUES ('Osorno', 9);
INSERT INTO comunas (nombre, idRegion) VALUES ('Puerto Montt', 9);
INSERT INTO comunas (nombre, idRegion) VALUES ('Copiapó', 10);
INSERT INTO comunas (nombre, idRegion) VALUES ('Vallenar', 10);
INSERT INTO comunas (nombre, idRegion) VALUES ('Curicó', 11);
INSERT INTO comunas (nombre, idRegion) VALUES ('Linares', 11);


INSERT INTO regiones (nombre) VALUES ('Metropolitana');
INSERT INTO regiones (nombre) VALUES ('Valparaíso');
INSERT INTO regiones (nombre) VALUES ('Biobío');
INSERT INTO regiones (nombre) VALUES ('La Araucanía');
INSERT INTO regiones (nombre) VALUES ('Antofagasta');
INSERT INTO regiones (nombre) VALUES ('Tarapacá');
INSERT INTO regiones (nombre) VALUES ('O Higgins');
INSERT INTO regiones (nombre) VALUES ('Coquimbo');
INSERT INTO regiones (nombre) VALUES ('Los Lagos');
INSERT INTO regiones (nombre) VALUES ('Atacama');
INSERT INTO regiones (nombre) VALUES ('Maule');
INSERT INTO regiones (nombre) VALUES ('Ñuble');
INSERT INTO regiones (nombre) VALUES ('Los Ríos');
INSERT INTO regiones (nombre) VALUES ('Aysén');
INSERT INTO regiones (nombre) VALUES ('Magallanes');


INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle Principal 123', 'Esquina con Av. Libertador', 1);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. siempre viva 456', 'Frente a la plaza', 2);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Ruta 10, km 5', 'Al lado del restaurante', 3);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle Falsa 789', 'Detrás del supermercado', 4);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. del Mar 321', 'Cerca del hotel', 5);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle del Sol 654', 'A la vuelta de la esquina', 6);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. de la Paz 987', 'Frente al parque', 7);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle de la Luna 111', 'Al lado de la iglesia', 8);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. de los Pinos 222', 'Cerca del centro comercial', 9);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle de las Flores 333', 'Detrás del hospital', 10);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. de la Esperanza 444', 'Frente a la estación de tren', 11);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle de los Sueños 555', 'Al lado del cine', 12);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. de la Libertad 666', 'Cerca del museo', 13);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle de la Amistad 777', 'Detrás del banco', 14);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. de la Alegría 888', 'Frente a la biblioteca', 15);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle de la Esperanza 999', 'Al lado del parque de diversiones', 16);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Av. de la Paz 1010', 'Cerca del estadio', 17);
INSERT INTO ubicaciones (direccion, referencia, idComuna) VALUES ('Calle de la Libertad 1111', 'Detrás del centro de salud', 18);
