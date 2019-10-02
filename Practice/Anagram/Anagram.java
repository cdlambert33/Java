import java.io.*;
import java.util.*;

class Anagram
{
    static boolean check(char[] string1, char[] string2)
    {
      int num1 = string1.length;
      int num2 = string2.length;

      if (num1 != num2)
      {
        return false;
      }

      Arrays.sort(string1);
      Arrays.sort(string2);

      for (int i = 0; i < num1; i++)
      {
        if (string1[i] != string2[i])
          return false;
      }
      return true;
    }

    public static void main(String args[])
    {
        //System.out.println("Hello, World");
        char string1[] = { 'l', 'i', 's', 't', 'e', 'r'};
        char string2[] = { 's', 'i', 'l', 'e', 'n', 't'};

        if (check(string1, string2))
        {
          System.out.println("This phrase is an anagram");
        }
        else
        {
          System.out.println("This phrase isn't an anagram");
        }
    }

}
