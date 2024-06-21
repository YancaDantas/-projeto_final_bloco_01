package conta.model;

public class Livros {
    private String nomeLivro;
    private String generoLivro;
    private String autorLivro;
    private String editor;
    private double valor;

    public Livros(String nomeLivro, String generoLivro, String autorLivro, String editor, double valor) {
        this.nomeLivro = nomeLivro;
        this.generoLivro = generoLivro;
        this.autorLivro = autorLivro;
        this.editor = editor;
        this.valor = valor;
    }

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getGeneroLivro() {
		return generoLivro;
	}

	public void setGeneroLivro(String generoLivro) {
		this.generoLivro = generoLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

  
}
