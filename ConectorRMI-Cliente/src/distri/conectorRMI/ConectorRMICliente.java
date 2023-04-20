package distri.conectorRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;

public class ConectorRMICliente implements ILimiteReq{
	
	private IConectorServidor connServer;
	private IConectorServidor connServer2;
	private int count = 0;
	
	
	public ConectorRMICliente(){
		try{
			this.connServer = (IConectorServidor) Naming.lookup("rmi://localhost:1099/connServer");
			this.connServer2 = (IConectorServidor) Naming.lookup("rmi://localhost:1088/connServer2");
		}catch(RemoteException e){
			e.printStackTrace();
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
		catch(NotBoundException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public double estimarLimite(UsuarioDT usuario){
		try{
			// Implementado o Round-Robin Ponderado através de um contador
			System.out.println(count);
			if (count < 2) { // 0 e 1 usa o servidor um
				ClienteDTServidor cliente = new ClienteDTServidor();
				cliente.salario = Double.parseDouble(usuario.rendimentos);
				count += 1;
				return this.connServer.calcularLimiteRMI(cliente);
			} else {
				ClienteDTServidor cliente = new ClienteDTServidor();
				cliente.salario = Double.parseDouble(usuario.rendimentos);
				this.count = 0; // zera o contador
				return this.connServer2.calcularLimiteRMI(cliente);				
			}
		}catch(Exception e){
			return 0;
		}

	}

}
