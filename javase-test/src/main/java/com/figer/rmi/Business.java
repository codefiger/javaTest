package com.figer.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Business extends Remote{
	String echo(String message) throws RemoteException;
}
