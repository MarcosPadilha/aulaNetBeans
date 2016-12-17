/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.ClienteBO;
import negocio.CompraBO;
import negocio.VendaBO;

/**
 *
 * @author faculdade.ads
 */

public class CompraBD {
     public static ArrayList<CompraBO> base = new ArrayList();
      private static String caminho = "c:\\banco\\Compras.tdn";

   public static void load(){
   
         if(Arquivo.loadDataBase(caminho)!=null){
             base = (ArrayList<CompraBO>)Arquivo.loadDataBase(caminho);           
         }
    
 
 }
    
     public static boolean save(CompraBO compra){
        base.add(compra);
         Arquivo.updateDataBase(base, caminho);
        return true;
    
    }
    
    public static ArrayList<CompraBO> getAll(){
     
        return base;
 
    }
    
      public static CompraBO findCompraCodigo(int codigo){
       
    for(CompraBO c : base){
        if(c.getCodigoCompra() == codigo){
            
            return c;
        }
    }
       return null; 
    }
            public static boolean delete(int codigo){
              
            int linha = posCompraCodigo(codigo);
                if(linha!= -1){
                    base.remove(linha);
                   
                   return true; 
                }else{
                    return false;
                }
       
    }
        public static int posCompraCodigo(int codigo){
          
        int linha = 0;
        for(CompraBO c : base){
            if(c.getCodigoCompra()== codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
        
          public static boolean update(CompraBO dado){
          
    int linha = posCompraCodigo(dado.getCodigoCompra());
        if(linha!= -1){
            base.set(linha, dado);
           
            return true;
        }else{
            return false;
        }
        
    }
      
      
    
}
