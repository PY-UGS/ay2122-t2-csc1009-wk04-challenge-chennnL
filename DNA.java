import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author linweichen
 * 6/2/2022
 */

public class DNA {
    private static String data;
    private static int count;

    /* Checks if a string is empty ("") or null. */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /* Counts how many times the substring appears in the larger string. */
    public static int countMatches(String text, String str)
    {
        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }

        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }

        // indexOf method
//        int index = 0, count = 0;
//        while (true)
//        {
//            index = text.indexOf(str, index);
//            if (index != -1)
//            {
//                count ++;
//                index += str.length();
//            }
//            else {
//                break;
//            }
//        }
//
//        return count;

        Matcher matcher = Pattern.compile(str).matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }



    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\linwe\\OneDrive\\Desktop\\data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String str = "GTC";
        count = countMatches(data, str);
        System.out.println("Sequence " + str + " appeared " + count + " times ");
    }

}


