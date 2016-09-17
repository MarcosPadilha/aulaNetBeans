/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

import controle.FornecedorCL;
import persistencia.FornecedorBD;
import visao.Teclado;

/**
 *
 * @author Marcos
 */
public class FornecedorMN {
    /**
     * método que cria um menu principal com cadastrar fornecedores, listar e voltar.
     * @return 
     */
    public static int showMenu(){
        System.out.println("Módulo de fornecedores :");
        int opcao = 0;
        do{
        System.out.println("digite 1 para cadastrar fornecedor  ");
        System.out.println("digite 2 para listar os fornecedores "); 
        System.out.println("digite 3 para buscar fornecedor por código");
        System.out.println("digite 4 para atualizar fornecedor");
        System.out.println("dogite 5 para deletar Fornecedor");
        System.out.println("digite 0 para voltar");
        System.out.println("informe uma ação :");
            opcao = Teclado.lerInt();
        } while(opcao <0 || opcao >4);
        
        
        return opcao;
        
    }
    /**
     * executa o menu criado acima e realiza as opções. 
     */
    public static void execute(){
    int opcao;
    String saida;
    int codigo;
    do{
           opcao=showMenu();
       
        switch(opcao){
            case 1:
                if(FornecedorCL.newFornecedor()){
                  System.out.println("fornecedor salvo com sucesso.");
                }else{
                    System.out.println("não foi possível salvar o fornecedor");
                }
                System.out.println("Pressiona enter para continuar ");
                saida = Teclado.lerString();
                break;
            case 2:
                FornecedorCL.showFornecedores();
                System.out.println("pressione enter para continuar");
              saida = Teclado.lerString();
              break;
            case 3:
                System.out.println("dódigo do fornecedor para ua busca");
                codigo = Teclado.lerInt();
                FornecedorCL.findFornecedorCodigo(codigo);
                System.out.println("pressione enter para conrinuar");
                saida = Teclado.lerString();
                break;
            case 4:
                if(FornecedorCL.updateFornecedor()){
                    System.out.println("Cliente atualizado com sucesso");
                }else{
                    System.out.println("Problemas ao atualizar");
                }
                     System.out.println("pressione enter para conrinuar");
                     saida = Teclado.lerString();
                 break;
            case 5:
                System.out.println("dogite o codigo do fornecedor que deseja deletar");
                codigo = Teclado.lerInt();
                if(  FornecedorCL.deleteFornecedor(opcao)){
                    System.out.println("Fornecedor deletado com sucesso");
                }else{
                    System.out.println("problemas ao excluir");
                }
              
                 System.out.println("pressione enter para conrinuar");
                saida = Teclado.lerString();
                break;
        }
    }while(opcao!=0);       
            
    
    }
    
}
