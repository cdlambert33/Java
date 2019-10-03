import java.util.*;

class MostPopularInt
{
  public static void main (String[] args)
  {
    //System.out.println("Hello");

    int array[] = {2, 1, 2, 3, 4, 2, 3, 1, 1, 1};
    int n = array.length;

    System.out.println(getElement(array, n));
  }

  static int getElement(int array[], int n)
  {
    Arrays.sort(array);

    int max_count = 1;
    int res = array[0];
    int current_count = 1;

    for (int i = 1; i < n; i++)
    {
      if (array[i] == array[i - 1])
      {
        current_count++;
      }
      else
      {
        if (current_count > max_count)
        {
          max_count = current_count;
          res = array[i - 1];
        }
        current_count = 1;
      }
    }

    if (current_count > max_count)
    {
      max_count = current_count;
      res = array[n - 1];
    }
    return res;
  }
}
