/**
 * Created by mr on 12/19/16.
 */
public class Agency {

    private String name;
    private String details;
    private String url;
    private String description;

    public Agency(String agencyName, String agencyDetails, String agencyURL, String description){
        this.name = agencyName;
        this.details = agencyDetails;
        this.url = agencyURL;
        this.description = description;
    }

    public String toString(){
        return "name: " + name +'\n'+
                "details: "+details +'\n'+
                "url: "+url +'\n'+
                "description: "+description + '\n' + '\n' +
                "***" + '\n';
    }
}
