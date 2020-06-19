package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LocadoraServicoImp extends UnicastRemoteObject implements ServicoLocadora {

	private static final long serialVersionUID = -6028791888292445711L;

	private List<Cliente> listaCliente;

	protected LocadoraServicoImp() throws RemoteException {
		listaCliente = new ArrayList<Cliente>();
	}

	@Override
	public boolean adicionarCliente(String nome) throws RemoteException {
		Cliente cliente = new Cliente(nome);
		if (listaCliente.contains(cliente)) {
			return false;
		} else {
			listaCliente.add(cliente);
			return true;
		}
	}

	@Override
	public boolean atualizarDebito(String nome, double novoDebito) throws RemoteException {
		Cliente cliente = new Cliente(nome);
		if (listaCliente.contains(cliente)) {
			int index = listaCliente.indexOf(cliente);
			cliente = listaCliente.get(index);

			cliente.setDebito(novoDebito);
			listaCliente.set(index, cliente);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public double consultarDebito(String nome) throws RemoteException {
		Cliente cliente = new Cliente(nome);
		if (listaCliente.contains(cliente)) {
			int index = listaCliente.indexOf(cliente);
			cliente = listaCliente.get(index);

			return cliente.getDebito();
		} else {
			return -1;
		}
	}

	@Override
	public boolean excluirCliente(String nome) throws RemoteException {
		Cliente cliente = new Cliente(nome);
		if (listaCliente.contains(cliente)) {
			int index = listaCliente.indexOf(cliente);
			listaCliente.remove(index);

			return true;
		} else {
			return false;
		}
	}

}
