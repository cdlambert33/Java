import java.io.*;

public class ReadAndWriteBin3{

  public static void main(String[] args) {

    System.out.println("Hello");

    int [][] distanceMatrix = new int [4][4];
    String fileName = "outputMatrix.bin";

    for (int row = 0; row < 4; row++){
      System.out.println("");
      for (int column = 0; column < 4; column ++){
        int GenerateRandomDistance = (int)(Math.random() * 100 + 1);
        distanceMatrix[row][column] = GenerateRandomDistance;
        System.out.print( distanceMatrix[row][column]+ "   " );
      }
    }

		try (
				DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName));
				)
		{
			for(int rowIndex = 0; rowIndex<distanceMatrix.length; rowIndex++)
			{
				for(int columnIndex = 0; columnIndex < distanceMatrix[0].length; columnIndex++)
				{

					output.writeInt(distanceMatrix[rowIndex][columnIndex]);
				}
			}
		}
    catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    catch (IOException e) {
      System.out.println("Error initializing stream");
    }

      System.out.println("\n\n");

		try (
				DataInputStream input =
				new DataInputStream(new FileInputStream(fileName));
				) {
			for(int rowIndex = 0; rowIndex<distanceMatrix.length; rowIndex++)
			{
				for(int columnIndex = 0; columnIndex < distanceMatrix[0].length; columnIndex++)
				{
					distanceMatrix[rowIndex][columnIndex] = input.readInt();
					System.out.print(distanceMatrix[rowIndex][columnIndex] + ", ");
				}
			}
		}
    catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
    catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
}
