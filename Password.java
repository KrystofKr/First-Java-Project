public class Password {

    String password;
    int passwordLength;

    public Password(String s){
        password = s;
        passwordLength = s.length();
    }

    private int CharType(char C) {
        int val;

        // Char is Uppercase Letter
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;

        // Char is Lowercase Letter
        else if ((int) C >= 97 && (int) C <= 122) {
            val = 2;
        }

        // Char is Digit
        else if ((int) C >= 48 && (int) C <= 57) {
            val = 3;
        }

        // Char is Symbol
        else {
            val = 4;
        }

        return val;
    }



        public int PoolPasswordStrenght(){
        int score = 0;
        int type;

        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNumber = false;
        boolean IncludeSymbols = false;

        char letter;

        for (int i = 0; i < passwordLength; i++){
            letter = password.charAt(i);
            type = CharType(letter);

            switch(type){
                case 1 -> IncludeUpper = true;
                case 2 -> IncludeLower = true;
                case 3 -> IncludeNumber = true;
                case 4 -> IncludeSymbols = true;
            }

            }
        if (IncludeUpper) score++;
        if (IncludeLower) score++;
        if (IncludeNumber) score++;
        if (IncludeSymbols) score++;

        return score;
       
    }

    private int PasswordStrenght(){
        int strenght = this.PoolPasswordStrenght();

        if (passwordLength >= 8) strenght++;
        if (passwordLength >= 16) strenght++;

        return strenght;

        
        
    }

    public String EvalPassword(){
        int score = this.PasswordStrenght();

        if (score == 6) {
            return "Dobré heslo, netřeba upravovat.";
        } else if (score >= 4) {
            return "Heslo ujde, lae stále je co zlepšit.";
        } else if (score >= 3) {
            return "Nic moc heslo, zkus to znovu a lépe.";
        } else {
            return "Slabé hoslo. Určitě si vygeneruj nové a lepší.";
        }
    }

    public String GetPassword(){
        return this.password;
    }
}
