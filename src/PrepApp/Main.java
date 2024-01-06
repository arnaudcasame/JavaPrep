package PrepApp;

import PrepApp.codingbat.FunctionalMapping.FunctionalMapping;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FunctionalMapping func = new FunctionalMapping();
        func.doubling(Arrays.asList(new Integer[]{1, 2, 3}));
    }
}