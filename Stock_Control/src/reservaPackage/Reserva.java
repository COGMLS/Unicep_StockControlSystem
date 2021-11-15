package reservaPackage;

import java.util.*;

import estoquePackage.Estoque;
import produtoPackage.Produto;

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
    private boolean CompraAutorizada;
    private String TransportadoraSel;
    private boolean ProdutoEnviado;

    //Getters:
    public List<Produto> getListaCompras()
    {
        return this.Lista_Compra;
    }
    public int getIDUsuario()
    {
        return this.ID_Usuario;
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

    //Funções de controle da reserva de produtos:

    //Verifica se a compra foi realizada.
    private void VerificarCompra()
    {

    }

    //Verifica a adição dos produtos desejados à lista de compras
    public void RetirarProdutosDoEstoque(Estoque estoque, int IDProd, int ReservarQuant)
    {
        Produto temp = estoque.RetirarDoEstoque(IDProd, ReservarQuant);

        if(temp != null)
        {
            Lista_Compra.add(temp);
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
        
    }

    //Função que contata se a compra foi finalizada.
    public void FinalizarCompra(boolean ConfirmarCompra)
    {
        if(ConfirmarCompra == true)
        {
            this.CompraAutorizada = true;
        }
        else
        {
            this.CompraAutorizada = false;
        }
    }

    //Funções de envio para a transportadora.
    private void ContatarTransportadora()
    {
        if(this.CompraAutorizada == true)
        {
            //Contata a transportadora e recebe um retorno de confirmação.
            
        }
    }

    //Verifica o envio à transportadora.
    public void VerificarEnvio()
    {
        if(this.CompraAutorizada == true)
        {
            if(this.ProdutoEnviado == true)
            {
                
            }
        }
    }
}
