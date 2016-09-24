/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.ClienteBO;
import negocio.ProdutoBO;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoBD {
    private static ArrayList <ProdutoBO> base = new ArrayList();
    public static boolean save(ProdutoBO item){
    base.add(item);
    return true;
    }
    public static ArrayList<ProdutoBO> getAll(){
        return base;
    }
    
      public static int posProdutoCodigo(int codigo){
        int linha = 0;
        for(ProdutoBO p : base){
            if(p.getCodigo()== codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
     
      
      public static boolean delete(int codigo){
    int linha = posProdutoCodigo(codigo);
        if(linha!= -1){
            base.remove(linha);
           return true; 
        }else{
            return false;
        }
       
    }
      public static boolean update(ProdutoBO dado){
      int linha = posProdutoCodigo(dado.getCodigo());
        if(linha !=-1){
        base.set(linha, dado);
        return true;
        }else{
        return false;
        }
      }
      public static ProdutoBO findProdutoCodigo(int codigo){
      for(ProdutoBO p : base){
          if(p.getCodigo()== codigo){
           return p ;
           
          }
      }
     return null;     
    }
      
       public static ArrayList <ProdutoBO> findProdutoValorCompra(double valorCompra, int opcao){
       ArrayList <ProdutoBO> resposta = new ArrayList();
       switch(opcao){
           case 1:
               for(ProdutoBO c : base){
        
                    if(c.getValorCompra() <= valorCompra){// para produto no preço máximo igual ao valor informado.
                         resposta.add(c);                       
                    }                    
                }
               break;
            case 2:
               for(ProdutoBO c : base){// para produto nopreço mínimo igual ao valor informado.
        
                    if(c.getValorCompra() >= valorCompra){
                         resposta.add(c);
                         
                    }                    
                }
               break;   
         }      
       if(resposta.isEmpty()){
          return null;
       }else{
           return resposta;
       }
       
      
    }
       public static ArrayList <ProdutoBO> findProdutoEstoqueBaixo(){
       ArrayList <ProdutoBO> lista = new ArrayList();
       
       
       return lista;
       }
      
    
    
}
