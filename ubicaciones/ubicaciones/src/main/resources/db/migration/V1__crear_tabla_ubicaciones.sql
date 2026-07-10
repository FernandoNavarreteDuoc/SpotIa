CREATE TABLE ubicaciones (
   idUbicacion INT AUTO_INCREMENT PRIMARY KEY,
   direccion VARCHAR(100) NOT NULL,
   referencia VARCHAR(100) NOT NULL,
   idComuna INT NOT NULL
);

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
