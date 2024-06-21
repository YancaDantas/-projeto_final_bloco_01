package controller;

import java.util.ArrayList;
import java.util.List;
import conta.model.Livros;
import conta.model.Obras;
import repository.LivroRepository;

public class livrariaController implements LivroRepository {
    private List<Livros> produtos;
    private List<Livros> carrinho;

    public livrariaController() {
        produtos = new ArrayList<>();
        carrinho = new ArrayList<>();
    }

    @Override
    public void cadastrarLivro(Livros livro) {
        produtos.add(livro);
        System.out.println("O livro foi cadastrado com sucesso!");
    }

    @Override
    public Livros buscarLivroPorNome(String nomeLivro) {
        for (Livros livro : produtos) {
            if (livro.getNomeLivro().equalsIgnoreCase(nomeLivro)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livros> buscarLivrosPorGenero(String genero) {
        List<Livros> livrosEncontrados = new ArrayList<>();
        for (Livros livro : produtos) {
            if (livro.getGeneroLivro().equalsIgnoreCase(genero)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    @Override
    public void adicionarNoCarrinho(Livros livro) {
        if (produtos.contains(livro)) {
            carrinho.add(livro);
            System.out.println("Livro adicionado ao carrinho!");
        } else {
            System.out.println("Livro não encontrado no catálogo!");
        }
    }

    @Override
    public void removerDoCarrinho(Livros livro) {
        if (carrinho.contains(livro)) {
            carrinho.remove(livro);
            System.out.println("Livro removido do carrinho!");
        } else {
            System.out.println("Livro não está no carrinho!");
        }
    }

    @Override
    public void listaLivros() {
        if (produtos.isEmpty()) {
            System.out.println("O catálogo está vazio.");
        } else {
            System.out.println("Catálogo de Livros:");
            for (Livros produto : produtos) {
                System.out.println(produto.getNomeLivro());
            }
        }
        System.out.println();
    }

    
}
