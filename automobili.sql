/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.18-MariaDB : Database - database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`automobili` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `automobili`;



DROP TABLE IF EXISTS `Administrator`;

CREATE TABLE `Administrator` (
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(30) NOT NULL,
  `Prezime` VARCHAR(30) NOT NULL,
  `Username` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Administrator` VALUES 
(1,'Sreten','Lukovic','sreten','sreten');



DROP TABLE IF EXISTS `Marka`;

CREATE TABLE `Marka` (
  `MarkaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`MarkaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Marka` VALUES 
(1,'Audi'),
(2,'BMW'),
(3,'Mercedes-Benz');



DROP TABLE IF EXISTS `TipAutomobila`;

CREATE TABLE `TipAutomobila` (
  `TipAutomobilaID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`TipAutomobilaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `TipAutomobila` VALUES 
(1,'Limuzina'),
(2,'Karavan'),
(3,'Kupe'),
(4,'Kabriolet');


DROP TABLE IF EXISTS `Automobil`;

CREATE TABLE `Automobil` (
  `AutomobilID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Model` VARCHAR(50) NOT NULL,
  `GodinaProizvodnje` INT(7) NOT NULL,
  `Kilometraza` INT(7) NOT NULL,
  `Motor` VARCHAR(50) NOT NULL,
  `Opis` VARCHAR(200) NOT NULL,
  `Cena` DECIMAL(10,2) NOT NULL,
  `MarkaID` BIGINT(10) UNSIGNED NOT NULL,
  `TipAutomobilaID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`AutomobilID`),
  CONSTRAINT `fk_marka_id` FOREIGN KEY (`MarkaID`) REFERENCES `Marka` (`MarkaID`),
  CONSTRAINT `fk_tip_id` FOREIGN KEY (`TipAutomobilaID`) REFERENCES `TipAutomobila` (`TipAutomobilaID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `Automobil` VALUES 
(1,'A6', 2010, 250000, '2.0TDI', 'Brutalan za svoje godiste.', 11000, 1, 1),
(2,'M5', 2013, 210000, 'S50', 'Brutalan za svoje godiste.', 40000, 2, 1),
(3,'A6', 2014, 220000, '3.0TDI', 'Brutalan za svoje godiste.', 15000, 1, 2),
(4,'RS6', 2020, 50000, 'V10', 'Brutalannn.', 100000, 1, 2),
(5,'AMG C63', 2016, 110000, 'V6', 'Brutalannn.', 60000, 3, 3),
(6,'Audi Coupe Quattro', 1991, 50000, '2.2L Turbocharged I5', 'Brutalan trkacki.', 11000, 1, 3),
(7,'A5', 2015, 91000, '3.0TDI', 'Izuzetan.', 32000, 1, 4),
(8,'BMW E46 Cabriolet M-Sport', 2002, 140000, '330ci M-sport', 'Mnogo dobar.', 19000, 2, 4);


DROP TABLE IF EXISTS `DodatnaOprema`;

CREATE TABLE `DodatnaOprema` (
  `AutomobilID` BIGINT(10) UNSIGNED NOT NULL,
  `Rb` INT(7) NOT NULL,
  `Naziv` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`AutomobilID`,`Rb`),
  CONSTRAINT `fk_auto_id` FOREIGN KEY (`AutomobilID`) REFERENCES `Automobil` (`AutomobilID`) ON DELETE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;



INSERT  INTO `DodatnaOprema` VALUES 
(1,1,'Parking senzori'),
(1,2,'Grejaci sedista'),
(2,1,'Parking senzori'),
(2,2,'Grejaci sedista'),
(3,1,'Parking senzori'),
(3,2,'Grejaci sedista'),
(4,1,'Parking senzori'),
(4,2,'Grejaci sedista'),
(5,1,'Parking senzori'),
(5,2,'Grejaci sedista'),
(6,1,'Parking senzori'),
(6,2,'Grejaci sedista'),
(7,1,'Parking senzori'),
(7,2,'Grejaci sedista'),
(8,1,'Parking senzori'),
(8,2,'Grejaci sedista');




DROP TABLE IF EXISTS `Racun`;

CREATE TABLE `Racun` (
  `RacunID` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `DatumVreme` DATETIME NOT NULL,
  `CenaBezPDV` DECIMAL(10,2) NOT NULL,
  `PDV` DECIMAL(10,2) NOT NULL,
  `KonacnaCena` DECIMAL(10,2) NOT NULL,
  `AutomobilID` BIGINT(10) UNSIGNED NOT NULL,
  `AdministratorID` BIGINT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`RacunID`),
  CONSTRAINT `fk_autoRacun_id` FOREIGN KEY (`AutomobilID`) REFERENCES `Automobil` (`AutomobilID`),
  CONSTRAINT `fk_admin_id` FOREIGN KEY (`AdministratorID`) REFERENCES `Administrator` (`AdministratorID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT  INTO `Racun` VALUES 
(1,'2023-11-18 18:54:44',100000, 20, 120000, 1, 1);








/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
