import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day01part2{

    public static void main(String[] args){
        try {
            int[] measurements = new int[10000];
            int old = Integer.MAX_VALUE;
            int sum = 0;
            int counter = 0;
            int itemcount = 0;
            File input = new File("day01.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                measurements[itemcount] = Integer.parseInt(data[0]);
                itemcount++;
            }
            for(int i=0; i<itemcount-2; i++){
                sum = measurements[i] + measurements[i+1] + measurements[i+2];
                if(sum>old){
                    counter++;
                }
                old = sum;
            }

            System.out.println("Part 2: " + counter);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}