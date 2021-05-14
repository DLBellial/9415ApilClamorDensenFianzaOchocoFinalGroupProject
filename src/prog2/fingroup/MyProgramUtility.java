package prog2.fingroup;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * Format:  Firstname (String), Lastname (String), Email (String), Address (String), Age (Int), Resident (Boolean), District (Int), Gender (Char)
 */

/*
Processes:
1. Sort Age (May be used for curfew monitoring)
2. Sort Residents from non-Residents (Monitoring entry and security)
3. Sort Genders (May be used for Data collection)
4. Sort district locations (Monitoring areas of concern i.e. Districts that have cases and may be susceptible)
5. Sort Last Names Alphabetically (May be used when giving out vaccines orderly)
 */


public class MyProgramUtility {
    public static ArrayList<Citizen> Record() throws Exception{

        File file = new File("C:\\Users\\Admin\\Desktop\\9415ApilClamorDensenFianzaOchocoFinalGroupProject\\src\\prog2\\res\\data.csv");
        Scanner scan = new Scanner(file);
        FileReader fileReader = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

        //Number of lines dictate array size
        int lineNumber = 0;
        while (lineNumberReader.readLine() != null) {
            lineNumber++;
        }

        //Initializes the arrays with a dynamic size
        String[] array  =new String[lineNumber];
        String[] firstName = new String[lineNumber];
        String[] lastName = new String[lineNumber];
        String[] email = new String[lineNumber];
        String[] address = new String[lineNumber];
        Boolean[] resident = new Boolean[lineNumber];
        char[] gender = new char[lineNumber];
        int[] age = new int[lineNumber];
        int[] district = new int[lineNumber];
        int n = 0;

        //Populates the array
        for (int a = 0; scan.hasNextLine(); a++) {
            array[a] = scan.nextLine();
        }

        //Divides the elements separated by a comma into their designated arrays
        for (String course : array) {
            String[] temp = course.split(",");
            firstName[n] = temp[0];
            lastName[n] = temp[1];
            email[n] = temp[2];
            address[n] = temp[3];
            age[n] = Integer.parseInt(temp[4]);
            district[n] = Integer.parseInt(temp[6]);

            if(Objects.equals(temp[5], "Resident")){
                resident[n] = true;
            }else{
                resident[n] = false;
            }

            if (Objects.equals(temp[7], "Male")){
                gender[n] = 'M';
            }else{
                gender[n] = 'F';
            }
            n++;
        }

        /**
         * Format:  Firstname (String), Lastname (String), Email (String), Address (String), Age (Int), District (Int), Resident (Boolean), Gender (Char)
         */
        ArrayList<Citizen> record = new ArrayList<Citizen>();
        for (int a = 0; a < lineNumber; a++){
            record.add(new Citizen(firstName[a], lastName[a], email[a], address[a], age[a], resident[a], district[a], gender[a]));
        }
        return record;
    }

    /**
     * Sorts data based on Ages
     */
    public static void sortAge(ArrayList<Citizen> record){

    }

    /**
     * Sorts data based on Residency
     */
    public static void sortResidents(ArrayList<Citizen> record){

    }

    /**
     * Sorts data based on Genders
     */
    public static void sortGender(ArrayList<Citizen> record){

    }

    /**
     * Sorts data based on Districts
     */
    public static void sortDistrict(ArrayList<Citizen> record){

    }

    /**
     * Sorts data Alphabetically based on their Last names
     */
    public static void sortLastName(ArrayList<Citizen> record){
        try {
            /*
            Stream<Citizen> names = Record().stream().sorted();
            names.forEach(n -> System.out.println(n));
             */

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
