package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {


        Iterator<? extends T> streamIterator = stream.iterator();
        if (streamIterator.hasNext()) {

            T max = streamIterator.next();
            T min = max;

            while (streamIterator.hasNext()) {
                T next = streamIterator.next();
                if (order.compare(next, max) > 0) max = next;
                else if (order.compare(next, min) < 0) min = next;
            }
            minMaxConsumer.accept(min, max);
        }
        else minMaxConsumer.accept(null, null);
    }
}
