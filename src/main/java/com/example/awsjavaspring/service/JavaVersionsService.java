package com.example.awsjavaspring.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class JavaVersionsService {

    public String executeVersion8() throws ScriptException {
        /*1. Lambda Expressions
            Permite escrever funções anônimas de maneira concisa.
            Facilita a programação funcional no Java.*/
        List<String> names = Arrays.asList("John", "Jane", "Jack");
        names.forEach(name -> System.out.println(name));

        /*2. Streams API
            Fornece uma maneira funcional de processar sequências de elementos.
            Permite operações como map, filter, reduce, collect, etc.*/
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());

        /*3. Default Methods
            Permite adicionar métodos com implementação em interfaces.
            Facilita a evolução das interfaces sem quebrar as implementações existentes.*/
        interface MyInterface {
            void existingMethod();

            default void newDefaultMethod() {
                System.out.println("This is a default method");
            }
        }

        /*4. New Date and Time API
            Introdução do pacote java.time para substituir as antigas classes Date e Calendar.
            Baseado na biblioteca Joda-Time.
            Imutável e thread-safe.*/
        LocalDate date = LocalDate.now();
        LocalDate birthdate = LocalDate.of(1990, Month.JANUARY, 1);
        Period age = Period.between(birthdate, date);

        /*5. Optional
            Classe Optional para evitar NullPointerException.
            Representa um valor que pode ou não estar presente.*/
        Optional<String> optionalName = Optional.of("John");
        optionalName.ifPresent(System.out::println);

        /*6. Nashorn JavaScript Engine
            Novo motor JavaScript chamado Nashorn.
            Permite executar código JavaScript a partir de Java.*/
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.eval("print('Hello from JavaScript');");

        /*7. Parallel Array Sorting
            Método Arrays.parallelSort para ordenação paralela de arrays.*/
        int[] numbers = {5, 3, 1, 4, 2};
        Arrays.parallelSort(numbers);

        /*8. Type Annotations
            Permite anotações em qualquer lugar onde um tipo é usado.*/
        //@NonNull String str;

        /*9. Metaspace
            Substituição do PermGen (Permanent Generation) por Metaspace.
            Melhoria na gestão de memória para as informações de classe e métodos.*/

        /*10. Base64 Encoding and Decoding
            Utilitários para codificação e decodificação Base64 em java.util.Base64.*/
        String encoded = Base64.getEncoder().encodeToString("Hello, World!".getBytes());
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);

        /*11. CompletableFuture and New Concurrency APIs
            CompletableFuture para programação assíncrona e reativa.
            Métodos como thenApply, thenAccept, thenCompose, etc.*/
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(str -> str + " World")
                .thenAccept(System.out::println);

        /*12. PermGen Removal
            A PermGen foi removida e substituída por Metaspace, melhorando a gestão de memória da JVM.
         */

        return null;
    }

    public String executeVersion9() {
        /*1. Java Platform Module System (Project Jigsaw):
            Introduziu o sistema de módulos, permitindo que o JDK e bibliotecas de terceiros fossem divididos em módulos.
            Melhor organização e encapsulamento de código.
        module com.example.myapp {
            requires java.base;
        }*/

        /*2. JShell:
            Ferramenta de REPL (Read-Eval-Print Loop) para interagir com o Java de maneira interativa.*/
        /*3. Collections Factory Methods:
            Métodos de fábrica para coleções imutáveis: List.of(), Set.of(), Map.of().*/
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("a", "b", "c");
        Map<String, Integer> map = Map.of("key1", 1, "key2", 2);

        /*4. Interface Private Methods:
            Suporte para métodos privados dentro de interfaces.
         */
        interface MyInterface {
            private void privateMethod() {
                System.out.println("This is a private method");
            }

            default void callPrivateMethod() {
                privateMethod();
            }
        }

        return null;
    }

    public String executeVersion10() {
        /*1. Local-Variable Type Inference:
            Introdução da palavra-chave var para inferência de tipo em variáveis locais.*/
        var list = List.of("one", "two", "three");
        for (var item : list) {
            System.out.println(item);
        }

        /*2. Garbage Collector (GC) Improvements:
            Implementação do Garbage Collector Experimental (ZGC).*/

        /*3. Application Class-Data Sharing (AppCDS):
            Melhoria no tempo de inicialização de aplicativos através do compartilhamento de dados de classe.*/

        var url = new ChannelService();


        return null;
    }

    public String executeVersion11() throws IOException, InterruptedException {
        /*1. LTS (Long-Term Support):
            Primeira versão LTS desde o Java 8.*/

        /*2. Novas APIs para Strings:
            Métodos como isBlank(), lines(), strip(), repeat().*/
        String str = " ";
        System.out.println(str.isBlank()); // true

        String multilineStr = "Line1\nLine2\nLine3";
        multilineStr.lines().forEach(System.out::println);

        String text = "   text   ";
        System.out.println(text.strip()); // "text"

        String repeated = "abc".repeat(3); // "abcabcabc"

        /*3. HTTP Client API:
            Nova API para HTTP/2 e WebSocket.*/
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        /*4. Remoção de APIs e Recursos:
            Remoção do Java EE e CORBA do JDK.*/

        return null;
    }

    public String executeVersion12() {
        /*1. Switch Expressions (Preview):
            Novas expressões switch que podem retornar valores.*/
        int day = 3;
        String dayName = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            default -> "Invalid day";
        };
        System.out.println(dayName); // Tuesday

        /*2. Default CDS Archives:
            Melhorias no tempo de inicialização através de CDS (Class Data Sharing) por padrão.*/

        return null;
    }

    public String executeVersion13() {
        /*1. Text Blocks (Preview):
            Strings multilinha com sintaxe simplificada usando três aspas (""").*/
        String textBlock = """
        This is a text block
        that spans multiple lines
        """;
        System.out.println(textBlock);

        /*2. Switch Expressions (Second Preview):
            Melhorias nas expressões switch baseadas no feedback da primeira prévia.*/
        return null;
    }

    public String executeVersion14() {
        /*1. Pattern Matching for instanceof (Preview):
            Simplificação do uso de instanceof com correspondência de padrões.*/
        Object obj = "Hello, Java 14";
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());
        }

        /*2. Records (Preview):
            Nova sintaxe para declarar classes imutáveis concisas.*/
        record Point(int x, int y) {}
        Point point = new Point(1, 2);
        System.out.println(point.x()); // 1
        System.out.println(point.y()); // 2

        /*3. Helpful NullPointerExceptions:
            Mensagens de erro mais detalhadas para NullPointerException.*/
        String str = null;
        str.length(); // Will throw a NullPointerException with more detail

        return null;
    }

    public String executeVersion15() {
        /*1. Text Blocks:
            Torna os Text Blocks um recurso permanente.*/
        String textBlock = """
        This is a text block
        that spans multiple lines
        """;
        System.out.println(textBlock);

        /*2. Hidden Classes:
            Classes que são usadas por frameworks e não estão disponíveis diretamente para bytecode.*/
        return null;
    }

    public String executeVersion16() {
        /*1. Records:
            Torna os Records um recurso permanente.*/
        record Point(int x, int y) {}
        Point point = new Point(1, 2);
        System.out.println(point.x()); // 1
        System.out.println(point.y()); // 2

        /*2. Pattern Matching for instanceof:
            Torna a correspondência de padrões para instanceof um recurso permanente.*/
        Object obj = "Hello, Java 16";
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());
        }

        /*3. Sealed Classes (Preview):
            Classes que restringem quais outras classes podem estendê-las.*/
        return null;
    }

    public String executeVersion17() {
        /*1. LTS (Long-Term Support):
            Segunda versão LTS após o Java 11.*/
        /*2. Sealed Classes:
            Torna as Sealed Classes um recurso permanente.
        sealed interface Shape permits Circle, Rectangle {}

        final class Circle implements Shape {
            double radius;
        }

        final class Rectangle implements Shape {
            double length, width;
        }*/

        /*3. Foreign Function & Memory API (Preview):
            Permite que o Java interaja com código e dados fora do runtime do Java de maneira segura.*/
        return null;
    }

    public String executeVersion18() {
        /*
        UTF-8 by Default:
            UTF-8 se torna a charset padrão para APIs de Java.
        // UTF-8 is the default charset for string operations
String content = Files.readString(Path.of("example.txt")); // Assumes UTF-8

        Simple Web Server (Preview):
            Um servidor web básico útil para testes e desenvolvimento.
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
server.createContext("/test", (exchange -> {
    String response = "This is the response";
    exchange.sendResponseHeaders(200, response.getBytes().length);
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
}));
server.setExecutor(null); // creates a default executor
server.start();

         */
        return null;
    }

    public String executeVersion19() {
        /*
        Virtual Threads (Preview):
            Threads leves para melhorar a escalabilidade de aplicações.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> {
        System.out.println("Hello, Virtual Threads");
    });
}

        Structured Concurrency (Incubator):
            Simplificação de tarefas concorrentes com escopos estruturados.
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<String> task1 = scope.fork(() -> "Result of Task 1");
    Future<String> task2 = scope.fork(() -> "Result of Task 2");

    scope.join();  // Wait for all tasks to complete
    scope.throwIfFailed();

    String result1 = task1.resultNow();
    String result2 = task2.resultNow();

    System.out.println(result1);
    System.out.println(result2);
}

         */
        return null;
    }

    public String executeVersion20() {
        /*
        Scoped Values (Incubator):
            Alternativa mais eficiente e segura para variáveis ThreadLocal.
        public class ScopedValuesExample {
    private static final ScopedValue<String> USER_ID = ScopedValue.newInstance();

    public static void main(String[] args) {
        try (var scope = ScopedValue.where(USER_ID, "12345")) {
            new Thread(() -> System.out.println(USER_ID.get())).start(); // 12345
        }
    }
}

        Pattern Matching for Switch (Third Preview):
            Continuação da evolução da correspondência de padrões para switch.
        Object obj = 123;
String result = switch (obj) {
    case Integer i -> "Integer: " + i;
    case String s -> "String: " + s;
    default -> "Unknown type";
};
System.out.println(result); // Integer: 123

         */
        return null;
    }

    public String executeVersion21() {
        /*
        1.LTS (Long-Term Support):
            Terceira versão LTS após o Java 17.
        2.Virtual Threads:
            Torna os Virtual Threads um recurso permanente.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> {
        System.out.println("Hello, Virtual Threads");
    });
}

        3.String Templates (Preview):
            Permite embutir expressões em strings de forma segura e eficiente.
        String name = "Java";
String message = STR."Hello, \{name}!";
System.out.println(message); // Hello, Java!

        4.Sequenced Collections:
            Novas interfaces para coleções sequenciadas como listas e filas.
        SequencedSet<String> sequencedSet = SequencedSet.of("a", "b", "c");
sequencedSet.addFirst("first");
sequencedSet.addLast("last");
System.out.println(sequencedSet); // [first, a, b, c, last]

        */

        return null;
    }

}
