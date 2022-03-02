import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Handles serialization of woz.xml
 */

public class Credentials {

    private String user;
    @XStreamAlias("password")
    private Password pw;
    private String host;
    private int port;
    
    
    /**
     * Basic toString formatting
     * @return String
     */
    @Override
    public String toString() {
        return "Credentials [host=" + host + ", port=" + port + ", " + pw + ", user=" + user + "]";
    }

    /**
     * xstream seems to expect that xml attributes be hanlded as an instance of a class, thus a nested class is used here
     * ToAttributedValueConverter allows us to get both the attribute and the password value
     * This also makes it unnecisary to use XStreamAsAttribute to explicitly designate attributes as the converter makes it implicit
     */
    @XStreamConverter(value=ToAttributedValueConverter.class, strings={"password"})
    class Password {
        @XStreamAlias("xhint")
        private String hint;

        private String password;



        public String toString() {
            return "password=" + password + ", hint=" + hint;
        }
    }

    

    
    
}
