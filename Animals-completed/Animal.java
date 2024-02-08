//Abscract, Superclass 
//v1.0 //Ciarán Daly
public abstract class Animal
{
    boolean hasSkin;
    boolean breathes;
    String colour;
    
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        colour = "grey"; //all the subclasses of Animal inherit this property and value
    }
 
    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public abstract void move(int distance);//Method abstracted
        //System.out.printf("I move %d metres \n", distance); //thisline will be declared in on of the subclasses  - reduced repitition of code
    
        
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public abstract String getColour();//abstract, getter method will be used instead in subclasses
    
     /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */
    
    public abstract boolean hasSkin();//abstract, getter method can be used instead in subclasses
}
