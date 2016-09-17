/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import negocio.ProdutoBO;

/**
 *
 * @author tecnico.ti
 */
public class ProdutoIO {
    
    public static ProdutoBO getInstance(){
        System.out.println("Digite o código do produto:");
        int codigo = Teclado.lerInt();
        System.out.println("Digite o nome do produto:");
        String nome = Teclado.lerString();
        System.out.println("Digite  o estoque do produto:");
        double estoque = Teclado.lerDouble();
        System.out.println("Digite o estoque de segurança:");
        double estoqueSeguranca = Teclado.lerDouble();
        System.out.println("Digite o valor de compra:");
        double valorCompra = Teclado.lerDouble();
        System.out.println("Digite o valor da venda:");
        double valorVenda = Teclado.lerDouble();
        
        return new ProdutoBO (codigo, nome, estoque, estoqueSeguranca, valorCompra, valorVenda);
        
        
    }
    public static void printProduto(ProdutoBO p){
        System.out.println("Código: "+p.getCodigo());
        System.out.println("Nome: "+ p.getNome());
        System.out.println("Estoque: "+ p.getEstoque());
        System.out.println("Estoque de segurança: "+p.getEstoqueSegurança());
        System.out.println("Valor de compra"+p.getValorCompra());
        System.out.println("Valor de venda: "+ p.getValorVenda());
        
        
        
    } 
    
    public static void printList(ArrayList <ProdutoBO> lista){
        System.out.println("Lista de produtos");
        for(ProdutoBO produto : lista){
            printProduto(produto);
            System.out.println("--------------");
        
        }
    
    
    }
    
}
