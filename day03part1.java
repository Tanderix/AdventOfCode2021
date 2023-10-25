import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day03part1{
    public static void main(String[] args){
        try {
            String gamma = "";
            String epsilon = "";
            int[] bitcounter = new int[12];
            int count = 0;
            File input = new File("day03.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for(int i=0; i<12; i++){
                    if(Character.getNumericValue(data.charAt(i)) == 1){
                        bitcounter[i] = bitcounter[i] + 1;
                    }
                }
                count++;
            }
            for(int i=0; i<12; i++){
                if(bitcounter[i] > (count / 2)){
                    gamma = gamma + "1";
                    epsilon = epsilon + "0";
                }else{
                    gamma = gamma + "0";
                    epsilon = epsilon + "1"; 
                }
            }
            int result = Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
            System.out.println("Part 1: " + result);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}