SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `default_schema` ;
USE `default_schema` ;

-- -----------------------------------------------------
-- Table `default_schema`.`Classes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `default_schema`.`Classes` ;

CREATE  TABLE IF NOT EXISTS `default_schema`.`Classes` (
  `ClassId` INT(3) NULL DEFAULT NULL ,
  `ClassName` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`ClassId`) );


-- -----------------------------------------------------
-- Table `default_schema`.`Staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `default_schema`.`Staff` ;

CREATE  TABLE IF NOT EXISTS `default_schema`.`Staff` (
  `StaffId` INT(3) NULL DEFAULT NULL ,
  `firstName` VARCHAR(15) NOT NULL ,
  `lastName` VARCHAR(15) NOT NULL ,
  `gender` CHAR(1) NOT NULL ,
  `teaches` INT(3) NULL DEFAULT NULL ,
  PRIMARY KEY (`StaffId`) ,
  INDEX `fk_{164C06D6-4FDB-45C0-975C-3DBDD5F163A4}` (`teaches` ASC) );


-- -----------------------------------------------------
-- Table `default_schema`.`Membership`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `default_schema`.`Membership` ;

CREATE  TABLE IF NOT EXISTS `default_schema`.`Membership` (
  `MembershipId` INT(3) NULL DEFAULT NULL ,
  `MembershipName` VARCHAR(15) NOT NULL ,
  `Price` DECIMAL(3,2) NOT NULL ,
  PRIMARY KEY (`MembershipId`) );


-- -----------------------------------------------------
-- Table `default_schema`.`Member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `default_schema`.`Member` ;

CREATE  TABLE IF NOT EXISTS `default_schema`.`Member` (
  `MemberId` INT(3) NULL DEFAULT NULL ,
  `firstName` VARCHAR(15) NOT NULL ,
  `lastName` VARCHAR(15) NOT NULL ,
  `dateOfBirth` DATE NOT NULL ,
  `gender` CHAR(1) NOT NULL ,
  `takesClass` INT(3) NULL DEFAULT NULL ,
  `mShipType` INT(3) NOT NULL ,
  PRIMARY KEY (`MemberId`) ,
  INDEX `mShipType` (`mShipType` ASC) );


-- -----------------------------------------------------
-- Table `default_schema`.`Suppliments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `default_schema`.`Suppliments` ;

CREATE  TABLE IF NOT EXISTS `default_schema`.`Suppliments` (
  `SuppId` INT(3) NULL DEFAULT NULL ,
  `SuppName` VARCHAR(15) NOT NULL ,
  `SuppType` VARCHAR(10) NOT NULL ,
  `SuppPrice` DECIMAL(3,2) NOT NULL ,
  PRIMARY KEY (`SuppId`) );



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
