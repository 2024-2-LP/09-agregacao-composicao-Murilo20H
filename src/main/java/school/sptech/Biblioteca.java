package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        if (livro != null &&
                livro.getTitulo() != null && !livro.getTitulo().isBlank() &&
                livro.getAutor() != null && !livro.getAutor().isBlank() &&
                livro.getDataPublicacao() != null) {
            livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(i);
                return;
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        return null;
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> livrosAteAno = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosAteAno.add(livro);
            }
        }
        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        List<Livro> topCinco = new ArrayList<>();
        Double maiorMedia = -1.0;
        Livro maiorLivro = null;
        if (livros.isEmpty()) {
            return topCinco;
        }

        for (int i = 0; i < livros.size() && i != 5; i++) {
            for (Livro livro : livros) {
                if (livro.calcularMediaAvaliacoes() > maiorMedia && !topCinco.contains(livro)) {
                    maiorMedia = livro.calcularMediaAvaliacoes();
                    maiorLivro = livro;
                }
            }

            maiorMedia = -1.0;
            topCinco.add(maiorLivro);
        }
        return topCinco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
