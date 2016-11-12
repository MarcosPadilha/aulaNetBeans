/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import negocio.CompraBO;
import negocio.CompraProdutoBO;
import negocio.ProdutoBO;
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
    
     public static CompraBO findCompraCodigo( int codigo){
        CompraBO v = CompraBD.findCompraCodigo(codigo);
        if(v!=null){
         return v;
        }else{
           return null;
        }
    
   
    
    }
      public static ArrayList<CompraBO> showCompras(){
          return CompraBD.getAll();
    
    }
      public static void findProdutosComprados(int codigo){
         ArrayList<CompraProdutoBO> item =  CompraProdutoBD.findProdutosComprados(codigo);
          CompraProdutoIO.printList(item);
          
          
      }
      public static  ArrayList <CompraProdutoBO> getItens(int codigoVenda) {
     return   CompraProdutoBD.findProdutosComprados(codigoVenda);
        
    }
      
      public static void newCompra(CompraBO c){
        CompraBO compra = c;
        if(CompraBD.save(compra)){

        }
     
    }
      
      public static boolean delete(int codigo){
    return CompraBD.delete(codigo);
    }
      
      public static boolean newItemCompra(CompraProdutoBO item){
         return CompraProdutoBD.save(item);
      
     }
      
      public static boolean updateCompra(CompraBO c){
    
    return CompraBD.update(c);
    }
      
      public static boolean removeItem(int codigo){
       CompraProdutoBD.delete(codigo);
       
       return true;
   }
      
      public static void atualizarEstoque(int codigoCompra){
        CompraBO v =   CompraCL.findCompraCodigo(codigoCompra);
            
       for(CompraProdutoBO cc : CompraCL.getItens(codigoCompra)){
           int qtd;
           qtd = cc.getQuantidade();
           ProdutoBO prod = ProdutoCL.findProdutoCodigo(cc.getProduto().getCodigo()) ;
           int novoEstoque = (int) (prod.getEstoque() + qtd);
           prod.setEstoque(novoEstoque);
           ProdutoCL.updateProduto(prod);
       }
   
   
   }
      
      
           
           
           
           
           
          
           
       
       
       
    
}
