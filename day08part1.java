import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day08part1{
    public static void main(String[] args){

        try {
            File input = new File("day08.txt");
            Scanner myReader = new Scanner(input);
            
            String[] line;
            String[] output;
            int num = 0;

            //Parse input
            while(myReader.hasNextLine()){
                line = myReader.nextLine().split(" \\| ");
                output = line[1].trim().split(" ");

                for (int i = 0; i < output.length; i++) {
                    switch(output[i].length()){
                        case 2: num++; break;
                        case 3: num++; break;
                        case 4: num++; break;
                        case 7: num++; break;                        
                    }
                }
            }

            System.out.println("Part 1: " + num);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}