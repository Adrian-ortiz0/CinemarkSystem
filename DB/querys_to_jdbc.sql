insert into clientes (Nombre, Apellido, Cedula) values ("adrian", "ortiz", "1005327319");

select * from combos;
select * from detalleCompras;
select * from clientes;
select * from comprasCombosProductos;

insert into boletos (ID_Cliente, ID_Asiento, ID_Funcion) values (?, ?, ?);

select * from facturas;
select * from comprasCombosProductos;

SELECT ID
FROM boletos
WHERE ID_Cliente = 1 AND Vencido = FALSE;

SELECT 
    a.ID AS ID_Asiento, 
    a.ID_Sala, 
    a.ID_TipoAsiento, 
    a.Fila, 
    a.Numero, 
    a.Ocupado, 
    ta.ID AS ID_TipoAsiento, 
    ta.Nombre AS NombreTipoAsiento, 
    ta.Precio 
FROM 
    asientos a 
INNER JOIN 
    tipoAsientos ta 
ON 
    a.ID_TipoAsiento = ta.ID 
WHERE 
    a.ID_Sala = 1;

select * from inventario;
select * from boletos;
select * from clientes where Cedula = 63338860;
select * from Clientes;
select * from Asientos;
SELECT * FROM salas WHERE ID = ?;
select * from funciones;
SELECT * FROM tipoAsientos WHERE ID = 1;

INSERT INTO funciones (FechaInicio, FechaFin, ID_Pelicula, ID_Sala)  VALUES (?, ?, ?, ?);

insert into facturaBoleto(FechaFactura, Total, ID_Cliente, ID_Boleto) values (?, ?, ?, ?);

SELECT 
    mp.ID AS ID_MateriaPrima,
    mp.Nombre AS Nombre_MateriaPrima,
    p.ID AS ID_Proveedor,
    p.NombreEmpresa AS Nombre_Proveedor
FROM 
    materiaPrima mp
JOIN 
    proveedoresMateriaPrima pm ON mp.ID = pm.ID_MateriaPrima
JOIN 
    proveedores p ON pm.ID_Proveedor = p.ID
WHERE 
    mp.ID = 7 -- Reemplaza "?" con el ID del producto específico
ORDER BY 
    p.ID;
    
SELECT 
    mp.ID AS ID_MateriaPrima,
    mp.Nombre AS Nombre_MateriaPrima,
    p.ID AS ID_Proveedor,
    p.NombreEmpresa AS Nombre_Proveedor
FROM 
    materiaPrima mp
JOIN 
    proveedoresMateriaPrima pm 
    ON mp.ID = pm.ID_MateriaPrima
JOIN 
    proveedores p 
    ON pm.ID_Proveedor = p.ID
WHERE 
    mp.Nombre = 'Salchichas';
    
SELECT 
    mp.ID AS ID_MateriaPrima,
    mp.Nombre AS Nombre_MateriaPrima,
    p.ID AS ID_Proveedor,
    p.NombreEmpresa AS Nombre_Proveedor
FROM 
    materiaPrima mp
JOIN 
    proveedoresMateriaPrima pm 
    ON mp.ID = pm.ID_MateriaPrima
JOIN 
    proveedores p 
    ON pm.ID_Proveedor = p.ID;
    
insert into ordenesCompra (ID_Proveedor, FechaOrden, Total) values
(?, NOW(), ?);

SELECT mp.Nombre AS Producto, i.Cantidad, i.CantidadMinima, p.NombreEmpresa AS Proveedor, pm.PrecioPorUnidad
FROM inventario i
INNER JOIN materiaPrima mp ON i.ID_MateriaPrima = mp.ID
INNER JOIN proveedoresMateriaPrima pm ON mp.ID = pm.ID_MateriaPrima
INNER JOIN proveedores p ON pm.ID_Proveedor = p.ID
WHERE i.Cantidad < i.CantidadMinima;

SELECT 
    mp.Nombre AS Producto,
    i.Cantidad AS Cantidad,
    mm.Nombre AS Unidad
FROM 
    inventario i
INNER JOIN 
    materiaPrima mp ON i.ID_MateriaPrima = mp.ID
INNER JOIN 
    medidasMateriaPrima mm ON mp.ID_MedidasMateriaPrima = mm.ID;



delete from empleados where cedula = "777";
select * from empleados where cedula = "777";

select * from administrador where Correo = "dxniel7328@gmail.com" and Contraseña = "7328";
select * from empleados;

UPDATE empleados
SET ID_Rol = ?
WHERE Cedula = ?;

select * from detalleOrden;
select * from detalleFacturas;

SELECT p.ID AS ID_Proveedor, p.NombreEmpresa 
            FROM proveedores p
            JOIN proveedoresMateriaPrima pm ON p.ID = pm.ID_Proveedor
            WHERE pm.ID_MateriaPrima = 2;

insert into peliculas (Nombre, FechaLanzamiento, Director, Genero, Duracion, Disponible, Estreno) values (?,?,?,?,?,?,?);
select * from peliculas;
update peliculas set Disponible = false where ID = ?;

select * from peliculas where Disponible = false;

SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, f.FechaInicio
FROM funciones f
JOIN peliculas p ON f.ID_Pelicula = p.ID
JOIN salas s ON f.ID_Sala = s.ID;

SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, f.FechaInicio FROM funciones f JOIN peliculas p ON f.ID_Pelicula = p.ID JOIN salas s ON f.ID_Sala = s.ID WHERE f.ID = 1;

SELECT f.ID, p.Nombre AS NombrePelicula, s.Nombre AS NombreSala, f.FechaInicio FROM funciones f JOIN peliculas p ON f.ID_Pelicula = p.ID JOIN salas s ON f.ID_Sala = s.ID WHERE f.Completa = FALSE;