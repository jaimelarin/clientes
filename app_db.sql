-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema app_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `app_db` DEFAULT CHARACTER SET utf32 ;
USE `app_db` ;

-- -----------------------------------------------------
-- Table `app_db`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_db`.`region` (
  `id_region` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_region` VARCHAR(10) NOT NULL,
  `region` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_region`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `app_db`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_db`.`pais` (
  `id_pais` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_pais` VARCHAR(10) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `id_region` INT(11) NOT NULL,
  PRIMARY KEY (`id_pais`),
  INDEX `pais_region_fk_idx` (`id_region` ASC),
  CONSTRAINT `pais_region_fk`
    FOREIGN KEY (`id_region`)
    REFERENCES `app_db`.`region` (`id_region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `app_db`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_db`.`estado` (
  `id_estado` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_estado` VARCHAR(10) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `id_pais` INT(11) NOT NULL,
  PRIMARY KEY (`id_estado`),
  INDEX `estado_pais_fk_idx` (`id_pais` ASC),
  CONSTRAINT `estado_pais_fk`
    FOREIGN KEY (`id_pais`)
    REFERENCES `app_db`.`pais` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf32;


-- -----------------------------------------------------
-- Table `app_db`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_db`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_cliente` VARCHAR(10) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `fecha_nac` DATE NOT NULL,
  `domicilio` VARCHAR(255) NOT NULL,
  `id_region` INT(11) NOT NULL,
  `id_pais` INT(11) NOT NULL,
  `id_estado` INT(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `cliente_region_fk_idx` (`id_region` ASC),
  INDEX `cliente_pais_fk_idx` (`id_pais` ASC),
  INDEX `cliente_estado_idx` (`id_estado` ASC),
  CONSTRAINT `cliente_estado_fk`
    FOREIGN KEY (`id_estado`)
    REFERENCES `app_db`.`estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cliente_pais_fk`
    FOREIGN KEY (`id_pais`)
    REFERENCES `app_db`.`pais` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cliente_region_fk`
    FOREIGN KEY (`id_region`)
    REFERENCES `app_db`.`region` (`id_region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf32;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
