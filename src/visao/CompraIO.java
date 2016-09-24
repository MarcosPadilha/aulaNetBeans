/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.FornecedorCL;
import negocio.CompraBO;

/**
 *
 * @author faculdade.ads
 */
public class CompraIO {
    
    public static CompraBO getInstance(){
         System.out.println("Código:");
        int codigo = Teclado.lerInt();
        System.out.println("data:");
        String dataVenda = Teclado.lerString();
        int codigoCliente = FornecedorCL.chooseFornecedor().getCodigo();
        return new CompraBO(codigo, dataVenda, codigoCliente); 
        
    }
    
    
}
