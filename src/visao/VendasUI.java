/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ClienteCL;
import controle.ProdutoCL;
import controle.VendaCL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ClienteBO;
import negocio.ProdutoBO;
import negocio.ProdutoVendaBO;
import negocio.VendaBO;

/**
 *
 * @author faculdade.ads
 */
public class VendasUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form VendasUI
     */
    public VendasUI() {
        initComponents();
    }
    
   public static VendaBO venda;
    
    public int pegaCodigo(int codigo){
    
        
        return codigo;
    }
    
    public void pegarItens(){
        if(tblItens.getSelectedRow()>-1){
            int linha = tblItens.getSelectedRow();
            DefaultTableModel conteudo = (DefaultTableModel) tblItens.getModel();
            VendaBO v = VendaCL.findVendaCodigo(Integer.valueOf(conteudo.getValueAt(linha, 0).toString()));
            VendaCL.getItens(v.getCodigoVenda());
                 
         }
    }
    
    public void retrieveDetalheVenda(int codigoVenda){
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("quantidade");
      modelo.addColumn("subtotal");
        
        for(ProdutoVendaBO item : VendaCL.getItens(codigoVenda)){
         modelo.addRow(new Object[] {item.getProduto().getCodigo(),
         item.getProduto().getValorVenda(), item.getQuantidade(), item.getProduto().getValorVenda()*item.getQuantidade()
       
        });
        
        }
        tblItens.setModel(modelo); 
                
    }
     
    /**
     * mostra os clientes no combo box de cliente
     */
    private void retrieveComboBox(){
      
    jcbClientes.removeAll();
    jcbClientes.setModel(new DefaultComboBoxModel(ClienteCL.showClientes().toArray()));
   
  }
    
    /**
     * 
     */
  public void  MostraProdutosDaVenda(){
      if(tblItens.getSelectedRow()>-1){
            int linha = tblItens.getSelectedRow();
            
                   
        }
    
    }
    /**
     * limpa campos
     */
    public void LimpaTela(){
    txtCodigoVenda.setText("");
    txtDataVenda.setText("");
    txtQuantidade.setText("");
    txtValorUnitario.setText("");
    txtValorTotal.setText("");
    txtCodigoCliente.setText("");
    txtCodigoProduto.setText("");
    txtDescricao.setText("");  
    }
    /**
     * cria tabela vazia
     */
    public void criaTabelaVazia(){
     DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("quantidade");
      modelo.addColumn("subTotal");
      tblItens.setModel(modelo);
    
    }
    
   
    /**
     * cria tabela com todas as vendas
     * @return 
     */
    public boolean criaTabelaVendas(){
         DefaultTableModel modelo = new DefaultTableModel();
  modelo.addColumn("Código");
      modelo.addColumn("data");
      modelo.addColumn("Cliente");
       
     for(VendaBO venda : VendaCL.showVendas()){
     ClienteBO cliente = ClienteCL.findClienteCodigo(venda.getCodigoCliente());
      modelo.addRow(new Object[] {
      venda.getCodigoVenda(), venda.getDataVenda(), cliente.getNome()
        });
                      
     }
       
        tblItens.setModel(modelo); 
    
        
        return true;
    }
    /**
     * grava produtos vendidos na BD
     * @return boolean
     */
    
    public   boolean gravaItens(){
        for(int i=0; i<=tblItens.getRowCount(); i++){
        int linha = i;
    
            DefaultTableModel conteudo = (DefaultTableModel) tblItens.getModel();
            
            ProdutoBO p =  ProdutoCL.findProdutoCodigo(Integer.valueOf(conteudo.getValueAt(linha, 0).toString()));
            int quantidade = Integer.valueOf(conteudo.getValueAt(linha, 2).toString());
            int codigo = Integer.valueOf(txtCodigoVenda.getText()) ;
            ProdutoVendaBO pv=  new ProdutoVendaBO(codigo, p,quantidade);
            VendaCL.salvaProdutosVendidos(pv);
                         
        }
    
            return true;
    }
    
    /**
     * Cada vez que um produto é adicionado na tabela, o método
     * calcula o total do pedido e coloca no campo valor total.
     */
    
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
    
    /**
     * quando um produto é removido da tabela, o método subtrai esse ítem do pedido e do valor total.
     * @param valor Double
     * @param qtd int
     */
    public void CalculaRemovido(Double valor, int qtd){
    
        double total = Double.parseDouble(txtValorTotal.getText());
        Double valorParcial = valor ;
        
        Double TotalFinal = total - valorParcial;
        
        txtValorTotal.setText(String.valueOf(TotalFinal));
    
    }
    
   
 
     
    /**
     * lê dados dos campos e cria um objeto tipo vendaBO
     * @return VendaBO
     */
     
     
    public VendaBO readVenda(){
     int codigoVenda = Integer.parseInt(txtCodigoVenda.getText());
   
   LocalDate hoje = LocalDate.now();
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // hoje.format(formatador);
    String data =  txtDataVenda.getText();
    
    int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
    double valotTotal = 0; //Double.parseDouble(txtValorTotal.getText());
     
    return new VendaBO(codigoVenda, data, codigoCliente, valotTotal);
     
    }
    /**
     * finaliza a venda com valot total e ítens
     * @param valor
     * @return VendaBO
     */
    
     public VendaBO readVenda(Double valor){
     int codigoVenda = Integer.parseInt(txtCodigoVenda.getText());
    Date dataAgora = new Date();
    dataAgora.getDate();
    String data = String.valueOf(txtDataVenda);
    
     int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
     double valotTotal = valor;      
     return new VendaBO(codigoVenda, data, codigoCliente ,valotTotal);
     
    }
    
    
    
    
    public ProdutoVendaBO readProdutoVenda(){
     int codigoVenda =Integer.parseInt(txtCodigoVenda.getText());   
     int codigoProduto = Integer.parseInt(txtCodigoProduto.getText());
     ProdutoBO p =   ProdutoCL.findProdutoCodigo(codigoProduto);
     int quantidade = Integer.parseInt( txtQuantidade.getText()) ;
    
    return new ProdutoVendaBO(codigoVenda,readProduto(),quantidade  );
    
    }
    
    /**
     * Lê o campo do código e acha o objeto ProdutoBO.
     * @return ProdutoBO
     */
    public ProdutoBO readProduto(){
    int codigoProduto = Integer.parseInt(txtCodigoProduto.getText());
     ProdutoBO p =   ProdutoCL.findProdutoCodigo(codigoProduto);
    
    return p;
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelTopo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        btnFecharVenda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDescricao = new javax.swing.JTextField();
        btnCancelarVenda = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        btnAbrirVenda = new javax.swing.JButton();
        jcbClientes = new javax.swing.JComboBox<>();
        btnBuscaVendas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        txtValorTotal = new javax.swing.JTextField();
        lblValorTotal = new javax.swing.JLabel();
        btnLimpaTabela = new javax.swing.JButton();
        txtCLientePara = new javax.swing.JTextField();
        lblCLientePara = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JTextField();
        btnAddItem = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPainelTopo.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Código do pedido:");

        jLabel4.setText("Código cliente:");

        jLabel5.setText("Nome Cliente:");

        btnFecharVenda.setText("Finalizar Pedido");
        btnFecharVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharVendaActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        jLabel6.setText("Código Produto:");

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

        jLabel7.setText("Descrição do produto:");

        btnCancelarVenda.setText("cancelar venda");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor Unitário:");

        txtValorUnitario.setEditable(false);

        btnAbrirVenda.setText("Novo Pedido");
        btnAbrirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirVendaActionPerformed(evt);
            }
        });

        jcbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbClientesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcbClientesFocusLost(evt);
            }
        });
        jcbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClientesActionPerformed(evt);
            }
        });

        btnBuscaVendas.setText("Localizar pedido");
        btnBuscaVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaVendasActionPerformed(evt);
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
                                .addComponent(jLabel3)
                                .addGap(40, 40, 40)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addComponent(btnAbrirVenda)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarVenda)
                                .addGap(59, 59, 59)
                                .addComponent(btnFecharVenda))
                            .addGroup(jPainelTopoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(150, 150, 150)))
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelTopoLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPainelTopoLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(27, 27, 27)
                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(jPainelTopoLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPainelTopoLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBuscaVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPainelTopoLayout.setVerticalGroup(
            jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAbrirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFecharVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaVendas))
                .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPainelTopoLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelTopoLayout.createSequentialGroup()
                        .addGroup(jPainelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
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
        tblItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItens);

        txtValorTotal.setEditable(false);

        lblValorTotal.setText("Valor Total:");

        btnLimpaTabela.setText("Limpa tabela");
        btnLimpaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaTabelaActionPerformed(evt);
            }
        });

        lblCLientePara.setText("Cliente:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(141, 141, 141))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(btnLimpaTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValorTotal)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCLientePara, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblCLientePara, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpaTabela)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorTotal))
                .addGap(31, 31, 31)
                .addComponent(lblCLientePara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCLientePara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jLabel8.setText("Ítens da venda:");

        jLabel2.setText("Data da venda:");

        txtDataVenda.setEditable(false);
        txtDataVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataVendaActionPerformed(evt);
            }
        });

        btnAddItem.setText("Add item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnRemoveItem.setText("Remove item");
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 747, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemoveItem)
                .addGap(295, 295, 295)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataVenda)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPainelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPainelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddItem))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataVendaActionPerformed
       
    }//GEN-LAST:event_txtDataVendaActionPerformed

    private void btnAbrirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirVendaActionPerformed
     
     LocalDate hoje = LocalDate.now();
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  
     txtDataVenda.setText(String.valueOf(hoje.format(formatador)));
     VendaCL.newVenda(readVenda());
     txtCLientePara.setText("");
   
    }//GEN-LAST:event_btnAbrirVendaActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
    
        // calculaTotal();
         VendaCL.newItemVenda(readProdutoVenda()); 
         VendaBO v =  VendaCL.findVendaCodigo(readProdutoVenda().getCodigoVenda());
         retrieveDetalheVenda(Integer.parseInt(txtCodigoVenda.getText()));
          v.setValorTotal(v.getValorTotal() + readProdutoVenda().getProduto().getValorVenda() * readProdutoVenda().getQuantidade());
        txtValorTotal.setText(String.valueOf(v.getValorTotal()));
       VendaCL.updateVenda(v);
          txtQuantidade.setText("");
          txtDescricao.setText("");
          txtValorUnitario.setText("");
          txtCodigoProduto.setText("");
         
               
         
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        VendaCL.delete(Integer.parseInt(txtCodigoVenda.getText()));
        LimpaTela();
    criaTabelaVazia();
   
    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void btnFecharVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharVendaActionPerformed
       Double valor = Double.parseDouble(txtValorTotal.getText());
       VendaCL.updateVenda(readVenda(valor));
                   
       int codigo = Integer.parseInt(txtCodigoVenda.getText());
      VendaCL.atualizarEstoque(codigo);
         JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso");
        LimpaTela();
        criaTabelaVazia();
            
    }//GEN-LAST:event_btnFecharVendaActionPerformed

    private void btnLimpaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaTabelaActionPerformed
        txtValorTotal.setText("");
        criaTabelaVazia();
    }//GEN-LAST:event_btnLimpaTabelaActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
            
        
        int linha = tblItens.getSelectedRow();
        
        DefaultTableModel conteudo = (DefaultTableModel) tblItens.getModel();
        double subTotal =(double) ( conteudo.getValueAt(linha, 3));
        int qtd =(int) ( conteudo.getValueAt(linha, 2));
        int codigoProduto = (int) ( conteudo.getValueAt(linha, 0));
        CalculaRemovido(subTotal, qtd);
        int codigoVenda = Integer.parseInt(txtCodigoVenda.getText());
        ProdutoBO pd = ProdutoCL.findProdutoCodigo(codigoProduto);
        
        ProdutoVendaBO p = new ProdutoVendaBO(codigoVenda,pd, qtd);
           
         VendaCL.removeItem(p.getCodigoVenda());      
          
          ((DefaultTableModel) tblItens.getModel()).removeRow(linha);
         
              
             
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void txtCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProdutoActionPerformed
     
    }//GEN-LAST:event_txtCodigoProdutoActionPerformed

    private void jcbClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbClientesFocusGained
     retrieveComboBox();
   
    
    }//GEN-LAST:event_jcbClientesFocusGained

    private void tblItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensMouseClicked
              
               
    }//GEN-LAST:event_tblItensMouseClicked

    private void jcbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbClientesActionPerformed

    private void btnBuscaVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaVendasActionPerformed
      //  criaTabelaVendas();
        retrieveDetalheVenda(Integer.parseInt(txtCodigoVenda.getText()));
      VendaBO v =  VendaCL.findVendaCodigo(Integer.parseInt(txtCodigoVenda.getText()));
        txtValorTotal.setText(String.valueOf(v.getValorTotal()));
        txtDataVenda.setText(v.getDataVenda());
        ClienteBO nome = ClienteCL.findClienteCodigo(v.getCodigoCliente());
        txtCLientePara.setText(nome.getNome());
    }//GEN-LAST:event_btnBuscaVendasActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
    criaTabelaVazia();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProdutoFocusLost
   
        ProdutoBO p = ProdutoCL.findProdutoCodigo(Integer.parseInt(txtCodigoProduto.getText()));
        if(p!=null){
        txtDescricao.setText(p.getNome());
        txtValorUnitario.setText(String.valueOf(p.getValorVenda()));
        
        }else{
        JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
        
        
        
    }//GEN-LAST:event_txtCodigoProdutoFocusLost

    private void jcbClientesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbClientesFocusLost
ClienteBO c = ClienteCL.findCLienteNome(jcbClientes.getSelectedItem().toString());
    txtCodigoCliente.setText(String.valueOf(c.getCodigo()));       
    }//GEN-LAST:event_jcbClientesFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirVenda;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBuscaVendas;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnFecharVenda;
    private javax.swing.JButton btnLimpaTabela;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPainelTopo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcbClientes;
    private javax.swing.JLabel lblCLientePara;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtCLientePara;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtCodigoVenda;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
