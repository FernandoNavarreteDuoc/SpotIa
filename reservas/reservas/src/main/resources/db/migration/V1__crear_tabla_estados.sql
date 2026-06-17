CREATE TABLE estados (
   idEstado INT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
   descripcion VARCHAR(100) NOT NULL
);

INSERT INTO estados (nombre, descripcion) VALUES ('Pendiente', 'La reserva está pendiente para utilizar');
INSERT INTO estados (nombre, descripcion) VALUES ('En Proceso', 'La reserva está siendo utilizada');
INSERT INTO estados (nombre, descripcion) VALUES ('Finalizada', 'La reserva ha sido utilizada y finalizada exitosamente');

