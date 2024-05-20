package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    private int idAmigo;
    private String nomeAmigo;
    private String telefone;
    AmigoDAO dao;

    public Amigo() {
        this(0, "", "");
    }

    public Amigo(int idAmigo, String nomeCliente, String telefone) {
        this.idAmigo = idAmigo;
        this.nomeAmigo = nomeCliente;
        dao = new AmigoDAO();

        this.telefone = telefone;
    }

    public String getNomeAmigo() {
        return nomeAmigo;

    }

    public void setNomeAmigo(String nomeCliente) {
        this.nomeAmigo = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public ArrayList<Amigo> listaAmigo() {
        return dao.getListaAmigo();
    }

    public boolean InsertAmigoDB(String nome, String telefone) {
        int maiorID = dao.maiorIDAmigo() + 1;
        Amigo amigo = new Amigo(maiorID, nome, telefone);
        dao.insertAmigoDB(amigo);
        return true;

    }

    public boolean deleteAmigoDB(int id) {
        dao.deleteAmigoDB(id);
        return true;
    }

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AmigoDAO.listaAmigo.size(); i++) {
            if (AmigoDAO.listaAmigo.get(i).getIdAmigo() == id) {
                indice = i;
            }

        }
        return indice;
    }

    public boolean updateAmigoDB(int id, String nome, String telefone) {
        Amigo amigo = new Amigo(id, nome, telefone);
        int indice = this.procuraIndice(id);
        dao.updateAmigoDB(amigo);
        return true;
    }

    public Amigo retrieveAmigoDB(int id) {
        return dao.retrieveAmigoDB(id);
    }

    public int MaiorID() {
        return dao.maiorIDAmigo();
    }
}
