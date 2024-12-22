package com.meryem;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.function.Predicate;  // Ajout de l'import de Predicate
import java.util.stream.Collectors;  // Ajout de l'import de Collectors

public class PersonServiceTest2 {

    // Nouvelle méthode pour filtrer les personnes par adresse dans le test
    public static List<Person> findPeopleAtAddress(String adresse) {
        List<Person> mockPersonsDatabase = Arrays.asList(
            new Person("Meryem", "Benchelh", LocalDate.of(2003, 11, 12), "5 Rue Sanhaja"),
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida"),
            new Person("Douae", "Brada", LocalDate.of(2007, 11, 12), "15 Rue Saada")
        );
        // Correction de l'import de Predicate et du code associé
        Predicate<Person> hasAdresse = person -> person.getAdresse().equals(adresse);
        return mockPersonsDatabase.stream()
                                  .filter(hasAdresse)
                                  .collect(Collectors.toList());
    }

    @Test
    public void testFindPeopleAtAddress() {
        List<Person> peopleAt10RueBoujida = findPeopleAtAddress("10 Rue Boujida");
        List<Person> expectedPeopleAt10RueBoujida = Arrays.asList(
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida")
        );
        assertThat(peopleAt10RueBoujida).containsExactlyElementsOf(expectedPeopleAt10RueBoujida);
    }

    @Test
    public void testGetAdultsOver21() {
        List<Person> adultsOver21 = PersonService2.getAdultsOver21();
        List<Person> expectedAdultPersons = Arrays.asList();
        assertThat(adultsOver21).containsExactlyElementsOf(expectedAdultPersons);
    }
}
