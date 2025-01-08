use cinemark;

insert into administrador (Correo, Contraseña) values
("dxniel7328@gmail.com", "7328");

insert into tiquetero (Correo, Contraseña) values
("cinemark@gmail.com", "1234");

insert into rol (NombreRol, Salario) values 
("Cajero", 1800000.0),
("Tiquetero", 1500000.0),
("Supervisor", 1200000.0),
("Concesiones", 1300000.0),
("Encargado de Proyeccion", 1500000.0),
("Oficios varios", 1200000.0),
("Atencion al cliente", 1300000.0);

insert into medidasMateriaPrima(Nombre) VALUES
("Gramos"),
("Mililitros"),
("Unidades");

INSERT INTO materiaPrima (Nombre, ID_MedidasMateriaPrima, PrecioPorUnidad, FechaVencimiento) VALUES
("Maiz", 1, 0.5, "2027-02-02"),             -- Precio por gramo           1
("Coca-cola", 2, 0.5, "2028-02-02"),        -- Precio por mililitro       2
("Salchichas", 3, 100.0, "2025-11-11"),     -- Precio por unidad          3
("Pan", 3, 20.0, "2025-08-08"),             -- Precio por unidad          4
("Vasos grandes", 3, 10.0, NULL),           -- Precio por unidad          5
("Vasos medianos", 3, 8.0, NULL),           -- Precio por unidad          6
("Vasos pequeños", 3, 5.0, NULL),           -- Precio por unidad          7
("Balde Grande", 3, 10.0, NULL),            -- Precio por unidad          8
("Balde Mediano", 3, 8.0, NULL),            -- Precio por unidad          9
("Balde Pequeño", 3, 5.0, NULL),            -- Precio por unidad          10
("Caramelo", 2, 0.3, "2027-02-02"),         -- Precio por gramo           11
("Mantequilla", 2, 0.3, "2027-02-02"),      -- Precio por mililitro       12
("Cartones para hot dog", 3, 5.0, NULL),    -- Precio por unidad          13
("Chocolatina Jet", 3, 20.0, "2027-02-02"), -- Precio por unidad          14
("M&M", 3, 20.0, "2027-02-02"),             -- Precio por unidad          15
("Bolsa de Nachos", 3, 8.0, "2027-02-02"),                             -- 16
("Bolsa de salsas", 3, 5.0, "2027-02-02");  -- Precio por unidad          17

INSERT INTO productos (Nombre, Precio) VALUES
("Balde Pequeño de Palomitas", 5000.0), -- 1
("Balde Mediano de Palomitas", 8000.0), -- 2
("Balde Grande de Palomitas", 15000.0), -- 3
("Hotdog", 12000.0), -- 4
("Vaso Pequeño de Refresco", 3000.0), -- 5
("Vaso Mediano de Refresco", 7000.0), -- 6
("Vaso Grande de Refresco", 10000.0), -- 7
("Balde Pequeño de Palomitas Mixtas", 7000.0), -- 8
("Balde Mediano de Palomitas Mixtas", 12000.0), -- 9
("Balde Grande de Palomitas Mixtas", 18000.0), -- 10
("Chocolatina Jet", 3500.0), -- 11
("M&M", 3500.0), -- 12
("Bolsa de Nachos", 12000.0); -- 13

INSERT INTO combos (Nombre, Precio) VALUES
("Combo Parejas", 45000.0), -- 1
("Combo Personal", 21000.0), -- 2
("Combo Nachos", 25000.0), -- 3
("MegaCombo", 75000.0); -- 4

INSERT INTO productos_materia_prima (ID_Producto, ID_MateriaPrima, Cantidad) VALUES
-- Balde pequeño de palomitas
(1, 1, 200),
(1, 12, 10),

-- Balde mediano de palomitas
(2, 1, 400),
(2, 12, 30),

-- Balde grande de palomitas
(3, 1, 600),
(3, 12, 60),

-- Hotdog
(4, 3, 1), -- Salchicha
(4, 4, 1), -- Pan
(4, 13, 1), -- carton para hotdog

-- Vaso Pequeño de Refresco
(5, 2, 300), -- Coca-cola

-- Vaso Mediano de Refresco
(6, 2, 500), -- Coca-cola

-- Vaso Grande de Refresco
(7, 2, 900),

-- Balde pequeño palomitas mixtas
(8, 1, 200),
(8, 12, 10),
(8, 11, 10),

