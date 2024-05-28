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
            ResultSet res = smt.executeQuery("select * from tb_emprestimo");

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

    public static void setListaEmprestimo(ArrayList<Emprestimo> listaEmprestimo) {
        EmprestimoDAO.listaEmprestimo = listaEmprestimo;

    }

    public int maiorIDEmprestimo() {
        int MaiorID = 0;
        try {
            Statement smt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = smt.executeQuery("select MAX(idEmprestimo)idEmprestimo from tb_emprestimo");
            res.next();
            MaiorID = res.getInt("idEmprestimo");
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return MaiorID;
    }

    public boolean insertEmprestimoDB(Emprestimo emprestimo) {
        String res = "insert into tb_emprestimo(idEmprestimo,idAmigo,idFerramenta,dataInicio,dataDevolucao)values(?,?,?,?,?)";
        try {
            PreparedStatement smt = this.getConexaoEmprestimo().prepareCall(res);
            smt.setInt(1, emprestimo.getidEmprestimo());
            smt.setInt(2, emprestimo.getidAmigo());
            smt.setInt(3, emprestimo.getidFerramenta());
            smt.setString(4, emprestimo.getDataEmprestimo());
            smt.setString(5, emprestimo.getDataDevolucao());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public Emprestimo retrieveEmprestimoDB(int IdEmprestimo) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setidEmprestimo(IdEmprestimo);
        try {
            Statement smt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_emprestimo where idEmprestimo = " + IdEmprestimo);
            res.next();
            emprestimo.setidEmprestimo(res.getInt("idEmprestimo"));
            emprestimo.setDataDevolucao(res.getString("dataDevolucao"));
            emprestimo.setDataEmprestimo(res.getString("dataInicio"));
            emprestimo.setidAmigo(res.getInt("idAmigo"));
            emprestimo.setidFerramenta(res.getInt("idFerramenta"));
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return emprestimo;
    }

    public boolean updateEmprestimoDB(Emprestimo emprestimo) {
        String res = "update tb_emprestimo set idEmprestimo=?,idAmigo=?, idFerramenta=?, dataInicio=?, dataDevolucao=? where idEmprestimo=?";
        try {
            PreparedStatement smt = this.getConexaoEmprestimo().prepareStatement(res);
            smt.setInt(1, emprestimo.getidEmprestimo());
            smt.setInt(2, emprestimo.getidAmigo());
            smt.setInt(3, emprestimo.getidFerramenta());
            smt.setString(4, emprestimo.getDataEmprestimo());
            smt.setString(5, emprestimo.getDataDevolucao());
            smt.setInt(6, emprestimo.getidEmprestimo());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean deleteEmprestimoDB(int IdEmprestimo) {
        try {
            Statement smt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = smt.executeQuery("delete from tb_emprestimo where id=" + IdEmprestimo);
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    // Outros métodos de manipulação de empréstimos
}
