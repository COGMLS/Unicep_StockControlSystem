package reservaPackage;

import java.util.*;

import estoquePackage.Estoque;
import produtoPackage.Produto;
import produtoPackage.ProcuraProdEnumAux;

/**Classe Reserva
 * ---------------------
 * Classe destinada para o gerenciamento
 * da reserva de produtos do estoque para
 *  o cliente.
*/
public class Reserva
{
    private int ID_Usuario;     //ID única para o usuário.
    private ArrayList<Produto> Lista_Compra;
    private boolean CompraAutorizada = false;
    private String TransportadoraSel = "Correios"; //Dado estático para fins de teste.
    private boolean ProdutoEnviado = false;

    //Getters:
    public List<Produto> getListaCompras()
    {
        return this.Lista_Compra;
    }
    public int getIDUsuario()
    {
        return this.ID_Usuario;
    }
    public boolean getCompraAutorizada()
    {
        return this.CompraAutorizada;
    }

    //Setters:
    public void setListaCompras(int size)
    {
        this.Lista_Compra = new ArrayList<Produto>(size);
    }
    public void setIDUsuario(int ID)
    {
        this.ID_Usuario = ID;
    }
    public void setCompraAutorizada(boolean autorizada)
    {
        this.CompraAutorizada = autorizada;
    }

    //Funções de controle da reserva de produtos:

    //Verifica a adição dos produtos desejados à lista de compras
    public void RetirarProdutosDoEstoque(Estoque estoque, int IDProd, int ReservarQuant)
    {
        Produto temp = estoque.RetirarDoEstoque(IDProd, ReservarQuant);

        //Verifica se houve o retorno do estoque.
        if(temp != null)
        {
            boolean ProdutoEncontrado = false;

            //Pesquisa na lista de compras se já existe o produto.
            for (Produto produto : Lista_Compra)
            {
                //Caso o produto já esteja na lista de compras, somar as quantidades.
                if(produto.getIDProduto() == temp.getIDProduto())
                {
                    produto.setQuantidade(produto.getQuantidade() + temp.getQuantidade());
                    break;
                }
            }
            
            //Caso o produto não exista na lista de compras.
            if(!ProdutoEncontrado)
            {
                Lista_Compra.add(temp);
            }
        }
    }

    //Verifica a devolução dos produtos desejados
    public void DevolverProdutosAoEstoque(Estoque estoque, int IDProd, int DevolverQuant)
    {
        boolean ProdutoEncontrado = false;

        for (Produto produto : Lista_Compra)
        {
            if(produto.getIDProduto() == IDProd)
            {
                ProdutoEncontrado = true;

                if(DevolverQuant <= produto.getQuantidade() && DevolverQuant > 0)
                {
                    //Contata o estoque para devolver os produtos.
                    estoque.RetornarAoEstoque(IDProd, DevolverQuant);

                    //Caso toda a quantidade do produto seja retirada, removê-lo da lista.
                    if(DevolverQuant == produto.getQuantidade())
                    {
                        this.Lista_Compra.remove(produto);
                    }
                    else
                    {
                        produto.setQuantidade(produto.getQuantidade() - DevolverQuant);
                    }
                }
                else if(DevolverQuant > produto.getQuantidade())
                {
                    System.out.println("A quantidade a devolver não existe na reserva.");
                }
                else if(DevolverQuant <= 0)
                {
                    System.out.println("Entre com um valor válido entre 1 até " + produto.getQuantidade());
                }
                else
                {
                    System.out.println("Não foi possível devolver ao estoque o produto.");
                }
                break;
            }
        }

        if(!ProdutoEncontrado)
        {
            System.out.println("Não foi encontrado o produto com ID " + IDProd + " na lista de compras.");
        }
    }

    //Lista os produtos reservados
    public void ListReserva()
    {
        if(!this.Lista_Compra.isEmpty())
        {
            System.out.println("Produtos reservados:\n--------------------------------------------------");
            for (Produto produto : this.Lista_Compra)
            {
                System.out.println(TodasInfoProduto(produto));
            }
            System.out.println("--------------------------------------------------");
        }
        else
        {
            System.out.println("Não há produtos reservados.");
        }
    }

    //Extrai as informações do produto para o usuário.
    private String TodasInfoProduto(Produto produto)
    {
        String ProdutoInfo = "";

        //Pega as informações
        ProdutoInfo += Integer.toString(produto.getIDProduto()) + " | ";
        ProdutoInfo += produto.getNomeProduto() + " | ";
        ProdutoInfo += produto.getModeloProduto() + " | ";
        ProdutoInfo += produto.getMarcaProduto() + " | ";
        ProdutoInfo += "R$ " + Float.toString(produto.getPreco()) + " | ";
        ProdutoInfo += Integer.toString(produto.getQuantidade());

        return ProdutoInfo;
    }

    //Função que contata se a compra foi finalizada.
    public void FinalizarCompra(Estoque estoque, boolean ConfirmarCompra)
    {
        if(ConfirmarCompra)
        {
            if(this.CompraAutorizada == true)
            {
                ContatarTransportadora();

                if(this.ProdutoEnviado)
                {
                    estoque.ConfirmarRetiradaPermanente(this.Lista_Compra, ConfirmarCompra);
                    VerificarEnvio();
                }
            }
            else
            {
                System.out.println("A compra não foi autorizada!");
            }
        }
        else    //Devolve os produtos ao estoque.
        {
            estoque.ConfirmarRetiradaPermanente(this.Lista_Compra, ConfirmarCompra);
        }
    }

    //Funções de envio para a transportadora.
    private void ContatarTransportadora()
    {
        if(this.CompraAutorizada == true)
        {
            this.ProdutoEnviado = true;
        }
    }

    //Verifica o envio à transportadora.
    public void VerificarEnvio()
    {
        if(this.CompraAutorizada == true)
        {
            //Para fins de teste. Simula a espera para o envio dos produtos à transportadora.

            Random espera = new Random();

            int limit = espera.nextInt(5 + 0) + 0;
            int EnviarQuando = espera.nextInt(5 + 0) + 0;

            for(int i = 0; i < limit; i++)
            {
                if(i == EnviarQuando)
                {
                    ContatarTransportadora();
                }

                if(this.ProdutoEnviado == true)
                {
                    System.out.println("Os produtos foram entregues à transportadora: " + this.TransportadoraSel);
                    break;
                }
                else
                {
                    System.out.println("Aguardando o envio à transportadora...");
                }
            }
        }
    }
}
