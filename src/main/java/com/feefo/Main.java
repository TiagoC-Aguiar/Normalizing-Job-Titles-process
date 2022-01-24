package com.feefo;

public class Main {
    public static void main(String[] args) {
        Normalizer normalizer = new Normalizer();
        String engineer = normalizer.normalize("Java engineer");
        String accountant = normalizer.normalize("Chief Accountant");
        String manager = normalizer.normalize("Manager");

        System.out.println("First Job: " + engineer);
        System.out.println("Second Job: " + accountant);
        System.out.println("Third Job: " + manager);
    }
}
