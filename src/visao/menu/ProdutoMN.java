/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

import controle.ProdutoCL;
import negocio.ProdutoBO;
import visao.Teclado;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoMN {
    
    public static int showMenu(){
        int opcao = 0;
        System.out.println("Módulo para clientes: ");
        do{
             System.out.println("1- para cadastrar prduto");
            System.out.println("2- para consultar por código");
            System.out.println("3- para consultar por valor de compra  mínimo");
            System.out.println("4- para consultar por valor de compra máximo");         
            System.out.println("5- para listar os cilentes");
            System.out.println("6- para alterar um cliente");
            System.out.println("7- para deletar um cliente");
            System.out.println("0- para voltar");
            
              System.out.println("informe uma ação: ");
            opcao = Teclado.lerInt();
        }while(opcao <0 || opcao>7);
            return opcao;
        
        
    
    
    }
    public static void execute(){
    
    int opcao = 0;
        int codigo;
        String saida;
        double valor=0;
        do{
            switch(opcao){
                    case 1:
                        if(ProdutoCL.newProduto()){
                            System.out.println("Cliente salvo com sucesso");
                        }else{
                            System.out.println("Não foi possível salvar o produto");
                        }
                        System.out.println("pressione enter para continuar");
                                 saida = Teclado.lerString();
                        break;
                    case 2:
                        System.out.println("Digite o código do produto para buscar");
                        codigo = Teclado.lerInt();
                        ProdutoCL.findProdutoCodigo(codigo);
                        System.out.println("Digite enter para continuar:");
                        saida = Teclado.lerString();
                        break;
                    case 3:
                        System.out.println("Informe o valor do produto :");
                        valor = Teclado.lerDouble();
                        ProdutoCL.findProdutoValorCompra(valor, opcao);
                        
                        
                        
                        
                    
        
        
            }
        
        }while(opcao!=0);
        
        
    }
    
}
