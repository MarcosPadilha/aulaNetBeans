/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author faculdade.ads
 */
public class VendaBO {
   
    private int codigoVenda;
    private String dataVenda;
    private int codigoCliente;
    private Double valorTotal;

    public VendaBO(int codigoVenda, String dataVenda, int codigoCliente, double valorTotal) {
        this.codigoVenda = codigoVenda;
        this.dataVenda = dataVenda;
        this.codigoCliente = codigoCliente;
        this.valorTotal = valorTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
   
    
      
    
}
