CREATE USER 'batchclientes'@'localhost' IDENTIFIED BY 'batchclientes';

GRANT ALL PRIVILEGES ON * . * TO 'batchclientes'@'localhost';

ALTER USER 'batchclientes'@'localhost' IDENTIFIED WITH mysql_native_password BY 'batchclientes';

CREATE DATABASE  IF NOT EXISTS `spring_batch_clientes` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring_batch_clientes`;