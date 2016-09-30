/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.CompraBO;

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
    
}
