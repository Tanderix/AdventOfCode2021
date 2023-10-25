import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02part2{
    public static void main(String[] args){
        try {
            int x = 0;
            int y = 0;
            int aim = 0;
            File input = new File("day02.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                String dir = data[0];
                int value = Integer.parseInt(data[1]);
                
                switch(dir){
                    case "forward": x = x + value; y = y + (aim * value); break;
                    case "down": aim = aim + value; break;
                    case "up": aim = aim - value; break;
                }
            }
            int result = x * y;
            System.out.println("Part 2: " + result);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}