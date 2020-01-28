package antrian_bazaar.tool;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import list.RegistrasiList;

public class RunAntrianRegistrasi implements Runnable {

    private final Thread tt;
    StopWatchku stop;
    JTable table2, table3, table1, table4;
    public boolean kendaliRun = true;
    int flag = 0;

    //ini ubah jtable1
    public RunAntrianRegistrasi(JTable table2, JTable table3, JTable table4) {
        tt = new Thread(this);
        tt.start();
        this.table2 = table2;
        this.table3 = table3;
        this.table4 = table4;
    }

    @Override
    public void run() {
        while (kendaliRun) {
            try {
                WaktuPelayanan w[] = new WaktuPelayanan[table3.getRowCount()];
                int j = 0;
                while (j < table3.getRowCount()) {
                    if (table3.getValueAt(j, 4).toString().equalsIgnoreCase("")) {
                        String no_antrian = "";
                        String waktu_antrian = "0";
                        String status = "";
                        String nama = "";
                        String buku = "";
                        String id = "";
                        int harga = 0;

                        int[] value = RegistrasiList.cariPrioritas();
                        DefaultTableModel m = (DefaultTableModel) table2.getModel();
                        int i = 0;

                        while (i < m.getRowCount()) {
                            if (value[1] == Integer.parseInt(
                                    m.getValueAt(i, 0).toString())) {
                                no_antrian = m.getValueAt(i, 0).toString();
                                no_antrian = m.getValueAt(i, 0).toString();
                                waktu_antrian = m.getValueAt(i, 2).toString();
                                status = m.getValueAt(i, 1).toString();
                                nama = m.getValueAt(i, 3).toString();
                                buku = m.getValueAt(i, 4).toString();

                                //tambahan untuk searching array
                                for (int k = 0; k < table4.getRowCount(); k++) {
                                    if (buku.equalsIgnoreCase(table4.getValueAt(k, 1).toString())) {
                                        flag = 2;
                                        id = table4.getValueAt(k, 0).toString();
                                        harga = Integer.parseInt(table4.getValueAt(k, 2).toString());
                                        break;
                                    } else {
                                        flag = 0;
                                    }
                                }

                                DefaultTableModel m3 = (DefaultTableModel) table3.getModel();                   
                                m3.setValueAt("No Urut " + no_antrian, j, 0);
                                m3.setValueAt("Status " + status, j, 1);
                                m3.setValueAt(waktu_antrian, j, 2);
                                m3.setValueAt(nama, j, 5);
                                m3.setValueAt(buku, j, 6);

                                m.removeRow(i);
                                RegistrasiList.deleteAntrianPrioritas(value[0]);
                                RegistrasiList.cetakAntrianRegistrasi();

                            }
                            i++;

                            //menampilkan hasil search array
                            if (flag == 2) {
                                JOptionPane.showMessageDialog(null, "Data Buku ditemukan ! \n- Id Buku " + id + "\n- Judul " 
                                        + buku + "\n- harga Rp." + harga + "\n\nSilahkan Melakukan Pembayaran ke Teller 1");

                            } else {
                                JOptionPane.showMessageDialog(null, "Data Buku dengan judul " + buku + " tidak ditemukan");
                            }
                        }

                        StopWatchku sto = new StopWatchku(new Waktuku(0, 0, 0));
                        w[j] = new WaktuPelayanan(sto,
                                table3,
                                Integer.parseInt(waktu_antrian), true);

                    }

                    j++;
                }
                Thread.sleep(1000);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
                //kendaliRun=false;

            }
        }
    }
}
