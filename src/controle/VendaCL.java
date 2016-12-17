/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import negocio.ProdutoBO;
import negocio.ProdutoVendaBO;
import negocio.VendaBO;
import persistencia.ClienteBD;
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
    
 
    
    public static boolean newVenda(VendaBO v){
        VendaBO venda = v;
        if(VendaBD.save(venda)){
                return true;
        }else{
        return false;
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
     
     public static boolean newItemVenda(ProdutoVendaBO item){
         return ProdutoVendaBD.save(item);
      
     }
     
     public static ArrayList<VendaBO> showVendas(){
          return VendaBD.getAll();
     }

    public static  ArrayList <ProdutoVendaBO> getItens(int codigoVenda) {
     return   ProdutoVendaBD.findProdutoVendidos(codigoVenda);
        
    }
    
   public static boolean updateVenda(VendaBO c){
    
    return VendaBD.update(c);
    }
   
   public static boolean delete(int codigo){
    return VendaBD.delete(codigo);
    }
   
   public static boolean removeItem(int codigo){
       ProdutoVendaBD.delete(codigo);
       
       return true;
   }
   
   public static void atualizarEstoque(int codigoVenda){
        VendaBO v =   VendaCL.findVendaCodigo(codigoVenda);
            
       for(ProdutoVendaBO pp : VendaCL.getItens(codigoVenda)){
           int qtd;
           qtd = pp.getQuantidade();
           ProdutoBO prod = ProdutoCL.findProdutoCodigo(pp.getProduto().getCodigo()) ;
           int novoEstoque = (int) (prod.getEstoque() - qtd);
           prod.setEstoque(novoEstoque);
           ProdutoCL.updateProduto(prod);
       }
   
   
   }
     
     
     
     
}
