package com.grigorovich.homeWork_4.Person_sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {
    static Set<String> nameSet = new HashSet<>();
    static Set<String> surnameSet = new HashSet<>();
    static List<Person> personList = new ArrayList<>();
    static Set<Person> personSet = new HashSet<>();
    static final String NAME_FILE = "D:\\IT_Academy_Projects\\HomeWorkItAcademy\\textFile\\name_file";
    static final String SURNAME_FILE = "D:\\IT_Academy_Projects\\HomeWorkItAcademy\\textFile\\surname_file";
    static final String SAVE_FILE = "D:\\IT_Academy_Projects\\HomeWorkItAcademy\\textFile\\save_file";
    static final int NUMBER_PERSON = 100;
    static List<String> nameList = new ArrayList<>();
    static List<String> surnameList = new ArrayList<>();
    static FileReader name_file;
    static FileReader surname_file;
    static File save_file;

    static {
        try {
            name_file = new FileReader(NAME_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            surname_file = new FileReader(SURNAME_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        save_file = new File(SAVE_FILE);
    }


}
