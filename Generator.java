import java.util.InputMismatchException;
import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    Scanner keyboard = new Scanner(System.in);

    public Generator(Scanner s){
        keyboard = s;
    }
    
    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNumber, boolean IncludeSymbols){
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNumber, IncludeSymbols);
    }

    public void mainLoop(){
        System.out.println();
        System.out.println("Vítej v generovači hesel.");
        

        int userOption = 0;
        this.mainMenu();
        while (userOption != 3){
            try{
            userOption = keyboard.nextInt();
            keyboard.nextLine();
            switch(userOption){
                case 1 -> {
                    this.RequestPassword();
                    this.mainMenu();
                }
                case 2 -> {
                    this.ScorePassword();
                    this.mainMenu();
                }
                case 3 -> {
                    this.Exitmessage();

                }
                default ->{
                    System.out.println("Napiš jen jednu z vypsaných možností, nic jiného.");
                    this.mainMenu();
                }
            }
            }
            catch(InputMismatchException e) {
            System.out.println("Špatné! Napiš platné číslo.");
            keyboard.nextLine(); 
            this.mainMenu();
        }
        }

    }

    public Password GeneratePassword(int l){

        StringBuilder password = new StringBuilder("");
        String pool = alphabet.getPool(); 
        int poolScore = alphabet.getPoolScore();
        Password checkPassword;

        do {
        for (int i = 0; i < l; i++){
            
            int index = (int) (Math.random() * pool.length()) + 1;
            if (index > 0 && index < pool.length()){
                char c = pool.charAt(index);
                password.append(c);
                }
        }
        //return password.toString();
        checkPassword = new Password(password.toString());

        if (poolScore != checkPassword.PoolPasswordStrenght()){
        password.setLength(0);
            }

        }
        while (poolScore != checkPassword.PoolPasswordStrenght());
        return checkPassword;
    }

    private void RequestPassword(){

        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNumber = false;
        boolean IncludeSymbols = false;

        boolean ContinueLoop = false;
        String answear;

        do{
            answear = "";
            System.out.println();
            System.out.println("Pojďme si vygenerovat heslo. Na následující otázky odpovídej ano nebo ne.");
            
            do {
            System.out.println();
            System.out.println("Chceš aby heslo zahrnovalo velká písmena?");
            answear = keyboard.nextLine();
            RequestPasswordError(answear);

            } while (!answear.equalsIgnoreCase("ano") && !answear.equalsIgnoreCase("ne"));
            if (answear.equalsIgnoreCase("ano")) IncludeUpper = true;

            do {
            System.out.println();
            System.out.println("Chceš aby heslo zahrnovalo malá písmena?");
            answear = keyboard.nextLine();
            RequestPasswordError(answear);

            } while (!answear.equalsIgnoreCase("ano") && !answear.equalsIgnoreCase("ne"));
            if (answear.equalsIgnoreCase("ano")) IncludeLower = true;

            do {
            System.out.println();
            System.out.println("Chceš aby heslo zahrnovalo číslice?");
            answear = keyboard.nextLine();
            RequestPasswordError(answear);

            } while (!answear.equalsIgnoreCase("ano") && !answear.equalsIgnoreCase("ne"));
            if (answear.equalsIgnoreCase("ano")) IncludeNumber = true;

            do {
            System.out.println();
            System.out.println("Chceš aby heslo zahrnovalo symboly?");
            answear = keyboard.nextLine();
            RequestPasswordError(answear);

            } while (!answear.equalsIgnoreCase("ano") && !answear.equalsIgnoreCase("ne"));
            if (answear.equalsIgnoreCase("ano")) IncludeSymbols = true;
            
            if (!IncludeUpper && !IncludeLower && !IncludeNumber && !IncludeSymbols){
                System.out.println("Musíš zvolit alespoň jeden okruh znaků. Zkus to.");
                ContinueLoop = true;
            }
            if (IncludeUpper || IncludeLower || IncludeNumber || IncludeSymbols){
                ContinueLoop = false;
            }
            
        }
        while (ContinueLoop);

        System.out.println();
        System.out.println("Z kolika znaků má být heslo poskládáno?");
        int Length = keyboard.nextInt();
        keyboard.nextLine();
        while (Length <= 0){
        System.out.println("Heslo se musí skládat alespoň z jednoho znaku. Napiš z kolika znaků má být heslo poskládáno.");
        Length = keyboard.nextInt();
        keyboard.nextLine();
        }
        

        Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNumber, IncludeSymbols);
        Password password = generator.GeneratePassword(Length);
        System.out.println();
        System.out.println("Tvoje heslo je: " + password.GetPassword());

    }
    private void ScorePassword(){
        System.out.println("Napište heslo k ohodnocení.");
        String s = keyboard.next();
        final Password password = new Password(s);
        System.out.println();
        System.out.println(password.EvalPassword());

    }

    private void RequestPasswordError(String s){
        if (!s.equalsIgnoreCase("ano") && !s.equalsIgnoreCase("ne") && !s.equalsIgnoreCase("")){
            System.out.println("Odpověď musí být ano nebo ne.");
        }
    }

    private void Exitmessage(){
        System.out.println();
        System.out.println("Díky za využití mého programu. See you soon.");
    }

    private void mainMenu(){
        System.out.println();
        System.out.println("Napsáním příslušné číslice zvol jednu možnost");
        System.out.println();
        System.out.println("1 - Vygenerování hesla");
        System.out.println("2 - Ohodnocení hesla");
        System.out.println("3 - Vypnout generátor");
    }
}
