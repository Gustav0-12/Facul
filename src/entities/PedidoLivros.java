package entities;

public class PedidoLivros {
    private Integer quantidade;
    private ModeloLivro modeloLivro;

    public PedidoLivros(Integer quantidade, ModeloLivro modeloLivro) {
        this.quantidade = quantidade;
        this.modeloLivro = modeloLivro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ModeloLivro getModeloLivro() {
        return modeloLivro;
    }

    public void setModeloLivro(ModeloLivro modeloLivro) {
        this.modeloLivro = modeloLivro;
    }

    @Override
    public String toString() {
        return " \n Pedido: " +
                "Quantidade: " +
                quantidade +
                ", Modelo do livro: " +
                modeloLivro;
    }
}

