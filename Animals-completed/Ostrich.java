
//Ciarán Daly
//v1.0 //subclass of Bird class
public class Ostrich extends Bird
{
    
    String name; // the name of this Ostrich

    /**
     * Constructor for objects of class Ostrich
     */
    public Ostrich(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "black"; // this overrides the value inherited from Bird
        flies = false;//ovverides Bird parent class as this Ostrich cant fly
        isTall = true;
        hasThinLongLegs = true;
        canSing = false;//ovverides Bird parent class as this Ostrich cant sing
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
     * What superclass has Ostrich inherited this method from? 
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "\n\n";
        strng+= "Ostrich; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "\n";
        strng+= "Am I tall? ";
        strng+= isTall ? "Yes I am tall" : "No, I am not tall";
        strng+= "\n";
        strng+= "Can I fly? ";
        strng+= flies ? "Yes, I can fly" : "I'm a bird but cannot fly";
        strng+= "\n";
        strng+= "Do I have thin long legs? ";
        strng+= hasThinLongLegs? "Yes, I have thin long legs" : "I don't have thin long legs";
        strng+= "\n";
        strng+= "Can I sing? ";
        strng+= canSing? "Yes I can sing." : "I'm a bird but cannot sing";
        strng+= "\n";
        strng+= "Do I have feathers? ";
        strng+= hasFeathers ? "I have feathers" : "I'm a bird but don't have feathers";
        return strng;
    }

            @Override
        public String getColour(){
        return colour;
    }
    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Ostrich class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Ostrich object
     */
    
    @Override
    public boolean equals(Object obj) {
        // checks if the object is null
        if (obj == null) {
            return false;
        }
    
        // checks if the object is an instance of Canary
        if (obj instanceof Ostrich) {
            Ostrich ostrich = (Ostrich) obj;
            
            // Compare the color attribute
            if (this.colour == ostrich.getColour()) {
                return true;
            }
        }
    
        return false;
    }
}

