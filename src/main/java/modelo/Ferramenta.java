

package modelo;

public class Ferramenta {
    private final String nome;
    private final String marca;
    private final double custo;
    private boolean disponivel;

    public Ferramenta(String nome, double custo) {
        this.nome = nome;
        this.custo = custo;
        this.marca = ""; // Inicializa a marca como uma string vazia
        this.disponivel = true;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getMarca() {
        return marca;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Ferramenta " + nome + " emprestada");
        } else {
            System.out.println("Esta ferramenta está indisponível para empréstimo");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Ferramenta " + nome + " foi devolvida");
        } else {
            System.out.println("Ferramenta já está disponível no sistema");
        }
    }
}
