/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.ProdutoVendaBO;
import negocio.VendaBO;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoVendaBD {
        public static ArrayList<ProdutoVendaBO> base = new ArrayList();
         private static String caminho = "c:\\banco\\ProdutoVenda.tdn";

   public static void load(){
   
         if(Arquivo.loadDataBase(caminho)!=null){
             base = (ArrayList<ProdutoVendaBO>)Arquivo.loadDataBase(caminho);           
         }
    
 
 }
    
    public static boolean save(ProdutoVendaBO venda){       
         base.add(venda);
       
          return true;
               
    }
    
    public static ArrayList<ProdutoVendaBO> getAll(){
      
        return base;
        
    }
    
    public static ArrayList<ProdutoVendaBO> findProdutoVendidos(int codigoVenda){
     
       ArrayList<ProdutoVendaBO> resposta = new ArrayList();
       for(ProdutoVendaBO pv: base){
        if(pv.getCodigoVenda()==codigoVenda){
               resposta.add(pv);
               
        }
      }
       
       if(resposta.isEmpty()){
           return null;
           
       }else{
           return resposta;
       }
    
    }
    
    
     public static boolean delete(int codigo){
      
    int linha = posProdutoVendaCodigo(codigo);
        if(linha!= -1){
            base.remove(linha);
             
           return true; 
        }else{
            return false;
        }
    
    
     }
     
      public static ProdutoVendaBO findProdutoVendaCodigo(int codigo){
     
    for(ProdutoVendaBO p : base){
        if(p.getCodigoVenda() == codigo){
            
            return p;
        }
    }
       return null; 
    }
      
      
      public static int posProdutoVendaCodigo(int codigo){
      
        int linha = 0;
        for(ProdutoVendaBO v : base){
            if(v.getCodigoVenda() == codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
        
    
        
}
