/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoBO {
    private int codigo;
    private String nome;
    private double estoque;
    private double estoqueSegurança;
    private double valorCompra;
    private double valorVenda;

    public ProdutoBO(int codigo, String nome, double estoque, double estoqueSegurança, double valorCompra, double valorVenda) {
        this.codigo = codigo;
        this.nome = nome;
        this.estoque = estoque;
        this.estoqueSegurança = estoqueSegurança;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public double getEstoqueSegurança() {
        return estoqueSegurança;
    }

    public void setEstoqueSegurança(double estoqueSegurança) {
        this.estoqueSegurança = estoqueSegurança;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
    
    
}
