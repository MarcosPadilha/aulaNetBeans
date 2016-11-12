/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import negocio.ClienteBO;
import persistencia.ClienteBD;
import visao.ClienteIO;
import visao.ClienteUI;
import visao.Teclado;

/**
 *Classe que liga os escopos visão com persistência
 * @author faculdade.ads
 */
public class ClienteCL {
    /**
     * método que chama o método da classe ClienteIO para exibir um menu na tela.
     * @return objeto ClienteBD com esse menu pronto para ser chamado.
     */
    
   
   
    
    /**
     * Grava um novo cliente.
     * @param  cliente ClienteBO
     * @return Boolean.
     */
    
    public static boolean newCliente(ClienteBO cliente){
             
        return ClienteBD.save(cliente);
    }
    
    /**Método que delete clientes.
     * 
     * @param  codigo int
     * @return boolean
     */
    public static boolean deleteCliente(int codigo){
    return ClienteBD.delete(codigo);
    }
    /**
     * Atualiza um registro.
     * @param  c ClienteBO
     * @return boolean
     */
    public static boolean updateCliente(ClienteBO c){
    
    return ClienteBD.update(c);
    }
    
    /**
     * método que chama um método da classe ClienteIO que mostra todo na tela passando como parâmetro o
     *método gettAll da classe CLienteBD que pega todos os clientes.
     * @return ArrayList
     */
   
   
      public static ArrayList<ClienteBO> showClientes(){
          return ClienteBD.getAll();
      }
    
  /*
    public static void findClienteCodigo( int codigo){
        ClienteBO c = ClienteBD.findClienteCodigo(codigo);
        if(c!=null){
         ClienteIO.printCliente(c);  
        }else{//depois troca por exceção
            System.out.println("nao encontrado ");  
        }
        
    }
      
      */
      /**
       * 
       * @param  codigo int
       * @return ClienteBO
       */
    public static ClienteBO findClienteCodigo(int codigo){
        ClienteBO c = ClienteBD.findClienteCodigo(codigo);
        return c;
        
    }
    
    
   /**
    * Método que busca cliente por renda criando um arrayList tipo ClienteBO 
    * que chama o método findClienteRenda da classe ClienteBD. Se a resposta for null
    * ele manda um print "não encontrado" se existir, ele manda um arrayList vindo de 
    * um método chamado printList da classe ClienteIO.
    * @param  renda double
    * @param   opcao int
    */
    
      public static void findClienteRenda( double renda, int opcao){
          ArrayList<ClienteBO> resposta = new ArrayList();
            resposta = ClienteBD.findClienteRenda(renda, opcao);
            if(resposta!=null){
                ClienteIO.printList(resposta);
            }else{
                System.out.println("Não encontrado");
            }
      }
      /**
       * busca cliente pelo código.
       * @return ClienteBO
       */
      public static ClienteBO chooseCliente(){
          String resposta = null;
           ClienteBO c;
           int codigo;         
          do{
                System.out.println("Digite o código do cliente que deseja buscar");
                codigo = Teclado.lerInt();
               c = ClienteBD.findClienteCodigo(codigo);
             if(c != null){
                 System.out.println(c.getNome());
                  System.out.println("deseja prosseguir? s/n");
                  resposta = Teclado.lerString();
                  
             }else{
                 System.out.println("Cliente não localizado");
                 resposta = "n";
             }
                 
              } while(!(resposta.equals("s")));
             
             return c;
          }
      
      /**
       * busca renda maior que 5000
       * 
       */
      public static void findRendaMaior5000(){
     ArrayList<ClienteBO> resposta = new ArrayList();
            resposta = ClienteBD.findRendaMaior5000();
            if(resposta!=null){
                ClienteIO.printList(resposta);
            }else{
                System.out.println("Nenhum Cliente ganha mais de 5000");
            }
      
      
      }
      /**
       * imprime a média das rendas.
       * 
       */
       public static void mediaRenda(){
           
           System.out.println("A média de renda dos clientes é " + ClienteBD.mediaRenda());
           
           
       }
       /**
        * busca maior renda.
        */
       public static void RendaMaior(){
           ArrayList<ClienteBO> lista = new ArrayList();
          
           lista = ClienteBD.findRendaMaior();
           ClienteIO.printList(lista);
       
       
       
       }
       
       public static ClienteBO findCLienteNome(String nome){
      
           return  ClienteBD.findClienteNome(nome);
       
       
       }
          
          
      }
      
      

