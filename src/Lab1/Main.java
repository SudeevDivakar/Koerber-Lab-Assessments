package Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Merchandise> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sudeev.divakar\\IdeaProjects\\Koerber_Lab_Assessments\\src\\Lab1\\file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                data.add(new Merchandise(words[0], Integer.parseInt(words[1]), Float.parseFloat(words[2])));
            }

            Collections.sort(data);

            for (Merchandise merch : data) {
                System.out.println(merch.toString());
            }
            System.out.println("******************** \n");

            Collections.sort(data, new BookSortByPrice());

            for (Merchandise merch : data) {
                System.out.println(merch.toString());
            }
//            data.get(0).toString();
        }
        catch (Exception ex) {
            System.out.println("Error While Trying to Open File");
        }
    }
}
