/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deltamike.scoa.view.almoxarifado;

import deltamike.scoa.controller.almoxarifado.bem.BemController;
import deltamike.scoa.controller.almoxarifado.item.ItemController;
import deltamike.scoa.controller.almoxarifado.produto.ProdutoController;
import deltamike.scoa.dtos.almoxarifado.bem.BemDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoDTO;
import deltamike.scoa.view.Dashboard;

/**
 *
 * @author rapha
 */
public class Almoxarifado extends javax.swing.JFrame {

    /**
     * Creates new form Almoxarifado
     */
    public Almoxarifado() {
        initComponents();
        Nome.setVisible(false);
        Nome_Edit.setVisible(false);
        EstoqueMin.setVisible(false);
        EstoqueMin_Edit.setVisible(false);
        EstoqueMax.setVisible(false);
        EstoqueMax_Edit.setVisible(false);
        EstoqueAtual.setVisible(false);
        EstoqueAtual_Edit.setVisible(false);
        Qtd.setVisible(false);
        Qtd_Edit.setVisible(false);
        Setor.setVisible(false);
        Setor_Edit.setVisible(false);
        Tombo.setVisible(false);
        Tombo_Edit.setVisible(false);
        Referencia.setVisible(false);
        Referencia_Edit.setVisible(false);
        Local.setVisible(false);
        Local_Edit.setVisible(false);
        CodBarras.setVisible(false);
        CodBarras_Edit.setVisible(false);
        Cadastrar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tipos = new javax.swing.ButtonGroup();
        Guias = new javax.swing.JTabbedPane();
        Relatorio = new javax.swing.JPanel();
        Item0 = new javax.swing.JLabel();
        Item0_Edit = new javax.swing.JTextField();
        Qtd0 = new javax.swing.JLabel();
        Qtd0_Edit = new javax.swing.JTextField();
        Tipo = new javax.swing.JLabel();
        RelEnt = new javax.swing.JRadioButton();
        RelSai = new javax.swing.JRadioButton();
        Emitir = new javax.swing.JButton();
        Item = new javax.swing.JPanel();
        Bem_Produto = new javax.swing.JComboBox<>();
        Opções = new javax.swing.JComboBox<>();
        Nome = new javax.swing.JLabel();
        Nome_Edit = new javax.swing.JTextField();
        EstoqueMin = new javax.swing.JLabel();
        EstoqueMin_Edit = new javax.swing.JTextField();
        EstoqueMax = new javax.swing.JLabel();
        EstoqueMax_Edit = new javax.swing.JTextField();
        EstoqueAtual = new javax.swing.JLabel();
        EstoqueAtual_Edit = new javax.swing.JTextField();
        Qtd = new javax.swing.JLabel();
        Qtd_Edit = new javax.swing.JTextField();
        Setor = new javax.swing.JLabel();
        Setor_Edit = new javax.swing.JTextField();
        Tombo = new javax.swing.JLabel();
        Tombo_Edit = new javax.swing.JTextField();
        Referencia = new javax.swing.JLabel();
        Referencia_Edit = new javax.swing.JTextField();
        Local = new javax.swing.JLabel();
        Local_Edit = new javax.swing.JTextField();
        CodBarras = new javax.swing.JLabel();
        CodBarras_Edit = new javax.swing.JTextField();
        Cadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Almoxarifado");
        setResizable(false);

        Relatorio.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                RelatorioComponentShown(evt);
            }
        });

        Item0.setText("ITEM");

        Qtd0.setText("QTD.");

        Tipo.setText("TIPO :");

        Tipos.add(RelEnt);
        RelEnt.setText("ENTRADA");

        Tipos.add(RelSai);
        RelSai.setText("SAÍDA");

        Emitir.setText("EMITIR");
        Emitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmitirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RelatorioLayout = new javax.swing.GroupLayout(Relatorio);
        Relatorio.setLayout(RelatorioLayout);
        RelatorioLayout.setHorizontalGroup(
            RelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RelatorioLayout.createSequentialGroup()
                        .addComponent(Item0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Item0_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Qtd0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Qtd0_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RelatorioLayout.createSequentialGroup()
                        .addComponent(Tipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RelEnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RelSai)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RelatorioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Emitir))
        );
        RelatorioLayout.setVerticalGroup(
            RelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Item0)
                    .addComponent(Item0_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qtd0)
                    .addComponent(Qtd0_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipo)
                    .addComponent(RelEnt)
                    .addComponent(RelSai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(Emitir)
                .addContainerGap())
        );

        Guias.addTab("Relatório", Relatorio);

        Bem_Produto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- ESCOLHA UMA OPÇÃO --", "Bem", "Produto" }));
        Bem_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bem_ProdutoActionPerformed(evt);
            }
        });

        Opções.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpçõesActionPerformed(evt);
            }
        });

        Nome.setText("NOME");

        EstoqueMin.setText("ESTOQUE MIN.");

        EstoqueMax.setText("ESTOQUE MAX.");

        EstoqueAtual.setText("ESTOQUE ATUAL");

        Qtd.setText("QTD.");

        Setor.setText("SETOR");

        Tombo.setText("TOMBO");

        Referencia.setText("REFERENCIA");

        Local.setText("LOCAL");

        CodBarras.setText("COD. BARRAS");

        Cadastrar.setText("CADASTRAR");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ItemLayout = new javax.swing.GroupLayout(Item);
        Item.setLayout(ItemLayout);
        ItemLayout.setHorizontalGroup(
            ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bem_Produto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Opções, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(Nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nome_Edit))
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(Qtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Qtd_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Setor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Setor_Edit))
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(Tombo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tombo_Edit))
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(EstoqueMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstoqueMin_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstoqueMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstoqueMax_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstoqueAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstoqueAtual_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(Referencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Referencia_Edit))
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(Local)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Local_Edit))
                    .addGroup(ItemLayout.createSequentialGroup()
                        .addComponent(CodBarras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodBarras_Edit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cadastrar)))
                .addContainerGap())
        );
        ItemLayout.setVerticalGroup(
            ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bem_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Opções, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(Nome_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstoqueMin)
                    .addComponent(EstoqueMin_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstoqueMax)
                    .addComponent(EstoqueMax_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstoqueAtual)
                    .addComponent(EstoqueAtual_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Qtd)
                    .addComponent(Qtd_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Setor)
                    .addComponent(Setor_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tombo)
                    .addComponent(Tombo_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Referencia)
                    .addComponent(Referencia_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Local)
                    .addComponent(Local_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodBarras)
                    .addComponent(CodBarras_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Guias.addTab("Item", Item);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Guias)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Guias))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bem_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bem_ProdutoActionPerformed
        // TODO add your handling code here:
        switch (Bem_Produto.getSelectedItem().toString()) {
            case "Bem":
                Opções.removeAllItems();
                Opções.addItem("Servível");
                Opções.addItem("Inservível");
                Cadastrar.setVisible(true);
                break;
            case "Produto":
                Opções.removeAllItems();
                Opções.addItem("Consumível");
                Opções.addItem("Não-consumível");
                Cadastrar.setVisible(true);
                break;
            default:
                Opções.removeAllItems();
                Opções.addItem("");
                Cadastrar.setVisible(false);
                break;
        }
    }//GEN-LAST:event_Bem_ProdutoActionPerformed

    private void OpçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpçõesActionPerformed
        // TODO add your handling code here:
        if(Opções.getSelectedItem() == null) {
            return;
        }
        switch (Opções.getSelectedItem().toString()) {
            case "Servível":
                Nome.setVisible(true);
                Nome_Edit.setVisible(true);
                EstoqueMin.setVisible(true);
                EstoqueMin_Edit.setVisible(true);
                EstoqueMax.setVisible(true);
                EstoqueMax_Edit.setVisible(true);
                EstoqueAtual.setVisible(true);
                EstoqueAtual_Edit.setVisible(true);
                Qtd.setVisible(true);
                Qtd_Edit.setVisible(true);
                Setor.setVisible(true);
                Setor_Edit.setVisible(true);
                Tombo.setVisible(true);
                Tombo_Edit.setVisible(true);
                Referencia.setVisible(false);
                Referencia_Edit.setVisible(false);
                Local.setVisible(false);
                Local_Edit.setVisible(false);
                CodBarras.setVisible(false);
                CodBarras_Edit.setVisible(false);
                break;
            case "Inservível":
                Nome.setVisible(true);
                Nome_Edit.setVisible(true);
                EstoqueMin.setVisible(true);
                EstoqueMin_Edit.setVisible(true);
                EstoqueMax.setVisible(true);
                EstoqueMax_Edit.setVisible(true);
                EstoqueAtual.setVisible(true);
                EstoqueAtual_Edit.setVisible(true);
                Qtd.setVisible(true);
                Qtd_Edit.setVisible(true);
                Setor.setVisible(false);
                Setor_Edit.setVisible(false);
                Tombo.setVisible(false);
                Tombo_Edit.setVisible(false);
                Referencia.setVisible(false);
                Referencia_Edit.setVisible(false);
                Local.setVisible(false);
                Local_Edit.setVisible(false);
                CodBarras.setVisible(false);
                CodBarras_Edit.setVisible(false);
                break;
            case "Consumível":
                Nome.setVisible(true);
                Nome_Edit.setVisible(true);
                EstoqueMin.setVisible(true);
                EstoqueMin_Edit.setVisible(true);
                EstoqueMax.setVisible(true);
                EstoqueMax_Edit.setVisible(true);
                EstoqueAtual.setVisible(true);
                EstoqueAtual_Edit.setVisible(true);
                Qtd.setVisible(true);
                Qtd_Edit.setVisible(true);
                Setor.setVisible(false);
                Setor_Edit.setVisible(false);
                Tombo.setVisible(false);
                Tombo_Edit.setVisible(false);
                Referencia.setVisible(true);
                Referencia_Edit.setVisible(true);
                Local.setVisible(true);
                Local_Edit.setVisible(true);
                CodBarras.setVisible(true);
                CodBarras_Edit.setVisible(true);
                break;
            case "Não-consumível":
                Nome.setVisible(true);
                Nome_Edit.setVisible(true);
                EstoqueMin.setVisible(true);
                EstoqueMin_Edit.setVisible(true);
                EstoqueMax.setVisible(true);
                EstoqueMax_Edit.setVisible(true);
                EstoqueAtual.setVisible(true);
                EstoqueAtual_Edit.setVisible(true);
                Qtd.setVisible(true);
                Qtd_Edit.setVisible(true);
                Setor.setVisible(false);
                Setor_Edit.setVisible(false);
                Tombo.setVisible(false);
                Tombo_Edit.setVisible(false);
                Referencia.setVisible(true);
                Referencia_Edit.setVisible(true);
                Local.setVisible(true);
                Local_Edit.setVisible(true);
                CodBarras.setVisible(true);
                CodBarras_Edit.setVisible(true);
                break;
            default:
                Nome.setVisible(false);
                Nome_Edit.setVisible(false);
                EstoqueMin.setVisible(false);
                EstoqueMin_Edit.setVisible(false);
                EstoqueMax.setVisible(false);
                EstoqueMax_Edit.setVisible(false);
                EstoqueAtual.setVisible(false);
                EstoqueAtual_Edit.setVisible(false);
                Qtd.setVisible(false);
                Qtd_Edit.setVisible(false);
                Setor.setVisible(false);
                Setor_Edit.setVisible(false);
                Tombo.setVisible(false);
                Tombo_Edit.setVisible(false);
                Referencia.setVisible(false);
                Referencia_Edit.setVisible(false);
                Local.setVisible(false);
                Local_Edit.setVisible(false);
                CodBarras.setVisible(false);
                CodBarras_Edit.setVisible(false);
                break;
        }
    }//GEN-LAST:event_OpçõesActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        // TODO add your handling code here:
        ItemController springItemController = (ItemController) Dashboard.springAppContext.getBean("itemController");
        switch (Bem_Produto.getSelectedItem().toString()) {
            case "Bem":
                BemDTO bemDTO = new BemDTO();
                bemDTO.setNome(Nome_Edit.getText());
                bemDTO.setEstoque(Integer.valueOf(EstoqueAtual_Edit.getText()));
                bemDTO.setEstoque_min(Integer.valueOf(EstoqueMin_Edit.getText()));
                bemDTO.setEstoque_max(Integer.valueOf(EstoqueMax_Edit.getText()));
                BemController bemController = (BemController) Dashboard.springAppContext.getBean("bemController");
                bemController.saveBem(bemDTO);
                break;
            case "Produto":
                ProdutoDTO produtoDTO = new ProdutoDTO();
                produtoDTO.setNome(Nome_Edit.getText());
                produtoDTO.setEstoque(Integer.valueOf(EstoqueAtual_Edit.getText()));
                produtoDTO.setEstoque_min(Integer.valueOf(EstoqueMin_Edit.getText()));
                produtoDTO.setEstoque_max(Integer.valueOf(EstoqueMax_Edit.getText()));
                produtoDTO.setCodBarras(CodBarras_Edit.getText());
                produtoDTO.setLocalizacao(Local_Edit.getText());
                produtoDTO.setReferencia(EstoqueAtual_Edit.getText());
                ProdutoController produtoController = (ProdutoController) Dashboard.springAppContext.getBean("produtoController");
                produtoController.saveProduto(produtoDTO);
                break;
            default:
                return;
        }
    }//GEN-LAST:event_CadastrarActionPerformed

    private void EmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmitirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmitirActionPerformed

    private void RelatorioComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_RelatorioComponentShown
        // TODO add your handling code here:
        ItemController itemController = (ItemController) Dashboard.springAppContext.getBean("itemController");
    }//GEN-LAST:event_RelatorioComponentShown

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
            java.util.logging.Logger.getLogger(Almoxarifado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Almoxarifado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Almoxarifado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Almoxarifado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Almoxarifado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Bem_Produto;
    private javax.swing.JButton Cadastrar;
    private javax.swing.JLabel CodBarras;
    private javax.swing.JTextField CodBarras_Edit;
    private javax.swing.JButton Emitir;
    private javax.swing.JLabel EstoqueAtual;
    private javax.swing.JTextField EstoqueAtual_Edit;
    private javax.swing.JLabel EstoqueMax;
    private javax.swing.JTextField EstoqueMax_Edit;
    private javax.swing.JLabel EstoqueMin;
    private javax.swing.JTextField EstoqueMin_Edit;
    private javax.swing.JTabbedPane Guias;
    private javax.swing.JPanel Item;
    private javax.swing.JLabel Item0;
    private javax.swing.JTextField Item0_Edit;
    private javax.swing.JLabel Local;
    private javax.swing.JTextField Local_Edit;
    private javax.swing.JLabel Nome;
    private javax.swing.JTextField Nome_Edit;
    private javax.swing.JComboBox<String> Opções;
    private javax.swing.JLabel Qtd;
    private javax.swing.JLabel Qtd0;
    private javax.swing.JTextField Qtd0_Edit;
    private javax.swing.JTextField Qtd_Edit;
    private javax.swing.JLabel Referencia;
    private javax.swing.JTextField Referencia_Edit;
    private javax.swing.JRadioButton RelEnt;
    private javax.swing.JRadioButton RelSai;
    private javax.swing.JPanel Relatorio;
    private javax.swing.JLabel Setor;
    private javax.swing.JTextField Setor_Edit;
    private javax.swing.JLabel Tipo;
    private javax.swing.ButtonGroup Tipos;
    private javax.swing.JLabel Tombo;
    private javax.swing.JTextField Tombo_Edit;
    // End of variables declaration//GEN-END:variables
}
