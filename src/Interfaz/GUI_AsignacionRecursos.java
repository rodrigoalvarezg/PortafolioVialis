/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Conexion.Conexion;
import Negocio.TLogin;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Modelo.ComboTrabajador;
import Negocio.RecursosConsultas;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class GUI_AsignacionRecursos extends javax.swing.JFrame {

    TLogin tLogin = new TLogin();
    int xMouse;
    int yMouse;
    Conexion con = new Conexion();
    ArrayList<String> trab = new ArrayList<String>();
    ArrayList<String> mat = new ArrayList<String>();
    ArrayList<String> cant = new ArrayList<String>();

    public GUI_AsignacionRecursos() {
        initComponents();
        this.setLocationRelativeTo(null);
        muestraFecha();
        llenar_tblSeleccionarObra_Personal();
        llenar_jTable1();
        jLabel3.setText(tLogin.getUsuario());
        llenarCbTrabajadores();
        llenarTablaMateriales();
    }

    void llenarCbTrabajadores() {
        try {
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT RUN_TRAB, APELLIDO_PAT_TRAB||' '||NOMBRE_TRAB \"NOMBRE_AP\" FROM TRABAJADOR ORDER BY APELLIDO_PAT_TRAB")) {
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                modeloCombo.addElement(new ComboTrabajador("0", "Seleccione..."));
                jcbFuncionario.setModel(modeloCombo);
                while (rs.next()) {
                    modeloCombo.addElement(new ComboTrabajador(rs.getString("RUN_TRAB"), rs.getString("NOMBRE_AP")));
                }
                rs.close();
            }
        } catch (Exception ex) {

        }
    }

    void muestraFecha() {
        //Muestra la fecha en el label
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat();
        lblDate.setText(s.format(d));
        /*Función para mostrar la fecha actual en el menú*/
    }

    void llenarTablaMateriales() {
        try {
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MATERIAL");
            DefaultTableModel value = new DefaultTableModel();
            tblInventario_Asignar.setModel(value);
            value.addColumn("ID");
            value.addColumn("NOMBRE");
            value.addColumn("STOCK");
            tblInventario_Asignar.getColumnModel().getColumn(0).setMaxWidth(0);
            tblInventario_Asignar.getColumnModel().getColumn(0).setMinWidth(0);
            tblInventario_Asignar.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblInventario_Asignar.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            tblInventario_Asignar.getColumnModel().getColumn(2).setMaxWidth(0);
            tblInventario_Asignar.getColumnModel().getColumn(2).setMinWidth(0);
            tblInventario_Asignar.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
            tblInventario_Asignar.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
            while (rs.next()) {
                value.addRow(new Object[]{rs.getString("ID_MAT"), rs.getString("NOMBRE_MAT"), rs.getString("STOCK_MAT")});
            }
            rs.close();
        } catch (Exception e) {

        }
    }

    void llenar_tblSeleccionarObra_Personal() {
        try {
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM PROYECTO")) {
                DefaultTableModel modeloTabla = new DefaultTableModel();
                tblSeleccionarObra_Personal.setModel(modeloTabla);
                modeloTabla.addColumn("ID");
                modeloTabla.addColumn("NOMBRE");
                tblSeleccionarObra_Personal.getColumnModel().getColumn(0).setMaxWidth(0);
                tblSeleccionarObra_Personal.getColumnModel().getColumn(0).setMinWidth(0);
                tblSeleccionarObra_Personal.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                tblSeleccionarObra_Personal.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                while (rs.next()) {
                    modeloTabla.addRow(new Object[]{rs.getString("ID_PROY"), rs.getString("NOMBRE_PROY")});
                }
                rs.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void llenar_jTable1() {
        try {
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM PROYECTO")) {
                DefaultTableModel modeloTabla = new DefaultTableModel();
                jTable1.setModel(modeloTabla);
                modeloTabla.addColumn("ID");
                modeloTabla.addColumn("NOMBRE");
                jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                while (rs.next()) {
                    modeloTabla.addRow(new Object[]{rs.getString("ID_PROY"), rs.getString("NOMBRE_PROY")});
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void llenarTablaAsignados() {
        String material;
        String cantidad;
        DefaultTableModel modeloTabla = (DefaultTableModel) tblAsignados.getModel();
        tblAsignados.setModel(modeloTabla);
        material = lblMaterialSeleccionado.getText();
        cantidad = txtNombreFunEdit1.getText();
        modeloTabla.addRow(new Object[]{material, cantidad});
        cant.add(cantidad);
        
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
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir_Fun = new javax.swing.JLabel();
        btnAtras_Fun = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnAsignarPersonal = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAsignarRecursos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PanelMenuAsignacion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        Panel_AsignarPersonal = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSeleccionarObra_Personal = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFuncionariosAsignados = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnAgregarFun = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jcbFuncionario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnAsignarFun = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        btnLimpiarAsig_fun = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        Panel_AsignarRecursos = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsignados = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInventario_Asignar = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarFun = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        lblMaterialSeleccionado = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        txtNombreFunEdit1 = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnEditarFun = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btnLimpiarEditFun = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        Drag = new javax.swing.JPanel();
        FrameDrag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("jLabel6");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 21, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 17, -1, -1));

        btnSalir_Fun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CERRAR_MINI_ICON.png"))); // NOI18N
        btnSalir_Fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalir_FunMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalir_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(932, 13, -1, -1));

        btnAtras_Fun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ATRAS_MINI_ICON.png"))); // NOI18N
        btnAtras_Fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtras_FunMouseClicked(evt);
            }
        });
        jPanel1.add(btnAtras_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 13, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("USER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 17, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/USER_MINI_ICON_MAINMENU.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 21, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSTRUCTORA VIALIS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 12, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CALENDARIO_MINI_ICON_MAINMENU.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 21, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 52, 957, 13));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAsignarPersonal.setBackground(new java.awt.Color(255, 102, 0));
        btnAsignarPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarPersonalMouseClicked(evt);
            }
        });
        btnAsignarPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Personal");
        btnAsignarPersonal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/INSERTARUSUARIO_FUNCIONARIOS.png"))); // NOI18N
        btnAsignarPersonal.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel3.add(btnAsignarPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 130));

        btnAsignarRecursos.setBackground(new java.awt.Color(51, 0, 204));
        btnAsignarRecursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarRecursosMouseClicked(evt);
            }
        });
        btnAsignarRecursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Recursos");
        btnAsignarRecursos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edicion.png"))); // NOI18N
        btnAsignarRecursos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 20, 70, -1));

        jPanel3.add(btnAsignarRecursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 140, 130));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 83, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.CardLayout());

        PanelMenuAsignacion.setBackground(new java.awt.Color(102, 102, 255));
        PanelMenuAsignacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("¡Bienvenido al menú de asignación de recursos!");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Asigna funcionarios y materiales a los proyectos cursados de Vialis.");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AsignarRecursos_Asignacion.png"))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Funciones disponibles: ");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("1.- Asignar Personal");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("2.- Asignar Materiales");

        javax.swing.GroupLayout PanelMenuAsignacionLayout = new javax.swing.GroupLayout(PanelMenuAsignacion);
        PanelMenuAsignacion.setLayout(PanelMenuAsignacionLayout);
        PanelMenuAsignacionLayout.setHorizontalGroup(
            PanelMenuAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuAsignacionLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addGroup(PanelMenuAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(PanelMenuAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelMenuAsignacionLayout.createSequentialGroup()
                            .addGroup(PanelMenuAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel54)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addComponent(jLabel52)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        PanelMenuAsignacionLayout.setVerticalGroup(
            PanelMenuAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuAsignacionLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addGroup(PanelMenuAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuAsignacionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56))
                    .addGroup(PanelMenuAsignacionLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11)))
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jPanel2.add(PanelMenuAsignacion, "card7");

        Panel_AsignarPersonal.setBackground(new java.awt.Color(102, 102, 255));
        Panel_AsignarPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Asignación de Personal");
        Panel_AsignarPersonal.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Seleccione una obra...");
        Panel_AsignarPersonal.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        tblSeleccionarObra_Personal.setBackground(new java.awt.Color(252, 251, 251));
        tblSeleccionarObra_Personal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSeleccionarObra_Personal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Puente Cau Cau"},
                {"Castillo Ratinbum"},
                {"Centro Pokémon"},
                {"Acuario de Jureles"}
            },
            new String [] {
                "NOMBRE DE OBRA"
            }
        ));
        tblSeleccionarObra_Personal.setGridColor(new java.awt.Color(255, 255, 255));
        tblSeleccionarObra_Personal.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblSeleccionarObra_Personal.setShowHorizontalLines(false);
        tblSeleccionarObra_Personal.setShowVerticalLines(false);
        tblSeleccionarObra_Personal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSeleccionarObra_PersonalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSeleccionarObra_Personal);

        Panel_AsignarPersonal.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 640, 130));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        Panel_AsignarPersonal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 780, 10));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Funcionarios");
        Panel_AsignarPersonal.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setForeground(new java.awt.Color(255, 255, 255));

        tblFuncionariosAsignados.setBackground(new java.awt.Color(252, 251, 251));
        tblFuncionariosAsignados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblFuncionariosAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUT", "NOMBRE"
            }
        ));
        tblFuncionariosAsignados.setGridColor(new java.awt.Color(255, 255, 255));
        tblFuncionariosAsignados.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblFuncionariosAsignados.setShowHorizontalLines(false);
        tblFuncionariosAsignados.setShowVerticalLines(false);
        jScrollPane5.setViewportView(tblFuncionariosAsignados);

        Panel_AsignarPersonal.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 430, 170));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarFun.setBackground(new java.awt.Color(255, 204, 51));
        btnAgregarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarFunMouseExited(evt);
            }
        });
        btnAgregarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("AGREGAR");
        btnAgregarFun.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel5.add(btnAgregarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 110, 40));

        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 10));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Seleccione Funcionario:");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jcbFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFuncionario.setEnabled(false);
        jcbFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFuncionarioItemStateChanged(evt);
            }
        });
        jPanel5.add(jcbFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, -1));

        Panel_AsignarPersonal.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 260, 170));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Flecha_Asignacion.png"))); // NOI18N
        Panel_AsignarPersonal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Asignados");
        Panel_AsignarPersonal.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        btnAsignarFun.setBackground(new java.awt.Color(0, 153, 153));
        btnAsignarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAsignarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAsignarFunMouseExited(evt);
            }
        });
        btnAsignarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ASIGNAR");
        btnAsignarFun.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Panel_AsignarPersonal.add(btnAsignarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 100, 50));

        btnLimpiarAsig_fun.setBackground(new java.awt.Color(204, 51, 0));
        btnLimpiarAsig_fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarAsig_funMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarAsig_funMouseExited(evt);
            }
        });
        btnLimpiarAsig_fun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("LIMPIAR");
        btnLimpiarAsig_fun.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Panel_AsignarPersonal.add(btnLimpiarAsig_fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 100, 50));

        jPanel2.add(Panel_AsignarPersonal, "card3");

        Panel_AsignarRecursos.setBackground(new java.awt.Color(102, 102, 255));
        Panel_AsignarRecursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Asignación de Materiales");
        Panel_AsignarRecursos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Seleccione una obra...");
        Panel_AsignarRecursos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(252, 251, 251));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Puente Cau Cau"},
                {"Castillo Ratinbum"},
                {"Centro Pokémon"},
                {"Acuario de Jureles"}
            },
            new String [] {
                "NOMBRE DE OBRA"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 102));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Panel_AsignarRecursos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 640, 130));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        Panel_AsignarRecursos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 780, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Asignados");
        Panel_AsignarRecursos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        tblAsignados.setBackground(new java.awt.Color(252, 251, 251));
        tblAsignados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CANTIDAD"
            }
        ));
        tblAsignados.setGridColor(new java.awt.Color(255, 255, 255));
        tblAsignados.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblAsignados.setShowHorizontalLines(false);
        tblAsignados.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tblAsignados);

        Panel_AsignarRecursos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 220, 230));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        tblInventario_Asignar.setBackground(new java.awt.Color(252, 251, 251));
        tblInventario_Asignar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblInventario_Asignar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"MARTILLO"},
                {"POLLO GRITON"},
                {"TACHUELAS"},
                {null}
            },
            new String [] {
                "NOMBRE"
            }
        ));
        tblInventario_Asignar.setGridColor(new java.awt.Color(255, 255, 255));
        tblInventario_Asignar.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblInventario_Asignar.setShowHorizontalLines(false);
        tblInventario_Asignar.setShowVerticalLines(false);
        tblInventario_Asignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventario_AsignarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblInventario_Asignar);

        Panel_AsignarRecursos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 230, 230));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Material Seleccionado:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cantidad Disponible:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btnBuscarFun.setBackground(new java.awt.Color(255, 204, 51));
        btnBuscarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarFunMouseExited(evt);
            }
        });
        btnBuscarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("AGREGAR");
        btnBuscarFun.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel4.add(btnBuscarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 110, 40));

        lblMaterialSeleccionado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMaterialSeleccionado.setForeground(new java.awt.Color(255, 255, 255));
        lblMaterialSeleccionado.setText("Seleccione un material...");
        jPanel4.add(lblMaterialSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Ingrese Cantidad:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtNombreFunEdit1.setBackground(new java.awt.Color(102, 102, 255));
        txtNombreFunEdit1.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreFunEdit1.setText("Ingrese cantidad a solicitar...");
        txtNombreFunEdit1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombreFunEdit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreFunEdit1MouseClicked(evt);
            }
        });
        jPanel4.add(txtNombreFunEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 192, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Seleccione un material...");
        jPanel4.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        Panel_AsignarRecursos.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 260, 230));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Flecha_Asignacion.png"))); // NOI18N
        Panel_AsignarRecursos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Inventario");
        Panel_AsignarRecursos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        btnEditarFun.setBackground(new java.awt.Color(0, 153, 153));
        btnEditarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarFunMouseExited(evt);
            }
        });
        btnEditarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("ASIGNAR");
        btnEditarFun.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Panel_AsignarRecursos.add(btnEditarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 100, 50));

        btnLimpiarEditFun.setBackground(new java.awt.Color(204, 51, 0));
        btnLimpiarEditFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarEditFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarEditFunMouseExited(evt);
            }
        });
        btnLimpiarEditFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("LIMPIAR");
        btnLimpiarEditFun.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Panel_AsignarRecursos.add(btnLimpiarEditFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 100, 50));

        jPanel2.add(Panel_AsignarRecursos, "card2");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        Drag.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout DragLayout = new javax.swing.GroupLayout(Drag);
        Drag.setLayout(DragLayout);
        DragLayout.setHorizontalGroup(
            DragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        DragLayout.setVerticalGroup(
            DragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(Drag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 60));

        FrameDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FrameDragMouseDragged(evt);
            }
        });
        FrameDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FrameDragMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FrameDragMousePressed(evt);
            }
        });
        jPanel1.add(FrameDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 981, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalir_FunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalir_FunMouseClicked
        // TODO add your handling code here:
        new Mensajes_SalirAp().setVisible(true);
    }//GEN-LAST:event_btnSalir_FunMouseClicked

    private void btnAtras_FunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtras_FunMouseClicked
        // TODO add your handling code here:
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtras_FunMouseClicked

    private void btnAsignarPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarPersonalMouseClicked
        // TODO add your handling code here:

        btnAsignarPersonal.setBackground(new Color(255, 204, 153));
        btnAsignarRecursos.setBackground(new Color(51, 0, 204));

        PanelMenuAsignacion.setVisible(false);
        Panel_AsignarPersonal.setVisible(true);
        Panel_AsignarRecursos.setVisible(false);


    }//GEN-LAST:event_btnAsignarPersonalMouseClicked

    private void btnAsignarRecursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarRecursosMouseClicked
        // TODO add your handling code here:
        btnAsignarPersonal.setBackground(new Color(255, 102, 0));
        btnAsignarRecursos.setBackground(new Color(204, 204, 255));

        PanelMenuAsignacion.setVisible(false);
        Panel_AsignarPersonal.setVisible(false);
        Panel_AsignarRecursos.setVisible(true);


    }//GEN-LAST:event_btnAsignarRecursosMouseClicked

    private void btnBuscarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunMouseEntered
        // TODO add your handling code here:
        btnBuscarFun.setBackground(new Color(255, 204, 153));
    }//GEN-LAST:event_btnBuscarFunMouseEntered

    private void btnBuscarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunMouseExited
        // TODO add your handling code here:
        btnBuscarFun.setBackground(new Color(255, 204, 51));
    }//GEN-LAST:event_btnBuscarFunMouseExited

    private void btnEditarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFunMouseEntered
        // TODO add your handling code here:
        btnEditarFun.setBackground(new Color(0, 204, 153));
    }//GEN-LAST:event_btnEditarFunMouseEntered

    private void btnEditarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFunMouseExited
        // TODO add your handling code here:
        btnEditarFun.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_btnEditarFunMouseExited

    private void btnLimpiarEditFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseEntered
        // TODO add your handling code here:
        btnLimpiarEditFun.setBackground(new Color(255, 51, 0));
    }//GEN-LAST:event_btnLimpiarEditFunMouseEntered

    private void btnLimpiarEditFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseExited
        // TODO add your handling code here:
        btnLimpiarEditFun.setBackground(new Color(204, 51, 0));
    }//GEN-LAST:event_btnLimpiarEditFunMouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modeloTabla = (DefaultTableModel) tblAsignados.getModel();
        tblAsignados.setModel(modeloTabla);
        for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
            modeloTabla.removeRow(i);
        }
        
        tblInventario_Asignar.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void tblInventario_AsignarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventario_AsignarMouseClicked
        // TODO add your handling code here:
        int column = 1;
        int row = tblInventario_Asignar.getSelectedRow();
        String value = tblInventario_Asignar.getModel().getValueAt(row, column).toString();
        String cantidad = tblInventario_Asignar.getModel().getValueAt(row, 2).toString();
        lblMaterialSeleccionado.setText(value);
        lblCantidad.setText(cantidad);
        txtNombreFunEdit1.setText("");
    }//GEN-LAST:event_tblInventario_AsignarMouseClicked

    private void tblSeleccionarObra_PersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeleccionarObra_PersonalMouseClicked

        DefaultTableModel modeloTabla = (DefaultTableModel) tblSeleccionarObra_Personal.getModel();
        String id_proyecto = String.valueOf(modeloTabla.getValueAt(tblSeleccionarObra_Personal.getSelectedRow(), 0));
        jcbFuncionario.setEnabled(true);

        DefaultTableModel mt = new DefaultTableModel();
        tblFuncionariosAsignados.setModel(mt);
        mt.addColumn("RUT");
        mt.addColumn("NOMBRE");

        try {
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();

            try (ResultSet rs = stmt.executeQuery("SELECT TRABAJADOR_RUN_TRAB FROM PROY_TRAB WHERE PROYECTO_ID_PROY='" + id_proyecto + "'")) {

                while (rs.next()) {

                    try (ResultSet rs2 = stmt.executeQuery("SELECT * FROM TRABAJADOR WHERE RUN_TRAB='" + rs.getString("TRABAJADOR_RUN_TRAB") + "'")) {

                        mt.addRow(new Object[]{rs2.getString("RUN_TRAB"), rs2.getString("NOMBRE_TRAB")});
                    }
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }//GEN-LAST:event_tblSeleccionarObra_PersonalMouseClicked

    private void btnAgregarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarFunMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarFunMouseEntered

    private void btnAgregarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarFunMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarFunMouseExited

    private void btnAsignarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarFunMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarFunMouseEntered

    private void btnAsignarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarFunMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarFunMouseExited

    private void btnLimpiarAsig_funMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarAsig_funMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarAsig_funMouseEntered

    private void btnLimpiarAsig_funMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarAsig_funMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarAsig_funMouseExited

    private void txtNombreFunEdit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreFunEdit1MouseClicked
        // TODO add your handling code here:
        txtNombreFunEdit1.setText("");
    }//GEN-LAST:event_txtNombreFunEdit1MouseClicked

    private void btnAgregarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarFunMouseClicked
        // TODO add your handling code here:
        ComboTrabajador ct = (ComboTrabajador) jcbFuncionario.getSelectedItem();
        if (!ct.getNombre().equals("Seleccione...")) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tblFuncionariosAsignados.getModel();
            tblFuncionariosAsignados.setModel(modeloTabla);
            String run = ((ComboTrabajador) ct).getRut();
            String nombre = ((ComboTrabajador) ct).getNombre();
            int numero = 0;

            if (modeloTabla.getRowCount() != 0) {
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    if (!modeloTabla.getValueAt(i, 0).toString().equals(run)) {
                        numero = 0;
                    } else {
                        numero = numero + 1;
                        break;
                    }
                }
                if (numero != 0) {
                    JOptionPane.showMessageDialog(null, "Ya esta el Funcionario");
                } else {
                    modeloTabla.addRow(new Object[]{run, nombre});
                    trab.add(run);
                }
            } else {
                modeloTabla.addRow(new Object[]{run, nombre});
                trab.add(run);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un funcionario");
        }
    }//GEN-LAST:event_btnAgregarFunMouseClicked

    private void FrameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen(); //para rescatar el valor X de la posición de la ventana
        int y = evt.getYOnScreen(); //para rescatar el valor Y de la posición de la ventana

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDragMouseDragged

    private void FrameDragMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FrameDragMouseClicked

    private void FrameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDragMousePressed

    private void jcbFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFuncionarioItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jcbFuncionarioItemStateChanged

    private void btnAsignarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarFunMouseClicked
        // TODO add your handling code here:
        if (tblSeleccionarObra_Personal.getSelectedColumn() == 1) {
            String run;
            RecursosConsultas rc = new RecursosConsultas();
            DefaultTableModel om = (DefaultTableModel) tblSeleccionarObra_Personal.getModel();
            String id_proy = String.valueOf(om.getValueAt(tblSeleccionarObra_Personal.getSelectedRow(), 0));

            for (int i = 0; i < trab.size(); i++) {
                run = trab.get(i);
                rc.agregarFuncionarios(id_proy, run);
            }
            trab.removeAll(trab);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una obra.");
        }

    }//GEN-LAST:event_btnAsignarFunMouseClicked

    private void btnBuscarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunMouseClicked
        // TODO add your handling code here:
        if (tblInventario_Asignar.getSelectedColumn() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar material.");
        } else {
            llenarTablaAsignados();
            DefaultTableModel tm = (DefaultTableModel) tblInventario_Asignar.getModel();
            String id_material = String.valueOf(tm.getValueAt(tblInventario_Asignar.getSelectedRow(), 0));
            mat.add(id_material);
        }
    }//GEN-LAST:event_btnBuscarFunMouseClicked

    private void btnEditarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFunMouseClicked
        // TODO add your handling code here:
        if (jTable1.getSelectedColumn()!=1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una obra.");
        } else {
            DefaultTableModel om = (DefaultTableModel) jTable1.getModel();
            String id_proyecto = String.valueOf(om.getValueAt(jTable1.getSelectedRow(), 0));
            String id_mat;
            int cantidad;
            RecursosConsultas rc = new RecursosConsultas();
            for (int i = 0; i < mat.size(); i++) {
                id_mat = mat.get(i);
                cantidad = Integer.parseInt(cant.get(i));
                rc.agregarRecurso(id_mat, id_proyecto, cantidad);
            }
        }
        mat.removeAll(mat);
        cant.removeAll(mat);
    }//GEN-LAST:event_btnEditarFunMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_AsignacionRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_AsignacionRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_AsignacionRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_AsignacionRecursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_AsignacionRecursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Drag;
    private javax.swing.JLabel FrameDrag;
    private javax.swing.JPanel PanelMenuAsignacion;
    private javax.swing.JPanel Panel_AsignarPersonal;
    private javax.swing.JPanel Panel_AsignarRecursos;
    private javax.swing.JPanel btnAgregarFun;
    private javax.swing.JPanel btnAsignarFun;
    private javax.swing.JPanel btnAsignarPersonal;
    private javax.swing.JPanel btnAsignarRecursos;
    private javax.swing.JLabel btnAtras_Fun;
    private javax.swing.JPanel btnBuscarFun;
    private javax.swing.JPanel btnEditarFun;
    private javax.swing.JPanel btnLimpiarAsig_fun;
    private javax.swing.JPanel btnLimpiarEditFun;
    private javax.swing.JLabel btnSalir_Fun;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbFuncionario;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMaterialSeleccionado;
    private javax.swing.JTable tblAsignados;
    private javax.swing.JTable tblFuncionariosAsignados;
    private javax.swing.JTable tblInventario_Asignar;
    private javax.swing.JTable tblSeleccionarObra_Personal;
    private javax.swing.JTextField txtNombreFunEdit1;
    // End of variables declaration//GEN-END:variables
}
