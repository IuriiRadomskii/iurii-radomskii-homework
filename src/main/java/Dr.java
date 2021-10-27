import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dr {

    public static void main(String[] args) {
        try {
            File file = new File("src/test/java/com/epam/tc/hw2/credentials");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern1 = Pattern.compile("password", Pattern.CASE_INSENSITIVE);
            while (line != null) {
                Matcher matcher1 = pattern1.matcher(line);
                if (matcher1.find()) {
                    Pattern pattern2 = Pattern.compile("\"([^\"]*)\"");
                    Matcher matcher2 = pattern2.matcher(line);
                    if (matcher2.find()) {
                        System.out.println(matcher2.group(0));
                    }
                    line = reader.readLine();
                } else {
                    line = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
