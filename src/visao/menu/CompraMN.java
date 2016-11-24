/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

import controle.CompraCL;
import visao.Teclado;

/**
 *
 * @author faculdade.ads
 */
public class CompraMN {
    
      public static int showMenu(){
        int opcao;
        do{
        System.out.println("Digite 1 para cadastrar uma compra");
        System.out.println("Digite 2 para buscar compra por codigo");
        System.out.println("Digite 3 para buscar todas as compras");
        System.out.println("Digite 4 para buscar produtos comprados");
        System.out.println("Digite 0 para sair");
        opcao = Teclado.lerInt();
        return opcao;
        }while(opcao<0 || opcao>4);
    }
    public static void execute(){
        int opcao = showMenu();
        String saida;
        double valor;
        int codigo;
            switch(opcao){
                case 1:
                    CompraCL.newVenda();
                     System.out.println("pressione enter para continuar ");
                            saida = Teclado.lerString();
                    break;
                case 2:
                    System.out.println("Código da venda para sua busca: ");
                            codigo = Teclado.lerInt();
                            //CompraCL.findCOmpraCodigo(codigo);
                            System.out.println("pressione enter para continuar ");
                            saida = Teclado.lerString();
                    
                    break;
                case 3:
                    CompraCL.showCompras();
                    System.out.println("pressione enter para continuar ");
                            saida = Teclado.lerString();
                    break;
                case 4:
                    System.out.println("Digite o código da venda");
                    codigo = Teclado.lerInt();
                    CompraCL.findProdutosComprados(codigo);
                    
                    
            
            }
    
 
    }
    
    
    
    
}
