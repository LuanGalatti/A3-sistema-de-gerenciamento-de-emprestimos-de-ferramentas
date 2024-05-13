package model;
import dao.ClienteDAO;
public class Cliente {
    private String nomeCliente;
    private String telefone;
public Cliente(){
    this("","");
}
    public Cliente(String nomeCliente, String telefone) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

  
    
}
