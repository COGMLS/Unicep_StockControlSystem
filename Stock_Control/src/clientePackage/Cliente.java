package clientePackage;

import java.util.Scanner;

import estoquePackage.Estoque;
import reservaPackage.Reserva;

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

    //Reserva e adiciona os produtos do estoque para a lista de compras.
    public void ReservarProdutoCliente(Estoque estoque)
    {
        System.out.print("Entre com o código do produto para reservar: ");
        Scanner ID_Prod = new Scanner(System.in);

        try
        {
            int ID_ProdInt = Integer.parseInt(ID_Prod.toString());

            System.out.println("Entre com a quantidade de produtos a ser retirada: ");
            Scanner RetirarQuant = new Scanner(System.in);

            try
            {
                int RetirarQuantInt = Integer.parseInt(RetirarQuant.toString());

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

        try
        {
            int ID_ProdInt = Integer.parseInt(ID_Prod.toString());

            System.out.println("Entre com a quantidade de produtos a ser devolvida ao estoque: ");
            Scanner RetirarQuant = new Scanner(System.in);

            try
            {
                int RetirarQuantInt = Integer.parseInt(RetirarQuant.toString());

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
    public void FinalizarCompra()
    {
        boolean ConfirmarCompra;

        System.out.println("Deseja finalizar a compra? (s|n)");
        Scanner UserConfirm = new Scanner(System.in);

        String UserConfirmStr = UserConfirm.toString();

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
            default:
                ConfirmarCompra = false;
                break;
        }

        ClienteCompras.FinalizarCompra(ConfirmarCompra);
    }
}