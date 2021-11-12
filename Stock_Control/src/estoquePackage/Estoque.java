package estoquePackage;

import java.util.*;
import produtoPackage.Produto;
import produtoPackage.DispEnum;
import produtoPackage.ProcuraProdutoEnum;

public class Estoque 
{
    //Reserva espaço para a criação do banco de dados de produtos
    ArrayList<Produto> ProdBD;
    
    Estoque()
    {
        Produto Obj00 = new Produto("Intel Core i9-9900KF", 1, "BX80684I99900KF", "Intel", 25, 3000.00f, 100, ProcuraProdutoEnum.BAIXA, 1);
        Produto Obj01 = new Produto("Intel Core i7-9700K", 2, "BX80684I79700K", "Intel", 120, 1899.90f, 250, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj02 = new Produto("NVIDIA GeForce RTX 2060 D6 6G", 3, "GV-N2060D6-6GD", "NVidia", 100, 3600.00f, 200, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj03 = new Produto("NVIDIA GeForce RTX 3070 Twin Edge 8GB", 4, "ZT-A30700E-10PLHR", "NVidia", 35, 7500.00f, 100, ProcuraProdutoEnum.MEDIA, 1);
        Produto Obj04 = new Produto("Teclado Logitech K120", 5, "K120", "Logitech", 60, 70.00f, 300, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj05 = new Produto("Teclado Mecânico Gamer HyperX Alloy Origins Core", 6, "HX-KB7RDX-BR", "Hyper-X", 30, 650.00f, 100, ProcuraProdutoEnum.BAIXA, 0);
        Produto Obj06 = new Produto("Mouse Logitech M90 Preto 1000DPI", 7, "910-004053", "Logitech", 80, 36.00f, 320, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj07 = new Produto("Mouse Gamer Redragon Cobra", 8, "M711", "Redragon", 68, 140.00f, 150, ProcuraProdutoEnum.MEDIA, 1);
        Produto Obj08 = new Produto("Headphone JBL Club700", 9, "Club700BT", "JBL", 10, 900.00f, 50, ProcuraProdutoEnum.BAIXA, 0);
        Produto Obj09 = new Produto("Headset Gamer Havit", 10, "HV-H2002D", "Havid", 5, 260.00f, 160, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj10 = new Produto("HD Seagate BarraCuda 2TB", 11, "ST2000DM008", "Seagate", 326, 400.00f, 600, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj11 = new Produto("HD Seagate Externo Portátil Expansion USB 3.0 1TB", 12, "STEA1000400", "Seagate", 120, 300.00f, 450, ProcuraProdutoEnum.ALTA, 2);
        Produto Obj12 = new Produto("SSD Kingston A400 240GB", 13, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj13 = new Produto("SSD Kingston NV1 500GB M.2 2280 NVMe", 14, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj14 = new Produto("Notebook Asus ZenBook 14 Intel Core I5-1135G7", 15, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj15 = new Produto("Notebook ASUS X515JA-EJ1045T Intel Core i5-1035G1", 16, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj16 = new Produto("Nintendo Switch 32GB 1x Joycon Neon Azul/Vermelho", 17, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj17 = new Produto("Console Microsoft Xbox Series S 512GB Branco", 18, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj18 = new Produto("Cadeira Gamer Husky Gaming Snow", 19, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);
        Produto Obj19 = new Produto("Cadeira Gamer Husky Gaming Blizzard RGB", 20, "Modelo", "Marca", QuantidadeComprada, PrecoUni, QuantRec, ProcuraEnum, ProcuraInt);

        ProdBD = new ArrayList<Produto>(20);

        ProdBD.add(0, Obj00);
        ProdBD.add(1, Obj01);
        ProdBD.add(2, Obj02);
        ProdBD.add(3, Obj03);
        ProdBD.add(4, Obj04);
        ProdBD.add(5, Obj05);
        ProdBD.add(6, Obj06);
        ProdBD.add(7, Obj07);
        ProdBD.add(8, Obj08);
        ProdBD.add(9, Obj09);
        ProdBD.add(10, Obj10);
        ProdBD.add(11, Obj11);
        ProdBD.add(12, Obj12);
        ProdBD.add(13, Obj13);
        ProdBD.add(14, Obj14);
        ProdBD.add(15, Obj15);
        ProdBD.add(16, Obj16);
        ProdBD.add(17, Obj17);
        ProdBD.add(18, Obj18);
        ProdBD.add(19, Obj19);
    }
}
