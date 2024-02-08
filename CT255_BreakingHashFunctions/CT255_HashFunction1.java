 import java.util.Random;
/**
* 
* @author Michael Schukat
*/
public class CT255_HashFunction1 {
    public static void main(String[] args) {
            int res = 0;
         if (args != null && args.length > 0) { // Check for <input> value
            res = hashF1(args[0]); // call hash function with <input>
        if (res < 0) { // Error 
            System.out.println("Error: <input> must be 1 to 64 characters long.");
            }
        else {
            System.out.println("input = " + args[0] + " : Hash = " + res);
            System.out.println("Start searching for collisions");
            
            collisionsSearch("Bamb0", 8000);
        }
        
        }
            else { // No <input>
            System.out.println("Use: CT255_HashFunction1 <Input>");
         }
         }
         

    private static int hashF1(String s){
        int ret = -1, i, j;
        int[] hashA = new int[]{1, 1, 1, 1};
        String filler, sIn;
        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");
        if ((s.length() > 64) || (s.length() < 1)) { // String does not have required length
        ret = -1;
        }
        else {
        sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
        sIn = sIn.substring(0, 64); // // Limit string to first 64 characters
        // System.out.println(sIn); // FYI
            for (i = 0; i < sIn.length(); i++){
                char byPos = sIn.charAt(i); // get i'th character
                hashA[0] += (byPos * 17); // Note: A += B means A = A + B
                hashA[1] += (byPos * 31);
                hashA[2] += (byPos * 101);
                hashA[3] += (byPos * 79);
            }
             hashA[0] %= 255; // % is the modulus operation, i.e. division with rest
                hashA[1] %= 255;
                hashA[2] %= 255;
                hashA[3] %= 255;
                ret = hashA[0] + (hashA[1] * 256) + (hashA[2] * 256 * 256) + (hashA[3] * 256 * 256 * 256);
        
                
        //using a larger prime number for modulus
        //this should give better distribution of hash values
       // int largePrime = 7919;
        
        //for (j = 0; i < 4; i++) { //loop through hashA
        //    hashA[i] %= largePrime; //use modulus for each position
        //}
        
        //ret = hashA[0] + (hashA[1] * 7919) + (hashA[2] * 7919 * 7919) + (hashA[3] * 7919 * 7919 * 7919);
         
        if (ret < 0) 
           ret *= -1;
        }
        return ret;
        }


     private static void collisionsSearch(String testString, int maxAttempts) {
        int testStringHash = hashF1(testString); //ie 1079524045
        int attempts = 0;
        Random rand = new Random();

        while (attempts < maxAttempts) {
            StringBuilder input = new StringBuilder(); //string builder to allow modifying string many times
            int length = rand.nextInt(64) + 1; //will set string to a random lenght between 1 - 64 chars
            
            for (int i = 0; i < length; i++) {
                char randomChar = (char) (rand.nextInt(26) + 'A'); // generates random uppercase letters for this test
                input.append(randomChar); //assigns random char to input string
            }

            int hash = hashF1(input.toString());
            
            //if hash of inputted hash is equal to the random hash
            //and are not the same string, a collision is found
            if (hash == testStringHash && !input.toString().equals(testString)) {
                System.out.println("Collision found: input = " + input + " : Hash = " + hash);
            }

            attempts++;
        }
     }
}

