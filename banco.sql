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
  `disponivel` TINYINT NOT NULL,  
PRIMARY KEY (`idFerramenta`));

