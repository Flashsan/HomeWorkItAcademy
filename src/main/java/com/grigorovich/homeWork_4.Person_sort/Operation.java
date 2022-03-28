package com.grigorovich.homeWork_4.Person_sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.grigorovich.homeWork_4.Person_sort.Data.*;

public class Operation {

    /**
     * This method read information from text file
     *
     * @param fileReader
     */
    public void readFromFile(FileReader fileReader,
                             Set<String> stringSet) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(fileReader)) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringSet.add(str);
            }
        } catch (
                IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * This method write to Person object to file
     *
     * @param personSet
     */
    public void writeToFile(Set<Person> personSet) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(SAVE_FILE));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Person person : personSet) {
                objectOutputStream.writeObject(person);
            }
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method copy information from collection to collection
     */
    public void copyFromSetColToListCol(Set<String> stringSet,
                                        List<String> stringList) {
        for (String str : stringSet) {
            stringList.add(str);
        }
    }

    /**
     * This method to generate number
     */
    public int generateAge() {
        Random random = new Random();
        return random.nextInt(16) + 15;
    }

    /**
     * This method create/generate person
     *
     * @param objectList
     * @param stringListName
     * @param stringListSurname
     */
    public void createPerson(List<Person> objectList,
                             List<String> stringListName,
                             List<String> stringListSurname) {
        for (int i = 0; i < NUMBER_PERSON; i++) {
            objectList.add(new Person(
                    stringListName.get(new Random().nextInt(stringListName.size())),
                    stringListSurname.get(new Random().nextInt(stringListSurname.size())),
                    generateAge()));
        }
    }

    /**
     * This method drop equal Person
     *
     * @param personSet
     * @param personList
     */
    public Set<Person> removeEqualsPerson(Set<Person> personSet, List<Person> personList) {
        for (Person person : personList) {
            personSet.add(person);
        }
        return personSet;
    }

    /**
     * This method show Person less AGE_RESTRICTION
     *
     * @param AGE_RESTRICTION
     */
    public void showPersonSortByAgeRestriction(List<Person> personList, int AGE_RESTRICTION) {
        for (Person person : personList.stream()
                .filter(i -> i.getAge() <= AGE_RESTRICTION).collect(Collectors.toList())) {
            System.out.println(person.toString());
        }
    }

    /**
     * This method show information about Object(Person)
     *
     * @param objectList
     */
    public void showInformationAboutPerson(Set<Person> objectList) {
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }

    /**
     * This method show information about Object(Person)
     *
     * @param objectList
     */
    public void showInformationAboutPerson(List<Person> objectList) {
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }


    /**
     * This method read Person object from file and return collection person object
     *
     * @return
     */
    public List<Person> readFromFile() {
        List<Person> personFromSaveFile = new ArrayList<>();
        try {
            File file = new File(SAVE_FILE);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (objectInputStream.available() != 0) {
                personFromSaveFile.add((Person) objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personFromSaveFile;
    }

}
