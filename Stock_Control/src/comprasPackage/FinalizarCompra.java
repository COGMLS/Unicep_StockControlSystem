package comprasPackage;

import java.util.Scanner;

public class FinalizarCompra
{
    public static boolean ConcluirCompra()
    {
        System.out.print("Deseja concluir a compra dos itens? (s|n): ");
        Scanner UserEntry = new Scanner(System.in);

        String UserEntryStr = UserEntry.next();

        switch(UserEntryStr.toLowerCase())
        {
            case "s":
                return true;
            case "n":
                return false;
            default:
                return false;
        }
    }
}
