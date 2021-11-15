package produtoPackage;

public class DispEnumAux
{
    //Converte o valor de DispEnum para string
    public static String DispE2Str(DispEnum DispProdEnum)
    {
        switch (DispProdEnum)
        {
            case MUITOBAIXA:
                return "MUITO BAIXA";
            case BAIXA:
                return "BAIXA";
            case MEDIA:
                return "MEDIA";
            case ALTA:
                return "ALTA";
            case MUITOALTA:
                return "MUITO ALTA";
            default:
                return "INDISPOIVEL";
        }
    }

    //Converte uma string em um valor válido de DispEnum
    public static DispEnum DispSrt2E(String Srt)
    {
        if(Srt.equals("MUITO BAIXA"))
        {
            return DispEnum.MUITOBAIXA;
        }
        if(Srt.equals("BAIXA"))
        {
            return DispEnum.BAIXA;
        }
        else if(Srt.equals("MEDIA"))
        {
            return DispEnum.MEDIA;
        }
        else if(Srt.equals("ALTA"))
        {
            return DispEnum.ALTA;
        }
        else if(Srt.equals("MUITO ALTA"))
        {
            return DispEnum.MUITOALTA;
        }
        else
        {
            return DispEnum.INDISPONIVEL;
        }
    }
}
