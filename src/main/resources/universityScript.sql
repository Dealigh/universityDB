-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Schools`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Schools` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NOT NULL,
  `price` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Title`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Title` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NOT NULL,
  `Schools_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Schools_id`),
  CONSTRAINT `fk_Title_Schools1`
    FOREIGN KEY (`Schools_id`)
    REFERENCES `mydb`.`Schools` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Internships`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Internships` (
  `id` INT NOT NULL,
  `nameCompany` TINYTEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Grade` (
  `id` INT NOT NULL,
  `name` TINYTEXT NOT NULL,
  `optional` TINYINT NOT NULL,
  `Student_id` INT NOT NULL,
  `Title_id` INT NOT NULL,
  `Internships_id` INT NOT NULL,
  `Schools_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Student_id`, `Schools_id`),
  CONSTRAINT `fk_Asignature_Title1`
    FOREIGN KEY (`Title_id`)
    REFERENCES `mydb`.`Title` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignature_Internships1`
    FOREIGN KEY (`Internships_id`)
    REFERENCES `mydb`.`Internships` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Assignature_Schools1`
    FOREIGN KEY (`Schools_id`)
    REFERENCES `mydb`.`Schools` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teachers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NOT NULL,
  `schoolTitle` TINYINT NOT NULL,
  `Asignature_id` INT NOT NULL,
  `Schools_id` INT NOT NULL,
  `Schools_Student_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Schools_id`, `Schools_Student_id`),
  CONSTRAINT `fk_Teachers_Asignature1`
    FOREIGN KEY (`Asignature_id`)
    REFERENCES `mydb`.`Grade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teachers_Schools1`
    FOREIGN KEY (`Schools_id`)
    REFERENCES `mydb`.`Schools` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Residence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Residence` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sport` TINYTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NOT NULL,
  `careerPercent` DECIMAL NOT NULL,
  `age` INT NOT NULL,
  `Residence_id` INT NOT NULL,
  `Schools_id` INT NOT NULL,
  `Schools_Student_id` INT NOT NULL,
  `Sports_id` INT NOT NULL,
  `Internships_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Student_Residence1`
    FOREIGN KEY (`Residence_id`)
    REFERENCES `mydb`.`Residence` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Schools1`
    FOREIGN KEY (`Schools_id`)
    REFERENCES `mydb`.`Schools` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Sports1`
    FOREIGN KEY (`Sports_id`)
    REFERENCES `mydb`.`Sports` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Internships1`
    FOREIGN KEY (`Internships_id`)
    REFERENCES `mydb`.`Internships` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Exam` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `note` INT NULL,
  `date` DATE NOT NULL,
  `Asignature_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Exam_Asignature1`
    FOREIGN KEY (`Asignature_id`)
    REFERENCES `mydb`.`Grade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Library`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Library` (
  `id` INT NOT NULL,
  `books` INT NOT NULL,
  `Schools_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Library_Schools1`
    FOREIGN KEY (`Schools_id`)
    REFERENCES `mydb`.`Schools` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Grant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `percentage` INT NULL,
  `Student_id` INT NOT NULL,
  `Student_Schools_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Grant_Student1`
    FOREIGN KEY (`Student_id` , `Student_Schools_id`)
    REFERENCES `mydb`.`Student` (`id` , `Schools_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sponsorship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sponsorship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` TINYTEXT NULL,
  `Schools_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Sponsorship_Schools1`
    FOREIGN KEY (`Schools_id`)
    REFERENCES `mydb`.`Schools` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Researchs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Researchs` (
  `idResearchs` INT NOT NULL,
  `Teachers_id` INT NOT NULL,
  `Sponsorship_id` INT NOT NULL,
  PRIMARY KEY (`idResearchs`),
  CONSTRAINT `fk_Researchs_Teachers1`
    FOREIGN KEY (`Teachers_id`)
    REFERENCES `mydb`.`Teachers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Researchs_Sponsorship1`
    FOREIGN KEY (`Sponsorship_id`)
    REFERENCES `mydb`.`Sponsorship` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Exchanges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Exchanges` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `procedency` TINYTEXT NOT NULL,
  `Student_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Exchanges_Student1`
    FOREIGN KEY (`Student_id`)
    REFERENCES `mydb`.`Student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Exam` (
  `Student_id` INT NOT NULL,
  `Exam_id` INT NOT NULL,
  `Exam_Asignature_id` INT NOT NULL,
  PRIMARY KEY (`Student_id`, `Exam_id`, `Exam_Asignature_id`),
  CONSTRAINT `fk_Student_has_Exam_Student1`
    FOREIGN KEY (`Student_id`)
    REFERENCES `mydb`.`Student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_has_Exam_Exam1`
    FOREIGN KEY (`Exam_id` , `Exam_Asignature_id`)
    REFERENCES `mydb`.`Exam` (`id` , `Asignature_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Teachers_has_Title`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teachers_has_Title` (
  `Teachers_id` INT NOT NULL,
  `Teachers_Schools_id` INT NOT NULL,
  `Teachers_Schools_Student_id` INT NOT NULL,
  `Title_id` INT NOT NULL,
  `Title_Schools_id` INT NOT NULL,
  PRIMARY KEY (`Teachers_id`, `Teachers_Schools_id`, `Teachers_Schools_Student_id`, `Title_id`, `Title_Schools_id`),
  CONSTRAINT `fk_Teachers_has_Title_Teachers1`
    FOREIGN KEY (`Teachers_id` , `Teachers_Schools_id` , `Teachers_Schools_Student_id`)
    REFERENCES `mydb`.`Teachers` (`id` , `Schools_id` , `Schools_Student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teachers_has_Title_Title1`
    FOREIGN KEY (`Title_id` , `Title_Schools_id`)
    REFERENCES `mydb`.`Title` (`id` , `Schools_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grade_has_Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Grade_has_Student` (
  `Grade_id` INT NOT NULL,
  `Grade_Student_id` INT NOT NULL,
  `Grade_Schools_id` INT NOT NULL,
  `Student_id` INT NOT NULL,
  PRIMARY KEY (`Grade_id`, `Grade_Student_id`, `Grade_Schools_id`, `Student_id`),
  CONSTRAINT `fk_Grade_has_Student_Grade1`
    FOREIGN KEY (`Grade_id` , `Grade_Student_id` , `Grade_Schools_id`)
    REFERENCES `mydb`.`Grade` (`id` , `Student_id` , `Schools_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grade_has_Student_Student1`
    FOREIGN KEY (`Student_id`)
    REFERENCES `mydb`.`Student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
