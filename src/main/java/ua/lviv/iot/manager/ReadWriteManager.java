package ua.lviv.iot.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriteManager {


  public static ArrayList<String> readFromFile(String fileName) throws FileNotFoundException {
    ArrayList<String> res = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(fileName))) {

      String input = scanner.nextLine();
      res.add(input);
      input = scanner.nextLine();
      res.add(input);
      return res;
    } catch (FileNotFoundException e) {
      System.out.println("File not found!!!");
    }
    return null;
  }

  public static void writeToFile(String fileName, ArrayList<String> list) {

    try {
      FileWriter fileWriter = new FileWriter("result.txt");
      for (String s : list) {
        fileWriter.write(s + "\n");
      }
      fileWriter.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }


}
