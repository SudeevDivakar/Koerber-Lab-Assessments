package Lab2.streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);

        System.out.println("Printing the map");
        map.forEach((key, value) -> {
            System.out.println(new StringBuilder()
                    .append(key).append(" : ").append(value).toString());
        });
        System.out.println("***********************\n");

        System.out.println("Printing only records that contain key Raj");
        map.entrySet().stream()
                .filter(e -> e.getKey() == "raj")
                .forEach(System.out::println);
        System.out.println("***********************\n");

        System.out.println("Print map sorted by key");
        map.entrySet().stream()
                .sorted(Comparator.comparing((e1) -> e1.getKey()))
                .forEach(System.out::println);
        System.out.println("***********************\n");

        System.out.println("Print map sorted by values");
        map.entrySet().stream()
                .sorted(Comparator.comparing((e1) -> e1.getValue()))
                .forEach(System.out::println);
        System.out.println("***********************\n");

        System.out.println("Print map reverse sorted by key");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(System.out::println);
        System.out.println("***********************\n");

        Map<Student, Integer> map2=new HashMap<>();
        map2.put(new Student(109, "raj", 95), 95);
        map2.put(new Student(61, "keta", 78), 78);
        map2.put(new Student(11, "gunika", 98), 98);
        map2.put(new Student(19, "keshav", 97), 97);

        System.out.println("Records sorted by student name:");
        map2.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getName()))
                .forEach(System.out::println);
        System.out.println("***********************\n");

        System.out.println("Print all records as per id of the student");
        map2.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getId()))
                .forEach(System.out::println);
        System.out.println("***********************\n");
    }
}
