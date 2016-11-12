/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.CompraProdutoBO;

/**
 *
 * @author faculdade.ads
 */

public class CompraProdutoBD {
     public static ArrayList<CompraProdutoBO> base = new ArrayList();
     
      public static boolean save(CompraProdutoBO venda){
        base.add(venda);
        return true;    
    }
    
    public static ArrayList<CompraProdutoBO> getAll(){
        return base;
        
    }
    /**
     * método que busca por produtos comprados
     * @param  codigoCompra int
     * @return arrayList
     */
    public static ArrayList<CompraProdutoBO> findProdutosComprados(int codigoCompra){
       ArrayList<CompraProdutoBO> resposta = new ArrayList();
       for(CompraProdutoBO pc: base){
        if(pc.getCodigoCompra()==codigoCompra){
               resposta.add(pc);
               
        }
      }
       if(resposta.isEmpty()){
           return null;
           
       }else{
           return resposta;
       }
    
    }
    
    public static boolean delete(int codigo){
    int linha = posProdutoCompraCodigo(codigo);
        if(linha!= -1){
            base.remove(linha);
           return true; 
        }else{
            return false;
        }
    
    
     }
    
     public static int posProdutoCompraCodigo(int codigo){
        int linha = 0;
        for(CompraProdutoBO c : base){
            if(c.getCodigoCompra() == codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
     
     
    
}
