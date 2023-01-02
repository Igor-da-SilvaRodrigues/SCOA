/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deltamike.scoa.view.usuario.cadastrar;

import deltamike.scoa.controller.usuario.FuncionarioController;
import deltamike.scoa.controller.usuario.UsuarioController;
import deltamike.scoa.dtos.usuario.FuncionarioDTO;
import deltamike.scoa.model.usuario.FuncionarioModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.view.Dashboard;
import deltamike.scoa.view.biblioteca.cadastrar.CadastrarLivroFrame;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class CadastrarFuncionarioForm extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarFuncionarioForm
     */
    public CadastrarFuncionarioForm() {
        initComponents();
        
        //populando combo box de usuarios
        UsuarioController controller = (UsuarioController) Dashboard.springAppContext.getBean("usuarioController");
        List<UsuarioModel> usuarios = controller.getAll().getBody();
        
        for(UsuarioModel usuario : usuarios){
            this.usuarioComboBox.addItem(usuario.getId());
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

        jLabel1 = new javax.swing.JLabel();
        usuarioComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salarioSpinner = new javax.swing.JSpinner();
        departamentoTextField = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Departamento");

        jLabel3.setText("Salario liquido");

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(departamentoTextField)
                    .addComponent(salarioSpinner)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 308, Short.MAX_VALUE)
                        .addComponent(cadastrarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salarioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(cadastrarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        // TODO add your handling code here:
        
        
        
        //confirmando alteração manual no spinner de salario
        try {
            this.salarioSpinner.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarLivroFrame.class.getName()).log(Level.SEVERE, null, ex);
            Dashboard.alert(ex.toString());
            return;
        
        }
        
        UsuarioController usuarioController = (UsuarioController) Dashboard.springAppContext.getBean("usuarioController");
        UsuarioModel usuario = (UsuarioModel) usuarioController.getById( this.usuarioComboBox.getItemAt( this.usuarioComboBox.getSelectedIndex() ) ).getBody();
        
        if(usuario.getFuncionario() != null){
            Dashboard.alert("Este usuario já está cadastrado como funcionario!");
            return;
        }
        
        FuncionarioController funcionarioController = (FuncionarioController) Dashboard.springAppContext.getBean("funcionarioController");
        
        FuncionarioDTO funcionarioDTO= new FuncionarioDTO();
        funcionarioDTO.setDepartamento(this.departamentoTextField.getText());
        funcionarioDTO.setSalario_liquido((Integer)this.salarioSpinner.getValue());
        
        FuncionarioModel funcionario = funcionarioController.saveFuncionario(funcionarioDTO).getBody();
        funcionarioController.colocarFuncionarioEmUsuario(usuario.getId(), funcionario.getId());
        
        Dashboard.alert("Funcionario cadastrado com sucesso");
        
    }//GEN-LAST:event_cadastrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFuncionarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField departamentoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner salarioSpinner;
    private javax.swing.JComboBox<String> usuarioComboBox;
    // End of variables declaration//GEN-END:variables
}
