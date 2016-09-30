/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

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
        System.out.println("Digite 2 para buscar venda por codigo");
        System.out.println("Digite 0 para sair");
        opcao = Teclado.lerInt();
        return opcao;
        }while(opcao<0 | opcao>2);
    }
    public static void execute(){
        int opcao = showMenu();
        String saida;
        double valor;
            switch(opcao){
                case 1:
                    VendaCL.newVenda();
                    break;
                case 2:
                    break;
            
            
            }
    
 
    }
    
}
