//Ciarán Daly
//v1.0 //subclass of Bird class
public class Canary extends Bird
{
    String name; // the name of this Canary
    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        
    }
    @Override
        public String getColour(){
        return colour;
    }
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing(){
         System.out.println(canSing ? "tweet tweet tweet" : "I'm a bird but cannot sing \n");
    }
    
     @Override
    public void move(int distance){ //replace with ternary operator 
      System.out.printf(flies ? "I fly %d metres \n" : "I'm a bird but cannot fly \n", distance);
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "\n\n";
        strng+= "Canary; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        strng+= "Can I fly? ";
        strng+= flies ? "Yes, I can fly" : "I'm a bird but cannot fly";
        strng+= "Can I sing? ";
        strng+= canSing? "Yes I can sing." : "I'm a bird but cannot sing";
        strng+= "\n";
        strng+= "Do I have feathers? ";
        strng+= hasFeathers ? "I have feathers" : "I'm a bird but don't have feathers";
        return strng;
    }

    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
             return false;
        }
        if (obj instanceof Canary) {
            Canary canary = (Canary) obj;
            if (this.colour.equals(canary.getColour())) {
                return true;
            }
            
        }
        return false;
    }
}






