/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import negocio.ProdutoBO;
import persistencia.ProdutoBD;
import visao.ClienteIO;
import visao.ProdutoIO;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoCL {
    
    public static boolean newProduto(){
    ProdutoBO p = ProdutoIO.getInstance();
    return ProdutoBD.save(p);
    
    }
    
     public static boolean deleteProduto(int codigo){
    return ProdutoBD.delete(codigo);
    }
    
    public static boolean updateCliente(){
    ProdutoBO c = ProdutoIO.getInstance();
    return ProdutoBD.update(c);
    
    }
    
     public static void findProdutoCodigo( int codigo){
        ProdutoBO c = ProdutoBD.findProdutoCodigo(codigo);
        if(c!=null){
         ProdutoIO.printProduto(c);  
        }else{//depois troca por exceção
            System.out.println("nao encontrado ");  
        }
        
    }
       public static void findProdutoValorCompra( double renda, int opcao){
          ArrayList<ProdutoBO> resposta = new ArrayList();
            resposta = ProdutoBD.findProdutoValorCompra(renda, opcao);
            if(resposta!=null){
                ProdutoIO.printList(resposta);
            }else{
                System.out.println("Não encontrado");
            }
      }
     
}
