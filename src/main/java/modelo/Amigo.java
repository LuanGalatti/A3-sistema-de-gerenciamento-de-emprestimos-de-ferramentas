package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 * Representa um amigo com id, nome e telefone.
 */
public class Amigo {

    private int idAmigo;
    private String nomeAmigo;
    private String telefone;
    AmigoDAO dao;

    /**
     * Construtor padrão para a classe Amigo. Inicializa o cliente com id, nome
     * e telefone vazios.
     */
    public Amigo() {
        this(0, "", "");
    }

    /**
     * Construtor para a classe amigo. Inicializa o cliente com o nome e
     * telefone fornecidos.
     *
     * @param idAmigo O id do amigo
     * @param nomeCliente O nome do amigo.
     * @param telefone O telefone do cliente.
     */
    public Amigo(int IdAmigo, String nomeCliente, String telefone) {
        this.idAmigo = idAmigo;
        this.nomeAmigo = nomeCliente;
        this.telefone = telefone;
    }

    /**
     * Obtém o nome do amigo.
     *
     * @return O nome do amigo.
     */
    public String getNomeAmigo() {
        return nomeAmigo;
    }

    /**
     * Define o nome do amigo.
     *
     * @param nomeCliente O nome do amigo a ser definido.
     */
    public void setNomeAmigo(String nomeCliente) {
        this.nomeAmigo = nomeCliente;
    }

    /**
     * Obtém o telefone do amigo.
     *
     * @return O telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param telefone O telefone do amigo a ser definido.
     */
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
