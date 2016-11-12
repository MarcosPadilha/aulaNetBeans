/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ClienteCL;
import controle.CompraCL;
import controle.FornecedorCL;
import controle.ProdutoCL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ClienteBO;
import negocio.CompraBO;
import negocio.CompraProdutoBO;
import negocio.FornecedorBO;
import negocio.ProdutoBO;
import negocio.ProdutoVendaBO;

/**
 *
 * @author faculdade.ads
 */
public class ComprasUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form ComprasUI
     */
    public ComprasUI() {
        initComponents();
    }
    private void retrieveComboBox(){
      
    jcbFornecedores.removeAll();
    jcbFornecedores.setModel(new DefaultComboBoxModel(FornecedorCL.showFornecedores().toArray()));
   
  }
    
     public void retrieveDetalheCompra(int codigoCompra){
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("quantidade");
      modelo.addColumn("subtotal");
        
        for(CompraProdutoBO item : CompraCL.getItens(codigoCompra)){
         modelo.addRow(new Object[] {item.getProduto().getCodigo(),
         item.getProduto().getValorVenda(), item.getQuantidade(), item.getProduto().getValorVenda()*item.getQuantidade()
       
        });
        
        }
        tblCompras.setModel(modelo); 
                
    }
     
     public CompraBO readCompra(){
     int codigoCompra = Integer.parseInt(txtCodigoCompra.getText());
   
     LocalDate hoje = LocalDate.now();
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // hoje.format(formatador);
     String data =  txtDataCompra.getText();
    
     int codigoFornecedor = Integer.parseInt(txtCodigoFornecedor.getText());
    //Double.parseDouble(txtValorTotal.getText());
     
    return new CompraBO(codigoCompra, data, codigoFornecedor);
     
    }
     
     public  void  calculaTotal(){
        int qtd = 0;
         double valorAtual = 0;
         if(txtQuantidade.getText()==null || txtCodigoProduto.getText() == null){
          JOptionPane.showMessageDialog(null, "preencha todos os campos");
         }else{
          qtd =  Integer.parseInt(txtQuantidade.getText());
          
  Double valorUnit = Double.parseDouble(txtValorUnitario.getText());
 
    if(txtValorTotal.getText().isEmpty()){
     valorAtual = 0;
    }else{
     valorAtual = Double.parseDouble(txtValorTotal.getText());
    
    }
      
  double valorTotal = qtd * valorUnit;
  
  double result = valorTotal + valorAtual;
      
  txtValorTotal.setText( String.valueOf(result));
          
         }
           
    }
     
     public void CalculaRemovido(Double valor, int qtd){
    
        double total = Double.parseDouble(txtValorTotal.getText());
        Double valorParcial = valor ;
        
        Double TotalFinal = total - valorParcial;
        
        txtValorTotal.setText(String.valueOf(TotalFinal));
    
    }
     
      public CompraBO readVenda(Double valor){
     int codigoCompra = Integer.parseInt(txtCodigoCompra.getText());
     LocalDate hoje = LocalDate.now();
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // hoje.format(formatador);
     String data =  txtDataCompra.getText();
    
     int codigoCliente = Integer.parseInt(txtCodigoCompra.getText());
     double valotTotal = valor;      
    CompraBO c = CompraCL.findCompraCodigo(codigoCompra);
     c.setValorTotal(valotTotal);
     return c;
    }
      
       public CompraProdutoBO readProdutoCompra(){
     int codigoCompra =Integer.parseInt(txtCodigoCompra.getText());   
     int codigoProduto = Integer.parseInt(txtCodigoProduto.getText());
     ProdutoBO p =   ProdutoCL.findProdutoCodigo(codigoProduto);
     int quantidade = Integer.parseInt( txtQuantidade.getText()) ;
    
    return new CompraProdutoBO(codigoCompra,readProduto(),quantidade  );
    
    }
       
        public ProdutoBO readProduto(){
    int codigoProduto = Integer.parseInt(txtCodigoProduto.getText());
     ProdutoBO p =   ProdutoCL.findProdutoCodigo(codigoProduto);
    
    return p;
    
    }
        
         public boolean criaTabelaCompras(){
         DefaultTableModel modelo = new DefaultTableModel();
  modelo.addColumn("Código");
      modelo.addColumn("data");
      modelo.addColumn("Fornecedor");
       
     for(CompraBO compra : CompraCL.showCompras()){
     FornecedorBO fornecedor = FornecedorCL.findFornecedorCodigo(compra.getCodFornecedor());
      modelo.addRow(new Object[] {
      compra.getCodigoCompra(), compra.getDataCompra(),fornecedor.getNomeFantasia()
        });
                      
     }
       
        tblCompras.setModel(modelo); 
    
        
        return true;
    }
         
         public void limpaTela(){
            txtCodigoCompra.setText("");
            txtDataCompra.setText("");
            txtQuantidade.setText("");
            txtValorUnitario.setText("");
            txtValorTotal.setText("");
            txtCodigoFornecedor.setText("");
            txtCodigoProduto.setText("");
            txtDescricao.setText(""); 
            jcbFornecedores.removeAll();
         }
         
          public void criaTabelaVazia(){
     DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("quantidade");
      modelo.addColumn("subTotal");
      tblCompras.setModel(modelo);
    
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
        jPainelTopo = new javax.swing.JPanel();
        lblCodigoCompra = new javax.swing.JLabel();
        txtCodigoCompra = new javax.swing.JTextField();
        lblCodigoFornecedor = new javax.swing.JLabel();
        lblNomeFornecedor = new javax.swing.JLabel();
        txtCodigoFornecedor = new javax.swing.JTextField();
        btnFinalizarPedido = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblCodigoProduto = new javax.swing.JLabel();
        txtCodigoProduto = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnCancelarCompra = new javax.swing.JButton();
        lblValorUnitario = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        btnAbrirCompra = new javax.swing.JButton();
        jcbFornecedores = new javax.swing.JComboBox<>();
        btnLocalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDataCompra = new javax.swing.JTextField();
        btnRemoveItem = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        jPainel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        btnLimpaTabelaCompras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFornecedorPara = new javax.swing.JTextField();

        setClosable(true);

        jPainelTopo.setBackground(new java.awt.Color(204, 255, 255));

        lblCodigoCompra.setText("Código do pedido:");

        lblCodigoFornecedor.setText("Código fornecedor:");

        lblNomeFornecedor.setText("Nome fornecedor:");

        btnFinalizarPedido.setText("Finalizar Pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        lblCodigoProduto.setText("Código Produto:");

        txtCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoProdutoFocusLost(evt);
            }
        });
        txtCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProdutoActionPerformed(evt);
            }
        });

        lblDescricao.setText("Descrição do produto:");

        btnCancelarCompra.setText("Cancelar compra");
        btnCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompraActionPerformed(evt);
            }
        });

        lblValorUnitario.setText("Valor Unitário:");

        txtValorUnitario.setEditable(false);

        btnAbrirCompra.setText("Nova Compra");
        btnAbrirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCompraActionPerformed(evt);
            }
        });

        jcbFornecedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFornecedores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbFornecedoresFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbFornecedoresFocusLost(evt);
            }
        });
        jcbFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFornecedoresActionPerformed(evt);
            }
        });

        btnLocalizar.setText("Localizar pedido");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        jLabel2.setText("Data da venda:");

        txtDataCompra.setEditable(false);
        txtDataCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPainelTopoLayout = new javax.swing.GroupLayout(jPainelTopo);
        jPainelTopo.setLayout(jPainelTopoLayout);
        jPainelTopoLayout.setHorizontalGroup(
            jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addComponent(lblCodigoProduto)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addComponent(btnAbrirCompra)
                                .addGap(34, 34, 34)
                                .addComponent(btnCancelarCompra)
                                .addGap(42, 42, 42)
                                .addComponent(btnFinalizarPedido))
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblValorUnitario))
                                .addGap(32, 32, 32)
                                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelTopoLayout.createSequentialGroup()
                                        .addComponent(lblNomeFornecedor)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                                        .addComponent(lblCodigoFornecedor)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addComponent(lblCodigoCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPainelTopoLayout.setVerticalGroup(
            jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelTopoLayout.createSequentialGroup()
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoFornecedor)
                            .addComponent(txtCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeFornecedor)
                            .addComponent(jcbFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAbrirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoCompra)
                    .addComponent(txtCodigoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizar)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoProduto))
                .addGap(8, 8, 8)
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorUnitario)
                    .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnRemoveItem.setText("Remove item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        btnAddItem.setText("Add item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnRemoveItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPainelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPainelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveItem)
                    .addComponent(btnAddItem))
                .addContainerGap())
        );

        jLabel8.setText("Ítens da venda:");

        txtValorTotal.setEditable(false);

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCompras);

        btnLimpaTabelaCompras.setText("Limpa tabela");
        btnLimpaTabelaCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaTabelaComprasActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPainel2Layout = new javax.swing.GroupLayout(jPainel2);
        jPainel2.setLayout(jPainel2Layout);
        jPainel2Layout.setHorizontalGroup(
            jPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainel2Layout.createSequentialGroup()
                .addGroup(jPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8))
                    .addGroup(jPainel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 195, Short.MAX_VALUE))
            .addGroup(jPainel2Layout.createSequentialGroup()
                .addGroup(jPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4))
                    .addGroup(jPainel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtFornecedorPara, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPainel2Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(btnLimpaTabelaCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPainel2Layout.setVerticalGroup(
            jPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainel2Layout.createSequentialGroup()
                .addGroup(jPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPainel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(txtFornecedorPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPainel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpaTabelaCompras)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPainel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPainel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed

       // calculaTotal();
        CompraCL.newItemCompra(readProdutoCompra());
        CompraBO c =  CompraCL.findCompraCodigo(readProdutoCompra().getCodigoCompra());
        retrieveDetalheCompra(Integer.parseInt(txtCodigoCompra.getText()));
        c.setValorTotal(c.getValorTotal() + readProdutoCompra().getProduto().getValorVenda() * readProdutoCompra().getQuantidade());
        txtValorTotal.setText(String.valueOf(c.getValorTotal()));
        CompraCL.updateCompra(c);
        txtQuantidade.setText("");
        txtDescricao.setText("");
        txtValorUnitario.setText("");
        txtCodigoProduto.setText("");

    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed

        int linha = tblCompras.getSelectedRow();

        DefaultTableModel conteudo = (DefaultTableModel) tblCompras.getModel();
        double subTotal =(double) ( conteudo.getValueAt(linha, 3));
        int qtd =(int) ( conteudo.getValueAt(linha, 2));
        int codigoProduto = (int) ( conteudo.getValueAt(linha, 0));
        CalculaRemovido(subTotal, qtd);
        int codigoCompra = Integer.parseInt(txtCodigoCompra.getText());
        ProdutoBO pd = ProdutoCL.findProdutoCodigo(codigoProduto);

        CompraProdutoBO p = new CompraProdutoBO(codigoCompra,pd, qtd);

        CompraCL.removeItem(p.getCodigoCompra());

        ((DefaultTableModel) tblCompras.getModel()).removeRow(linha);

    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void txtDataCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataCompraActionPerformed

    }//GEN-LAST:event_txtDataCompraActionPerformed

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        Double valor = Double.parseDouble(txtValorTotal.getText());
        CompraCL.updateCompra(readVenda(valor));

        int codigo = Integer.parseInt(txtCodigoCompra.getText());
        CompraCL.atualizarEstoque(codigo);
        CompraBO compra = CompraCL.findCompraCodigo(codigo);
      
        limpaTela();
        criaTabelaVazia();
       

    }//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void txtCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProdutoFocusLost

        ProdutoBO p = ProdutoCL.findProdutoCodigo(Integer.parseInt(txtCodigoProduto.getText()));
        if(p!=null){
            txtDescricao.setText(p.getNome());
            txtValorUnitario.setText(String.valueOf(p.getValorVenda()));

        }else{
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }

    }//GEN-LAST:event_txtCodigoProdutoFocusLost

    private void txtCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProdutoActionPerformed

    }//GEN-LAST:event_txtCodigoProdutoActionPerformed

    private void btnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompraActionPerformed
        CompraCL.delete(Integer.parseInt(txtCodigoCompra.getText()));
        limpaTela();
        criaTabelaVazia();

    }//GEN-LAST:event_btnCancelarCompraActionPerformed

    private void btnAbrirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCompraActionPerformed

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        txtDataCompra.setText(String.valueOf(hoje.format(formatador)));
        CompraCL.newCompra(readCompra());
        txtFornecedorPara.setText("");

    }//GEN-LAST:event_btnAbrirCompraActionPerformed

    private void jcbFornecedoresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbFornecedoresFocusGained
        retrieveComboBox();

    }//GEN-LAST:event_jcbFornecedoresFocusGained

    private void jcbFornecedoresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbFornecedoresFocusLost
        FornecedorBO f = FornecedorCL.findFornecedorNome(jcbFornecedores.getSelectedItem().toString());
        txtCodigoFornecedor.setText(String.valueOf(f.getCodigo()));
    }//GEN-LAST:event_jcbFornecedoresFocusLost

    private void jcbFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFornecedoresActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        //  criaTabelaVendas();
        retrieveDetalheCompra(Integer.parseInt(txtCodigoCompra.getText()));
        CompraBO c =  CompraCL.findCompraCodigo(Integer.parseInt(txtCodigoCompra.getText()));
        txtValorTotal.setText(String.valueOf(c.getValorTotal()));
        txtDataCompra.setText(c.getDataCompra());
        FornecedorBO nome = FornecedorCL.findFornecedorNome(String.valueOf(c.getCodFornecedor()));
        txtFornecedorPara.setText(nome.getNomeFantasia());
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnLimpaTabelaComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaTabelaComprasActionPerformed
        txtValorTotal.setText("");
        criaTabelaVazia();
    }//GEN-LAST:event_btnLimpaTabelaComprasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCompra;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancelarCompra;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnLimpaTabelaCompras;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPainel2;
    private javax.swing.JPanel jPainelTopo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbFornecedores;
    private javax.swing.JLabel lblCodigoCompra;
    private javax.swing.JLabel lblCodigoFornecedor;
    private javax.swing.JLabel lblCodigoProduto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNomeFornecedor;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTextField txtCodigoCompra;
    private javax.swing.JTextField txtCodigoFornecedor;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtDataCompra;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedorPara;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
