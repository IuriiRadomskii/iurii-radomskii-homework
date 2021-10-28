import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Draft {

    public static void main(String[] args) {
        FileInputStream inputStream;
        Properties property = new Properties();

        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw2/credentials.properties");
            property.load(inputStream);

            String userName = property.getProperty("username");
            String password = property.getProperty("password");
            System.out.println(userName);
            System.out.println(password);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}
