
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */

public class HOME extends javax.swing.JFrame {
 
    /**
     * Creates new form HOME
     */Connection connection;
    public HOME() {
initComponents();
initializeDatabaseConnection(); // ✅ Do this first
load_teacher();
counter();
fetch();

    }
    PreparedStatement preparedstatement;
ResultSet resultSet;
    private void fetch() {
    try {
        int q;
        PreparedStatement preparedstatement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            preparedstatement = connection.prepareStatement("SELECT id, fname, lname, gender, age , status, contact, address , dept FROM tblteacher");
            resultSet = preparedstatement.executeQuery();
            java.sql.ResultSetMetaData rss = resultSet.getMetaData();
            q = rss.getColumnCount();

            javax.swing.table.DefaultTableModel df = (javax.swing.table.DefaultTableModel) record.getModel();
            df.setRowCount(0);
            while (resultSet.next()) {
                java.util.Vector<String> v2 = new java.util.Vector<>();
                for (int a = 1; a <= q; a++) {
                    v2.add(resultSet.getString(a));
                }
                df.addRow(v2);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Database connection is not established.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(books.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
              if (resultSet != null) resultSet.close();
            if (preparedstatement != null) preparedstatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(tblteacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
    
    private void initializeDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/teacherdb";
            String dbUser = "root";
            String dbPassword = "root@123";
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(books.class.getName()).log(Level.SEVERE, null, ex);
            // Consider exiting the application or disabling functionality if connection fails
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database connection error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(books.class.getName()).log(Level.SEVERE, null, ex);
            // Consider exiting the application or disabling functionality if connection fails
            connection = null; // Ensure connection is null if connection fails
        }
    }

    public void load_teacher() {

        try {
            DefaultTableModel table = (DefaultTableModel) record.getModel();
            table.setRowCount(0);

           
                Statement state = connection.createStatement();
                ResultSet rs = state.executeQuery(" select * from tblteacher ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                table.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
    }
    
    public void counter(){
     try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root", "");
                Statement state = con.createStatement();
                ResultSet r = state.executeQuery("SELECT count(*) FROM `tblteacher`");

                while (r.next()) {

                    jLabel17.setText(r.getString("count(*)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dept = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        record = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("Teachers Profiling and Scheduling");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 356, 40));

        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/icons8_search_20px.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/icons8_bell_20px_1.png"))); // NOI18N
        jLabel17.setText("0");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/icons8_administrator_male_50px.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        jLabel3.setBackground(new java.awt.Color(153, 255, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("Teacher Information");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, -1));

        dept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 160, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Status");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 90, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Identification");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 80, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Department");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 80, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Lastname");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 60, 20));

        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 100, 20));

        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, 20));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setForeground(new java.awt.Color(255, 0, 51));
        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 40, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText(" Age");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 40, 20));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Divorced", "Widow" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 120, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Firstname", "Lastname", "Gender", "Age", "Status", "Contact #", "Address", "Dept."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        record.setGridColor(new java.awt.Color(255, 255, 255));
        record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(record);
        if (record.getColumnModel().getColumnCount() > 0) {
            record.getColumnModel().getColumn(0).setResizable(false);
            record.getColumnModel().getColumn(1).setResizable(false);
            record.getColumnModel().getColumn(2).setResizable(false);
            record.getColumnModel().getColumn(3).setResizable(false);
            record.getColumnModel().getColumn(4).setResizable(false);
            record.getColumnModel().getColumn(5).setResizable(false);
            record.getColumnModel().getColumn(6).setResizable(false);
            record.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 320));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 900, 320));

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        jLabel10.setBackground(new java.awt.Color(0, 102, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CREATE");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 102));

        jLabel12.setBackground(new java.awt.Color(255, 153, 153));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("READ");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 80, -1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        jLabel11.setBackground(new java.awt.Color(255, 153, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("UPDATE");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jLabel11.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel11ComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 80, -1));

        jPanel4.setBackground(new java.awt.Color(255, 153, 255));

        jLabel9.setBackground(new java.awt.Color(153, 153, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DELETE");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 80, -1));

        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Firstname");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Contact #");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 60, 20));

        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, -1));

        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 230, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Address");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 60, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Gender");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 60, 20));

        gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 100, 20));

        jPanel8.setBackground(new java.awt.Color(0, 153, 102));

        jLabel18.setBackground(new java.awt.Color(0, 153, 153));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("REFRESH");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        if(fname.getText().equals("") || lname.getText().equals("") || gender.getText().equals("") || age.getText().equals("") ||
        contact.getText().equals("") || address.getText().equals("") || dept.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please fill-up all forms");
        }else if(!id.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "Data already exist");
         id.setText("");
         fname.setText("");
         lname.setText("");
                gender.setText("");
                age.setText("");
                status.setSelectedItem("Single");
                contact.setText("");
                address.setText("");
                dept.setText("");
                jLabel12.setForeground(Color.white);
                load_teacher();
                counter();
        }     
         else{
         try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root", "root@123");
                Statement state = con.createStatement();
                state.executeUpdate("insert into tblteacher (`fname`,`lname`,`gender`,`age`,`status`,`contact`,`address`,`dept`) "
                + "values ('" + fname.getText() + "','" + lname.getText() + "','" + gender.getText() + "','" + age.getText() + "',"
                + "'" + status.getSelectedItem()+"','" + contact.getText() + "','" + address.getText() + "','" + dept.getText() + "')");
                
                JOptionPane.showMessageDialog(rootPane, "Successfully saved");
                fname.setText("");
                lname.setText("");
                gender.setText("");
                age.setText("");
                status.setSelectedItem("Single");
                contact.setText("");
                address.setText("");
                dept.setText("");
                load_teacher();
                counter();
                
            } catch (Exception x) {
                System.out.println(x.getMessage());
            } 
        }
        
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        jLabel10.setForeground(Color.black);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
         jLabel10.setForeground(Color.white);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        
        if(id.getText().equals("")){    
              JOptionPane.showMessageDialog(null, "Click one form the table");      
        }else{
          DefaultTableModel display = (DefaultTableModel) record.getModel();
          int r = record.getSelectedRow();
            READ read = new READ();
            read.setVisible(true);
            String[] Array = {display.getValueAt(r, 0).toString(),
            display.getValueAt(r, 1).toString(),
            display.getValueAt(r, 2).toString(),
            display.getValueAt(r, 3).toString(),
            display.getValueAt(r, 4).toString(),
            display.getValueAt(r, 5).toString(),
            display.getValueAt(r, 6).toString(),
            display.getValueAt(r, 7).toString(),
            display.getValueAt(r, 8).toString()};
   
            read.id.setText(Array[0]);
            read.fname.setText(Array[1]);
            read.lname.setText(Array[2]);
            read.gender.setText(Array[3]);
            read.age.setText(Array[4]);
            read.status.setText(Array[5]);
            read.contact.setText(Array[6]);
            read.address.setText(Array[7]);
            read.dept.setText(Array[8]);
        
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordMouseClicked
        // TODO add your handling code here:
        int t = record.getSelectedRow();
         String tid = record.getValueAt(t, 0).toString();
          String tname = record.getValueAt(t, 1).toString();
           String tlname = record.getValueAt(t, 2).toString();
            String tgender = record.getValueAt(t, 3).toString();
             String tage = record.getValueAt(t, 4).toString();
              String tstatus = record.getValueAt(t, 5).toString();
               String tcontact = record.getValueAt(t, 6).toString();
                String taddress = record.getValueAt(t, 7).toString();
                 String tdept = record.getValueAt(t, 8).toString();
         id.setText(tid);
         fname.setText(tname);
         lname.setText(tlname);
         gender.setText(tgender);
         age.setText(tage);
         status.setSelectedItem(tstatus);
         contact.setText(tcontact);
         address.setText(taddress);
         dept.setText(tdept);
    }//GEN-LAST:event_recordMouseClicked

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
                id.setText("");
                fname.setText("");
                lname.setText("");
                gender.setText("");
                age.setText("");
                status.setSelectedItem("Single");
                contact.setText("");
                address.setText("");
                dept.setText("");
                jLabel12.setForeground(Color.white);
                load_teacher();
                counter();
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        jLabel12.setForeground(Color.black);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        try {
            DefaultTableModel table = (DefaultTableModel) record.getModel();
            table.setRowCount(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root", "");
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery("select * from tblteacher where  fname like '%" + jTextField1.getText() + "%'");

                while (rs.next()) {
                Vector r = new Vector();
                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                table.addRow(r);       
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
 // TODO add your handling code here:
                String fName = fname.getText();
                String lName = lname.getText();
                String Gender = gender.getText();
                
        if(validateFields()){
            JOptionPane.showMessageDialog(null, "All fields are required");
        }
        else{
            try{
               
                PreparedStatement ps = con.prepareStatement("update category set name=? where category_pk=?");
                ps.setString(1,name);
                ps.setInt(2, categoryPK);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Category updated successfully!");
                setVisible(false);
                new ManageCategory().setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }        // TODO add your handling code here:

                                         

    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here
        jLabel11.setForeground(Color.black);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here
         jLabel11.setForeground(Color.white);

    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        if(id.getText().isEmpty()){
        }else{
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherdb", "root", "root@123");
                Statement state = con.createStatement();
                state.executeUpdate("delete from tblteacher where id = '" + id.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Successfully Deleted");
                 id.setText("");
                fname.setText("");
                lname.setText("");
                gender.setText("");
                age.setText("");
                status.setSelectedItem("Single");
                contact.setText("");
                address.setText("");
                dept.setText("");
                jLabel12.setForeground(Color.white);
                load_teacher();
                counter();
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }   
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jLabel9.setForeground(Color.black);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jLabel9.setForeground(Color.white);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        id.setText("");
                fname.setText("");
                lname.setText("");
                gender.setText("");
                age.setText("");
                status.setSelectedItem("Single");
                contact.setText("");
                address.setText("");
                dept.setText("");
                jLabel12.setForeground(Color.white);
                load_teacher();
                counter();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        jLabel18.setForeground(Color.black);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
         jLabel18.setForeground(Color.white);
    }//GEN-LAST:event_jLabel18MouseExited

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void jLabel11ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel11ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11ComponentShown

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
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField dept;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField gender;
    private javax.swing.JTextField id;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField lname;
    private javax.swing.JTable record;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables

    private static class tblteacher {

        public tblteacher() {
        }
    }
}
