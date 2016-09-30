/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import negocio.CompraBO;
import negocio.CompraProdutoBO;
import persistencia.CompraBD;
import persistencia.CompraProdutoBD;
import visao.CompraIO;
import visao.CompraProdutoIO;
import visao.Teclado;

/**
 *
 * @author faculdade.ads
 */
public class CompraCL {
    
    public static void newVenda(){
    String finalizar = null;
    CompraBO compra = CompraIO.getInstance();
      if(CompraBD.save(compra)){
      CompraProdutoBO item;
      
        do{
            item = CompraProdutoIO.getInstance(compra.getCodigoVenda());
            System.out.println("Continuar? s/n");
            finalizar = Teclado.lerString();
        
        }while(!(finalizar.equalsIgnoreCase("n")));
     } 
    
   }
       
      
      
           
           
           
           
           
          
           
       
       
       
    
}
