import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Handles serialization of weather.org
 * 
 * Note: calling this class Weather.java caused the following error:
 * Exception in thread "main" java.lang.NoClassDefFoundError: Weather (wrong name: weather)
 * I have no idea why
 */
public class Wt {

    private String location;
    @XStreamAlias("temperature_string")
    private String temp;
    @XStreamAlias("relative_humidity")
    private String humidity;
    private Image image;

    

    @Override
    public String toString() {
        return "Weather [humidity=" + humidity + ", location=" + location + ", temp=" + temp + ", image url=" + image + "]";
    }


    /**
     * Nested class to handle nested xml
     */
    class Image{
        private String url;

        @Override
        public String toString() {
            return "url=" + url;
        }

        
    }
    
}
