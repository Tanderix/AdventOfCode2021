import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class day03part2{
    public static void main(String[] args){
        int DIGITS = 12;
        try {
            //***************** Oxygen **************/

            char toKeep = '-';
            int result1;
            int result2;

            List<String> OXnumbers = new ArrayList<String>();
            List<String> CO2numbers = new ArrayList<String>();
            List<String> newnumbers = new ArrayList<String>();

            File input = new File("day03.txt");
            Scanner myReader = new Scanner(input);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                OXnumbers.add(data);
            }

            CO2numbers = new ArrayList<String>(OXnumbers);

            for(int i=0; i<DIGITS;i++){
                //Check the most common
                float bitcounter = 0.0f;
                for(int j=0; j<OXnumbers.size();j++){
                    if(Character.getNumericValue(OXnumbers.get(j).charAt(i)) == 1){
                        bitcounter++;
                    }
                }

                //Filter numbers
                float mean = (float) OXnumbers.size() / 2.0f;
                if(bitcounter >= mean){
                    toKeep = '1';
                }else{
                    toKeep = '0';
                }
                newnumbers.clear();
                for(int h=0; h<OXnumbers.size();h++){
                    if(OXnumbers.get(h).charAt(i) == toKeep){
                        newnumbers.add(OXnumbers.get(h));
                    }
                }
                OXnumbers = new ArrayList<>(newnumbers);

                if(CO2numbers.size() == 1){
                    break;
                }
            }
            
            myReader.close();
            result1 = Integer.parseInt(OXnumbers.get(0), 2);
            System.out.println("Oxygen: " + result1);
        
        //****************** C02 ************************/
            toKeep = '-';
            newnumbers = new ArrayList<String>();

            for(int i=0; i<DIGITS;i++){
                //Check the most common
                float bitcounter = 0.0f;
                for(int j=0; j<CO2numbers.size();j++){
                    if(Character.getNumericValue(CO2numbers.get(j).charAt(i)) == 1){
                        bitcounter++;
                    }
                }


                //Filter numbers
                float mean = (float) CO2numbers.size() / 2.0f;
                if(bitcounter >= mean){
                    toKeep = '0';
                }else{
                    toKeep = '1';
                }
                newnumbers.clear();
                for(int h=0; h<CO2numbers.size();h++){
                    if(CO2numbers.get(h).charAt(i) == toKeep){
                        newnumbers.add(CO2numbers.get(h));
                    }
                }
                CO2numbers = new ArrayList<>(newnumbers);

                if(CO2numbers.size() == 1){
                    break;
                }
            }
            
            result2 = result1 * Integer.parseInt(CO2numbers.get(0), 2);
            System.out.println("C02: " + Integer.parseInt(CO2numbers.get(0), 2));            
            System.out.println("Part 2: " + result2);
        
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}