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
import visao.Teclado;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoCL {
    
    public static boolean newProduto(){
    ProdutoBO p = ProdutoIO.getInstance();
    return ProdutoBD.save(p);
    
    }
    public static void showProdutos(){
        ProdutoIO.printList(ProdutoBD.getAll());
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
       public static void findProdutoValorCompra( double valor, int opcao){
          ArrayList<ProdutoBO> resposta = new ArrayList();
            resposta = ProdutoBD.findProdutoValorCompra(valor, opcao);
            if(resposta!=null){
                ProdutoIO.printList(resposta);
            }else{
                System.out.println("Não encontrado");
            }
      }
       
       public static void findProdutoEstoqueBaixo(){
       
       }
       
       public static ProdutoBO chooseProduto(){
       String resposta = null;
           ProdutoBO p;
           int codigo = 0;
           
            do{
                System.out.println("Digite o produto que deseja incluir na venda:");
                codigo = Teclado.lerInt();
                p = ProdutoBD.findProdutoCodigo(codigo);
                
                 if(p != null){
                 System.out.println(p.getNome());
                  System.out.println("deseja prosseguir? s/n");
                  resposta = Teclado.lerString();
                  
             }else{
                 System.out.println("Produto não localizado");
                 resposta = "n";
             }
                 
                
            
            }while(!(resposta.equals("s")));
            
           
           
           return p;
           
           
       }
     
}
