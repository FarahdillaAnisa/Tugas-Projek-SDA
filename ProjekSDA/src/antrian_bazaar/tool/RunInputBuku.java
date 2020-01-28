/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian_bazaar.tool;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import list.BukuList;
import list.RegistrasiList;

/**
 *
 * @author juna
 */
public class RunInputBuku implements Runnable{
    private final Thread tt;
    JTable table3, table1;
    public boolean kendaliRun=true;
    
    //jtable3,jTable1 yang diujung
    public RunInputBuku(JTable table3,JTable table1){
        tt=new Thread(this);
        tt.start();
        this.table3=table3;
        this.table1=table1;
    }

    @Override
    public void run() {
        while(kendaliRun){
            
            try {
                WaktuPelayanan w[]=new WaktuPelayanan[table1.getRowCount()];
                int j=0;
                while(j<table1.getRowCount()){
                    if(table1.getValueAt(j, 4).toString().equalsIgnoreCase("")){
                    String no_antrian="";
                    String waktu_antrian="0";
                    String status="";
                    String id_judul="";
                    int harga;
                    
                int [] value=BukuList.cariPrioritas();
                DefaultTableModel m=(DefaultTableModel)table3.getModel();
                for(int i=0;i<m.getRowCount();i++){
                    
                    //String cs=m3.getValueAt(i, 0).toString();
                    if(value[1]==Integer.parseInt(
                        m.getValueAt(i, 0).toString())){
                        no_antrian=m.getValueAt(i, 1).toString();
                        waktu_antrian=m.getValueAt(i, 2).toString();
//                        status=m.getValueAt(i, 1).toString();
                        
                        DefaultTableModel m3=(DefaultTableModel)table1.getModel();
                       // Thread t=new Thread();
                        //t.start();
                        String html="<html><body><font size=3 color=#ff0000><b>No antrian "+no_antrian+
                                " ditunggu </b></font></body></html>";
                        m3.setValueAt(html
                                , j, 1);
                        //t.sleep(500);                        
                        m3.setValueAt("No "+no_antrian+" status "+status, j, 1);
                        m3.setValueAt(waktu_antrian, j, 2);
                        m3.setValueAt("", j, 5);
                        m3.setValueAt("", j, 6);
                        m.removeRow(i);
                        BukuList.deleteAntrianPrioritas(value[0]);
                        BukuList.cetakAntrianRegistrasi();
                    }
                }
                StopWatchku sto=new StopWatchku(new Waktuku(0, 0, 0));
                w[j]=new WaktuPelayanan(sto,
                        table1, 
                        Integer.parseInt(waktu_antrian),true);
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
