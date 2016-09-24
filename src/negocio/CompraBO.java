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
    private int codigoVenda;
    private String dataCompra;
    private int codFornecedor;

    public CompraBO(int codigoVenda, String dataCompra, int codFornecedor) {
        this.codigoVenda = codigoVenda;
        this.dataCompra = dataCompra;
        this.codFornecedor = codFornecedor;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
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
