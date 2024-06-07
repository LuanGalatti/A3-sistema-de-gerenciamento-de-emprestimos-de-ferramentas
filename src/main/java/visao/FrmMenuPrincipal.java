package visao;

import modelo.Amigo;

/**
 *
 * @author 1072416842
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuPrincipal
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCadastrarAmigos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastrarFerramentas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuTransação = new javax.swing.JMenu();
        jMenuItemEmpréstimo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemDevolução = new javax.swing.JMenuItem();
        jMenuGerenciamento = new javax.swing.JMenu();
        jMenuItemGerenciarAmigos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemGerenciarFerramentas = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItemGerenciarEmprestimo = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItemRelatorio = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jMenuCadastro.setText("Cadastro");
        jMenuCadastro.setMaximumSize(new java.awt.Dimension(60, 32767));
        jMenuCadastro.setMinimumSize(new java.awt.Dimension(60, 22));
        jMenuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroActionPerformed(evt);
            }
        });

        jMenuItemCadastrarAmigos.setText("Cadastrar Amigos");
        jMenuItemCadastrarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarAmigosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastrarAmigos);
        jMenuCadastro.add(jSeparator2);

        jMenuItemCadastrarFerramentas.setText("Cadastrar Ferramentas");
        jMenuItemCadastrarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarFerramentasActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastrarFerramentas);
        jMenuCadastro.add(jSeparator3);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemSair);

        jMenuBar1.add(jMenuCadastro);

        jMenuTransação.setText("Transação");
        jMenuTransação.setMaximumSize(new java.awt.Dimension(70, 32767));
        jMenuTransação.setMinimumSize(new java.awt.Dimension(60, 22));
        jMenuTransação.setPreferredSize(new java.awt.Dimension(60, 22));

        jMenuItemEmpréstimo.setText("Empréstimo");
        jMenuItemEmpréstimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmpréstimoActionPerformed(evt);
            }
        });
        jMenuTransação.add(jMenuItemEmpréstimo);
        jMenuTransação.add(jSeparator1);

        jMenuItemDevolução.setText("Devolução");
        jMenuItemDevolução.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDevoluçãoActionPerformed(evt);
            }
        });
        jMenuTransação.add(jMenuItemDevolução);

        jMenuBar1.add(jMenuTransação);

        jMenuGerenciamento.setText("Gerenciamento");
        jMenuGerenciamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciamentoActionPerformed(evt);
            }
        });

        jMenuItemGerenciarAmigos.setText("Gerenciar Amigos");
        jMenuItemGerenciarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarAmigosActionPerformed(evt);
            }
        });
        jMenuGerenciamento.add(jMenuItemGerenciarAmigos);
        jMenuGerenciamento.add(jSeparator4);

        jMenuItemGerenciarFerramentas.setText("Gerenciar Ferramentas");
        jMenuItemGerenciarFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemGerenciarFerramentasMouseClicked(evt);
            }
        });
        jMenuItemGerenciarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarFerramentasActionPerformed(evt);
            }
        });
        jMenuGerenciamento.add(jMenuItemGerenciarFerramentas);
        jMenuGerenciamento.add(jSeparator5);

        jMenuItemGerenciarEmprestimo.setText("Gerenciar Empréstimo");
        jMenuItemGerenciarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarEmprestimoActionPerformed(evt);
            }
        });
        jMenuGerenciamento.add(jMenuItemGerenciarEmprestimo);

        jMenuBar1.add(jMenuGerenciamento);

        jMenuRelatorio.setText("Relatório");
        jMenuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioActionPerformed(evt);
            }
        });

        jMenuItemRelatorio.setText("Relatório");
        jMenuRelatorio.add(jMenuItemRelatorio);

        jMenuBar1.add(jMenuRelatorio);

        jMenuSobre.setText("Sobre");
        jMenuSobre.setMinimumSize(new java.awt.Dimension(60, 22));
        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        //Encerra o programa
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemGerenciarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarAmigosActionPerformed
        //Instancia a tela de gerenciar amigo
        FrmGerenciarAmigo objeto = new FrmGerenciarAmigo();
        objeto.setVisible(true);

    }//GEN-LAST:event_jMenuItemGerenciarAmigosActionPerformed

    private void jMenuItemCadastrarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarFerramentasActionPerformed
        // Instancia a tela de cadastro de ferramenta
        FrmCadastroFerramenta objeto = new FrmCadastroFerramenta();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarFerramentasActionPerformed

    private void jMenuItemEmpréstimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmpréstimoActionPerformed
        // Instancia a tela de cadastro de empréstimo
        FrmCadastroEmprestimo tela = new FrmCadastroEmprestimo();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemEmpréstimoActionPerformed

    private void jMenuItemDevoluçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDevoluçãoActionPerformed
        // Instancia a tela de cadastro devoluçao
        FrmCadastroDevolucao tela = new FrmCadastroDevolucao();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemDevoluçãoActionPerformed

    private void jMenuGerenciamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciamentoActionPerformed

    }//GEN-LAST:event_jMenuGerenciamentoActionPerformed

    private void jMenuItemGerenciarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarEmprestimoActionPerformed
        //Instancia a tela de gerenciar emprestimo
        FrmGerenciarEmprestimo objeto = new FrmGerenciarEmprestimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciarEmprestimoActionPerformed

    private void jMenuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioActionPerformed
//Instancia a tela de gerenciar emprestimo
        FrmRelatorio objeto = new FrmRelatorio();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuRelatorioActionPerformed
    private void jMenuItemGerenciarFerramentasMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void jMenuItemCadastrarAmigosActionPerformed(java.awt.event.ActionEvent evt) {

        //Instancia a tela de cadastrar amigo
        FrmCadastroAmigo objeto = new FrmCadastroAmigo();
        objeto.setVisible(true);

    }

    private void jMenuArquivoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jMenuCadastroActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jMenuItemGerenciarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {
        // Instancia a tela de gerenciar ferramenta
        FrmGerenciarFerramenta objeto = new FrmGerenciarFerramenta();
        objeto.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuGerenciamento;
    private javax.swing.JMenuItem jMenuItemCadastrarAmigos;
    private javax.swing.JMenuItem jMenuItemCadastrarFerramentas;
    private javax.swing.JMenuItem jMenuItemDevolução;
    private javax.swing.JMenuItem jMenuItemEmpréstimo;
    private javax.swing.JMenuItem jMenuItemGerenciarAmigos;
    private javax.swing.JMenuItem jMenuItemGerenciarEmprestimo;
    private javax.swing.JMenuItem jMenuItemGerenciarFerramentas;
    private javax.swing.JMenuItem jMenuItemRelatorio;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JMenu jMenuTransação;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
