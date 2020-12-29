package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.manager.RabinCarpManager;
import ua.lviv.iot.manager.ReadWriteManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RabinCarpManagerTest {

  private Scanner scanner;


    public void initializeScanner() {
      try {
        scanner = new Scanner(new File("result.txt"));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }


    public void makeEvaluations(String filename) throws FileNotFoundException {
      try {
        ArrayList<String> res = ReadWriteManager.readFromFile(filename);
        try {
          String text = res.get(0);
          String pattern = res.get(1);
          ArrayList<String> result = RabinCarpManager.rabinKarp(text, pattern, 256, 1000007);
          ReadWriteManager.writeToFile("result.txt", result);
        } catch (Exception ex) {
          System.out.println("INCORRECT DATA");
        }


      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }

    }

  @Test
  void testNegative() throws FileNotFoundException {
   makeEvaluations("negative.txt");
   initializeScanner();
    List<String> expected = new ArrayList<>();
    expected.add("");
    for (String expectedLine : expected) {
      assertEquals(expectedLine, scanner.nextLine());
    }


  }



  @Test
  void testPositive() throws FileNotFoundException {
    makeEvaluations("rabin.txt");
    initializeScanner();
    List<String> expected = new ArrayList<>();
    expected.add("(0,3)");
    expected.add("(13,16)");
    for (String expectedLine : expected) {
      assertEquals(expectedLine, scanner.nextLine());
    }


  }
}