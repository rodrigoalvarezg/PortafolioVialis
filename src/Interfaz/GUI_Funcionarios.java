/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Conexion.Conexion;
import java.awt.Color;
import Interfaz.*;
import Negocio.TFuncionarios;
import Negocio.TProyecto;
import Negocio.TLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Esteban
 */
public class GUI_Funcionarios extends javax.swing.JFrame {

     TLogin tLogin = new TLogin();
     int xMouse;
     int yMouse;
    /**
     * Creates new form GUI_Funcionarios
     */
    public GUI_Funcionarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        muestraFecha();
        Mensajes_SalirAp men = new Mensajes_SalirAp();
        llenarTabla();
        iniciarTablaSueldos();
        iniciarTablaProyectos();
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
        Conexion con = new Conexion();
        try {
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM trabajador");
            DefaultTableModel value = new DefaultTableModel();
            tblListadoFuncionarios.setModel(value);
            value.addColumn("RUT FUNCIONARIO");
            value.addColumn("NOMBRE");
            value.addColumn("SUELDO");
            value.addColumn("BONO");
            value.addColumn("TIPO DE CONTRATO");
            value.addColumn("PROFESION");
            while(rs.next()){
               value.addRow(new Object[]{rs.getString("RUN_TRAB"),rs.getString("NOMBRE_TRAB")+" "+
                       rs.getString("APELLIDO_PAT_TRAB")+" "+rs.getString("APELLIDO_MAT_TRAB"),
                       rs.getInt("SUELDO_BASE_TRAB"),rs.getInt("BONO_TRAB"),rs.getString("TIPO_CONTRATO_TRAB"),
                       rs.getInt("PROFESION_OFICIO_ID_PO")});
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void iniciarTablaSueldos(){
        Conexion con = new Conexion();
        try{
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            DefaultTableModel value = new DefaultTableModel();
            tblSueldosHistoricos.setModel(value);
            value.addColumn("SUELDO");
            value.addColumn("FECHA");
        }catch (Exception e){
            System.out.println(e);
    }
    }
    
    void iniciarTablaProyectos(){
        try{
            
            DefaultTableModel value = new DefaultTableModel();
            jTable1.setModel(value);
            value.addColumn("PROYECTO");
        }catch (Exception e){
            System.out.println(e);
    }
    }
    
    void llenarTablaSueldos(String rut){
        Conexion con = new Conexion();
        try{
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sueldo_historico WHERE rut_trab ='"+rut+"' ORDER BY pago");
            DefaultTableModel value = new DefaultTableModel();
            tblSueldosHistoricos.setModel(value);
            value.addColumn("SUELDO");
            value.addColumn("FECHA");
            while(rs.next()){
                value.addRow(new Object[]{rs.getInt("SUELDO"), rs.getDate("PAGO")});
            }
            
            ResultSet rs2 = stmt.executeQuery("SELECT SUELDO_BASE_TRAB FROM TRABAJADOR WHERE RUN_TRAB='"+rut+"'");
            while(rs2.next()){
                txtRutFun_Sueldo.setText((String) rs2.getString("SUELDO_BASE_TRAB"));
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    void llenarTablaProyectos(String rut){
        Conexion con = new Conexion();
        try{
            
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROY_TRAB WHERE trabajador_run_trab='"+rut+"'");
            DefaultTableModel value = new DefaultTableModel();
            jTable1.setModel(value);

            value.addColumn("PROYECTO");
            while(rs.next()){
                value.addRow(new Object[]{rs.getString("PROYECTO_ID_PROY")});
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    void limpiarCampos(){
                    txtNombreFunEdit.setText("");
                    txtApelPatFunEdit.setText("");
                    txtApelMatFunEdit.setText("");
                    txtFonoFunEdit.setText("");
                    txtEmailFunEdit.setText("");
                    txtDireccionFunEdit.setText("");
                    cmbAFPFunEdit1.setSelectedIndex(0);
                    cmbSaludFunEdit.setSelectedIndex(0);
                    cmbEstadoCivilFunEdit.setSelectedIndex(0);
                    txtSueldoFunEdit.setText("");
                    txtBonoFunEdit.setText("");
                    cmbContratoEdit.setSelectedIndex(0);
                    cmbProfesionEdit.setSelectedIndex(0);
                    cmbResponsableEdit.setSelectedIndex(0);
                    
                    txtNombreFun.setText("");
                    txtApelPatFun.setText("");
                    txtApelMatFun.setText("");
                    txtFonoFun.setText("");
                    txtEmailFun.setText("");
                    txtDireccionFun.setText("");
                    cmbAFPFun.setSelectedIndex(0);
                    cmbSaludFun.setSelectedIndex(0);
                    cmbEstadoCivilFun.setSelectedIndex(0);
                    txtSueldoFun.setText("");
                    txtBonoEdit.setText("");
                    cmbContrato.setSelectedIndex(0);
                    cmbProfesion.setSelectedIndex(0);
                    cmbResponsable.setSelectedIndex(0);
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
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir_Fun = new javax.swing.JLabel();
        btnAtras_Fun = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblDate = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        PanelMenuFuncionarios = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        PanelIngresarFun = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbAFPFun = new javax.swing.JComboBox<>();
        cmbSaludFun = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cmbEstadoCivilFun = new javax.swing.JComboBox<>();
        btnLimpiarFun = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNombreFun = new javax.swing.JTextField();
        txtApelPatFun = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtApelMatFun = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtRutFun = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtFonoFun = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtEmailFun = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        txtDireccionFun = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        btnInsertarFun = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txtSueldoFun = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel66 = new javax.swing.JLabel();
        cmbContrato = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        txtBonoEdit = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        cmbProfesion = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        cmbResponsable = new javax.swing.JComboBox<>();
        PanelEditarFun = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cmbContratoEdit = new javax.swing.JComboBox<>();
        cmbSaludFunEdit = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        cmbEstadoCivilFunEdit = new javax.swing.JComboBox<>();
        jSeparator13 = new javax.swing.JSeparator();
        txtNombreFunEdit = new javax.swing.JTextField();
        txtApelPatFunEdit = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        txtApelMatFunEdit = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        txtFonoFunEdit = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        txtEmailFunEdit = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        txtDireccionFunEdit = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtRutFun1 = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        btnEditarFun = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btnLimpiarEditFun = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        btnBuscarFun = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        txtSueldoFunEdit = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel61 = new javax.swing.JLabel();
        cmbAFPFunEdit1 = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        txtBonoFunEdit = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel63 = new javax.swing.JLabel();
        cmbProfesionEdit = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        cmbResponsableEdit = new javax.swing.JComboBox<>();
        PanelEliminarFun = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txtRutElimFun = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        btnEliminarFun = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        btnLimpiarElimFun = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        PanelListarFun = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoFuncionarios = new javax.swing.JTable();
        PanelProyectosFun = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        txtRutFun_Proyecto = new javax.swing.JTextField();
        jSeparator22 = new javax.swing.JSeparator();
        btnBuscarFunProy = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        PanelSueldoFuncionario = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        btnBuscarFunSueldo = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        txtRutFun_Sueldo1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSueldosHistoricos = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtRutFun_Sueldo = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnIngresarFuncionario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnEditarFuncionario = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnEliminarFuncionario = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnListarFuncionario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnProyectosFuncionario = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        btnSueldosFuncionario = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Drag = new javax.swing.JPanel();
        FrameDrag = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.CardLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 699, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 19, -1, -1));

        btnSalir_Fun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CERRAR_MINI_ICON.png"))); // NOI18N
        btnSalir_Fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalir_FunMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalir_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 15, -1, -1));

        btnAtras_Fun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ATRAS_MINI_ICON.png"))); // NOI18N
        btnAtras_Fun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtras_FunMouseClicked(evt);
            }
        });
        jPanel1.add(btnAtras_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 15, -1, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("USER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 19, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/USER_MINI_ICON_MAINMENU.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 23, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSTRUCTORA VIALIS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 14, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CALENDARIO_MINI_ICON_MAINMENU.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 23, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 991, 13));

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("jLabel6");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 23, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel9.setLayout(new java.awt.CardLayout());

        PanelMenuFuncionarios.setBackground(new java.awt.Color(102, 102, 255));
        PanelMenuFuncionarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("¡Bienvenido al menú de funcionarios!");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Utiliza diversas herramientas para el control y gestión de los funcionarios Vialis");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Casco_MenuFuncionario.png"))); // NOI18N

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Funciones disponibles: ");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("1.- Inserción de Funcionarios");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("2.- Edición de Funcionarios");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("4.- Listar Funcionarios");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("3.- Eliminar Funcionario");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("5.- Proyectos del Funcionario");

        javax.swing.GroupLayout PanelMenuFuncionariosLayout = new javax.swing.GroupLayout(PanelMenuFuncionarios);
        PanelMenuFuncionarios.setLayout(PanelMenuFuncionariosLayout);
        PanelMenuFuncionariosLayout.setHorizontalGroup(
            PanelMenuFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuFuncionariosLayout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(PanelMenuFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(PanelMenuFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelMenuFuncionariosLayout.createSequentialGroup()
                            .addGroup(PanelMenuFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel54)
                                .addComponent(jLabel55)
                                .addComponent(jLabel56)
                                .addComponent(jLabel57)
                                .addComponent(jLabel58)
                                .addComponent(jLabel59))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addComponent(jLabel52)))
                .addGap(234, 234, 234))
        );
        PanelMenuFuncionariosLayout.setVerticalGroup(
            PanelMenuFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuFuncionariosLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addGroup(PanelMenuFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuFuncionariosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel59))
                    .addGroup(PanelMenuFuncionariosLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11)))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jPanel9.add(PanelMenuFuncionarios, "card7");

        PanelIngresarFun.setBackground(new java.awt.Color(102, 102, 255));
        PanelIngresarFun.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelIngresarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Registro de Funcionario");
        PanelIngresarFun.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nombre:");
        PanelIngresarFun.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Apellido Paterno:");
        PanelIngresarFun.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Apellido Materno:");
        PanelIngresarFun.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelIngresarFun.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 15, 300));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("AFP:");
        PanelIngresarFun.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Correo electrónico:");
        PanelIngresarFun.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Rut:");
        PanelIngresarFun.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelIngresarFun.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 15, 300));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Dirección:");
        PanelIngresarFun.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Estado Civil:");
        PanelIngresarFun.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Fono/Celular:");
        PanelIngresarFun.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        cmbAFPFun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Modelo", "Cuprum", "Vital" }));
        PanelIngresarFun.add(cmbAFPFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 213, -1));

        cmbSaludFun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Isapre", "Fonsa" }));
        PanelIngresarFun.add(cmbSaludFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 213, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Salud:");
        PanelIngresarFun.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        cmbEstadoCivilFun.setBackground(new java.awt.Color(102, 102, 255));
        cmbEstadoCivilFun.setForeground(new java.awt.Color(255, 255, 255));
        cmbEstadoCivilFun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Soltero", "Casado", "Viudo" }));
        cmbEstadoCivilFun.setBorder(null);
        PanelIngresarFun.add(cmbEstadoCivilFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 210, -1));

        btnLimpiarFun.setBackground(new java.awt.Color(204, 51, 0));
        btnLimpiarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarFunMouseExited(evt);
            }
        });
        btnLimpiarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("LIMPIAR");
        btnLimpiarFun.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 13, -1, -1));

        PanelIngresarFun.add(btnLimpiarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 140, 50));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 189, -1));

        txtNombreFun.setBackground(new java.awt.Color(102, 102, 255));
        txtNombreFun.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreFun.setText("Ingrese nombre aquí...");
        txtNombreFun.setBorder(null);
        txtNombreFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtNombreFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 192, -1));

        txtApelPatFun.setBackground(new java.awt.Color(102, 102, 255));
        txtApelPatFun.setForeground(new java.awt.Color(255, 255, 255));
        txtApelPatFun.setText("Ingrese apellido paterno...");
        txtApelPatFun.setBorder(null);
        txtApelPatFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApelPatFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtApelPatFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 189, -1));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 192, -1));

        txtApelMatFun.setBackground(new java.awt.Color(102, 102, 255));
        txtApelMatFun.setForeground(new java.awt.Color(255, 255, 255));
        txtApelMatFun.setText("Ingrese apellido materno...");
        txtApelMatFun.setBorder(null);
        txtApelMatFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApelMatFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtApelMatFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 189, -1));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 189, -1));

        txtRutFun.setBackground(new java.awt.Color(102, 102, 255));
        txtRutFun.setForeground(new java.awt.Color(255, 255, 255));
        txtRutFun.setText("Ingrese rut...");
        txtRutFun.setBorder(null);
        txtRutFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRutFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtRutFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 189, -1));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 189, -1));

        txtFonoFun.setBackground(new java.awt.Color(102, 102, 255));
        txtFonoFun.setForeground(new java.awt.Color(255, 255, 255));
        txtFonoFun.setText("Ingrese celular...");
        txtFonoFun.setBorder(null);
        txtFonoFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFonoFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtFonoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 190, -1));

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 190, 10));

        txtEmailFun.setBackground(new java.awt.Color(102, 102, 255));
        txtEmailFun.setForeground(new java.awt.Color(255, 255, 255));
        txtEmailFun.setText("Ingrese correo electrónico...");
        txtEmailFun.setBorder(null);
        txtEmailFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtEmailFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 210, -1));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 210, -1));

        txtDireccionFun.setBackground(new java.awt.Color(102, 102, 255));
        txtDireccionFun.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionFun.setText("Ingrese dirección...");
        txtDireccionFun.setBorder(null);
        txtDireccionFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtDireccionFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 210, -1));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 210, -1));

        btnInsertarFun.setBackground(new java.awt.Color(0, 153, 153));
        btnInsertarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertarFunMouseExited(evt);
            }
        });
        btnInsertarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("INGRESAR");
        btnInsertarFun.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 13, -1, -1));

        PanelIngresarFun.add(btnInsertarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 150, 50));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Sueldo Base:");
        PanelIngresarFun.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, -1));

        txtSueldoFun.setBackground(new java.awt.Color(102, 102, 255));
        txtSueldoFun.setForeground(new java.awt.Color(255, 255, 255));
        txtSueldoFun.setText("Ingrese sueldo base...");
        txtSueldoFun.setBorder(null);
        txtSueldoFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSueldoFunMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtSueldoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 210, -1));

        jSeparator25.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 200, 10));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Tipo de Contrato:");
        PanelIngresarFun.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, -1, -1));

        cmbContrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Contrata", "Planta", "Honorario" }));
        cmbContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbContratoActionPerformed(evt);
            }
        });
        PanelIngresarFun.add(cmbContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 200, -1));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Bonificaciones:");
        PanelIngresarFun.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, -1, -1));

        txtBonoEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtBonoEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtBonoEdit.setText("Ingrese bonos...");
        txtBonoEdit.setBorder(null);
        txtBonoEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBonoEditMouseClicked(evt);
            }
        });
        PanelIngresarFun.add(txtBonoEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 210, -1));

        jSeparator26.setForeground(new java.awt.Color(255, 255, 255));
        PanelIngresarFun.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 200, 10));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Profesión/Oficio:");
        PanelIngresarFun.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, -1, -1));

        cmbProfesion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Técnico", "Ingeniero", "Diseñador" }));
        PanelIngresarFun.add(cmbProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 200, -1));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Responsable:");
        PanelIngresarFun.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, -1, -1));

        cmbResponsable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "40", "60", "100" }));
        PanelIngresarFun.add(cmbResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 200, -1));

        jPanel9.add(PanelIngresarFun, "card2");

        PanelEditarFun.setBackground(new java.awt.Color(102, 102, 255));
        PanelEditarFun.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelEditarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Edición de Funcionario");
        PanelEditarFun.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nombre:");
        PanelEditarFun.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Apellido Paterno:");
        PanelEditarFun.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Apellido Materno:");
        PanelEditarFun.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jSeparator11.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelEditarFun.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 15, 280));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tipo de Contrato:");
        PanelEditarFun.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Sueldo Base:");
        PanelEditarFun.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Dirección:");
        PanelEditarFun.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Estado Civil:");
        PanelEditarFun.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Fono/Celular:");
        PanelEditarFun.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        cmbContratoEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Contrata", "Planta", "Honorario" }));
        PanelEditarFun.add(cmbContratoEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 200, -1));

        cmbSaludFunEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Isapre", "Fonsa" }));
        PanelEditarFun.add(cmbSaludFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 213, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Salud:");
        PanelEditarFun.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        cmbEstadoCivilFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        cmbEstadoCivilFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        cmbEstadoCivilFunEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Soltero", "Casado", "Viudo" }));
        cmbEstadoCivilFunEdit.setBorder(null);
        PanelEditarFun.add(cmbEstadoCivilFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 210, -1));

        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 189, -1));

        txtNombreFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtNombreFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreFunEdit.setText("Ingrese nombre aquí...");
        txtNombreFunEdit.setBorder(null);
        txtNombreFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtNombreFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 192, -1));

        txtApelPatFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtApelPatFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtApelPatFunEdit.setText("Ingrese apellido paterno...");
        txtApelPatFunEdit.setBorder(null);
        txtApelPatFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApelPatFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtApelPatFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 189, -1));

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 192, -1));

        txtApelMatFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtApelMatFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtApelMatFunEdit.setText("Ingrese apellido materno...");
        txtApelMatFunEdit.setBorder(null);
        txtApelMatFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApelMatFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtApelMatFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 189, -1));

        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 189, -1));

        txtFonoFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtFonoFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtFonoFunEdit.setText("Ingrese celular...");
        txtFonoFunEdit.setBorder(null);
        txtFonoFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFonoFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtFonoFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 210, -1));

        jSeparator17.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 190, 3));

        txtEmailFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtEmailFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtEmailFunEdit.setText("Ingrese correo electrónico...");
        txtEmailFunEdit.setBorder(null);
        txtEmailFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtEmailFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 210, -1));

        jSeparator18.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 190, -1));

        txtDireccionFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtDireccionFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccionFunEdit.setText("Ingrese dirección...");
        txtDireccionFunEdit.setBorder(null);
        txtDireccionFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtDireccionFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 210, -1));

        jSeparator19.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 210, -1));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Ingrese Rut de Funcionario");

        txtRutFun1.setBackground(new java.awt.Color(102, 102, 255));
        txtRutFun1.setForeground(new java.awt.Color(255, 255, 255));
        txtRutFun1.setText("Ingrese rut...");
        txtRutFun1.setBorder(null);
        txtRutFun1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRutFun1MouseClicked(evt);
            }
        });

        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));

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
        jLabel43.setText("EDITAR");
        btnEditarFun.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, -1, -1));

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

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("LIMPIAR");
        btnLimpiarEditFun.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jSeparator12.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
        jLabel44.setText("BUSCAR");
        btnBuscarFun.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(txtRutFun1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnBuscarFun, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarFun, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiarEditFun, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(5, 5, 5)
                        .addComponent(txtRutFun1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnLimpiarEditFun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarFun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(btnEditarFun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        PanelEditarFun.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 740, 100));

        jSeparator20.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelEditarFun.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 15, 290));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Correo electrónico:");
        PanelEditarFun.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        txtSueldoFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtSueldoFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtSueldoFunEdit.setText("Ingrese sueldo base...");
        txtSueldoFunEdit.setBorder(null);
        txtSueldoFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSueldoFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtSueldoFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 210, -1));

        jSeparator23.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 210, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("AFP:");
        PanelEditarFun.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        cmbAFPFunEdit1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Modelo", "Cuprum", "Vital" }));
        PanelEditarFun.add(cmbAFPFunEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 213, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Bonificaciones:");
        PanelEditarFun.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, -1, -1));

        txtBonoFunEdit.setBackground(new java.awt.Color(102, 102, 255));
        txtBonoFunEdit.setForeground(new java.awt.Color(255, 255, 255));
        txtBonoFunEdit.setText("Ingrese bonos...");
        txtBonoFunEdit.setBorder(null);
        txtBonoFunEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBonoFunEditMouseClicked(evt);
            }
        });
        PanelEditarFun.add(txtBonoFunEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 210, -1));

        jSeparator24.setForeground(new java.awt.Color(255, 255, 255));
        PanelEditarFun.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 200, 10));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Profesión/Oficio:");
        PanelEditarFun.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        cmbProfesionEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Técnico", "Ingeniero", "Diseñador" }));
        PanelEditarFun.add(cmbProfesionEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 200, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Responsable:");
        PanelEditarFun.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, -1, -1));

        cmbResponsableEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "40", "60", "100" }));
        PanelEditarFun.add(cmbResponsableEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 200, -1));

        jPanel9.add(PanelEditarFun, "card2");

        PanelEliminarFun.setBackground(new java.awt.Color(102, 102, 255));
        PanelEliminarFun.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Ingrese Rut de Funcionario");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtRutElimFun.setBackground(new java.awt.Color(102, 102, 255));
        txtRutElimFun.setForeground(new java.awt.Color(255, 255, 255));
        txtRutElimFun.setText("Ingrese rut aquí...");
        txtRutElimFun.setBorder(null);
        txtRutElimFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRutElimFunMouseClicked(evt);
            }
        });
        jPanel6.add(txtRutElimFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, -1));

        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 380, 10));

        btnEliminarFun.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminarFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarFunMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarFunMouseExited(evt);
            }
        });
        btnEliminarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ELIMINAR");
        btnEliminarFun.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, -1, -1));

        jPanel6.add(btnEliminarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 150, 50));

        btnLimpiarElimFun.setBackground(new java.awt.Color(204, 51, 0));
        btnLimpiarElimFun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarElimFunMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarElimFunMouseExited(evt);
            }
        });
        btnLimpiarElimFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("LIMPIAR");
        btnLimpiarElimFun.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jPanel6.add(btnLimpiarElimFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 100, 50));

        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Eliminar Funcionario");

        javax.swing.GroupLayout PanelEliminarFunLayout = new javax.swing.GroupLayout(PanelEliminarFun);
        PanelEliminarFun.setLayout(PanelEliminarFunLayout);
        PanelEliminarFunLayout.setHorizontalGroup(
            PanelEliminarFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarFunLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(PanelEliminarFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        PanelEliminarFunLayout.setVerticalGroup(
            PanelEliminarFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEliminarFunLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        jPanel9.add(PanelEliminarFun, "card4");

        PanelListarFun.setBackground(new java.awt.Color(102, 102, 255));
        PanelListarFun.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelListarFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Listado de Funcionarios");
        PanelListarFun.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        tblListadoFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListadoFuncionarios);

        PanelListarFun.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 779, 290));

        jPanel9.add(PanelListarFun, "card5");

        PanelProyectosFun.setBackground(new java.awt.Color(102, 102, 255));
        PanelProyectosFun.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelProyectosFun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Ingrese Rut de Funcionario");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtRutFun_Proyecto.setBackground(new java.awt.Color(102, 102, 255));
        txtRutFun_Proyecto.setForeground(new java.awt.Color(255, 255, 255));
        txtRutFun_Proyecto.setText("Ingrese rut...");
        txtRutFun_Proyecto.setBorder(null);
        txtRutFun_Proyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRutFun_ProyectoMouseClicked(evt);
            }
        });
        jPanel7.add(txtRutFun_Proyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, -1));

        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 250, 10));

        btnBuscarFunProy.setBackground(new java.awt.Color(255, 204, 51));
        btnBuscarFunProy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarFunProyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarFunProyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarFunProyMouseExited(evt);
            }
        });
        btnBuscarFunProy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("BUSCAR");
        btnBuscarFunProy.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 13, -1, -1));

        jPanel7.add(btnBuscarFunProy, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 120, 50));

        PanelProyectosFun.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 430, 100));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        PanelProyectosFun.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 840, 200));

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Proyectos de Funcionario");
        PanelProyectosFun.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jPanel9.add(PanelProyectosFun, "card6");

        PanelSueldoFuncionario.setBackground(new java.awt.Color(102, 102, 255));
        PanelSueldoFuncionario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelSueldoFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Ingrese Rut de Funcionario");
        jPanel8.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jSeparator27.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 390, 10));

        btnBuscarFunSueldo.setBackground(new java.awt.Color(255, 204, 51));
        btnBuscarFunSueldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarFunSueldoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarFunSueldoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarFunSueldoMouseExited(evt);
            }
        });
        btnBuscarFunSueldo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("BUSCAR");
        btnBuscarFunSueldo.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 13, -1, -1));

        jPanel8.add(btnBuscarFunSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 120, 50));

        txtRutFun_Sueldo1.setBackground(new java.awt.Color(102, 102, 255));
        txtRutFun_Sueldo1.setForeground(new java.awt.Color(255, 255, 255));
        txtRutFun_Sueldo1.setText("Ingrese rut...");
        txtRutFun_Sueldo1.setBorder(null);
        txtRutFun_Sueldo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRutFun_Sueldo1MouseClicked(evt);
            }
        });
        jPanel8.add(txtRutFun_Sueldo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, -1));

        PanelSueldoFuncionario.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 580, 100));

        tblSueldosHistoricos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblSueldosHistoricos);

        PanelSueldoFuncionario.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 820, 200));

        jLabel74.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Sueldo de Funcionario");
        PanelSueldoFuncionario.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Sueldos Históricos:");
        PanelSueldoFuncionario.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        txtRutFun_Sueldo.setBackground(new java.awt.Color(102, 102, 255));
        txtRutFun_Sueldo.setForeground(new java.awt.Color(255, 255, 255));
        txtRutFun_Sueldo.setText("Busque un funcionario...");
        txtRutFun_Sueldo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRutFun_Sueldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRutFun_SueldoMouseClicked(evt);
            }
        });
        PanelSueldoFuncionario.add(txtRutFun_Sueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 310, 30));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Sueldo Actual:");
        PanelSueldoFuncionario.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, 30));

        jPanel9.add(PanelSueldoFuncionario, "card6");

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 217, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresarFuncionario.setBackground(new java.awt.Color(255, 102, 0));
        btnIngresarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarFuncionarioMouseClicked(evt);
            }
        });
        btnIngresarFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Insertar");
        btnIngresarFuncionario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/INSERTARUSUARIO_FUNCIONARIOS.png"))); // NOI18N
        btnIngresarFuncionario.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel3.add(btnIngresarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 130));

        btnEditarFuncionario.setBackground(new java.awt.Color(51, 0, 204));
        btnEditarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarFuncionarioMouseClicked(evt);
            }
        });
        btnEditarFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Editar");
        btnEditarFuncionario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edicion.png"))); // NOI18N
        btnEditarFuncionario.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 20, 70, -1));

        jPanel3.add(btnEditarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 140, 130));

        btnEliminarFuncionario.setBackground(new java.awt.Color(204, 0, 204));
        btnEliminarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarFuncionarioMouseClicked(evt);
            }
        });
        btnEliminarFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Eliminar");
        btnEliminarFuncionario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ELIMINAR.png"))); // NOI18N
        btnEliminarFuncionario.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 20, 70, -1));

        jPanel3.add(btnEliminarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 140, 130));

        btnListarFuncionario.setBackground(new java.awt.Color(0, 153, 153));
        btnListarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarFuncionarioMouseClicked(evt);
            }
        });
        btnListarFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Listar");
        btnListarFuncionario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Listar.png"))); // NOI18N
        btnListarFuncionario.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 70));

        jPanel3.add(btnListarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 140, 130));

        btnProyectosFuncionario.setBackground(new java.awt.Color(204, 0, 0));
        btnProyectosFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProyectosFuncionarioMouseClicked(evt);
            }
        });
        btnProyectosFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Proyectos");
        btnProyectosFuncionario.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PROYECTOS_FUNCIONARIOS.png"))); // NOI18N
        btnProyectosFuncionario.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 20, 70, -1));

        jPanel3.add(btnProyectosFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 140, 130));

        btnSueldosFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        btnSueldosFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSueldosFuncionarioMouseClicked(evt);
            }
        });
        btnSueldosFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sueldos");
        btnSueldosFuncionario.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 100, 50, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SueldoFuncionario.png"))); // NOI18N
        btnSueldosFuncionario.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

        jPanel3.add(btnSueldosFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 140, 130));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        Drag.setBackground(new java.awt.Color(102, 102, 255));

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

        javax.swing.GroupLayout DragLayout = new javax.swing.GroupLayout(Drag);
        Drag.setLayout(DragLayout);
        DragLayout.setHorizontalGroup(
            DragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FrameDrag, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        DragLayout.setVerticalGroup(
            DragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FrameDrag, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(Drag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarFuncionarioMouseClicked
        // TODO add your handling code here:

        btnIngresarFuncionario.setBackground(new Color (255,204,153));
        btnEditarFuncionario.setBackground(new Color (51,0,204));
        btnEliminarFuncionario.setBackground(new Color (204,0,204));
        btnListarFuncionario.setBackground(new Color (0,153,153));
        btnProyectosFuncionario.setBackground(new Color (204,0,0));
        btnSueldosFuncionario.setBackground(new Color (153,153,153));
        
        PanelMenuFuncionarios.setVisible(false);
        PanelIngresarFun.setVisible(true);
        PanelEditarFun.setVisible(false);
        PanelEliminarFun.setVisible(false);
        PanelListarFun.setVisible(false);
        PanelProyectosFun.setVisible(false);
        PanelSueldoFuncionario.setVisible(false);

    }//GEN-LAST:event_btnIngresarFuncionarioMouseClicked

    private void btnEditarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFuncionarioMouseClicked
        // TODO add your handling code here:
        btnIngresarFuncionario.setBackground(new Color (255,102,0));
        btnEditarFuncionario.setBackground(new Color (204,204,255));
        btnEliminarFuncionario.setBackground(new Color (204,0,204));
        btnListarFuncionario.setBackground(new Color (0,153,153));
        btnProyectosFuncionario.setBackground(new Color (204,0,0));
        btnSueldosFuncionario.setBackground(new Color (153,153,153));
        
        PanelMenuFuncionarios.setVisible(false);
        PanelIngresarFun.setVisible(false);
        PanelEditarFun.setVisible(true);
        PanelEliminarFun.setVisible(false);
        PanelListarFun.setVisible(false);
        PanelProyectosFun.setVisible(false);
        PanelSueldoFuncionario.setVisible(false);
    }//GEN-LAST:event_btnEditarFuncionarioMouseClicked

    private void btnEliminarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFuncionarioMouseClicked
        // TODO add your handling code here:
        btnIngresarFuncionario.setBackground(new Color (255,102,0));
        btnEditarFuncionario.setBackground(new Color (51,0,204));
        btnEliminarFuncionario.setBackground(new Color (255,153,255));
        btnListarFuncionario.setBackground(new Color (0,153,153));
        btnProyectosFuncionario.setBackground(new Color (204,0,0));
        btnSueldosFuncionario.setBackground(new Color (153,153,153));
        
        PanelMenuFuncionarios.setVisible(false);
        PanelIngresarFun.setVisible(false);
        PanelEditarFun.setVisible(false);
        PanelEliminarFun.setVisible(true);
        PanelListarFun.setVisible(false);
        PanelProyectosFun.setVisible(false);
        PanelSueldoFuncionario.setVisible(false);
    }//GEN-LAST:event_btnEliminarFuncionarioMouseClicked

    private void btnListarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarFuncionarioMouseClicked
        // TODO add your handling code here:
        btnIngresarFuncionario.setBackground(new Color (255,102,0));
        btnEditarFuncionario.setBackground(new Color (51,0,204));
        btnEliminarFuncionario.setBackground(new Color (204,0,204));
        btnListarFuncionario.setBackground(new Color (0,204,153));
        btnProyectosFuncionario.setBackground(new Color (204,0,0));
        btnSueldosFuncionario.setBackground(new Color (153,153,153));
        
        
        PanelMenuFuncionarios.setVisible(false);
        PanelIngresarFun.setVisible(false);
        PanelEditarFun.setVisible(false);
        PanelEliminarFun.setVisible(false);
        PanelListarFun.setVisible(true);
        PanelProyectosFun.setVisible(false);
        PanelSueldoFuncionario.setVisible(false);
        llenarTabla();
    }//GEN-LAST:event_btnListarFuncionarioMouseClicked

    private void btnSueldosFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSueldosFuncionarioMouseClicked
        // TODO add your handling code here:
        btnIngresarFuncionario.setBackground(new Color (255,102,0));
        btnEditarFuncionario.setBackground(new Color (51,0,204));
        btnEliminarFuncionario.setBackground(new Color (204,0,204));
        btnListarFuncionario.setBackground(new Color (0,153,153));
        btnProyectosFuncionario.setBackground(new Color (204,0,0));
        btnSueldosFuncionario.setBackground(new Color (204,204,204));
        
        PanelMenuFuncionarios.setVisible(false);
        PanelIngresarFun.setVisible(false);
        PanelEditarFun.setVisible(false);
        PanelEliminarFun.setVisible(false);
        PanelListarFun.setVisible(false);
        PanelProyectosFun.setVisible(false);
        PanelSueldoFuncionario.setVisible(true);
    }//GEN-LAST:event_btnSueldosFuncionarioMouseClicked

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

    private void btnLimpiarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarFunMouseEntered
        // TODO add your handling code here:
        btnLimpiarFun.setBackground(new Color (255,51,0));
    }//GEN-LAST:event_btnLimpiarFunMouseEntered

    private void btnLimpiarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarFunMouseExited
        // TODO add your handling code here:
        btnLimpiarFun.setBackground(new Color (204,51,0));
    }//GEN-LAST:event_btnLimpiarFunMouseExited

    private void btnInsertarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarFunMouseEntered
        // TODO add your handling code here:
        btnInsertarFun.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnInsertarFunMouseEntered

    private void btnInsertarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarFunMouseExited
        // TODO add your handling code here:
        btnInsertarFun.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnInsertarFunMouseExited

    private void btnEditarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFunMouseEntered
        // TODO add your handling code here:
        btnEditarFun.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnEditarFunMouseEntered

    private void btnEditarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFunMouseExited
        // TODO add your handling code here:
        btnEditarFun.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnEditarFunMouseExited

    private void btnEliminarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFunMouseEntered
        // TODO add your handling code here:
        btnEliminarFun.setBackground(new Color (0,204,153));
    }//GEN-LAST:event_btnEliminarFunMouseEntered

    private void btnEliminarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFunMouseExited
        // TODO add your handling code here:
        btnEliminarFun.setBackground(new Color (0,153,153));
    }//GEN-LAST:event_btnEliminarFunMouseExited

    private void btnLimpiarEditFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseEntered
        // TODO add your handling code here:
        btnLimpiarEditFun.setBackground(new Color (255,51,0));
    }//GEN-LAST:event_btnLimpiarEditFunMouseEntered

    private void btnLimpiarEditFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseExited
        // TODO add your handling code here:
        btnLimpiarEditFun.setBackground(new Color (204,51,0));
    }//GEN-LAST:event_btnLimpiarEditFunMouseExited

    private void btnLimpiarElimFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarElimFunMouseEntered
        // TODO add your handling code here:
        btnLimpiarElimFun.setBackground(new Color (255,51,0));
    }//GEN-LAST:event_btnLimpiarElimFunMouseEntered

    private void btnLimpiarElimFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarElimFunMouseExited
        // TODO add your handling code here:
        btnLimpiarElimFun.setBackground(new Color (204,51,0));
    }//GEN-LAST:event_btnLimpiarElimFunMouseExited

    private void btnBuscarFunProyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunProyMouseEntered
        // TODO add your handling code here:
        btnBuscarFunProy.setBackground(new Color (255,204,153));
    }//GEN-LAST:event_btnBuscarFunProyMouseEntered

    private void btnBuscarFunProyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunProyMouseExited
        // TODO add your handling code here:
        btnBuscarFunProy.setBackground(new Color (255,204,51));
    }//GEN-LAST:event_btnBuscarFunProyMouseExited

    private void btnBuscarFunMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunMouseEntered
        // TODO add your handling code here:
        btnBuscarFun.setBackground(new Color (255,204,153));
    }//GEN-LAST:event_btnBuscarFunMouseEntered

    private void btnBuscarFunMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunMouseExited
        // TODO add your handling code here:
        btnBuscarFun.setBackground(new Color (255,204,51));
    }//GEN-LAST:event_btnBuscarFunMouseExited

    private void btnInsertarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarFunMouseClicked
        TFuncionarios rf = new TFuncionarios();
        try{
            rf.registrarFunncionario(txtRutFun.getText(), 
                    txtNombreFun.getText(), 
                    txtApelPatFun.getText(), 
                    txtApelMatFun.getText(), 
                    txtDireccionFun.getText(), 
                    cmbEstadoCivilFun.getSelectedItem().toString(), 
                    Integer.parseInt(txtSueldoFun.getText()),
                    Integer.parseInt(txtBonoEdit.getText()),
                    cmbContrato.getSelectedItem().toString(), 
                    cmbAFPFun.getSelectedItem().toString(), 
                    cmbSaludFun.getSelectedItem().toString(), 
                    cmbResponsable.getSelectedIndex(),
                    cmbProfesion.getSelectedIndex(),
                    txtFonoFun.getText(), 
                    txtEmailFun.getText());
            new Mensajes_ExitoIngreso().setVisible(true);
        }catch(Exception ex){
            new Mensajes_ErrorIngresar().setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnInsertarFunMouseClicked

    private void btnEliminarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFunMouseClicked
        TFuncionarios rf = new TFuncionarios();
        try{
            new Mensajes_ExitoEliminar().setVisible(true);
            rf.eliminarFuncionario(txtRutElimFun.getText());
        }catch(Exception ex){
            new Mensajes_ErrorEliminar().setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarFunMouseClicked

    private void btnBuscarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunMouseClicked
         
        limpiarCampos();
        
        Conexion con = new Conexion();
         
        
        try{
            con.getConexion();
            Statement stmt = con.getConexion().createStatement();
            try{
                ResultSet rs = stmt.executeQuery("SELECT * FROM trabajador WHERE RUN_TRAB ='"+txtRutFun1.getText()+"'");
                while(rs.next()){
                    txtNombreFunEdit.setText(rs.getString("NOMBRE_TRAB"));
                    txtApelPatFunEdit.setText(rs.getString("APELLIDO_PAT_TRAB"));
                    txtApelMatFunEdit.setText(rs.getString("APELLIDO_MAT_TRAB"));
                    txtFonoFunEdit.setText(rs.getString("FONO_TRAB"));
                    txtEmailFunEdit.setText(rs.getString("CORREO_TRAB"));
                    txtDireccionFunEdit.setText(rs.getString("DIRECCION_TRAB"));
                    cmbAFPFunEdit1.setSelectedItem(rs.getString("AFP_TRAB"));
                    cmbSaludFunEdit.setSelectedItem(rs.getString("SEGURO_SALUD_TRAB"));
                    cmbEstadoCivilFunEdit.setSelectedItem(rs.getString("EST_CIVIL_TRAB"));
                    txtSueldoFunEdit.setText(rs.getString("SUELDO_BASE_TRAB"));
                    txtBonoFunEdit.setText(rs.getString("BONO_TRAB"));
                    cmbContratoEdit.setSelectedItem(rs.getString("TIPO_CONTRATO_TRAB"));
                    cmbProfesionEdit.setSelectedIndex(rs.getInt("PROFESION_OFICIO_ID_PO"));
                    cmbResponsableEdit.setSelectedIndex(rs.getInt("ACEPTACION_ID_ACEP"));                  
                    
                }
            }catch (SQLException ex){                
                System.out.println(ex);            
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnBuscarFunMouseClicked

    private void cmbContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbContratoActionPerformed

    private void btnEditarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarFunMouseClicked
        TFuncionarios rf = new TFuncionarios();
        try{
            rf.editarProyecto(txtRutFun1.getText(), 
                    txtNombreFunEdit.getText(), 
                    txtApelPatFunEdit.getText(), 
                    txtApelMatFunEdit.getText(), 
                    txtDireccionFunEdit.getText(), 
                    cmbEstadoCivilFunEdit.getSelectedItem().toString(), 
                    Integer.parseInt(txtSueldoFunEdit.getText()),
                    Integer.parseInt(txtBonoFunEdit.getText()),
                    cmbContratoEdit.getSelectedItem().toString(), 
                    cmbAFPFunEdit1.getSelectedItem().toString(), 
                    cmbSaludFunEdit.getSelectedItem().toString(), 
                    cmbResponsableEdit.getSelectedIndex(),
                    cmbProfesionEdit.getSelectedIndex(),
                    txtFonoFunEdit.getText(), 
                    txtEmailFunEdit.getText());
            new Mensajes_ExitoModificacion().setVisible(true);
        }catch(Exception ex){
            new Mensajes_ErrorModificar().setVisible(true);
        
        }
    }//GEN-LAST:event_btnEditarFunMouseClicked

    private void btnLimpiarEditFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarEditFunMouseClicked
        // TODO add your handling code here:
        limpiarCampos();
        txtRutFun1.setText("");
    }//GEN-LAST:event_btnLimpiarEditFunMouseClicked

    private void btnLimpiarFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarFunMouseClicked
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarFunMouseClicked

    private void txtRutFun1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRutFun1MouseClicked
        // TODO add your handling code here:
        txtRutFun1.setText("");
    }//GEN-LAST:event_txtRutFun1MouseClicked

    private void txtNombreFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreFunEditMouseClicked
        // TODO add your handling code here:
        txtNombreFunEdit.setText("");
    }//GEN-LAST:event_txtNombreFunEditMouseClicked

    private void txtApelPatFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApelPatFunEditMouseClicked
        // TODO add your handling code here:
        txtApelPatFunEdit.setText("");
    }//GEN-LAST:event_txtApelPatFunEditMouseClicked

    private void txtApelMatFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApelMatFunEditMouseClicked
        // TODO add your handling code here:
        txtApelMatFunEdit.setText("");
    }//GEN-LAST:event_txtApelMatFunEditMouseClicked

    private void txtFonoFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFonoFunEditMouseClicked
        // TODO add your handling code here:
        txtFonoFunEdit.setText("");
    }//GEN-LAST:event_txtFonoFunEditMouseClicked

    private void txtEmailFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailFunEditMouseClicked
        // TODO add your handling code here:
        txtEmailFunEdit.setText("");
    }//GEN-LAST:event_txtEmailFunEditMouseClicked

    private void txtDireccionFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionFunEditMouseClicked
        // TODO add your handling code here:
        txtDireccionFunEdit.setText("");
    }//GEN-LAST:event_txtDireccionFunEditMouseClicked

    private void txtSueldoFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSueldoFunEditMouseClicked
        // TODO add your handling code here:
         txtSueldoFunEdit.setText("");
    }//GEN-LAST:event_txtSueldoFunEditMouseClicked

    private void txtBonoFunEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBonoFunEditMouseClicked
        // TODO add your handling code here:
        txtBonoFunEdit.setText("");
    }//GEN-LAST:event_txtBonoFunEditMouseClicked

    private void txtNombreFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreFunMouseClicked
        // TODO add your handling code here:
        txtNombreFun.setText("");
    }//GEN-LAST:event_txtNombreFunMouseClicked

    private void txtApelPatFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApelPatFunMouseClicked
        // TODO add your handling code here:
        txtApelPatFun.setText("");
    }//GEN-LAST:event_txtApelPatFunMouseClicked

    private void txtApelMatFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApelMatFunMouseClicked
        // TODO add your handling code here:
        txtApelMatFun.setText("");
    }//GEN-LAST:event_txtApelMatFunMouseClicked

    private void txtRutFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRutFunMouseClicked
        // TODO add your handling code here:
        txtRutFun.setText("");
    }//GEN-LAST:event_txtRutFunMouseClicked

    private void txtFonoFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFonoFunMouseClicked
        // TODO add your handling code here:
        txtFonoFun.setText("");
    }//GEN-LAST:event_txtFonoFunMouseClicked

    private void txtEmailFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailFunMouseClicked
        // TODO add your handling code here:
        txtEmailFun.setText("");
    }//GEN-LAST:event_txtEmailFunMouseClicked

    private void txtDireccionFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionFunMouseClicked
        // TODO add your handling code here:
        txtDireccionFun.setText("");
    }//GEN-LAST:event_txtDireccionFunMouseClicked

    private void txtSueldoFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSueldoFunMouseClicked
        // TODO add your handling code here:
        txtSueldoFun.setText("");
    }//GEN-LAST:event_txtSueldoFunMouseClicked

    private void txtBonoEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBonoEditMouseClicked
        // TODO add your handling code here:
        txtBonoEdit.setText("");
    }//GEN-LAST:event_txtBonoEditMouseClicked

    private void txtRutElimFunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRutElimFunMouseClicked
        // TODO add your handling code here:
        txtRutElimFun.setText("");
    }//GEN-LAST:event_txtRutElimFunMouseClicked

    private void txtRutFun_ProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRutFun_ProyectoMouseClicked
        // TODO add your handling code here:
        txtRutFun_Proyecto.setText("");
    }//GEN-LAST:event_txtRutFun_ProyectoMouseClicked

    private void FrameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen(); //para rescatar el valor X de la posición de la ventana
        int y = evt.getYOnScreen(); //para rescatar el valor Y de la posición de la ventana

        this.setLocation(x - xMouse ,y - yMouse);
    }//GEN-LAST:event_FrameDragMouseDragged

    private void FrameDragMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FrameDragMouseClicked

    private void FrameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_FrameDragMousePressed

    private void btnProyectosFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProyectosFuncionarioMouseClicked
        // TODO add your handling code here:
        btnIngresarFuncionario.setBackground(new Color (255,102,0));
        btnEditarFuncionario.setBackground(new Color (51,0,204));
        btnEliminarFuncionario.setBackground(new Color (204,0,204));
        btnListarFuncionario.setBackground(new Color (0,153,153));
        btnProyectosFuncionario.setBackground(new Color (255,102,102));
        btnSueldosFuncionario.setBackground(new Color (153,153,153));
        
        PanelMenuFuncionarios.setVisible(false);
        PanelIngresarFun.setVisible(false);
        PanelEditarFun.setVisible(false);
        PanelEliminarFun.setVisible(false);
        PanelListarFun.setVisible(false);
        PanelProyectosFun.setVisible(true);
        PanelSueldoFuncionario.setVisible(false);
    }//GEN-LAST:event_btnProyectosFuncionarioMouseClicked

    private void txtRutFun_SueldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRutFun_SueldoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutFun_SueldoMouseClicked

    private void btnBuscarFunSueldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunSueldoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFunSueldoMouseEntered

    private void btnBuscarFunSueldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunSueldoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFunSueldoMouseExited

    private void txtRutFun_Sueldo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRutFun_Sueldo1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutFun_Sueldo1MouseClicked

    private void btnBuscarFunProyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunProyMouseClicked

        llenarTablaProyectos(txtRutFun_Proyecto.getText());
        
    }//GEN-LAST:event_btnBuscarFunProyMouseClicked

    private void btnBuscarFunSueldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarFunSueldoMouseClicked
        
        
        llenarTablaSueldos(txtRutFun_Sueldo1.getText());
        
        
        
    }//GEN-LAST:event_btnBuscarFunSueldoMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Funcionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Drag;
    private javax.swing.JLabel FrameDrag;
    private javax.swing.JPanel PanelEditarFun;
    private javax.swing.JPanel PanelEliminarFun;
    private javax.swing.JPanel PanelIngresarFun;
    private javax.swing.JPanel PanelListarFun;
    private javax.swing.JPanel PanelMenuFuncionarios;
    private javax.swing.JPanel PanelProyectosFun;
    private javax.swing.JPanel PanelSueldoFuncionario;
    private javax.swing.JLabel btnAtras_Fun;
    private javax.swing.JPanel btnBuscarFun;
    private javax.swing.JPanel btnBuscarFunProy;
    private javax.swing.JPanel btnBuscarFunSueldo;
    private javax.swing.JPanel btnEditarFun;
    private javax.swing.JPanel btnEditarFuncionario;
    private javax.swing.JPanel btnEliminarFun;
    private javax.swing.JPanel btnEliminarFuncionario;
    private javax.swing.JPanel btnIngresarFuncionario;
    private javax.swing.JPanel btnInsertarFun;
    private javax.swing.JPanel btnLimpiarEditFun;
    private javax.swing.JPanel btnLimpiarElimFun;
    private javax.swing.JPanel btnLimpiarFun;
    private javax.swing.JPanel btnListarFuncionario;
    private javax.swing.JPanel btnProyectosFuncionario;
    private javax.swing.JLabel btnSalir_Fun;
    private javax.swing.JPanel btnSueldosFuncionario;
    private javax.swing.JComboBox<String> cmbAFPFun;
    private javax.swing.JComboBox<String> cmbAFPFunEdit1;
    private javax.swing.JComboBox<String> cmbContrato;
    private javax.swing.JComboBox<String> cmbContratoEdit;
    private javax.swing.JComboBox<String> cmbEstadoCivilFun;
    private javax.swing.JComboBox<String> cmbEstadoCivilFunEdit;
    private javax.swing.JComboBox<String> cmbProfesion;
    private javax.swing.JComboBox<String> cmbProfesionEdit;
    private javax.swing.JComboBox<String> cmbResponsable;
    private javax.swing.JComboBox<String> cmbResponsableEdit;
    private javax.swing.JComboBox<String> cmbSaludFun;
    private javax.swing.JComboBox<String> cmbSaludFunEdit;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTable tblListadoFuncionarios;
    private javax.swing.JTable tblSueldosHistoricos;
    private javax.swing.JTextField txtApelMatFun;
    private javax.swing.JTextField txtApelMatFunEdit;
    private javax.swing.JTextField txtApelPatFun;
    private javax.swing.JTextField txtApelPatFunEdit;
    private javax.swing.JTextField txtBonoEdit;
    private javax.swing.JTextField txtBonoFunEdit;
    private javax.swing.JTextField txtDireccionFun;
    private javax.swing.JTextField txtDireccionFunEdit;
    private javax.swing.JTextField txtEmailFun;
    private javax.swing.JTextField txtEmailFunEdit;
    private javax.swing.JTextField txtFonoFun;
    private javax.swing.JTextField txtFonoFunEdit;
    private javax.swing.JTextField txtNombreFun;
    private javax.swing.JTextField txtNombreFunEdit;
    private javax.swing.JTextField txtRutElimFun;
    private javax.swing.JTextField txtRutFun;
    private javax.swing.JTextField txtRutFun1;
    private javax.swing.JTextField txtRutFun_Proyecto;
    private javax.swing.JTextField txtRutFun_Sueldo;
    private javax.swing.JTextField txtRutFun_Sueldo1;
    private javax.swing.JTextField txtSueldoFun;
    private javax.swing.JTextField txtSueldoFunEdit;
    // End of variables declaration//GEN-END:variables
}
