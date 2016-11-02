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
 * @author Marcos
 */
public class ProdutoMN {
    
    public static int showMenu(){
        int opcao = 0;
        System.out.println("Módulo para produtos: ");
        do{
             System.out.println("1- para cadastrar prduto");
            System.out.println("2- para consultar por código");
            System.out.println("3- para consultar por valor de compra  máximo");
            System.out.println("4- para consulta por valor de no mínimo");        
            System.out.println("5- para listar os produtos");
            System.out.println("6- para alterar um produto");
            System.out.println("7- para deletar um produto");
            System.out.println("0- para voltar");
            
              System.out.println("informe uma ação: ");
            opcao = Teclado.lerInt();
        }while(opcao <0 || opcao >7);
            return opcao;
        
        
    
    
    }
    public static void execute(){
    
    int opcao = 0;
        int codigo;
        String saida;
        double valor=0;
        do{
            opcao = showMenu();
            switch(opcao){
                    case 1:
                        if(ProdutoCL.newProduto()){// novo produto
                            System.out.println("Produto salvo com sucesso");
                        }else{
                            System.out.println("Não foi possível salvar o produto");
                        }
                        System.out.println("pressione enter para continuar");
                                 saida = Teclado.lerString();
                        break;
                    case 2://buscar produto
                        System.out.println("Digite o código do produto para buscar");
                        codigo = Teclado.lerInt();
                        ProdutoCL.findProdutoCodigo(codigo);
                        System.out.println("Digite enter para continuar:");
                        saida = Teclado.lerString();
                        break;
                    case 3://buscar produtos com preço até...
                        System.out.println("Informe o valor máximo do produto :");
                        valor = Teclado.lerDouble();
                        ProdutoCL.findProdutoValorCompra(valor, 1);
                         System.out.println("Digite enter para continuar:");
                        saida = Teclado.lerString();
                        break;
                    case 4:// buscar produtos com valor no minimo de...
                        System.out.println("Informe o valor mínimo do produto");
                        valor = Teclado.lerDouble();
                        ProdutoCL.findProdutoValorCompra(valor, 2);
                        System.out.println("Digite enter para continuar:");
                        saida = Teclado.lerString();
                        break;
                        
                    case 5:// listar produto
                        ProdutoCL.showProdutos();
                        System.out.println("Digite enter para continuar:");
                        saida = Teclado.lerString();
                        break;
                        /*
                    case 6:// atualizar produto
                       if(ProdutoCL.updateProduto()){
                           System.out.println("Prodotu alterado com sucesso ");
                       }else{
                           System.out.println("Erro ao alterar produto");
                       }
                        System.out.println("Pressione enter para continuar");
                         saida = Teclado.lerString();
                        break;
*/
                   case 7://deletar
                       System.out.println("Digite o codigo para busca :");
                        codigo = Teclado.lerInt();
                       if(ProdutoCL.deleteProduto(codigo)){
                            System.out.println("Produto deletado com sucesso");
                            
                        }else{
                            System.out.println("erro ao deletar produto");
                       }
                        
                        System.out.println("Pressione enter para continuar");
                       saida = Teclado.lerString();
                       break;
                        
                    
        
        
            }
        
        }while(opcao!=0);
        
        
    }
    
}
