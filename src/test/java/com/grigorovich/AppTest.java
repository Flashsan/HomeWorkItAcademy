package com.grigorovich;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.grigorovich.homeWork_4.Person_sort.Operation;
import com.grigorovich.homeWork_4.Person_sort.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static Person person1 = new Person("Alexander", "Grigorovich", 22);
    private static Person person2 = new Person("Alexey", "Loxmatov", 21);
    private static Person person3 = new Person("Alexey", "Kuderko", 21);
    private static Person person4 = new Person("Alexander", "Grigorovich", 22);
    private static Person person5 = new Person("Alexey", "Loxmatov", 21);
    private static Person person6 = new Person("Alexey", "Kuderko", 21);
    private Operation operation;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void dropeEqualsPerson() {
        List<Person> listWithDoublePerson = List.of(person1, person2, person3, person4, person5, person6);
        Set<Person> personSet = new HashSet<>();
        List<Person> listWithoutDoublePerson = List.of(person1, person2, person3);
        assertEquals(listWithoutDoublePerson, operation.removeEqualsPerson(personSet,listWithDoublePerson));

    }
}
