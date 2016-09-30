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
public class CompraProdutoBO {
    
    private int codigoCompra;
    private ProdutoBO produto;
    private int quantidade;

    public CompraProdutoBO(int codigoCompra, ProdutoBO produto, int quantidade) {
        this.codigoCompra = codigoCompra;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
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
