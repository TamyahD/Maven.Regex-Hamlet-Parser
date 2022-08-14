import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
    private String hamletData;

    private StringBuffer sb = new StringBuffer();


    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public String replaceHamletWithLeon() {
        Pattern hamletPattern = Pattern.compile("Hamlet+", Pattern.CASE_INSENSITIVE);
        Matcher hamletMatcher = hamletPattern.matcher(hamletData);

        while (hamletMatcher.find()) {
            hamletMatcher.appendReplacement(sb, "Leon");
        }
        hamletMatcher.appendTail(sb);
        return sb.toString();
    }

    public String replaceHoratioWithTariq() {
        Pattern horatioPattern = Pattern.compile("Horatio+", Pattern.CASE_INSENSITIVE);
        Matcher horatioMatcher = horatioPattern.matcher(hamletData);

        while (horatioMatcher.find()) {
            horatioMatcher.appendReplacement(sb, "Tariq");
        }
        horatioMatcher.appendTail(sb);
        return sb.toString();
    }

    public boolean findInput (String toFind) {
        boolean foundInput=false;
        String[] words = getHamletData().split("\\s+");
        for (String word : words) {
            if (word.equalsIgnoreCase(toFind)) {
                foundInput=true;
            }
        }
        return foundInput;
    }

    public int howManyTimesFound(String toFind) {
        int counter=0;
        Pattern inputPattern = Pattern.compile(toFind, Pattern.CASE_INSENSITIVE);
        Matcher inputMatcher = inputPattern.matcher(hamletData);

        while (inputMatcher.find()) {
            counter++;
        }
//        String[] words = getHamletData().split("\\s+");
//        for (String word : words) {
//            if (word.equalsIgnoreCase(toFind)) {
//                counter++;
//            }
//        }
        return counter;
    }

}
