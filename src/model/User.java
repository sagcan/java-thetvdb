package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Volkan Sagcan
 *         <p>
 *         POJO class which is used to obtain a session token.
 *         For more information see: https://api.thetvdb.com/swagger#!/Authentication/post_login
 */
public class User {
    private String username;
    private String userkey;
    private String apikey;

    public User(String username, String userkey, String apikey) {
        this.username = username;
        this.userkey = userkey;
        this.apikey = apikey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
