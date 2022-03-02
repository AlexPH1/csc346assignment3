import java.util.ArrayList;
import java.util.List;

/**
 * A class that is an array list of instances of the State class
 * Handles serialization of woz.xml along with State.java
 */
public class StateList {

    private List<State> states;

    public StateList(){
        states = new ArrayList<State>();
    }

    
    /** 
     * Add instances of State class to array list
     * @param o
     */
    public void add(State o){
        states.add(o);
    }

    
    /** 
     * Formats so that each instance of a State class has its own line
     * @return String
     */
    @Override
    public String toString() {

        String s = "";

        for (State state : states){
            s = s + state.toString() + "\n";            
        }
        return s;
    }

    
    
}
