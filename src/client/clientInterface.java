/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.*;

/**
 *
 * @author arifztenk
 */
public interface clientInterface extends Remote{
    public void nyareh(String query) throws RemoteException;
    public int jumlah() throws RemoteException;
    public String hasil(int index) throws RemoteException;
}