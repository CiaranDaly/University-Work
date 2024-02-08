
/**
 * For Part 2: Test the classes in your hierarchy
 * this class is used for calling each test method, AnimalTestx() in its main method.
 *
 * @author (Ciarán Daly)
 * @version (v1.0) //TestClass
 */
public class AnimalTest
{
    /**
     * Constructor for objects of class AnimalTest (N/A)
     */
    public AnimalTest()
    {
        
    }

    public static void main(String[] args) //main method, used to test each AnimalTest
    {
         AnimalTest test = new AnimalTest();
         test.AnimalTest1();
         test.AnimalTest2();
    }
    
    public void AnimalTest1(){
        //Canary Bluey1 = new Canary("Bluey");
        //Bluey1.sing(); //sings okay
        
        // Shark hammer = new Shark("Hammerhead Shark");
        //System.out.println(hammer); prints shark class okay
        
        
        Animal[] animals = new Animal[4]; //declares and allocates memory for an array of Animal references with 4 spaces
        
        animals[0] = new Canary("Bluey");//assigning each element of the array with a different animal class
        animals[1] = new Ostrich("Somali Ostrich");
        animals[2] = new Shark("Hammerhead Shark");
        animals[3] = new Trout("Bull Trout");
        
        for(int i = 0; i < 4; i++){
            System.out.println(animals[i]);//will jump to the toString() method and print its contents
            animals[i].move(100);//calls move method which each animal possesses
        }
        
    }
    
    public void AnimalTest2(){
        //tests if equals method works correctly
        
        Animal[] animals = new Animal[4]; 
        animals[0] = new Canary("Bluey");
        animals[1] = new Ostrich("Somali Ostrich");
        animals[2] = new Shark("Hammerhead Shark");
        animals[3] = new Trout("Bull Trout");
        
        System.out.println("Test equals method for Canary Class \n");//tests equals method of Canary class with each animal object in the array
        //output should be: equal, not equal, not equal, not equal.
        for(int i = 0; i < 4; i++){
            //animals[0].equals(animals[i]); (inccorrect, fixed by using line below)
            System.out.println(animals[0].equals(animals[i])? "This object is equal" : "This object is not equal"); 
        }
        System.out.println("\n");
        System.out.println("Test equals method for Ostrich Class \n");
        //output should be: not equal, equal, not equal, not equal.
         for(int i = 0; i < 4; i++){
            //animals[0].equals(animals[i]);
            System.out.println(animals[1].equals(animals[i])? "This object is equal" : "This object is not equal");
        }
        System.out.println("\n");
        System.out.println("Test equals method for Shark Class \n");
        //output should be: not equal, not equal, equal, not equal.
        for(int i = 0; i < 4; i++){
            //animals[0].equals(animals[i]);
            System.out.println(animals[2].equals(animals[i])? "This object is equal" : "This object is not equal");
        }
        System.out.println("\n");
        System.out.println("Test equals method for Trout Class \n");
        //output should be: not equal, not equal, not equal, equal.
         for(int i = 0; i < 4; i++){
            //animals[0].equals(animals[i]);
            System.out.println(animals[3].equals(animals[i])? "This object is equal" : "This object is not equal");
        }
    }
}

