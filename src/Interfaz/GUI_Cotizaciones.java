/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import Conexion.Conexion;
import java.sql.*;
import Negocio.*;
import Modelo.*;
import java.io.FileInputStream;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Esteban
 */
public class GUI_Cotizaciones extends javax.swing.JFrame {

    TLogin tLogin = new TLogin();
    /**
     * Creates new form GUI_Cotizaciones
     */
    FileInputStream myFile;
    long lon;
    Conexion con = new Conexion();
    public GUI_Cotizaciones() {
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
    
    void llenarTabla(){
        
        try {
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MATERIAL ORDER BY NOMBRE_MAT");
                DefaultTableModel value = new DefaultTableModel();
                jTable1.setModel(value);
                value.addColumn("NOMBRE");
            value.addColumn("ID");
            //Oculta la Columna ID 
            jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            jTable1.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            //------
            
                while(rs.next()){
                    Material m = new Material(rs.getString("ID_MAT"), rs.getString("NOMBRE_MAT"));
                    value.addRow(new Object[]{m.getNombre_mat(),m.getId_mat()});
                }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void llenarTablaServicio(){
        try {
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SERVICIO ORDER BY NOMBRE_SERV");
                DefaultTableModel value = new DefaultTableModel();
                tblServicios.setModel(value);
                value.addColumn("NOMBRE");
            value.addColumn("ID");
            //Oculta la Columna ID 
            tblServicios.getColumnModel().getColumn(1).setMaxWidth(0);
            tblServicios.getColumnModel().getColumn(1).setMinWidth(0);
            tblServicios.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            tblServicios.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            //------
                while(rs.next()){
                    value.addRow(new Object[]{rs.getString("NOMBRE_SERV"),rs.getString("ID_SERV")});
                }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void llenarTablaCotServicio(){
        try {
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT C.CODIGO_COT,S.NOMBRE_SERV,C.FECHA_COT,C.ACEPTACION_COT FROM COTI_SERV C JOIN SERVICIO S ON (C.SERVICIO_ID_SERV=S.ID_SERV) ORDER BY S.NOMBRE_SERV,C.FECHA_COT");
                DefaultTableModel value = new DefaultTableModel();
                tblAceptacionCotizacionesServ.setModel(value);
                value.addColumn("ID");
            value.addColumn("SERVICIO");
                value.addColumn("FECHA");
            value.addColumn("ESTADO DE COTIZACION");
            tblAceptacionCotizacionesServ.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAceptacionCotizacionesServ.getColumnModel().getColumn(0).setMinWidth(0);
            tblAceptacionCotizacionesServ.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblAceptacionCotizacionesServ.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                while(rs.next()){
                if(rs.getString("ACEPTACION_COT").equals("R")){
               value.addRow(new Object[]{rs.getString("CODIGO_COT"),rs.getString("NOMBRE_SERV"),rs.getString("FECHA_COT"),"RECHAZADA"});
                }else if(rs.getString("ACEPTACION_COT").equals("A")){
                    value.addRow(new Object[]{rs.getString("CODIGO_COT"),rs.getString("NOMBRE_SERV"),rs.getString("FECHA_COT"),"ACEPTADA"});
                }else{
                    value.addRow(new Object[]{rs.getString("CODIGO_COT"),rs.getString("NOMBRE_SERV"),rs.getString("FECHA_COT"),"PENDIENTE"});
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void llenarTablaCotMaterial(){
        try {
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT C.CODIGO_COT,M.NOMBRE_MAT,C.FECHA_COT,C.ACEPTACION_COT FROM COTI_MAT C JOIN MATERIAL M ON (C.MATERIAL_ID_MAT=M.ID_MAT) ORDER BY M.NOMBRE_MAT,C.FECHA_COT");
                DefaultTableModel value = new DefaultTableModel();
                tblAceptacionCotizaciones.setModel(value);
                value.addColumn("ID");
            value.addColumn("MATERIAL");
                value.addColumn("FECHA");
                value.addColumn("ESTADO");
            tblAceptacionCotizaciones.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAceptacionCotizaciones.getColumnModel().getColumn(0).setMinWidth(0);
            tblAceptacionCotizaciones.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            tblAceptacionCotizaciones.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
                while(rs.next()){
                if(rs.getString("ACEPTACION_COT").equals("R")){
                    value.addRow(new Object[]{rs.getString("CODIGO_COT"),rs.getString("NOMBRE_MAT"),rs.getString("FECHA_COT"),"RECHAZADA"});
                }else if(rs.getString("ACEPTACION_COT").equals("A")){
                    value.addRow(new Object[]{rs.getString("CODIGO_COT"),rs.getString("NOMBRE_MAT"),rs.getString("FECHA_COT"),"ACEPTADA"});
                }else{
                    value.addRow(new Object[]{rs.getString("CODIGO_COT"),rs.getString("NOMBRE_MAT"),rs.getString("FECHA_COT"),"PENDIENTE"});
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
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

        jSeparator4 = new javax.swing.JSeparator();
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
        PanelMenuCotizaciones = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        PanelAceptacionMateriales = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAceptacionCotizaciones = new javax.swing.JTable();
        btnDescargarCotProd = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        btnAceptarCotProd = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btnLimpiarEditFun = new javax.swing.JPanel();
        btnRechazarCotProd = new javax.swing.JLabel();
        PanelCotizacionProducto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAbrirCot = new javax.swing.JPanel();
        lblAbrirCot = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSubirCot = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        PanelCotizacionServicio = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnAbrirCotServicio = new javax.swing.JPanel();
        lblAbrirCot1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnSubirCotServicio = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        PanelAceptacionServicios = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAceptacionCotizacionesServ = new javax.swing.JTable();
        btnDescargarCotServ = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        btnAceptarCotServ = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        btnRechazarCotServ = new javax.swing.JPanel();
        btnRechazarCotProd1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnCotizacionMateriales = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnCotizacionServicios = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnAceptacionMateriales = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAceptacionServ = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("jLabel6");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 22, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 18, -1, -1));

        btnSalir_Fun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CERRAR_MINI_ICON.png"))); // NOI18N
        btnSalir_Fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalir_FunMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalir_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 14, -1, -1));

        btnAtras_Fun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ATRAS_MINI_ICON.png"))); // NOI18N
        btnAtras_Fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtras_FunMouseClicked(evt);
            }
        });
        jPanel1.add(btnAtras_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 14, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("USER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 18, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/USER_MINI_ICON_MAINMENU.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 22, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSTRUCTORA VIALIS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CALENDARIO_MINI_ICON_MAINMENU.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 22, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, 806, 13));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.CardLayout());

        PanelMenuCotizaciones.setBackground(new java.awt.Color(102, 102, 255));
        PanelMenuCotizaciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("¡Bienvenido al menú de Cotizaciones!");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Sube cotizaciones de servicios y materiales, acéptalas y descargalas. ");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cotizaciones_Principal.png"))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Funciones disponibles: ");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("1.- Subir Cotización Material");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("2.- Subir Cotización Servicio");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("4.- Aceptación de Cotización Serv.");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("3.- Aceptación de Cotización Mat.");

        javax.swing.GroupLayout PanelMenuCotizacionesLayout = new javax.swing.GroupLayout(PanelMenuCotizaciones);
        PanelMenuCotizaciones.setLayout(PanelMenuCotizacionesLayout);
        PanelMenuCotizacionesLayout.setHorizontalGroup(
            PanelMenuCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuCotizacionesLayout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(PanelMenuCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(PanelMenuCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelMenuCotizacionesLayout.createSequentialGroup()
                            .addGroup(PanelMenuCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel54)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56)
                                .addComponent(jLabel57)
                                .addComponent(jLabel58))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25))
                        .addComponent(jLabel52)))
                .addGap(234, 234, 234))
        );
        PanelMenuCotizacionesLayout.setVerticalGroup(
            PanelMenuCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuCotizacionesLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addGroup(PanelMenuCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuCotizacionesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addGroup(PanelMenuCotizacionesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel25)))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jPanel3.add(PanelMenuCotizaciones, "card7");

        PanelAceptacionMateriales.setBackground(new java.awt.Color(102, 102, 255));
        PanelAceptacionMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Aceptación de Cotizaciones de Materiales");
        PanelAceptacionMateriales.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        tblAceptacionCotizaciones.setBackground(new java.awt.Color(252, 251, 251));
        tblAceptacionCotizaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAceptacionCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO O SERVICIO", "FECHA DE INGRESO", "ESTADO"
            }
        ));
        tblAceptacionCotizaciones.setGridColor(new java.awt.Color(255, 255, 255));
        tblAceptacionCotizaciones.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblAceptacionCotizaciones.setShowHorizontalLines(false);
        tblAceptacionCotizaciones.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblAceptacionCotizaciones);

        PanelAceptacionMateriales.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 740, 330));

        btnDescargarCotProd.setBackground(new java.awt.Color(255, 204, 51));
        btnDescargarCotProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDescargarCotProdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescargarCotProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescargarCotProdMouseExited(evt);
            }
        });
        btnDescargarCotProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("DESCARGAR");
        btnDescargarCotProd.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelAceptacionMateriales.add(btnDescargarCotProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 140, 50));

        btnAceptarCotProd.setBackground(new java.awt.Color(0, 153, 153));
        btnAceptarCotProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarCotProdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarCotProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarCotProdMouseExited(evt);
            }
        });
        btnAceptarCotProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("ACEPTAR");
        btnAceptarCotProd.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelAceptacionMateriales.add(btnAceptarCotProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 120, 50));

        btnLimpiarEditFun.setBackground(new java.awt.Color(204, 51, 0));
        btnLimpiarEditFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarEditFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarEditFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarEditFunMouseExited(evt);
            }
        });
        btnLimpiarEditFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRechazarCotProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRechazarCotProd.setForeground(new java.awt.Color(255, 255, 255));
        btnRechazarCotProd.setText("RECHAZAR");
        btnLimpiarEditFun.add(btnRechazarCotProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelAceptacionMateriales.add(btnLimpiarEditFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 130, 50));

        jPanel3.add(PanelAceptacionMateriales, "card4");

        PanelCotizacionProducto.setBackground(new java.awt.Color(102, 102, 255));
        PanelCotizacionProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ingreso de Cotizaciones");
        PanelCotizacionProducto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(252, 251, 251));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 102));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        PanelCotizacionProducto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 300, 360));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelCotizacionProducto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 430));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CARPETA_COTIZACIONES_64.png"))); // NOI18N
        PanelCotizacionProducto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Seleccione un producto");
        PanelCotizacionProducto.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        btnAbrirCot.setBackground(new java.awt.Color(0, 204, 204));
        btnAbrirCot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAbrirCot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirCotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAbrirCotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAbrirCotMouseExited(evt);
            }
        });
        btnAbrirCot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAbrirCot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAbrirCot.setForeground(new java.awt.Color(255, 255, 255));
        lblAbrirCot.setText("Abrir...");
        btnAbrirCot.add(lblAbrirCot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        PanelCotizacionProducto.add(btnAbrirCot, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 260, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Seleccione cotización...");
        PanelCotizacionProducto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        btnSubirCot.setBackground(new java.awt.Color(0, 153, 153));
        btnSubirCot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubirCotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubirCotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubirCotMouseExited(evt);
            }
        });
        btnSubirCot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("SUBIR");
        btnSubirCot.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        PanelCotizacionProducto.add(btnSubirCot, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 120, 50));

        jPanel3.add(PanelCotizacionProducto, "card2");

        PanelCotizacionServicio.setBackground(new java.awt.Color(102, 102, 255));
        PanelCotizacionServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ingreso de Cotizaciones");
        PanelCotizacionServicio.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        tblServicios.setBackground(new java.awt.Color(252, 251, 251));
        tblServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE"
            }
        ));
        tblServicios.setGridColor(new java.awt.Color(255, 255, 255));
        tblServicios.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblServicios.setShowHorizontalLines(false);
        tblServicios.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tblServicios);

        PanelCotizacionServicio.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 300, 360));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelCotizacionServicio.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 430));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CARPETA_COTIZACIONES_64.png"))); // NOI18N
        PanelCotizacionServicio.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Seleccione un Servicio");
        PanelCotizacionServicio.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        btnAbrirCotServicio.setBackground(new java.awt.Color(0, 204, 204));
        btnAbrirCotServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAbrirCotServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirCotServicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAbrirCotServicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAbrirCotServicioMouseExited(evt);
            }
        });
        btnAbrirCotServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAbrirCot1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAbrirCot1.setForeground(new java.awt.Color(255, 255, 255));
        lblAbrirCot1.setText("Abrir...");
        btnAbrirCotServicio.add(lblAbrirCot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        PanelCotizacionServicio.add(btnAbrirCotServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 260, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Seleccione cotización...");
        PanelCotizacionServicio.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        btnSubirCotServicio.setBackground(new java.awt.Color(0, 153, 153));
        btnSubirCotServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubirCotServicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubirCotServicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubirCotServicioMouseExited(evt);
            }
        });
        btnSubirCotServicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("SUBIR");
        btnSubirCotServicio.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        PanelCotizacionServicio.add(btnSubirCotServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 120, 50));

        jPanel3.add(PanelCotizacionServicio, "card3");

        PanelAceptacionServicios.setBackground(new java.awt.Color(102, 102, 255));
        PanelAceptacionServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Aceptación de Cotizaciones de Servicios");
        PanelAceptacionServicios.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        tblAceptacionCotizacionesServ.setBackground(new java.awt.Color(252, 251, 251));
        tblAceptacionCotizacionesServ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAceptacionCotizacionesServ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SERVICIO", "FECHA DE INGRESO", "ESTADO"
            }
        ));
        tblAceptacionCotizacionesServ.setGridColor(new java.awt.Color(255, 255, 255));
        tblAceptacionCotizacionesServ.setSelectionBackground(new java.awt.Color(0, 204, 102));
        tblAceptacionCotizacionesServ.setShowHorizontalLines(false);
        tblAceptacionCotizacionesServ.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tblAceptacionCotizacionesServ);

        PanelAceptacionServicios.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 740, 330));

        btnDescargarCotServ.setBackground(new java.awt.Color(255, 204, 51));
        btnDescargarCotServ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDescargarCotServMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescargarCotServMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescargarCotServMouseExited(evt);
            }
        });
        btnDescargarCotServ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("DESCARGAR");
        btnDescargarCotServ.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelAceptacionServicios.add(btnDescargarCotServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 140, 50));

        btnAceptarCotServ.setBackground(new java.awt.Color(0, 153, 153));
        btnAceptarCotServ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarCotServMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarCotServMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarCotServMouseExited(evt);
            }
        });
        btnAceptarCotServ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("ACEPTAR");
        btnAceptarCotServ.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelAceptacionServicios.add(btnAceptarCotServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 120, 50));

        btnRechazarCotServ.setBackground(new java.awt.Color(204, 51, 0));
        btnRechazarCotServ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRechazarCotServMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRechazarCotServMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRechazarCotServMouseExited(evt);
            }
        });
        btnRechazarCotServ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRechazarCotProd1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRechazarCotProd1.setForeground(new java.awt.Color(255, 255, 255));
        btnRechazarCotProd1.setText("RECHAZAR");
        btnRechazarCotServ.add(btnRechazarCotProd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelAceptacionServicios.add(btnRechazarCotServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 130, 50));

        jPanel3.add(PanelAceptacionServicios, "card4");

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 850, 540));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCotizacionMateriales.setBackground(new java.awt.Color(255, 102, 0));
        btnCotizacionMateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCotizacionMaterialesMouseClicked(evt);
            }
        });
        btnCotizacionMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cot. Materiales");
        btnCotizacionMateriales.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/COTIZACIONHERRAMIENTAS_COTIZACION.png"))); // NOI18N
        btnCotizacionMateriales.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(btnCotizacionMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 130));

        btnCotizacionServicios.setBackground(new java.awt.Color(51, 0, 204));
        btnCotizacionServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCotizacionServiciosMouseClicked(evt);
            }
        });
        btnCotizacionServicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cot. Servicios");
        btnCotizacionServicios.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/COTIZACIONSERVICIO_COTIZACIONES.png"))); // NOI18N
        btnCotizacionServicios.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 20, 70, -1));

        jPanel4.add(btnCotizacionServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 140, 130));

        btnAceptacionMateriales.setBackground(new java.awt.Color(204, 0, 204));
        btnAceptacionMateriales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptacionMaterialesMouseClicked(evt);
            }
        });
        btnAceptacionMateriales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Aceptación Mat.");
        btnAceptacionMateriales.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ACEPTACIONHERRAMIENTAS_COTIZACION.png"))); // NOI18N
        btnAceptacionMateriales.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(btnAceptacionMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 140, 130));

        btnAceptacionServ.setBackground(new java.awt.Color(0, 153, 153));
        btnAceptacionServ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptacionServMouseClicked(evt);
            }
        });
        btnAceptacionServ.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Aceptación Serv.");
        btnAceptacionServ.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ACEPTACIONSERVICIOS_COTIZACION.png"))); // NOI18N
        btnAceptacionServ.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 70));

        jPanel4.add(btnAceptacionServ, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 140, 130));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 560, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 760));

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

    private void btnSubirCotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirCotMouseEntered
        // TODO add your handling code here:
        btnSubirCot.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnSubirCotMouseEntered

    private void btnSubirCotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirCotMouseExited
        // TODO add your handling code here:
        btnSubirCot.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnSubirCotMouseExited

    private void btnAbrirCotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCotMouseEntered
        // TODO add your handling code here:
        btnAbrirCot.setBackground(new Color (51,255,255));
        
    }//GEN-LAST:event_btnAbrirCotMouseEntered

    private void btnAbrirCotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCotMouseExited
        // TODO add your handling code here:
        btnAbrirCot.setBackground(new Color (0,204,204));
    }//GEN-LAST:event_btnAbrirCotMouseExited

    private void btnAbrirCotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCotMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        
        if ( returnVal == JFileChooser.APPROVE_OPTION){
            File myFiles = chooser.getSelectedFile();
            lblAbrirCot.setText(myFiles+ "");
            long longitud = myFiles.length();
            try {
                FileInputStream myFile = new FileInputStream(myFiles);
                this.myFile = myFile;
                this.lon = longitud;
                
            } catch (Exception e) {
                System.out.println("Error archivo");
            }
        }
    }//GEN-LAST:event_btnAbrirCotMouseClicked

    private void btnCotizacionMaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCotizacionMaterialesMouseClicked
        // TODO add your handling code here:

        btnCotizacionMateriales.setBackground(new Color (255,204,153));
        btnCotizacionServicios.setBackground(new Color (51,0,204));
        btnAceptacionMateriales.setBackground(new Color (204,0,204));
        btnAceptacionServ.setBackground(new Color (0,153,153));

        PanelMenuCotizaciones.setVisible(false);
        PanelCotizacionProducto.setVisible(true);
        PanelCotizacionServicio.setVisible(false);
        PanelAceptacionMateriales.setVisible(false);
        PanelAceptacionServicios.setVisible(false);
        llenarTabla();

    }//GEN-LAST:event_btnCotizacionMaterialesMouseClicked

    private void btnCotizacionServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCotizacionServiciosMouseClicked
        // TODO add your handling code here:
        btnCotizacionMateriales.setBackground(new Color (255,102,0));
        btnCotizacionServicios.setBackground(new Color (204,204,255));
        btnAceptacionMateriales.setBackground(new Color (204,0,204));
        btnAceptacionServ.setBackground(new Color (0,153,153));

        PanelMenuCotizaciones.setVisible(false);
        PanelCotizacionProducto.setVisible(false);
        PanelCotizacionServicio.setVisible(true);
        PanelAceptacionMateriales.setVisible(false);
        PanelAceptacionServicios.setVisible(false);
        llenarTablaServicio();
    }//GEN-LAST:event_btnCotizacionServiciosMouseClicked

    private void btnAceptacionMaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptacionMaterialesMouseClicked
        // TODO add your handling code here:
        btnCotizacionMateriales.setBackground(new Color (255,102,0));
        btnCotizacionServicios.setBackground(new Color (51,0,204));
        btnAceptacionMateriales.setBackground(new Color (255,153,255));
        btnAceptacionServ.setBackground(new Color (0,153,153));

        PanelMenuCotizaciones.setVisible(false);
        PanelCotizacionProducto.setVisible(false);
        PanelCotizacionServicio.setVisible(false);
        PanelAceptacionMateriales.setVisible(true);
        PanelAceptacionServicios.setVisible(false);
        llenarTablaCotMaterial();
    }//GEN-LAST:event_btnAceptacionMaterialesMouseClicked

    private void btnAbrirCotServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCotServicioMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        
        if ( returnVal == JFileChooser.APPROVE_OPTION){
            File myFiles = chooser.getSelectedFile();
            lblAbrirCot.setText(myFiles+ "");
            long longitud = myFiles.length();
            try {
                FileInputStream myFile = new FileInputStream(myFiles);
                this.myFile = myFile;
                this.lon = longitud;
                
            } catch (Exception e) {
                System.out.println("Error archivo");
            }
        }
    }//GEN-LAST:event_btnAbrirCotServicioMouseClicked

    private void btnAbrirCotServicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCotServicioMouseEntered
        // TODO add your handling code here:
        btnAbrirCotServicio.setBackground(new Color (51,255,255));
    }//GEN-LAST:event_btnAbrirCotServicioMouseEntered

    private void btnAbrirCotServicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirCotServicioMouseExited
        // TODO add your handling code here:
        btnAbrirCotServicio.setBackground(new Color (0,204,204));
    }//GEN-LAST:event_btnAbrirCotServicioMouseExited

    private void btnSubirCotServicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirCotServicioMouseEntered
        // TODO add your handling code here:
        btnSubirCotServicio.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnSubirCotServicioMouseEntered

    private void btnSubirCotServicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirCotServicioMouseExited
        // TODO add your handling code here:
        btnSubirCotServicio.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnSubirCotServicioMouseExited

    private void btnDescargarCotProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarCotProdMouseEntered
        // TODO add your handling code here:
        btnDescargarCotProd.setBackground(new Color (255,204,153));
    }//GEN-LAST:event_btnDescargarCotProdMouseEntered

    private void btnDescargarCotProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarCotProdMouseExited
        // TODO add your handling code here:
        btnDescargarCotProd.setBackground(new Color (255,204,51));
    }//GEN-LAST:event_btnDescargarCotProdMouseExited

    private void btnAceptarCotProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCotProdMouseEntered
        // TODO add your handling code here:
        btnAceptarCotProd.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnAceptarCotProdMouseEntered

    private void btnAceptarCotProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCotProdMouseExited
        // TODO add your handling code here:
        btnAceptarCotProd.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnAceptarCotProdMouseExited

    private void btnAceptacionServMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptacionServMouseClicked
        // TODO add your handling code here:
        btnCotizacionMateriales.setBackground(new Color (255,102,0));
        btnCotizacionServicios.setBackground(new Color (51,0,204));
        btnAceptacionMateriales.setBackground(new Color (204,0,204));
        btnAceptacionServ.setBackground(new Color (0,204,153));
        
        PanelMenuCotizaciones.setVisible(false);
        PanelCotizacionProducto.setVisible(false);
        PanelCotizacionServicio.setVisible(false);
        PanelAceptacionMateriales.setVisible(false);
        PanelAceptacionServicios.setVisible(true);
        llenarTablaCotServicio();
    }//GEN-LAST:event_btnAceptacionServMouseClicked

    private void btnLimpiarEditFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseEntered
        // TODO add your handling code here:
        btnLimpiarEditFun.setBackground(new Color (255,51,0));
    }//GEN-LAST:event_btnLimpiarEditFunMouseEntered

    private void btnLimpiarEditFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseExited
        // TODO add your handling code here:
        btnLimpiarEditFun.setBackground(new Color (204,51,0));
    }//GEN-LAST:event_btnLimpiarEditFunMouseExited

    private void btnDescargarCotServMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarCotServMouseEntered
        // TODO add your handling code here:
        btnDescargarCotServ.setBackground(new Color (255,204,153));
    }//GEN-LAST:event_btnDescargarCotServMouseEntered

    private void btnDescargarCotServMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarCotServMouseExited
        // TODO add your handling code here:
        btnDescargarCotServ.setBackground(new Color (255,204,51));
    }//GEN-LAST:event_btnDescargarCotServMouseExited

    private void btnAceptarCotServMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCotServMouseEntered
        // TODO add your handling code here:
        btnAceptarCotServ.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnAceptarCotServMouseEntered

    private void btnAceptarCotServMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCotServMouseExited
        // TODO add your handling code here:
        btnAceptarCotServ.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnAceptarCotServMouseExited

    private void btnRechazarCotServMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRechazarCotServMouseEntered
        // TODO add your handling code here:
        btnRechazarCotServ.setBackground(new Color (255,51,0));
    }//GEN-LAST:event_btnRechazarCotServMouseEntered

    private void btnRechazarCotServMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRechazarCotServMouseExited
        // TODO add your handling code here:
        btnRechazarCotServ.setBackground(new Color (204,51,0));
    }//GEN-LAST:event_btnRechazarCotServMouseExited

    private void btnSubirCotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirCotMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
        String dato = String.valueOf(tm.getValueAt(jTable1.getSelectedRow(),1));
        mc.subirCotizacion(dato, myFile, lon);
    }//GEN-LAST:event_btnSubirCotMouseClicked

    private void btnSubirCotServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirCotServicioMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblServicios.getModel();
        String dato = String.valueOf(tm.getValueAt(tblServicios.getSelectedRow(),1));
        System.out.println(dato);
        mc.subirCotiServicio(dato, myFile, lon);
    }//GEN-LAST:event_btnSubirCotServicioMouseClicked

    private void btnDescargarCotServMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarCotServMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblAceptacionCotizacionesServ.getModel();
        String dato = String.valueOf(tm.getValueAt(tblAceptacionCotizacionesServ.getSelectedRow(),0));
        mc.descargarCotServicio(dato);
        
    }//GEN-LAST:event_btnDescargarCotServMouseClicked

    private void btnDescargarCotProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescargarCotProdMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblAceptacionCotizaciones.getModel();
        String dato = String.valueOf(tm.getValueAt(tblAceptacionCotizaciones.getSelectedRow(),0));
        mc.descargarCotMaterial(dato);
    }//GEN-LAST:event_btnDescargarCotProdMouseClicked

    private void btnAceptarCotProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCotProdMouseClicked
        
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblAceptacionCotizaciones.getModel();
        String dato = String.valueOf(tm.getValueAt(tblAceptacionCotizaciones.getSelectedRow(),0));
        mc.aceptarCotMaterial(dato);
        llenarTablaCotMaterial();
        
    }//GEN-LAST:event_btnAceptarCotProdMouseClicked

    private void btnLimpiarEditFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblAceptacionCotizaciones.getModel();
        String dato = String.valueOf(tm.getValueAt(tblAceptacionCotizaciones.getSelectedRow(),0));
        mc.rechazarCotMaterial(dato);
        llenarTablaCotMaterial();
    }//GEN-LAST:event_btnLimpiarEditFunMouseClicked

    private void btnRechazarCotServMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRechazarCotServMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblAceptacionCotizacionesServ.getModel();
        String dato = String.valueOf(tm.getValueAt(tblAceptacionCotizacionesServ.getSelectedRow(),0));
        mc.rechazarCotServicio(dato);
        llenarTablaCotServicio();
    }//GEN-LAST:event_btnRechazarCotServMouseClicked

    private void btnAceptarCotServMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCotServMouseClicked
        // TODO add your handling code here:
        MaterialConsultas mc = new MaterialConsultas();
        DefaultTableModel tm = (DefaultTableModel)tblAceptacionCotizacionesServ.getModel();
        String dato = String.valueOf(tm.getValueAt(tblAceptacionCotizacionesServ.getSelectedRow(),0));
        mc.aceptarCotServicio(dato);
        llenarTablaCotServicio();
    }//GEN-LAST:event_btnAceptarCotServMouseClicked
                                                                                        
                                              

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
            java.util.logging.Logger.getLogger(GUI_Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Cotizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAceptacionMateriales;
    private javax.swing.JPanel PanelAceptacionServicios;
    private javax.swing.JPanel PanelCotizacionProducto;
    private javax.swing.JPanel PanelCotizacionServicio;
    private javax.swing.JPanel PanelMenuCotizaciones;
    private javax.swing.JPanel btnAbrirCot;
    private javax.swing.JPanel btnAbrirCotServicio;
    private javax.swing.JPanel btnAceptacionMateriales;
    private javax.swing.JPanel btnAceptacionServ;
    private javax.swing.JPanel btnAceptarCotProd;
    private javax.swing.JPanel btnAceptarCotServ;
    private javax.swing.JLabel btnAtras_Fun;
    private javax.swing.JPanel btnCotizacionMateriales;
    private javax.swing.JPanel btnCotizacionServicios;
    private javax.swing.JPanel btnDescargarCotProd;
    private javax.swing.JPanel btnDescargarCotServ;
    private javax.swing.JPanel btnLimpiarEditFun;
    private javax.swing.JLabel btnRechazarCotProd;
    private javax.swing.JLabel btnRechazarCotProd1;
    private javax.swing.JPanel btnRechazarCotServ;
    private javax.swing.JLabel btnSalir_Fun;
    private javax.swing.JPanel btnSubirCot;
    private javax.swing.JPanel btnSubirCotServicio;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAbrirCot;
    private javax.swing.JLabel lblAbrirCot1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTable tblAceptacionCotizaciones;
    private javax.swing.JTable tblAceptacionCotizacionesServ;
    private javax.swing.JTable tblServicios;
    // End of variables declaration//GEN-END:variables
}
