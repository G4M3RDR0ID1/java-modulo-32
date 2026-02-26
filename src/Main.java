import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static void main(String[] args) {

        List<Produto> produtos = List.of(
                new Produto("Teclado Mecânico", 150.0),
                new Produto("Mouse Gamer", 89.90),
                new Produto("Fone Bluetooth", 120.0),
                new Produto("Caixa de Som", 175.50),
                new Produto("Webcam HD", 130.0),
                new Produto("HD Externo 1TB", 199.90),
                new Produto("Pendrive 128GB", 59.90),
                new Produto("Suporte para Notebook", 70.0),
                new Produto("Controle Xbox", 180.0),
                new Produto("Carregador Portátil", 95.0)
        );

        //Crie uma lista contendo apenas os produtos com preço maior que 100 usando collect.
        List<Produto> produtosAcimaDeCem = produtos.stream()
                .filter(produto -> produto.getPreco() > 100)
                .toList();
        System.out.println(produtosAcimaDeCem);

        //Ordene a lista de produtos pelo nome em ordem alfabética.
        List<Produto> produtosOrdePorNome = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .toList();
        System.out.println(produtosOrdePorNome);


        //Realize uma busca usando Optional:
        //Busque um produto pelo nome usando Optional:
        Optional<Produto> produtoProcurado = produtos.stream().filter(produto -> produto.getNome().equals("HD Externo 1TB")).findFirst();
        //Se o produto existir, exiba o nome e preço.
        produtoProcurado.ifPresentOrElse(
                produto -> {
                    System.out.println("Nome do produto: " + produto.getNome());
                    System.out.println("Preco do produto: " + produto.getPreco());
                },
                //Se não existir, exiba uma mensagem: "Produto não encontrado."
                () -> System.out.println("Produto não encontrado.")
        );
    }

}