-- Balde mediano palomitas mixtas
(9, 1, 400),
(9, 12, 30),
(9, 11, 20),

-- Balde grande palomitas mixtas
(10, 1, 600),
(10, 12, 60),
(10, 11, 30);

INSERT INTO combos_productos (ID_Combo, ID_Producto, Cantidad) VALUES
-- Combo Parejas
(1, 1, 1), -- 1 Balde Pequeño de Palomitas
(1, 4, 2), -- 2 Hotdogs
(1, 5, 2), -- 2 Vasos Pequeños de Refresco

-- Combo Personal
(2, 2, 1), -- 1 Balde mediano de palomitas
(2, 4, 1), -- 1 hot dog
(2, 6, 1), -- 1 vaso mediano de refresco

-- Combo Nachos
(3, 1, 1), -- 1 balde pequeño de palomitas
(3, 7, 1), -- 1 vaso de refresco grande
(3, 11, 1), -- 1 chocolatina jet
(3, 13, 2), -- 2 paquetes de nachos

-- Mega Combo
(4, 3, 2), -- 2 baldes de palomitas grandes
(4, 4, 2), -- 2 hot dogs
(4, 7, 2), -- 2 refrescos grandes
(4, 11, 2), -- 2 chocolatinas jet
(4, 12, 2), -- 2 m6m
(4, 13, 1); -- 1 paquete de nachos

INSERT INTO inventario (ID_MateriaPrima, Cantidad, CantidadMinima, CantidadNecesaria) VALUES
(1, 10000, 8000, 100000),
(2, 20000, 10000, 200000),
(3, 50, 100, 1000),
(4, 100, 40, 500),
(5, 300, 100, 500),
(6, 500, 200, 1000),
(7, 700, 300, 1000),
(8, 200, 50, 1000),
(9, 300, 100, 1000),
(10, 400, 100, 1000),
(11, 10000, 5000, 200000),
(12, 8000, 500, 10000),
(13, 500, 400, 5000),
(14, 50, 40, 500),
(15, 100, 70, 500),
(16, 250, 100, 700),
(17, 50, 100, 500);

INSERT INTO proveedores (NombreEmpresa, Contacto, Direccion, Telefono, Correo) VALUES
("Maiz Medellin", "Juan Pérez", "Calle 123, Medellín", "1478963", "maizmedellin@gmail.com"),
("Coca-Cola", "Ana Gómez", "Avenida 45, Bogotá", "11111111", "coca_cola@gmail.com"),
("Salchichas El Rey", "Carlos Martínez", "Carrera 12, Bogotá", "21212121", "elrey@gmail.com"),
("Panadería La Familia", "Luis Rodríguez", "Calle 78, Medellín", "325417896", "pansito@gmail.com"),
("Vasos S.A.", "Ricardo Díaz", "Calle 10, Bogotá", "148975623", "vasos@gmail.com"),
("Baldex S.A.", "Diego Sánchez", "Calle 54, Medellín", "25718493", "baldex@gmail.com"),
("Caramelos del Valle", "Martín Pérez", "Carrera 9, Bogotá", "24252627", "caramelos@gmail.com"),
("Mantequillas Premium", "María López", "Calle 22, Medellín", "17181915", "mantquillina@gmail.com"),
("Chocolatina Jet", "José Silva", "Avenida 6, Bogotá", "35343637", "jet@gmail.com"),
("M&M Sweets", "Paola Gómez", "Calle 11, Medellín", "31343532", "mym@gmail.com"),
("Nachos del Sur", "Juliana Rodríguez", "Calle 18, Bogotá", "14151621", "nachossur@gmail.com");

INSERT INTO proveedoresMateriaPrima (ID_Proveedor, ID_MateriaPrima, PrecioPorUnidad) VALUES
(1, 1, 0.5),        -- Maiz Medellin - Maiz
(2, 2, 0.5),        -- Coca-Cola - Coca-Cola
(3, 3, 100.0),      -- Salchichas El Rey - Salchichas
(4, 4, 20.0),       -- Panadería La Familia - Pan
(5, 5, 10.0),       -- Vasos S.A. - Vasos grandes
(5, 6, 8.0),        -- Vasos S.A. - Vasos medianos
(5, 7, 5.0),        -- Vasos S.A. - Vasos pequeños
(6, 8, 10.0),       -- Baldex S.A. - Balde Grande
(6, 9, 8.0),        -- Baldex S.A. - Balde Mediano
(6, 10, 5.0),       -- Baldex S.A. - Balde Pequeño
(7, 11, 0.3),       -- Caramelos del Valle - Caramelo
(8, 12, 0.3),       -- Mantequillas Premium - Mantequilla
(6, 13, 5.0),       -- Chocolatina Jet - Cartones para hot dog
(9, 14, 20.0),      -- Chocolatina Jet - Chocolatina Jet
(10, 15, 20.0),     -- M&M Sweets - M&M
(11, 16, 8.0),      -- Nachos del Sur - Bolsa de Nachos
(3, 17, 5.0);

