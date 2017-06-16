
import client.clientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arifztenk
 */
public class golek extends UnicastRemoteObject implements clientInterface{
    private static int termfile;
    private static search se = new search();
    private static loadfiles lf = new loadfiles();
    private static DecimalFormat df = new DecimalFormat("#.##");
    private static convertword cw = new convertword();
    
    public golek() throws RemoteException{
        
    }
    public void nyareh(String query) throws RemoteException{
        System.out.println(query);
        se.pertama(query,2);
        termfile=0;
        for(int i=0;i<30;i++){
            if(se.nilai[i][0]>0){
                termfile++;
            }
        }
    }
    public int jumlah() throws RemoteException{
        return termfile;
    }
    public String hasil(int index) throws RemoteException{
        int idx = (int) Math.round(se.nilai[index][1]);
        
        String data = "ID Doc\t\t: "+ idx +
            "\nName File\t\t: "+lf.listOfFiles[idx-1].getName() +
            "\nTotal Kesamaan kata\t: "+(int) se.nilai[index][2] +
            "\nRangking\t\t: "+df.format(se.nilai[index][0]) +
            "\nIsi dari File\t: \n"+cw.convert[idx-1] ;
        return data;
    }
}
