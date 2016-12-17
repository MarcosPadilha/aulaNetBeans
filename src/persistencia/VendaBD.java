/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.VendaBO;

/**
 *
 * @author tecnico.ti
 */
public class VendaBD {
    public static ArrayList<VendaBO> base = new ArrayList();
    private static String caminho = "c:\\banco\\Vendas.tdn";

   public static void load(){
   
         if(Arquivo.loadDataBase(caminho)!=null){
             base = (ArrayList<VendaBO>)Arquivo.loadDataBase(caminho);           
         }
   
 }
    
    public static boolean save(VendaBO venda){
        base.add(venda);
        
        return true;
           
    }
    
    public static ArrayList<VendaBO> getAll(){
      
         return base;
    }       
 
    
    
       public static VendaBO findVendaCodigo(int codigo){
     
    for(VendaBO v : base){
        if(v.getCodigoVenda() == codigo){
            
            return v;
        }
    }
       return null; 
    }
       
       
       public static boolean delete(int codigo){
        
        int linha = posVendaCodigo(codigo);
        if(linha!= -1){
            base.remove(linha);
           
           return true; 
        }else{
            return false;
        }
        
        
       
    }
        public static int posVendaCodigo(int codigo){
         
        int linha = 0;
        for(VendaBO v : base){
            if(v.getCodigoVenda() == codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
        
         public static boolean update(VendaBO dado){
           
    int linha = posVendaCodigo(dado.getCodigoVenda());
        if(linha!= -1){
            base.set(linha, dado);
       
            return true;
        }else{
            return false;
        }
        
    }
       
       
}
