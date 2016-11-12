/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *Classe que define o que é um fornecedor.
 * @author Marcos
 */
public class FornecedorBO {
    private int codigo;
   private String nomeFantasia;
   private String razaoSocial;
   private String telefone;
   private String eMail;
   private CNPJBO cnpj;   
   private EnderecoBO endereco;
   private String contato;

    public FornecedorBO(int codigo, String nomeFantasia, String razaoSocial, String telefone, String eMail, CNPJBO cnpj, EnderecoBO endereco, String contato) {
        this.codigo = codigo;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.eMail = eMail;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.contato = contato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public CNPJBO getCnpj() {
        return cnpj;
    }

    public void setCnpj(CNPJBO cnpj) {
        this.cnpj = cnpj;
    }

    public EnderecoBO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBO endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    @Override
    public String toString(){
    
     return getNomeFantasia();
    }
   
   
    
}
