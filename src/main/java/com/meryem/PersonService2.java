
package com.meryem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService2 {

    // Nouvelle méthode pour filtrer les adultes
    public static List<Person> getAdultsOver21() {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Meryem", "Benchelh", LocalDate.of(2003, 11, 12), "5 Rue Sanhaja"),
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida"),
            new Person("Douae", "Brada", LocalDate.of(2007, 11, 12), "15 Rue Saada")
        );
        Predicate<Person> isAdult = person -> person.calculerAge() >= 21;
        return mockPersonsDatabase.stream()
                                  .filter(isAdult)
                                  .collect(Collectors.toList());
    }
}
