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

    public static ArrayList<Emprestimo> listaEmprestimo = new ArrayList<>();

    /**
     * Se conecta com o banco de dados de emprestimos.
     *
     * @return Conexão com o banco de dados ou null se a conexão falhar.
     */
    public Connection getConexaoEmprestimo() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_emprestimo";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;

        } catch (ClassNotFoundException erro) {
            System.out.println("O driver não foi encontrado. " + erro.getMessage());
            return null;
        } catch (SQLException erro) {
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }

    public ArrayList<Emprestimo> getListaEmprestimo() {
        listaEmprestimo.clear();
        try {
            Statement smt = this.getConexaoEmprestimo().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_Ferramenta");
            while (res.next()) {
                int idEmprestimo = res.getInt("IdEmprestimo");
                int idAmigo = res.getInt("idAmigo");
                int idFerramenta = res.getInt("idFerramenta");
                String dataEmprestimo = res.getString("dataInicio");
                String dataDevolucao = res.getString("dataDevolucao");
                Emprestimo objeto = new Emprestimo(idEmprestimo, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao);

                listaEmprestimo.add(objeto);
            }
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
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
}
