/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ClienteCL;
import controle.ProdutoCL;
import negocio.ProdutoBO;
import negocio.ProdutoVendaBO;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoVendaIO {
    public static ProdutoVendaBO getInstance(int codigoVenda){
        ProdutoBO p = ProdutoCL.chooseProduto();
        System.out.println("quantidade");
        int quantidade = Teclado.lerInt();
        return new ProdutoVendaBO(codigoVenda, p, quantidade);
    }
            
    
    
    
    
}
