import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day06part1{
    public static void main(String[] args){

        try {
            File input = new File("day06.txt");
            Scanner myReader = new Scanner(input);

            String[] line;
            List<Long> fishes = new ArrayList<Long>();
            long aux = 0;

            //Parse input
            while(myReader.hasNextLine()){
                line = myReader.nextLine().split(",");
                for(int i=0;i<line.length;i++){
                    fishes.add(Long.parseLong(line[i]));
                }
            }

            System.out.print("Initial state: ");
            for(int k=0;k<fishes.size();k++){
                System.out.print(fishes.get(k));
                if(k<fishes.size()-1){
                    System.out.print(",");
                }
            }
            System.out.println();

            long[] digits = new long[11];
            //Fill initial state
            digits[10] = 0;
            for(int i=0;i<fishes.size();i++){
                digits[fishes.get(i).intValue()]++;
                digits[10]++;
            }

            for(int i=0; i<80; i++){
                aux = digits[0];
                for (int j = 0; j < 9; j++) {
                    digits[j] = digits[j+1];
                }

                digits[6]+=aux;
                digits[8]+=aux;
                digits[10]+=aux;

                System.out.println("Day " + (i+1) + ": " + digits[10]);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}