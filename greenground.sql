

Drop database if exists GreenGround;
Create database GreenGround;
Use GreenGround;


Drop table if exists tbproducto;
CREATE TABLE tbproducto (
  IdProducto int(11) NOT NULL,
  Nombre varchar(255) NOT NULL,
  Foto blob NOT NULL,
  Descripcion varchar(255) NOT NULL,
  Precio double NOT NULL,
  Stock int(11) NOT NULL,
  PRIMARY KEY (Idproducto)
);

Drop table if exists tbcliente;
CREATE TABLE tbcliente (
  IdCliente int(11) NOT NULL,
  Identificacion varchar(10) NOT NULL,
  Nombres varchar(255) NOT NULL,
  Direccion varchar(255) NOT NULL,
  Email varchar(255) NOT NULL,
  Password varchar(20) NOT NULL,
  PRIMARY KEY (IdCliente)
) ;

Drop table if exists tbpago;
CREATE TABLE tbpago (
  IdPago int(11) NOT NULL,
  Monto double NOT NULL,
  PRIMARY KEY (IdPago)
) ;

Drop table if exists tbcompras;
CREATE TABLE tbcompras (
  IdCompras int(11) NOT NULL,
  IdCliente int(11) NOT NULL,
  IdPago int(11) NOT NULL,
  Fechatbcompras varchar(11) NOT NULL,
  Monto double NOT NULL,
  Estado varchar(50) NOT NULL,
  PRIMARY KEY (IdCompras),
  FOREIGN KEY (IdCliente) REFERENCES tbcliente(IdCliente),
  FOREIGN KEY (IdPago) REFERENCES tbpago(IdPago)
) ;

Drop table if exists tbdetalle_compras;
CREATE TABLE tbdetalle_compras (
  IdDetalle int(11) NOT NULL,
  Idproducto int(11) NOT NULL,
  IdCompras int(11) NOT NULL,
  Cantidad int(11) NOT NULL,
  PrecioCompra double NOT NULL,
  PRIMARY KEY (IdDetalle),
  FOREIGN KEY (Idproducto) REFERENCES tbproducto(Idproducto),
  FOREIGN KEY (IdCompras) REFERENCES tbcompras(IdCompras)
) ;




