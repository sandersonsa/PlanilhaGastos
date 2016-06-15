package br.home.sanderson.controlagasto.view;

import br.home.sanderson.controlagasto.componente.CellRenderer;
import br.home.sanderson.controlagasto.componente.JTableModelDespesa;
import br.home.sanderson.controlagasto.componente.JTableModelReceita;
import br.home.sanderson.controlagasto.controle.Controle;
import br.home.sanderson.controlagasto.modelo.Despesa;
import br.home.sanderson.controlagasto.modelo.Receita;
import br.home.sanderson.controlagasto.persistencia.DaoDespesa;
import br.home.sanderson.controlagasto.persistencia.DaoReceita;
import br.home.sanderson.controlagasto.util.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Mangabit
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private Integer[] tamColunasDespesa = {80,345,80,80,50};
    private Integer[] tamColunasReceita = {350,100,80};
    private Integer referenciaSistema;

    /** Creates new form Principal */
    public TelaPrincipal() {
        initComponents();
        iniciarComboReferenciaSistema();
        Utils.centralizarComponente(this);
        Utils.atualizarTempo(lblDataHora);
        iniciarTabelas();
    }

    private void iniciarTabelaDespesa(List<Despesa> despesas) {
        JTableModelDespesa modelo = new JTableModelDespesa(despesas);
        tabDespesas.setModel(modelo);
//        jTable1.getColumnModel().getColumn(3).setCellRenderer(Utils.setarAlinhamentoDireita());
        CellRenderer cellRenderer = new CellRenderer();
        tabDespesas.setDefaultRenderer(Object.class, cellRenderer);
        Utils.setarTamanhoColuna(tabDespesas, tamColunasDespesa);
        tabDespesas.setTableHeader(Utils.formataCollumnHeader(tabDespesas));
        tabDespesas.setVisible(true);
    }

    private void iniciarTabelaReceita(List<Receita> receitas) {
        JTableModelReceita modelo = new JTableModelReceita(receitas);
        tabReceitas.setModel(modelo);
//        jTable1.getColumnModel().getColumn(3).setCellRenderer(Utils.setarAlinhamentoDireita());
//        CellRenderer cellRenderer = new CellRenderer();
//        tabReceitas.setDefaultRenderer(Object.class, cellRenderer);
        Utils.setarTamanhoColuna(tabReceitas, tamColunasReceita);
        tabReceitas.setTableHeader(Utils.formataCollumnHeader(tabReceitas));
        tabReceitas.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovaDespesa = new javax.swing.JButton();
        btnNovaReceira = new javax.swing.JButton();
        btnQuitarDivida = new javax.swing.JButton();
        btnExcluirDivida = new javax.swing.JButton();
        btnEditarDivida = new javax.swing.JButton();
        painelStatus = new javax.swing.JPanel();
        lblInformacoes = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        painelTabulado = new javax.swing.JTabbedPane();
        painelDespesas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDespesas = new javax.swing.JTable();
        painelReceitas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabReceitas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbReferenciaSistema = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        lblSaldoRefencia = new javax.swing.JLabel();
        barraMenus = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuSair = new javax.swing.JMenuItem();
        mnuRelatorio = new javax.swing.JMenu();
        mnuRelatorioGeral = new javax.swing.JMenuItem();
        mnuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planilha de Gastos Ver. 0.5");

        jToolBar1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jToolBar1.setRollover(true);

        btnNovaDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/home/sanderson/controlagasto/view/imagens/despesa.png"))); // NOI18N
        btnNovaDespesa.setToolTipText("Nova Despesa");
        btnNovaDespesa.setFocusable(false);
        btnNovaDespesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovaDespesa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaDespesaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovaDespesa);

        btnNovaReceira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/home/sanderson/controlagasto/view/imagens/dinheiro.png"))); // NOI18N
        btnNovaReceira.setToolTipText("Nova Receita");
        btnNovaReceira.setFocusable(false);
        btnNovaReceira.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovaReceira.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovaReceira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaReceiraActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovaReceira);

        btnQuitarDivida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/home/sanderson/controlagasto/view/imagens/pago.png"))); // NOI18N
        btnQuitarDivida.setToolTipText("Pagar Despesa");
        btnQuitarDivida.setFocusable(false);
        btnQuitarDivida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuitarDivida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuitarDivida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarDividaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQuitarDivida);

        btnExcluirDivida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/home/sanderson/controlagasto/view/imagens/divida.png"))); // NOI18N
        btnExcluirDivida.setToolTipText("Excluir Registro");
        btnExcluirDivida.setFocusable(false);
        btnExcluirDivida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirDivida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirDivida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDividaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluirDivida);

        btnEditarDivida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/home/sanderson/controlagasto/view/imagens/Edit_Text_32x32.png"))); // NOI18N
        btnEditarDivida.setToolTipText("Editar Registro");
        btnEditarDivida.setFocusable(false);
        btnEditarDivida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarDivida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEditarDivida);

        lblInformacoes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInformacoes.setText("Sanderson Sá, costadesa@gmail.com");

        lblDataHora.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDataHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDataHora.setText("DATA E HORA DO SISTEMA");

        javax.swing.GroupLayout painelStatusLayout = new javax.swing.GroupLayout(painelStatus);
        painelStatus.setLayout(painelStatusLayout);
        painelStatusLayout.setHorizontalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelStatusLayout.createSequentialGroup()
                .addComponent(lblInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelStatusLayout.setVerticalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblInformacoes)
                .addComponent(lblDataHora))
        );

        tabDespesas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabDespesas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabDespesas);

        javax.swing.GroupLayout painelDespesasLayout = new javax.swing.GroupLayout(painelDespesas);
        painelDespesas.setLayout(painelDespesasLayout);
        painelDespesasLayout.setHorizontalGroup(
            painelDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
        painelDespesasLayout.setVerticalGroup(
            painelDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        painelTabulado.addTab("Despesas", painelDespesas);

        tabReceitas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabReceitas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tabReceitas);

        javax.swing.GroupLayout painelReceitasLayout = new javax.swing.GroupLayout(painelReceitas);
        painelReceitas.setLayout(painelReceitasLayout);
        painelReceitasLayout.setHorizontalGroup(
            painelReceitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );
        painelReceitasLayout.setVerticalGroup(
            painelReceitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        painelTabulado.addTab("Receitas", painelReceitas);

        jLabel1.setText("REFERÊNCIA:");

        cmbReferenciaSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReferenciaSistemaActionPerformed(evt);
            }
        });

        jLabel2.setText("SALDO:");

        lblSaldoRefencia.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblSaldoRefencia.setText("10000,00");

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelTabulado, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbReferenciaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldoRefencia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbReferenciaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lblSaldoRefencia))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelTabulado, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mnuArquivo.setText("Arquivo");

        mnuSair.setText("Sair");
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuSair);

        barraMenus.add(mnuArquivo);

        mnuRelatorio.setText("Relatório");

        mnuRelatorioGeral.setText("Relatório Geral");
        mnuRelatorioGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatorioGeralActionPerformed(evt);
            }
        });
        mnuRelatorio.add(mnuRelatorioGeral);

        barraMenus.add(mnuRelatorio);

        mnuAjuda.setText("Ajuda");
        barraMenus.add(mnuAjuda);

        setJMenuBar(barraMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaDespesaActionPerformed
        new TelaDespesa(this, true).setVisible(true);
        iniciarTabelaDespesa(new DaoDespesa().listarDespesasPorReferencia(referenciaSistema));
        calcularSaldo();
    }//GEN-LAST:event_btnNovaDespesaActionPerformed

    private void btnQuitarDividaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarDividaActionPerformed
        List<Despesa> lista = new ArrayList<Despesa>();
        if(tabDespesas.getSelectedRowCount() > 0) {
            JTableModelDespesa modelo = (JTableModelDespesa) tabDespesas.getModel();
            int[] rows = tabDespesas.getSelectedRows();
            for (int i = 0; i < rows.length; i++) {
                lista.add(modelo.getObjetoTable(rows[i]));
            }
            for(Despesa r : lista){
                r.setPago(true);
                new DaoDespesa().salvarDespesa(r);
            }
            iniciarTabelaDespesa(new DaoDespesa().listarDespesasPorReferencia(referenciaSistema));
        }else {
            Utils.mensagemAlerta("Selecione um Despesa!");
        }
    }//GEN-LAST:event_btnQuitarDividaActionPerformed

    private void btnExcluirDividaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDividaActionPerformed
        List<Despesa> lista = new ArrayList<Despesa>();
        if(tabDespesas.getSelectedRowCount() > 0) {
            JTableModelDespesa modelo = (JTableModelDespesa) tabDespesas.getModel();
            int[] rows = tabDespesas.getSelectedRows();
            for (int i = 0; i < rows.length; i++) {
                lista.add(modelo.getObjetoTable(rows[i]));
            }
            for(Despesa r : lista) {
                new DaoDespesa().deletarDespesa(r);
            }
            iniciarTabelaDespesa(new DaoDespesa().listarDespesasPorReferencia(referenciaSistema));
        } else {
            Utils.mensagemAlerta("Selecione um Despesa!");
        }
    }//GEN-LAST:event_btnExcluirDividaActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSairActionPerformed

    private void mnuRelatorioGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatorioGeralActionPerformed
        new Controle().relatorioGeral(new DaoDespesa().listarTodosDespesas());
    }//GEN-LAST:event_mnuRelatorioGeralActionPerformed

    private void btnNovaReceiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaReceiraActionPerformed
        new TelaReceita(this, true).setVisible(true);
        iniciarTabelaReceita(new DaoReceita().listarReceitasPorReferencia(referenciaSistema));
        calcularSaldo();
    }//GEN-LAST:event_btnNovaReceiraActionPerformed

    private void cmbReferenciaSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReferenciaSistemaActionPerformed
        if(cmbReferenciaSistema.getSelectedItem() != null && !cmbReferenciaSistema.getSelectedItem().toString().equals("")){
            referenciaSistema = Utils.formatarReferencia(cmbReferenciaSistema.getSelectedItem().toString());
            iniciarTabelas();
            calcularSaldo();
        }
    }//GEN-LAST:event_cmbReferenciaSistemaActionPerformed

    private void iniciarComboReferenciaSistema() {
        Utils.inicarComboReferencia(cmbReferenciaSistema);
        cmbReferenciaSistema.setSelectedIndex(new DateTime().getMonthOfYear()-1);
    }

    private void iniciarTabelas(){
        iniciarTabelaDespesa(new DaoDespesa().listarDespesasPorReferencia(referenciaSistema));
        iniciarTabelaReceita(new DaoReceita().listarReceitasPorReferencia(referenciaSistema));
    }

    private void calcularSaldo() {
        BigDecimal totalReceitas = BigDecimal.ZERO;
        BigDecimal totalDespesas = BigDecimal.ZERO;
        BigDecimal saldoReferencia = BigDecimal.ZERO;
        List<Receita> receitasRef = new DaoReceita().listarReceitasPorReferencia(referenciaSistema);
        List<Despesa> despesasRef = new DaoDespesa().listarDespesasPorReferencia(referenciaSistema);
        for(Receita r : receitasRef){
            totalReceitas = totalReceitas.add(r.getValor());
        }
        for(Despesa d : despesasRef){
            totalDespesas = totalDespesas.add(d.getValor());
        }
        saldoReferencia = totalReceitas.subtract(totalDespesas);
        if(saldoReferencia.compareTo(BigDecimal.ZERO) == -1){
            lblSaldoRefencia.setText("R$ " + Utils.getValorBigDecimalToTxt(saldoReferencia.abs()));
            lblSaldoRefencia.setForeground(new java.awt.Color(153,0,0));
        }else{
            lblSaldoRefencia.setText("R$ " + Utils.getValorBigDecimalToTxt(saldoReferencia.abs()));
            lblSaldoRefencia.setForeground(new java.awt.Color(0, 102, 0));
        }


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenus;
    private javax.swing.JButton btnEditarDivida;
    private javax.swing.JButton btnExcluirDivida;
    private javax.swing.JButton btnNovaDespesa;
    private javax.swing.JButton btnNovaReceira;
    private javax.swing.JButton btnQuitarDivida;
    private javax.swing.JComboBox cmbReferenciaSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblInformacoes;
    private javax.swing.JLabel lblSaldoRefencia;
    private javax.swing.JMenu mnuAjuda;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenu mnuRelatorio;
    private javax.swing.JMenuItem mnuRelatorioGeral;
    private javax.swing.JMenuItem mnuSair;
    private javax.swing.JPanel painelDespesas;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelReceitas;
    private javax.swing.JPanel painelStatus;
    private javax.swing.JTabbedPane painelTabulado;
    private javax.swing.JTable tabDespesas;
    private javax.swing.JTable tabReceitas;
    // End of variables declaration//GEN-END:variables

}
