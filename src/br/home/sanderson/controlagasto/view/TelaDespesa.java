package br.home.sanderson.controlagasto.view;

import br.home.sanderson.controlagasto.modelo.Despesa;
import br.home.sanderson.controlagasto.modelo.TipoRegistro;
import br.home.sanderson.controlagasto.persistencia.DaoDespesa;
import br.home.sanderson.controlagasto.persistencia.DaoTipoRegistro;
import br.home.sanderson.controlagasto.util.Utils;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;

/**
 *
 * @author Mangabit
 */
public class TelaDespesa extends javax.swing.JDialog {

    /** Creates new form TelaDespesa */
    public TelaDespesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarComboTipoRegistro(new DaoTipoRegistro().listarTipoRegistro());
        txtValorRegistro.setText("0,00");
        txtdataRegistro.setFormats("dd/MM/yyyy");
        txtdataRegistro.setDate(new Date());
        Utils.centralizarComponente(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoRegistro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtdataRegistro = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        txtValorRegistro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnConfimar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Registro de Gasto"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Tipo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Venc.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Valor");

        txtValorRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorRegistroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorRegistroFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Descrição do Gasto");

        jScrollPane1.setViewportView(jTextPane1);

        btnConfimar.setText("Confirmar");
        btnConfimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfimarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnConfimar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtdataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtValorRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfimar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfimarActionPerformed
        String resultado = verificarPreenchimento();
        if(resultado.equals("OK")){
            try{
                Despesa r = new Despesa();
                r.setVencimento(txtdataRegistro.getDate());
                r.setDescricao(jTextPane1.getText().trim());
                r.setTipoRegistro((TipoRegistro)cmbTipoRegistro.getSelectedItem());
                r.setValor(Utils.getTxtToValorBigDecimal(txtValorRegistro));
                DateTime ref = new DateTime(txtdataRegistro.getDate());
                r.setReferencia(Integer.parseInt(ref.getMonthOfYear() + "" + ref.getYear()));
                new DaoDespesa().salvarDespesa(r);
                dispose();
            }catch(Exception e){
                throw new RuntimeException("Erro ao confirmar novo registro", e);
            }
        } else {
            JOptionPane.showMessageDialog(null, resultado, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfimarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(null,
                "Desejar Realmente cancelar o novo registro?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtValorRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorRegistroFocusGained
        txtValorRegistro.selectAll();
    }//GEN-LAST:event_txtValorRegistroFocusGained

    private void txtValorRegistroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorRegistroFocusLost
        Utils.verificarValor(txtValorRegistro);
    }//GEN-LAST:event_txtValorRegistroFocusLost

    private String verificarPreenchimento(){
        StringBuilder resultado = new StringBuilder();
        if(cmbTipoRegistro.getSelectedItem() == null){
            resultado.append("Selecione o tipo de Registro");
        }else if(txtdataRegistro.getDate() == null){
            resultado.append("Selecione uma data para o Registro");
        }else if(txtValorRegistro.getText().trim().equals(Utils.VALOR_VAZIO) || txtValorRegistro.getText().trim().equals(Utils.VAZIO)){
            resultado.append("Informe um valor para o Registro");
        }else {
            resultado.append("OK");
        }
        return resultado.toString();
    }

    private void iniciarComboTipoRegistro(List<TipoRegistro> lista) {
        cmbTipoRegistro.removeAllItems();
        for (TipoRegistro tipo : lista) {
            cmbTipoRegistro.addItem(tipo);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfimar;
    private javax.swing.JComboBox cmbTipoRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtValorRegistro;
    private org.jdesktop.swingx.JXDatePicker txtdataRegistro;
    // End of variables declaration//GEN-END:variables

}
