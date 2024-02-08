
/**
 * A class composed of three Light objects that indicates which is currently lit
 *
 * @author (Ciaran Daly)
 * @version (v1.0)
 */
public class TrafficLights
{
    private Light green;
    private Light amber;
    private Light red; //object fields for each light colour
    
    public TrafficLights(){
        green = new Light("Green");
        amber = new Light("Amber");
        red = new Light("Red"); 
    }
    
    
    public void go(){
          //green light on, rest off, use turnLightOn/Off methods
            green.turnLightOn();
            amber.turnLightOff();
            red.turnLightOff();
            //undeclared method??(fixed by using green = new Light("Green"))
        }
        
        public void prepareToStop(){
            //amber on, rest off  
            green.turnLightOff();
            amber.turnLightOn();
            red.turnLightOff();
    }
    
        public void stop(){
            //red on, rest off    
            green.turnLightOff();
            amber.turnLightOff();
            red.turnLightOn();
    }
    
            public void printState(){
            //prints states of each light when called
            System.out.println(green.printState());
            System.out.println(amber.printState());
            System.out.println(red.printState());
    }
}
