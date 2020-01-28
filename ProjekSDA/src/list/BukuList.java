/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.awt.List;
import antrian_bazaar.tool.Antrian;

/**
 *
 * @author kantor-linux
 */
class CS{

    Antrian antrianRegistrasi;
    int data;
    Registrasi next;

    public CS() {

    }

    public CS(int data) {
        this.data = data;
    }

    public Antrian getAntrianRegistrasi() {
        return antrianRegistrasi;
    }

    public void setAntrianRegistrasi(Antrian antrianRegistrasi) {
        this.antrianRegistrasi = antrianRegistrasi;
    }

}

public class BukuList {

    static int dataCari = 0;
    static Registrasi regis = null;

    public BukuList() {

    }

    public static void insertAntrianAwal(int data) {
        Registrasi antrianSementara = new Registrasi(data);
        if (regis == null) {
            regis = antrianSementara;
        } else {
            antrianSementara.next = regis;
            regis = antrianSementara;
        }
    }

    public static void insertAntrianAwal(int data, Antrian antri) {
        Registrasi antrianSementara = new Registrasi(data);
        antrianSementara.setAntrianRegistrasi(antri);
        if (regis == null) {
            regis = antrianSementara;
        } else {
            antrianSementara.next = regis;
            regis = antrianSementara;
        }
    }

    public static void cetakAntrian() {
        System.out.println("Antrian Yang ada ");
        Registrasi k = RegistrasiList.regis;
        while (k != null) {
            if (k.next == null) {
                System.out.print("null");
                break;
            } else {
                System.out.print(k.data + "->");
                k = k.next;
            }
        }
        System.out.println("");
    }

    public static void cetakAntrianRegistrasi() {
        System.out.println("Antrian Yang ada ");
        Registrasi k = RegistrasiList.regis;
        while (k != null) {
            System.out.print("No Urut Antrian : "+k.getAntrianRegistrasi().getNo_urut() + " Dengan Waktu : "
                    + k.getAntrianRegistrasi().getWaktu()+"\n");
            k = k.next;
        }
        System.out.println("");
    }

    public static void insertAntrianAkhir(int data) {
        Registrasi antrianSementara = new Registrasi(data);
        if (regis == null) {
            regis = antrianSementara;
        } else {
            Registrasi bantu = regis;
            while (bantu.next != null) {
                bantu = bantu.next;
            }
            bantu.next = antrianSementara;
        }
    }

    public static void deleteAntrianAwal() {
        if (regis == null) {
            System.out.println("Antrian masih kosong tidak bisa dihapus");
        } else {
            System.out.println("Yang di ambil: " + regis.data);
            dataCari = regis.data;
            Registrasi k = regis.next;
            regis = k;

        }
    }

    public static int dataYangdiCari() {
        return dataCari;
    }

    public static void deleteAntrianAkhir() {
        if (regis == null) {
            System.out.println("Antrian masih kosong tidak bisa dihapus");
        } else {
            Registrasi k = regis;
            while (k.next.next != null) {
                k = k.next;
            }
            System.out.println("Antrian Di hapus sebelum null");
            k.next = null;
            

        }
    }

    public static Object[] cariPosisiAntrian(int cari) {
        System.out.println("---------- Cari Posisi Antrian ----------");
        Object object[] = new Object[2];
        if (regis == null) {
            System.out.println("Tidak dapat dilakukan pencarian, antrian kosong");
        } else {
            int nomor = 1;
            Registrasi k = regis;
            while (k.next != null) {
                if (k.data == cari) {
                    object[0] = nomor;
                    object[1] = cari;
                }
                k = k.next;
                nomor++;
            }
        }
        return object;
    }

    public static void cetakHasilPencarian2(Object[] cari) {
        System.out.println("Data yang dicari diposisi ke " + cari[0] + " bernilai: " + cari[1]);
    }

    public static int[] cariPrioritas() {
        int max = 0;
        int no_urut = 0;
        if (regis == null) {
            //System.out.println("Tidak dapat mencari prioritas, kereta kosong");
        } else {             //Kereta sementara=new Kereta(yangdicari);

            if (regis.next != null) {
                Registrasi k = regis;
                max = k.next.getAntrianRegistrasi().getPoint();
                no_urut = k.next.getAntrianRegistrasi().getNo_urut();
                while (k.next != null) {
                    //Nilai Untuk Menentukan Prioritas
//                    System.out.println(max + " = " + k.next.getAntrianRegistrasi().getPoint());
                    if (k.next.getAntrianRegistrasi().getPoint() < max) {
                        max = k.next.getAntrianRegistrasi().getPoint();
                        no_urut = k.next.getAntrianRegistrasi().getNo_urut();
                    }
                    k = k.next;
                }
//                System.out.println("Nilai terakhir: " + regis.getAntrianRegistrasi().getPoint());
                if (regis.getAntrianRegistrasi().getPoint() < max) {
                    max = regis.getAntrianRegistrasi().getPoint();
                    no_urut = regis.getAntrianRegistrasi().getNo_urut();
                }
//                System.out.println("max: " + max + " no urut " + no_urut);
            } else {
                max = regis.getAntrianRegistrasi().getPoint();
                no_urut = regis.getAntrianRegistrasi().getNo_urut();
            }

        }
        return new int[]{max, no_urut};
    }

    public static void deleteAntrianPrioritas(int prioritas) {
        System.out.println("---------- Menghapus antrian yang dicari ----------");
        if (regis == null) {
            System.out.println("Tidak dapat dilakukan penggantian, antrian kosong");
        } else {
            //Kereta sementara=new Kereta(yangdicari);
            if (regis.next != null) {
                Registrasi k = regis;
                while (k.next.getAntrianRegistrasi().getPoint() != prioritas && k.next.next != null) {
                    k = k.next;
                }
                if (k.next.getAntrianRegistrasi().getPoint() != prioritas) {
                    //System.out.println("Data yang dicari tidak ditemukan");
                    Registrasi kk = regis.next;
                    if (regis.getAntrianRegistrasi().getPoint() == prioritas) {
                        regis = kk;
                    }
                } else {
                    k.next = k.next.next;
                }
            } else {
                deleteAntrianAwal();
            }

        }
    }

    public static void deleteAntrianYangdiCari(int yangdicari) {
        System.out.println("---------- Menghapus Antrian yand dicari ----------");
        if (regis == null) {
            System.out.println("Tidak dapat dilakukan penggatian, antrian kosong");
        } else {
            //Kereta sementara=new Kereta(yangdicari);
            Registrasi k = regis;
            while (k.next.data != yangdicari && k.next.next != null) {
                k = k.next;
            }
            if (k.next.data != yangdicari) {
                System.out.println("Data yang dicari tidak ditemukan");
            } else {
                System.out.println("Data yang Terhapus : "+yangdicari);
                k.next = k.next.next;
            }
        }
    }

    public static void main(String arg[]) {
        RegistrasiList.insertAntrianAkhir(30);
        RegistrasiList.insertAntrianAwal(610);
        RegistrasiList.insertAntrianAwal(50);
        RegistrasiList.insertAntrianAwal(10);
        RegistrasiList.insertAntrianAkhir(20);
        RegistrasiList.cetakAntrian();
        RegistrasiList.deleteAntrianAkhir();
        RegistrasiList.cetakAntrian();
        RegistrasiList.deleteAntrianYangdiCari(50);
        RegistrasiList.cetakAntrian();
    }
}
