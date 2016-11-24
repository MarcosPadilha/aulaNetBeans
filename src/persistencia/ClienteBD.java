/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ClienteBO;


/**
 *
 * @author faculdade.ads
 * 
 */
public class ClienteBD {
 private static ArrayList<ClienteBO> base = new ArrayList(); 
 private static String caminho = "c:\\banco\\Clientes.tdn";

 public static void load(){
   
         if(Arquivo.loadDataBase(caminho)!=null){
             base = (ArrayList<ClienteBO>)Arquivo.loadDataBase(caminho);           
         }
    
 
 }
 
 /**
  * método que salva os clientes no array base criado aqui em cima.
  * @param  item - objeto ClienteBO
  * @return boolean
  */
    public static boolean save(ClienteBO item){
        base.add(item);
        Arquivo.updateDataBase(base, caminho);
        return true;

    }
       /**
    * método que chama o método desta classe chamado
    * posCodigoCliente que verifica a posição do cliente no array
    * se existir ele deleta, se não, ele retorna false.
    * @param  codigo - inteiro
    * @return boolean
    */
    public static boolean delete(int codigo){
    int linha = posClienteCodigo(codigo);
        if(linha!= -1){
            base.remove(linha);
           return true; 
        }else{
            return false;
        }
       
    }
  /**
   * Atualiza um registro
   * @param  dado CLienteBO
   * @return boolean
   */  
    
    public static boolean update(ClienteBO dado){
    int linha = posClienteCodigo(dado.getCodigo());
        if(linha!= -1){
            base.set(linha, dado);
            return true;
        }else{
            return false;
        }
        
    }
    
 /**
  * método que retorna o array criado logo acima.
  * @return base com todos clientes.
  */
    public static ArrayList<ClienteBO> getAll(){

        return base;
    }       
    /**
     * método que encontra cliente pelo codigo enviado via parâmetro.
     * @param  codigo - valor int
     * @return objeto tipo ClienteBO com o cliente buscado ou um nulo.
     */
    public static ClienteBO findClienteCodigo(int codigo){
    for(ClienteBO c : base){
        if(c.getCodigo() == codigo){
            
            return c;
        }
    }
       return null; 
    }
    /**
     * busca cliente por nome
     * @param nome
     * @return ClienteBO
     */
     public static ClienteBO findClienteNome(String nome){
    for(ClienteBO c : base){
        if(c.getNome().equals(nome)){
            
            return c;
        }
    }
       return null; 
    }
    
    
    /**
     * método que encontra a posição de um determinado cliente no array.
     * @param  codigo - int
     * @return int
     */
    public static int posClienteCodigo(int codigo){
        int linha = 0;
        for(ClienteBO c : base){
            if(c.getCodigo()== codigo){
            return linha;
            }
            linha++;
        }
        return -1;
        
    }
/**
 * método que busca clientes quew atendam às características de renda passadas pelo parâmetro
 * e de acordo a opçao restritiva enviada.
 * @param  renda double
 * @param  opcao int
 * @return Arraylist
 */    
   public static ArrayList <ClienteBO> findClienteRenda(double renda, int opcao){
       ArrayList <ClienteBO> resposta = new ArrayList();
       switch(opcao){
           case 1:
               for(ClienteBO c : base){
        
                    if(c.getRenda() <= renda){// para quem ganha no máximo o valor informado.
                         resposta.add(c);                       
                    }                    
                }
               break;
            case 2:
               for(ClienteBO c : base){// para quem ganha no mínimo o valor informado.
        
                    if(c.getRenda() >= renda){
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
   
  /**
   * Busca ciente com renda maior que 5000
   * @return arrrayList
   */
   public static ArrayList<ClienteBO> findRendaMaior5000(){
     ArrayList <ClienteBO> resposta = new ArrayList();
      for(ClienteBO c : base){
          if(c.getRenda() >5000){
          resposta.add(c);
          }
          
      }
          
   return resposta;
   }
   
   /**
    * busca maior renda
    * @return ArrayList
    */
   
    public static ArrayList<ClienteBO> findRendaMaior(){
     ArrayList <ClienteBO> resposta = new ArrayList();
    
       double maior = 0;
      
      for(ClienteBO c : base){
          
          if(c.getRenda() >= maior){
              maior = c.getRenda();      
             
          }
                 
      }
      
      for(ClienteBO cliente : base){
          
          if(cliente.getRenda() >= maior){
              resposta.add(cliente);
             
          }
                 
      } 
           return resposta;
         
   }
    
     /**
      * busca a media de renda.
      * @return double.
      */
  public static double mediaRenda(){
       
      int total = 0;
      double media;
      double valor = 0;
   for(ClienteBO c : base){
       valor += c.getRenda();
       
       total++;
   }
   media = valor/total;
  
   return media;
  } 
  
  
}


    



