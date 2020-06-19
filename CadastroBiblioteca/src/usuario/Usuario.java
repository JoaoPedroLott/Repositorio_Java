package usuario;

import utilitarios.Console;

public class Usuario {
	public static void main(String[] args) {
		menu();
		System.out.println("\n Programa Finalizado. \n");
		System.exit(0);
	}
	
	// Metodo menu
	private static void menu() {
		int opcao = 0;

		do {
			System.out.println("\n Cadastro de uma biblioteca \n");
			System.out.println("1 - Cadastrar uma livro.");
			System.out.println("2 - Excluir uma livro.");
			System.out.println("3 - Pesquisar um livro pelo código.");
			System.out.println("4 - Pesquisar um livro pelo nome.");
			System.out.println("0 - Sair do programa.");
			opcao = Console.readInt("\n Escolha uma das opções acima:");

			switch (opcao) {
			case 0:
				// Parar Programa
				break;

			case 1:
				CadastrarLivro();
				break;

			case 2:
				RemoverLivro();
				break;

			case 3:
				PesquisaCodigo();
				break;

			case 4:
				PesquisaNome();
				break;
			}
		} while (opcao != 0);
	} 
	// Fim do metodo menu

	// Metodo para cadastrar um novo livro
	private static void CadastrarLivro() {
		System.out.println("\n Cadastrara um livro \n");
		
		// Receber e validar titulo do livro
		String titulo;
		while(true){
			titulo = Console.readLine("Informe o titulo do livro: ").trim();
			if (titulo.isEmpty()){
				System.out.println("\n Um titulo deve ser informado. \n");
				continue;
			}else break;
		}
		
		// Receber e validar autor do livro
		String autor;
		while(true){
			autor = Console.readLine("Informe o autor do livro: ").trim();
			if (autor.isEmpty()){
				System.out.println("\n Um autor deve ser informado. \n");
				continue;
			}else break;
		}
		
		// Não sei se precisa receber a Data e o codigo.
	}

	// Metodo para remover um livro
	private static void RemoverLivro() {
		System.out.println("\n Remover um livro \n");
		
		
	}

	private static void PesquisaCodigo() {
		System.out.println("\n Pesquisar um livro pelo codigo \n");
		
	}

	private static void PesquisaNome() {
		System.out.println("\n Pesquisar um livro pelo nome \n");
		
	}
	
	
	
}
