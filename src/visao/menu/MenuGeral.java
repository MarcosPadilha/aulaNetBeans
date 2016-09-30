/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

import visao.Teclado;

/**
 *
 * @author faculdade.ads
 */
public class MenuGeral {
    public static int showMenu(){
        int opcao;
        do{
            System.out.println("Controle de estoque");
            System.out.println("1- Módulo de clientes");
            System.out.println("2- Módulo de fornecedores");
            System.out.println("3- Módulo de produtos");
            System.out.println("4- Módulo de vendas");
            System.out.println("5- Módulo de compras");
            System.out.println("0- para sair");
            System.out.println("Selecione um módulo");
            opcao = Teclado.lerInt();
            
        }while(opcao <0 || opcao>5);
      
    
      return opcao;
    }
    
    public static void execute(){
    int opcao;
        do{
              opcao = showMenu();
              switch(opcao){
                  case 1:
                      ClienteMN.execute();
                      break;
                  case 2:
                      FornecedorMN.execute();
                      break;
                  case 3:
                      ProdutoMN.execute();
                  case 4:
                      VendaMN.execute();
                      break;
                  case 5:
                      CompraMN.execute();
                   break;
                   
                      
              
              }
              


        }while(opcao!=0);
        
    }
    
    
}