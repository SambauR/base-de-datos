SET NAMES 'latin1';
DROP DATABASE IF EXISTS clubnauticados;
CREATE DATABASE IF NOT EXISTS clubnauticados DEFAULT CHARACTER SET utf8;
USE clubnauticados;

CREATE TABLE membresias(
id_mbs					INTEGER NOT NULL AUTO_INCREMENT,
nombre_mbs				VARCHAR (30),
PRIMARY KEY (id_mbs)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE tipos_barcos(
id_tps					INTEGER NOT NULL AUTO_INCREMENT,
nombre_tps				VARCHAR (30),
PRIMARY KEY (id_tps)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE precios_membresias(
id_pcs					INTEGER NOT NULL AUTO_INCREMENT,
id_mbs					INTEGER NOT NULL,
precio_mbs				VARCHAR (30),
fecha					DATE,
PRIMARY KEY (id_pcs),
FOREIGN KEY (id_mbs) REFERENCES membresias(id_mbs)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE cuotas_barcos(
id_cts					INTEGER NOT NULL AUTO_INCREMENT,
id_tps					INTEGER NOT NULL,
cuota					VARCHAR (30),
fecha					DATE,
PRIMARY KEY (id_cts),
FOREIGN KEY (id_tps) REFERENCES tipos_barcos(id_tps)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE socios(
id_scs					INTEGER NOT NULL AUTO_INCREMENT,
id_mbs	 				INTEGER NOT NULL,
nombre_scs				VARCHAR(30) NOT NULL,
apellido_pat_scs		VARCHAR(30) NOT NULL,
apellido_mat_scs		VARCHAR(30) NOT NULL,
telefono_scs			VARCHAR(45) NOT NULL,
correo_scs				VARCHAR(100) NOT NULL,	
PRIMARY KEY (id_scs),
FOREIGN KEY (id_mbs) REFERENCES membresias(id_mbs),
CONSTRAINT solo_letras CHECK(nombre_scs REGEXP '^[A-Za-z]+$'),
CONSTRAINT solo_numeros CHECK(telefono_scs REGEXP '^[0-9]+$'),
CONSTRAINT correo_invalido CHECK(correo_scs REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
)DEFAULT CHARACTER SET utf8;

CREATE TABLE patrones(
id_pts					INTEGER NOT NULL AUTO_INCREMENT,
nombre_pts				VARCHAR(30) NOT NULL,
apellido_pat_pts		VARCHAR(30) NOT NULL,
apellido_mat_pts		VARCHAR(30) NOT NULL,
telefono_pts			VARCHAR(50) NOT NULL,
correo_pts				VARCHAR(100) NOT NULL,
PRIMARY KEY (id_pts),
CONSTRAINT solo_letras CHECK(nombre_pts REGEXP '^[A-Za-z]+$'),
CONSTRAINT solo_numeros CHECK(telefono_pts REGEXP '^[0-9]+$'),
CONSTRAINT correo_invalido CHECK(correo_pts REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
)DEFAULT CHARACTER SET utf8;

CREATE TABLE barcos(
id_bcs					INTEGER NOT NULL AUTO_INCREMENT,
id_scs					INTEGER NOT NULL,
id_pts					INTEGER NOT NULL,
id_tps					INTEGER NOT NULL,
codigo_amarre			VARCHAR(50) NOT NULL UNIQUE,
nombre_bcs				VARCHAR(30) NOT NULL,
PRIMARY KEY (id_bcs),
FOREIGN KEY (id_scs) REFERENCES socios(id_scs),
FOREIGN KEY (id_tps) REFERENCES tipos_barcos(id_tps),
FOREIGN KEY (id_pts) REFERENCES patrones (id_pts)
)DEFAULT CHARACTER SET utf8;

CREATE TABLE salidas(
id_sls					INTEGER NOT NULL AUTO_INCREMENT,
destino					VARCHAR(30),
fecha_sls				DATE,
hora_sls				TIME,
PRIMARY KEY (id_sls)
)DEFAULT CHARACTER SET utf8;


CREATE TABLE barcos_salidas(
id_bcs					INTEGER,
id_sls					INTEGER,
FOREIGN KEY (id_bcs) REFERENCES barcos(id_bcs),
FOREIGN KEY (id_sls) REFERENCES salidas(id_sls)
)DEFAULT CHARACTER SET utf8;