import java.io.*;

public class ReadAndWriteBin{

  public static void main(String[] args) {

    int [][] distanceMatrix = new int [4][4];
    //int [][] readableMatrix;

    System.out.println("Hello world!");

    for (int row = 0; row < 4; row++){
      System.out.println("");
      for (int column = 0; column < 4; column ++){
        int GenerateRandomDistance = (int)(Math.random() * 100 + 1);
        distanceMatrix[row][column] = GenerateRandomDistance;
        System.out.print( distanceMatrix[row][column]+ "   " );
      }
    }

    System.out.println("\n");

    String fileName = "outputMatrix.bin";


    /*
    try{
      FileOutputStream fileOutput = new FileOutputStream(fileName);
      ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

      objectOutput.writeObject(distanceMatrix);
      objectOutput.close();
      System.out.println("Done writing. Now reading.\n");
      /*
      FileInputStream fileInput = new FileInputStream(new File("outputMatrix.bin"));
      ObjectInputStream objectInput = new ObjectInputStream(fileInput);
      Object x = objectInput.readObject();
      System.out.println(x);
      objectInput.close();
      */

      try{
        DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName));

        for(int rowIndex = 0; rowIndex < distanceMatrix.length; rowIndex++){
          for(int columnIndex = 0; columnIndex < distanceMatrix[0].length; columnIndex++){
            output.writeInt(distanceMatrix[rowIndex][columnIndex]);
          }
        }
        System.out.println("Done writing. Now reading.\n");
/*
        DataInputStream input = new DataInputStream(new FileInputStream(fileName));

        for(int rowIndex = 0; rowIndex < distanceMatrix.length; rowIndex++){
          for(int columnIndex = 0; columnIndex < distanceMatrix[0].length; columnIndex++){
            distanceMatrix[rowIndex][columnIndex] = input.readInt();
            System.out.println(input.readInt());
            System.out.println(distanceMatrix);
          }
        }
        */
      }
      //readableMatrix = objectInput.readObject();
      //System.out.println("" + objectInput.readObject());



    catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
    catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    /*
    catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    */
    try{
      DataInputStream input = new DataInputStream(new FileInputStream(fileName));

      for(int rowIndex = 0; rowIndex < distanceMatrix.length; rowIndex++){
        for(int columnIndex = 0; columnIndex < distanceMatrix[0].length; columnIndex++){
          distanceMatrix[rowIndex][columnIndex] = input.readInt();
          System.out.println(input.readInt());
          //System.out.println(distanceMatrix);
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
