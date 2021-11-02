package reposicaoPackage;

/**Classe Reposicao
 *-----------------------------------
 *Gerencia a reposição de um determinado
 * produto ao estoque e calcula o seu 
 * novo preço com base na média ponderada.
*/

public class Reposicao
{
    private float PreçoAntigo;
    private float PrecoNovo;
    private float MargemDeLucro;
    private float PrecoDeCompra;
    private int QuantProdutosNovos;

    //Contata o forncedor para a requisição de novos produtos.
    private void ContatarFornecedor()
    {
        //Se houver o produto disponível, seguir para a compra.
        if()
        {
            //Se o forncedor tiver a quantidade necessária de produtos, os adquire na quantidade desejada.
            if()
            {
                ComprarNovosProdutos(N);
            }
            else    //Caso o forncedor não tenha a quantidade de produtos desejada, adiquirir a quntidade que houver.
            {
                ComprarNovosProdutos(n);
            }
        }
    };

    //Calcula o novo preço para o produto que será vendido, através da média ponderada.
    private float CalcularNovoPreco()
    {
        float NovoPreco = 0.0f;

        NovoPreco = (this.PreçoAntigo * this.Quantidade + this.PrecoDeCompra * this.QuantProdutosNovos)/(this.QuantProdutosNovos + this.Quantidade)

        this.PrecoNovo = NovoPreco;
    };

    //Contata o forncedor confirmando a aquisição dos produtos.
    private void ComprarNovosProdutos(int Quant)
    {

    };

    //Repoem ao estoque os produtos adiquiridos.
    private void ReporEstoque(int Quant)
    {
        ContatarFornecedor();

        this.Quantidade += this.QuantProdutosNovos;
        this.Preco = this.PrecoNovo;
    };
}
