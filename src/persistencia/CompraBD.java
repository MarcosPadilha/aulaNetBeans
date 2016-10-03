/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.CompraBO;
import negocio.VendaBO;

/**
 *
 * @author faculdade.ads
 */

public class CompraBD {
     public static ArrayList<CompraBO> base = new ArrayList();
    
     public static boolean save(CompraBO compra){
        base.add(compra);
        return true;
    
    }
    
    public static ArrayList<CompraBO> getAll(){
        return base;
 
    }
    
      public static CompraBO findCompraCodigo(int codigo){
    for(CompraBO c : base){
        if(c.getCodigoVenda() == codigo){
            
            return c;
        }
    }
       return null; 
    }
            public static boolean delete(int codigo){
            int linha = posCompraVenda(codigo);
                if(linha!= -1){
                    base.remove(linha);
                   return true; 
                }else{
                    return false;
                }
       
    }
        public static int posCompraVenda(int codigo){
        int linha = 0;
        for(CompraBO v : base){
            if(v.getCodigoVenda() == codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
      
      
    
}
