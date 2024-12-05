package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8)
        );

        bufferedReader.lines()
                .map(lines -> lines.toLowerCase())
                .filter(line -> !line.isEmpty())
                .flatMap(lines -> Stream.of(lines.split("[^a-zа-яё0-9]")))
                // собираем в мап, где ключ - слово, значение - сколько раз оно встретилось
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                // и превращаем в поток пар ключ-значение (слово - количество)
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .limit(10)
                .forEach(word -> System.out.print(word.getKey()));
    }

}
