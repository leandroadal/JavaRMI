package rmi.principal;

import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import distri.conectorRMI.ConectorRMICliente;

public class Principal {
	public static void main(String[] args) {
		// Instanciando empréstimo
		br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager compEmp = 
				ComponentFactory.createInstance();
		
		// Instanciando o conector
		ConectorRMICliente conector = new ConectorRMICliente();
		compEmp.setRequiredInterface("ILimiteReq", conector);
		
		IEmprestimoOps objEmpOps = (IEmprestimoOps)compEmp.getProvidedInterface("IEmprestimoOps");
		UsuarioDT usuario = new UsuarioDT();
		usuario.rendimentos = "1500";
		System.out.println(objEmpOps.liberarEmprestimoAutomatico(usuario));
		
		UsuarioDT usuario1 = new UsuarioDT();
		usuario1.rendimentos = "1666";
		System.out.println(objEmpOps.liberarEmprestimoAutomatico(usuario1));
		
		UsuarioDT usuario2 = new UsuarioDT();
		usuario2.rendimentos = "6000";
		System.out.println(objEmpOps.liberarEmprestimoAutomatico(usuario2));
		
		UsuarioDT usuario3 = new UsuarioDT();
		usuario3.rendimentos = "10000";
		System.out.println(objEmpOps.liberarEmprestimoAutomatico(usuario3));
	}

}
