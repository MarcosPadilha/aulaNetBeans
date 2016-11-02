/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.menu;

import controle.ClienteCL;
import persistencia.ClienteBD;
import visao.Teclado;

/**Classe que cria menu e será chamada na classe teste.
 *
 * @author faculdade.ads
 */
public class ClienteMN {
    /**
     * método que cria um menu principal com opções de cadastrar clientes, listar e voltar.
     * @return int
     */
    public static int showMenu(){
    
        System.out.println("Módulo de clientes");
        int opcao=0;
        do{
            System.out.println("1- para cadastrar cliente");
            System.out.println("2- para consultar por código");
            System.out.println("3- para consultar por renda mínima");
            System.out.println("4- para consultar por renda máxima");         
            System.out.println("5- para listar todos os cilentes");
           
            System.out.println("6- para alterar um cliente");
            System.out.println("7- para deletar um cliente");
            System.out.println("8- para buscar clientes com renda maior que 5000");
            System.out.println("9- para mostrar a media de renda dos clientes");
            System.out.println("10 -para buscar cliente com maior renda");
            System.out.println("0- para voltar");
           
            System.out.println("informe uma ação: ");
            opcao = Teclado.lerInt();
            
            
        }while(opcao < 0 || opcao > 10);
        
        return opcao;
    }
    /**
     * método que chama o menu criado acima e executa o que foi escohido.
     */
    public static void execute(){
        int opcao;
        int codigo;
        String saida;
        double renda=0;
        
            do{
                opcao = showMenu();
                    switch(opcao){
                        /*
                        case 1://novo cliente
                       
                            if(ClienteCL.newCliente()){
                                System.out.println("cliente salvo com sucesso");
                            }else{
                                System.out.println("nao foi possivel salvar o cliente");
                            }
                                 System.out.println("pressione enter para continuar");
                                 saida = Teclado.lerString();
                        break;
*/
                        case 2: //consultar 
                            System.out.println("Código de cliente para sua busca: ");
                            codigo = Teclado.lerInt();                            
                            ClienteCL.findClienteCodigo(codigo);
                            System.out.println("pressione enter para continuar ");
                            saida = Teclado.lerString();
                            break;
                        case 3: //renda minima
                            System.out.println("renda: ");// no mínimo o valor informado
                            renda = Teclado.lerDouble();
                            ClienteCL.findClienteRenda(renda, 2);
                            System.out.println("Pressione enter para continuar");
                            saida = Teclado.lerString();
                            break;
                        case 4: //renda maxima
                            System.out.println("renda: ");// no máximo o valor informado
                            renda = Teclado.lerDouble();
                            ClienteCL.findClienteRenda(renda, 1);
                            System.out.println("Pressione enter para continuar");
                            saida = Teclado.lerString();
                            break;
                           
                        case 5://listar todos
                            ClienteCL.showClientes();
                            System.out.println("pressione enter para continuar");
                            saida = Teclado.lerString();
                         break;
                        
                        case 6:
                            
// atualizar
                            //if(ClienteCL.updateCliente()){
                              //  System.out.println("Cliente alterado");
                          //  }else{
                           //     System.out.println("Problemas ao alterar");
                          //  }
                          //  System.out.println("Pressione enter ao alterar");
                          //  saida = Teclado.lerString();
                          //  break;
                            
                            case 7: //deletar
                            
                            System.out.println("digite um código para busca");
                            codigo = Teclado.lerInt();
                            if( ClienteCL.deleteCliente(codigo)){
                                System.out.println("Cliente excluído com sucesso");
                            }else{
                                System.out.println("problemas ao excluir");
                            }
                               System.out.println("pressione enter para continuar");
                              saida =Teclado.lerString();
                            break;
                            
                            case 8:
                                System.out.println("Clientes com renda maior que 5000: ");
                                ClienteCL.findRendaMaior5000();
                                
                                System.out.println("Pressione enter para continuar");
                            saida = Teclado.lerString();
                            break;
                            case 9:
                                ClienteCL.mediaRenda();
                                System.out.println("Pressione enter para continuar");
                            saida = Teclado.lerString();
                            break;
                            case 10:
                                ClienteCL.RendaMaior();
                                
                            System.out.println("Pressione enter para continuar");
                            saida = Teclado.lerString();
                            break;
                    }
                    
            }while(opcao!=0);
            
            
            
    }
    
    
    
}
