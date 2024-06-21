package repository;

import java.util.List;

import conta.model.Livros;

public interface LivroRepository {
    void cadastrarLivro(Livros livro);
    Livros buscarLivroPorNome(String nomeLivro);
    List<Livros> buscarLivrosPorGenero(String genero);
    void adicionarNoCarrinho(Livros livro);
    void removerDoCarrinho(Livros livro);
    void listaLivros();
}
