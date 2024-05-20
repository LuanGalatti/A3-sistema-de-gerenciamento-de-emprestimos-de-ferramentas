package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;
public class FerramentaDAO {
     public static ArrayList<Ferramenta> listaFerramenta = new ArrayList<>();

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
            System.out.println("O driver nao foi encontrado. " + erro.getMessage());
            return null;
        } catch (SQLException erro) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }   
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
                Ferramenta objeto = new Ferramenta(idFerramenta, nomeFerramenta,custoFerramenta,marcaFerramenta);
                
                listaFerramenta.add(objeto);
            }
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return listaFerramenta;
    }

    public static void setListaAmigo(ArrayList<Ferramenta> listaFerramenta) {
        FerramentaDAO.listaFerramenta = listaFerramenta;
    }
  public int maiorIDFerramenta() {
        int MaiorID = 0;
        try {
            Statement smt = this.getConexaoFerramenta().createStatement();
            ResultSet res = smt.executeQuery("select MAX(idFerramenta)idFerramenta from tb_Ferramenta");
            res.next();
            MaiorID = res.getInt("idFerramenta");
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return MaiorID;
    }
public boolean insertFerramentaDB(Ferramenta ferramenta) {
        String res = ("insert into tb_Ferramenta(idFerramenta,nomeFerramenta,marcaFerramenta,custoFerramenta,disponivel)values(?,?,?,?,?)");
        try {
            PreparedStatement smt = this.getConexaoFerramenta().prepareCall(res);
            smt.setInt(1, ferramenta.getIdFerramenta());
            smt.setString(2, ferramenta.getNome());
            smt.setString(3, ferramenta.getMarca());
             smt.setString(4, ferramenta.getCusto()+"");
            smt.setBoolean(5, true);
             smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }
 public Ferramenta retrieveFerramentaDB(int IdFerramenta) {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setIdFerramenta(IdFerramenta);
        try {

            Statement smt = this.getConexaoFerramenta().createStatement();
            ResultSet res = smt.executeQuery("select * from tb_Ferramenta where idFerramenta = " + IdFerramenta);
            res.next();
            ferramenta.setNome(res.getString("nomeAmigo"));
            ferramenta.setMarca(res.getString("telefoneAmigo"));
            ferramenta.setCusto(res.getDouble("custoFerramenta"));
            ferramenta.setDisponivel(res.getBoolean("disponivel"));
            smt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return ferramenta;
    }
public boolean updateFerramentaDB(Ferramenta ferramenta) {
        String res = "update tb_Ferramenta set idFerramenta=?,nomeFerramenta=?, marcaFerramenta=?, custoFerramenta=?, disponivel=?";
        try {
            PreparedStatement smt = this.getConexaoFerramenta().prepareStatement(res);
            smt.setInt(1, ferramenta.getIdFerramenta());
            smt.setString(2, ferramenta.getNome());
            smt.setString(3, ferramenta.getMarca());
            smt.setDouble(4, ferramenta.getCusto());
            smt.setBoolean(5, ferramenta.getDisponivel());
            smt.execute();
            smt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }
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
