
/**
 * A class that represents a single light
 *
 * @author (Ciaran Daly)
 * @version (v1.0)
 */
public class Light
{
    // instance variables - replace the example below with your own
    private int LightOn = 0; //set light to 0 if off, 1 if on
    private String Colour; // Colour of light

    /**
     * Constructor for objects of class Light
     */
    public Light(String Colour)
    {
        this.Colour = Colour;
        this.LightOn = 0;
    }
    
    // accessor and mutator method for the colour field
    public String getColour(){
        return Colour;
    }
    
    public void setColour(String Colour){
        this.Colour = Colour;
    }
    
    //Methods for turning light on/off, updating LightOn accordingly     
    public void turnLightOn(){
        LightOn = 1;
    }
    
    public void turnLightOff(){
        LightOn = 0;
    }
    
    public String printState(){
        if (LightOn == 1){
            return Colour;
        // System.out.println(Colour);
        }
        else{
            return "=OFF=";
           //System.out.println("=OFF=");
        }
        //missing return statement?? (error fix, 'string' type method has to return a value, unlike void)
    }
    }

