-- MySQL Workbench Forward Engineering
SET
  @OLD_UNIQUE_CHECKS = @ @UNIQUE_CHECKS,
  UNIQUE_CHECKS = 0;

SET
  @OLD_FOREIGN_KEY_CHECKS = @ @FOREIGN_KEY_CHECKS,
  FOREIGN_KEY_CHECKS = 0;

SET
  @OLD_SQL_MODE = @ @SQL_MODE,
  SQL_MODE = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bibliospring
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bibliospring
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bibliospring` DEFAULT CHARACTER SET utf8;

USE `bibliospring`;

-- -----------------------------------------------------
-- Table `bibliospring`.`BS_USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`BS_USER`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`BS_USER` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(25) NOT NULL,
  `lastName` VARCHAR(25) NOT NULL,
  `userName` VARCHAR(25) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NULL,
  `email` VARCHAR(25) NOT NULL,
  `phoneNumber` VARCHAR(20) NULL,
  `type` ENUM('ADMIN', 'CLIENT', 'GUEST') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`Author`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`Author` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(25) NOT NULL,
  `lastName` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`Editor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`Editor`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`Editor` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `info` VARCHAR(256) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`Title`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`Title`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`Title` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `isbn` VARCHAR(20) NULL,
  `publishingDate` VARCHAR(20) NULL,
  `type` ENUM('BOOK', 'JOURNAL') NOT NULL,
  `Editor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Title_Editor1_idx` (`Editor_id` ASC) VISIBLE,
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) VISIBLE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE,
  CONSTRAINT `fk_Title_Editor1` FOREIGN KEY (`Editor_id`) REFERENCES `bibliospring`.`Editor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`Item`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`Item` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Title_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Item_Title_idx` (`Title_id` ASC) VISIBLE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE,
  CONSTRAINT `fk_Item_Title` FOREIGN KEY (`Title_id`) REFERENCES `bibliospring`.`Title` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`Reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`Reservation`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`Reservation` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `BS_USER_id` INT UNSIGNED NOT NULL,
  `Title_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reservation_BS_USER1_idx` (`BS_USER_id` ASC) VISIBLE,
  INDEX `fk_Reservation_Title1_idx` (`Title_id` ASC) VISIBLE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_BS_USER1` FOREIGN KEY (`BS_USER_id`) REFERENCES `bibliospring`.`BS_USER` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Title1` FOREIGN KEY (`Title_id`) REFERENCES `bibliospring`.`Title` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`Loan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`Loan`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`Loan` (
  `uuid` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `BS_USER_id` INT UNSIGNED NOT NULL,
  `Item_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Loan_BS_USER1_idx` (`BS_USER_id` ASC) VISIBLE,
  INDEX `fk_Loan_Item1_idx` (`Item_id` ASC) VISIBLE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC) VISIBLE,
  CONSTRAINT `fk_Loan_BS_USER1` FOREIGN KEY (`BS_USER_id`) REFERENCES `bibliospring`.`BS_USER` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Loan_Item1` FOREIGN KEY (`Item_id`) REFERENCES `bibliospring`.`Item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bibliospring`.`TitleAuthor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bibliospring`.`TitleAuthor`;

CREATE TABLE IF NOT EXISTS `bibliospring`.`TitleAuthor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Title_id` INT UNSIGNED NOT NULL,
  `Author_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_TitleAuthor_Title1_idx` (`Title_id` ASC) VISIBLE,
  INDEX `fk_TitleAuthor_Author1_idx` (`Author_id` ASC) VISIBLE,
  CONSTRAINT `fk_TitleAuthor_Title1` FOREIGN KEY (`Title_id`) REFERENCES `bibliospring`.`Title` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TitleAuthor_Author1` FOREIGN KEY (`Author_id`) REFERENCES `bibliospring`.`Author` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

SET
  SQL_MODE = @OLD_SQL_MODE;

SET
  FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;

SET
  UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`BS_USER`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`BS_USER` (
    `uuid`,
    `id`,
    `firstName`,
    `lastName`,
    `userName`,
    `password`,
    `address`,
    `email`,
    `phoneNumber`,
    `type`
  )
VALUES
  (
    '7b08c90f-b839-4055-b177-51858f542dbf',
    DEFAULT,
    'Istvan',
    'Nagy',
    'isti',
    'istike',
    'London',
    'nagy.istvan@test.com',
    '+40 999 999999',
    'ADMIN'
  );

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`Author`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`Author` (`uuid`, `id`, `firstName`, `lastName`)
VALUES
  (
    '4917757b-f362-4dfa-aee9-5c1a5c203916',
    1,
    'Nagy',
    'Istvan'
  );

INSERT INTO
  `bibliospring`.`Author` (`uuid`, `id`, `firstName`, `lastName`)
VALUES
  (
    '4015f355-eba6-46af-84c5-acc69eecce41',
    2,
    'Kis',
    'Tamas'
  );

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`Editor`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`Editor` (`uuid`, `id`, `name`, `info`)
VALUES
  (
    '8c843fe6-20d2-4227-a5d9-8bfbf0289526',
    1,
    'Publisher',
    'London'
  );

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`Title`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`Title` (
    `uuid`,
    `id`,
    `title`,
    `isbn`,
    `publishingDate`,
    `type`,
    `Editor_id`
  )
VALUES
  (
    'a21af150-a7e3-41f1-861d-6e01037f718c',
    1,
    'Need Smtg',
    'xxx',
    '2010',
    'BOOK',
    1
  );

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`Item`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`Item` (`uuid`, `id`, `Title_id`)
VALUES
  ('cfbb6813-eae6-4baf-83ec-d2d3895a5540', 1, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`Reservation`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`Reservation` (`uuid`, `id`, `BS_USER_id`, `Title_id`)
VALUES
  ('5858fbef-3554-4d35-abad-81be43c8893b', 1, 1, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`Loan`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`Loan` (`uuid`, `id`, `BS_USER_id`, `Item_id`)
VALUES
  ('ada42bc1-b309-48d7-a4f2-495c7c9f0b5c', 1, 1, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `bibliospring`.`TitleAuthor`
-- -----------------------------------------------------
START TRANSACTION;

USE `bibliospring`;

INSERT INTO
  `bibliospring`.`TitleAuthor` (`id`, `Title_id`, `Author_id`)
VALUES
  (1, 1, 1);

INSERT INTO
  `bibliospring`.`TitleAuthor` (`id`, `Title_id`, `Author_id`)
VALUES
  (2, 1, 2);

COMMIT;