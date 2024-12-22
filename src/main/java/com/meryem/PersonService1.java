package com.meryem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService1 {

    // Méthode pour trouver les personnes par adresse
    public static List<Person> findByLocation(String location) {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Meryem", "Benchelh", LocalDate.of(2003, 11, 12), "5 Rue Sanhaja"),
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida"),
            new Person("Douae", "Brada", LocalDate.of(2007, 11, 12), "15 Rue Saada")
        );
        Predicate<Person> hasLocation = person -> person.getAdresse().equals(location);
        return mockPersonsDatabase.stream()
                                  .filter(hasLocation)
                                  .collect(Collectors.toList());
    }

    // Méthode pour trouver les adultes
    public static List<Person> getAdults() {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Meryem", "Benchelh", LocalDate.of(2003, 11, 12), "5 Rue Sanhaja"),
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida"),
            new Person("Douae", "Brada", LocalDate.of(2007, 11, 12), "15 Rue Saada")
        );
        Predicate<Person> isAdult = person -> person.calculerAge() >= 18;
        return mockPersonsDatabase.stream()
                                  .filter(isAdult)
                                  .collect(Collectors.toList());
    }
}
