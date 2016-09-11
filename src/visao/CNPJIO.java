/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import negocio.CNPJBO;



/**
 *
 * @author Marcos
 */
public class CNPJIO {
    /**
     * método que pede a digitaçao do cnpj com a classe teclado
     * @return objeto instanciado da classe CNPJIO
     */
     public static CNPJBO getInstance(){
        
        System.out.println("numero do CNPJ: ");
        String CNPJ = Teclado.lerString();
        return new CNPJBO(CNPJ);
        
    }
        public static void printCNPJ(CNPJBO cnpj) {
       System.out.println("CPF"+cnpj.getNumero());
       
   
           
    
    
}
   
    
}
