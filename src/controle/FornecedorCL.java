/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import negocio.FornecedorBO;
import persistencia.FornecedorBD;
import visao.FornecedorIO;

/**Classe que liga as camadas de persistencia, de visão e de negocios dos fornecedores.
 *
 * @author Marcos
 */
public class FornecedorCL {
    /**
     * método que cria um objeto FornecedorBO e chama um método da classe FornecedorIO
     * chamado getInstance que traz um menu para criar um novo fornecedor. Depois cria um
     * objeto FornecedorBD invocando método save passando o objeto criado como parâmetro.
     * @return devolve um boolean
     */
    public static boolean newFornecedor(){
    FornecedorBO f =  FornecedorIO.getInstance();
    
    
    return FornecedorBD.save(f);
    
    }
    /**
     * método que chama um método da classe FornecedorIO chamado printList
     * que passa como parâmetro um metodo da classe FornecedorBD chamado getAll.
     */
    public static void showFornecedores(){
    FornecedorIO.printList(FornecedorBD.getAll());
    }
    public static void findFornecedorCodigo(int codigo){
    
       FornecedorBO b = FornecedorBD.findFornecedorCodigo(codigo);
       if(b!=null){
       FornecedorIO.printFornecedor(b);
       }else{
           System.out.println("não encontrado");
       }
        
        
        
        
        
    }
    
    public static boolean deleteFornecedor(int codigo){
    return FornecedorBD.delete(codigo);
    }
    public static boolean updateFornecedor(){
    FornecedorBO b = FornecedorIO.getInstance();
        return FornecedorBD.update(b);
    
    }
    
}
