import java.util.Scanner;
import java.util.zip.DataFormatException;

public class main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter full name:");

        String initials = scanner.nextLine();
        //String initials = "Меньков Александр Николаевич";

        try {
            String[] full_name = initials.split(" ");
            if (full_name.length != 3) throw new DataFormatException("Not 3 words");

            for (int i=0;i<full_name.length;i++){
                if (full_name[i].matches(".*\\d+.*")) throw new DataFormatException("Number in the name");
            }




            initials = full_name[0] + " " + full_name[1].substring(0, 1) + "." + full_name[2].substring(0, 1) + ".";

            String patronymic = full_name[2];
            patronymic = patronymic.substring(patronymic.length() - 2);
            String gender = "Undefined";

            if (patronymic.equals("на")) {
                gender = "Ж";
            } else if (patronymic.equals("ич")) {
                gender = "М";
            }


            System.out.println("Enter birth date (DAY.MONTH.YEAR):");

            String date = scanner.nextLine();
            String[] full_date = date.split("[,\\.\\/\\s]");
            if (full_date.length != 3) throw new DataFormatException("Not 3 numbers");

            for (int i=0;i<full_date.length; i++){
                if (Integer.parseInt(full_date[i])<0) throw new NumberFormatException("Date is less than 0");
            }

            int current_month = 11;
            int current_day = 23;
            int current_year = 2024;

            int day = Integer.parseInt(full_date[0]);
            int month = Integer.parseInt(full_date[1]);
            int year = Integer.parseInt(full_date[2]);

            if (day>31 || day<1) throw new NumberFormatException("Day is out of range");
            if (month>12 || month<1) throw new NumberFormatException("Month is out of range");
            if (year>current_year) throw new NumberFormatException("Year is greater than 2024");


            int age = current_year - year;

            if (Integer.parseInt(full_date[1]) > current_month) {
                age -= 1;

            } else if ((Integer.parseInt(full_date[0]) > current_day) && (Integer.parseInt(full_date[1]) == current_month)) {
                age -= 1;
            }

            String age_name = " лет";

            if (age % 10 == 1 && age != 11) {
                age_name = " год";
            } else if (age % 10 > 1 && age % 10 < 5 && (age > 15 || age < 10)) {
                age_name = " года";
            }

            System.out.println("Initials: " + initials);
            System.out.println("Gender: " + gender);
            System.out.println("Age: " + age + age_name);
        } catch (Exception e){
            System.out.println("Error occured!\n" +e);
        }

    }
}