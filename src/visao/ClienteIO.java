/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import negocio.CPFBO;
import negocio.ClienteBO;
import negocio.EnderecoBO;

/**
 *Classe que oferece métodos criar novo cliente e mostrar na tela.
 * @author faculdade.ads
 */
public class ClienteIO {
    /**
     * método que cria um objeto com informações digitadas pelo usuário.
     * @return ClienteBO
     */
    public static ClienteBO getInstance(){
        System.out.println("Código: ");
        int codigo = Teclado.lerInt();
         System.out.println("Nome: : ");
        String nome = Teclado.lerString();
         System.out.println("Telefone: ");
        String telefone = Teclado.lerString();
       System.out.println("e-mail: ");
        String email = Teclado.lerString();
        System.out.println("renda :");
        double renda = Teclado.lerDouble();
        CPFBO cpf = CPFIO.getInstance();
        EnderecoBO endereco = EnderecoIO.getInstance();
        
        return new ClienteBO(codigo, nome, telefone, email, cpf, endereco, renda);
    }
    /**
     * método cria saidas de tela com dados de cliente criado.
     * @param  c ClienteBO
     * 
     */
    public static void printCliente(ClienteBO c){
        System.out.println("Codigo :"+c.getCodigo());
        System.out.println("Nome :"+c.getNome());
        System.out.println("Telefone :"+c.getTelefone());
        System.out.println("email :"+c.getMail());
        System.out.println("renda :" + c.getRenda());
        System.out.println("");
        CPFIO.printCPF(c.getCpf());
        EnderecoIO.printEndereco(c.getEndereco());
        
    }
    /**Método que cria um arrayList do tipo ClienteBO mostrando na tela todos clientes criados.
     * 
     * @param  lista  ClienteBO
     */
    public static void printList(ArrayList <ClienteBO> lista){
        System.out.println("lista de clientes :");
        for(ClienteBO cadaCliente: lista){
        printCliente(cadaCliente);
            System.out.println("------------------");
        }
        
    }
    
}