package com.meryem;

import org.junit.Test; // Import de JUnit 4
import static org.assertj.core.api.Assertions.assertThat; // Import de AssertJ
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;

public class PersonServiceTest1 {

    @Test
    public void testFindByLocation() {
        // Test de la méthode findByLocation
        List<Person> peopleLivingIn10RueBoujida = PersonService1.findByLocation("10 Rue Boujida");

        List<Person> expectedPersonsLivingIn10RueBoujida = Arrays.asList(
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida")
        );

        // Vérification avec AssertJ
        assertThat(peopleLivingIn10RueBoujida)
            .containsExactlyElementsOf(expectedPersonsLivingIn10RueBoujida);
    }

    @Test
    public void testGetAdults() {
        // Test de la méthode getAdults
        List<Person> adults = PersonService1.getAdults();

        List<Person> expectedAdultPersons = Arrays.asList(
            new Person("Meryem", "Benchelh", LocalDate.of(2003, 11, 12), "5 Rue Sanhaja"),
            new Person("Rania", "Kssim", LocalDate.of(2003, 9, 25), "10 Rue Boujida")
        );

        // Vérification avec AssertJ
        assertThat(adults).containsExactlyElementsOf(expectedAdultPersons);
    }
}