/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author jun
 */
public class Stack {
    public Stack(){
        RegistrasiList.insertAntrianAkhir(20);
        RegistrasiList.insertAntrianAwal(40);
        RegistrasiList.insertAntrianAwal(50);
        RegistrasiList.cetakAntrian();
        RegistrasiList.deleteAntrianAwal();
        RegistrasiList.cetakAntrian();
        System.out.println(RegistrasiList.regis.data);
    }
    public static void main (String arg[]){
        Stack stack=new Stack();
    }
}
