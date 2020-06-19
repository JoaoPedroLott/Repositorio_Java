package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoLocadora extends Remote {

	public double consultarDebito(String nome) throws RemoteException;

	public boolean atualizarDebito(String nome, double novoDebito) throws RemoteException;

	public boolean adicionarCliente(String nome) throws RemoteException;

	public boolean excluirCliente(String nome) throws RemoteException;
}
