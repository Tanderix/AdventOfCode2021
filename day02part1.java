import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02part1{
    public static void main(String[] args){
        try {
            int x = 0;
            int y = 0;
            File input = new File("day02.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                String dir = data[0];
                int value = Integer.parseInt(data[1]);
                
                switch(dir){
                    case "forward": x = x + value; break;
                    case "down": y = y + value; break;
                    case "up": y = y - value; break;
                }
            }
            int result = x * y;
            System.out.println("Part 1: " + result);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}