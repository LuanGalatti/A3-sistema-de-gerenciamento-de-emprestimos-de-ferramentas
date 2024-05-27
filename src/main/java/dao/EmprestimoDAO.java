package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Emprestimo;

public class EmprestimoDAO {

    // Lista para armazenar os dados dos empréstimos
    public static ArrayList<Emprestimo> listaEmprestimo = new ArrayList<>();

    /**
     * Estabelece uma conexão com o banco de dados de empréstimos.
     *
     * @return Conexão com o banco de dados ou null se a conexão falhar.
     */
    public Connection getConexaoEmprestimo() {
        Connection connection = null;
        try {
            // Carrega o driver do banco de dados
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Informações de conexão com o banco de dados
            String server = "localhost";
            String database = "db_emprestimo";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            // Estabelece a conexão com o banco de dados
            connection = DriverManager.getConnection(url, user, password);

            // Verifica se a conexão foi bem-sucedida e exibe uma mensagem
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;

        } catch (ClassNotFoundException erro) {
            // Trata o erro caso o driver não seja encontrado
            System.out.println("O driver não foi encontrado. " + erro.getMessage());
            return null;
        } catch (SQLException erro) {
            // Trata o erro caso a conexão com o banco de dados falhe
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }

    // Métodos para manipulação de empréstimos

    /**
     * Obtém a lista de empréstimos do banco de dados.
     *
     * @return Lista de empréstimos
     */
    public ArrayList<Emprestimo> getListaEmprestimo() {
        // Limpa a lista para evitar duplicatas
        listaEmprestimo.clear();
        try {
            // Cria uma declaração para executar a consulta SQL
            Statement smt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_Ferramenta");

            // Itera sobre o resultado da consulta e adiciona empréstimos à lista
            while (res.next()) {
                int idEmprestimo = res.getInt("IdEmprestimo");
                int idAmigo = res.getInt("idAmigo");
                int idFerramenta = res.getInt("idFerramenta");
                String dataEmprestimo = res.getString("dataInicio");
                String dataDevolucao = res.getString("dataDevolucao");
                Emprestimo objeto = new Emprestimo(idEmprestimo, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao);

                listaEmprestimo.add(objeto);
            }
            // Fecha a declaração após a execução da consulta
            smt.close();
        } catch (SQLException erro) {
            // Trata o erro caso ocorra algum problema na execução da consulta
            System.out.println("Erro: " + erro);
        }
        // Retorna a lista de empréstimos
        return listaEmprestimo;
    }

    // Outros métodos de manipulação de empréstimos
}
