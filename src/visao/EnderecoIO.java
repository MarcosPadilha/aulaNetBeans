/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import negocio.EnderecoBO;

/**
 *
 * @author faculdade.ads
 */
public class EnderecoIO {
    /**
     * método que pede ao usuario todos os dados referentes ao endereço
     * @return objeto da classe EnderecoBO com todos parâmetros dentro
     */
     public static EnderecoBO getInstance(){
         System.out.println("estado(sigla)");
         String estado = Teclado.lerString();
         System.out.println("cidade: ");
         String cidade = Teclado.lerString();
         System.out.println("bairro: ");
         String bairro = Teclado.lerString();
         System.out.println("cep: ");
         String cep = Teclado.lerString();
         System.out.println("logradouro: ");
         String logradouro = Teclado.lerString();
         System.out.println("numero: ");
         int numero = Teclado.lerInt();
         System.out.println("complemento:");
         String complemento = Teclado.lerString();
         return new EnderecoBO(estado, cidade,bairro, cep,logradouro,numero, complemento );
         
         
    }
    public static void printEndereco(EnderecoBO e){
        System.out.println("Logradouro :"+e.getLogradouro());
        System.out.println("Numero :"+e.getNumero());
        System.out.println("Complemento :"+e.getComplemento());
        System.out.println("Cep :"+e.getCep());
        System.out.println("Bairro :"+e.getBairro());
        System.out.println("cidade :"+e.getCidade());
        System.out.println("Estado :"+e.getEstado());
    
    }
  
} 