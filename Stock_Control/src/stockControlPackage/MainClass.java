package stockControlPackage;

import java.util.*;

import produtoPackage.Produto;
import clientePackage.Cliente;
import estoquePackage.Estoque;

public class MainClass
{
	public static void main(String[] args)
	{
		// Apresentação dos responsáveis:
		System.out.println("Unicep - Sistema de Controle de Estoque (Stock Control System)");
		System.out.println("\n\nAlunos:\n\tBruno Alves de Araújo | RA: 4200870\n\tMatheus Lopes Silvati | RA: 4200872");
		System.out.println("Professor: Wesley Pecoraro\nCurso: Eng. de Computação\nDisciplina: Programação Orientada ao Objeto");

		// Instancia a lista de produtos que estará disponível como DB.
		Estoque estoque = new Estoque();

		// Inicializa o cliente
		Cliente cliente = new Cliente(500);

		// Loop de funcionamento em modo de interação:
		boolean sair = false;

		do
		{
			String userEntryStr = "";

			System.out.println("ajuda - Exibe os comandos disponíveis.");
			System.out.print("Entre com o comando desejado: ");
			Scanner userEntry = new Scanner(System.in);

			userEntryStr = userEntry.nextLine();

			switch(userEntryStr.toLowerCase())
			{
				case "ajuda":			//Exibe a ajuda do programa.
				{
					System.out.println("\nComandos disponíveis para o usuário:\n----------------------------------------");
					System.out.println("Ajuda - Exibe a ajuda do programa.");
					System.out.println("MostrarProdutos - Exibe os produtos registrados no estoque.");
					System.out.println("MostrarId - Exibe a identificação do usuário (ID de usuário).");
					System.out.println("ProcurarProduto - Busca por um produto no estoque.");
					System.out.println("ReservarProduto - Reserva um produto e a sua quantidade especificada.");
					System.out.println("RemoverProduto - Retira um produto e a sua quantidade especificada que fora reservado.");
					System.out.println("ListarCompras - Exibe os produtos reservados.");
					System.out.println("FinalizarCompra - Finaliza a compra dos produtos reservados.");
					System.out.println("-----------------------------------------------\nSair - Encerra o programa.");

					break;
				}
				case "mostrarprodutos":	//Exibe todos os produtos disponíveis no banco de dados do estoque.
				{
					estoque.ListarProdutos();
					break;
				}
				case "mostrarid":		//Exibe a ID do cliente.
				{
					cliente.ExibirIDCliente();
					break;
				}
				case "procurarproduto":	//Busca por uma identificação de um produto (ID de produto).
				{
					cliente.PesquisarProduto(estoque);
					break;
				}
				case "reservarproduto":	//Reserva um produto para a compra do cliente.
				{
					cliente.ReservarProdutoCliente(estoque);
					break;
				}
				case "removerproduto":	//Retira um produto da reserva do cliente.
				{
					cliente.DevolverProdutoCliente(estoque);
					break;
				}
				case "listarcompras":	//Lista os produtos reservados pelo cliente.
				{
					cliente.ListarCompras();
					break;
				}
				case "finalizarcompra":	//Realiza a finalização da compra dos produtos reservados.
				{
					cliente.FinalizarCompra(estoque);
					break;
				}
				case "sair":
				{
					System.out.println("\n\nSaindo do programa...\n\n");
					sair = true;
					break;
				}
			}
		}
		while(!sair);
	}
}
