CREATE TABLE tbtopicos(
	id INT PRIMARY KEY NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    mensaje VARCHAR(450) NOT NULL,
    fecha_creacion DATE NOT NULL,
    estatus_topico VARCHAR(150) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    curso VARCHAR(150) NOT NULL
);