/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import facturacion.elementos.Cliente;
import facturacion.elementos.ReporteStock;
import facturacion.elementos.enumeraciones.SaborHelado;
import facturacion.elementos.enumeraciones.TipoRecipiente;
import facturacion.gestores.GestorStock;

import facturacion.gestores.interfaces.*;
import java.awt.Component;
import java.awt.Font;
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

public class VentanaHeladero extends javax.swing.JFrame {

    private LoginVentana loginDeOrigen;
    private IGestorStockHeladero gestorStock;
    private IGestorPromocionHeladero gestorPromocion;
    private IGestorClienteHeladero gestorCliente;
    private Cliente cliente;

    // Constructor
    /**
     * Creates new form VentanaHeladero
     */
    public VentanaHeladero(IGestorStockHeladero gStock, IGestorPromocionHeladero gPromocion, IGestorClienteHeladero gCliente, LoginVentana login) {
        initComponents();
        this.loginDeOrigen = login;
        this.gestorStock = gStock;
        this.gestorPromocion = gPromocion;
        this.gestorCliente = gCliente;

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
        btnAplicarCambios.setVisible(false);
        btnEliminarCliente.setVisible(false);
        btnModificarCliente.setVisible(false);
        labelActualizarInformacion.setVisible(false);
        labelCedulaAct.setVisible(false);
        labelNombreAct.setVisible(false);
        labelTelefonoAct.setVisible(false);
        labelDireccionAct.setVisible(false);
        labelCorreoAct.setVisible(false);
        labelResultadoBusqueda.setVisible(false);

        actCedulaField.setVisible(false);
        actNombreField.setVisible(false);
        actTelefonoField.setVisible(false);
        actCorreoField.setVisible(false);
        actDireccionField.setVisible(false);

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
        checkSaboresStock = new javax.swing.JRadioButton();
        checkRecipienteStock = new javax.swing.JRadioButton();
        labelActualizarStock = new javax.swing.JLabel();
        opcionesStock = new javax.swing.JComboBox<>();
        newStock = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        stock = new javax.swing.JTextArea();
        btnGenerarReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnEliminarCliente = new javax.swing.JToggleButton();
        cedulaField = new javax.swing.JTextField();
        labelCedula = new javax.swing.JLabel();
        labelNombreAct = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JToggleButton();
        btnAplicarCambios = new javax.swing.JToggleButton();
        actNombreField = new javax.swing.JTextField();
        labelResultadoBusqueda = new javax.swing.JLabel();
        labelDireccionAct = new javax.swing.JLabel();
        labelTelefonoAct = new javax.swing.JLabel();
        labelCorreoAct = new javax.swing.JLabel();
        labelCedulaAct = new javax.swing.JLabel();
        actTelefonoField = new javax.swing.JTextField();
        actDireccionField = new javax.swing.JTextField();
        btnModificarCliente = new javax.swing.JToggleButton();
        actCorreoField = new javax.swing.JTextField();
        actCedulaField = new javax.swing.JTextField();
        labelActualizarInformacion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

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
        setResizable(false);

        pantallaActualizarStock.setToolTipText("");
        pantallaActualizarStock.setName(""); // NOI18N

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
                                .addGap(16, 16, 16)
                                .addComponent(labelActualizarStock))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkSaboresStock)
                                .addGap(55, 55, 55)
                                .addComponent(checkRecipienteStock))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnActualizarStock)))
                .addContainerGap(166, Short.MAX_VALUE))
                                .addComponent(btnActualizarStock)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerarReporte)))))
                .addContainerGap(153, Short.MAX_VALUE))
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
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pantallaActualizarStock.addTab("ActualizarStock", jPanel1);

        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        cedulaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaFieldActionPerformed(evt);
            }
        });

        labelCedula.setText("Cedula: ");

        labelNombreAct.setText("Nombre:");

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnAplicarCambios.setText("Actualizar Información");
        btnAplicarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarCambiosActionPerformed(evt);
            }
        });

        labelResultadoBusqueda.setText("Cliente encontrado");

        labelDireccionAct.setText("Dirección: ");

        labelTelefonoAct.setText("Teléfono:");

        labelCorreoAct.setText("Correo:");

        labelCedulaAct.setText("Cédula:");

        btnModificarCliente.setText("Modificar Información del Cliente");
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        labelActualizarInformacion.setText("Actualizar información del cliente: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscarCliente)
                        .addGap(272, 272, 272))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(labelCedula)
                        .addGap(12, 12, 12)
                        .addComponent(cedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombreAct, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTelefonoAct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCedulaAct))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(actTelefonoField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(actCedulaField)
                                    .addComponent(actNombreField))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelDireccionAct, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCorreoAct))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(actDireccionField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                            .addComponent(actCorreoField)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(161, 161, 161)
                                        .addComponent(btnAplicarCambios))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelResultadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnEliminarCliente)
                                        .addGap(81, 81, 81)
                                        .addComponent(btnModificarCliente))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(labelActualizarInformacion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelResultadoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnModificarCliente))
                .addGap(8, 8, 8)
                .addComponent(labelActualizarInformacion)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actNombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombreAct)
                    .addComponent(labelDireccionAct)
                    .addComponent(actDireccionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(actTelefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefonoAct))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(actCorreoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCorreoAct)
                            .addComponent(actCedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCedulaAct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnAplicarCambios)
                        .addGap(26, 26, 26))))
        );

        pantallaActualizarStock.addTab("Actualizar Registro Clientes", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        pantallaActualizarStock.addTab("tab3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantallaActualizarStock)
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
            titulo.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
            titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(titulo);

            panel.add(Box.createVerticalStrut(10));

            // ===== INFORMACIÓN GENERAL =====
            JLabel lblNumero = new JLabel("Reporte N°: " + reporte.getIdReporte());
            lblNumero.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16));
            lblNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblNumero);

            JLabel lblFecha = new JLabel("Fecha: " + reporte.getFechaReporte());
            lblFecha.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 16));
            lblFecha.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblFecha);

            panel.add(Box.createVerticalStrut(15));

            // ===== STOCK DE SABORES =====
            JLabel lblSabores = new JLabel("Stock de Sabores:");
            lblSabores.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));
            lblSabores.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblSabores);

            for (Map.Entry<SaborHelado, Integer> entry : reporte.getStockSabores().entrySet()) {
                JLabel lblItem = new JLabel(entry.getKey().toString() + ": " + entry.getValue());
                lblItem.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 15));
                lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
                panel.add(lblItem);
            }

            panel.add(Box.createVerticalStrut(15));

            // ===== STOCK DE RECIPIENTES =====
            JLabel lblRecipientes = new JLabel("Stock de Recipientes:");
            lblRecipientes.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));
            lblRecipientes.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblRecipientes);

            for (Map.Entry<TipoRecipiente, Integer> entry : reporte.getStockRecipiente().entrySet()) {
                JLabel lblItem = new JLabel(entry.getKey().toString() + ": " + entry.getValue());
                lblItem.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 15));
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

    // ############################################################### 
    
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String cedula = cedulaField.getText().trim();
        // Formato inválido o longitud incorrecta
        if (!cedula.matches("^[0-9]{10}$")) {        
            JOptionPane.showMessageDialog(
                    this,
                    "Cédula inválida. Debe contener exactamente 10 dígitos.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE
            );
            mostrar_ocultarLabelsActualizacion(false); 
            return;
        }
        
        buscarCliente(cedula);
    }

    private void mostrar_ocultarLabelsActualizacion (boolean flag) {
        labelActualizarInformacion.setVisible(flag);
        labelCedulaAct.setVisible(flag);
        labelNombreAct.setVisible(flag);
        labelTelefonoAct.setVisible(flag);
        labelDireccionAct.setVisible(flag);
        labelCorreoAct.setVisible(flag);
        labelResultadoBusqueda.setVisible(flag);

        actCedulaField.setVisible(flag);
        actNombreField.setVisible(flag);
        actTelefonoField.setVisible(flag);
        actCorreoField.setVisible(flag);
        actDireccionField.setVisible(flag);
    }
    private void buscarCliente(String cedula) {
        if (validarCedula(cedula)) {
            Cliente clienteAux = gestorCliente.buscarCliente(cedula);
            if (clienteAux == null) {
                labelResultadoBusqueda.setText("Cliente no encontrado");
                labelResultadoBusqueda.setVisible(true);
                mostrar_ocultarLabelsActualizacion(false);
                return;
                // se podría presentar la opcion de registrar cliente
            } else {
                cliente = clienteAux;
                labelResultadoBusqueda.setText(String.format("Cliente encontrado: %s", cliente.getNombre()));
                labelResultadoBusqueda.setVisible(true);
                
                btnEliminarCliente.setVisible(true);
                btnModificarCliente.setVisible(true);
                mostrar_ocultarLabelsActualizacion(false);
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

    public boolean validarCedula(String cedula) {
        //Algortimo para la verificación de cedula tomado de Legion-Developers por Juan Pinzón
        int suma = 0;
        if (cedula.length() <= 9) {
            return false;
        } else {
            int a[] = new int[cedula.length() / 2];
            int b[] = new int[(cedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < cedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
                c = c + 2;
                if (i < (cedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1)))) {
                return true;
            } else if (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }

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

    // Funciones para actualizar registro clientes
    private void cedulaFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        gestorCliente.eliminarCliente(cliente.getCedula());
        this.cliente = null;
    }

    private void btnAplicarCambiosActionPerformed(java.awt.event.ActionEvent evt) {
        String cedula = actCedulaField.getText().trim();
        String nombre = actNombreField.getText().trim();
        String correo = actCorreoField.getText().trim();
        String telefono = actTelefonoField.getText().trim();
        String direccion = actDireccionField.getText().trim();
        System.out.println(cedula + nombre + correo + telefono + direccion);
        gestorCliente.modificarCliente(cliente, cedula, nombre, correo, telefono, direccion);
    }


    // Actualizacion de la informacion del cliente
    
    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        // Mostrar los campos para la actualización
        mostrar_ocultarLabelsActualizacion(true);
        btnAplicarCambios.setVisible(true);
        // Muestro la informacion almacenada
        actCedulaField.setText(cliente.getCedula());
        actNombreField.setText(cliente.getNombre());
        actCorreoField.setText(cliente.getCorreoElectronico());
        actTelefonoField.setText(cliente.getTelefono());
        actDireccionField.setText(cliente.getDireccion());
    }
    
    // TODO:skdfjlskjdlkfjs

    private void actCorreoFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void actCedulaFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actCedulaField;
    private javax.swing.JTextField actCorreoField;
    private javax.swing.JTextField actDireccionField;
    private javax.swing.JTextField actNombreField;
    private javax.swing.JTextField actTelefonoField;
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JToggleButton btnAplicarCambios;
    private javax.swing.JToggleButton btnBuscarCliente;
    private javax.swing.JToggleButton btnEliminarCliente;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JToggleButton btnModificarCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cedulaField;
    private javax.swing.JRadioButton checkRecipienteStock;
    private javax.swing.JRadioButton checkSaboresStock;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel labelActualizarInformacion;
    private javax.swing.JLabel labelActualizarStock;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCedulaAct;
    private javax.swing.JLabel labelCorreoAct;
    private javax.swing.JLabel labelDireccionAct;
    private javax.swing.JLabel labelNombreAct;
    private javax.swing.JLabel labelResultadoBusqueda;
    private javax.swing.JLabel labelTelefonoAct;
    private javax.swing.JTextField newStock;
    private javax.swing.JComboBox<String> opcionesStock;
    private javax.swing.JTabbedPane pantallaActualizarStock;
    private javax.swing.JTextArea stock;
    // End of variables declaration//GEN-END:variables
}
