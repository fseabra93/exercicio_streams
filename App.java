import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws Exception {

        List<Integer> inteiros = new ArrayList<>();
        inteiros.add(0);
        inteiros.add(1);
        inteiros.add(2);
        inteiros.add(3);
        inteiros.add(4);
        inteiros.add(5);
        inteiros.add(6);

        List<String> frases = new ArrayList<>();
        frases.add("They don't know that we know they know we know");

        //////////////////////////////////////////////////////////////////

        List<Integer> lista_pares = inteiros.stream()
                .filter((Integer num) -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Imprimindo números pares usando filter:" + lista_pares);

        ///////////////////////////////////////////////////////////////////////////////

        List<Integer> lista_quadrados = inteiros.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println("Imprimindo quadrados dos números usando map:" + lista_quadrados);

        ///////////////////////////////////////////////////////////////////////////////

        List<String> palavras = frases.stream()
                .flatMap((String frase) -> Arrays.stream(frase.split(" ")))
                .collect(Collectors.toList());

        System.out.println("Imprimindo palavras da array frases usando flatmap:" + palavras);

        /////////////////////////////////////////////////////////////////////////////////

        List<String> palavras_unicas = palavras.stream()
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(
                "Imprimindo palavras únicas da array palavras (derivada de frases) usando distinct:" + palavras_unicas);

        /////////////////////////////////////////////////////////////////////////////////

        List<String> palavras_unicas_ordenada = palavras_unicas.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(
                "Imprimindo array palavras (derivada de frases) ordenada usando sorted:" + palavras_unicas_ordenada);

        /////////////////////////////////////////////////////////////////////////////////

        List<String> palavras_limit = palavras.stream()
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Imprimindo as primeiras 2 palavras do array palavras usando limit:" + palavras_limit);

        /////////////////////////////////////////////////////////////////////////////////

        List<String> palavras_skip = palavras.stream()
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("Imprimindo as outras palavras do array palavras em maiúsculo usando skip:" + palavras_skip);

        /////////////////////////////////////////////////////////////////////////////////

        int soma = inteiros.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Imprimindo a soma dos valores da array inteiros usando reduce: soma=" + soma);

        /////////////////////////////////////////////////////////////////////////////////

        boolean maior_que_5 = inteiros.stream()
                .anyMatch((Integer num) -> {
                    return num > 5;
                });

        System.out.println(
                "Imprimindo se foi encontrado algum valor maior que 5 no array usando anyMatch: " + maior_que_5);

        /////////////////////////////////////////////////////////////////////////////////

        boolean maiores_que_5 = inteiros.stream()
                .allMatch((Integer num) -> {
                    return num > 5;
                });

        System.out
                .println("Imprimindo se todos os valores são maiores que 5 no array usando allMatch: " + maiores_que_5);

        /////////////////////////////////////////////////////////////////////////////////

        boolean maiores_que_7 = inteiros.stream()
                .noneMatch((Integer num) -> {
                    return num > 5;
                });

        System.out
                .println("Imprimindo se não tem nenhum valor maior que 7 no array usando noneMatch: " + maiores_que_7);

        /////////////////////////////////////////////////////////////////////////////////

        long quantidade = inteiros.stream()
                .count();

        System.out.println("Imprimindo quantos elementos tem no array inteiros usando count: " + quantidade);

        /////////////////////////////////////////////////////////////////////////////////

        Optional<Integer> menor = inteiros.stream()
                .min((Integer n1, Integer n2) -> {
                    return n1.compareTo(n2);
                });

        System.out.println("Imprimindo o menor elemento do array inteiros usando min: " + menor);

        /////////////////////////////////////////////////////////////////////////////////

        Optional<Integer> maior = inteiros.stream()
                .max((Integer n1, Integer n2) -> {
                    return n1.compareTo(n2);
                });

        System.out.println("Imprimindo o maio elemento do array inteiros usando max: " + maior);

        /////////////////////////////////////////////////////////////////////////////////

        int primeiro = inteiros.stream()
                .findFirst().get();

        System.out.println("Imprimindo o primeiro elemento do array inteiros usando findFirst: " + primeiro);

        /////////////////////////////////////////////////////////////////////////////////

        int qualquer = inteiros.stream()
                .findAny().get();

        System.out.println("Imprimindo um elemento qualquer do array inteiros usando findAny: " + qualquer);

    }
}
