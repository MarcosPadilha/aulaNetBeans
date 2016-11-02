/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import controle.ClienteCL;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.CPFBO;
import negocio.ClienteBO;
import negocio.EnderecoBO;

/**
 *
 * @author faculdade.ads
 */

public class ClienteUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClienteUI
     */
    public ClienteUI() {
        initComponents();
    }
    
     private static ClienteUI instancia;



    /**
     * Lê os dados digitados nos campos e coloca nas variáveis.
     * @return ClienteBO
     */
    public ClienteBO  read(){
      int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
        String nome = txtNomeCliente.getText();
        Double renda = Double.parseDouble(txtRendaCliente.getText());
         String email = txtEmailCliente.getText();
        String telefone = txtTelefoneCliente.getText();
        String estado = txtEstadoCliente.getText();
        String cidade = txtCidadeCliente.getText();
        String bairro = txtBairroCliente.getText();
        String cep = txtCepCliente.getText();
        String logradouro = txtLogradouroCliente.getText();
        int numero = Integer.parseInt(txtNumeroCliente.getText());
        String complemento = txtComplementoCliente.getText();
        String cpfCliente = txtCpfCliente.getText();
               
        EnderecoBO  endereco = new EnderecoBO(estado, cidade, bairro, cep, logradouro, numero, complemento);
        CPFBO cpf = new CPFBO(cpfCliente);
        
        ClienteBO cliente = new ClienteBO(codigoCliente, nome, telefone, email, cpf, endereco, renda );
        return cliente;
    }
    /**
     * Limpa os campos.
     */
    public void limpaTelaClientes(){
    txtCodigoCliente.setText("");
        txtNomeCliente.setText("");
        txtTelefoneCliente.setText("");
        txtEmailCliente.setText("");
        txtRendaCliente.setText("");
        txtEstadoCliente.setText("");
        txtCidadeCliente.setText("");
        txtBairroCliente.setText("");
        txtCepCliente.setText("");
        txtLogradouroCliente.setText("");
        txtComplementoCliente.setText("");
        txtNumeroCliente.setText("");
        txtCpfCliente.setText("");
    }
    /**
     * Cria tabela vazia, limpa tabela.
     */
   public void CriaTabelaVazia(){
    DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("telefone");
      modelo.addColumn("email");
      modelo.addColumn("renda");
      tblCliente.setModel(modelo);
    }
   /**
    * Cria tabela com os dados do cliente conforme objeto recebido por parâmetro.
    * @param  cliente ClienteBO
    */
    public void CriaTabelaPesquisa(ClienteBO cliente){
        ClienteBO c = cliente;
    DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("telefone");
      modelo.addColumn("email");
      modelo.addColumn("renda");
      tblCliente.setModel(modelo);
      
        modelo.addRow(new Object[] {
        c.getCodigo(), c.getNome(), c.getTelefone(), c.getMail(), c.getRenda()
        });
        
            tblCliente.setModel(modelo);
    }
    /**
     * Cria tabela com dados de todos clientes já criados.
     */
    public void retrieveClientes(){
    DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Código");
      modelo.addColumn("Nome");
      modelo.addColumn("telefone");
      modelo.addColumn("email");
      modelo.addColumn("renda");
        
        for(ClienteBO c: ClienteCL.showClientes()){
        modelo.addRow(new Object[] {
        c.getCodigo(), c.getNome(), c.getTelefone(), c.getMail(), c.getRenda()
        });
        }
            tblCliente.setModel(modelo);
        
        
    }
    /**
     * escreve na tela os dados do cliente selecionado
     * @param c 
     */
    private void WriteCliente(ClienteBO c ){
    
    txtCodigoCliente.setText(String.valueOf(c.getCodigo()));
    txtNomeCliente.setText(c.getNome());
    txtTelefoneCliente.setText(c.getTelefone());
    txtEmailCliente.setText(c.getMail());
    txtCpfCliente.setText(c.getCpf().getNumero());
    txtRendaCliente.setText(String.valueOf(c.getRenda()));
    txtEstadoCliente.setText(c.getEndereco().getEstado());
    txtCidadeCliente.setText(c.getEndereco().getCidade());
    txtBairroCliente.setText(c.getEndereco().getBairro());
    txtCepCliente.setText(c.getEndereco().getCep());
    txtLogradouroCliente.setText(c.getEndereco().getLogradouro());
    txtNumeroCliente.setText(String.valueOf(c.getEndereco().getNumero()));
    txtComplementoCliente.setText(c.getEndereco().getComplemento());
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDados = new javax.swing.JPanel();
        lblCodigoCliente = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        lblNomeCliente = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblRenda = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtEstadoCliente = new javax.swing.JTextField();
        txtCidadeCliente = new javax.swing.JTextField();
        txtCepCliente = new javax.swing.JTextField();
        txtBairroCliente = new javax.swing.JTextField();
        txtComplementoCliente = new javax.swing.JTextField();
        txtNumeroCliente = new javax.swing.JTextField();
        txtCpfCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        txtTelefoneCliente = new javax.swing.JTextField();
        txtRendaCliente = new javax.swing.JTextField();
        txtLogradouroCliente = new javax.swing.JTextField();
        btnLimpaCampos = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnLimpaTabela = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);
        setTitle("Módulo de clientes");
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

        pnlDados.setBackground(new java.awt.Color(153, 204, 255));
        pnlDados.setToolTipText("");

        lblCodigoCliente.setLabelFor(txtCodigoCliente);
        lblCodigoCliente.setText("Código:");

        txtCodigoCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClienteActionPerformed(evt);
            }
        });

        lblNomeCliente.setLabelFor(txtNomeCliente);
        lblNomeCliente.setText("Nome:");

        lblTelefone.setLabelFor(txtTelefoneCliente);
        lblTelefone.setText("Telefone:");

        lblEmail.setLabelFor(txtEmailCliente);
        lblEmail.setText("Email:");

        lblCpf.setLabelFor(txtCpfCliente);
        lblCpf.setText("CPF:");

        lblRenda.setLabelFor(txtRendaCliente);
        lblRenda.setText("Renda:");

        lblEstado.setLabelFor(txtEstadoCliente);
        lblEstado.setText("Estado:");

        lblCidade.setLabelFor(txtCidadeCliente);
        lblCidade.setText("Cidade:");

        lblBairro.setLabelFor(txtBairroCliente);
        lblBairro.setText("Bairro:");

        lblCep.setLabelFor(txtCepCliente);
        lblCep.setText("Cep:");

        lblLogradouro.setLabelFor(txtLogradouroCliente);
        lblLogradouro.setText("Logradouro:");

        lblNumero.setLabelFor(txtComplementoCliente);
        lblNumero.setText("Numero:");

        lblComplemento.setLabelFor(txtNumeroCliente);
        lblComplemento.setText("Complemento:");

        txtNomeCliente.setBackground(new java.awt.Color(204, 204, 204));

        txtEstadoCliente.setBackground(new java.awt.Color(204, 204, 204));

        txtCidadeCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtCidadeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeClienteActionPerformed(evt);
            }
        });

        txtCepCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtCepCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepClienteActionPerformed(evt);
            }
        });

        txtBairroCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtBairroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroClienteActionPerformed(evt);
            }
        });

        txtComplementoCliente.setBackground(new java.awt.Color(204, 204, 204));

        txtNumeroCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroClienteActionPerformed(evt);
            }
        });

        txtCpfCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtCpfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfClienteActionPerformed(evt);
            }
        });

        txtEmailCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtEmailCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailClienteActionPerformed(evt);
            }
        });

        txtTelefoneCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtTelefoneCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneClienteActionPerformed(evt);
            }
        });

        txtRendaCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtRendaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRendaClienteActionPerformed(evt);
            }
        });

        txtLogradouroCliente.setBackground(new java.awt.Color(204, 204, 204));
        txtLogradouroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroClienteActionPerformed(evt);
            }
        });

        btnLimpaCampos.setText("Limpa campos");
        btnLimpaCampos.setBorder(null);
        btnLimpaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDadosLayout.createSequentialGroup()
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodigoCliente)
                                    .addComponent(lblNomeCliente))
                                .addGap(11, 11, 11)
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDadosLayout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDadosLayout.createSequentialGroup()
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCpf)
                                    .addComponent(lblRenda))
                                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDadosLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDadosLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRendaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnLimpaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblCep)
                        .addGap(35, 35, 35)
                        .addComponent(txtCepCliente))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblNumero)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblLogradouro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogradouroCliente))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblComplemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplementoCliente))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBairro, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDadosLayout.createSequentialGroup()
                                .addComponent(txtEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 152, Short.MAX_VALUE))
                            .addComponent(txtBairroCliente)
                            .addComponent(txtCidadeCliente))))
                .addGap(0, 160, Short.MAX_VALUE))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addComponent(btnLimpaCampos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDadosLayout.createSequentialGroup()
                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDadosLayout.createSequentialGroup()
                            .addComponent(lblCodigoCliente)
                            .addGap(19, 19, 19)
                            .addComponent(lblNomeCliente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstado))
                        .addGap(16, 16, 16)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCidade))))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogradouro)
                            .addComponent(txtLogradouroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblComplemento)
                            .addComponent(txtComplementoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBairro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCpf)
                            .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRendaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRenda))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save_disk_22124.png"))); // NOI18N
        btnSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSalvarKeyReleased(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EXCLUIR.fw.png"))); // NOI18N
        btnExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ATUALIZAR.fw.png"))); // NOI18N
        btnAtualizar.setText("Alterar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/create-list-button_icon-icons.com_54025.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        tblCliente.setBackground(new java.awt.Color(204, 204, 255));
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCliente.setGridColor(new java.awt.Color(51, 51, 51));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        btnLimpaTabela.setText("Limpa tabela");
        btnLimpaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaTabelaActionPerformed(evt);
            }
        });

        btnPesquisar.setText("pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpaTabela)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnLimpaTabela))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    private void txtCpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfClienteActionPerformed

    private void txtEmailClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClienteActionPerformed

    private void txtCidadeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeClienteActionPerformed

    private void txtBairroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroClienteActionPerformed

    private void txtCepClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepClienteActionPerformed
        
    }//GEN-LAST:event_txtCepClienteActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
                    
            if(ClienteCL.newCliente(read())){
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
            limpaTelaClientes();
            
         }else{
              JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente");
         }
            
        retrieveClientes();
        
              
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtLogradouroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroClienteActionPerformed

    private void txtTelefoneClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneClienteActionPerformed

    private void txtRendaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRendaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRendaClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
          
    }//GEN-LAST:event_formWindowOpened

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       retrieveClientes();
       
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        retrieveClientes();
    }//GEN-LAST:event_btnListarActionPerformed

    private void txtNumeroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroClienteActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        if(tblCliente.getSelectedRow()>-1){
            int linha = tblCliente.getSelectedRow();
            DefaultTableModel conteudo = (DefaultTableModel) tblCliente.getModel();
            ClienteBO c = ClienteCL.findClienteCodigo(Integer.valueOf(conteudo.getValueAt(linha, 0).toString()));
            WriteCliente(c);
          
        }



    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        /*
        if(tblCliente.getSelectedRow()>-1){
            int linha = tblCliente.getSelectedRow();
            DefaultTableModel conteudo = (DefaultTableModel) tblCliente.getModel();
            int a =(Integer.valueOf(conteudo.getValueAt(linha, 0).toString()));
            ClienteCL.deleteCliente(a);
            
            
        }
        */
        int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
       
               
        ClienteCL.deleteCliente(codigoCliente);
        int linha = tblCliente.getSelectedRow();
        ((DefaultTableModel) tblCliente.getModel()).removeRow(linha);
          limpaTelaClientes();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
              
        if(ClienteCL.updateCliente(read())){
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
            limpaTelaClientes();
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            
        }
            retrieveClientes();
        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLimpaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaTabelaActionPerformed
       CriaTabelaVazia();
        
        
    }//GEN-LAST:event_btnLimpaTabelaActionPerformed

    private void btnLimpaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaCamposActionPerformed
        limpaTelaClientes();
    }//GEN-LAST:event_btnLimpaCamposActionPerformed

    private void btnSalvarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarKeyReleased

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
     
       
  
        
         
        
        
        
      
        
        
        
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpaCampos;
    private javax.swing.JButton btnLimpaTabela;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigoCliente;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRenda;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBairroCliente;
    private javax.swing.JTextField txtCepCliente;
    private javax.swing.JTextField txtCidadeCliente;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtComplementoCliente;
    private javax.swing.JTextField txtCpfCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEstadoCliente;
    private javax.swing.JTextField txtLogradouroCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNumeroCliente;
    private javax.swing.JTextField txtRendaCliente;
    private javax.swing.JTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
