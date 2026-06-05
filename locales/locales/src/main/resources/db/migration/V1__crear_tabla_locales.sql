CREATE TABLE locales (
    idLocal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    capacidad INT NOT NULL
);

INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Le Voleign', 'Restaurante', 50);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('La Casona', 'Salón de eventos', 100);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('El Mirador', 'Terraza con vista panorámica', 30);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('La Bodega', 'Espacio para catas de vino', 20);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('El Jardín', 'Espacio al aire libre para eventos', 80);
