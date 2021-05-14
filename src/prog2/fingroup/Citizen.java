package prog2.fingroup;

import java.lang.Comparable;

/**
 * Format: Firstname,Lastname,Email,Address,Age,Resident,District,Gender
 */

class Citizen implements Comparable<Citizen> {
    String firstName = "";
    String lastName = "";
    String email = "";
    String address = "";
    int age = 0;
    boolean resident = true;
    int district;
    char gender = 'z';

        public Citizen(){
            firstName = " ";
            email = " ";
            address = " ";
            age = 0;
            resident = false;
            district = 0;
            gender = ' ';
        }

        public Citizen(String firstName, String lastName, String email, String address, int age, boolean resident, int district, char gender){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.address = address;
            this.age = age;
            this.district = district;
            this.resident = resident;
            this.gender = gender;
        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return firstName;
    }

    public void setLastNameName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Format: Firstname,Lastname,Email,Address,Age,Resident,District,Gender
     */

    public String toString(){
            String result = " ";
            result = firstName + "," + lastName + "," + email + "," +  address + "," +  age + "," +  resident + "," +  district + "," +  gender;
            return result;
    }

    @Override
    public int compareTo(Citizen o) {
        if(age == o.age){
            return 0;
        }else if(age > o.age){
            return 1;
        }
        return -1;
    }
}
