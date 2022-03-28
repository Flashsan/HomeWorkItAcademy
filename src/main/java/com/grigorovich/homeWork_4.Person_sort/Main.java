package com.grigorovich.homeWork_4.Person_sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


import static com.grigorovich.homeWork_4.Person_sort.Data.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Operation operation = new Operation();

        operation.readFromFile(name_file, nameSet);
        operation.readFromFile(surname_file, surnameSet);

        operation.copyFromSetColToListCol(nameSet, nameList);
        operation.copyFromSetColToListCol(surnameSet, surnameList);

        System.out.println("Generate persons:");
        operation.createPerson(personList, nameList, surnameList);

        System.out.println("Sort by age:");
        operation.showPersonSortByAgeRestriction(personList, AGE_RESTRICTION);

        System.out.println("Sort by surname, after by name:");
        personList.sort(Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
        operation.showInformationAboutPerson(personList);

        System.out.println("Drop equals person:");
        operation.removeEqualsPerson(personSet, personList);
        operation.showInformationAboutPerson(personSet);

        System.out.println("Save in file:");
        operation.writeToFile(personSet);

        System.out.println("Read from file:");
        operation.readFromFile();

        System.out.println("Collection with stream:");
        List<String> list = personList.stream().
                map(x -> x.getName() + " " + x.getSurname())
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);

        }
    }
}
