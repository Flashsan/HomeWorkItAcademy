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

        operation.createPerson(personList, nameList, surnameList);
        operation.showInformationAboutPerson(personList);

        System.out.println("_____________________________________");
        personList.sort(Comparator.comparing(Person::getSurname).thenComparing(Person::getName));

        operation.showInformationAboutPerson(personList);

        System.out.println("__________________");

        //  personList = operation.readFromFile();

        List<String> list = personList.stream().
                map(x -> x.getName() + " " + x.getSurname())
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);

        }
    }
}
