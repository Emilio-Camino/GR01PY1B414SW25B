/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import facturacion.elementos.Cliente;
import facturacion.elementos.Factura;
import facturacion.elementos.Helado;
import facturacion.elementos.Promocion;
import facturacion.elementos.ReporteStock;
import facturacion.elementos.ReporteVenta;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;

import facturacion.gestores.interfaces.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class VentanaHeladero extends JFrame {
    Color materialBlue = new Color(66, 133, 244);
    Color softPink = new Color(208, 60, 62);
    Color softGreen = new Color(73, 159, 44);
    private LoginVentana loginDeOrigen;
    private IGestorStockHeladero gestorStock;
    private IGestorPromocionHeladero gestorPromocion;
    private IGestorClienteHeladero gestorCliente;
    private IGestorFacturaHeladero gestorFactura;
    private java.util.List<Promocion> promocionesActuales;
    private java.util.List<Factura> facturasExistentes;
    private Cliente cliente;


    // Constructor
  
    /**
     * Creates new form VentanaHeladero
     */
    public VentanaHeladero(IGestorStockHeladero gStock, IGestorPromocionHeladero gPromocion, IGestorClienteHeladero gCliente,IGestorFacturaHeladero gFactura , LoginVentana login) {
        // Disenio de las pestanias
        UIManager.put("TabbedPane.shadow", Color.WHITE);
        UIManager.put("TabbedPane.darkShadow", Color.WHITE);
        UIManager.put("TabbedPane.selected", Color.WHITE);
        UIManager.put("TabbedPane.selectHighlight", Color.WHITE); 
        UIManager.put("TabbedPane.light", Color.WHITE);
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.drawFocusIndicator", false);
        
        initComponents();
        this.loginDeOrigen = login;
        this.gestorStock = gStock;
        this.gestorPromocion = gPromocion;
        this.gestorCliente = gCliente;
        this.gestorFactura = gFactura;
        actCedulaField.setEnabled(false);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                loginDeOrigen.setVisible(true);
                dispose();
            }
        });
        
        // Gestor Stock
        
        buttonGroup1.add(checkSaboresStock);
        buttonGroup1.add(checkRecipienteStock);
        buttonGroup1.clearSelection();
        
        // Gestor Cliente
        activar_DesactivarLabelsActualizacion(false);

        cargarOpcionesPromocion();
        cargarPromociones();
        
        cargarFacturas();
        
        jListPromociones.addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            int index = jListPromociones.getSelectedIndex();

            // Si hay una selección válida y no es el mensaje de "sin promociones"
            if (index >= 0 && !jListPromociones.getSelectedValue().contains("No hay promociones")) {
                btnEliminarPromocion.setVisible(true);
            } else {
                btnEliminarPromocion.setVisible(false);
            }
        }
    });
        
        jListFacturas.addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            int index = jListFacturas.getSelectedIndex();

            // Si hay una selección válida y no es el mensaje de "sin promociones"
            if (index >= 0 && !jListFacturas.getSelectedValue().contains("No hay facturas registradas")) {
                btnEliminarFactura.setEnabled(true);
            } else {
                btnEliminarFactura.setEnabled(false);
            }
        }
    });

    }

    // ################ INIT COMPONENTS ###############################################
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        pantallaActualizarStock = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnActualizarStock = new javax.swing.JButton();
        btnActualizarStock.setBackground(materialBlue);
        btnActualizarStock.setForeground(Color.WHITE);
        btnActualizarStock.setOpaque(true);
        btnActualizarStock.setBorderPainted(false);
        btnActualizarStock.setContentAreaFilled(true);
        checkSaboresStock = new javax.swing.JRadioButton();
        checkSaboresStock.setBackground(Color.WHITE);
        checkSaboresStock.setForeground(Color.BLACK);
        checkSaboresStock.setOpaque(true);
        checkSaboresStock.setContentAreaFilled(false);
        checkSaboresStock.setBorderPainted(false);
        checkRecipienteStock = new javax.swing.JRadioButton();
        checkRecipienteStock.setBackground(Color.WHITE);
        checkRecipienteStock.setForeground(Color.BLACK);
        checkRecipienteStock.setOpaque(true);
        checkRecipienteStock.setContentAreaFilled(false);
        checkRecipienteStock.setBorderPainted(false);
        labelActualizarStock = new javax.swing.JLabel();
        opcionesStock = new javax.swing.JComboBox<>();
        opcionesStock.setBackground(Color.WHITE);
        opcionesStock.setForeground(Color.BLACK);
        opcionesStock.setOpaque(true);
        opcionesStock.setBorder(null);
        newStock = new javax.swing.JTextField();
        newStock.setBackground(Color.WHITE);
        newStock.setForeground(Color.BLACK);
        newStock.setOpaque(true);
        jScrollPane4 = new javax.swing.JScrollPane();
        stock = new javax.swing.JTextArea();
        btnGenerarReporte = new javax.swing.JButton();
        btnGenerarReporte.setBackground(softGreen);
        btnGenerarReporte.setForeground(Color.WHITE);
        btnGenerarReporte.setOpaque(true);
        btnGenerarReporte.setBorderPainted(false);
        btnGenerarReporte.setContentAreaFilled(true);
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnCrearPromocion = new javax.swing.JButton();
        btnCrearPromocion.setBackground(softGreen);
        btnCrearPromocion.setForeground(Color.WHITE);
        btnCrearPromocion.setOpaque(true);
        btnCrearPromocion.setBorderPainted(false);
        btnCrearPromocion.setContentAreaFilled(true);
        labelActualizarStock1 = new javax.swing.JLabel();
        opcionesPromocion = new javax.swing.JComboBox<>();
        opcionesPromocion.setBackground(Color.WHITE);
        opcionesPromocion.setForeground(Color.BLACK);
        opcionesPromocion.setOpaque(true);
        opcionesPromocion.setBorder(null);
        newStockPromocion = new javax.swing.JTextField();
        newStockPromocion.setBackground(Color.WHITE);
        newStockPromocion.setForeground(Color.BLACK);
        newStockPromocion.setOpaque(true);
        jScrollPane5 = new javax.swing.JScrollPane();
        jListPromociones = new javax.swing.JList<>();
        btnEliminarPromocion = new javax.swing.JButton();
        btnEliminarPromocion.setBackground(softPink);
        btnEliminarPromocion.setForeground(Color.WHITE);
        btnEliminarPromocion.setOpaque(true);
        btnEliminarPromocion.setBorderPainted(false);
        btnEliminarPromocion.setContentAreaFilled(true);
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelCedula = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        btnBuscarCliente.setBackground(materialBlue);
        btnBuscarCliente.setForeground(Color.WHITE);
        btnBuscarCliente.setOpaque(true);
        btnBuscarCliente.setBorderPainted(false);
        btnBuscarCliente.setContentAreaFilled(true);
        cedulaField = new javax.swing.JTextField();
        cedulaField.setBackground(Color.WHITE);
        cedulaField.setForeground(Color.BLACK);
        cedulaField.setOpaque(true);
        btnEliminarCliente = new javax.swing.JButton();
        btnEliminarCliente.setBackground(softPink);
        btnEliminarCliente.setForeground(Color.WHITE);
        btnEliminarCliente.setOpaque(true);
        btnEliminarCliente.setBorderPainted(false);
        btnEliminarCliente.setContentAreaFilled(true);
        btnModificarCliente = new javax.swing.JButton();
        btnModificarCliente.setBackground(materialBlue);
        btnModificarCliente.setForeground(Color.WHITE);
        btnModificarCliente.setOpaque(true);
        btnModificarCliente.setBorderPainted(false);
        btnModificarCliente.setContentAreaFilled(true);
        jPanel6 = new javax.swing.JPanel();
        labelNombreAct = new javax.swing.JLabel();
        labelCedulaAct = new javax.swing.JLabel();
        labelTelefonoAct = new javax.swing.JLabel();
        actNombreField = new javax.swing.JTextField();
        actNombreField.setBackground(Color.WHITE);
        actNombreField.setForeground(Color.BLACK);
        actNombreField.setOpaque(true);
        actNombreField.setBorder(null);
        actCedulaField = new javax.swing.JTextField();
        actCedulaField.setBackground(Color.WHITE);
        actCedulaField.setForeground(Color.BLACK);
        actCedulaField.setOpaque(true);
        actCedulaField.setBorder(null);
        actTelefonoField = new javax.swing.JTextField();
        actTelefonoField.setBackground(Color.WHITE);
        actTelefonoField.setForeground(Color.BLACK);
        actTelefonoField.setOpaque(true);
        actTelefonoField.setBorder(null);
        labelDireccionAct = new javax.swing.JLabel();
        labelCorreoAct = new javax.swing.JLabel();
        actCorreoField = new javax.swing.JTextField();
        actCorreoField.setBackground(Color.WHITE);
        actCorreoField.setForeground(Color.BLACK);
        actCorreoField.setOpaque(true);
        actCorreoField.setBorder(null);
        actDireccionField = new javax.swing.JTextField();
        actDireccionField.setBackground(Color.WHITE);
        actDireccionField.setForeground(Color.BLACK);
        actDireccionField.setOpaque(true);
        actDireccionField.setBorder(null);
        btnAplicarCambios = new javax.swing.JButton();
        btnAplicarCambios.setBackground(softGreen);
        btnAplicarCambios.setForeground(Color.WHITE);
        btnAplicarCambios.setOpaque(true);
        btnAplicarCambios.setBorderPainted(false);
        btnAplicarCambios.setContentAreaFilled(true);
        labelActualizarInformacion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListFacturas = new javax.swing.JList<>();
        btnEliminarFactura = new javax.swing.JButton();
        btnEliminarFactura.setBackground(softPink);
        btnEliminarFactura.setForeground(Color.WHITE);
        btnEliminarFactura.setOpaque(true);
        btnEliminarFactura.setBorderPainted(false);
        btnEliminarFactura.setContentAreaFilled(true);
        jLabel2 = new javax.swing.JLabel();
        btnGenerarReporteV = new javax.swing.JButton();
        btnGenerarReporteV.setBackground(softGreen);
        btnGenerarReporteV.setForeground(Color.WHITE);
        btnGenerarReporteV.setOpaque(true);
        btnGenerarReporteV.setBorderPainted(false);
        btnGenerarReporteV.setContentAreaFilled(true);
        btnVerFactura = new javax.swing.JButton();
        btnVerFactura.setBackground(materialBlue);
        btnVerFactura.setForeground(Color.WHITE);
        btnVerFactura.setOpaque(true);
        btnVerFactura.setBorderPainted(false);
        btnVerFactura.setContentAreaFilled(true);

        jCheckBox1.setText("jCheckBox1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel4.setText("Cliente encontrado");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pantallaActualizarStock.setBackground(new java.awt.Color(255, 255, 255));
        pantallaActualizarStock.setToolTipText("");
        pantallaActualizarStock.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnActualizarStock.setText("Actualizar Stock");
        btnActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarStockActionPerformed(evt);
            }
        });

        checkSaboresStock.setSelected(true);
        checkSaboresStock.setText("Sabores de Helado");
        checkSaboresStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSaboresStockActionPerformed(evt);
            }
        });

        checkRecipienteStock.setText("Recipientes");
        checkRecipienteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRecipienteStockActionPerformed(evt);
            }
        });

        labelActualizarStock.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelActualizarStock.setText("ACTUALIZAR STOCK");

        opcionesStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opcionesStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesStockActionPerformed(evt);
            }
        });

        stock.setColumns(20);
        stock.setRows(5);
        jScrollPane4.setViewportView(stock);

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(labelActualizarStock))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkSaboresStock)
                        .addGap(55, 55, 55)
                        .addComponent(checkRecipienteStock))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opcionesStock, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newStock, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnActualizarStock)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerarReporte)))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelActualizarStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkSaboresStock)
                    .addComponent(checkRecipienteStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcionesStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarStock)
                    .addComponent(btnGenerarReporte))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pantallaActualizarStock.addTab("ActualizarStock", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnCrearPromocion.setText("Crear Promoción");
        btnCrearPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPromocionActionPerformed(evt);
            }
        });

        labelActualizarStock1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelActualizarStock1.setText("ACTUALIZAR PROMOCIONES");

        opcionesPromocion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opcionesPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesPromocionActionPerformed(evt);
            }
        });

        newStockPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStockPromocionActionPerformed(evt);
            }
        });

        jListPromociones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jListPromociones);

        btnEliminarPromocion.setText("Eliminar Promoción");
        btnEliminarPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPromocionActionPerformed(evt);
            }
        });

        jLabel1.setText("Porcentaje Promoción");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelActualizarStock1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opcionesPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newStockPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(labelActualizarStock1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(opcionesPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newStockPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearPromocion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarPromocion))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pantallaActualizarStock.addTab("Actualizar Promociones", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        labelCedula.setText("Cédula: ");

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        cedulaField.setToolTipText("");
        cedulaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaFieldActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnModificarCliente.setText("Modificar Cliente");
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombreAct.setText("Nombre:");
        jPanel6.add(labelNombreAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, -1, -1));

        labelCedulaAct.setText("Cédula:");
        jPanel6.add(labelCedulaAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 96, 47, -1));

        labelTelefonoAct.setText("Telefono:");
        jPanel6.add(labelTelefonoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, -1, -1));

        actNombreField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actNombreFieldActionPerformed(evt);
            }
        });
        jPanel6.add(actNombreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 41, 116, -1));
        jPanel6.add(actCedulaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 93, 116, -1));

        actTelefonoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actTelefonoFieldActionPerformed(evt);
            }
        });
        jPanel6.add(actTelefonoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 145, 116, -1));

        labelDireccionAct.setText("Dirección:");
        jPanel6.add(labelDireccionAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 41, -1, -1));

        labelCorreoAct.setText("Correo:");
        jPanel6.add(labelCorreoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 87, -1, -1));

        actCorreoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actCorreoFieldActionPerformed(evt);
            }
        });
        jPanel6.add(actCorreoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 84, 116, -1));

        actDireccionField.setToolTipText("");
        actDireccionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actDireccionFieldActionPerformed(evt);
            }
        });
        jPanel6.add(actDireccionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 41, 116, -1));

        btnAplicarCambios.setText("Aplicar Cambios");
        btnAplicarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarCambiosActionPerformed(evt);
            }
        });
        jPanel6.add(btnAplicarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 145, -1, -1));

        labelActualizarInformacion.setText("Actualizar Información del Cliente");
        jPanel6.add(labelActualizarInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 7, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(106, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCedula)
                    .addComponent(cedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(btnEliminarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pantallaActualizarStock.addTab("Actualizar Registro Clientes", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jListFacturas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jListFacturas);

        btnEliminarFactura.setText("Anular Factura");
        btnEliminarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFacturaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("REVISAR FACTURAS");

        btnGenerarReporteV.setText("Generar Reporte");
        btnGenerarReporteV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteVActionPerformed(evt);
            }
        });

        btnVerFactura.setText("Ver Factura");
        btnVerFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(btnGenerarReporteV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnEliminarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerFactura)
                        .addGap(28, 28, 28)
                        .addComponent(btnGenerarReporteV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pantallaActualizarStock.addTab("Revisar Facturas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pantallaActualizarStock)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantallaActualizarStock)
        );

        pantallaActualizarStock.getAccessibleContext().setAccessibleName("Actualizar Información del Cliente");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
            ReporteStock reporte = gestorStock.generarReporteStock();

            // Crear el panel principal
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 20)); // márgenes alrededor

            // ===== TÍTULO =====
            JLabel titulo = new JLabel("Reporte de Stock");
            titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
            titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(titulo);

            panel.add(Box.createVerticalStrut(10));

            // ===== INFORMACIÓN GENERAL =====
            JLabel lblNumero = new JLabel("Reporte N°: " + reporte.getIdReporte());
            lblNumero.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            lblNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblNumero);
            
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String fechaFormateada = reporte.getFechaReporte().format(formatter);

                //Label para la fecha
                JLabel lblFecha = new JLabel("Fecha del Reporte: " + fechaFormateada);
                lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                lblFecha.setAlignmentX(Component.LEFT_ALIGNMENT);
                panel.add(lblFecha);

            panel.add(Box.createVerticalStrut(15));

            // ===== STOCK DE SABORES =====
            JLabel lblSabores = new JLabel("Stock de Sabores:");
            lblSabores.setFont(new Font("Segoe UI", Font.BOLD, 18));
            lblSabores.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblSabores);

            for (Map.Entry<SaborHelado, Integer> entry : reporte.getStockSabores().entrySet()) {
                JLabel lblItem = new JLabel(entry.getKey().toString() + ": " + entry.getValue());
                lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
                panel.add(lblItem);
            }

            panel.add(Box.createVerticalStrut(15));

            // ===== STOCK DE RECIPIENTES =====
            JLabel lblRecipientes = new JLabel("Stock de Recipientes:");
            lblRecipientes.setFont(new Font("Segoe UI", Font.BOLD, 18));
            lblRecipientes.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblRecipientes);

            for (Map.Entry<TipoRecipiente, Integer> entry : reporte.getStockRecipiente().entrySet()) {
                JLabel lblItem = new JLabel(entry.getKey().toString() + ": " + entry.getValue());
                lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
                panel.add(lblItem);
            }

            // ===== SCROLL Y DIÁLOGO =====
            JScrollPane scroll = new JScrollPane(panel);
            JOptionPane.showMessageDialog(
                this,
                scroll,
                "Reporte de Stock N° " + reporte.getIdReporte() + " " + reporte.getFechaReporte(),
                JOptionPane.INFORMATION_MESSAGE
            );
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnCrearPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPromocionActionPerformed
        ingresarPorcentaje();
    }//GEN-LAST:event_btnCrearPromocionActionPerformed

    private void opcionesPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesPromocionActionPerformed
        
    }//GEN-LAST:event_opcionesPromocionActionPerformed

    private void opcionesStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionesStockActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
    String cedula = cedulaField.getText().trim();
        // Formato inválido o longitud incorrecta
        if (!cedula.matches("^[0-9]{10}$")) {        
            JOptionPane.showMessageDialog(
                    this,
                    "Cédula inválida. Debe contener exactamente 10 dígitos.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE
            );
            activar_DesactivarLabelsActualizacion(false); 
            return;
        }
        
        buscarCliente(cedula);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

     private void activar_DesactivarLabelsActualizacion (boolean flag) {
        labelCedulaAct.setEnabled(flag);
        labelNombreAct.setEnabled(flag);
        labelTelefonoAct.setEnabled(flag);
        labelDireccionAct.setEnabled(flag);
        labelCorreoAct.setEnabled(flag);
        
        actNombreField.setEnabled(flag);
        actTelefonoField.setEnabled(flag);
        actCorreoField.setEnabled(flag);
        actDireccionField.setEnabled(flag);
        btnAplicarCambios.setEnabled(flag);
        btnModificarCliente.setEnabled(flag);
        btnEliminarCliente.setEnabled(flag);
        
    }
     private void activar_DesactivarCamposActualizacion (boolean flag){
        actNombreField.setEnabled(flag);
        actTelefonoField.setEnabled(flag);
        actCorreoField.setEnabled(flag);
        actDireccionField.setEnabled(flag);
        btnAplicarCambios.setEnabled(flag);
     }
     
    private void ocultarCamposActualizacion(boolean flag) {
    // La variable 'flag' ya no se utiliza en esta lógica.
    
    actCedulaField.setText("");
    actNombreField.setText("");
    actTelefonoField.setText("");
    actCorreoField.setText("");
    actDireccionField.setText("");
    

}
     
     private void buscarCliente(String cedula) {
        if (gestorCliente.validarCedula(cedula)) {
            Cliente clienteAux = gestorCliente.buscarCliente(cedula);
            if (clienteAux == null) {
                JOptionPane.showMessageDialog(null, "El cliente no se encuentra registrado", "Cliente inexistente", JOptionPane.ERROR_MESSAGE);
                activar_DesactivarLabelsActualizacion(false);
                return;
            } else {
                cliente = clienteAux;
                JOptionPane.showMessageDialog(null, "Se encontró al cliente", "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
                activar_DesactivarLabelsActualizacion(true);
                activar_DesactivarCamposActualizacion(false);
                
                actCedulaField.setText(cliente.getCedula());
                actNombreField.setText(cliente.getNombre());
                actCorreoField.setText(cliente.getCorreoElectronico());
                actTelefonoField.setText(cliente.getTelefono());
                actDireccionField.setText(cliente.getDireccion());

            }
        }
        else {
            JOptionPane.showMessageDialog(
                    this,
                    "Cédula inválida. Por favor, ingrese una cédula correcta.",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
    }

    
    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
        // Mostrar los campos para la actualización
        activar_DesactivarCamposActualizacion(true);
        btnAplicarCambios.setVisible(true);
        // Mostrar la informacion almacenada
        actCedulaField.setText(cliente.getCedula());
        actNombreField.setText(cliente.getNombre());
        actCorreoField.setText(cliente.getCorreoElectronico());
        actTelefonoField.setText(cliente.getTelefono());
        actDireccionField.setText(cliente.getDireccion());
        
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnAplicarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarCambiosActionPerformed
        String cedula = actCedulaField.getText().trim();
        
        if(cedula.equals("9999999999")){
        JOptionPane.showMessageDialog(null, "NO puede modificarse a CONSUMIDOR FINAL", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        String nombre = actNombreField.getText().trim();
        String correo = actCorreoField.getText().trim();
        String telefono = actTelefonoField.getText().trim();
        String direccion = actDireccionField.getText().trim();
        gestorCliente.modificarCliente(cliente, nombre, cedula, direccion, telefono, correo);
        activar_DesactivarLabelsActualizacion(false);
        ocultarCamposActualizacion(false);
    }//GEN-LAST:event_btnAplicarCambiosActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        gestorCliente.eliminarCliente(cliente.getCedula());
        this.cliente = null;
        activar_DesactivarLabelsActualizacion(false);
        ocultarCamposActualizacion(false);
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void cedulaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaFieldActionPerformed

    private void actNombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actNombreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actNombreFieldActionPerformed

    private void actCorreoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actCorreoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actCorreoFieldActionPerformed

    private void actTelefonoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actTelefonoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actTelefonoFieldActionPerformed

    private void btnEliminarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFacturaActionPerformed
        int index = jListFacturas.getSelectedIndex();

        if (index < 0 || facturasExistentes == null || facturasExistentes.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar una alguna factura.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Obtener la promoción real correspondiente
        Factura facturaElegida = facturasExistentes.get(index);
        if(facturaElegida.getCliente().getCedula().equals("9999999999")){
            JOptionPane.showMessageDialog(
                    this,
                    "No puede eliminar una factura a nombre de Consumidor Final.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Confirmar la eliminación
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea eliminar la factura " + String.format( "ID: %d a nombre del Cliente: %s",facturaElegida.getIdFactura(), facturaElegida.getCliente().getCedula()) + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = false;
            // Aquí llamas al método del gestor que elimina la promoción
            eliminado = gestorFactura.anularFactura(facturaElegida.getIdFactura());

            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Factura: " +String.format( "ID: %d a nombre del Cliente: %s",facturaElegida.getIdFactura(), facturaElegida.getCliente().getCedula()) + " eliminada correctamente.");
                cargarFacturas(); // refrescar lista
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo eliminar la factura.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btnEliminarFacturaActionPerformed

    private void btnGenerarReporteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteVActionPerformed
        ReporteVenta reporteV= gestorFactura.generarReporteVenta();
        // 2. Crear el panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20)); // Ajuste de márgenes

    // 3. TÍTULO
    JLabel titulo = new JLabel("Reporte de Venta");
    titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
    titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(titulo);

    panel.add(Box.createVerticalStrut(10));

    // 4. INFORMACIÓN GENERAL
   
    // Formateador para la fecha/hora
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String fechaFormateada = reporteV.getFechaReporte().format(formatter);
    
    //Label para la fecha
    JLabel lblFecha = new JLabel("Fecha del Reporte: " + fechaFormateada);
    lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblFecha.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblFecha);
    
    // Total Ventas 
    JLabel lblTotal = new JLabel(String.format("Total de Ventas: $%.2f", reporteV.getTotalVentas()));
    lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblTotal.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblTotal);

    // Facturas Procesadas
    JLabel lblFacturas = new JLabel("Facturas Procesadas: " + reporteV.getFacturasProcesadas());
    lblFacturas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblFacturas.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblFacturas);
    
    panel.add(Box.createVerticalStrut(10)); // Espacio

    // Sabor Más Vendido 
    String saborMasVendido = (reporteV.getSaborMasVendido() != null) ? reporteV.getSaborMasVendido().toString() : "N/A";
    JLabel lblSaborMax = new JLabel("Sabor Más Vendido: " + saborMasVendido);
    lblSaborMax.setFont(new Font("Segoe UI", Font.BOLD, 16)); // En negrita para destacar
    lblSaborMax.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblSaborMax);
    
    // Recipiente Más Vendido
    String recipMasVendido = (reporteV.getRecipienteMasVendido() != null) ? reporteV.getRecipienteMasVendido().toString() : "N/A";
    JLabel lblRecipMax = new JLabel("Recipiente Más Vendido: " + recipMasVendido);
    lblRecipMax.setFont(new Font("Segoe UI", Font.BOLD, 16)); // En negrita para destacar
    lblRecipMax.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblRecipMax);

    panel.add(Box.createVerticalStrut(15));

    // 5. Detalle de sabores
    JLabel lblSabores = new JLabel("Detalle de Sabores Vendidos:");
    lblSabores.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblSabores.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblSabores);

    for (Map.Entry<SaborHelado, Integer> entry : reporteV.getConteoSabor().entrySet()) {
        JLabel lblItem = new JLabel(entry.getKey().toString() + ": " + entry.getValue() + " bolas");
        lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblItem);
    }

    panel.add(Box.createVerticalStrut(15));

    // 6. Detalle de recipientes
    JLabel lblRecipientes = new JLabel("Detalle de Recipientes Vendidos:");
    lblRecipientes.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblRecipientes.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblRecipientes);

    for (Map.Entry<TipoRecipiente, Integer> entry : reporteV.getConteoRecipiente().entrySet()) {
        JLabel lblItem = new JLabel(entry.getKey().toString() + ": " + entry.getValue() + " unidades");
        lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblItem);
    }

    // 7. Scroll y dialogo
    JScrollPane scroll = new JScrollPane(panel);
  

    JOptionPane.showMessageDialog(
            this, 
            scroll,
            "Reporte de Venta", // Título de la ventana
            JOptionPane.INFORMATION_MESSAGE
    );
        
    }//GEN-LAST:event_btnGenerarReporteVActionPerformed

    private void newStockPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStockPromocionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newStockPromocionActionPerformed

    private void actDireccionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actDireccionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actDireccionFieldActionPerformed

    private void btnVerFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFacturaActionPerformed
