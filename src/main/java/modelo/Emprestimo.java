package modelo;
import dao.EmprestimoDAO;
import java.util.ArrayList;

public class Emprestimo{
    private int idEmprestimo;
    private int idAmigo;
    private int idFerramenta;
    private String DataEmprestimo;
    private String DataDevolucao;
    EmprestimoDAO dao;
    
    /**
     * Construtor padrão para a classe Emprestimo. Inicializa o id do emprestimo,
     * o id do amigo(para quem foi emprestado),
     * o id da ferramenta(ferramenta que foi emprestada),
     * data do emprestimo e data de devolução vazios.
     */
    public Emprestimo() {
        this(0, 0, 0, "", "");
    }

    /**
     * Construtor para a classe Emprestimo. Inicializa o emprestimo com os id's de Emprestimo,
     * Amigo e ferramenta, Data de emprestimo e de devolução fornecidos.
     *
     * @param idEmprestimo Id do emprestimo
     * @param idAmigo Para que amigo foi emprestada a ferramenta.
     * @param idFerramenta Que ferramenta foi emprestada.
     * @param DataEmprestimo Quando foi emprestado a ferramenta.
     * @param DataDevolucao Data de quando a ferramenta deve ser devolvida.
     */
    public Emprestimo(int idEmprestimo, int idAmigo, int idFerramenta, String DataEmprestimo, String DataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.idAmigo = idAmigo;
        this.idFerramenta = idFerramenta;
        this.DataEmprestimo = DataEmprestimo;
        this.DataDevolucao = DataDevolucao;
    }

    /**
     * Obtém od id do emprestimo.
     *
     * @return o id do emprestimo.
     * 
     */
    public int getidEmprestimo() {
        return idEmprestimo;
    }
    /**
     * Define o id do emprestimo.
     *
     * @param idEmprestimo O id do emprestimo a ser definido.
     */
    public void setidEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    /**
     * Obtém para que amigo foi emprestado.
     *
     * @return para quem foi emprestado.
     * 
     */
    public int getidAmigo() {
        return idAmigo;
    }

    /**
     * Define para quem foi emprestado.
     *
     * @param idAmigo O id do amigo a ser definido.
     */
    public void setidAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    /**
     * Obtém od id da ferramenta.
     *
     * @return o id da ferramenta.
     * 
     */
    public int getidFerramenta() {
        return idFerramenta;
    }
    /**
     * Define o id da ferramenta.
     *
     * @param idFerramenta O id da ferramenta a ser definido.
     */
    public void setidFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }
    /**
     * Obtém a data do emprestimo.
     *
     * @return A data do emprestimo.
     */
    public String getDataEmprestimo() {
        return DataEmprestimo;
    }

    /**
     * Define a data do emprestimo.
     *
     * @param DataEmprestimo A data do emprestimo a ser definida.
     */
    public void DataEmprestimo(String DataEmprestimo) {
        this.DataEmprestimo = DataEmprestimo;
    }
    
    /**
     * Obtém a data de devolução do emprestimo.
     *
     * @return A data de devolução do emprestimo.
     */
    public String getDataDevolucao() {
        return DataDevolucao;
    }
    
    /**
     * Define a data de devolução do emprestimo.
     *
     * @param DataDevolucao A data de devolução do emprestimo a ser definida.
     */
    public void setDataDevolucao(String DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }
    
    public ArrayList<Emprestimo> listaEmprestimo() {
        return dao.getListaEmprestimo();
    }

    public boolean InsertEmprestimoDB(int idAmigo, int idFerramenta, String DataEmprestimo, String DataDevolucao) {
        int maiorID = dao.maiorIDEmprestimo() + 1;
        Emprestimo emprestimo = new Emprestimo(maiorID, idAmigo, idFerramenta, DataEmprestimo, DataDevolucao);
        dao.insertEmprestimoDB(emprestimo);
        return true;

    }

    public boolean deleteEmprestimoDB(int id) {
        dao.deleteEmprestimoDB(id);
        return true;
    }

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < EmprestimoDAO.listaEmprestimo.size(); i++) {
            if (EmprestimoDAO.listaEmprestimo.get(i).getIdAmigo() == id) {
                indice = i;
            }
        }
        return indice;
    }

    public boolean updateEmprestimoDB(int id, int idAmigo, int idFerrmaneta, String DataEmprestimo, String DataDevolucao) {
        Emprestimo emprestimo = new Emprestimo(id, idAmigo, idFerramenta, DataEmprestimo, DataDevolucao);
        int indice = this.procuraIndice(id);
        dao.updateEmprestimoDB(emprestimo);
        return true;
    }

    public Emprestimo retrieveEmprestimoDB(int id) {
        return dao.retrieveEmprestimoDB(id);
    }

    public int MaiorID() {
        return dao.maiorIDEmprestimo();
    }
}