SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `LNCoders_fitness` ;
CREATE SCHEMA IF NOT EXISTS `LNCoders_fitness` DEFAULT CHARACTER SET utf8 ;
USE `LNCoders_fitness` ;

-- -----------------------------------------------------
-- Table `LNCoders_fitness`.`classes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LNCoders_fitness`.`classes` ;

CREATE  TABLE IF NOT EXISTS `LNCoders_fitness`.`classes` (
  `ClassId` INT(3) NOT NULL ,
  `ClassName` VARCHAR(15) NOT NULL ,
  `type` VARCHAR(15) NOT NULL ,
  `startTime` TIME NOT NULL ,
  `endTime` TIME NOT NULL ,
  `date` DATE NOT NULL ,
  `cost` DECIMAL(10,0) NOT NULL ,
  PRIMARY KEY (`ClassId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `LNCoders_fitness`.`fitnessplans`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LNCoders_fitness`.`fitnessplans` ;

CREATE  TABLE IF NOT EXISTS `LNCoders_fitness`.`fitnessplans` (
  `fitnessPlansId` INT(3) NOT NULL ,
  `name` VARCHAR(15) NOT NULL ,
  `type` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`fitnessPlansId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `LNCoders_fitness`.`membership`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LNCoders_fitness`.`membership` ;

CREATE  TABLE IF NOT EXISTS `LNCoders_fitness`.`membership` (
  `MembershipId` INT(3) NOT NULL ,
  `MembershipName` VARCHAR(15) NOT NULL ,
  `Price` DECIMAL(3,2) NOT NULL ,
  `mType` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`MembershipId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `LNCoders_fitness`.`supplements`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LNCoders_fitness`.`supplements` ;

CREATE  TABLE IF NOT EXISTS `LNCoders_fitness`.`supplements` (
  `SuppId` INT(3) NOT NULL ,
  `SuppName` VARCHAR(15) NOT NULL ,
  `SuppType` VARCHAR(10) NOT NULL ,
  `SuppPrice` DECIMAL(3,2) NOT NULL ,
  `stock` INT(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`SuppId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `LNCoders_fitness`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LNCoders_fitness`.`member` ;

CREATE  TABLE IF NOT EXISTS `LNCoders_fitness`.`member` (
  `memberId` INT(3) NOT NULL ,
  `Fname` VARCHAR(15) NOT NULL ,
  `Sname` VARCHAR(15) NOT NULL ,
  `gender` CHAR(1) NOT NULL ,
  `dateOfBirth` DATE NOT NULL ,
  `membership` INT(3) NOT NULL ,
  `takesClass` INT(3) NOT NULL ,
  `purchased` INT(3) NULL DEFAULT NULL ,
  `fitnessPlan` INT(3) NOT NULL ,
  PRIMARY KEY (`memberId`) ,
  INDEX `membership` (`membership` ASC) ,
  INDEX `class` (`takesClass` ASC) ,
  INDEX `purchase` (`purchased` ASC) ,
  INDEX `plan` (`fitnessPlan` ASC) ,
  CONSTRAINT `membership`
    FOREIGN KEY (`membership` )
    REFERENCES `LNCoders_fitness`.`membership` (`MembershipId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `class`
    FOREIGN KEY (`takesClass` )
    REFERENCES `LNCoders_fitness`.`classes` (`ClassId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `purchase`
    FOREIGN KEY (`purchased` )
    REFERENCES `LNCoders_fitness`.`supplements` (`SuppId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `plan`
    FOREIGN KEY (`fitnessPlan` )
    REFERENCES `LNCoders_fitness`.`fitnessplans` (`fitnessPlansId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `LNCoders_fitness`.`staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LNCoders_fitness`.`staff` ;

CREATE  TABLE IF NOT EXISTS `LNCoders_fitness`.`staff` (
  `StaffId` INT(3) NOT NULL ,
  `firstName` VARCHAR(15) NOT NULL ,
  `lastName` VARCHAR(15) NOT NULL ,
  `gender` CHAR(1) NOT NULL ,
  `teaches` INT(3) NULL DEFAULT NULL ,
  `position` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`StaffId`) ,
  INDEX `teaches` (`teaches` ASC) ,
  CONSTRAINT `staff_ibfk_1`
    FOREIGN KEY (`teaches` )
    REFERENCES `LNCoders_fitness`.`classes` (`ClassId` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
