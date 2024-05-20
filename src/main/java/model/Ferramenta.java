


package modelo;
/**
 * Classe de ferramenta com nome, marca, custo e disponibilidade.
 */
public class Ferramenta {
    private final String nome;
    private final String marca;
    private final double custo;
    private boolean disponivel;
/**
     * Construtor para a classe Ferramenta.
     * Inicializa a ferramenta com nome e custo, define a marca como uma string vazia e define a disponibilidade como verdadeira.
     *
     * @param nome  O nome da ferramenta.
     * @param custo O custo da ferramenta.
     */
    public Ferramenta(String nome, double custo) {
        this.nome = nome;
        this.custo = custo;
        this.marca = ""; // Inicializa a marca como uma string vazia
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
/**
     * Obtém o custo da ferramenta.
     *
     * @return O custo da ferramenta.
     */
    public double getCusto() {
        return custo;
    }
/**
     * Verifica se a ferramenta está disponível.
     *
     * @return {@code true} se a ferramenta estiver disponível, {@code false} caso contrário.
     */
    public boolean isDisponivel() {
        return disponivel;
    }
/**
     * Obtém a marca da ferramenta.
     *
     * @return A marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }
/**
     * Empresta a ferramenta, marcando-a como indisponível se estiver disponível.
     * Imprime uma mensagem indicando o sucesso ou falha do empréstimo.
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
}

