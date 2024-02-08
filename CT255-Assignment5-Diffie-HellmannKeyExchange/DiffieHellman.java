import java.util.Random;
/**
 * Methods needed for this class: A main method, a generator method,a  method to check if a number is prime, method to check if one number is a primitive 
 * root of another number, and a method to calculate (a^b) % mod
 *
 * @author (Ciarán Daly)
 * @version (v1.0)
 */
public class DiffieHellman
{
    int lb = 10000; //lower bound (10^4)
    int ub = 100000;//lower bound (10^5)
    //int p = 1; p & a moved to main due to static error
    //int a = 1;
    Random random = new Random();
    public DiffieHellman()
    {
      // Constructor N/A
    }
    //main method
    public static void main(String[] args){
        DiffieHellman dh = new DiffieHellman();
         int lb = 10000;
         int ub = 100000;
   
        int p = dh.generatePrime();//assign generate prime method, thus p = random prime num
        int a = dh.findPrimitiveRoot(p);
        
        //key exchange for
        int XA = dh.random.nextInt(ub);//alice private key
        int XB = dh.random.nextInt(ub);//bob private key
        
        //PART2: Demo a MitM attack
        int XM = dh.random.nextInt(100000);//mallory private key
        
        
        //int YA = dh.power(a, XA, p);
        //int YB = dh.power(a, XB, p);
        
        //int KA = dh.power(YB, XA, p);
        //int KB = dh.power(YA, XB, p);
        
        int YA = dh.power(a, XA, p); //alice public key
        int YB = dh.power(a, XB, p); //alice public key
        int YM = dh.power(a, XM, p); //alice public key
        
        int KAM = dh.power(YM, XA, p); //key between Alice and Mallory
        int KBM = dh.power(YM, XB, p); //key between Bob and Mallory
        
        int KMA = dh.power(YA, XM, p); //key between Mallory and Alice
        int KMB = dh.power(YB, XM, p); //key between Mallory and Bob
        
        
        //System.out.println("Key calculated by Alice: " + KA);
        //System.out.println("Key calculated by Bob: " + KB);
        
        //Print Keys for PART2, MitM attack
        System.out.println("Key calculated by Alice for Mallory: " + KAM);
        System.out.println("Key calculated by Bob for Mallory: " + KBM);
        System.out.println("Key calculated by Mallory with Alice: " + KMA);
        System.out.println("Key calculated by Mallory with Bob: " + KMB);
    }
    //generator method, enerate a random prime number between upper and lower bound
      private int generatePrime() {
        int num;
        do {
            num = lb + random.nextInt(ub - lb);
        } while (!isPrime(num));
        return num;
    }
    //boolean method to check if a number is prime
        private boolean isPrime(int num) {
        if (num <= 1)
        return false; //if number input us less or equal to 1, ret false
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)//if the result of the modulus with the number = 0, it means it is divisable bt more nums than itself and 0, so ret false
            return false;
        }
        return true;//if neither conditions are met, it means num is prime, so return true
    }
    
    //method to find the prime root of p
     private int findPrimitiveRoot(int p) {
        for (int a = 2; a < p; a++) {
            if (isPrimitiveRoot(a, p)) { //check if a is the primitive root of p
                return a;//if it is, return a
            }
        }
        return -1; //else, return -1 if no prim root is found
    }
    
    //check if 'a' is a primitive root of 'p'
    private boolean isPrimitiveRoot(int a, int p) {
        for (int i = 1; i < p - 1; i++) {
            if (power(a, i, p) == 1) 
            return false;
        }
        return true;
    }
    //method to calculate (a^b) % mod
    private int power(int a, int b, int mod) {
        int result = 1;
        a = a % mod;
        while (b > 0) { //while expo 'b' is greater than 0
            if (b % 2 == 1) { //if 'b' is an odd number
                result = (result * a) % mod;//multiply 'result' with 'a' and apply modulus
            }
            b = b >> 1; //shift 'b' by one (basically divides b by 2)
            a = (a * a) % mod;// a^a and apply modulus again for next iteration
        }

        return result; //should return 'a^b % mod'
    }
}


