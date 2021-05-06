-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2021 a las 03:39:56
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `greenground`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbcliente`
--

CREATE TABLE `tbcliente` (
  `IdCliente` int(11) NOT NULL,
  `Identificacion` varchar(10) NOT NULL,
  `Nombres` varchar(255) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `img_usuario` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbcompras`
--

CREATE TABLE `tbcompras` (
  `IdCompras` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdPago` int(11) NOT NULL,
  `Fechatbcompras` varchar(11) NOT NULL,
  `Monto` double NOT NULL,
  `Estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbdetalle_compras`
--

CREATE TABLE `tbdetalle_compras` (
  `IdDetalle` int(11) NOT NULL,
  `Idproducto` int(11) NOT NULL,
  `IdCompras` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioCompra` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbpago`
--

CREATE TABLE `tbpago` (
  `IdPago` int(11) NOT NULL,
  `Monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbproducto`
--

CREATE TABLE `tbproducto` (
  `IdProducto` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Foto` blob NOT NULL,
  `Descripcion` varchar(255) NOT NULL,
  `Precio` double NOT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `tbcompras`
--
ALTER TABLE `tbcompras`
  ADD PRIMARY KEY (`IdCompras`),
  ADD KEY `IdCliente` (`IdCliente`),
  ADD KEY `IdPago` (`IdPago`);

--
-- Indices de la tabla `tbdetalle_compras`
--
ALTER TABLE `tbdetalle_compras`
  ADD PRIMARY KEY (`IdDetalle`),
  ADD KEY `Idproducto` (`Idproducto`),
  ADD KEY `IdCompras` (`IdCompras`);

--
-- Indices de la tabla `tbpago`
--
ALTER TABLE `tbpago`
  ADD PRIMARY KEY (`IdPago`);

--
-- Indices de la tabla `tbproducto`
--
ALTER TABLE `tbproducto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbcompras`
--
ALTER TABLE `tbcompras`
  ADD CONSTRAINT `tbcompras_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `tbcliente` (`IdCliente`),
  ADD CONSTRAINT `tbcompras_ibfk_2` FOREIGN KEY (`IdPago`) REFERENCES `tbpago` (`IdPago`);

--
-- Filtros para la tabla `tbdetalle_compras`
--
ALTER TABLE `tbdetalle_compras`
  ADD CONSTRAINT `tbdetalle_compras_ibfk_1` FOREIGN KEY (`Idproducto`) REFERENCES `tbproducto` (`IdProducto`),
  ADD CONSTRAINT `tbdetalle_compras_ibfk_2` FOREIGN KEY (`IdCompras`) REFERENCES `tbcompras` (`IdCompras`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
