package ru.otus;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;


/**
 *
 * To start the application:
 * java -jar ./hw01-gradle/build/libs/hw01-gradle-0.1.jar
 *
 */
public class App {
    public static void main(String... args) {
        List<Integer> numbers = Lists.newArrayList(1, 6, 8, null, 7, 8, null, 7, null, 13);

        Iterable<Integer> onlyNumbers = Iterables.filter(numbers, Predicates.notNull());

        for (Integer i: onlyNumbers) {
            System.out.println(i);
        }
    }
}
