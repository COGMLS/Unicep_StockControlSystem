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
    // Variáveis de identificação do produto:
    private String NomeProduto;
    private int ID_Produto;
    private String Modelo_Produto;
    private String MarcaProduto;
    private int Quantidade;
    private float Preco;

    // Variáveis de controle do estoque:
    private int QuantRecomendada;   // Quantidade recomendada para se manter no estoque.
    private ProcuraProdutoEnum ProcuraDoProduto;    //Classificação da procura do produto.
    private int Procura;    //Métrica de mercado

    // Construtor vazio
    public Produto()
    {
        this.Quantidade = -1;     //Define que o objeto foi inicializado na memória, mas não está pronto para uso
    }

    // Construtor para a criação do banco de dados
    public Produto(String NomeProduto, int ID_Produto, String Modelo, String Marca, int QuantidadeDisponivel, float PrecoUni, int QuantRec, ProcuraProdutoEnum ProcuraEnum, int ProcuraInt)
    {
        this.NomeProduto = NomeProduto;
        this.ID_Produto = ID_Produto;
        this.Modelo_Produto = Modelo;
        this.MarcaProduto = Marca;
        this.Quantidade = QuantidadeDisponivel;
        this.Preco = PrecoUni;
        this.QuantRecomendada = QuantRec;
        this.ProcuraDoProduto = ProcuraEnum;
        this.Procura = ProcuraInt;
    }

    // Contrutor para a Reserva
    public Produto(String NomeProduto, int ID_Produto, String Modelo, String Marca, int QuantidadeComprada, float PrecoUni)
    {
        this.NomeProduto = NomeProduto;
        this.ID_Produto = ID_Produto;
        this.Modelo_Produto = Modelo;
        this.MarcaProduto = Marca;
        this.Quantidade = QuantidadeComprada;
        this.Preco = PrecoUni;
    }

    //Getters:
    public String getNomeProduto()
    {
        return this.NomeProduto;
    }
    
    public String getModeloProduto()
    {
        return this.Modelo_Produto;
    }

    public String getMarcaProduto()
    {
        return this.MarcaProduto;
    }

    public int getIDProduto()
    {
        return this.ID_Produto;
    }

    public int getQuantidade()
    {
        return this.Quantidade;
    }

    public float getPreco()
    {
        return this.Preco;
    }

    //Setters:
    protected void setNomeProduto(String NomeP)
    {
        this.NomeProduto = NomeP;
    }

    protected void setModeloProduto(String Modelo)
    {
        this.Modelo_Produto = Modelo;
    }

    protected void setMarcaProduto(String Marca)
    {
        this.MarcaProduto = Marca;
    }

    protected void setIDProduto(int ID)
    {
        this.ID_Produto = ID;
    }

    protected void setQuantidade(int Quant)
    {
        this.Quantidade = Quant;
    }

    protected void setPreco(float NovoPreco)
    {
        this.Preco = NovoPreco;
    }

    //Métodos de controle de Produtos:

    //Recebe o status da procura de um produto.
    public ProcuraProdutoEnum getProcuraDeProduto()
    {
        return this.ProcuraDoProduto;
    }

    //Define a produra pelo produto.
    private void setProcuraDeProduto(ProcuraProdutoEnum ProcuraEnum)
    {
        this.ProcuraDoProduto = ProcuraEnum;
    }

    //Envia o status da disponibilidade do produto
    public DispEnum VerificarDisponibilidade()
    {
        float PorcentEstoque = this.Quantidade / this.QuantRecomendada;

        if(PorcentEstoque == 0)     //Sem estoque.
        {
            return DispEnum.INDISPONIVEL;
        }
        else if(PorcentEstoque <= 0.1)      //Estoque muito baixo.
        {
            return DispEnum.MUITOBAIXA;
        }
        else if(PorcentEstoque <= 0.25 && PorcentEstoque > 0.1)     //Estoque baixo
        {
            return DispEnum.BAIXA;
        }
        else if(PorcentEstoque <= 0.5 && PorcentEstoque > 0.25)     //Estoque médio
        {
            return DispEnum.MEDIA;
        }
        else if(PorcentEstoque <= 0.75 && PorcentEstoque > 0.5)     //Estoque alto
        {
            return DispEnum.ALTA;
        }
        else if(PorcentEstoque <= 1 && PorcentEstoque > 0.75)       //Estoque cheio ou muito alto
        {
            return DispEnum.MUITOALTA;
        }
        else
        {
            return DispEnum.INDISPONIVEL;   // Em caso de uma falha no estoque, impedir a possibilidade de compra.
        }
    }

    //Reserva uma quantidade N do produto para o usuário
    public Produto Reservar(int ReservarN)
    {
        //Verifica se há a existência do produto desejado
        if(this.VerificarDisponibilidade() != DispEnum.INDISPONIVEL && this.Quantidade > 0)
        {
            // Verifica se a quantidade no estoque é suficiente.
            if(this.Quantidade >= ReservarN)
            {
                Produto Obj = new Produto(this.NomeProduto, this.ID_Produto, this.Modelo_Produto, this.MarcaProduto, ReservarN, this.Preco);
                return Obj;
            }
            else    // Em caso da quantidade reservada ser maior que a disponível, reservar o que estiver disponível.
            {
                Produto Obj = new Produto(this.NomeProduto, this.ID_Produto, this.Modelo_Produto, this.MarcaProduto, this.Quantidade, this.Preco);

                Reposicao.ReporEstoque();   //Temporário. Envia pedido de reposição de estoque.

                return Obj; 
            }
        }
        else
        {
            return null;
        }
    }

    //Recebe a devolução do produto ao estoque
    public void ReceberProduto(int DevolverNumProdutos)
    {
        this.Quantidade += DevolverNumProdutos;
    }
}