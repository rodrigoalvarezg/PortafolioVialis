/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Negocio.TLogin;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Esteban
 */
public final class MainMenu extends javax.swing.JFrame {

    
    TLogin tLogin = new TLogin();
    
    
    public MainMenu() {
        initComponents();
        muestraFecha();
        jLabel3.setText(tLogin.getUsuario());        
    }
    
    void muestraFecha(){
        //Muestra la fecha en el label
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat();
        lblDate.setText(s.format(d));
        /*Función para mostrar la fecha actual en el menú*/
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btnProyectos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnFuncionarios = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnReunionesInspecciones = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnCotizaciones = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnRecursos = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnHerramientas = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnMateriales = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnCuentas = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnHito = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSTRUCTORA VIALIS");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido");

        btnProyectos.setBackground(new java.awt.Color(0, 204, 204));
        btnProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProyectosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProyectosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProyectosMouseExited(evt);
            }
        });
        btnProyectos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PROYECTOS_ICON_MAINMENU.png"))); // NOI18N
        btnProyectos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 13, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Proyectos");
        btnProyectos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, -1, -1));

        btnFuncionarios.setBackground(new java.awt.Color(255, 153, 51));
        btnFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFuncionariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFuncionariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFuncionariosMouseExited(evt);
            }
        });
        btnFuncionarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Funcionarios");
        btnFuncionarios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/EMPLEADOS_ICON_MAINMENU.png"))); // NOI18N
        btnFuncionarios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 13, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("USER");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/USER_MINI_ICON_MAINMENU.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CALENDARIO_MINI_ICON_MAINMENU.png"))); // NOI18N

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vialis Business - Hellfish 2018");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CERRAR_MINI_ICON.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ATRAS_MINI_ICON.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        btnReunionesInspecciones.setBackground(new java.awt.Color(0, 153, 102));
        btnReunionesInspecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReunionesInspeccionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReunionesInspeccionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReunionesInspeccionesMouseExited(evt);
            }
        });
        btnReunionesInspecciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("e Inspecciones");
        btnReunionesInspecciones.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/REUNIONES_ICON_MAINMENU.png"))); // NOI18N
        btnReunionesInspecciones.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Reuniones");
        btnReunionesInspecciones.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnCotizaciones.setBackground(new java.awt.Color(0, 102, 102));
        btnCotizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCotizacionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCotizacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCotizacionesMouseExited(evt);
            }
        });
        btnCotizaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/COTIZACIONES_ICON_MAINMENU.png"))); // NOI18N
        btnCotizaciones.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 13, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cotizaciones");
        btnCotizaciones.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, -1, -1));

        btnRecursos.setBackground(new java.awt.Color(0, 0, 153));
        btnRecursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecursosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRecursosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRecursosMouseExited(evt);
            }
        });
        btnRecursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Recursos_MainMenu.png"))); // NOI18N
        btnRecursos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 13, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Recursos");
        btnRecursos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, -1, -1));

        btnHerramientas.setBackground(new java.awt.Color(204, 0, 0));
        btnHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHerramientasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHerramientasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHerramientasMouseExited(evt);
            }
        });
        btnHerramientas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HERRAMIENTAS_ICON_MAINMENU.png"))); // NOI18N
        btnHerramientas.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 13, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Herramientas");
        btnHerramientas.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 63, -1, -1));

        btnMateriales.setBackground(new java.awt.Color(204, 204, 0));
        btnMateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaterialesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMaterialesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMaterialesMouseExited(evt);
            }
        });
        btnMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MATERIALES_ICON_MAINMENU.png"))); // NOI18N
        btnMateriales.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 13, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Materiales");
        btnMateriales.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, -1, -1));

        btnCuentas.setBackground(new java.awt.Color(153, 153, 153));
        btnCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCuentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCuentasMouseExited(evt);
            }
        });
        btnCuentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cuentas_MainMenu.png"))); // NOI18N
        btnCuentas.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Cuentas");
        btnCuentas.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 63, -1, -1));

        btnHito.setBackground(new java.awt.Color(204, 0, 204));
        btnHito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHitoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHitoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHitoMouseExited(evt);
            }
        });
        btnHito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Inspecciones_MainMenu.png"))); // NOI18N
        btnHito.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Hitos");
        btnHito.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnFuncionarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProyectos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReunionesInspecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCotizaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHito, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel6)))
                .addGap(0, 79, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDate)
                .addGap(93, 93, 93)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMateriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHerramientas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHito, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReunionesInspecciones, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnCotizaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionariosMouseClicked
        // TODO add your handling code here:
        GUI_Funcionarios func = new GUI_Funcionarios();
        func.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFuncionariosMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        new Mensajes_SalirAp().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnProyectosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProyectosMouseEntered
        // TODO add your handling code here:
        btnProyectos.setBackground(new Color (0,255,204));
    }//GEN-LAST:event_btnProyectosMouseEntered

    private void btnProyectosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProyectosMouseExited
        // TODO add your handling code here:
        btnProyectos.setBackground(new Color (0,204,204));
    }//GEN-LAST:event_btnProyectosMouseExited

    private void btnFuncionariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionariosMouseEntered
        // TODO add your handling code here:
        btnFuncionarios.setBackground(new Color (255,204,102));
    }//GEN-LAST:event_btnFuncionariosMouseEntered

    private void btnFuncionariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuncionariosMouseExited
        // TODO add your handling code here:
        btnFuncionarios.setBackground(new Color (255,153,51));
    }//GEN-LAST:event_btnFuncionariosMouseExited

    private void btnReunionesInspeccionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReunionesInspeccionesMouseEntered
        // TODO add your handling code here:
        btnReunionesInspecciones.setBackground(new Color (0,204,102));
    }//GEN-LAST:event_btnReunionesInspeccionesMouseEntered

    private void btnReunionesInspeccionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReunionesInspeccionesMouseExited
        // TODO add your handling code here:
        btnReunionesInspecciones.setBackground(new Color (0,153,102));
    }//GEN-LAST:event_btnReunionesInspeccionesMouseExited

    private void btnMaterialesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaterialesMouseEntered
        // TODO add your handling code here:
        btnMateriales.setBackground(new Color (255,204,0));
    }//GEN-LAST:event_btnMaterialesMouseEntered

    private void btnMaterialesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaterialesMouseExited
        // TODO add your handling code here:
        btnMateriales.setBackground(new Color (204,204,0));
    }//GEN-LAST:event_btnMaterialesMouseExited

    private void btnHerramientasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHerramientasMouseEntered
        // TODO add your handling code here:
        btnHerramientas.setBackground(new Color (255,0,51));
    }//GEN-LAST:event_btnHerramientasMouseEntered

    private void btnHerramientasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHerramientasMouseExited
        // TODO add your handling code here:
        btnHerramientas.setBackground(new Color (204,0,0));
    }//GEN-LAST:event_btnHerramientasMouseExited

    private void btnCotizacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCotizacionesMouseEntered
        // TODO add your handling code here:
        btnCotizaciones.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnCotizacionesMouseEntered

    private void btnCotizacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCotizacionesMouseExited
        // TODO add your handling code here:
        btnCotizaciones.setBackground(new Color (0,102,102));
    }//GEN-LAST:event_btnCotizacionesMouseExited

    private void btnRecursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecursosMouseEntered
        // TODO add your handling code here:
        btnRecursos.setBackground(new Color (0,0,204));
    }//GEN-LAST:event_btnRecursosMouseEntered

    private void btnRecursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecursosMouseExited
        // TODO add your handling code here:
        btnRecursos.setBackground(new Color (0,0,153));
    }//GEN-LAST:event_btnRecursosMouseExited

    private void btnHitoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitoMouseEntered
        // TODO add your handling code here:
        btnHito.setBackground(new Color (255,51,255));
    }//GEN-LAST:event_btnHitoMouseEntered

    private void btnHitoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitoMouseExited
        // TODO add your handling code here:
        btnHito.setBackground(new Color (204,0,204));
    }//GEN-LAST:event_btnHitoMouseExited

    private void btnCuentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuentasMouseEntered
        // TODO add your handling code here:
        btnCuentas.setBackground(new Color (204,204,204));
    }//GEN-LAST:event_btnCuentasMouseEntered

    private void btnCuentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuentasMouseExited
        // TODO add your handling code here:
        btnCuentas.setBackground(new Color (153,153,153));
    }//GEN-LAST:event_btnCuentasMouseExited

    private void btnCotizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCotizacionesMouseClicked
        // TODO add your handling code here:
        GUI_Cotizaciones cot = new GUI_Cotizaciones();
        cot.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCotizacionesMouseClicked

    private void btnRecursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecursosMouseClicked
        // TODO add your handling code here:
        GUI_AsignacionRecursos asig = new GUI_AsignacionRecursos();
        asig.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRecursosMouseClicked

    private void btnHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHerramientasMouseClicked
        // TODO add your handling code here:
        GUI_ArriendoHerramienta arr = new GUI_ArriendoHerramienta();
        arr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHerramientasMouseClicked

    private void btnProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProyectosMouseClicked
        // TODO add your handling code here:
        GUI_Proyectos pro = new GUI_Proyectos();
        pro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProyectosMouseClicked

    private void btnMaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaterialesMouseClicked
        // TODO add your handling code here:
        GUI_Materiales mat = new GUI_Materiales();
        mat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMaterialesMouseClicked

    private void btnHitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHitoMouseClicked
        // TODO add your handling code here:
        GUI_Hitos hit = new GUI_Hitos();
        hit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHitoMouseClicked

    private void btnReunionesInspeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReunionesInspeccionesMouseClicked
        // TODO add your handling code here:
        GUI_Reuniones_Inspecciones re = new GUI_Reuniones_Inspecciones();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReunionesInspeccionesMouseClicked

    private void btnCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuentasMouseClicked
        // TODO add your handling code here:
        GUI_Cuenta cu = new GUI_Cuenta();
        cu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCuentasMouseClicked

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCotizaciones;
    private javax.swing.JPanel btnCuentas;
    private javax.swing.JPanel btnFuncionarios;
    private javax.swing.JPanel btnHerramientas;
    private javax.swing.JPanel btnHito;
    private javax.swing.JPanel btnMateriales;
    private javax.swing.JPanel btnProyectos;
    private javax.swing.JPanel btnRecursos;
    private javax.swing.JPanel btnReunionesInspecciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDate;
    // End of variables declaration//GEN-END:variables
}
