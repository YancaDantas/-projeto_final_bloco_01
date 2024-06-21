ppackage livraria;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.livrariaController;
import conta.model.Livros;
import conta.model.Obras;

public class Menu {

    public static void main(String[] args) {

        livrariaController obras = new livrariaController();

        obras.cadastrarLivro(new Obras("Harry Potter", "Fantasia", "J.K. Rowling", "Rocco", 55.0));
        obras.cadastrarLivro(new Obras("Dom Casmurro", "Romance", "Machado de Assis", "Martin Claret", 30.0));
        obras.cadastrarLivro(new Obras("O Senhor dos Anéis", "Fantasia", "J.R.R. Tolkien", "Martins Fontes", 80.0));
        obras.cadastrarLivro(new Obras("1984", "Ficção Científica", "George Orwell", "Companhia das Letras", 45.0));
        obras.cadastrarLivro(new Obras("Orgulho e Preconceito", "Romance", "Jane Austen", "Martin Claret", 25.0));
        obras.cadastrarLivro(new Obras("A Revolução dos Bichos", "Fábula", "George Orwell", "Companhia das Letras", 35.0));
        obras.cadastrarLivro(new Obras("O Pequeno Príncipe", "Infantil", "Antoine de Saint-Exupéry", "Geração Editorial", 20.0));
        obras.cadastrarLivro(new Obras("A Culpa é das Estrelas", "Romance", "John Green", "Intrínseca", 40.0));
        obras.cadastrarLivro(new Obras("As Crônicas de Nárnia", "Fantasia", "C.S. Lewis", "WMF Martins Fontes", 60.0));
        obras.cadastrarLivro(new Obras("A Menina que Roubava Livros", "Drama", "Markus Zusak", "Intrínseca", 38.0));
        obras.cadastrarLivro(new Obras("O Iluminado", "Terror", "Stephen King", "Suma de Letras", 42.0));
        obras.cadastrarLivro(new Obras("It: A Coisa", "Terror", "Stephen King", "Suma de Letras", 55.0));

        Scanner leia = new Scanner(System.in);
        int opcao;

        while (true) {
            exibirMenu();

            try {
                opcao = leia.nextInt();
                leia.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Entre com um número do menu!");
                leia.nextLine(); 
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    consultarLivroPorNome(obras, leia);
                    keypress();
                    break;

                case 2:
                    consultarLivrosPorGenero(obras, leia);
                    keypress();
                    break;

                case 3:
                    adicionarLivroNoCarrinho(obras, leia);
                    keypress();
                    break;

                case 4:
                    removerLivroDoCarrinho(obras, leia);
                    keypress();
                    break;

                case 5:
                    obras.listaLivros();
                    keypress();
                    break;

                case 6:
                    cadastrarNovoLivro(obras, leia);
                    keypress();
                    break;

                case 7:
                    System.out.println("\nA Livraria BECO D agradece a sua preferência!");
                    leia.close(); 
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 7.");
                    break;
            }
        }
    }

    public static void exibirMenu() {
        System.out.println(" _____________________________________________________");
        System.out.println("|                                                     |");
        System.out.println("|                   LIVRARIA BECO D                   |");
        System.out.println("|_____________________________________________________|");
        System.out.println("|                                                     |");
        System.out.println("|            1 - Consultar Livro por Nome             |");
        System.out.println("|            2 - Consultar Livro por Gênero           |");
        System.out.println("|            3 - Adicionar livro no Carrinho          |");
        System.out.println("|            4 - Remover livro no Carrinho            |");
        System.out.println("|            5 - Listar Livros                        |");
        System.out.println("|            6 - Cadastrar novo livro                 |");
        System.out.println("|            7 - Sair                                 |");
        System.out.println("|_____________________________________________________|");
        System.out.println("Entre com a opção desejada:                          ");
    }

    public static void consultarLivroPorNome(livrariaController obras, Scanner leia) {
        System.out.println("Digite o nome do livro:");
        String nome = leia.nextLine();
        Livros livro = obras.buscarLivroPorNome(nome);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro.getNomeLivro());
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void consultarLivrosPorGenero(livrariaController obras, Scanner leia) {
        System.out.println("Digite o gênero desejado: (Romance, Suspense, Infantil, Fantasia, Fábula, Terror...)");
        String genero = leia.nextLine();
        var livrosPorGenero = obras.buscarLivrosPorGenero(genero);
        if (!livrosPorGenero.isEmpty()) {
            System.out.println("Livros encontrados no gênero '" + genero + "':");
            for (Livros l : livrosPorGenero) {
                System.out.println("- " + l.getNomeLivro());
            }
        } else {
            System.out.println("Nenhum livro encontrado no gênero '" + genero + "'.");
        }
    }

    public static void adicionarLivroNoCarrinho(livrariaController obras, Scanner leia) {
        System.out.println("Digite o nome do livro para adicionar ao carrinho:");
        String nomeLivroAdicionar = leia.nextLine();
        Livros livroParaAdicionar = obras.buscarLivroPorNome(nomeLivroAdicionar);
        if (livroParaAdicionar != null) {
            obras.adicionarNoCarrinho(livroParaAdicionar);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void removerLivroDoCarrinho(livrariaController obras, Scanner leia) {
        System.out.println("Digite o nome do livro para remover do carrinho:");
        String nomeLivroRemover = leia.nextLine();
        Livros livroParaRemover = obras.buscarLivroPorNome(nomeLivroRemover);
        if (livroParaRemover != null) {
            obras.removerDoCarrinho(livroParaRemover);
        } else {
            System.out.println("Livro não encontrado no carrinho!");
        }
    }

    public static void cadastrarNovoLivro(livrariaController obras, Scanner leia) {
        System.out.println("Cadastro de Novo Livro:");
        System.out.println("Digite o nome do livro:");
        String nomeLivro = leia.nextLine();
        System.out.println("Digite o gênero do livro:");
        String generoLivro = leia.nextLine();
        System.out.println("Digite o nome do autor do livro:");
        String autorLivro = leia.nextLine();
        System.out.println("Digite o nome da editora do livro:");
        String editor = leia.nextLine();
        System.out.println("Digite o valor do livro:");
        double valor = leia.nextDouble();
        leia.nextLine(); 

        obras.cadastrarLivro(new Obras(nomeLivro, generoLivro, autorLivro, editor, valor));
    }

    public static void keypress() {
        try {
            System.out.println("Pressione Enter para continuar..");
            System.in.read();
        } catch (Exception e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
}
    }
}
