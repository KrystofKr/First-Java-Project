public class Alphabet {
    private final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private StringBuilder pool;
    private int poolScore = 0;

    public Alphabet(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNumber, boolean IncludeSymbols){
        pool = new StringBuilder();
        
        if (IncludeUpper) {
          pool.append(UPPERCASE_LETTERS);
          poolScore++;
        }
        if (IncludeLower) {
          pool.append(LOWERCASE_LETTERS);
          poolScore++;}
        if (IncludeNumber) {
          pool.append(NUMBERS);
          poolScore++;}
        if (IncludeSymbols) {
          pool.append(SYMBOLS);
        poolScore++;}

    }

  public String getPool(){
    return pool.toString();
  }
  
  public int getPoolScore(){
    return poolScore;
  }
}
