/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.FornecedorCL;
import java.util.ArrayList;
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
    
    public static void printCompra(CompraBO c){
         System.out.println("Codigo :"+c.getCodigoVenda());
        System.out.println("data venda: " + c.getDataCompra());
        System.out.println("cliente :"+ c.getCodFornecedor());
    
    
    }
   
    public static void printList (ArrayList <CompraBO> lista){
        System.out.println("lista de clientes :");
        for(CompraBO cadaCompra: lista){
        printCompra(cadaCompra);
            System.out.println("------------------");
        }
        
    }
    
    
    
    
    
    
    
}