int index = jListFacturas.getSelectedIndex();

    if (index < 0 || facturasExistentes == null || facturasExistentes.isEmpty()) {
        JOptionPane.showMessageDialog(
                this,
                "Debe seleccionar una alguna factura.",
                "Error",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // 1. Obtener la factura seleccionada
    Factura factura = facturasExistentes.get(index);

    // 2. Crear el panel principal
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

    // Formateador para la fecha 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // 3. TÍTULO
    JLabel titulo = new JLabel("Detalle de Factura");
    titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
    titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(titulo);
    panel.add(Box.createVerticalStrut(10));

    // 4. INFORMACIÓN GENERAL DE LA FACTURA
    JLabel lblId = new JLabel("Factura N°: " + factura.getIdFactura());
    lblId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblId.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblId);

    JLabel lblFecha = new JLabel("Fecha: " + sdf.format(factura.getFechaEmision()));
    lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblFecha.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblFecha);

    JLabel lblPago = new JLabel("Método de Pago: " + factura.getTipoPago());
    lblPago.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblPago.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblPago);
    panel.add(Box.createVerticalStrut(15));

    // 5. DATOS DEL CLIENTE
    JLabel lblClienteTitulo = new JLabel("Datos del Cliente:");
    lblClienteTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblClienteTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblClienteTitulo);

    try {
        JLabel lblClienteNombre = new JLabel("Nombre: " + factura.getCliente().getNombre());
        lblClienteNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblClienteNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblClienteNombre);
        
        JLabel lblClienteCedula = new JLabel("Cédula: " + factura.getCliente().getCedula());
        lblClienteCedula.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblClienteCedula.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblClienteCedula);

    } catch (Exception e) {
        JLabel lblClienteError = new JLabel("No se pudieron cargar los datos del cliente.");
        lblClienteError.setFont(new Font("Segoe UI", Font.ITALIC, 15));
        lblClienteError.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblClienteError);
    }
    panel.add(Box.createVerticalStrut(15));


    // 6. DETALLE DEL PEDIDO
    JLabel lblPedidoTitulo = new JLabel("Detalle del Pedido (N° " + factura.getPedido().getPedidoID() + "):");
    lblPedidoTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblPedidoTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblPedidoTitulo);

    for (Helado helado : factura.getPedido().getHelados()) {
        JLabel lblItem = new JLabel("• " + helado.toString()); // El • es un bullet point
        lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblItem);
    }
    panel.add(Box.createVerticalStrut(15));

    // 7. TOTALES
    JLabel lblTotalesTitulo = new JLabel("Valores:");
    lblTotalesTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblTotalesTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblTotalesTitulo);

    double subtotal = factura.getTotal() - factura.getImpuestoIVA();

    JLabel lblSubtotal = new JLabel(String.format("Subtotal: $%.2f", subtotal));
    lblSubtotal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    lblSubtotal.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblSubtotal);

    JLabel lblIVA = new JLabel(String.format("IVA: $%.2f", factura.getImpuestoIVA()));
    lblIVA.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    lblIVA.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblIVA);

    // Total en negrita
    JLabel lblTotal = new JLabel(String.format("Total a Pagar: $%.2f", factura.getTotal()));
    lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));
    lblTotal.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblTotal);
    
    panel.add(Box.createVerticalStrut(10)); // Separador

    JLabel lblPagado = new JLabel(String.format("Monto Pagado: $%.2f", factura.getPago()));
    lblPagado.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    lblPagado.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblPagado);

    JLabel lblCambio = new JLabel(String.format("Cambio: $%.2f", factura.getCambio()));
    lblCambio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    lblCambio.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(lblCambio);

    // 8. SCROLL Y DIÁLOGO
    JScrollPane scroll = new JScrollPane(panel);
    JOptionPane.showMessageDialog(
            this,
            scroll,
            "Factura N° " + factura.getIdFactura(), // Título de la ventana
            JOptionPane.INFORMATION_MESSAGE
    );
        
    }//GEN-LAST:event_btnVerFacturaActionPerformed

    private void btnEliminarPromocionActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jListPromociones.getSelectedIndex();

        if (index < 0 || promocionesActuales == null || promocionesActuales.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar una promoción válida.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Obtener la promoción real correspondiente
        Promocion promoSeleccionada = promocionesActuales.get(index);

        // Confirmar la eliminación
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar la promoción de " + promoSeleccionada.getSaborPromocion() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = false;
            eliminado = gestorPromocion.eliminarPromocion(promoSeleccionada.getIdPromocion());

            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Promoción " + promoSeleccionada.getSaborPromocion().toString() + " - " + promoSeleccionada.getPorcentajeDescuento() + " eliminada correctamente.");
                cargarPromociones(); // refrescar lista
                btnEliminarPromocion.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo eliminar la promoción. Verifique la lógica del gestor.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    

    // ############################################################### 
    
   
 

    // Funciones para actualizar stock
    private void checkRecipienteStockActionPerformed(java.awt.event.ActionEvent evt) {
        cargarStockRecipientes();
    }

    private void btnActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {
        ingresarStock();
    }

    private void checkSaboresStockActionPerformed(java.awt.event.ActionEvent evt) {
        // Cargar info
        cargarStockSabores();
    }

    private void ingresarStock() {
        int nuevoStock;
        try {
            nuevoStock = Integer.parseInt(newStock.getText().trim());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this, // La ventana actual
                    "El valor ingresado no es válido. Debe ser un número entero.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE
            );
            return; 
        }

        if (nuevoStock < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "El stock no puede ser un número negativo.",
                    "Error de Valor",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Determinar el ítem a actualizar
        String itemSeleccionadoStr = (String) opcionesStock.getSelectedItem();

        if (itemSeleccionadoStr == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un ítem para actualizar.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        boolean actualizacionExitosa = false;

        if (checkSaboresStock.isSelected()) {
            
            try {
                SaborHelado sabor = SaborHelado.valueOf(itemSeleccionadoStr);
                actualizacionExitosa = gestorStock.actualizarHelados(sabor, nuevoStock);
                stock.setText(gestorStock.obtenerStockSaboresHelado());
                
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Error: Sabor no reconocido.", "Error Interno", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } else if (checkRecipienteStock.isSelected()) {
            
            try {
                TipoRecipiente recipiente = TipoRecipiente.valueOf(itemSeleccionadoStr);
                actualizacionExitosa = gestorStock.actualizarRecipiente(recipiente, nuevoStock);
                stock.setText(gestorStock.obtenerStockRecipiente());
                
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Error: Tipo de recipiente no reconocido.", "Error Interno", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (actualizacionExitosa) {
            JOptionPane.showMessageDialog(
                    this,
                    "Stock de " + itemSeleccionadoStr + " actualizado a " + nuevoStock + ".",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
            newStock.setText("");
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "La actualización falló. Verifique la lógica del gestor.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void cargarStockRecipientes() {
        stock.setText(this.gestorStock.obtenerStockRecipiente());
        
        opcionesStock.removeAllItems();

        for (TipoRecipiente rec : TipoRecipiente.values()) {
            opcionesStock.addItem(rec.name());
        }
    }

    private void cargarStockSabores() {
        
        stock.setText(this.gestorStock.obtenerStockSaboresHelado());
        opcionesStock.removeAllItems();
        for (SaborHelado sabor : SaborHelado.values()) {
            opcionesStock.addItem(sabor.name());
        }
    }

    private void cargarOpcionesPromocion() {
        opcionesPromocion.removeAllItems(); // Limpiar los ítems previos

        for (SaborHelado sabor : SaborHelado.values()) {
            opcionesPromocion.addItem(sabor.name());
        }
    }
    
    private void ingresarPorcentaje() {
        double nuevoPorcentaje;
        try {
            nuevoPorcentaje = Double.parseDouble(newStockPromocion.getText().trim());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this, // La ventana actual
                    "El valor ingresado no es válido. Debe puede ser un numero entero con decimales.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (nuevoPorcentaje < 5 || nuevoPorcentaje > 100) {
            JOptionPane.showMessageDialog(
                    this,
                    "La promoción puede ser menor al 5% ni superar al 100%.",
                    "Error de Valor",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Determinar el ítem a actualizar
        String itemSeleccionadoStr = (String) opcionesPromocion.getSelectedItem();

        if (itemSeleccionadoStr == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un ítem para actualizar.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        boolean creacionExitosa = false;

        try {
            SaborHelado sabor = SaborHelado.valueOf(itemSeleccionadoStr);
             creacionExitosa = gestorPromocion.agregarPromocion(sabor, nuevoPorcentaje);
             
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error: Sabor no reconocido.", "Error Interno", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (creacionExitosa) {
            JOptionPane.showMessageDialog(
                    this,
                    "Promoción " + itemSeleccionadoStr + " aplicado promoción de " + nuevoPorcentaje + "%.",
                    "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
            cargarPromociones();
            newStockPromocion.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "La promoción para dicho sabor ya existe, se modificó el descuento en su lugar", "Información", JOptionPane.INFORMATION_MESSAGE);
            cargarPromociones();
            newStockPromocion.setText("");
        }
    }

    private void cargarPromociones() {
        // Obtener las promociones del gestor
        promocionesActuales = gestorPromocion.getListaPromociones();

        // Crear el modelo de lista
        javax.swing.DefaultListModel<String> modelo = new javax.swing.DefaultListModel<>();

        if (promocionesActuales == null || promocionesActuales.isEmpty()) {
            modelo.addElement("No hay promociones disponibles.");
            btnEliminarPromocion.setVisible(false);
        } else {
            for (Promocion promo : promocionesActuales) {
                String texto = String.format(
                        "%s - Descuento: %.2f%%",
                        promo.getSaborPromocion(),
                        promo.getPorcentajeDescuento()
                );
                modelo.addElement(texto);
            }
        }

        jListPromociones.setModel(modelo);
    }
    
    private void cargarFacturas() {
        // 1. Obtener la lista completa del gestor
        java.util.List<Factura> todasLasFacturas = gestorFactura.getListaFacturas();
        facturasExistentes = new java.util.ArrayList<>();
        
        // 3. Crear el modelo para la JList
        javax.swing.DefaultListModel<String> modelo = new javax.swing.DefaultListModel<>();

        // 4. Iterar la lista COMPLETA
        if (todasLasFacturas != null && !todasLasFacturas.isEmpty()) {
            
            //Se itera la lista completa para filtrar
            for (Factura facturaActual : todasLasFacturas) {
                
                // 5. Si la factura NO está anulada, la agregamos a las listas:
                if (!facturaActual.getTipoPago().equals("ANULADA")) {
                    
                    //Agregar a la lista de datos
                    facturasExistentes.add(facturaActual); 
                    
                    // b. Agregar al modelo visual de la JList
                    String texto = String.format(
                            "ID: %d Cliente: %s",
                            facturaActual.getIdFactura(),
                            facturaActual.getCliente().getCedula()
                    );
                    modelo.addElement(texto);
                }
            }
        }

        // 6. Si la lista está vacia
        if (facturasExistentes.isEmpty()) { 
             modelo.addElement("No hay facturas activas registradas");
             btnEliminarFactura.setEnabled(false);
        }
        
        // 7. Asignar el modelo a la JList
        jListFacturas.setModel(modelo);

        if (jListFacturas.getSelectedIndex() == -1) {
            btnEliminarFactura.setEnabled(false);
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actCedulaField;
    private javax.swing.JTextField actCorreoField;
    private javax.swing.JTextField actDireccionField;
    private javax.swing.JTextField actNombreField;
    private javax.swing.JTextField actTelefonoField;
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JButton btnAplicarCambios;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCrearPromocion;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarFactura;
    private javax.swing.JButton btnEliminarPromocion;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnGenerarReporteV;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JButton btnVerFactura;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cedulaField;
    private javax.swing.JRadioButton checkRecipienteStock;
    private javax.swing.JRadioButton checkSaboresStock;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListFacturas;
    private javax.swing.JList<String> jListPromociones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labelActualizarInformacion;
    private javax.swing.JLabel labelActualizarStock;
    private javax.swing.JLabel labelActualizarStock1;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCedulaAct;
    private javax.swing.JLabel labelCorreoAct;
    private javax.swing.JLabel labelDireccionAct;
    private javax.swing.JLabel labelNombreAct;
    private javax.swing.JLabel labelTelefonoAct;
    private javax.swing.JTextField newStock;
    private javax.swing.JTextField newStockPromocion;
    private javax.swing.JComboBox<String> opcionesPromocion;
    private javax.swing.JComboBox<String> opcionesStock;
    private javax.swing.JTabbedPane pantallaActualizarStock;
    private javax.swing.JTextArea stock;
    // End of variables declaration//GEN-END:variables
}
