package com.TransactionAssistant.TransactionAssistant.concurrent;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;

import java.util.List;

public class ParrallelTest {

    public static List<String>toUpperCase(List<String>name){
        //List<String>names = List.of("Bob","Jamie","Jill","Rock");
       return name.stream().map(String::toUpperCase)
                .toList();
    }

    public static void usingParrallelStream(List<String>name){
        name.parallelStream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        List<String>names = List.of("Bob","Jamie","Jill","Rock");

        for (String s:names){
            System.out.println("Names List: "+s);
        }

        System.out.println(toUpperCase(List.of("Bob","Jamie","Jill","Rock")));
        usingParrallelStream(List.of("Bob","Jamie","Jill","Rock"));
    }
}
