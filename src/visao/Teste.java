/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;


import controle.ClienteCL;
import controle.VendaCL;
import java.util.ArrayList;
import negocio.CPFBO;
import negocio.ClienteBO;
import negocio.EnderecoBO;
import persistencia.ClienteBD;
import persistencia.FornecedorBD;
import visao.menu.ClienteMN;
import visao.menu.FornecedorMN;
import visao.menu.MenuGeral;
import visao.menu.ProdutoMN;


/**
 *
 * @author Marcos
 */
public class Teste {
    public static void main(String[] args) {
        ClienteBD.load();
    MenuCadastros frmCliente = new MenuCadastros();
    frmCliente.setVisible(true);
        
    
    
   
    }
    
    
}
