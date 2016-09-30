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
     
     
    
}
