@FunctionalInterface // Single Abstract Method(SAM)
interface Students{
    void display(String name,int age); // There must be only one abstract method inside the interface for Lambda Expression
}

//There should be only one abstract method inside the interface

@FunctionalInterface
interface Employee{
    int addNum(int a,int b);
}

public class LambdaExpression {
    public static void main(String[] args) {
        //We can create an object for the interface directly without the need for classes
        Students s1 = (name,age)->{
            System.out.println("Hello I am a "+name+" I am "+age+" years old");
        };

        Employee e1 = (a,b)->{
            return a+b;
        };

        s1.display("Abishek",20);
        int result = e1.addNum(6,4);
        System.out.println(result);
    }
}
