import java.util.Scanner;

public class App {
    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Generator generator = new Generator(keyboard);
        generator.mainLoop();
        keyboard.close();
    }
}
