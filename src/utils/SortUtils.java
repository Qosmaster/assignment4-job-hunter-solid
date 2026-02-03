package utils;

import model.Application;
import java.util.ArrayList;
import java.util.Comparator;

public class SortUtils {
    public static void sortById(ArrayList<Application> list) {
        list.sort((a1, a2) -> a1.getId() - a2.getId());
        System.out.println("Sorted by ID using Lambda.");
    }
}