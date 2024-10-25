package entities;

import entities.enums.TipoCapa;
import java.util.Date;

public class LivroFisico extends ModeloLivro{
    private Integer numPaginas;
    private TipoCapa tipoCapa;

    public LivroFisico(Integer id, String titulo, String autor, String descricao, Date publicacao, Integer numPaginas, TipoCapa tipoCapa) {
        super(id, titulo, autor, descricao, publicacao);
        this.numPaginas = numPaginas;
        this.tipoCapa = tipoCapa;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public TipoCapa getTipoCapa() {
        return tipoCapa;
    }

    public void setTipoCapa(TipoCapa tipoCapa) {
        this.tipoCapa = tipoCapa;
    }

    @Override
    public String toString() {
        return  "\n " + "Livro Fisíco -> " +
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
                ", Num Páginas: " +
                numPaginas +
                ", Tipo da capa: " +
                tipoCapa +
                " \n ====================================================";

    }
}