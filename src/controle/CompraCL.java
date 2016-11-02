/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
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
    /**
     * cria objeto tipo compraBO que pega a instância do COmpraIO
     * salva no banco o objeto, cria um objeto do tipo CompraProdutoBO e este recebe 
     * um getInstance do COmpraIO que passa por parâmetro o método getCodigoCompra
     */
    public static void newVenda(){
    String finalizar = null;
    CompraBO compra = CompraIO.getInstance();
      if(CompraBD.save(compra)){
      CompraProdutoBO item;
      
        do{
            item = CompraProdutoIO.getInstance(compra.getCodigoCompra());
            System.out.println("Continuar? s/n");
            finalizar = Teclado.lerString();
        
        }while(!(finalizar.equalsIgnoreCase("n")));
     }
      
      
    
   }
    
     public static void findCOmpraCodigo( int codigo){
        CompraBO v = CompraBD.findCompraCodigo(codigo);
        if(v!=null){
         CompraIO.printCompra(v);  
        }else{//depois troca por exceção
            System.out.println("nao encontrado ");  
        }
    
   
    
    }
      public static void showCompras(){
          CompraIO.printList(CompraBD.getAll());
    
    }
      public static void findProdutosComprados(int codigo){
         ArrayList<CompraProdutoBO> item =  CompraProdutoBD.findProdutosComprados(codigo);
          CompraProdutoIO.printList(item);
          
          
      }
      
      
      
           
           
           
           
           
          
           
       
       
       
    
}
