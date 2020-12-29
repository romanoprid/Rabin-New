package ua.lviv.iot.manager;

import java.math.BigInteger;
import java.util.ArrayList;

public class RabinCarpManager {
  public static int checkSymbolBySymbol(String pattern, String text, int i) {
    int j = 0;
    for (j = 0; j < pattern.length(); j++) {
      if (pattern.charAt(j) != text.charAt(i + j)) {
        break;
      }
    }
    return j;
  }

  public static int ord(char c) {
    return (int) c;
  }


  public static ArrayList<String> rabinKarp(String text, String pattern, long radixD, int moduloPrime) {
    int n = text.length();
    int m = pattern.length();
    long patternHash = 0;
    long textHash = 0;
    ArrayList<String> coordinates = new ArrayList<>();
    for (int j = 0; j < m; j++) {
      patternHash = (radixD * patternHash + ord(pattern.charAt(j))) % moduloPrime;
      textHash = (radixD * textHash + ord(text.charAt(j))) % moduloPrime;
    }

    for (int i = 0; i < n - m + 1; i++) {
      if (patternHash == textHash) {
        int j = checkSymbolBySymbol(pattern, text, i);
        if (j == m) {
          coordinates.add("(" + i + "," + (i + m - 1) + ")");
        }
      }
      if (i < n - m) {
        long x = ord(text.charAt(i + m));
        long z = radixD * (textHash - ord(text.charAt(i)) * ((long) Math.pow(radixD, m - 1)) % moduloPrime);
        BigInteger bigInteger = new BigInteger(String.valueOf(z + x));
        long t1 = bigInteger.mod(new BigInteger(String.valueOf(moduloPrime))).longValue();
        textHash = t1;
      }

    }
    if(coordinates.isEmpty()){
      coordinates.add("");
    }
    return coordinates;
  }
}
