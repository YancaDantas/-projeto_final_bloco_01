package livraria;

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
            System.out.println("|            6 - Sair                                 |");
            System.out.println("|_____________________________________________________|");
            System.out.println("Entre com a opção desejada:                          ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entre com um número do menu!");
                leia.nextLine();
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do livro:");
                    leia.nextLine(); 
                    String nome = leia.nextLine();
                    Livros livro = obras.buscarLivroPorNome(nome);
                    if (livro != null) {
                        System.out.println("Livro encontrado: " + livro.getNomeLivro());
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    keypress();
                    break;

                case 2:
                    System.out.println("Digite o gênero desejado: (Romance, Suspense, Infantil, Fantasia, Fábula, Terror...)");
                    leia.nextLine();
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
                    keypress();
                    break;


                case 3:
                    System.out.println("Digite o nome do livro para adicionar ao carrinho:");
                    leia.nextLine(); 
                    String nomeLivroAdicionar = leia.nextLine();
                    Livros livroParaAdicionar = obras.buscarLivroPorNome(nomeLivroAdicionar);
                    if (livroParaAdicionar != null) {
                        obras.adicionarNoCarrinho(livroParaAdicionar);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    keypress();
                    break;

                case 4:
                    System.out.println("Digite o nome do livro para remover do carrinho:");
                    leia.nextLine(); 
                    String nomeLivroRemover = leia.nextLine();
                    Livros livroParaRemover = obras.buscarLivroPorNome(nomeLivroRemover);
                    if (livroParaRemover != null) {
                        obras.removerDoCarrinho(livroParaRemover);
                    } else {
                        System.out.println("Livro não encontrado no carrinho!");
                    }
                    keypress();
                    break;

                case 5:
                    obras.listaLivros();
                    keypress();
                    break;

                case 6:
                    System.out.println("\nA Livraria BECO D agradece a sua preferência!");
                    sobre();
                    leia.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 5.");
                    break;
            }
        }
    }

    public static void keypress() {
        try {
            System.out.println("Pressione Enter para continuar..");
            System.in.read();
        } catch (Exception e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }

    private static void sobre() {
       
    }
}
