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
    
    
    
    
    
    
        
}
