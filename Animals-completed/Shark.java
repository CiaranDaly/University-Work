
//v1.0 //subclass of Fish class //Ciarán Daly
public class Shark extends Fish
{
    
    String name; // the name of this Shark

    /**
     * Constructor for objects of class Shark
     */
    public Shark(String name)
    {
        super(); // call the constructor of the superclass Fish
        this.name = name;
        colour = "Grey"; // this overrides the value inherited from Fish
        canBite = true;
        isDangerous = true;
    }

    /**
     * toString method returns a String representation of the fish
     * What superclass has Shark inherited this method from? 
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "\n\n";
        strng+= "Shark; ";
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
        strng+= "Can I bite?";
        strng+= canBite? "Yes, I can bite!" : "No, I cannot bite"; //add this method in Fish class to print
        strng+= "\n";
        strng+= "Am I dangerous? "; //also add htis method
        strng+= isDangerous? "Yes, I am dangerous!" : "No, I am not dangerous";
        strng+= "\n";
        return strng;
    }

    @Override
    public void move(int distance){
        System.out.printf("I swim %d metres \n", distance);
    }
    
        @Override
        public String getColour(){
        return colour;
    }
    /**
     * equals method defines how equality is defined between 
     * the instances of the Shark class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Shark object
     */
    
        @Override
        public boolean equals(Object obj) {
        // checks if the object is null
        if (obj == null) {
            return false;
        }
    
        // check if the object is an instance of Shark
        if (obj instanceof Shark) {
            Shark shark = (Shark) obj;
            
            // Compare the color attribute
            if (this.colour == shark.getColour()) {
                return true;
            }
        }
    
        return false;
        }
}
