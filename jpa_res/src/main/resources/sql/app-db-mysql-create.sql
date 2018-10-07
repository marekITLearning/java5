-- -----------------------------------------------------
-- Drop and create DB
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `customer`;
CREATE DATABASE IF NOT EXISTS `customer` /*!40100 DEFAULT CHARACTER SET utf8 */;

-- -----------------------------------------------------
-- Drop and create user, grant privileges
-- -----------------------------------------------------
DROP USER IF EXISTS 'appadmin'@'localhost';
CREATE USER 'appadmin'@'localhost' IDENTIFIED BY 'admin123';
GRANT ALL PRIVILEGES ON `customer`.* TO 'appadmin'@'localhost' WITH GRANT OPTION;
