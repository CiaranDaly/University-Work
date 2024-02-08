
/**
 * This class is used to test the other 2 classes using a main method
 *
 * @author (Ciaran Daly)
 * @version (v1.0)
 */
public class TestTrafficLight
{ 
    //main method
    public static void main(String[] args){
        //Instantiating a TrafficLight object
      //TestTrafficLight TestTrafficLight1 = new TestTrafficLight();
      TrafficLights TrafficLights1 = new TrafficLights();
      
      for(int i = 0; i < 5; i++){
          TrafficLights1.go();
          TrafficLights1.printState();
          // non static cannot be reference from a static context?(error fixed by replacing 'TrafficLights. with 'TrafficLights1')
          
          TrafficLights1.prepareToStop();
          TrafficLights1.printState();
          
          TrafficLights1.stop();
          TrafficLights1.printState();
          
      }
}
  
}
