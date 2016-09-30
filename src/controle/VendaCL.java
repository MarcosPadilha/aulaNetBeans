/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import negocio.ProdutoVendaBO;
import negocio.VendaBO;
import persistencia.ProdutoVendaBD;
import persistencia.VendaBD;
import visao.ProdutoVendaIO;
import visao.Teclado;
import visao.VendaIO;

/**
 *
 * @author tecnico.ti
 */
public class VendaCL {
    
    public static  void newVenda(){
        String finalizar;
    VendaBO venda = VendaIO.getInstance();
        if(VendaBD.save(venda)){
        ProdutoVendaBO item;
        
            do{
                item = ProdutoVendaIO.getInstance(venda.getCodigoVenda());
                
                ProdutoVendaBD.save(item);
                System.out.println("Continuar? s/n");
                finalizar = Teclado.lerString();
                
            }while(!(finalizar.equalsIgnoreCase("n")));
        
        }
    }
     public static void findClienteCodigo( int codigo){
        VendaBO v = VendaBD.findVendaCodigo(codigo);
        if(v!=null){
         VendaIO.printVenda(v);  
        }else{//depois troca por exceção
            System.out.println("nao encontrado ");  
        }
    
    
    
    
    }
}