INSERT INTO peliculas (Nombre, FechaLanzamiento, Director, Genero, Duracion, Disponible, Estreno) VALUES
("Dune PT2", "2024-11-24", "Dennis Villenueve", "SCI_FI", 166, TRUE, FALSE),
("The Substance", "2024-12-10", "Margaret Qualley", "TERROR", 150, TRUE, TRUE),
("Mufasa", "2024-12-15", "Martin Roberts", "ANIMACION", 120, TRUE, TRUE);

INSERT INTO salas (Nombre, Precio, Tipo, Llena, CapacidadMaxima, CapacidadActual) VALUES
("Sala Basica", 1000.0, "BASICA", FALSE, 50, 50),
("Sala Basica B", 1000.0, "BASICA", FALSE, 70, 70),
("Sala Basica C", 1000.0, "BASICA", FALSE, 50, 50),
("Sala Grande", 4000.0, "GRANDE", FALSE, 100, 100),
("Sala Grande B", 4000.0, "GRANDE", FALSE, 100, 100),
("Sala XD", 6000.0, "XD", FALSE, 50, 50),
("Sala 3D", 5000.0, "S3D", FALSE, 70, 70);

INSERT INTO tipoAsientos (Nombre, Precio) VALUES
("Basico", 8000.0),
("Preferencial", 11000.0);
-- Sala Basica
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(1, 1, 'A', 1, FALSE),
(1, 1, 'A', 2, FALSE),
(1, 1, 'A', 3, FALSE),
(1, 1, 'A', 4, FALSE),
(1, 1, 'A', 5, FALSE),
(1, 1, 'A', 6, FALSE),
(1, 1, 'A', 7, FALSE),
(1, 1, 'A', 8, FALSE),
(1, 1, 'A', 9, FALSE),
(1, 1, 'A', 10, FALSE),
(1, 1, 'B', 1, FALSE),
(1, 1, 'B', 2, FALSE),
(1, 1, 'B', 3, FALSE),
(1, 1, 'B', 4, FALSE),
(1, 1, 'B', 5, FALSE),
(1, 1, 'B', 6, FALSE),
(1, 1, 'B', 7, FALSE),
(1, 1, 'B', 8, FALSE),
(1, 1, 'B', 9, FALSE),
(1, 1, 'B', 10, FALSE),
(1, 1, 'C', 1, FALSE),
(1, 1, 'C', 2, FALSE),
(1, 1, 'C', 3, FALSE),
(1, 1, 'C', 4, FALSE),
(1, 1, 'C', 5, FALSE),
(1, 1, 'C', 6, FALSE),
(1, 1, 'C', 7, FALSE),
(1, 1, 'C', 8, FALSE),
(1, 1, 'C', 9, FALSE),
(1, 1, 'C', 10, FALSE),
(1, 1, 'D', 1, FALSE),
(1, 1, 'D', 2, FALSE),
(1, 1, 'D', 3, FALSE),
(1, 1, 'D', 4, FALSE),
(1, 1, 'D', 5, FALSE),
(1, 1, 'D', 6, FALSE),
(1, 1, 'D', 7, FALSE),
(1, 1, 'D', 8, FALSE),
(1, 1, 'D', 9, FALSE),
(1, 1, 'D', 10, FALSE),
(1, 2, 'E', 1, FALSE),
(1, 2, 'E', 2, FALSE),
(1, 2, 'E', 3, FALSE),
(1, 2, 'E', 4, FALSE),
(1, 2, 'E', 5, FALSE),
(1, 2, 'E', 6, FALSE),
(1, 2, 'E', 7, FALSE),
(1, 2, 'E', 8, FALSE),
(1, 2, 'E', 9, FALSE),
(1, 2, 'E', 10, FALSE);
-- Sala Basica B
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(2, 1, 'A', 1, FALSE),
(2, 1, 'A', 2, FALSE),
(2, 1, 'A', 3, FALSE),
(2, 1, 'A', 4, FALSE),
(2, 1, 'A', 5, FALSE),
(2, 1, 'A', 6, FALSE),
(2, 1, 'A', 7, FALSE),
(2, 1, 'A', 8, FALSE),
(2, 1, 'A', 9, FALSE),
(2, 1, 'A', 10, FALSE),
(2, 1, 'B', 1, FALSE),
(2, 1, 'B', 2, FALSE),
(2, 1, 'B', 3, FALSE),
(2, 1, 'B', 4, FALSE),
(2, 1, 'B', 5, FALSE),
(2, 1, 'B', 6, FALSE),
(2, 1, 'B', 7, FALSE),
(2, 1, 'B', 8, FALSE),
(2, 1, 'B', 9, FALSE),
(2, 1, 'B', 10, FALSE),
(2, 1, 'C', 1, FALSE),
(2, 1, 'C', 2, FALSE),
(2, 1, 'C', 3, FALSE),
(2, 1, 'C', 4, FALSE),
(2, 1, 'C', 5, FALSE),
(2, 1, 'C', 6, FALSE),
(2, 1, 'C', 7, FALSE),
(2, 1, 'C', 8, FALSE),
(2, 1, 'C', 9, FALSE),
(2, 1, 'C', 10, FALSE),
(2, 1, 'D', 1, FALSE),
(2, 1, 'D', 2, FALSE),
(2, 1, 'D', 3, FALSE),
(2, 1, 'D', 4, FALSE),
(2, 1, 'D', 5, FALSE),
(2, 1, 'D', 6, FALSE),
(2, 1, 'D', 7, FALSE),
(2, 1, 'D', 8, FALSE),
(2, 1, 'D', 9, FALSE),
(2, 1, 'D', 10, FALSE),
(2, 1, 'E', 1, FALSE),
(2, 1, 'E', 2, FALSE),
(2, 1, 'E', 3, FALSE),
(2, 1, 'E', 4, FALSE),
(2, 1, 'E', 5, FALSE),
(2, 1, 'E', 6, FALSE),
(2, 1, 'E', 7, FALSE),
(2, 1, 'E', 8, FALSE),
(2, 1, 'E', 9, FALSE),
(2, 1, 'E', 10, FALSE),
(2, 1, "F", 1, FALSE),
(2, 1, "F", 2, FALSE),
(2, 1, "F", 3, FALSE),
(2, 1, "F", 4, FALSE),
(2, 1, "F", 5, FALSE),
(2, 1, "F", 6, FALSE),
(2, 1, "F", 7, FALSE),
(2, 1, "F", 8, FALSE),
(2, 1, "F", 9, FALSE),
(2, 1, "F", 10, FALSE),
(2, 2, "G", 1, FALSE),
(2, 2, "G", 2, FALSE),
(2, 2, "G", 3, FALSE),
(2, 2, "G", 4, FALSE),
(2, 2, "G", 5, FALSE),
(2, 2, "G", 6, FALSE),
(2, 2, "G", 7, FALSE),
(2, 2, "G", 8, FALSE),
(2, 2, "G", 9, FALSE),
(2, 2, "G", 10, FALSE);
-- Sala Basica C
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(3, 1, 'A', 1, FALSE),
(3, 1, 'A', 2, FALSE),
(3, 1, 'A', 3, FALSE),
(3, 1, 'A', 4, FALSE),
(3, 1, 'A', 5, FALSE),
(3, 1, 'A', 6, FALSE),
(3, 1, 'A', 7, FALSE),
(3, 1, 'A', 8, FALSE),
(3, 1, 'A', 9, FALSE),
(3, 1, 'A', 10, FALSE),
(3, 1, 'B', 1, FALSE),
(3, 1, 'B', 2, FALSE),
(3, 1, 'B', 3, FALSE),
(3, 1, 'B', 4, FALSE),
(3, 1, 'B', 5, FALSE),
(3, 1, 'B', 6, FALSE),
(3, 1, 'B', 7, FALSE),
(3, 1, 'B', 8, FALSE),
(3, 1, 'B', 9, FALSE),
(3, 1, 'B', 10, FALSE),
(3, 1, 'C', 1, FALSE),
(3, 1, 'C', 2, FALSE),
(3, 1, 'C', 3, FALSE),
(3, 1, 'C', 4, FALSE),
(3, 1, 'C', 5, FALSE),
(3, 1, 'C', 6, FALSE),
(3, 1, 'C', 7, FALSE),
(3, 1, 'C', 8, FALSE),
(3, 1, 'C', 9, FALSE),
(3, 1, 'C', 10, FALSE),
(3, 1, 'D', 1, FALSE),
(3, 1, 'D', 2, FALSE),
(3, 1, 'D', 3, FALSE),
(3, 1, 'D', 4, FALSE),
(3, 1, 'D', 5, FALSE),
(3, 1, 'D', 6, FALSE),
(3, 1, 'D', 7, FALSE),
(3, 1, 'D', 8, FALSE),
(3, 1, 'D', 9, FALSE),
(3, 1, 'D', 10, FALSE),
(3, 2, 'E', 1, FALSE),
(3, 2, 'E', 2, FALSE),
(3, 2, 'E', 3, FALSE),
(3, 2, 'E', 4, FALSE),
(3, 2, 'E', 5, FALSE),
(3, 2, 'E', 6, FALSE),
(3, 2, 'E', 7, FALSE),
(3, 2, 'E', 8, FALSE),
(3, 2, 'E', 9, FALSE),
(3, 2, 'E', 10, FALSE);
-- Sala Grande
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(4, 1, 'A', 1, FALSE),
(4, 1, 'A', 2, FALSE),
(4, 1, 'A', 3, FALSE),
(4, 1, 'A', 4, FALSE),
(4, 1, 'A', 5, FALSE),
(4, 1, 'A', 6, FALSE),
(4, 1, 'A', 7, FALSE),
(4, 1, 'A', 8, FALSE),
(4, 1, 'A', 9, FALSE),
(4, 1, 'A', 10, FALSE),
(4, 1, 'B', 1, FALSE),
(4, 1, 'B', 2, FALSE),
(4, 1, 'B', 3, FALSE),
(4, 1, 'B', 4, FALSE),
(4, 1, 'B', 5, FALSE),
(4, 1, 'B', 6, FALSE),
(4, 1, 'B', 7, FALSE),
(4, 1, 'B', 8, FALSE),
(4, 1, 'B', 9, FALSE),
(4, 1, 'B', 10, FALSE),
(4, 1, 'C', 1, FALSE),
(4, 1, 'C', 2, FALSE),
(4, 1, 'C', 3, FALSE),
(4, 1, 'C', 4, FALSE),
(4, 1, 'C', 5, FALSE),
(4, 1, 'C', 6, FALSE),
(4, 1, 'C', 7, FALSE),
(4, 1, 'C', 8, FALSE),
(4, 1, 'C', 9, FALSE),
(4, 1, 'C', 10, FALSE),
(4, 1, 'D', 1, FALSE),
(4, 1, 'D', 2, FALSE),
(4, 1, 'D', 3, FALSE),
(4, 1, 'D', 4, FALSE),
(4, 1, 'D', 5, FALSE),
(4, 1, 'D', 6, FALSE),
(4, 1, 'D', 7, FALSE),
(4, 1, 'D', 8, FALSE),
(4, 1, 'D', 9, FALSE),
(4, 1, 'D', 10, FALSE),
(4, 1, 'E', 1, FALSE),
(4, 1, 'E', 2, FALSE),
(4, 1, 'E', 3, FALSE),
(4, 1, 'E', 4, FALSE),
(4, 1, 'E', 5, FALSE),
(4, 1, 'E', 6, FALSE),
(4, 1, 'E', 7, FALSE),
(4, 1, 'E', 8, FALSE),
(4, 1, 'E', 9, FALSE),
(4, 1, 'E', 10, FALSE),
(4, 1, 'F', 1, FALSE),
(4, 1, 'F', 2, FALSE),
(4, 1, 'F', 3, FALSE),
(4, 1, 'F', 4, FALSE),
(4, 1, 'F', 5, FALSE),
(4, 1, 'F', 6, FALSE),
(4, 1, 'F', 7, FALSE),
(4, 1, 'F', 8, FALSE),
(4, 1, 'F', 9, FALSE),
(4, 1, 'F', 10, FALSE),
(4, 1, 'G', 1, FALSE),
(4, 1, 'G', 2, FALSE),
(4, 1, 'G', 3, FALSE),
(4, 1, 'G', 4, FALSE),
(4, 1, 'G', 5, FALSE),
(4, 1, 'G', 6, FALSE),
(4, 1, 'G', 7, FALSE),
(4, 1, 'G', 8, FALSE),
(4, 1, 'G', 9, FALSE),
(4, 1, 'G', 10, FALSE),
(4, 2, 'H', 1, FALSE),
(4, 2, 'H', 2, FALSE),
(4, 2, 'H', 3, FALSE),
(4, 2, 'H', 4, FALSE),
(4, 2, 'H', 5, FALSE),
(4, 2, 'H', 6, FALSE),
(4, 2, 'H', 7, FALSE),
(4, 2, 'H', 8, FALSE),
(4, 2, 'H', 9, FALSE),
(4, 2, 'H', 10, FALSE),
(4, 2, 'I', 1, FALSE),
(4, 2, 'I', 2, FALSE),
(4, 2, 'I', 3, FALSE),
(4, 2, 'I', 4, FALSE),
(4, 2, 'I', 5, FALSE),
(4, 2, 'I', 6, FALSE),
(4, 2, 'I', 7, FALSE),
(4, 2, 'I', 8, FALSE),
(4, 2, 'I', 9, FALSE),
(4, 2, 'I', 10, FALSE),
(4, 2, 'J', 1, FALSE),
(4, 2, 'J', 2, FALSE),
(4, 2, 'J', 3, FALSE),
(4, 2, 'J', 4, FALSE),
(4, 2, 'J', 5, FALSE),
(4, 2, 'J', 6, FALSE),
(4, 2, 'J', 7, FALSE),
(4, 2, 'J', 8, FALSE),
(4, 2, 'J', 9, FALSE),
(4, 2, 'J', 10, FALSE);
-- Sala Grande B
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(5, 1, 'A', 1, FALSE),
(5, 1, 'A', 2, FALSE),
(5, 1, 'A', 3, FALSE),
(5, 1, 'A', 4, FALSE),
(5, 1, 'A', 5, FALSE),
(5, 1, 'A', 6, FALSE),
(5, 1, 'A', 7, FALSE),
(5, 1, 'A', 8, FALSE),
(5, 1, 'A', 9, FALSE),
(5, 1, 'A', 10, FALSE),
(5, 1, 'B', 1, FALSE),
(5, 1, 'B', 2, FALSE),
(5, 1, 'B', 3, FALSE),
(5, 1, 'B', 4, FALSE),
(5, 1, 'B', 5, FALSE),
(5, 1, 'B', 6, FALSE),
(5, 1, 'B', 7, FALSE),
(5, 1, 'B', 8, FALSE),
(5, 1, 'B', 9, FALSE),
(5, 1, 'B', 10, FALSE),
(5, 1, 'C', 1, FALSE),
(5, 1, 'C', 2, FALSE),
(5, 1, 'C', 3, FALSE),
(5, 1, 'C', 4, FALSE),
(5, 1, 'C', 5, FALSE),
(5, 1, 'C', 6, FALSE),
(5, 1, 'C', 7, FALSE),
(5, 1, 'C', 8, FALSE),
(5, 1, 'C', 9, FALSE),
(5, 1, 'C', 10, FALSE),
(5, 1, 'D', 1, FALSE),
(5, 1, 'D', 2, FALSE),
(5, 1, 'D', 3, FALSE),
(5, 1, 'D', 4, FALSE),
(5, 1, 'D', 5, FALSE),
(5, 1, 'D', 6, FALSE),
(5, 1, 'D', 7, FALSE),
(5, 1, 'D', 8, FALSE),
(5, 1, 'D', 9, FALSE),
(5, 1, 'D', 10, FALSE),
(5, 1, 'E', 1, FALSE),
(5, 1, 'E', 2, FALSE),
(5, 1, 'E', 3, FALSE),
(5, 1, 'E', 4, FALSE),
(5, 1, 'E', 5, FALSE),
(5, 1, 'E', 6, FALSE),
(5, 1, 'E', 7, FALSE),
(5, 1, 'E', 8, FALSE),
(5, 1, 'E', 9, FALSE),
(5, 1, 'E', 10, FALSE),
(5, 1, 'F', 1, FALSE),
(5, 1, 'F', 2, FALSE),
(5, 1, 'F', 3, FALSE),
(5, 1, 'F', 4, FALSE),
(5, 1, 'F', 5, FALSE),
(5, 1, 'F', 6, FALSE),
(5, 1, 'F', 7, FALSE),
(5, 1, 'F', 8, FALSE),
(5, 1, 'F', 9, FALSE),
(5, 1, 'F', 10, FALSE),
(5, 1, 'G', 1, FALSE),
(5, 1, 'G', 2, FALSE),
(5, 1, 'G', 3, FALSE),
(5, 1, 'G', 4, FALSE),
(5, 1, 'G', 5, FALSE),
(5, 1, 'G', 6, FALSE),
(5, 1, 'G', 7, FALSE),
(5, 1, 'G', 8, FALSE),
(5, 1, 'G', 9, FALSE),
(5, 1, 'G', 10, FALSE),
(5, 1, 'H', 1, FALSE),
(5, 1, 'H', 2, FALSE),
(5, 1, 'H', 3, FALSE),
(5, 1, 'H', 4, FALSE),
(5, 1, 'H', 5, FALSE),
(5, 1, 'H', 6, FALSE),
(5, 1, 'H', 7, FALSE),
(5, 1, 'H', 8, FALSE),
(5, 1, 'H', 9, FALSE),
(5, 1, 'H', 10, FALSE),
(5, 2, 'I', 1, FALSE),
(5, 2, 'I', 2, FALSE),
(5, 2, 'I', 3, FALSE),
(5, 2, 'I', 4, FALSE),
(5, 2, 'I', 5, FALSE),
(5, 2, 'I', 6, FALSE),
(5, 2, 'I', 7, FALSE),
(5, 2, 'I', 8, FALSE),
(5, 2, 'I', 9, FALSE),
(5, 2, 'I', 10, FALSE),
(5, 2, 'J', 1, FALSE),
(5, 2, 'J', 2, FALSE),
(5, 2, 'J', 3, FALSE),
(5, 2, 'J', 4, FALSE),
(5, 2, 'J', 5, FALSE),
(5, 2, 'J', 6, FALSE),
(5, 2, 'J', 7, FALSE),
(5, 2, 'J', 8, FALSE),
(5, 2, 'J', 9, FALSE),
(5, 2, 'J', 10, FALSE);
-- Sala 3d
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(6, 1, 'A', 1, FALSE),
(6, 1, 'A', 2, FALSE),
(6, 1, 'A', 3, FALSE),
(6, 1, 'A', 4, FALSE),
(6, 1, 'A', 5, FALSE),
(6, 1, 'A', 6, FALSE),
(6, 1, 'A', 7, FALSE),
(6, 1, 'A', 8, FALSE),
(6, 1, 'A', 9, FALSE),
(6, 1, 'A', 10, FALSE),
(6, 1, 'B', 1, FALSE),
(6, 1, 'B', 2, FALSE),
(6, 1, 'B', 3, FALSE),
(6, 1, 'B', 4, FALSE),
(6, 1, 'B', 5, FALSE),
(6, 1, 'B', 6, FALSE),
(6, 1, 'B', 7, FALSE),
(6, 1, 'B', 8, FALSE),
(6, 1, 'B', 9, FALSE),
(6, 1, 'B', 10, FALSE),
(6, 1, 'C', 1, FALSE),
(6, 1, 'C', 2, FALSE),
(6, 1, 'C', 3, FALSE),
(6, 1, 'C', 4, FALSE),
(6, 1, 'C', 5, FALSE),
(6, 1, 'C', 6, FALSE),
(6, 1, 'C', 7, FALSE),
(6, 1, 'C', 8, FALSE),
(6, 1, 'C', 9, FALSE),
(6, 1, 'C', 10, FALSE),
(6, 1, 'D', 1, FALSE),
(6, 1, 'D', 2, FALSE),
(6, 1, 'D', 3, FALSE),
(6, 1, 'D', 4, FALSE),
(6, 1, 'D', 5, FALSE),
(6, 1, 'D', 6, FALSE),
(6, 1, 'D', 7, FALSE),
(6, 1, 'D', 8, FALSE),
(6, 1, 'D', 9, FALSE),
(6, 1, 'D', 10, FALSE),
(6, 2, 'E', 1, FALSE),
(6, 2, 'E', 2, FALSE),
(6, 2, 'E', 3, FALSE),
(6, 2, 'E', 4, FALSE),
(6, 2, 'E', 5, FALSE),
(6, 2, 'E', 6, FALSE),
(6, 2, 'E', 7, FALSE),
(6, 2, 'E', 8, FALSE),
(6, 2, 'E', 9, FALSE),
(6, 2, 'E', 10, FALSE);
-- sala xd
INSERT INTO asientos (ID_Sala, ID_TipoAsiento, Fila, Numero, Ocupado) VALUES
(7, 1, 'A', 1, FALSE),
(7, 1, 'A', 2, FALSE),
(7, 1, 'A', 3, FALSE),
(7, 1, 'A', 4, FALSE),
(7, 1, 'A', 5, FALSE),
(7, 1, 'A', 6, FALSE),
(7, 1, 'A', 7, FALSE),
(7, 1, 'A', 8, FALSE),
(7, 1, 'A', 9, FALSE),
(7, 1, 'A', 10, FALSE),
(7, 1, 'B', 1, FALSE),
(7, 1, 'B', 2, FALSE),
(7, 1, 'B', 3, FALSE),
(7, 1, 'B', 4, FALSE),
(7, 1, 'B', 5, FALSE),
(7, 1, 'B', 6, FALSE),
(7, 1, 'B', 7, FALSE),
(7, 1, 'B', 8, FALSE),
(7, 1, 'B', 9, FALSE),
(7, 1, 'B', 10, FALSE),
(7, 1, 'C', 1, FALSE),
(7, 1, 'C', 2, FALSE),
(7, 1, 'C', 3, FALSE),
(7, 1, 'C', 4, FALSE),
(7, 1, 'C', 5, FALSE),
(7, 1, 'C', 6, FALSE),
(7, 1, 'C', 7, FALSE),
(7, 1, 'C', 8, FALSE),
(7, 1, 'C', 9, FALSE),
(7, 1, 'C', 10, FALSE),
(7, 1, 'D', 1, FALSE),
(7, 1, 'D', 2, FALSE),
(7, 1, 'D', 3, FALSE),
(7, 1, 'D', 4, FALSE),
(7, 1, 'D', 5, FALSE),
(7, 1, 'D', 6, FALSE),
(7, 1, 'D', 7, FALSE),
(7, 1, 'D', 8, FALSE),
(7, 1, 'D', 9, FALSE),
(7, 1, 'D', 10, FALSE),
(7, 1, 'E', 1, FALSE),
(7, 1, 'E', 2, FALSE),
(7, 1, 'E', 3, FALSE),
(7, 1, 'E', 4, FALSE),
(7, 1, 'E', 5, FALSE),
(7, 1, 'E', 6, FALSE),
(7, 1, 'E', 7, FALSE),
(7, 1, 'E', 8, FALSE),
(7, 1, 'E', 9, FALSE),
(7, 1, 'E', 10, FALSE),
(7, 1, 'F', 1, FALSE),
(7, 1, 'F', 2, FALSE),
(7, 1, 'F', 3, FALSE),
(7, 1, 'F', 4, FALSE),
(7, 1, 'F', 5, FALSE),
(7, 1, 'F', 6, FALSE),
(7, 1, 'F', 7, FALSE),
(7, 1, 'F', 8, FALSE),
(7, 1, 'F', 9, FALSE),
(7, 1, 'F', 10, FALSE),
(7, 2, 'G', 1, FALSE),
(7, 2, 'G', 2, FALSE),
(7, 2, 'G', 3, FALSE),
(7, 2, 'G', 4, FALSE),
(7, 2, 'G', 5, FALSE),
(7, 2, 'G', 6, FALSE),
(7, 2, 'G', 7, FALSE),
(7, 2, 'G', 8, FALSE),
(7, 2, 'G', 9, FALSE),
(7, 2, 'G', 10, FALSE);

INSERT INTO membresias (Nombre, Precio, Descripcion) VALUES 
("GOLD", 50000.0, "Membresia Gold para descuentos del 10% en todos los productos del cine y tiquetes"),
("PLATINUM", 100000.0, "Membresia Platinum para descuentos del 20% en todos los productos del cine y tiquetes"),
("SIN MEMBRESIA", 0, "Sin membresia");

insert into empleados (Nombre, Apellido, Cedula, FechaNacimiento, ID_Rol) values ("Samuel", "Orduz", "777", "2002-01-01", 2);