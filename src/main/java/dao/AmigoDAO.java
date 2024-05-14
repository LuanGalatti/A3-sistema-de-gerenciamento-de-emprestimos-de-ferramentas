
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigo;

public class AmigoDAO {

    public ArrayList<Amigo> listaCliente = new ArrayList<>();

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
public int MaiorIDAmigo(){
int MaiorID=0;
try{
Statement smt=this.getConexaoAmigo().createStatement();
ResultSet res= smt.executeQuery("select MAX(idAmigo)idAmigo from tb_Amigo");
res.next();
MaiorID=res.getInt("idAmigo");
smt.close();
}
catch(SQLException erro){
    System.out.println("Erro:"+erro);
}
return MaiorID;
}
}
