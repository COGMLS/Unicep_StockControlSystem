package clientePackage;

import java.util.Scanner;

import estoquePackage.Estoque;
import reservaPackage.Reserva;
import comprasPackage.FinalizarCompra;

/** Classe de controle do cliente.
 * ------------------------------------
 * Cuida das operações de interação do 
 * cliente com o sistema de reserva do
 * controle de estoque.
*/

public class Cliente
{
    private Reserva ClienteCompras;
    private int ID_Cliente;

    public Cliente(int ID_User)
    {
        ClienteCompras = new Reserva();
        this.ID_Cliente = ID_User;

        ClienteCompras.setListaCompras(20);
        ClienteCompras.setIDUsuario(ID_User);
    }

    //Exibe o ID do cliente.
    public void ExibirIDCliente()
    {
        System.out.println("ID do Cliente: " + this.ID_Cliente);
    }

    //Pesquisa por um produto e suas informações.
    public void PesquisarProduto(Estoque estoque)
    {
        System.out.print("Entre com a ID de um produto: ");
        Scanner ID_Prod = new Scanner(System.in);

        String ID_ProdStr = ID_Prod.next();

        try
        {
            int ID_ProdInt = Integer.parseInt(ID_ProdStr);

            estoque.encontrarID(ID_ProdInt);
        }
        catch (Exception e)
        {
            System.out.println("\n\n" + e.getMessage() +"\n\n");
        }
    }

    //Reserva e adiciona os produtos do estoque para a lista de compras.
    public void ReservarProdutoCliente(Estoque estoque)
    {
        System.out.print("Entre com o código do produto para reservar: ");
        Scanner ID_Prod = new Scanner(System.in);

        String ID_ProdStr = ID_Prod.next();

        try
        {
            int ID_ProdInt = Integer.parseInt(ID_ProdStr);

            System.out.print("Entre com a quantidade de produtos a ser retirada: ");
            Scanner RetirarQuant = new Scanner(System.in);

            String RetirarQuantStr = RetirarQuant.next();

            try
            {
                int RetirarQuantInt = Integer.parseInt(RetirarQuantStr);

                ClienteCompras.RetirarProdutosDoEstoque(estoque, ID_ProdInt, RetirarQuantInt);
            }
            catch (Exception e2)
            {
                System.out.println("\n\n" + e2.getMessage() +"\n\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("\n\n" + e.getMessage() +"\n\n");
        }
    }

    //Devolve os produtos na lista de compras ao estoque
    public void DevolverProdutoCliente(Estoque estoque)
    {
        System.out.print("Entre com o código do produto para devolver ao estoque: ");
        Scanner ID_Prod = new Scanner(System.in);

        String ID_ProdStr = ID_Prod.next();

        try
        {
            int ID_ProdInt = Integer.parseInt(ID_ProdStr);

            System.out.print("Entre com a quantidade de produtos a ser devolvida ao estoque: ");
            Scanner RetirarQuant = new Scanner(System.in);

            String RetirarQuantStr = RetirarQuant.next();

            try
            {
                int RetirarQuantInt = Integer.parseInt(RetirarQuantStr);

                ClienteCompras.DevolverProdutosAoEstoque(estoque, ID_ProdInt, RetirarQuantInt);
            }
            catch (Exception e2)
            {
                System.out.println("\n\n" + e2.getMessage() +"\n\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("\n\n" + e.getMessage() +"\n\n");
        }
    }

    //Exibe os produtos adicionados na lista de compras.
    public void ListarCompras()
    {
        ClienteCompras.ListReserva();
    }

    //Finalizar a compra.
    public void FinalizarCompra(Estoque estoque)
    {
        boolean ConfirmarCompra;

        System.out.print("Deseja finalizar a compra ou cancelar (c)? (s|n|c)  ");
        Scanner UserConfirm = new Scanner(System.in);

        String UserConfirmStr = UserConfirm.next();

        switch (UserConfirmStr)
        {
            case "s":
            case "S":
                ConfirmarCompra = true;
                break;
            case "n":
            case "N":
                ConfirmarCompra = false;
                break;
            case "c":
            case "C":
                ConfirmarCompra = false;
                ClienteCompras.FinalizarCompra(estoque, ConfirmarCompra);
                break;
            default:
                ConfirmarCompra = false;
                break;
        }

        if(ConfirmarCompra)
        {
            //Entra em contato com o banco.
            Boolean CompraAutorizada = FinalizarCompra.ConcluirCompra();

            //Define o status da compra.
            ClienteCompras.setCompraAutorizada(CompraAutorizada);

            //Contata a reserva do cliente para finalizar a compra.
            ClienteCompras.FinalizarCompra(estoque, ConfirmarCompra);
        }
    }
}