/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProdutoCL;
import negocio.CompraProdutoBO;
import negocio.ProdutoBO;

/**
 *
 * @author faculdade.ads
 */
public class CompraProdutoIO {
    
    public static CompraProdutoBO getInstance(int codigoCompra){
        ProdutoBO p = ProdutoCL.chooseProduto();
        System.out.println("quantidade");
        int quantidade = Teclado.lerInt();
        return new CompraProdutoBO(codigoCompra, p, quantidade);
    }
    
    
}
