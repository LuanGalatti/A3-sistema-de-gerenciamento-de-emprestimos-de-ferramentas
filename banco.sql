#cria a database db_emprestimo
create database if not exists db_emprestimo;
use db_emprestimo;
#cria a tabela "tb_Amigo" com os parametros idAmigo, nomeAmigo e telefoneAmigo
#define a primary key da tb_Ferramenta como idAmigo
CREATE TABLE IF NOT EXISTS `db_emprestimo`.`tb_Amigo` (
  `idAmigo` INT NOT NULL,
  `nomeAmigo` VARCHAR(45) NULL,
  `telefoneAmigo` VARCHAR(12) NULL,
  PRIMARY KEY (`idAmigo`));
#cria a tabela "tb_Ferramenta" com os parametros idFerramenta,nomeFerramenta, marcaFerramenta, curstoFerramenta e disponivel
#define a primary key da tb_Ferramenta como idFerramenta  
CREATE TABLE IF NOT EXISTS `db_emprestimo`.`tb_Ferramenta` (
  `idFerramenta` INT NOT NULL,
  `nomeFerramenta` VARCHAR(45) NULL,
   `marcaFerramenta` VARCHAR(45) NULL,
    `custoFerramenta` DOUBLE NULL,  
PRIMARY KEY (`idFerramenta`));
#cria a tabela "tb_emprestimo" com os parametros idEmprestimo, idFerramenta, idAmigo, dataInicio e dataDevolucao
#define a primary key da tb_emprestimo como idEmprestimo
#define idAmigo e idFerramenta como foreign key 
CREATE TABLE IF NOT EXISTS `db_emprestimo`.`tb_emprestimo` (
  `idEmprestimo` INT NOT NULL,
  `dataInicio` DATE NULL,
  `dataDevolucao` DATE NULL,
  `idFerramenta` INT NOT NULL,
  `idAmigo` INT NOT NULL,
  PRIMARY KEY (`idEmprestimo`),
  INDEX `fk_tb_emprestimo_tb_ferramenta_idx` (`idFerramenta` ASC) VISIBLE,
  INDEX `fk_tb_emprestimo_tb_amigo1_idx` (`idAmigo` ASC) VISIBLE,
  CONSTRAINT `fk_tb_emprestimo_tb_ferramenta`
    FOREIGN KEY (`idFerramenta`)
    REFERENCES `db_emprestimo`.`tb_ferramenta` (`idFerramenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_emprestimo_tb_amigo1`
    FOREIGN KEY (`idAmigo`)
    REFERENCES `db_emprestimo`.`tb_amigo` (`idAmigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
