
package model.tweet;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Description {

    @Expose
    private List<String> urls = new ArrayList<String>();

    /**
     * 
     * @return
     *     The urls
     */
    public List<String> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

}
