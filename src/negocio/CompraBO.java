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
public class CompraBO {
    private int codigoCompra;
    private String dataCompra;
    private int codFornecedor;
    private double ValorTotal;

    public CompraBO(int codigoCompra, String dataCompra, int codFornecedor) {
        this.codigoCompra = codigoCompra;
        this.dataCompra = dataCompra;
        this.codFornecedor = codFornecedor;
        
        
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoVenda) {
        this.codigoCompra = codigoVenda;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }
    
    
    
}
