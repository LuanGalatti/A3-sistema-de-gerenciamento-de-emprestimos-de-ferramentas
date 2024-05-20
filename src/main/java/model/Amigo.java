package modelo;
  
import dao.AmigoDAO;

/**
 * Representa um cliente com nome e telefone.
 */
public class Amigo {
    private String nomeCliente;
    private String telefone;
    
    /**
     * Construtor padrão para a classe Cliente.
     * Inicializa o cliente com nome e telefone vazios.
     */
public Amigo(){
    this("","");
}
  /**
     * Construtor para a classe Cliente.
     * Inicializa o cliente com o nome e telefone fornecidos.
     *
     * @param nomeCliente O nome do cliente.
     * @param telefone    O telefone do cliente.
     */
public Amigo(String nomeCliente, String telefone) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
    }
/**
     * Obtém o nome do cliente.
     *
     * @return O nome do cliente.
     */
public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nomeCliente O nome do cliente a ser definido.
     */
public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    /**
     * Obtém o telefone do cliente.
     *
     * @return O telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param telefone O telefone do cliente a ser definido.
     */
public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

  
    
}



