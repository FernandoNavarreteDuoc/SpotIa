CREATE TABLE comunas (
   idComuna INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   idRegion INT NOT NULL
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
