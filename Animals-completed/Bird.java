//Ciarán Daly
//v1.0 //Child class of Animal class, parent class to ostrich & canary classes
public abstract class Bird extends Animal
{
    //instance variables (fields)
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;
    boolean isTall;
    boolean hasThinLongLegs;
    boolean canSing;

    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "black"; //overrides the value of colour inherited from Animal
        hasFeathers = true; //all the subclasses of Bird inherit this property and value
        hasWings = true; //all the subclasses of Bird inherit this property and value
        flies = true; //all the subclasses of Bird inherit this property and value
        isTall = true;
        hasThinLongLegs = false;
        canSing = true;
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance){ 
      System.out.printf(flies ? "I fly %d metres \n" : "I'm a bird but cannot fly \n", distance);
        //Not all birds fly. What can we do here to check for the ability to fly
        //and print an appropriate message based on whether or not the bird can fly? 
        // - an if/else using boolean field 'flies'>>(replaced with ternary operator)
    }
    
    /**
     * sing method that all birds have
     */
    public abstract void sing();//abstract, used in subclasses canary &  osctrch

        public boolean hasSkin(){
        return hasSkin;
    }
    
    /**
     * 'getter' method for the hasWings field
     */
    public boolean hasWings(){
        return hasWings;
    }
    
    /**
     * 'getter' method for the hasFeathers field
     */
    public boolean hasFeathers(){
        return hasFeathers;
    }
}
