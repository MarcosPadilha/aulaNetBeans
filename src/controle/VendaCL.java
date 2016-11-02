/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import negocio.ProdutoVendaBO;
import negocio.VendaBO;
import persistencia.ProdutoVendaBD;
import persistencia.VendaBD;
import visao.ProdutoVendaIO;
import visao.Teclado;
import visao.VendaIO;

/**
 *
 * @author tecnico.ti
 */
public class VendaCL {
    
 
    
    public static void newVenda(VendaBO v){
    VendaBO venda = v;
    if(VendaBD.save(venda)){
    
    
    
    }
    
   
    
    }
    
     public static ArrayList<ProdutoVendaBO>  salvaProdutosVendidos(ProdutoVendaBO item){
         
         ProdutoVendaBD.save(item);
    
         return null;
    }
     public static VendaBO findVendaCodigo( int codigo){
        VendaBO v = VendaBD.findVendaCodigo(codigo);
        if(v!=null){
          return v;
        }else{
        return null;
        }
    
            
    }
     
     public static ArrayList<VendaBO> showVendas(){
          return VendaBD.getAll();
     }
     
     
     
     
}
