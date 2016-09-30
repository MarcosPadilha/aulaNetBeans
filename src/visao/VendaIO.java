/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ClienteCL;
import negocio.VendaBO;

/**
 *
 * @author faculdade.ads
 */
public class VendaIO {
    public static VendaBO getInstance(){
        System.out.println("Código:");
        int codigo = Teclado.lerInt();
        System.out.println("data:");
        String dataVenda = Teclado.lerString();
        int codigoCliente = ClienteCL.chooseCliente().getCodigo();
        return new VendaBO(codigo, dataVenda, codigoCliente); 
    }
    public static void printVenda(VendaBO v){
        System.out.println("Codigo :"+v.getCodigoVenda());
        System.out.println("data venda: " + v.getDataVenda());
        System.out.println("cliente :"+ v.getCodigoCliente());
        
     
        
    }
    
    
    
}
