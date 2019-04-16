import java.util.*;

public class TSPdistance {

	public static void main(String[] args) {

		int [][] DistanceMatrix = new int [4][4];

		for (int row = 0; row < 4; row++){
			System.out.println("");
			for (int column = 0; column < 4; column ++){
				int GenerateRandomDistance = (int)(Math.random() * 100 + 1);
				DistanceMatrix[row][column] = GenerateRandomDistance;
				System.out.print( DistanceMatrix[row][column]+ "   " );
			}
		}
int [] cityMatrix = {1, 2, 3, 4};

	System.out.println("\n");

	System.out.println("The random city path is ");

	shuffleArray(cityMatrix);
		 for (int i = 0; i < cityMatrix.length; i++){

			System.out.print(cityMatrix[i] + " ");
		 }

}

	private static void shuffleArray(int[] cityMatrix) {
			{
		    int index;
		    Random random = new Random();
		    for (int i = cityMatrix.length - 1; i > 0; i--)
		    {
		        index = random.nextInt(i + 1);
		        if (index != i)
		        {
		            cityMatrix[index] ^= cityMatrix[i];
		            cityMatrix[i] ^= cityMatrix[index];
		            cityMatrix[index] ^= cityMatrix[i];
		        }
		    }
		}
	}
}
