/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author faculdade.ads
 */
public class CPFBO {
    private String numero;

    public CPFBO(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public boolean isValid(){
        //to do: ajustar metodo
        return true;
        
    }
   
    
}
