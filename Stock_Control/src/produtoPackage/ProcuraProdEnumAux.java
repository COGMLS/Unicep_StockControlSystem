package produtoPackage;

import produtoPackage.ProcuraProdutoEnum;

public class ProcuraProdEnumAux
{
    //Converte o valor de ProcuraProdutoEnum para string
    public static String ProcuraProdutoE2Str(ProcuraProdutoEnum ProcuraEnum)
    {
        switch (ProcuraEnum)
        {
            case BAIXA:
                return "BAIXA";
            case MEDIA:
                return "MEDIA";
            case ALTA:
                return "ALTA";
            default:
                return "INDISPOIVEL";
        }
    }

    //Converte uma string em um valor válido de ProcuraProdutoEnum
    public static ProcuraProdutoEnum ProcuraProdutoSrt2E(String Srt)
    {
        if(Srt.equals("BAIXA"))
        {
            return ProcuraProdutoEnum.BAIXA;
        }
        else if(Srt.equals("MEDIA"))
        {
            return ProcuraProdutoEnum.MEDIA;
        }
        else
        {
            return ProcuraProdutoEnum.ALTA;
        }
    }
}
