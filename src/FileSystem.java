import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileSystem {
    public static void main(String[] args) {
        try {
            File f = new File("demo.txt");
            Scanner fsc = new Scanner(f);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your name : ");
            String name = sc.nextLine();
            FileWriter fw = new FileWriter("demo2.txt");
            fw.write(name);
            fw.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
