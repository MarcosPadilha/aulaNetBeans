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
}
