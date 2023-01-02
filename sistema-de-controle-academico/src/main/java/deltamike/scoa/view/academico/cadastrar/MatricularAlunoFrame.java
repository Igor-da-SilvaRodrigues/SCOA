/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deltamike.scoa.view.academico.cadastrar;

import deltamike.scoa.controller.academico.curso.CursoController;
import deltamike.scoa.controller.usuario.AlunoController;
import deltamike.scoa.controller.usuario.UsuarioController;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.view.Dashboard;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author rodri
 */
public class MatricularAlunoFrame extends javax.swing.JFrame {
    private CursoModel curso;

    public void setCurso(CursoModel curso) {
        this.curso = curso;
        this.cursoNomeLabel.setText(curso.getNome());
        
    }
    
    
    /**
     * Creates new form MatricularAlunoFrame
     */
       
    public MatricularAlunoFrame() {
        initComponents();
        
        
        
        AlunoController controller = (AlunoController) Dashboard.springAppContext.getBean("alunoController");
        List<AlunoModel> alunos = controller.getAll().getBody();
        
        for(AlunoModel aluno: alunos){
            if(aluno.getUsuario() == null){continue;}
            this.alunoComboBox.addItem(aluno.getUsuario().getId());
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
        cursoNomeLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        alunoComboBox = new javax.swing.JComboBox<>();
        cadastrarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Matricular aluno em curso: ");

        jLabel2.setText("Aluno");

        cadastrarButton.setText("Matricular");
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
                    .addComponent(alunoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cursoNomeLabel))
                            .addComponent(jLabel2))
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cadastrarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cursoNomeLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alunoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(cadastrarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        // TODO add your handling code here:
        UsuarioController usuarioController = (UsuarioController) Dashboard.springAppContext.getBean("usuarioController");
        
        String aluno_email = this.alunoComboBox.getItemAt( this.alunoComboBox.getSelectedIndex() );
        UsuarioModel usuario = (UsuarioModel) usuarioController.getById(aluno_email).getBody();
        AlunoModel aluno = usuario.getAluno();
        
        
        CursoController cursoController = (CursoController) Dashboard.springAppContext.getBean("cursoController");
        this.curso = (CursoModel) cursoController.getById(this.curso.getId()).getBody();
        
        
        List<AlunoModel> alunosMatriculados = this.curso.getAlunos();
        if(alunosMatriculados != null){
            for(AlunoModel alunoMatriculado : alunosMatriculados){
                if(Objects.equals(alunoMatriculado.getId(), aluno.getId())){
                    Dashboard.alert("Aluno já está matriculado neste curso!");
                    return;
                }
            }
        }
        
        ResponseEntity<Object> response = cursoController.colocarAlunoEmCurso(this.curso.getId(), aluno.getId());
        if(response.getStatusCode() == HttpStatus.OK){
            Dashboard.alert("Aluno matriculado com sucesso");
        }else{
            Dashboard.alert("Erro na matricula do aluno");
        }
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
            java.util.logging.Logger.getLogger(MatricularAlunoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatricularAlunoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatricularAlunoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatricularAlunoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatricularAlunoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alunoComboBox;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel cursoNomeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
