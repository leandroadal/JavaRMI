package distri.conectorRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import br.ufal.aracomp.cosmos.limite.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite.spec.prov.IManager;

public class ServerON {
	
public static void main(String[] args) {
		
		IManager compLimite = ComponentFactory.createInstance();
		
		ILimiteOps limiteOps;
		limiteOps = (ILimiteOps)compLimite.getProvidedInterface("ILimiteOps");
		try {
			IConectorServidor connServer = new ConectorRMIServidor(limiteOps);
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost/connServer", connServer);
			System.out.println("Conector RMI (servidor1) OK");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
