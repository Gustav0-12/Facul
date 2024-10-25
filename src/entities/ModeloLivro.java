package entities;

import java.time.LocalDate;

public abstract class ModeloLivro implements Comparable<ModeloLivro> {
    private Integer id;
    private String titulo;
    private String autor;
    private String descricao;
    private LocalDate publicacao;

    public ModeloLivro(Integer id, String titulo, String autor, String descricao, LocalDate publicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.publicacao = publicacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(LocalDate publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public int compareTo(ModeloLivro o1) {
        if (this.id < o1.getId()) {
            return -1;
        } else if (this.id > o1.getId()) {
            return 1;
        }
            return 0;
    }
}