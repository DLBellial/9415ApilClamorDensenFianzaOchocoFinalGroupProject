package prog2.fingroup;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


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

/**
 * This is the method where the ArrayList<Citizen> is populated with the data from
 * the CSV file.
 */
public class MyProgramUtility {
    public static int lineNumber = 0;
    public static ArrayList<Citizen> Record() throws Exception{
        //Reads the file
        File file = new File("C:\\Users\\Admin\\Desktop\\9415ApilClamorDensenFianzaOchocoFinalGroupProject\\src\\prog2\\res\\data.csv");
        Scanner scan = new Scanner(file);

        //Mainly used to read the Number of lines in the file
        FileReader fileReader = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

        //Number of lines dictate array size
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

        //Populates the array
        for (int a = 0; scan.hasNextLine(); a++) {
            array[a] = scan.nextLine();
        }

        //Source: https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes?noredirect=1&lq=1
        String otherThanQuote = " [^\"] ";
        String quotedString = String.format(" \" %s* \" ", otherThanQuote);
        String regex = String.format("(?x) "+ // enable comments, ignore white spaces
                        ",                         "+ // match a comma
                        "(?=                       "+ // start positive look ahead
                        "  (?:                     "+ // start non-capturing group 1
                        "    %s*                   "+ // match 'otherThanQuote' zero or more times
                        "    %s                    "+ // match 'quotedString'
                        "  )*                      "+ // end group 1 and repeat it zero or more times
                        "  %s*                     "+ // match 'otherThanQuote'
                        "  $                       "+ // match the end of the string
                        ")                         ", // stop positive look ahead
                otherThanQuote, quotedString, otherThanQuote);

        for (int n = 0; n < lineNumber; n++){

            String temp = array[n];
            String[] token = temp.split(regex, -1);

            firstName[n] = token[0];
            lastName[n] = token[1];
            email[n] = token[2];
            address[n] = token[3];
            age[n] = Integer.parseInt(token[4]);
            district[n] = Integer.parseInt(token[6]);

            //Simplifies if else (If temp is equal to Resident, returns true)
            resident[n] = Objects.equals(token[5], "Resident");
            if (Objects.equals(token[7], "Male")) gender[n] = 'M';
            else gender[n] = 'F';
        }


        //Populates the ArrayList
        ArrayList<Citizen> record = new ArrayList<Citizen>();
        for (int a = 0; a < lineNumber; a++){
            record.add(new Citizen(firstName[a], lastName[a], email[a], address[a], age[a], resident[a], district[a], gender[a]));
        }

        System.out.println(record.get(0));
        //Returns the populated Array
        return record;
    }







    public static String displaySortedAges() throws Exception {
        return sortAge(Record());
    }
    public static String displaySortedResidents() throws Exception {
        return sortResidents(Record());
    }
    public static String displaySortedGenders() throws Exception {
        return sortGender(Record());
    }
    public static String displaySortedDistricts() throws Exception {
        return sortDistrict(Record());
    }
    public static String displaySortedLastNames() throws Exception {
        return sortLastName(Record());
    }







    public static String sortAge(ArrayList<Citizen> record){
        String[] sortedArray = new String[lineNumber];
        //To be filled
        return String.valueOf(sortedArray);
    }

    public static String sortResidents(ArrayList<Citizen> record){
        String[] sortedArray = new String[lineNumber];
        //To be filled
        return String.valueOf(sortedArray);
    }

    public static String sortGender(ArrayList<Citizen> record){
        String[] sortedArray = new String[lineNumber];
        //To be filled
        return String.valueOf(sortedArray);
    }

    public static String sortDistrict(ArrayList<Citizen> record){
        String[] sortedArray = new String[lineNumber];
        //To be filled
        return String.valueOf(sortedArray);
    }

    public static String sortLastName(ArrayList<Citizen> record){
        String[] sortedArray = new String[lineNumber];
        //To be filled
        return String.valueOf(sortedArray);

        //Stream<Citizen> names = Record().stream().sorted();
        //names.forEach(n -> System.out.println(n));
    }
}
