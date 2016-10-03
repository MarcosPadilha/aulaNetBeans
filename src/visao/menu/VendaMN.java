/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

import controle.ProdutoCL;
import controle.VendaCL;
import visao.Teclado;

/**
 *
 * @author faculdade.ads
 */
public class VendaMN {
    public static int showMenu(){
        int opcao;
        do{
        System.out.println("Digite 1 para cadastrar uma venda");
        System.out.println("Digite 2 para listar todas as vendas");
        System.out.println("Digite 3 para buscar venda por codigo");
        System.out.println("Digite 4 para buscar por produtos vendidos");
        System.out.println("Digite 0 para sair");
        opcao = Teclado.lerInt();
        return opcao;
        }while(opcao<0 | opcao>4);
    }
    public static void execute(){
        int opcao = showMenu();
        String saida;
        double valor;
        int codigo;
            switch(opcao){
                case 1:
                    VendaCL.newVenda();
                    break;
                case 2:
                    VendaCL.showVendas();
                      System.out.println("pressione enter para continuar ");
                            saida = Teclado.lerString();
                    break;
                case 3:
                    System.out.println("Código da venda para sua busca: ");
                            codigo = Teclado.lerInt(); 
                            VendaCL.findVendaCodigo(codigo);
                            System.out.println("pressione enter para continuar ");
                            saida = Teclado.lerString();
                case 4:
                    System.out.println("método ainda não implementado");
                    System.out.println("Digite o código da venda:");
                    codigo = Teclado.lerInt();
                    
            }
    
 
    }
    
}
