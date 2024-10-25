package aplicacao;

import entities.*;
import entities.enums.Formato;
import entities.enums.TipoCapa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<ModeloLivro> livrosList = new ArrayList<>();

        System.out.print("Digite o nome do usuario: ");
        String nome = sc.next();
        System.out.print("Digite o email: ");
        String email = sc.next();
        System.out.print("Digite o cpf: ");
        String cpf = sc.next();

        Usuario usuario = new Usuario(nome, email, cpf);

        livrosList.add(new LivroFisico(10, "O Senhor dos Anéis", "J.R.R. Tolkien",
                "Uma das maiores obras de fantasia de todos os tempos.", LocalDate.parse("29/07/1954", fmt), 1216, TipoCapa.CAPA_DURA));

        livrosList.add(new LivroFisico(7, "Dom Casmurro", "Machado de Assis",
                "Um clássico da literatura brasileira.", LocalDate.parse("30/08/1899", fmt), 256, TipoCapa.CAPA_DURA));

        livrosList.add(new LivroFisico(8, "1984", "George Orwell",
                "Uma distopia que reflete sobre o totalitarismo.", LocalDate.parse("08/06/1949", fmt), 328, TipoCapa.CAPA_DURA));

        livrosList.add(new LivroFisico(3, "O Hobbit", "J.R.R. Tolkien",
                "A jornada de Bilbo Bolseiro na Terra Média.", LocalDate.parse("21/09/1937", fmt), 300, TipoCapa.CAPA_MOLE));

        livrosList.add(new Ebook(5, "Harry Potter e a Pedra Filosofal", "J.K. Rowling",
                "O primeiro livro da série Harry Potter.", LocalDate.parse("26/06/1997", fmt), 5, Formato.PDF));

        livrosList.add(new Ebook(4, "Neuromancer", "William Gibson",
                "O livro que popularizou o cyberpunk.", LocalDate.parse("01/07/1984", fmt), 3, Formato.EPUB));

        livrosList.add(new Ebook(2, "A Revolução dos Bichos", "George Orwell",
                "Uma sátira sobre o totalitarismo e o poder.", LocalDate.parse("17/08/1945", fmt), 2, Formato.PDF));

        livrosList.add(new Ebook(1, "A Guerra dos Tronos", "George R.R. Martin",
                "O primeiro livro da saga As Crônicas de Gelo e Fogo.", LocalDate.parse("06/08/1996", fmt), 10, Formato.EPUB));

        try {
            while (true) {
                System.out.println("====== BIBLIOTECA ======");
                System.out.println("(1) Comprar Livros");
                System.out.println("(2) Remover Livros");
                System.out.println("(3) Livros Disponíveis");
                System.out.println("(4) Listar livros do usuário");
                System.out.println("(5) Informações do usuário");
                System.out.println("(0) Sair");
                int opcao = sc.nextInt();
                if (opcao == 0) {
                    break;
                }

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o ID do livro que deseja comprar: ");
                        int idLivro = sc.nextInt();

                        List<PedidoLivros> pedidos = usuario.getPedidoLivros().stream().filter(p -> p.getModeloLivro().getId() == (idLivro)).toList();

                        PedidoLivros pedido;
                        if (pedidos.isEmpty()) {
                            for(int i = 0; i < livrosList.size(); i++) {
                                if (livrosList.get(i).getId() == idLivro) {
                                    ModeloLivro livro = livrosList.get(i);
                                    pedido = new PedidoLivros(1, livro);
                                    usuario.addPedido(pedido);
                                }
                            }
                        } else {
                            pedido = pedidos.get(0);
                            pedido.setQuantidade(pedido.getQuantidade() + 1);
                        }
                        break;

                    case 2:
                        System.out.println("Digite o id do livro que deseja remover: ");
                        int id = sc.nextInt();
                        usuario.getPedidoLivros().removeIf(pedidoLivros -> pedidoLivros.getModeloLivro().getId() == (id));
                        break;

                    case 3:
                        Collections.sort(livrosList);
                        System.out.println(livrosList);
                        break;

                    case 4:
                        System.out.println(usuario.getPedidoLivros());
                        break;

                    case 5:
                        System.out.println(" Nome: " + usuario.getNome() + " \n Email: " + usuario.getEmail() + " \n CPF: " + usuario.getCpf());
                        break;
                }
            }
        } catch (InputMismatchException exception) {
            throw new RuntimeException("Digite uma opção valida");
        } finally {
            sc.close();
        }
        System.out.println("Saindo...");
    }
}

