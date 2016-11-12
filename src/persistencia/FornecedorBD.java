/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.FornecedorBO;

/**
 *Classe que grava arquivos no banco  de dados
 * @author Marcos
 */
public class FornecedorBD {
    
    public static ArrayList <FornecedorBO> baseFornecedores = new ArrayList();
    /**
     * método que salva, adiciona no array base os fornecedores.
     * @param   item FornecedorBO
     * 
     * @return boolean
     * 
     */
        public static boolean save(FornecedorBO item){
        baseFornecedores.add(item);
            
            return true;
        }
        
        /**
         * método que cria uma lista e retorna todos os fornecedores
         * @return base de fornecedores
         */
         public static ArrayList<FornecedorBO> getAll(){

          return baseFornecedores;
        }       
  
 /**
  * método que procura fornecedor pelo código
  * @param  codigo int
  * @return objeto do tipo FornecedorBO ou um nulo.
  */        
         public static FornecedorBO findFornecedorCodigo(int codigo){
            for(FornecedorBO b : baseFornecedores){
                if(b.getCodigo()== codigo){
                 return b;
                }
              }
            return null;
         }
  /**
   * método que devolve a posição no array de um fornecedor buscado pelo código
   * @param  codigo int
   * @return posição do procurado ou posiçao inexistente.
   */       
         public static int posFornecedorCodigo(int codigo){
             int linha = 0;
                for(FornecedorBO b : baseFornecedores){
                    if(b.getCodigo()== codigo){
                        return linha;
                    }
                linha++;
                }
           return -1;
         }
         
      public static boolean delete(int codigo){
      int linha = posFornecedorCodigo(codigo);
        if(linha!=-1){
            baseFornecedores.remove(linha);
            return true;
        }else{
            return false;
        }
      
      }
      
       public static boolean update(FornecedorBO dado){
       int linha = posFornecedorCodigo(dado.getCodigo());
        if(linha!=-1){
            baseFornecedores.set(linha, dado);
            return true;
        
        }else{
        return false;
        }
        
       }
       
       
       public static FornecedorBO findFornecedorNome(String nome){
    for(FornecedorBO c : baseFornecedores){
        if(c.getNomeFantasia().equals(nome)){
            
            return c;
        }
    }
       return null; 
    }
}
