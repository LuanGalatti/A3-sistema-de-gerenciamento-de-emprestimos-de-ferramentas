create database if not exists db_emprestimo;
use db_emprestimo;
drop table if exists tb_Amigo;
CREATE TABLE IF NOT EXISTS `db_emprestimo`.`tb_Amigo` (
  `idAmigo` INT NOT NULL,
  `nomeAmigo` VARCHAR(45) NULL,
  `telefoneAmigo` VARCHAR(45) NULL,
  PRIMARY KEY (`idAmigo`))
ENGINE = InnoDB
