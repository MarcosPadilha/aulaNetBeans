/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import negocio.CNPJBO;
import negocio.EnderecoBO;
import negocio.FornecedorBO;

/**
 *Classe que oferece métodos para criar novo fornecedor e mostrar na tela.
 * @author faculdade.ads
 */
public class FornecedorIO {
    /**Método que cria menu para pegar informações digitadas pelo usuário
     * 
     * @return devolve um objeto FornecedorBO com dados digitados.
     */
    
    public static FornecedorBO getInstance(){
      System.out.println("Código: ");
        int codigo = Teclado.lerInt();
         System.out.println("Nome Fantasia : ");
        String nomeFantasia = Teclado.lerString();
        System.out.println("Razao social:");
        String razao = Teclado.lerString();       
         System.out.println("Telefone: ");
        String telefone = Teclado.lerString();
       System.out.println("e-mail: ");
        String email = Teclado.lerString();
        System.out.println("contato: ");
        String contato = Teclado.lerString();
        CNPJBO cnpj = CNPJIO.getInstance();
        EnderecoBO endereco = EnderecoIO.getInstance();
        return new FornecedorBO(codigo, nomeFantasia,razao, telefone, email, cnpj, endereco,contato);
    }
    /**
     * método que mostra na tela fornecedor criado.
     * @param  f FornecedorBO
     */
       public static void printFornecedor(FornecedorBO f){
        System.out.println("Codigo"+f.getCodigo());
        System.out.println("Nome Fantasia"+f.getNomeFantasia());
           System.out.println("Razão social: "+ f.getRazaoSocial());
        System.out.println("Telefone"+f.getTelefone());
        System.out.println("email"+f.geteMail());
        CNPJIO.printCNPJ(f.getCnpj());
        EnderecoIO.printEndereco(f.getEndereco());
        
    }
     /**
      * método que cria um array com todos fornecedores criados
      * @param  lista ArrayList
      */  
       public static void printList(ArrayList<FornecedorBO> lista){
           System.out.println("lista de fornecedores :");
             for(FornecedorBO cadaFornecedor : lista){
        printFornecedor(cadaFornecedor);
            System.out.println("------------------");
        }
             
       
       }
}
