CREATE TABLE locales (
    idLocal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    capacidad INT NOT NULL
);

INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Le Voleign', 'Comida italiana', 100);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('La Casona', 'Salón con jardín', 100);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('El Mirador', 'Terraza con vista panorámica', 60);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('El Jardín', 'Espacio al aire libre para eventos', 80);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Blue Five', 'Bar con música en vivo', 60);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Cuatro Mares', 'Alojamiento en la costa', 200);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Energy Club', 'Gimnasio con instalaciones modernas', 200);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Camping Don Lalo', 'Piscinas al aire libre con área de descanso', 50);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Beauty Lengend', 'Salón de belleza y bienestar', 50);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Rodka', 'Bar con música en vivo', 100);
INSERT INTO locales (nombre, descripcion, capacidad) VALUES ('Café Dulce Hogar', 'Cafetería con ambiente acogedor y jardín', 100);

