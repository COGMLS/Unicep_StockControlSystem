package produtoPackage;

import reposicaoPackage.Reposicao;
import produtoPackage.ProcuraProdutoEnum;
import produtoPackage.DispEnum;

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
    private ProcuraProdutoEnum ProcuraDoProduto;

    //Métricas de mercado:
    private int Procura;

    //Getters:
    public String getNomeProduto()
    {
        return this.NomeProduto;
    };
    public String getModeloProduto()
    {
        return this.Modelo_Produto;
    };
    public String getMarcaProduto()
    {
        return this.MarcaProduto;
    };
    public int getIDProduto()
    {
        return this.ID_Produto;
    };
    public int getQuantidade()
    {
        return this.Quantidade;
    };
    public float getPreco()
    {
        return this.Preco;
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

    //Recebe o status da procura de um produto.
    public ProcuraProdutoEnum getProcuraDeProduto()
    {

    };
    //Define a produra pelo produto.
    private void setProcuraDeProduto()
    {

    };
    //Envia o status da disponibilidade do produto
    public DispEnum VerificarDisponibilidade()
    {

    };
    //Reserva uma quantidade N do produto para o usuário
    public Reserva Reservar()
    {
        Reposicao.ReporEstoque();
    };
}