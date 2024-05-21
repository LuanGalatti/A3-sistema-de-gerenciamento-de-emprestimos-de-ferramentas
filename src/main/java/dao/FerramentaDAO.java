package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

/**
 * Classe responsável pelo acesso aos dados das ferramentas no banco de dados.
 */
public class FerramentaDAO {

    /**
     * Lista de ferramentas em armazenamento.
     */
    public static ArrayList<Ferramenta> listaFerramenta = new ArrayList<>();

    /**
     * Obtém uma conexão com o banco de dados de ferramentas.
     *
     * @return Conexão com o banco de dados ou null se a conexão falhar.
     */
    public Connection getConexaoFerramenta() {
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

    /**
     * Obtém a lista de ferramentas do banco de dados.
     *
     * @return Lista de ferramentas.
     */
    public ArrayList<Ferramenta> getListaFerramenta() {
        listaFerramenta.clear();
        try {
            Statement smt = this.getConexaoFerramenta().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_Ferramenta");
            while (res.next()) {
                int idFerramenta = res.getInt("IdFerramenta");
                String nomeFerramenta = res.getString("nomeFerramenta");
                String marcaFerramenta = res.getString("marcaFerramenta");
                double custoFerramenta = res.getDouble("custoFerramenta");
                Ferramenta objeto = new Ferramenta(idFerramenta, nomeFerramenta, custoFerramenta, marcaFerramenta);

                listaFerramenta.add(objeto);
            }
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return listaFerramenta;
    }

    /**
     * Define a lista de ferramentas.
     *
     * @param listaFerramenta Lista de ferramentas a ser definida.
     */
    public static void setListaFerramenta(ArrayList<Ferramenta> listaFerramenta) {
        FerramentaDAO.listaFerramenta = listaFerramenta;
    }

    /**
     * Obtém o maior ID de ferramenta no banco de dados.
     *
     * @return Maior ID de ferramenta.
     */
    public int maiorIDFerramenta() {
        int MaiorID = 0;
        try {
            Statement smt = this.getConexaoFerramenta().createStatement();
            ResultSet res = smt.executeQuery("select MAX(idFerramenta)idFerramenta from tb_Ferramenta");
            res.next();
            MaiorID = res.getInt("idFerramenta");
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return MaiorID;
    }

    /**
     * Insere uma ferramenta no banco de dados.
     *
     * @param ferramenta Ferramenta a ser inserida.
     * @return {@code true} se a inserção for bem-sucedida, caso contrário,
     * lança uma exceção.
     */
    public boolean insertFerramentaDB(Ferramenta ferramenta) {
        String res = "insert into tb_Ferramenta(idFerramenta,nomeFerramenta,marcaFerramenta,custoFerramenta,disponivel)values(?,?,?,?,?)";
        try {
            PreparedStatement smt = this.getConexaoFerramenta().prepareCall(res);
            smt.setInt(1, ferramenta.getIdFerramenta());
            smt.setString(2, ferramenta.getNomeFerramenta());
            smt.setString(3, ferramenta.getMarcaFerramenta());
            smt.setDouble(4, ferramenta.getCustoFerramenta());
            smt.setBoolean(5, true);
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Recupera uma ferramenta do banco de dados com base no ID.
     *
     * @param IdFerramenta ID da ferramenta a ser recuperada.
     * @return Ferramenta recuperada.
     */
    public Ferramenta retrieveFerramentaDB(int IdFerramenta) {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setIdFerramenta(IdFerramenta);
        try {
            Statement smt = this.getConexaoFerramenta().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_Ferramenta where idFerramenta = " + IdFerramenta);
            res.next();
            ferramenta.setNomeFerramenta(res.getString("nomeFerramenta"));
            ferramenta.setMarcaFerramenta(res.getString("marcaFerramenta"));
            ferramenta.setCustoFerramenta(res.getDouble("custoFerramenta"));
            ferramenta.setDisponivel(res.getBoolean("disponivel"));
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return ferramenta;
    }

    /**
     * Atualiza as informações de uma ferramenta no banco de dados.
     *
     * @param ferramenta Ferramenta a ser atualizada.
     * @return {@code true} se a atualização for bem-sucedida, caso contrário,
     * lança uma exceção.
     */
    public boolean updateFerramentaDB(Ferramenta ferramenta) {
        String res = "update tb_Ferramenta set idFerramenta=?,nomeFerramenta=?, marcaFerramenta=?, custoFerramenta=?, disponivel=?";
        try {
            PreparedStatement smt = this.getConexaoFerramenta().prepareStatement(res);
            smt.setInt(1, ferramenta.getIdFerramenta());
            smt.setString(2, ferramenta.getNomeFerramenta());
            smt.setString(3, ferramenta.getMarcaFerramenta());
            smt.setDouble(4, ferramenta.getCustoFerramenta());
            smt.setBoolean(5, ferramenta.getDisponivel());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Remove uma ferramenta do banco de dados com base no ID.
     *
     * @param IdFerramenta ID da ferramenta a ser removida.
     * @return {@code true} se a remoção for bem-sucedida, caso contrário,
     * {@code false}.
     */
    public boolean deleteFerramentaDB(int IdFerramenta) {
        try {
            Statement smt = this.getConexaoFerramenta().createStatement();
            ResultSet res = smt.executeQuery("delete from tb_Ferramenta where id=" + IdFerramenta);
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }
}
