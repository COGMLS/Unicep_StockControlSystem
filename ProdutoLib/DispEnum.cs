using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProdutoLib
{
    public class DispEnumClass
    {
        public enum DispEnum
        {
            INDISPONIVEL,   // Sem Estoque. Quantidade = 0
            MUITOBAIXA,     // Estoque <= 10%
            BAIXA,          // 25% >= Estoque > 10%
            MEDIA,          // 50 >= Estoque > 25%
            ALTA,           // 75% >= Estoque > 50%
            MUITOALTA       // Estoque cheio ou > 75%
        }
    }
}
