package distri.conectorRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConectorServidor extends Remote{
	
	public double calcularLimiteRMI(ClienteDTServidor clienteServidor) throws RemoteException;

}
