/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.mysql.jdbc.Connection;
import controllers.EmployeeController;
import controllers.icontrollers.IEmployeeController;
import daos.EmployeeDao;
import daos.idaos.IEmployeeDao;
import static java.awt.SystemColor.text;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import models.EmployeeModel;
import tools.DbConnection;
import java.util.ServiceLoader;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeView extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeView
     */
    public EmployeeView() {
        initComponents();
        tampil();
    }

    void tampil() {
        DbConnection connection = new DbConnection();
        IEmployeeDao iedao = new EmployeeDao(connection.GetConnection());
        DefaultTableModel dt;
        DefaultButtonModel db;
        Object[] baris = {"No", "Employee ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Job ID", "Salary", "Commision Pct", "Manager ID", "Departement ID"};
        dt = new DefaultTableModel(null, baris);
        employeeTable.setModel(dt);
        employeeIdField.setEditable(true);

        employeeIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        hireDateField.setText("");
        jobIdField.setText("");
        salaryField.setText("");
        commisionPctField.setText("");
        managerIdField.setText("");
        departementIdField.setText("");

        try {
            int i = 1;
            for (EmployeeModel empliong : iedao.getAll()) {
//                System.out.println(regiong.getRegionId() + " || " + regiong.getRegionName());

                String NO = (String) Integer.toString(i);
                String ID = (String) empliong.getEmployeeId().toString();
                String FN = (String) empliong.getFirstName().toString();
                String LN = (String) empliong.getLastName().toString();
                String E = (String) empliong.getEmail().toString();
                String PN = (String) empliong.getPhoneNumber().toString();
                String HD = (String) empliong.getHireDate().toString();
                String JI = (String) empliong.getJobId().toString();
                String S = (String) empliong.getSalary().toString();
                String CP = (String) empliong.getCommisionPct().toString();
                String MI = (String) empliong.getManagerId().toString();
                String DI = (String) empliong.getDepartementId().toString();

                String[] data = {NO, ID, FN, LN, E, PN, HD, JI, S, CP, MI, DI};
                dt.addRow(data);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void searching() {
        DbConnection connection = new DbConnection();
        IEmployeeDao iedao = new EmployeeDao(connection.GetConnection());
        IEmployeeController iec = new EmployeeController(connection.GetConnection());
        EmployeeModel employee = new EmployeeModel(searchButton.getText());

//        Region r = new Region();
        DefaultTableModel dt;
        DefaultButtonModel db;

        Object[] baris = {"Employee ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date", "Job ID", "Salary", "Commision Pct", "Manager ID", "Departement ID"};
        dt = new DefaultTableModel(null, baris);
        employeeTable.setModel(dt);

        try {
            for (EmployeeModel empliong : iedao.search(searchField.getText())) {
//                System.out.println(regiong.getRegionId() + " || " + regiong.getRegionName());

                String ID = (String) empliong.getEmployeeId().toString();
                String FN = (String) empliong.getFirstName().toString();
                String LN = (String) empliong.getLastName().toString();
                String E = (String) empliong.getEmail().toString();
                String PN = (String) empliong.getPhoneNumber().toString();
                String HD = (String) empliong.getHireDate().toString();
                String JI = (String) empliong.getJobId().toString();
                String S = (String) empliong.getSalary().toString();
                String CP = (String) empliong.getCommisionPct().toString();
                String MI = (String) empliong.getManagerId().toString();
                String DI = (String) empliong.getDepartementId().toString();

                String bt = (String) refreshButton.toString();

                String[] data = {ID, FN, LN, E, PN, HD, JI, S, CP, MI, DI};
                dt.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        employeeIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        hireDateField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jobIdField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        commisionPctField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        managerIdField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        departementIdField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 48, 36));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 40)); // NOI18N
        jLabel5.setText("Employees Table");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, 81));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee ID :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        employeeIdField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        employeeIdField.setPreferredSize(new java.awt.Dimension(4, 26));
        employeeIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdFieldActionPerformed(evt);
            }
        });
        employeeIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeIdFieldKeyReleased(evt);
            }
        });
        jPanel3.add(employeeIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 250, 24));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        firstNameField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, 250, 24));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, -1, -1));

        lastNameField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 159, 250, 24));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 194, -1, -1));

        emailField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        jPanel3.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 24));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone Number :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 255, -1, -1));

        phoneNumberField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });
        jPanel3.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 281, 250, 24));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hire Date :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 316, -1, -1));

        hireDateField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hireDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hireDateFieldActionPerformed(evt);
            }
        });
        jPanel3.add(hireDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 342, 250, 24));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Job ID :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 377, -1, -1));

        jobIdField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jobIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobIdFieldActionPerformed(evt);
            }
        });
        jobIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jobIdFieldKeyReleased(evt);
            }
        });
        jPanel3.add(jobIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 403, 250, 24));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Salary :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 438, -1, -1));

        salaryField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        salaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryFieldActionPerformed(evt);
            }
        });
        jPanel3.add(salaryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 464, 250, 24));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Commision Pct :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 499, -1, -1));

        commisionPctField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        commisionPctField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commisionPctFieldActionPerformed(evt);
            }
        });
        jPanel3.add(commisionPctField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 525, 250, 24));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manager ID :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        managerIdField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        managerIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerIdFieldActionPerformed(evt);
            }
        });
        managerIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                managerIdFieldKeyReleased(evt);
            }
        });
        jPanel3.add(managerIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 586, 250, 24));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Departement ID :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 621, -1, -1));

        departementIdField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        departementIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departementIdFieldActionPerformed(evt);
            }
        });
        departementIdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                departementIdFieldKeyReleased(evt);
            }
        });
        jPanel3.add(departementIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 647, 250, 24));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 270, 690));

        employeeTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        employeeTable.setColumnSelectionAllowed(true);
        employeeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        employeeTable.setRequestFocusEnabled(false);
        employeeTable.setRowMargin(2);
        employeeTable.setVerifyInputWhenFocusTarget(false);
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(employeeTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 1060, 520));

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 180, 30));

        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yosef Febrianes\\Downloads\\icons8-search-20.png")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 60, 30, -1));

        insertButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        insertButton.setText("INSERT");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        jPanel1.add(insertButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 640, 120, 40));

        updateButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, 120, 40));

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 640, 120, 40));

        refreshButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yosef Febrianes\\Downloads\\icons8-refresh-26.png")); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 640, 50, 40));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Yosef Febrianes\\Downloads\\icons8-exit-sign-46.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 660, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1372, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdFieldActionPerformed

    }//GEN-LAST:event_employeeIdFieldActionPerformed

    private void employeeIdFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeIdFieldKeyReleased
        // TODO add your handling code here:
        int position = employeeIdField.getCaretPosition();
        employeeIdField.setText(employeeIdField.getText().toUpperCase());
        employeeIdField.setCaretPosition(position);
    }//GEN-LAST:event_employeeIdFieldKeyReleased

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void hireDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hireDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hireDateFieldActionPerformed

    private void jobIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobIdFieldActionPerformed

    private void jobIdFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobIdFieldKeyReleased
        // TODO add your handling code here:
        int position = jobIdField.getCaretPosition();
        jobIdField.setText(jobIdField.getText().toUpperCase());
        jobIdField.setCaretPosition(position);
    }//GEN-LAST:event_jobIdFieldKeyReleased

    private void salaryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryFieldActionPerformed

    private void commisionPctFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commisionPctFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commisionPctFieldActionPerformed

    private void managerIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managerIdFieldActionPerformed

    private void departementIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departementIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departementIdFieldActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searching();
        searchField.setText("");
    }//GEN-LAST:event_searchButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        DbConnection connection = new DbConnection();
        IEmployeeDao iedao = new EmployeeDao(connection.GetConnection());
        IEmployeeController iec = new EmployeeController(connection.GetConnection());
        EmployeeModel location = new EmployeeModel(employeeIdField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), phoneNumberField.getText(), hireDateField.getText(), jobIdField.getText(), salaryField.getText(), commisionPctField.getText(), managerIdField.getText(), departementIdField.getText());

        JOptionPane.showMessageDialog(null, iec.insert(location));
        SwingUtilities.updateComponentTreeUI(insertButton);

        employeeIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        hireDateField.setText("");
        jobIdField.setText("");
        salaryField.setText("");
        commisionPctField.setText("");
        managerIdField.setText("");
        departementIdField.setText("");

        tampil();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        DbConnection connection = new DbConnection();
        IEmployeeController iec = new EmployeeController(connection.GetConnection());
        //        regionIdField.setEditable(false);
        EmployeeModel location = new EmployeeModel(employeeIdField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), phoneNumberField.getText(), hireDateField.getText(), jobIdField.getText(), salaryField.getText(), commisionPctField.getText(), managerIdField.getText(), departementIdField.getText());

        JOptionPane.showMessageDialog(null, iec.update(location));

        employeeIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        hireDateField.setText("");
        jobIdField.setText("");
        salaryField.setText("");
        commisionPctField.setText("");
        managerIdField.setText("");
        departementIdField.setText("");
        tampil();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DbConnection connection = new DbConnection();
        IEmployeeController iec = new EmployeeController(connection.GetConnection());
        //setText((String) source.getModel().getValueAt(row, column));
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete", "Title on Box", dialogButton);
        if (dialogResult == 0) {
            EmployeeModel employee = new EmployeeModel(employeeIdField.getText(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), phoneNumberField.getText(), hireDateField.getText(), jobIdField.getText(), salaryField.getText(), commisionPctField.getText(), managerIdField.getText(), departementIdField.getText());

            JOptionPane.showMessageDialog(null, iec.delete(employee.getEmployeeId()));

            employeeIdField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            phoneNumberField.setText("");
            hireDateField.setText("");
            jobIdField.setText("");
            salaryField.setText("");
            commisionPctField.setText("");
            managerIdField.setText("");
            departementIdField.setText("");

            tampil();
        } else {
            tampil();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        tampil();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void managerIdFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_managerIdFieldKeyReleased
        // TODO add your handling code here:
        int position = managerIdField.getCaretPosition();
        managerIdField.setText(managerIdField.getText().toUpperCase());
        managerIdField.setCaretPosition(position);
    }//GEN-LAST:event_managerIdFieldKeyReleased

    private void departementIdFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_departementIdFieldKeyReleased
        // TODO add your handling code here:
        int position = departementIdField.getCaretPosition();
        departementIdField.setText(departementIdField.getText().toUpperCase());
        departementIdField.setCaretPosition(position);
    }//GEN-LAST:event_departementIdFieldKeyReleased

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        // TODO add your handling code here:

        JTable source = (JTable) evt.getSource();
        int i = employeeTable.getSelectedRow();
        
        employeeIdField.setEditable(false);

        employeeIdField.setText((String) source.getModel().getValueAt(i, 1));
        firstNameField.setText((String) source.getModel().getValueAt(i, 2));
        lastNameField.setText((String) source.getModel().getValueAt(i, 3));
        emailField.setText((String) source.getModel().getValueAt(i, 4));
        phoneNumberField.setText((String) source.getModel().getValueAt(i, 5));
        hireDateField.setText((String) source.getModel().getValueAt(i, 6));
        jobIdField.setText((String) source.getModel().getValueAt(i, 7));
        salaryField.setText((String) source.getModel().getValueAt(i, 8));
        commisionPctField.setText((String) source.getModel().getValueAt(i, 9));
        managerIdField.setText((String) source.getModel().getValueAt(i, 10));
        departementIdField.setText((String) source.getModel().getValueAt(i, 11));

    }//GEN-LAST:event_employeeTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
//        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField commisionPctField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departementIdField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField employeeIdField;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField hireDateField;
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jobIdField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField managerIdField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField salaryField;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
