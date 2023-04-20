package distri.conectorRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.ufal.aracomp.cosmos.limite.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite.spec.prov.IManager;

public class ServerON2 {
	
public static void main(String[] args) {
		
		IManager compLimite = ComponentFactory.createInstance();
		
		ILimiteOps limiteOps;
		limiteOps = (ILimiteOps)compLimite.getProvidedInterface("ILimiteOps");
		try {
			IConectorServidor connServer2 = new ConectorRMIServidor(limiteOps);
			Registry rgsty = LocateRegistry.createRegistry(1088);
		    rgsty.rebind("connServer2", connServer2);
			System.out.println("Conector RMI (servidor2) OK");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
