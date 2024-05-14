package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigo;

public class AmigoDAO {

    public static ArrayList<Amigo> listaAmigo = new ArrayList<>();

    public Connection getConexaoAmigo() {

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
        AmigoDAO.listaAmigo = listaAmigo;
    }

    public int MaiorIDAmigo() {
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

    public boolean InsertAmigoDB(Amigo amigo) {
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
public Amigo RetrieveAmigoDB(int IdAmigo){
  Amigo amigo = new Amigo();
  amigo.setIdAmigo(IdAmigo);
    try{
        
    
    Statement smt=this.getConexaoAmigo().createStatement();
    ResultSet res= smt.executeQuery("select * from tb_amigo where idAmigo = "+IdAmigo);
res.next();
amigo.setNomeAmigo(res.getString("nomeAmigo"));
amigo.setTelefone(res.getString("telefoneAmigo"));
smt.close();
}catch(SQLException erro){
        System.out.println("Erro: "+erro);
}
return amigo;
}
public boolean UpdateAmigoDB(Amigo amigo){
    String res="update tb_amigo set idAmigo=?,nomeAmigo=?,telefoneAmigo=?";
    try{
        PreparedStatement smt=this.getConexaoAmigo().prepareStatement(res);
       smt.setInt(1,amigo.getIdAmigo());
        smt.setString(2, amigo.getNomeAmigo());
    smt.setString(3, amigo.getTelefone());
    smt.execute();
    smt.close();
    return true;
    }catch(SQLException erro){
        System.out.println("Erro: "+erro);
      throw new RuntimeException(erro);
    }
}public boolean DeleteAmigoDB(int IdAmigo){
   try{ Statement smt=this.getConexaoAmigo().createStatement();
    ResultSet res=smt.executeQuery("delete from tb_amigo where id="+IdAmigo);
    smt.close();
    
}catch(SQLException erro){
            System.out.println("Erro: "+erro);
}return true;
}
}