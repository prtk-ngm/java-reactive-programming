package com.reactive.learning;

public class RemoveBackspace {

  public static void main(String[] args) {

    System.out.println(removeBackspace("letsp####abcdef#####fghjk"));

  }

  public static String removeBackspace(String s){
    int i = 0;
    int j = 0;
    char [] cArray = new char[s.length()];
    for(i=0; i < s.length() ; i++) {
      while (s.charAt(i) == '#' && j >= 0) {
        i++;
        j--;
      }
      cArray[++j] = s.charAt(i);
    }

    return String.valueOf(cArray);

  }

}
