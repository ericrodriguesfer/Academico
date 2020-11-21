-- MySQL Script generated by MySQL Workbench
-- Qua 18 Abr 2018 15:56:31 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gerenciaCearaCientifico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gerenciaCearaCientifico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gerenciaCearaCientifico` DEFAULT CHARACTER SET utf8 ;
USE `gerenciaCearaCientifico` ;

-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_login` (
  `id_tbl_login` INT(8) NOT NULL,
  `login_tbl_login` VARCHAR(45) NOT NULL,
  `senha_tbl_login` VARCHAR(45) NOT NULL,
  `area_tbl_login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tbl_login`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_turmas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_turmas` (
  `id_tbl_turma` INT(3) NOT NULL,
  `nome_tbl_turma` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tbl_turma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_aluno` (
  `id_tbl_aluno` INT(3) NOT NULL,
  `nome_tbl_aluno` VARCHAR(45) NOT NULL,
  `num_tbl_aluno` VARCHAR(45) NOT NULL,
  `ano_tbl_aluno` VARCHAR(45) NOT NULL,
  `tbl_turmas_id_tbl_turma` INT NOT NULL,
  PRIMARY KEY (`id_tbl_aluno`),
  INDEX `fk_tbl_aluno_tbl_turmas_idx` (`tbl_turmas_id_tbl_turma` ASC),
  CONSTRAINT `fk_tbl_aluno_tbl_turmas`
    FOREIGN KEY (`tbl_turmas_id_tbl_turma`)
    REFERENCES `gerenciaCearaCientifico`.`tbl_turmas` (`id_tbl_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_orientador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_orientador` (
  `id_tbl_orientador` INT(3) NOT NULL,
  `nome_tbl_orientador` VARCHAR(50) NOT NULL,
  `area_tbl_orientador` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_tbl_orientador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_areas_projetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_areas_projetos` (
  `id_tbl_areas_projetos` INT(3) NOT NULL,
  `nome_tbl_areas_projetos` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_tbl_areas_projetos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_nota_projetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_nota_projetos` (
  `id_tbl_nota_projetos` INT NOT NULL,
  `contx_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL,
  `obj_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL DEFAULT '',
  `obj_espe_1_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL,
  `obj_espe_2_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL DEFAULT '',
  `obj_espe_3_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL DEFAULT '',
  `metodo_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL DEFAULT '',
  `relev_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL DEFAULT '',
  `impact_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL,
  `cond_fin_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL DEFAULT '',
  `nome_img_nota_tbl_nota_projetos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tbl_nota_projetos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`tbl_projetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`tbl_projetos` (
  `id_tbl_projetos` INT(3) NOT NULL,
  `nome_tbl_projetos` VARCHAR(45) NOT NULL,
  `contxt_tbl_projetos` VARCHAR(350) NOT NULL,
  `objt_tbl_projetos` VARCHAR(350) NOT NULL,
  `objt_espe_1_tbl_projetos` VARCHAR(120) NOT NULL,
  `objt_espe_2_tbl_projetos` VARCHAR(120) NOT NULL,
  `objt_espe_3_tbl_projetos` VARCHAR(120) NOT NULL,
  `metodo_tbl_projetos` VARCHAR(350) NOT NULL,
  `relev_tbl_projetos` VARCHAR(350) NOT NULL,
  `impact_tbl_projetos` VARCHAR(350) NOT NULL,
  `cond_fin_tbl_projetos` VARCHAR(350) NOT NULL,
  `nome_img_tbl_projetos` VARCHAR(200) NOT NULL,
  `tbl_orientador_id_tbl_orientador` INT NOT NULL,
  `tbl_aluno_id_tbl_aluno` INT NOT NULL,
  `tbl_areas_projetos_id_tbl_areas_projetos` INT(3) NOT NULL,
  `tbl_nota_projetos_id_tbl_nota_projetos` INT NOT NULL,
  PRIMARY KEY (`id_tbl_projetos`),
  INDEX `fk_tbl_projeto_natureza_tbl_orientador1_idx` (`tbl_orientador_id_tbl_orientador` ASC),
  INDEX `fk_tbl_projeto_natureza_tbl_aluno1_idx` (`tbl_aluno_id_tbl_aluno` ASC),
  INDEX `fk_tbl_projetos_tbl_areas_projetos1_idx` (`tbl_areas_projetos_id_tbl_areas_projetos` ASC),
  INDEX `fk_tbl_projetos_tbl_nota_projetos1_idx` (`tbl_nota_projetos_id_tbl_nota_projetos` ASC),
  CONSTRAINT `fk_tbl_projeto_natureza_tbl_orientador10`
    FOREIGN KEY (`tbl_orientador_id_tbl_orientador`)
    REFERENCES `gerenciaCearaCientifico`.`tbl_orientador` (`id_tbl_orientador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_projeto_natureza_tbl_aluno10`
    FOREIGN KEY (`tbl_aluno_id_tbl_aluno`)
    REFERENCES `gerenciaCearaCientifico`.`tbl_aluno` (`id_tbl_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_projetos_tbl_areas_projetos1`
    FOREIGN KEY (`tbl_areas_projetos_id_tbl_areas_projetos`)
    REFERENCES `gerenciaCearaCientifico`.`tbl_areas_projetos` (`id_tbl_areas_projetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_projetos_tbl_nota_projetos1`
    FOREIGN KEY (`tbl_nota_projetos_id_tbl_nota_projetos`)
    REFERENCES `gerenciaCearaCientifico`.`tbl_nota_projetos` (`id_tbl_nota_projetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`endereco` (
  `id_endereco` INT(8) NOT NULL AUTO_INCREMENT,
  `rua_endereco` VARCHAR(45) NOT NULL,
  `num_endereco` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_endereco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gerenciaCearaCientifico`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciaCearaCientifico`.`aluno` (
  `id_aluno` INT(8) NOT NULL AUTO_INCREMENT,
  `nome_aluno` VARCHAR(45) NOT NULL,
  `matricula_aluno` VARCHAR(45) NOT NULL,
  `endereco_id_endereco` INT(8) NOT NULL,
  PRIMARY KEY (`id_aluno`),
  INDEX `fk_aluno_endereco1_idx` (`endereco_id_endereco` ASC),
  CONSTRAINT `fk_aluno_endereco1`
    FOREIGN KEY (`endereco_id_endereco`)
    REFERENCES `gerenciaCearaCientifico`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
