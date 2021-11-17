package reposicaoPackage;

import java.util.Random;

import produtoPackage.Produto;

/**Classe Reposicao
 *-----------------------------------
 *Gerencia a reposição de um determinado
 * produto ao estoque e calcula o seu 
 * novo preço com base na média ponderada.
*/

public class Reposicao
{
    //Contata o forncedor para a requisição de novos produtos.
    private static int ContatarFornecedorQuant(int QuantR)
    {
        Random QuantFornecedor = new Random();
        Random QuantMaxMod = new Random();

        int QuantMaxModInt = QuantMaxMod.nextInt(100 + 1) + 1;

        //Retorna um valor entre 0 e a quantidade máxima que pode ser 1x até 100x a quantidade recomendada forncecida.
        return QuantFornecedor.nextInt((QuantR * QuantMaxModInt) + 0) + 0;
    }

    //Fonece o valor dos produtos que serão repostos. NOTA: função apenas para testes.
    private static float ContatarFornecedorPreco(float PrecoAntigo)
    {
        return PrecoAntigo;
    }

    //Calcula o novo preço para o produto que será vendido, através da média ponderada.
    private static float CalcularNovoPreco(Produto produtoEstoque, float PrecoCompra, int QuantComprada, float MargemDeLucro)
    {
        float NovoPreco = 0.0f;

        //Calcula a margem de lucro no produto.
        PrecoCompra *= MargemDeLucro;

        //Calcula o novo preço do produto que será vendido.
        NovoPreco = (produtoEstoque.getPreco() * produtoEstoque.getQuantidade() + PrecoCompra * QuantComprada) / (produtoEstoque.getQuantidade() + QuantComprada);

        return NovoPreco;
    }

    //Contata o forncedor confirmando a aquisição dos produtos.
    private static int ComprarNovosProdutos(int Quant)
    {
        return Quant;
    }

    //Repoem ao estoque os produtos adiquiridos.
    public static void ReporEstoque(Produto produto, int EncomendarQuant)
    {
        //Contata o forncedor e verifica a quantidade máxima (0 a EncomendarQuant) disponível pelo forncedor.
        int QuantFornecida = ContatarFornecedorQuant(produto.getQuantidadeRecomendada());

        if(QuantFornecida > 0)
        {
            int QuantConfirmada = 0;

            //Caso a quantidade máxima do forncedor seja menor, comprar o máximo possível.
            if(QuantFornecida < EncomendarQuant)
            {
                QuantConfirmada = QuantFornecida;
            }
            else
            {
                QuantConfirmada = EncomendarQuant;
            }

            //Confirma a compra dos produtos para reposição do estoque.
            int QuantComprada = ComprarNovosProdutos(QuantConfirmada);

            //Contata o forncedor para receber o preço dos novos produtos.
            float PrecoNovosProdutos = ContatarFornecedorPreco(produto.getPreco());

            //Calcula o preço final para a venda dos produtos. Margem de lucro definida para 20%.
            float NovoPreco = CalcularNovoPreco(produto, PrecoNovosProdutos, QuantComprada, 0.2f);

            //Define o novo preço unitário do produto e sua quantidade no esetoque.
            produto.setPreco(NovoPreco);
            produto.setQuantidade(QuantComprada);
        }
    }
}
