package stockControlPackage;

import java.util.List;

/**Classe Reserva
 * ---------------------
 * Classe destinada para o gerenciamento
 * da reserva de produtos do estoque.
*/

public class Reserva
{
    private int ID_Usuario;
    private List<Produto> Lista_Compra;
    private boolean CompraAutorizada;
    private String TransportadoraSel;
    private boolean ProdutoEnviado;

    public List<Produto> getListaCompras()
    {
        return this.Lista_Compra;
    };
    public int getIDUsuario()
    {
        return this.ID_Usuario;
    };
    private void setListaCompras()
    {

    };
    private void setIDUsuario(int ID)
    {
        this.ID_Usuario = ID;
    };
    private void VerificarCompra()
    {

    };
    private void ContatarTransportadora()
    {

    };
    private void VerificarEnvio()
    {

    };
    private void DevolverProdutosAoEstoque()
    {

    };
}
