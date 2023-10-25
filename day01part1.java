import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day01{

    public static void main(String[] args){
        try {
            int old = -1;
            int counter = 0;
            File input = new File("day01.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                int data = myReader.nextInt();

                if(old != -1 && data > old){
                    counter++;
                }

                old = data;
            }
            System.out.println(counter);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}