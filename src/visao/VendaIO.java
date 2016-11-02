/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ClienteCL;
import java.util.ArrayList;
import negocio.VendaBO;

/**
 *
 * @author faculdade.ads
 */
public class VendaIO {
  
    
    public static void printVenda(VendaBO v){
        System.out.println("Codigo :"+v.getCodigoVenda());
        System.out.println("data venda: " + v.getDataVenda());
        System.out.println("cliente :"+ v.getCodigoCliente());
            
    }
    
     public static void printList(ArrayList <VendaBO> lista){
        System.out.println("lista de clientes :");
        for(VendaBO cadaVenda: lista){
        printVenda(cadaVenda);
            System.out.println("------------------");
        }
        
    }
    
    
    
}
