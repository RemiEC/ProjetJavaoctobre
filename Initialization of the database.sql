CREATE database Project1_Web_Dynamic_App_DB;

CREATE TABLE `Project1_Web_Dynamic_App_DB`.`user_info` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
)
CREATE TABLE `Project1_Web_Dynamic_App_DB`.`todo` (
  `idtodo` int NOT NULL AUTO_INCREMENT,
  `texttodo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idtodo`)
) 