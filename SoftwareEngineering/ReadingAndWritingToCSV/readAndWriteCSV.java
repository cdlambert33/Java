import java.io.*;

public class readAndWriteCSV{

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

    try (PrintWriter writer = new PrintWriter(new File("writingMatrix.csv"))) {

      StringBuilder sb = new StringBuilder();

      for (int row = 0; row < 4; row++){
        for (int column = 0; column < 4; column ++){
          sb.append(DistanceMatrix[row][column]);
          sb.append(',');
        }
        sb.append('\n');
      }

      writer.write(sb.toString());

      System.out.println("Matrix printed to CSV!");
      System.out.println("");

    }
    catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    String csvFile = "C:/Users/Caston/Desktop/SoftwareEngineering2019/Team2/ReadingAndWritingToCSV/readingMatrix.csv";
    BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				String[] newMatrix = line.split(cvsSplitBy);

				for (int counter = 0; counter < newMatrix.length; counter++){
					System.out.print(newMatrix[counter] + ", ");
				}
			}
    }
    catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
  }
}
