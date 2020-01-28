package antrian_bazaar.tool;

public class Buku {
    String id, judul;
    int harga;

    public Buku(){
        
    }
    
    public Buku(String id, String judul, int harga) {
        this.id = id;
        this.judul = judul;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
