import java.util.*;

class RemoveDuplicateChar
{
  public static void main (String[] args)
  {
    char phrase[] = "hello".toCharArray();
    int n = phrase.length;
    System.out.println(removeDup(phrase, n));
  }

  static String removeDup(char phrase[], int n)
  {
    int index = 0;

    for (int i = 0; i < n; i++)
    {
      int j;
      for (j = 0; j < i; j++)
      {
        if (phrase[i] == phrase[j])
        {
          break;
        }
      }

      if (j == i)
      {
        phrase[index++] = phrase[i];
      }
    }
    return String.valueOf(Arrays.copyOf(phrase, index));
  }
}
