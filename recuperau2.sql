create database recuperau2;
use recuperau2;
drop database recuperau2;
  
CREATE TABLE alumnos (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(150) NOT NULL,
  apellido_1 VARCHAR(150) NOT NULL,
  apellido_2 VARCHAR(150) NOT NULL,
  fecha_na VARCHAR(150) NOT NULL,
  curp VARCHAR(150) NOT NULL,
  matricula VARCHAR(150) NOT NULL,
  matematicas DOUBLE NOT NULL,
  historia DOUBLE NOT NULL,
  engles DOUBLE NOT NULL,
  poo DOUBLE NOT NULL,
  promedio DOUBLE NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX curp_UNIQUE (curp ASC) VISIBLE,
  UNIQUE INDEX matricula_UNIQUE (matricula ASC) VISIBLE);
  
  CREATE TABLE maestros (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(150) NOT NULL,
  apellido_1 VARCHAR(150) NOT NULL,
  apellido_2 VARCHAR(150) NOT NULL,
  fecha_na VARCHAR(150) NOT NULL,
  curp VARCHAR(150) NOT NULL,
  no_empleado int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX no_empleado_UNIQUE (no_empleado ASC) VISIBLE
  );
  
  SELECT * FROM maestros;
