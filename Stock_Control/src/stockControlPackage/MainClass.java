package stockControlPackage;

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
		String userEntry = "";
		do
		{
			
		}
		while(userEntry != "Sair");
	}
}
