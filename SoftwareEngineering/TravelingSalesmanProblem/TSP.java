import java.util.*;
import java.io.*;
import java.time.*;
import java.util.concurrent.TimeUnit;
import static java.time.temporal.ChronoUnit.SECONDS;

public class TSP {

	public static void main(String[] args) {

		int cityCount = 600;
		int[][] distanceMatrix = new int [cityCount][cityCount];
		int[] pathArray = new int[cityCount];
		int[] bestPathArray = new int[cityCount];
		int currentPathDistance = 0;
		int bestDistance = Integer.MAX_VALUE;
		long time = 0;
		long end = 0;

		time = System.currentTimeMillis();
		end = time + 3000;
		//end = time+300000;

		readMatrixFromBin(distanceMatrix);

		System.out.println("Hello, welcome to the TSP!");
		System.out.println("");

		for(int passIndex = 1; passIndex < 1000000; passIndex++){
      resetPathArray(pathArray);
      pathArrayGenerator(pathArray);
      currentPathDistance = getPathDistance(pathArray, distanceMatrix);
			if(System.currentTimeMillis() > end){
				break;
			}
			else{
				if(currentPathDistance < bestDistance){
        	bestDistance = currentPathDistance;
        	storeBestPathArray(pathArray, bestPathArray);
        	printPathArray(pathArray);
        	System.out.println("\n\nPath Distance is " + currentPathDistance + "\n");
				}
      }
    }
    System.out.println("Best distance: " + bestDistance);
    System.out.print("Best path: ");
    printPathArray(bestPathArray);
		System.out.println("\n");
    System.out.println("Thanks for playing!");
  }

  private static void storeBestPathArray(int[] pathArray, int[] bestPathArray){
    for(int i = 0; i < pathArray.length; i++){
      bestPathArray[i] = pathArray[i];
    }
  }

  private static int getPathDistance(int[] pathArray, int[][] distanceMatrix){
    int currentDistance;
    int totalDistance = 0;
    int toCity;
    int fromCity;
    for(int i = 0; i < pathArray.length-1; i++){
      fromCity = pathArray[i];
      toCity = pathArray[i + 1];
      currentDistance = distanceMatrix[fromCity-1][toCity-1];
      totalDistance += currentDistance;
    }
    fromCity = pathArray[pathArray.length-1];
    toCity = pathArray[0];
    currentDistance = distanceMatrix[fromCity-1][toCity-1];
    totalDistance += currentDistance;
    return totalDistance;
  }

/*
  //Generates Random Numbers in the range 1 -100 to fill distance matrix
  private static void fillDistanceMatrix(int[][] distanceMatrix){
    for(int row = 0; row < distanceMatrix.length; row++) {
      System.out.println("");
      for(int column = 0; column < distanceMatrix[0].length; column++){
        int generateCity = (int)(Math.random()*100 + 1);
        distanceMatrix[row][column] = generateCity;
      }
    }
  }
*/
  private static int findCityNotInArray(int[] pathArray){
    boolean goodNextCity = false;
    int possibleNextCity = 0;
    while(!goodNextCity){
      possibleNextCity = (int)(Math.random() * pathArray.length + 1);
      goodNextCity = true;
      for(int i = 0; i < pathArray.length; i++){
        if(possibleNextCity != pathArray[i]){}
          else{
            goodNextCity = false;
          }
        }
      }
      return possibleNextCity;
    }

    private static void pathArrayGenerator(int[] pathArray){
      int nextCity;
      for(int i = 0; i < pathArray.length; i++){
        nextCity = findCityNotInArray(pathArray);
        pathArray[i] = nextCity;
      }
    }

    private static void printPathArray(int[] pathArray){
      System.out.print("Path: [");
      for(int i = 0; i < pathArray.length-1; i++){
        System.out.print(pathArray[i] + ", ");
      }
      System.out.print(pathArray[pathArray.length-1] + "] ");
    }

    private static void resetPathArray(int[] pathArray){
      for(int i = 0; i < pathArray.length; i++){
        pathArray[i] = 0;
      }
    }

		private static void readMatrixFromBin(int[][] distanceMatrix){

			String fileName = "matrix0600x0600.bin";

			try (
					DataInputStream input =
					new DataInputStream(new FileInputStream(fileName));
					) {
				for(int rowIndex = 0; rowIndex < distanceMatrix.length; rowIndex++)
				{
					for(int columnIndex = 0; columnIndex < distanceMatrix[0].length; columnIndex++)
					{
						distanceMatrix[rowIndex][columnIndex] = input.read();
						//distanceMatrix[rowIndex][columnIndex] = input.readInt();
						//System.out.print(distanceMatrix[rowIndex][columnIndex] + ", ");
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
