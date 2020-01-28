package antrian_bazaar.tool;

public class GenerateAntrian {
    Antrian antrian;
    public GenerateAntrian(int no_urut, String status, int waktunya, String nama, String buku){
        int sta=1;
        if(status.equalsIgnoreCase("Non-Member")){
            sta=1;
        }else{
            sta=2;
        }
        antrian=new Antrian(no_urut, sta, waktunya, nama, buku);
    }

    public Antrian getAntrian() {
        return antrian;
    }

    public void setAntrian(Antrian antrian) {
        this.antrian = antrian;
    }
    
}
