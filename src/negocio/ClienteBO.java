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
public class ClienteBO {
   private int codigo;
   private String nome;
   private String telefone;
   private String eMail;
   private CPFBO cpf;
   private EnderecoBO endereco;
   private double renda;

    
   

    public ClienteBO(int codigo, String nome, String telefone, String eMail, CPFBO cpf, EnderecoBO endereco, double renda) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.eMail = eMail;
        this.cpf = cpf;
        this.endereco = endereco;
        this.renda = renda;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public CPFBO getCpf() {
        return cpf;
    }

    public void setCpf(CPFBO cpf) {
        this.cpf = cpf;
    }

    public EnderecoBO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBO endereco) {
        this.endereco = endereco;
    }
    
  

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }
   @Override
    public String toString(){

    return getNome();
}
    
 
    

    
    
    
    
    
    
}
