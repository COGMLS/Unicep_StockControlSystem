package produtoPackage;

public enum ProcuraProdutoEnum
{
    INDISPONIVEL,       //Informção indisponível.
    BAIXA,              //0 <= x <= 33% é comprado.
    MEDIA,              //33% < x <= 66% é comprado.
    ALTA                //66% < x <= 100% é comprado.
}