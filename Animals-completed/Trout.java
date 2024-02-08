
//v1.0 //subclass of Fish class //Ciarán Daly
public class Trout extends Fish
{
    
    String name; // the name of this Fish

    /**
     * Constructor for objects of class Trout
     */
    public Trout(String name)
    {
        super(); // call the constructor of the superclass Fish
        this.name = name;
        colour = "Brown"; // this overrides the value inherited from Fish
        hasSpikes = true;
        isEdible = true;
        laysEggs = true;
    }
    
    /**
     * toString method returns a String representation of the fish
     * What superclass has Trout inherited this method from? 
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "\n\n";
        strng+= "Trout; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "\n";
        strng+= "Can I swim?";
        strng+= swims? "Yes, I can swim" : "I'm a fish but cannot swim"; //add this method in Fish class to print
        strng+= "\n";
        strng+= "Do I have fins?";
        strng+= hasFins? "Yes, I have fins" : "No, I do not have fins"; //add this method in Fish class to print
        strng+= "\n";
        strng+= "Do I have gills?";
        strng+= hasGills? "Yes, I have gills" : "No, I do not have gills"; //add this method in Fish class to print
        strng+= "\n";
        strng+= "Do I have spikes?";
        strng+= hasSpikes? "Yes I do have spikes!" : "No, I am spikeless!" ; //add method to Fish class
        strng+= "\n";
        strng+= "Am I edible?";
        strng+= isEdible? "I am edible!" : "No, I am not edible.";
        strng+= "\n";
        strng+= "If I lay eggs, where do I lay them? ";
        strng+= laysEggs? "I swim upriver to lay eggs" : "I don't lay eggs";
        strng+= "\n";
        return strng;
    }

    public void move(int distance){
        System.out.printf("I swim %d metres \n", distance);
    }
    
        @Override
        public String getColour(){
        return colour;
    }
    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Trout class
     * param Trout
     * return true or false depending on whether the input object is 
     * equal to this Trout object
     */
    
    @Override
        public boolean equals(Object obj) {
        // checks if the object is null
        if (obj == null) {
            return false;
        }
    
        // checks if the object is an instance of Trout
        if (obj instanceof Trout) {
            Trout trout = (Trout) obj;
            // Compare the color attribute
            if (this.colour == trout.getColour()) {
                return true;
            }
        }
    
        return false;
    }
}


