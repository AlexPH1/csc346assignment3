import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Handles the instances of state xml inside the states xml
 */
public class State {
    @XStreamAlias("state")
    private String name;
    private String slug;
    private String code;
    private String nickname;
    private String website;
    @XStreamAlias("admission_date")
    private String admissionDate;
    @XStreamAlias("admission_number")
    private String admissionNumber;
    @XStreamAlias("capital_city")
    private String capitalCity;
    @XStreamAlias("capital_url")
    private String capitalURL;
    private String population;
    @XStreamAlias("population_rank")
    private String populationRank;
    @XStreamAlias("constitution_url")
    private String constitutionURL;
    @XStreamAlias("state_flag_url")
    private String stateFlagURL;
    @XStreamAlias("state_seal_url")
    private String stateSealURL;
    @XStreamAlias("map_image_url")
    private String mapImageURL;
    @XStreamAlias("landscape_background_url")
    private String landscapeBackgroundURL;
    @XStreamAlias("skyline_background_url")
    private String skylineBackgroundURL;
    @XStreamAlias("twitter_url")
    private String twitterURL;
    @XStreamAlias("facebook_url")
    private String facebookURL;   
    
    /** 
     * Basic formatting
     * @return String
     */
    @Override
    public String toString() {
        return "[name=" + name +", admissionDate=" + admissionDate + ", admissionNumber=" + admissionNumber + ", capitalCity="
                + capitalCity + ", capitalURL=" + capitalURL + ", code=" + code + ", constitutionURL=" + constitutionURL
                + ", facebookURL=" + facebookURL + ", landscapeBackgroundURL=" + landscapeBackgroundURL
                + ", mapImageURL=" + mapImageURL + ", nickname=" + nickname + ", population="
                + population + ", populationRank=" + populationRank + ", skylineBackgroundURL=" + skylineBackgroundURL
                + ", slug=" + slug + ", stateFlagURL=" + stateFlagURL + ", stateSealURL=" + stateSealURL
                + ", twitterURL=" + twitterURL + ", website=" + website + "]";
    }

    

    
    
}
