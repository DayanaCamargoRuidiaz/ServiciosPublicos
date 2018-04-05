-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2017 a las 19:24:34
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `serviciospublicos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activitylog`
--

CREATE TABLE `activitylog` (
  `idActivityLog` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cycles`
--

CREATE TABLE `cycles` (
  `idCycles` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cycles`
--

INSERT INTO `cycles` (`idCycles`, `name`, `startDate`, `endDate`) VALUES
(1, 'Noviembre', '2017-11-01', '2017-11-30'),
(2, 'Diciembre', '2017-12-01', '2017-12-31'),
(3, 'Test', '2018-01-01', '2018-01-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `home`
--

CREATE TABLE `home` (
  `idHome` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `landline` varchar(45) NOT NULL,
  `idPerson` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `home`
--

INSERT INTO `home` (`idHome`, `address`, `landline`, `idPerson`) VALUES
(1, 'Calle 93', '5215', 1),
(2, 'Calle 93 #23-11', '5215344', 2),
(3, 'Calle Test', '4442103', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `homexcycle_subsidies`
--

CREATE TABLE `homexcycle_subsidies` (
  `idHome` int(11) NOT NULL,
  `idSubsidy` int(11) NOT NULL,
  `assignmentDate` date NOT NULL,
  `waterValueObtained` decimal(7,2) NOT NULL,
  `energyValueObtained` decimal(7,2) NOT NULL,
  `naturalGasValueObtained` decimal(7,2) NOT NULL,
  `idCycle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `home_x_cycle`
--

CREATE TABLE `home_x_cycle` (
  `idHome` int(11) NOT NULL,
  `idCycle` int(11) NOT NULL,
  `electricity` decimal(7,2) NOT NULL,
  `water` decimal(7,2) NOT NULL,
  `naturalGas` decimal(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `home_x_cycle`
--

INSERT INTO `home_x_cycle` (`idHome`, `idCycle`, `electricity`, `water`, `naturalGas`) VALUES
(3, 3, '200.00', '300.00', '400.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `documentNumber` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`idPerson`, `name`, `lastName`, `documentNumber`, `email`) VALUES
(1, 'Ruben', 'Muñoz', '10232313', 'rubenmunoz@gmail.com'),
(2, 'Camilo', 'Higuita', '10323451', 'camiloh@gmail.com'),
(3, 'Test', 'Test Tes', '101720237', 'test@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profile`
--

CREATE TABLE `profile` (
  `idProfile` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `access` varchar(255) NOT NULL,
  `onlyOne` binary(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `profile`
--

INSERT INTO `profile` (`idProfile`, `name`, `description`, `access`, `onlyOne`) VALUES
(1, 'Administrador', 'asd', 'dsa', 0x01),
(2, 'Operador', 'fgh', 'hgf', 0x02);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `report`
--

CREATE TABLE `report` (
  `idreport` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subsidy`
--

CREATE TABLE `subsidy` (
  `idsubsidy` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `expectedWaterValue` decimal(7,2) NOT NULL,
  `expectedEnergyValue` decimal(7,2) NOT NULL,
  `expectedNaturalGasValue` decimal(7,2) NOT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `subsidy`
--

INSERT INTO `subsidy` (`idsubsidy`, `startDate`, `endDate`, `name`, `description`, `expectedWaterValue`, `expectedEnergyValue`, `expectedNaturalGasValue`, `type`) VALUES
(1, '2017-11-19', '2017-11-30', 'Test', 'Valor test', '300.00', '150.00', '200.00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subsidytypes`
--

CREATE TABLE `subsidytypes` (
  `idsubsidyTypes` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `valueAtDiscretion` decimal(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `subsidytypes`
--

INSERT INTO `subsidytypes` (`idsubsidyTypes`, `nombre`, `descripcion`, `valueAtDiscretion`) VALUES
(1, 'Promedio', 'Valor promedio\r\n', '200.00'),
(2, 'Fijo', 'Valor fijo', '100.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `idProfile` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`idUser`, `userName`, `password`, `idProfile`) VALUES
(17, 'Esteban', '2c12471b9239ff8697b41621cc0be83e4d55c0f8', 1),
(22, 'Inaff', '2c12471b9239ff8697b41621cc0be83e4d55c0f8', 2),
(27, 'Jose', '2c12471b9239ff8697b41621cc0be83e4d55c0f8', 2),
(28, 'Juan', '7c222fb2927d828af22f592134e8932480637c0d', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activitylog`
--
ALTER TABLE `activitylog`
  ADD PRIMARY KEY (`idActivityLog`),
  ADD KEY `fk_activityLog_user_idx` (`idUser`);

--
-- Indices de la tabla `cycles`
--
ALTER TABLE `cycles`
  ADD PRIMARY KEY (`idCycles`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`),
  ADD UNIQUE KEY `star_date_UNIQUE` (`startDate`),
  ADD UNIQUE KEY `end_date_UNIQUE` (`endDate`),
  ADD UNIQUE KEY `idCicles_UNIQUE` (`idCycles`);

--
-- Indices de la tabla `home`
--
ALTER TABLE `home`
  ADD PRIMARY KEY (`idHome`),
  ADD UNIQUE KEY `idHogar_UNIQUE` (`idHome`),
  ADD UNIQUE KEY `direccion_UNIQUE` (`address`),
  ADD UNIQUE KEY `landline_UNIQUE` (`landline`),
  ADD KEY `fk_home_person_idx` (`idPerson`);

--
-- Indices de la tabla `homexcycle_subsidies`
--
ALTER TABLE `homexcycle_subsidies`
  ADD PRIMARY KEY (`idHome`,`idSubsidy`),
  ADD KEY `fk_homeXcycle_subsidies_idx` (`idSubsidy`);

--
-- Indices de la tabla `home_x_cycle`
--
ALTER TABLE `home_x_cycle`
  ADD PRIMARY KEY (`idHome`,`idCycle`),
  ADD KEY `fk_homeCycle_cycle_idx` (`idCycle`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`),
  ADD UNIQUE KEY `idPerson_UNIQUE` (`idPerson`),
  ADD UNIQUE KEY `documentNumber_UNIQUE` (`documentNumber`),
  ADD UNIQUE KEY `e-mail_UNIQUE` (`email`);

--
-- Indices de la tabla `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`idProfile`),
  ADD UNIQUE KEY `idProfile_UNIQUE` (`idProfile`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indices de la tabla `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`idreport`),
  ADD UNIQUE KEY `idreport_UNIQUE` (`idreport`),
  ADD KEY `fk_report_user_idx` (`idUser`);

--
-- Indices de la tabla `subsidy`
--
ALTER TABLE `subsidy`
  ADD PRIMARY KEY (`idsubsidy`),
  ADD UNIQUE KEY `idsubsidy_UNIQUE` (`idsubsidy`),
  ADD KEY `fk_subsidy_type_idx` (`type`);

--
-- Indices de la tabla `subsidytypes`
--
ALTER TABLE `subsidytypes`
  ADD PRIMARY KEY (`idsubsidyTypes`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `iduser_UNIQUE` (`idUser`),
  ADD KEY `fk_user_profile_idx` (`idProfile`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `activitylog`
--
ALTER TABLE `activitylog`
  MODIFY `idActivityLog` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cycles`
--
ALTER TABLE `cycles`
  MODIFY `idCycles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `home`
--
ALTER TABLE `home`
  MODIFY `idHome` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `person`
--
ALTER TABLE `person`
  MODIFY `idPerson` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `profile`
--
ALTER TABLE `profile`
  MODIFY `idProfile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `report`
--
ALTER TABLE `report`
  MODIFY `idreport` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `subsidy`
--
ALTER TABLE `subsidy`
  MODIFY `idsubsidy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `subsidytypes`
--
ALTER TABLE `subsidytypes`
  MODIFY `idsubsidyTypes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activitylog`
--
ALTER TABLE `activitylog`
  ADD CONSTRAINT `fk_activityLog_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `home`
--
ALTER TABLE `home`
  ADD CONSTRAINT `fk_home_person` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `homexcycle_subsidies`
--
ALTER TABLE `homexcycle_subsidies`
  ADD CONSTRAINT `fk_homeXcycle_subsidies` FOREIGN KEY (`idSubsidy`) REFERENCES `subsidy` (`idsubsidy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_subsidies_homeXcycle` FOREIGN KEY (`idHome`) REFERENCES `home_x_cycle` (`idHome`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `home_x_cycle`
--
ALTER TABLE `home_x_cycle`
  ADD CONSTRAINT `fk_homeCycle_cycle` FOREIGN KEY (`idCycle`) REFERENCES `cycles` (`idCycles`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_homeCycle_home` FOREIGN KEY (`idHome`) REFERENCES `home` (`idHome`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `fk_report_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `subsidy`
--
ALTER TABLE `subsidy`
  ADD CONSTRAINT `fk_subsidy_type` FOREIGN KEY (`type`) REFERENCES `subsidytypes` (`idsubsidyTypes`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_profile` FOREIGN KEY (`idProfile`) REFERENCES `profile` (`idProfile`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
