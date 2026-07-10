CREATE TABLE locales (
    idLocal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150) NOT NULL,
    capacidad INT NOT NULL,
    id_tipo_local INT NOT NULL,
    id_ubicacion INT NOT NULL
);


INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('Le Voleign', 'Comida italiana de alta calidad', 100, 1, 1);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('La Casona', 'Salón con jardín para eventos', 100, 7, 2);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('El Mirador', 'Terraza con vista panorámica', 60, 1, 3);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('El Jardín', 'Espacio al aire libre para eventos', 80, 7, 4);
INSERT INTO locales (nombre, descripcion, capacidad, id_tipo_local, id_ubicacion) VALUES ('Blue Five', 'Bar con música en vivo', 60, 2, 5);
