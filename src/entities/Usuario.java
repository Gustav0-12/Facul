package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String cpf;

    List<PedidoLivros> pedidoLivros = new ArrayList<>();

    public Usuario(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<PedidoLivros> getPedidoLivros() {
        return pedidoLivros;
    }

    public void addPedido(PedidoLivros pedido) {
        pedidoLivros.add(pedido);
    }

    public void removerPedido(PedidoLivros pedido) {
        pedidoLivros.remove(pedido);
    }

    @Override
    public String toString() {
        return "Usuário -> " +
                "Nome: " +
                nome +
                ", Email: " +
                email +
                ", CPF: " +
                cpf +
                ", Itens: " +
                pedidoLivros;
    }
}

