import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day06part1{
    public static void main(String[] args){

        try {
            File input = new File("day06.txt");
            Scanner myReader = new Scanner(input);

            String[] line;
            List<Integer> fishes = new ArrayList<Integer>();
            int toAdd = 0;

            //Parse input
            while(myReader.hasNextLine()){
                line = myReader.nextLine().split(",");
                for(int i=0;i<line.length;i++){
                    fishes.add(Integer.parseInt(line[i]));
                }
            }

            System.out.print("Initial state: ");
            for(int k=0;k<fishes.size();k++){
                System.out.print(fishes.get(k));
                if(k<fishes.size()-1){
                    System.out.print(", ");
                }
            }
            System.out.println();

            //Days
            for(int i=0; i<81; i++){
                System.out.println("Day " + i + ": " + fishes.size());
                //Reduce timer
                for(int j=0; j<fishes.size();j++){
                    int fish = fishes.get(j);
                    if(fish-1 < 0){
                        fishes.set(j, 6);
                        toAdd++;
                    }else{
                        fishes.set(j, fish-1);
                    }
                }
                if(i>0){
                    for(int j=0; j<toAdd; j++){
                        fishes.add(8);
                    }
                    toAdd = 0;
                }
            }
        
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}