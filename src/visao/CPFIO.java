/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import negocio.CPFBO;

/**
 *
 * @author faculdade.ads
 */
public class CPFIO {
    /**
     * método que pede ao usuario o cpf
     * @return objeto instanciado da classe CPFBO
     */
    public static CPFBO getInstance(){
        
        System.out.println("numero do cpf : ");
        String cpf = Teclado.lerString();
        return new CPFBO(cpf);
        
    }
   public static void printCPF(CPFBO CPF) {
       System.out.println("CPF :"+CPF.getNumero());
       
   
           
    
    
}

}