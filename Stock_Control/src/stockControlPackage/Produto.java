package stockControlPackage;

/**Classe Produto
 *-------------------------------
 * Classe base para o gerenciamento
 * de todos os itens do estoque.
 */

public class Produto
{
    private String NomeProduto;
    private int ID_Produto;
    private String Modelo_Produto;
    private String MarcaProduto;
    private int Quantidade;
    private float Preco;
    private Enum ProcuraDoProduto;

    //Getters:
    public String getNomeProduto()
    {
        this.NomeProduto;
    };
    public String getModeloProduto()
    {
        this.Modelo_Produto;
    };
    public String getMarcaProduto()
    {
        this.MarcaProduto;
    };
    public int getIDProduto()
    {
        this.ID_Produto;
    };
    public int getQuantidade()
    {
        this.Quantidade;
    };
    public float getPreco()
    {
        this.Preco;
    };

    //Setters:
    private void setNomeProduto(String NomeP)
    {
        this.NomeProduto = NomeP;
    };
    private void setModeloProduto(String Modelo)
    {
        this.Modelo_Produto = Modelo;
    };
    private void setMarcaProduto(String Marca)
    {
        this.MarcaProduto = Marca;
    };
    private void setIDProduto(int ID)
    {
        this.ID_Produto = ID;
    };
    private void setQuantidade(int Quant)
    {
        this.Quantidade = Quant;
    };
    private void setPreco(float NovoPreco)
    {
        this.Preco = NovoPreco;
    };

    //Métodos de controle de Produtos:

    //Define a produra pelo produto.
    public Enum getProcuraDeProduto()
    {

    };
    private void setProcuraDeProduto()
    {

    };
    public Enum VerificarDisponibilidade()
    {

    };
    public Reserva Reservar()
    {
        Reposicao.ReporEstoque();
    };
}
