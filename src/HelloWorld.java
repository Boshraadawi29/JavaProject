
import java.util.Scanner;

public class HelloWorld {
    private void print() {
        System.out.println("Enter your name: ");
        Scanner inp = new Scanner(System.in);
        String name = inp.nextLine();
        System.out.println("Hello World, my name is " + name);
    }
}

