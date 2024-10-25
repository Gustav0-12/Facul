package entities;

import entities.enums.Formato;
import java.util.Date;

public class Ebook extends ModeloLivro {
    private Integer tamanhoMB;
    private Formato formato;

    public Ebook(Integer id, String titulo, String autor, String descricao, Date publicacao, Integer tamanhoMB, Formato formato) {
        super(id, titulo, autor, descricao, publicacao);
        this.tamanhoMB = tamanhoMB;
        this.formato = formato;
    }

    public Integer getTamanhoMB() {
        return tamanhoMB;
    }

    public void setTamanhoMB(Integer tamanhoMB) {
        this.tamanhoMB = tamanhoMB;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "\n E-book -> " +
                "Id: " +
                getId() +
                ", Titulo: " +
                getTitulo() + "\n"+
                ", Autor: " +
                getAutor() + "\n" +
                ", Descrição: " +
                getDescricao() + "\n" +
                ", Publicado: " +
                getPublicacao() + "\n" +
                ", Tamanho do arquivo: " +
                tamanhoMB +
                ", Formato do arquivo: " +
                formato +
                " \n ====================================================";
    }
}