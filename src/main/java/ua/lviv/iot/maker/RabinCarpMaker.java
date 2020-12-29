package ua.lviv.iot.maker;

import ua.lviv.iot.manager.RabinCarpManager;
import ua.lviv.iot.manager.ReadWriteManager;

import java.util.ArrayList;

public class RabinCarpMaker {

  public static void main(String[] args) {
    try {
      ArrayList<String> res = ReadWriteManager.readFromFile("negative.txt");
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


}

