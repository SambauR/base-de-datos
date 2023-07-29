INSERT INTO membresias (nombre_mbs) VALUES
('BRONCE'),
('PLATA'),
('ORO'),
('PLATINO');

INSERT INTO tipos_barcos (nombre_tps) VALUES
('PEQUENIO'),
('MEDIANO'),
('GRANDE');

INSERT INTO cuotas_barcos (id_tps, cuota, fecha) VALUES
(1, '$500', '2015-01-01'),
(2, '$750', '2015-01-01'),
(3, '$1,000', '2015-01-01');

INSERT INTO precios_membresias (id_mbs, precio_mbs, fecha) VALUES
(1, '$1,000', '2015-01-01'),
(2, '$2,000', '2015-01-01'),
(3, '$3,000', '2015-01-01'),
(4, '$4,000', '2015-01-01');

INSERT INTO socios(id_mbs, nombre_scs, apellido_pat_scs, apellido_mat_scs, telefono_scs, correo_scs) VALUES
(1,'Jose','Lopez','Juarez','5512149930','queibrawamati-1939@yopmail.com'),
(1,'Alberto','Fernadez','Medina','5112540965','defeffaulallo-7885@yopmail.com'),
(2,'Julia','Hernandez','Cadena','5109436580','zidisadola-8944@yopmail.com'),
(3,'Ivonne','Cabrera','Castillo','5187426581','hogittiffoutre-6398@yopmail.com'),
(2,'Ricardo','Pichardo','Ortiz','5109346729','musissouzouya-9604@yopmail.com'),
(4,'Natael','Cano','Belic','5108367153', 'cehuvugoime-8333@yopmail.com'),
(3,'Angel','Escamilla','Escobar','5101542783', 'yotsubagod_nakano@yopmail.com'),
(1,'Emilia','Esquivel','Rendon','5104157189', 'yappifowapra-3878@yopmail.com'),
(4,'Francisco','Camacho','Villa','5174534213', 'pajopebofro-1835@yopmail.com'),
(2,'Ariel','Villena','Dominguez','5157318853', 'verauzunussa-6426@yopmail.com');

INSERT INTO patrones(nombre_pts, apellido_pat_pts, apellido_mat_pts, telefono_pts, correo_pts) VALUES
('Ana','Rodriguez','Pichardo','5581499330','wamati-1939@yopmail.com'),
('Lilia','Pichardo','Garcia','5612540965','lo-7885@yopmail.com'),
('Angel','Toledo','Torres','5542134276','souma-6163@yopmail.com'),
('Mercedes','Rosa','Castillo','6587426581','hog-6398@yopmail.com'),
('Joaquin','Lopez','Rodriguez','8712345265', 'tapiq3950@yopmail.com'),
('Peso','Pluma','Belic','9808367153','kalel-8333@yopmail.com'),
('David','Esmeralda', 'Escobar','5571958219', 'abcd@yopmail.com'),
('Edgar','Dominguez','Retro','3965412365','uncorreo@yopmail.com'),
('Fatima','Contreras','Vega','5544227789','demo@yopmail.com'),
('Arturo','Villanueva','Dominguez','5678983421','marian@yopmail.com');

INSERT INTO salidas(destino, fecha_sls, hora_sls) VALUES
('Narnia','2015-02-20', '12:00:01'),
('Reino de muy muy lejano', '2015-01-25', '05:52:41'),
('Belen','2015-03-23', '08:22:51'),
('Hyrule','2015-07-13', '07:52:45'),
('Olimpo','2015-04-23', '06:43:34'),
('Limbo','2015-06-27', '12:14:23'),
('Francia','2015-02-14', '10:24:51'),
('Mictlan','2015-12-15', '11:05:01'),
('Lago de los cisnes', '2015-11-05', '05:35:01'),
('Troya', '2015-09-21', '09:36:01');

INSERT INTO barcos(id_scs, id_pts, id_tps, codigo_amarre, nombre_bcs) VALUES
(10, 2, 1, 'A12', 'LA PINTA'),
(9, 1, 3, 'A10', 'POSEIDON'),
(8, 5, 2, 'B13', 'JACK'),
(1, 4, 1, 'B9', 'OUT'),
(6, 7, 3, 'C19', 'LUNA'),
(5, 6, 2, 'C20', 'SUN'),
(4, 9, 3, 'D56', 'EL PERLA NEGRA'),
(3, 3, 3, 'D87', 'LA ORCA'),
(2, 8, 1, 'E11', 'COOPER'),
(7, 10, 2, 'E6', 'THE SMALL');

INSERT INTO barcos_salidas(id_bcs, id_sls) VALUES
(1, 8),
(2, 5),
(3, 2),
(4, 9),
(5, 3),
(6, 1),
(7, 6),
(8, 4),
(9, 7),
(10, 10);