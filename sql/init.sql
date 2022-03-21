CREATE SCHEMA `new_schema` ;

CREATE TABLE `new_schema`.`dog` (
  `id_dog` INT NOT NULL AUTO_INCREMENT,
  `breed` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `name` VARCHAR(45) NULL,git
  `Thoroughbred` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id_dog`),
  UNIQUE INDEX `id_dog_UNIQUE` (`id_dog` ASC) VISIBLE);

  CREATE TABLE `new_schema`.`dog_department` (
    `id_dog_department` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `case` VARCHAR(45) NULL,
    `Available` TINYINT NULL DEFAULT 1,
    PRIMARY KEY (`id_dog_department`),
    UNIQUE INDEX `id_dog_department_UNIQUE` (`id_dog_department` ASC) VISIBLE);