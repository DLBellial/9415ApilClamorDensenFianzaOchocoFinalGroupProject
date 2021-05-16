package prog2.fingroup;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

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
        String[] array  = new String[lineNumber];
        String[] firstName = new String[lineNumber];
        String[] lastName = new String[lineNumber];
        String[] email = new String[lineNumber];
        String[] address = new String[lineNumber];
        Boolean[] resident = new Boolean[lineNumber];
        char[] gender = new char[lineNumber];
        int[] age = new int[lineNumber];
        int[] district = new int[lineNumber];

        /*
        array = Arrays.stream(array)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);


         */

        //Populates the array
        for (int a = 0; scan.hasNextLine() && scan.nextLine() != null; a++) {
            array[a] = scan.nextLine();
        }



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

        //For loop used to split the array elements separated by a comma
        for (int n = 0; n < lineNumber; n++){
            //Temporary array mainly used to contain the data to be split
            String temp = array[n];

            //System.out.println(regex);
            //System.out.println(temp);

            //Splits array data separated by commas ignoring cases where a comma is encapsulated within quotations marks
            String[] token = temp.split(regex, -1);

            //Assigns separated elements into temporary arrays that hold specific element characteristics
            firstName[n] = token[0];
            lastName[n] = token[1];
            email[n] = token[2];
            address[n] = token[3];
            age[n] = Integer.parseInt(token[4]);
            district[n] = Integer.parseInt(token[6]);

            //Simplifies if else (If temp is equal to Resident, returns true)
            resident[n] = Objects.equals(token[5], "Resident");
            //If Statement that handles gender char assignment by comparing to a String
            if (Objects.equals(token[7], "Male")) gender[n] = 'M';
            else gender[n] = 'F';
        }

        //Populates the ArrayList
        ArrayList<Citizen> record = new ArrayList<Citizen>();
        for (int a = 0; a < lineNumber; a++){
            //Adds array elements into Citizen ArrayList
            /*
            System.out.println("FN: "+firstName[a]);
            System.out.println("LN: " +lastName[a]);
            System.out.println( "EM: "+email[a]);
            System.out.println( "AD: "+address[a]);
            System.out.println( "AGE: "+age[a]);
            System.out.println( "RES: "+resident[a]);
            System.out.println( "DIS: "+district[a]);
            System.out.println("GEN: " +gender[a]);

             */
            record.add(new Citizen(firstName[a], lastName[a], email[a], address[a], age[a], resident[a], district[a], gender[a]));
        }



        //Test That Prints out Record Contents
        //Prints out record Just fine
        for(int j = 0; j < lineNumber; j++){
            System.out.println(record.get(j));
        }




        //Returns the populated Array
        return record;
    }

    /**
     * This method sorts the Arraylist by age in an
     * ascending order.
     *
     * @param record  The ArrayList to be sorted.
     * @return ArrayList sorted by ascending age.
     */
    public static ArrayList<Citizen> sortAge(ArrayList<Citizen> record){
        //Variable recordArray created to hold record data
        ArrayList<Citizen> recordArray = record;
        String[] temp = new String[7];
        char s;
        for (int a = 0; a < lineNumber; a++){
            for (int b = a + 1; b < lineNumber; b++){
                int p1 = recordArray.get(a).age;
                int p2 = recordArray.get(a+1).age;
                if (p1 > p2){
                    temp[0] = recordArray.get(a).firstName;
                    temp[1] = recordArray.get(a).lastName;
                    temp[2] = recordArray.get(a).email;
                    temp[3] = recordArray.get(a).address;
                    temp[4] = String.valueOf(recordArray.get(a).age);
                    temp[5] = String.valueOf(recordArray.get(a).resident);
                    temp[6] = String.valueOf(recordArray.get(a).district);
                    s = recordArray.get(a).gender;

                    recordArray.get(a).firstName = recordArray.get(a+1).firstName;
                    recordArray.get(a).lastName = recordArray.get(a+1).lastName;
                    recordArray.get(a).email = recordArray.get(a+1).email;
                    recordArray.get(a).address =recordArray.get(a+1).address;
                    recordArray.get(a).age = recordArray.get(a+1).age;
                    recordArray.get(a).resident = recordArray.get(a+1).resident;
                    recordArray.get(a).district = recordArray.get(a+1).district;
                    recordArray.get(a).gender = recordArray.get(a+1).gender;

                    recordArray.get(a+1).firstName = temp[0];
                    recordArray.get(a+1).lastName = temp[1];
                    recordArray.get(a+1).email = temp[2];
                    recordArray.get(a+1).address = temp[3];
                    recordArray.get(a+1).age = Integer.parseInt(temp[4]);
                    recordArray.get(a+1).resident = Boolean.parseBoolean(temp[5]);
                    recordArray.get(a+1).district = Integer.parseInt(temp[6]);
                    recordArray.get(a+1).gender = s;
                }
            }
        }
        return recordArray;
    }

    /**
     * This method sorts the ArrayList from citizens to
     * non-citizens.
     *
     * @param record The ArrayList to be sorted.
     * @return ArrayList sorted by residents and non-residents.
     */
    public static ArrayList<Citizen> sortResidents(ArrayList<Citizen> record){
        //Variable recordArray created to hold record data
        ArrayList<Citizen> recordArray = record;
        String[] temp = new String[7];
        char s;
        for (int a = 0; a < lineNumber; a++){
            for (int b = a + 1; b < lineNumber; b++){
                boolean p1 = recordArray.get(a).resident;
                boolean p2 = recordArray.get(a+1).resident;
                if (!p1 && p2){
                    temp[0] = recordArray.get(a).firstName;
                    temp[1] = recordArray.get(a).lastName;
                    temp[2] = recordArray.get(a).email;
                    temp[3] = recordArray.get(a).address;
                    temp[4] = String.valueOf(recordArray.get(a).age);
                    temp[5] = String.valueOf(recordArray.get(a).resident);
                    temp[6] = String.valueOf(recordArray.get(a).district);
                    s = recordArray.get(a).gender;

                    recordArray.get(a).firstName = recordArray.get(a+1).firstName;
                    recordArray.get(a).lastName = recordArray.get(a+1).lastName;
                    recordArray.get(a).email = recordArray.get(a+1).email;
                    recordArray.get(a).address =recordArray.get(a+1).address;
                    recordArray.get(a).age = recordArray.get(a+1).age;
                    recordArray.get(a).resident = recordArray.get(a+1).resident;
                    recordArray.get(a).district = recordArray.get(a+1).district;
                    recordArray.get(a).gender = recordArray.get(a+1).gender;

                    recordArray.get(a+1).firstName = temp[0];
                    recordArray.get(a+1).lastName = temp[1];
                    recordArray.get(a+1).email = temp[2];
                    recordArray.get(a+1).address = temp[3];
                    recordArray.get(a+1).age = Integer.parseInt(temp[4]);
                    recordArray.get(a+1).resident = Boolean.parseBoolean(temp[5]);
                    recordArray.get(a+1).district = Integer.parseInt(temp[6]);
                    recordArray.get(a+1).gender = s;
                }
            }
        }
        return recordArray;
    }

    /**
     * This method sorts the ArrayList by gender separating
     * male from female.
     *
     * @param record ArrayList to be sorted.
     * @return ArrayList sorted by gender.
     */
    public static ArrayList<Citizen> sortGender(ArrayList<Citizen> record){
        //Variable recordArray created to hold record data
        ArrayList<Citizen> recordArray = record;
        String[] temp = new String[7];
        char s;
        for (int a = 0; a < lineNumber; a++){
            for (int b = a + 1; b < lineNumber; b++){
                char p1 = recordArray.get(a).gender;
                char p2 = recordArray.get(a+1).gender;
                if (p1 == 'M' && p2 == 'F'){
                    temp[0] = recordArray.get(a).firstName;
                    temp[1] = recordArray.get(a).lastName;
                    temp[2] = recordArray.get(a).email;
                    temp[3] = recordArray.get(a).address;
                    temp[4] = String.valueOf(recordArray.get(a).age);
                    temp[5] = String.valueOf(recordArray.get(a).resident);
                    temp[6] = String.valueOf(recordArray.get(a).district);
                    s = recordArray.get(a).gender;

                    recordArray.get(a).firstName = recordArray.get(a+1).firstName;
                    recordArray.get(a).lastName = recordArray.get(a+1).lastName;
                    recordArray.get(a).email = recordArray.get(a+1).email;
                    recordArray.get(a).address =recordArray.get(a+1).address;
                    recordArray.get(a).age = recordArray.get(a+1).age;
                    recordArray.get(a).resident = recordArray.get(a+1).resident;
                    recordArray.get(a).district = recordArray.get(a+1).district;
                    recordArray.get(a).gender = recordArray.get(a+1).gender;

                    recordArray.get(a+1).firstName = temp[0];
                    recordArray.get(a+1).lastName = temp[1];
                    recordArray.get(a+1).email = temp[2];
                    recordArray.get(a+1).address = temp[3];
                    recordArray.get(a+1).age = Integer.parseInt(temp[4]);
                    recordArray.get(a+1).resident = Boolean.parseBoolean(temp[5]);
                    recordArray.get(a+1).district = Integer.parseInt(temp[6]);
                    recordArray.get(a+1).gender = s;
                }
            }
        }
        return recordArray;
    }

    /**
     * This method sorts the ArrayList by grouping
     * citizens based on their district.
     *
     * @param record ArrayList to be sorted.
     * @return ArrayList sorted by districts.
     */
    public static ArrayList<Citizen> sortDistrict(ArrayList<Citizen> record){
        //Variable recordArray created to hold record data
        ArrayList<Citizen> recordArray = record;

        String[] temp = new String[7];
        char s;
        for (int a = 0; a < lineNumber; a++){
            for (int b = a + 1; b < lineNumber; b++){
                int p1 = recordArray.get(a).district;
                int p2 = recordArray.get(a+1).district;
                if (p1 > p2){
                    temp[0] = recordArray.get(a).firstName;
                    temp[1] = recordArray.get(a).lastName;
                    temp[2] = recordArray.get(a).email;
                    temp[3] = recordArray.get(a).address;
                    temp[4] = String.valueOf(recordArray.get(a).age);
                    temp[5] = String.valueOf(recordArray.get(a).resident);
                    temp[6] = String.valueOf(recordArray.get(a).district);
                    s = recordArray.get(a).gender;

                    recordArray.get(a).firstName = recordArray.get(a+1).firstName;
                    recordArray.get(a).lastName = recordArray.get(a+1).lastName;
                    recordArray.get(a).email = recordArray.get(a+1).email;
                    recordArray.get(a).address =recordArray.get(a+1).address;
                    recordArray.get(a).age = recordArray.get(a+1).age;
                    recordArray.get(a).resident = recordArray.get(a+1).resident;
                    recordArray.get(a).district = recordArray.get(a+1).district;
                    recordArray.get(a).gender = recordArray.get(a+1).gender;

                    recordArray.get(a+1).firstName = temp[0];
                    recordArray.get(a+1).lastName = temp[1];
                    recordArray.get(a+1).email = temp[2];
                    recordArray.get(a+1).address = temp[3];
                    recordArray.get(a+1).age = Integer.parseInt(temp[4]);
                    recordArray.get(a+1).resident = Boolean.parseBoolean(temp[5]);
                    recordArray.get(a+1).district = Integer.parseInt(temp[6]);
                    recordArray.get(a+1).gender = s;
                }
            }
        }
        //Returns the sorted recordArray
        return recordArray;
    }

    /**
     * This method sorts the ArrayList alphabetically
     * based on the citizen's last name.
     *
     * @param record ArrayList to be sorted.
     * @return ArrayList sorted alphabetically by last name.
     */
    public static ArrayList<Citizen> sortLastName(ArrayList<Citizen> record){
        //Variable recordArray created to hold record data
        ArrayList<Citizen> recordArray = record;
        String[] temp = new String[7];
        char s;
        for (int a = 0; a < lineNumber; a++){
            for (int b = a + 1; b < lineNumber; b++){
                String p1 = recordArray.get(a).lastName;
                String p2 = recordArray.get(a+1).lastName;
                if (p1.compareTo(p2) > 0){
                    temp[0] = recordArray.get(a).firstName;
                    temp[1] = recordArray.get(a).lastName;
                    temp[2] = recordArray.get(a).email;
                    temp[3] = recordArray.get(a).address;
                    temp[4] = String.valueOf(recordArray.get(a).age);
                    temp[5] = String.valueOf(recordArray.get(a).resident);
                    temp[6] = String.valueOf(recordArray.get(a).district);
                    s = recordArray.get(a).gender;

                    recordArray.get(a).firstName = recordArray.get(a+1).firstName;
                    recordArray.get(a).lastName = recordArray.get(a+1).lastName;
                    recordArray.get(a).email = recordArray.get(a+1).email;
                    recordArray.get(a).address =recordArray.get(a+1).address;
                    recordArray.get(a).age = recordArray.get(a+1).age;
                    recordArray.get(a).resident = recordArray.get(a+1).resident;
                    recordArray.get(a).district = recordArray.get(a+1).district;
                    recordArray.get(a).gender = recordArray.get(a+1).gender;

                    recordArray.get(a+1).firstName = temp[0];
                    recordArray.get(a+1).lastName = temp[1];
                    recordArray.get(a+1).email = temp[2];
                    recordArray.get(a+1).address = temp[3];
                    recordArray.get(a+1).age = Integer.parseInt(temp[4]);
                    recordArray.get(a+1).resident = Boolean.parseBoolean(temp[5]);
                    recordArray.get(a+1).district = Integer.parseInt(temp[6]);
                    recordArray.get(a+1).gender = s;
                }
            }
        }
        //Returns the sorted recordArray
        return recordArray;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Citizen> displaySortedAges() throws Exception {
        return sortAge(Record());
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Citizen> displaySortedResidents() throws Exception {
        return sortResidents(Record());
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Citizen> displaySortedGenders() throws Exception {
        return sortGender(Record());
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Citizen> displaySortedDistricts() throws Exception {
        return sortDistrict(Record());
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static ArrayList<Citizen> displaySortedLastNames() throws Exception {
        return sortLastName(Record());
    }
}
