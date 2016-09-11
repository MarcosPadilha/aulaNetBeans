/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.ClienteBO;

/**
 *
 * @author faculdade.ads
 * 
 */
public class ClienteBD {
 private static ArrayList<ClienteBO> base = new ArrayList(); 
 /**
  * método que salva os clientes no array base criado aqui em cima.
  * @param item
  * @return boolean
  */
    public static boolean save(ClienteBO item){
        base.add(item);
        return true;

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
     * @param codigo
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
     * método que encontra a posição de um determinado cliente no array.
     * @param codigo
     * @return posiçao no array
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
 * @param renda
 * @param opcao
 * @return devolve um  objeto array com os clientes encontrados ou um nulo.
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
    * método que chama o método desta classe chamado
    * posCodigoCliente que verifica a posição do cliente no array
    * se existir ele deleta, se não, ele retorna false.
    * @param codigo
    * @return 
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
    
    public static boolean update(ClienteBO dado){
    int linha = posClienteCodigo(dado.getCodigo());
        if(linha!= -1){
            base.set(linha, dado);
            return true;
        }else{
            return false;
        }
        
    }
    
}
