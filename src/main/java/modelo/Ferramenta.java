package modelo;

/**
 * Classe de ferramenta com nome, marca, custo e disponibilidade.
 */
public class Ferramenta {

    private int idFerramenta;
    private String nome;
    private String marca;
    private double custo;
    private boolean disponivel;

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
        this(0, "", 0, "");
    }

    public Ferramenta(int idFerramenta, String nome, double custo, String marca) {
        this.idFerramenta = idFerramenta;
        this.nome = nome;
        this.custo = custo;
        this.marca = marca; // Inicializa a marca como uma string vazia
        this.disponivel = true;
    }

    /**
     * Obtém o nome da ferramenta.
     *
     * @return O nome da ferramenta.
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o custo da ferramenta.
     *
     * @return O custo da ferramenta.
     */
    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
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
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
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

}
