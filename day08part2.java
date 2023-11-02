import java.io.*;
import java.util.*;

public class day08part2{
    public static void main(String[] args){

        try {
            File input = new File("day08.txt");
            Scanner myReader = new Scanner(input);
            
            String[] line;
            String[] output;
            String[] patterns;
            Set<Character> auxset;
            int sum = 0;
            int count = 0;
            String curVal = "";

            //Parse input
            while(myReader.hasNextLine()){
                line = myReader.nextLine().split(" \\| ");
                patterns = line[0].trim().split(" ");
                output = line[1].trim().split(" ");
                HashMap<Integer, Set<Character>> sets = new HashMap<Integer, Set<Character>>();

                //Patterns
                Arrays.sort(patterns, Comparator.comparingInt(String::length));
                for (int i = 0; i < patterns.length; i++) {
                    auxset = new HashSet<Character>();
                    for(int j=0;j<patterns[i].length();j++){
                        auxset.add(patterns[i].charAt(j));
                    }
                    switch(auxset.size()){
                        case 2: 
                            sets.put(1, auxset);                        //Case 1
                            break;
                        case 3:
                            sets.put(7, auxset);                        //Case 7
                            break;
                        case 4:
                            sets.put(4, auxset);                        //Case 4
                            break;
                        case 5:
                            if(auxset.containsAll(sets.get(1))){
                                sets.put(3, auxset);
                                break;                                      //Case 3
                            }
                            count = 0;
                            for (Character character : sets.get(4)) {
                                if(auxset.contains(character)){
                                    count++;
                                }
                            }
                            if(count == 3){
                                sets.put(5, auxset);                    //Case 5
                            }else if(count == 2){
                                sets.put(2, auxset);                    //Case 2
                            }else{
                                System.out.println("Errore!");
                            } 
                            break;
                        case 6:
                            if(auxset.containsAll(sets.get(4))){
                                sets.put(9, auxset);
                                break;                                      //Case 9
                            }
                            if(auxset.containsAll(sets.get(7))){
                                sets.put(0, auxset);
                                break;                                      //Case 0
                            }else{
                                sets.put(6, auxset);
                                break;                                      //Case 6
                            }
                        case 7:
                            sets.put(8, auxset);                        //Case 8
                            break;
                    }

                }
                
                //Check output
                for (int k = 0; k < output.length; k++) {
                    auxset = new HashSet<Character>();
                    for(int j=0;j<output[k].length();j++){
                        auxset.add(output[k].charAt(j));
                    }
                    for (Map.Entry<Integer, Set<Character>> set: sets.entrySet()) {
                        if(set.getValue().equals(auxset)){
                            curVal+=set.getKey();
                        }
                    }
                }

                sum+=Integer.parseInt(curVal);
                curVal="";
            }

            System.out.println("Part 2: " + sum);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}