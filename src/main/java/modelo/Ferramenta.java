package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

/**
 * Classe de ferramenta com nome, marca, custo e disponibilidade.
 */
public class Ferramenta {

    private int idFerramenta;
    private String nome;
    private String marca;
    private double custo;
    private boolean disponivel;
    FerramentaDAO dao;

    /**
     * Construtor para a classe Ferramenta. Inicializa a ferramenta com nome e
     * custo, define a marca como uma string vazia e define a disponibilidade
     * como verdadeira.
     *
     * @param nome O nome da ferramenta.
     * @param custo O custo da ferramenta.
     * @param idFerramenta O id da ferramenta.
     */
    public Ferramenta() {
        this(0, "", 0, "",true);
    }
/**
    public Ferramenta(int idFerramenta, String nome, double custo, String marca) {
        this.idFerramenta = idFerramenta;
        this.nome = nome;
        this.custo = custo;
        this.marca = marca; // Inicializa a marca como uma string vazia
        this.disponivel = true;
        this.dao = new FerramentaDAO();
    }
*/
    public Ferramenta(int idFerramenta, String nome, double custo, String marca, boolean disponivel) {
        this.idFerramenta = idFerramenta;
        this.nome = nome;
        this.custo = custo;
        this.marca = marca; // Inicializa a marca como uma string vazia
        this.disponivel = disponivel;
        this.dao = new FerramentaDAO();
    }

    /**
     * Obtém o nome da ferramenta.
     *
     * @return O nome da ferramenta.
     */
    public String getNomeFerramenta() {
        return nome;
    }

    public void setNomeFerramenta(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o custo da ferramenta.
     *
     * @return O custo da ferramenta.
     */
    public double getCustoFerramenta() {
        return custo;
    }

    public void setCustoFerramenta(double custo) {
        this.custo = custo;
    }

    /**
     * Verifica se a ferramenta está disponível.
     *
     * @return {@code true} se a ferramenta estiver disponível, {@code false}
     * caso contrário.
     */
    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Obtém a marca da ferramenta.
     *
     * @return A marca da ferramenta.
     */
    public String getMarcaFerramenta() {
        return marca;
    }

    public void setMarcaFerramenta(String marca) {
        this.marca = marca;
    }

    /**
     * Empresta a ferramenta, marcando-a como indisponível se estiver
     * disponível. Imprime uma mensagem indicando o sucesso ou falha do
     * empréstimo.
     */
    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Ferramenta " + nome + " emprestada");
        } else {
            System.out.println("Esta ferramenta está indisponível para empréstimo");
        }
    }

    /**
     * Devolve a ferramenta, marcando-a como disponível se estiver indisponível.
     * Imprime uma mensagem indicando o sucesso ou falha da devolução.
     */
    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Ferramenta " + nome + " foi devolvida");
        } else {
            System.out.println("Ferramenta já está disponível no sistema");
        }
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public ArrayList<Ferramenta> listaFerramenta() {
        return dao.getListaFerramenta();
    }

    public boolean InsertFerramentaDB(String nome, String marca, double custo) {
        int maiorID = dao.maiorIDFerramenta() + 1;
        boolean disponivel=true;
        Ferramenta ferramenta = new Ferramenta(maiorID, nome, custo, marca, disponivel);
        dao.insertFerramentaDB(ferramenta);
        return true;

    }

    public boolean deleteFerramentaDB(int id) {
        dao.deleteFerramentaDB(id);
        return true;
    }

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < FerramentaDAO.listaFerramenta.size(); i++) {
            if (FerramentaDAO.listaFerramenta.get(i).getIdFerramenta() == id) {
                indice = i;
            }

        }
        return indice;
    }

    public boolean updateFerramentaDB(int id, String nome, String marca, double custo, boolean disponivel) {
        Ferramenta ferramenta = new Ferramenta(id, nome, custo, marca, disponivel);
        dao.updateFerramentaDB(ferramenta);
        return true;
    }

    public Ferramenta retrieveFerramentaDB(int id) {
        return dao.retrieveFerramentaDB(id);
    }

    public int MaiorID() {
        return dao.maiorIDFerramenta();
    }
}
