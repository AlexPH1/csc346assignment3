import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import com.thoughtworks.xstream.XStream;

/**
 * Demoing XStream
 * 
 * Note: POJOs included are barebones only serving as demonstrations
 *
 * @author: Shane Slater-Pinnick
 * @since: 02-2022
 */

public class App {

    /**
     * Lets user whoose what example to run; doesn't do anything else except handle
     * exceptions
     */
    public static void main(String[] args) {

        try {

            Scanner kbd = new Scanner(System.in);
            System.out.println("Enter 1, 2, or 3");
            String x = kbd.next();
            kbd.close();

            if (x.equals("1")) {
                System.out.println("Example 1:");
                example1();
            } else if (x.equals("2")) {

                System.out.println("Example 2:");
                example2();

            } else if (x.equals("3")) {

                System.out.println("Example 3:");
                example3();

            } else {
                System.out.println("Try again");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(2);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(3);
        }

        System.out.println("\nGoodybye, World!");
    }

    /**
     * Example 1 handles the woz xml
     * Uses Credentials.java
     * 
     * @throws FileNotFoundException
     */
    private static void example1() throws FileNotFoundException {
        FileReader fileReader = new FileReader("woz.xml"); // set ups the woz file to be read
        XStream xstream = new XStream(); // starts up xstream
        xstream.allowTypeHierarchy(Credentials.class); // gives security permission for Credentials.class to be used by
                                                       // xstream
        xstream.processAnnotations(Credentials.class); // processes annotations in the Credentials class
        xstream.alias("credentials", Credentials.class); // aliases "credentials" in the xml with our Credentials class
        Credentials wozCredentials = (Credentials) xstream.fromXML(fileReader); // serializes xml into our Credentials
                                                                                // class
        System.out.println(wozCredentials); // prints results
    }

    /**
     * Example 2 handles the states.xml
     * Uses State.java and StateList.java
     * 
     * @throws FileNotFoundException
     */
    private static void example2() throws FileNotFoundException {
        FileReader fileReader = new FileReader("states.xml"); // set ups the states file to be read
        XStream xstream = new XStream(); // starts up xstream
        xstream.allowTypeHierarchy(StateList.class);
        xstream.allowTypeHierarchy(State.class); // both classes need security permission
        xstream.processAnnotations(State.class); // processes annotations in the state class
        xstream.alias("states", StateList.class); // aliases "states" in the xml with our StateList class
        xstream.alias("state", State.class); // aliases "state" in the xml with our State class
        xstream.addImplicitCollection(StateList.class, "states", State.class); // lets xstream know that instances of
                                                                               // state is contained inside states
        StateList sList = (StateList) xstream.fromXML(fileReader); // serializes xml into our StateList class
        System.out.println(sList); // prints results
    }

    private static void example3() throws MalformedURLException, IOException {
        URL url = new URL("https://w1.weather.gov/xml/current_obs/KSTJ.xml");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(url.openStream()));
        XStream xstream = new XStream(); // starts up xstream
        xstream.allowTypeHierarchy(Wt.class);
        xstream.processAnnotations(Wt.class);
        xstream.alias("current_observation", Wt.class);
        xstream.ignoreUnknownElements(); // will ignore all the extra elements in the xml that we do not want to
                                         // serialize
        Wt currentWeather = (Wt) xstream.fromXML(bufferReader);
        System.out.println(currentWeather);

    }

}
