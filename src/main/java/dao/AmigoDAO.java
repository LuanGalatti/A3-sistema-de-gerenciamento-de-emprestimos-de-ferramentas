package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;
/**
 * Esta classe é responsável por lidar com a persistência de dados relacionados aos amigos em um banco de dados.
 * Ela fornece métodos para conexão com o banco de dados, inserção, recuperação, atualização e exclusão de registros de amigos.
 */
public class AmigoDAO {
 /**
     * ArrayList para armazenar objetos do tipo Amigo.
     * É estático para que possa ser compartilhado entre diferentes instâncias desta classe.
     */
    public static ArrayList<Amigo> listaAmigo = new ArrayList<>();
/**
     * Obtém a conexão com o banco de dados.
     *
     * @return Uma conexão com o banco de dados.
     */
    public Connection getConexaoAmigo() {
     /**
     * Obtém uma lista de todos os amigos no banco de dados.
     *
     * @return Uma lista de objetos Amigo.
     */
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
            System.out.println("O driver nao foi encontrado. " + erro.getMessage());
            return null;
        } catch (SQLException erro) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    public ArrayList<Amigo> getListaAmigo() {
     /**
     * Define a lista de amigos.
     *
     * @param listaAmigo A lista de amigos a ser definida.
     */

        listaAmigo.clear();
        try {
            Statement smt = this.getConexaoAmigo().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_amigo");
            while (res.next()) {
                int idAmigo = res.getInt("IdAmigo");
                String nomeAmigo = res.getString("nomeAmigo");
                String telefoneAmigo = res.getString("telefoneAmigo");
                Amigo objeto = new Amigo(idAmigo, nomeAmigo, telefoneAmigo);
                listaAmigo.add(objeto);
            }
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return listaAmigo;
    }

    public static void setListaAmigo(ArrayList<Amigo> listaAmigo) {
    /**
     * Obtém o maior ID de amigo presente no banco de dados.
     *
     * @return O maior ID de amigo.
     */
        AmigoDAO.listaAmigo = listaAmigo;
    }

    public int maiorIDAmigo() {
     /**
     * Insere um novo amigo no banco de dados.
     *
     * @param amigo O objeto Amigo a ser inserido no banco de dados.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
        int MaiorID = 0;
        try {
            Statement smt = this.getConexaoAmigo().createStatement();
            ResultSet res = smt.executeQuery("select MAX(idAmigo)idAmigo from tb_amigo");
            res.next();
            MaiorID = res.getInt("idAmigo");
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return MaiorID;
    }

    public boolean insertAmigoDB(Amigo amigo) {
   /**
     * Recupera um amigo do banco de dados com base no ID especificado.
     *
     * @param IdAmigo O ID do amigo a ser recuperado.
     * @return Um objeto Amigo recuperado do banco de dados.
     */
        String res = ("insert into tb_amigo(idAmigo,nomeAmigo,telefoneAmigo)values(?,?,?)");
        try {
            PreparedStatement smt = this.getConexaoAmigo().prepareCall(res);
            smt.setInt(1, amigo.getIdAmigo());
            smt.setString(2, amigo.getNomeAmigo());
            smt.setString(3, amigo.getTelefone());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public Amigo retrieveAmigoDB(int IdAmigo) {
     /**
     * Atualiza as informações de um amigo no banco de dados.
     *
     * @param amigo O objeto Amigo com as informações atualizadas a serem atualizadas no banco de dados.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
        Amigo amigo = new Amigo();
        amigo.setIdAmigo(IdAmigo);
        try {

            Statement smt = this.getConexaoAmigo().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_amigo where idAmigo = " + IdAmigo);
            res.next();
            amigo.setNomeAmigo(res.getString("nomeAmigo"));
            amigo.setTelefone(res.getString("telefoneAmigo"));
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return amigo;
    }

    public boolean updateAmigoDB(Amigo amigo) {
     /**
     * Exclui um amigo do banco de dados com base no ID especificado.
     *
     * @param IdAmigo O ID do amigo a ser excluído.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
        String res = "update tb_amigo set idAmigo=?,nomeAmigo=?,telefoneAmigo=?";
        try {
            PreparedStatement smt = this.getConexaoAmigo().prepareStatement(res);
            smt.setInt(1, amigo.getIdAmigo());
            smt.setString(2, amigo.getNomeAmigo());
            smt.setString(3, amigo.getTelefone());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public boolean deleteAmigoDB(int IdAmigo) {
        try {
            Statement smt = this.getConexaoAmigo().createStatement();
            ResultSet res = smt.executeQuery("delete from tb_amigo where id=" + IdAmigo);
            smt.close();

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }
}
