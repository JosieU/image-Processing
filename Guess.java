import java.util.Scanner;
import java.util.zip.ZipEntry;

public class Guess {
    public static int GuessNumber(int b){
        Scanner scanner = new Scanner(System.in);
        System.err.println("Enter Your Jackpot");
        int a = scanner.nextInt();
        if (a == b - 10 || a == b +10){
             System.out.println("Close to Your JackPot");
        }
        else if (a == b ){
            System.out.println("winner");

        }
        return b;
    }
    public static void main(String [] args){
       int number = (GuessNumber(40));
    }
    
}
