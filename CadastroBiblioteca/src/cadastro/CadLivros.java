package cadastro;

import java.util.ArrayList;
import dados.Livro;

public class CadLivros {

	ArrayList<String> lista = new ArrayList<String>();
	
	// Metodo para adicionar novo livro na lista
	public void AddLivro(Livro obj) {
		lista.add(obj.getTitulo());
	}
	
	// Metodo para remover um livro da lista
	public void RemoveLivro(Livro obj) {
		lista.remove(obj.getTitulo());
	}
	
	// Metodo para pesquisar um livro pelo codigo
	public ArrayList<Livro> ConsultaCodigo(int codigo) {
		ArrayList<Livro> codLivro = new ArrayList<Livro>();
		
		for(Livro obj : lista.values()){
			if(obj.getCodigo().contains(codigo)){
				codLivro.add(obj);
			}
		}
		if(codLivro.isEmpty()){
			System.out.println("Não existe livro para o código informado.");
		}
		
		return codLivro;
	}
	
	// Metodo para pesquisar um livro pelo nome
	public ArrayList<Livro> consultaNome (String nome) {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		for(Livro obj : lista.values()){
			if(obj.getTitulo().toUpperCase().contains(nome.toUpperCase())){
				livros.add(obj);
			}
		}
		if(livros.isEmpty()){
			 System.out.println("Não possue um livro com este título.");
		}
		return livros;
	}
}