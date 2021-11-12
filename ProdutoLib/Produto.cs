using System;

namespace ProdutoLib
{
    /**Classe Produto
     *-------------------------------
     * Classe base para o gerenciamento
     * de todos os itens do estoque.
     */

    public class Produto
    {
        // Variáveis de identificação do produto:
        private string NomeProduto;
        private int ID_Produto;
        private string Modelo_Produto;
        private string MarcaProduto;
        private int Quantidade;
        private float Preco;

        // Variáveis de controle do estoque:
        private int QuantRecomendada;   // Quantidade recomendada para se manter no estoque.
        private ProcuraProdutoEnumClass.ProcuraProdutoEnum ProcuraDoProduto;    //Classificação da procura do produto.
        private int Procura;    //Métrica de mercado

        // Construtor vazio
        public Produto()
        {
            this.Quantidade = -1;     //Define que o objeto foi inicializado na memória, mas não está pronto para uso
        }

        // Construtor para a criação do banco de dados
        public Produto(string NomeProduto, int ID_Produto, string Modelo, string Marca, int QuantidadeDisponivel, float PrecoUni, int QuantRec, ProcuraProdutoEnumClass.ProcuraProdutoEnum ProcuraEnum, int ProcuraInt)
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
        public Produto(string NomeProduto, int ID_Produto, string Modelo, string Marca, int QuantidadeComprada, float PrecoUni)
        {
            this.NomeProduto = NomeProduto;
            this.ID_Produto = ID_Produto;
            this.Modelo_Produto = Modelo;
            this.MarcaProduto = Marca;
            this.Quantidade = QuantidadeComprada;
            this.Preco = PrecoUni;
        }

        //Getters:
        public string GetNomeProduto()
        {
            return this.NomeProduto;
        }
        public string GetModeloProduto()
        {
            return this.Modelo_Produto;
        }
        public string GetMarcaProduto()
        {
            return this.MarcaProduto;
        }
        public int GetIDProduto()
        {
            return this.ID_Produto;
        }
        public int GetQuantidade()
        {
            return this.Quantidade;
        }
        public float GetPreco()
        {
            return this.Preco;
        }

        //Setters:
        private void SetNomeProduto(string NomeP)
        {
            this.NomeProduto = NomeP;
        }
        private void SetModeloProduto(string Modelo)
        {
            this.Modelo_Produto = Modelo;
        }
        private void SetMarcaProduto(string Marca)
        {
            this.MarcaProduto = Marca;
        }
        private void SetIDProduto(int ID)
        {
            this.ID_Produto = ID;
        }
        private void SetQuantidade(int Quant)
        {
            this.Quantidade = Quant;
        }
        private void SetPreco(float NovoPreco)
        {
            this.Preco = NovoPreco;
        }

        //Métodos de controle de Produtos:

        //Recebe o status da procura de um produto.
        public ProcuraProdutoEnumClass.ProcuraProdutoEnum GetProcuraDeProduto()
        {
            return this.ProcuraDoProduto;
        }

        //Define a produra pelo produto.
        private void SetProcuraDeProduto(ProcuraProdutoEnumClass.ProcuraProdutoEnum ProcuraEnum)
        {
            this.ProcuraDoProduto = ProcuraEnum;
        }

        //Envia o status da disponibilidade do produto
        public DispEnumClass.DispEnum VerificarDisponibilidade()
        {
            float PorcentEstoque = this.Quantidade / this.QuantRecomendada;

            if (PorcentEstoque == 0)     //Sem estoque.
            {
                return DispEnumClass.DispEnum.INDISPONIVEL;
            }
            else if (PorcentEstoque <= 0.1)      //Estoque muito baixo.
            {
                return DispEnumClass.DispEnum.MUITOBAIXA;
            }
            else if (PorcentEstoque <= 0.25 && PorcentEstoque > 0.1)     //Estoque baixo
            {
                return DispEnumClass.DispEnum.BAIXA;
            }
            else if (PorcentEstoque <= 0.5 && PorcentEstoque > 0.25)     //Estoque médio
            {
                return DispEnumClass.DispEnum.MEDIA;
            }
            else if (PorcentEstoque <= 0.75 && PorcentEstoque > 0.5)     //Estoque alto
            {
                return DispEnumClass.DispEnum.ALTA;
            }
            else if (PorcentEstoque <= 1 && PorcentEstoque > 0.75)       //Estoque cheio ou muito alto
            {
                return DispEnumClass.DispEnum.MUITOALTA;
            }
            else
            {
                return DispEnumClass.DispEnum.INDISPONIVEL;   // Em caso de uma falha no estoque, impedir a possibilidade de compra.
            }
        }

        //Reserva uma quantidade N do produto para o usuário
        public Produto Reservar(int ReservarN)
        {
            //Verifica se há a existência do produto desejado
            if (this.VerificarDisponibilidade() != DispEnumClass.DispEnum.INDISPONIVEL && this.Quantidade > 0)
            {
                // Verifica se a quantidade no estoque é suficiente.
                if (this.Quantidade >= ReservarN)
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
    }
}
