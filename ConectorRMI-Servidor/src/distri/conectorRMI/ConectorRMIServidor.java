package distri.conectorRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

public class ConectorRMIServidor extends UnicastRemoteObject implements IConectorServidor, Serializable{
	
	private static final long serialVersionUID = 1L;
	private ILimiteOps limiteOps;
	
	public ConectorRMIServidor(ILimiteOps limiteOps) throws RemoteException{
		super();
		this.limiteOps = limiteOps;
	}
	
	@Override
	public double calcularLimiteRMI(ClienteDTServidor clienteServidor) throws RemoteException {
		try {
			System.out.println("Servidor do conector executando...");
			ClienteDT cliente = new ClienteDT();
			cliente.salario = clienteServidor.salario;
			return this.limiteOps.calcularLimite(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
