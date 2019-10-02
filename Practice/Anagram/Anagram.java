import java.io.*;
import java.util.*;

class Anagram
{

  public static void main (String[] args)
  {
    char str1[] = { 'l', 'i', 's', 't', 'e', 'r'};
    char str2[] = { 's', 'i', 'l', 'e', 'n', 't'};

    if (areAnagram(str1, str2))
    {
      System.out.println("Is anagram");
    }
    else
    {
      System.out.println("Not anagram");
    }
  }

  static boolean areAnagram(char[] str1, char[] str2)
  {
    int n1 = str1.length;
    int n2 = str2.length;

    if (n1 != n2)
    {
      return false;
    }

    Arrays.sort(str1);
    Arrays.sort(str2);

    for (int i = 0; i < n1; i++)
    {
      if (str1[i] != str2[i])
      {
        return false;
      }
    }
    return true;
  }
  /*
    static boolean areAnagram(char[] string1, char[] string2)
    {
      int n1 = str1.length;
      int n2 = str2.length;

      if (n1 != n2)
      {
        return false;
      }

      Arrays.sort(str1);
      Arrays.sort(str2);

      for (int i = 0; i < n1; i++)
      {
        if (str1[i] != str2[i])
          return false;
      }
      return true;
    }

    public static void main(String args[])
    {
        //System.out.println("Hello, World");
        char str1[] = { 'l', 'i', 's', 't', 'e', 'n'};
        char str2[] = { 's', 'i', 'l', 'e', 'n', 't'};

        if (areAnagram(str1, str2))
        {
          System.out.println("This phrase is an anagram");
        }
        else
        {
          System.out.println("This isn't an anagram");
        }
    }
    */
}
