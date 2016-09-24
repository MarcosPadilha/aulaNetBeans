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
public class ProdutoVendaBO {
    private int codigoVenda;
    private ProdutoBO produto;
    private int quantidade;

    public ProdutoVendaBO(int codigoVenda, ProdutoBO produto, int quantidade) {
        this.codigoVenda = codigoVenda;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public ProdutoBO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoBO produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
