package antrian_bazaar;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import antrian_bazaar.dialog.DialogAntrianRegistrasi;
import antrian_bazaar.dialog.Input_Buku;
import antrian_bazaar.dialog.DialogInputBuku;

import antrian_bazaar.tool.Buku;
import antrian_bazaar.tool.CenterLocation;
import antrian_bazaar.tool.RunAntrianRegistrasi;
import antrian_bazaar.tool.StopWatchku;
import antrian_bazaar.tool.Waktu;
import antrian_bazaar.tool.WaktuPelayanan;
import antrian_bazaar.tool.Waktuku;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import list.RegistrasiList;

public class FrameUtama extends javax.swing.JFrame {

    StopWatchku stopWatch;
    Waktu w[];
    public static boolean runOto = true;
    public static int jumlahAntrianTeller = 0;
    public static int waktuMulaiTeller = 10;
    int flag = 0;

    public FrameUtama() {
        initComponents();
        //ini ubah jtable1
        RunAntrianRegistrasi run = new RunAntrianRegistrasi(this.jTable2, this.jTable3,  this.jTable4);

        DefaultTableModel m = (DefaultTableModel) this.jTable4.getModel();
        List<Object> list = new ArrayList<>();
        list.add(new Object[]{"B-001", "SDA", 52000});
        list.add(new Object[]{"B-002", "RPL", 60000});
        list.add(new Object[]{"B-003", "DW", 53500});
        list.add(new Object[]{"B-004", "WEB", 40000});
        list.add(new Object[]{"B-005", "JKD", 35000});
        list.add(new Object[]{"B-006", "MTK", 30000});

        for (Object obj : list) {
            m.addRow((Object[]) obj);
        }
        
        DefaultTableModel m1 = (DefaultTableModel) this.jTable1.getModel();
        List<Object> list1 = new ArrayList<>();
        list1.add(new Object[]{"Abdul Aziz Fakhrul", "1855301079"});
        list1.add(new Object[]{"Farahdilla Anisa", "1855301043"});
        list1.add(new Object[]{"Jean", "1855301068"});
        list1.add(new Object[]{"M. Hasbi", "1855301084"});

        for (Object obj1 : list1) {
            m1.addRow((Object[]) obj1);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tombolRegis = new javax.swing.JButton();
        tombolInputBuku = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel5 = new javax.swing.JPanel();
        ketTeller = new javax.swing.JLabel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jToolBar4 = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Antrian Bazaar");

        jSplitPane1.setDividerLocation(300);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane2.setDividerLocation(250);

        jPanel1.setLayout(new java.awt.GridLayout(5, 2));

        tombolRegis.setText("Antrian Registrasi");
        tombolRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolRegisActionPerformed(evt);
            }
        });
        jPanel1.add(tombolRegis);

        tombolInputBuku.setText("Input Data Buku");
        tombolInputBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolInputBukuActionPerformed(evt);
            }
        });
        jPanel1.add(tombolInputBuku);

        Exit.setText("Keluar");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jPanel1.add(Exit);

        jScrollPane4.setViewportView(jPanel1);

        jSplitPane2.setLeftComponent(jScrollPane4);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Antrian Bazaar"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 0, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", ""}
            },
            new String [] {
                "No Urut", "Status", "Waktu", "Waktu Pelayanan", "Status", "Nama", "Buku"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(30);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(ketTeller);

        jToolBar1.add(jPanel5);

        jPanel4.add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jSplitPane2.setRightComponent(jPanel4);
        jPanel4.getAccessibleContext().setAccessibleName("");

        jSplitPane1.setTopComponent(jSplitPane2);

        jSplitPane3.setDividerLocation(500);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kelompok 2"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", ""}
            },
            new String [] {
                "Nama", "NIM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar2.setRollover(true);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));
        jToolBar2.add(jPanel6);

        jPanel3.add(jToolBar2, java.awt.BorderLayout.PAGE_END);

        jSplitPane3.setLeftComponent(jPanel3);

        jSplitPane4.setDividerLocation(300);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Antrian Registrasi Bazaar"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(123, 0, 67));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Urut", "Status", "Waktu", "Nama", "Buku"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jToolBar3.setRollover(true);
        jPanel2.add(jToolBar3, java.awt.BorderLayout.PAGE_END);

        jSplitPane4.setRightComponent(jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("List Buku"));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable4.setForeground(new java.awt.Color(123, 0, 67));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Buku", "Judul Buku", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(25);
        jScrollPane5.setViewportView(jTable4);

        jPanel8.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jToolBar4.setRollover(true);
        jPanel8.add(jToolBar4, java.awt.BorderLayout.PAGE_END);

        jSplitPane4.setLeftComponent(jPanel8);

        jSplitPane3.setRightComponent(jSplitPane4);

        jSplitPane1.setRightComponent(jSplitPane3);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolRegisActionPerformed
        DialogAntrianRegistrasi reg = new DialogAntrianRegistrasi(this, true, this.jTable2);
        CenterLocation center = new CenterLocation(reg);
        reg.setVisible(true);
    }//GEN-LAST:event_tombolRegisActionPerformed
   
    private void tombolInputBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolInputBukuActionPerformed
        DialogInputBuku input = new DialogInputBuku(this, true, this.jTable4);
        CenterLocation center = new CenterLocation(input);
        input.setVisible(true);
    }//GEN-LAST:event_tombolInputBukuActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    public void runperKlik(int cek) {
        String no_antrian = "";
        String waktu_antrian = "";
        String nama = "";
        String buku = "";

        int[] value = RegistrasiList.cariPrioritas();
        DefaultTableModel m = (DefaultTableModel) this.jTable2.getModel();

        for (int i = 0; i < m.getRowCount(); i++) {
            if (value[1] == Integer.parseInt(
                    m.getValueAt(i, 0).toString())) {
                no_antrian = m.getValueAt(i, 0).toString();
                waktu_antrian = m.getValueAt(i, 2).toString();
                nama = m.getValueAt(i, 3).toString();
                buku = m.getValueAt(i, 4).toString();

                DefaultTableModel m3 = (DefaultTableModel) this.jTable3.getModel();
                m3.setValueAt(no_antrian, cek, 1);
                m3.setValueAt(waktu_antrian, cek, 2);

                m.removeRow(i);
                RegistrasiList.deleteAntrianPrioritas(value[0]);
                RegistrasiList.cetakAntrianRegistrasi();
            }
        }
        StopWatchku sto = new StopWatchku(new Waktuku(0, 0, 0));

        WaktuPelayanan w = new WaktuPelayanan(sto,
                jTable3,
                Integer.parseInt(waktu_antrian), true);

        DefaultTableModel m3 = (DefaultTableModel) this.jTable3.getModel();
        m3.setValueAt(nama, cek, 5);
        m3.setValueAt(buku, cek, 6);

    }

    public void runOtomatisRegistrasi() {
        DefaultTableModel m = (DefaultTableModel) this.jTable3.getModel();

        while (this.jTable2.getRowCount() > 0) {
            //for(int i=0;i<m.getRowCount();i++){
            int i = 0;
            while (i < m.getRowCount()) {
                if (m.getValueAt(i, 4).toString().equalsIgnoreCase("")) {
                    this.runperKlik(i);
                    System.out.println("ok " + i);
                }
                i++;

            }
            //}
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }
                FrameUtama f = new FrameUtama();
                f.setVisible(true);
            }
            public void run2() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }
                FrameUtama f = new FrameUtama();
                f.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
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
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JLabel ketTeller;
    private javax.swing.JButton tombolInputBuku;
    private javax.swing.JButton tombolRegis;
    // End of variables declaration//GEN-END:variables

}
