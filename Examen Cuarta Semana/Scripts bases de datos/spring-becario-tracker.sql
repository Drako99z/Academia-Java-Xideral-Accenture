CREATE USER 'springbecario'@'localhost' IDENTIFIED BY 'springbecario';

GRANT ALL PRIVILEGES ON * . * TO 'springbecario'@'localhost';

ALTER USER 'springbecario'@'localhost' IDENTIFIED WITH mysql_native_password BY 'springbecario';

CREATE DATABASE  IF NOT EXISTS `spring_becario_tracker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring_becario_tracker`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `becario`
--

DROP TABLE IF EXISTS `becario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `becario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `monto_beca` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `becario` WRITE;
/*!40000 ALTER TABLE `becario` DISABLE KEYS */;

INSERT INTO `becario` VALUES 
	(1,'Ana', 'García', 'ana.garcia@gmail.com', '1200.00'),
	(2,'Juan', 'López', 'juan.lopez@yahoo.com', '1200.00'),
	(3,'María', 'Martínez', 'maria.martinez@hotmail.com', '7280.68'),
	(4,'Pedro', 'Hernández', 'pedro.hernandez@gmail.com', '8500.20'),
	(5,'Laura', 'González', 'laura.gonzalez@yahoo.com', '8500.20');

/*!40000 ALTER TABLE `becario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
