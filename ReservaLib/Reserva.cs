using System;

namespace ReservaLib
{
    /**Classe Reserva
     * ---------------------
     * Classe destinada para o gerenciamento
     * da reserva de produtos do estoque para
     *  o cliente.
*/
    public class Reserva
    {
        private int ID_Usuario;     //ID única para o usuário.
        private List<Produto> Lista_Compra;
        private bool CompraAutorizada;
        private string TransportadoraSel;
        private bool ProdutoEnviado;

        //Getters:
        public List<Produto> getListaCompras()
        {
            return this.Lista_Compra;
        }
        public int getIDUsuario()
        {
            return this.ID_Usuario;
        }

        //Setters:
        private void setListaCompras(int size)
        {

        }
        private void setIDUsuario(int ID)
        {
            this.ID_Usuario = ID;
        }

        //Funções de controle da reserva de produtos:

        //Verifica se a compra foi realizada.
        private void VerificarCompra()
        {

        }
        private void DevolverProdutosAoEstoque()
        {

        }

        //Função que contata se a compra foi finalizada.
        public void FinalizarCompra(bool ConfirmarCompra)
        {
            if (ConfirmarCompra == true)
            {
                this.CompraAutorizada = true;
            }
            else
            {
                this.CompraAutorizada = false;
            }
        }

        //Funções de envio para a transportadora.
        private void ContatarTransportadora()
        {
            if (this.CompraAutorizada == true)
            {
                //Contata a transportadora e recebe um retorno de confirmação.

            }
        }

        //Verifica o envio à transportadora.
        public void VerificarEnvio()
        {
            if ()
        }



        //Funções de conctrole da reserva:
        public void AddReserva(int Produto_ID, int Quant)
        {

        }
        public void RemReserva(int Produto_ID, int Quant)
        {

        }
        public void ListReserva()
        {

        }
    }
}
