create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE producto (
	id int(11) not null auto_increment,
	nombre varchar NOT NULL,
	precio_unitario float4 NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE factura (
	id int(11) not null auto_increment,
	fecha datetime NOT NULL,
	descripcion varchar NULL,
	id_usuario int(11) NOT NULL,
	total float4 NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE venta_producto (
    id int(11) not null auto_increment,
	id_factura int4 NOT NULL,
	id_producto int4 NOT NULL,
	cantidad int4 NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id_factura) REFERENCES factura(id) ON DELETE CASCADE,
	FOREIGN KEY (id_producto) REFERENCES producto(id)
);

INSERT INTO usuario (nombre, clave, fecha_creacion) VALUES ('adrian.melo', '1234', now());
INSERT INTO usuario (nombre, clave, fecha_creacion) VALUES ('juan.osorio', '123456', now());
INSERT INTO usuario (nombre, clave, fecha_creacion) VALUES ('andres.lopez', '111111', now());
INSERT INTO usuario (nombre, clave, fecha_creacion) VALUES ('camila.perez', '123456', now());

INSERT INTO producto (nombre, precio_unitario) VALUES ('Acetaminofen', '5500');
INSERT INTO producto (nombre, precio_unitario) VALUES ('Fluconazol', '10000');
INSERT INTO producto (nombre, precio_unitario) VALUES ('Ibuprofeno', '3500');
INSERT INTO producto (nombre, precio_unitario) VALUES ('Dolex', '6500');
INSERT INTO producto (nombre, precio_unitario) VALUES ('Colgate', '3500');