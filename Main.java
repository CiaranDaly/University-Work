//Ciaran Daly //V1.0
import java.util.*;

public class Main {

    public static void main(String[] args) {

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Scanner inputScanner = new Scanner(System.in);//scanner to scan input from the user
        boolean forwards = true;//boolean to determine if user wants to type the letters forwards, true by default


        while (true) { //asks user for input 'f' for forwards or 'b' for backwards repeatedly until one of these are input
            System.out.println("Type the alphabet in order, and hit 'enter' after typing each letter \n Forwards for Backwards (f/b)? ");
            String dirInput = inputScanner.nextLine();
            if (dirInput.equals("f")) {
                forwards = true;
                break;//break the while(true) condition, move to typing test
            } else if (dirInput.equals("b")) {
                forwards = false;
                break;
            } else {
                System.out.println("Invalid input, press 'f' for forwards or 'b' for backwards");//error statement if neither 'f' nor 'b' are input by user
            }
        }

        long start = System.currentTimeMillis();//start of timer

        int i = 0;

        while(i < alphabet.length) {
            char userInput = inputScanner.nextLine().charAt(0); //
            char correctInput = forwards ? alphabet[i] : alphabet[25 - i]; //ternary operator, used to select the correct letter expected based on user typing forward or backward
            //char nextInput = forwards ? alphabet[i+1] : alphabet[25-i-1]; //Redundant: The incrementation of 'i' on line 37 now means there is no need for the extra +1 and -1
            if (userInput == correctInput) { //error: finishes after only one letter is typed
                i++;//increment i if the users input is equal to correct letter expected

                if (i < alphabet.length) {
                    char nextInput = forwards ? alphabet[i] : alphabet[25 - i];  //next letter the user must type
                    System.out.println(userInput + ": Correct. Type the next letter: " + nextInput);//print until all  letters are typed in order
                }
            }


        }


        /*
          Not working as intended, Replaced with above method instead

            if(forwards && userInput == alphabet[i]){ //
                    System.out.println("Type " + alphabet[i+1]);
                    i++;
            }

            else if (!forwards && userInput == alphabet[25-i]) {
                System.out.println("Type " + alphabet[25-i-1]);
                i++;
            }
        }
         */
        long finish = System.currentTimeMillis();//end timer
        long totalTime = (finish-start)/1000;//convert milliseconds time taken to seconds
        System.out.println("Correct! Well done. \n Total time taken: " + totalTime + " seconds");
 }
}