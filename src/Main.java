import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try{
            File file1 = new File("C://Users//acer//IdeaProjects//laba13", "note.txt");
            if(file1.createNewFile()){
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        //String input = "1.32.123.345.322.434.66.43.43.21.112.122.1214544.12.12.6544";
        Pattern pattern = Pattern.compile("((25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)");
        Matcher matcher = pattern.matcher(input);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))){
            while(matcher.find()){
                bw.write(matcher.group() + '\n');
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}