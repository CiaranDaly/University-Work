//Ciarán Daly
//v1.0 //Child class of Animal class, parent class to shark & trout classes
public abstract class Fish extends Animal
{
    //instance variables (fields)
    boolean hasFins;
    boolean hasGills;
    boolean swims;
    boolean canBite = false;
    boolean isDangerous = false;
    boolean hasSpikes = false;
    boolean isEdible = false;
    boolean laysEggs = false;
    /**
     * Constructor for objects of class Fish
     */
    public Fish()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "silver"; //overrides the value of colour inherited from Animal
        hasFins = true; //all the subclasses of Bird inherit this property and value
        hasGills = true; //all the subclasses of Bird inherit this property and value
        swims = true; //all the subclasses of Bird inherit this property and value
        
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance){
        System.out.printf("I swim %d metres \n", distance);
    }

    /**
     * 'getter' method for the hasFins field
     */
    public boolean hasFins(){
        return hasFins;
    }
    
    /**
     * 'getter' method for the hasGills field
     */
    public boolean hasGills(){
        return hasGills;
    }
    
        public boolean hasSkin(){
        return hasSkin;
    }
    
     public boolean getDangerous(){
        return isDangerous;
    }
    
    /*public void printIsDangerous(){
            if(isDangerous = true){
            System.out.printf("Yes, I am dangerous!");
        }
            else{
            System.out.printf("No, I am not dangerous");
        }
    } */  //Possibly dont need this? (I do not, used ternary operator in
    //toString() method instead.
    
}
