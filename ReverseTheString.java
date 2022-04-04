import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Reverse the string program reads a user text file that has the
 * strings in it and then uses a recursive function to reverse the
 * strings and then display the reverse to an output text file.
 *
 * @author Ketia Gaelle Kaze
 * @version 1.0
 * @since 2022-03-29
 */

class ReverseTheString {
    /**
     * Creating a private constructor due to
     * public/default constructor error.
     *
     * @throws IllegalStateException
     *
     */

    private ReverseTheString() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Reads text file.
     *
     * @param value passed in
     * @return reversed strings
     */

    public static String reverse(String value) {
        String val = value;
        if (!"".equals(val)) {
            val = reverse(value.substring(0 + 1)) + value.substring(0, 1);
        }
        return val;
    }

    /**
     * Main entry to reverse the string program.
     *
     * @param args nothing passed in
     *
     * @throws IOException if an issue occurs
     */

    public static void main(String[]args) throws IOException {
        // declaring variables
        List<String> listOfStrings = new ArrayList<String>();
        String[] stringsArray;
        String[] reversedStringsArray;
        List<String> reversedStrings = new ArrayList<String>();
        BufferedWriter writer;
        String string2;

        // Read input from their text files into a list
        try {
            listOfStrings = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // Transfer the string to array from their list to an array.
        stringsArray = listOfStrings.toArray(new String[0]);
        try {
            // call function
            for (int counter1 = 0; counter1 < stringsArray.length; counter1++) {
                string2 = reverse(stringsArray[counter1]);
                reversedStrings.add(string2);
            }
            // convert reversed strings to another array
            reversedStringsArray = reversedStrings.toArray(new String[0]);

            // build a string containing the elements of the array
            StringBuilder builder = new StringBuilder();
            for (int counter2 = 0; counter2
                    < reversedStringsArray.length; ++counter2) {
                builder.append(reversedStringsArray[counter2]);
                builder.append("\n");
            }

            // create a new file to display the output
            writer = new BufferedWriter(new FileWriter(
                "/home/ubuntu/environment/"
                    + "Unit2/Unit2-01/Unit2-01-Java/output.txt"));
            writer.write(builder.toString());
            writer.close();
            System.out.println("Assigned reversed strings to the output file");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
