import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable {
    String name;
    int age;
    public void sayName(){
        System.out.println("I am "+this.name+". I am "+this.age+" years old" );
    }

}

public class Serialization {
    public static void main(String[] args) {
        User user1 = new User();
        user1.name="Abishek";
        user1.age=20;
        try{
            FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
            ObjectOutputStream out= new ObjectOutputStream(fileOut);
            out.writeObject(user1);
            out.close();
            fileOut.close();

        }catch (Exception exep){

        }
    }
}
