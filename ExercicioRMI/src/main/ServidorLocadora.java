package main;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class ServidorLocadora {

	public static void main(String[] args) {
		System.setProperty("java.security.policy", "server.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			ServicoLocadora obj = new LocadoraServicoImp();
			Naming.rebind("LocadoraServer", obj);
		} catch (Exception e) {
			System.out.println("LocadoraServiceImpl err: " + e.getMessage());
		}
	}

}
