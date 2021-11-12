using System;

namespace ComprasLib
{
    public interface IFinalizarCompra
    {
        public void ConcluirCompra();
        public bool PagamentoAutorizado();
        public void CancelarCompra();
    }
}
