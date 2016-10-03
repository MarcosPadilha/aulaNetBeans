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
    
    
    
    
    
    
        
}
