import java.io.*;

public class ReadWrite {

  public static void main(String[] args){

    String fileName = "output.bin";

    try{
    FileOutputStream fileOutput = new FileOutputStream(fileName);
    ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

    objectOutput.writeInt(2048);
    objectOutput.writeDouble(3.1415);
    objectOutput.close();

    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }
    catch (IOException e){
      e.printStackTrace();
    }
    System.out.println("Done writing! Now reading.");

    try{
    FileInputStream fileInput = new FileInputStream(fileName);
    ObjectInputStream objectInput = new ObjectInputStream(fileInput);
    int x = objectInput.readInt();
    System.out.println(x);
    double d = objectInput.readDouble();
    System.out.println(d);
    objectInput.close();

    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}
