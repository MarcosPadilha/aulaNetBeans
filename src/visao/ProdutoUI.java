/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProdutoCL;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ProdutoBO;

/**
 *
 * @author faculdade.ads
 */
public class ProdutoUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProdutoUI
     */
    public ProdutoUI() {
        initComponents();
    }
    public ProdutoBO readProduto(){
         int codigo= Integer.parseInt(txtCodigoProduto.getText());
         String nome = txtNomeProduto.getText();
         Double estoque = Double.parseDouble(txtEstoque.getText());
         Double seguranca =   Double.parseDouble(txtEstoqueSeguranca.getText());
         Double compra = Double.parseDouble(txtValorCompra.getText());
         Double venda = Double.parseDouble(txtValorVenda.getText());
     return new ProdutoBO(codigo, nome, estoque, seguranca, compra, venda);
     
    }
    
    public  void LimpaTelaProdutos(){
    txtCodigoProduto.setText("");
    txtNomeProduto.setText("");
    txtEstoque.setText("");
    txtEstoqueSeguranca.setText("");
    txtValorCompra.setText("");
    txtValorVenda.setText("");
        
    }
    
    
     public void CriaTabelaVazia(){
    DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("estoque");
       modelo.addColumn("Valor Compra");
      modelo.addColumn("Valor Venda");
      tblProduto.setModel(modelo);
    }
      public void CriaTabelaPesquisa(ProdutoBO produto){
        ProdutoBO c = produto;
    DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("estoque");
      modelo.addColumn("Valor compra");
      modelo.addColumn("Valor venda");
      tblProduto.setModel(modelo);
      
        modelo.addRow(new Object[] {
        c.getCodigo(), c.getNome(), c.getEstoque(), c.getValorCompra(), c.getValorVenda()
        });
        
            tblProduto.setModel(modelo);
            
    }
    public void retrieveProdutos(){
  DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("Estoque");
      modelo.addColumn("Valor Compra");
      modelo.addColumn("Valor venda");
        
        for(ProdutoBO c: ProdutoCL.showProdutos()){
        modelo.addRow(new Object[] {
        c.getCodigo(), c.getNome(), c.getEstoque(), c.getValorCompra(), c.getValorVenda()
        });
        }
            tblProduto.setModel(modelo);
        
    }
    
    public  void WriteProduto(ProdutoBO p){
    txtCodigoProduto.setText(String.valueOf(p.getCodigo()));
    txtNomeProduto.setText(p.getNome());
    txtEstoque.setText(String.valueOf(p.getEstoque()));
    txtEstoqueSeguranca.setText(String.valueOf(p.getEstoqueSegurança()));
    txtValorCompra.setText(String.valueOf(p.getValorCompra()));
    txtValorVenda.setText(String.valueOf(p.getValorVenda()));
    
    
    }
    public boolean verificaCampos(){
        if(txtCodigoProduto.getText().length() <=0 || txtNomeProduto.getText().length() <= 0 || txtEstoque.getText().length() <= 0 || txtEstoqueSeguranca.getText().length()<=0 || txtValorCompra.getText().length()<=0 || txtValorVenda.getText().length()<=0 ){
        return false;

        }else{
            return true;
        }
    
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblEstoque = new javax.swing.JLabel();
        lblEstoqueSeguranca = new javax.swing.JLabel();
        lblValorCompra = new javax.swing.JLabel();
        lblValorVenda = new javax.swing.JLabel();
        txtCodigoProduto = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        txtEstoque = new javax.swing.JTextField();
        txtEstoqueSeguranca = new javax.swing.JTextField();
        txtValorCompra = new javax.swing.JTextField();
        txtValorVenda = new javax.swing.JTextField();
        btnLimpaCampos = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnLimpaTabela = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblNome.setText("Nome:");

        lblCodigo.setText("Código:");

        lblEstoque.setText("Estoque:");

        lblEstoqueSeguranca.setText("Estoque de segurança:");

        lblValorCompra.setText("Valor Compra:");

        lblValorVenda.setText("Valor venda:");

        txtValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorVendaActionPerformed(evt);
            }
        });

        btnLimpaCampos.setText("Limpa campos");
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.jpg"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblValorVenda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblValorCompra)
                            .addGap(53, 53, 53)
                            .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEstoqueSeguranca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstoqueSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(btnLimpaCampos)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigo))
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstoque)
                            .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstoqueSeguranca)
                            .addComponent(txtEstoqueSeguranca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpaCampos))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValorCompra)
                            .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValorVenda)
                            .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_disk_22124.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EXCLUIR.fw.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ATUALIZAR.fw.png"))); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        btnLimpaTabela.setText("Limpa tabela");
        btnLimpaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaTabelaActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(28, 28, 28)
                .addComponent(btnAtualizar)
                .addGap(48, 48, 48)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpaTabela)
                .addGap(40, 40, 40))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnListar)
                            .addComponent(btnLimpaTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaActionPerformed

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaCamposActionPerformed
    LimpaTelaProdutos();
    }//GEN-LAST:event_btnLimpaCamposActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       if(verificaCampos() ){
           if(ProdutoCL.newProduto(readProduto())){
               JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
               LimpaTelaProdutos();
           }else{
           JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
           }
       }else{
       JOptionPane.showMessageDialog(null, "Preencha corretamente os campos");
       
       }
       retrieveProdutos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
int codigo= Integer.parseInt(txtCodigoProduto.getText());
    if(ProdutoCL.deleteProduto(codigo)){
    int linha = tblProduto.getSelectedRow();
        ((DefaultTableModel) tblProduto.getModel()).removeRow(linha);
         LimpaTelaProdutos();
    
    }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
         if(tblProduto.getSelectedRow()>-1){
            int linha = tblProduto.getSelectedRow();
            DefaultTableModel conteudo = (DefaultTableModel) tblProduto.getModel();
            ProdutoBO c = ProdutoCL.findProdutoCodigo(Integer.valueOf(conteudo.getValueAt(linha, 0).toString()));
            WriteProduto(c);
          
        }
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       if(ProdutoCL.updateProduto(readProduto())){
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
             LimpaTelaProdutos();
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            
        }
            retrieveProdutos();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLimpaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaTabelaActionPerformed
      CriaTabelaVazia();
    }//GEN-LAST:event_btnLimpaTabelaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       int codigo= Integer.parseInt(txtCodigoProduto.getText());
       
     ProdutoBO p =   ProdutoCL.findProdutoCodigo(codigo);
       WriteProduto(p);
       
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
       retrieveProdutos();
    }//GEN-LAST:event_btnListarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.JButton btnLimpaTabela;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblEstoqueSeguranca;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblValorCompra;
    private javax.swing.JLabel lblValorVenda;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtEstoqueSeguranca;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtValorCompra;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
}
