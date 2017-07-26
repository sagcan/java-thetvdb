package test;

import api.TheTVDBAPI;
import org.apache.http.auth.AuthenticationException;

import java.io.IOException;

/**
 * This class is used to only make the theTVDBAPI object accessible to its sub-classes, so that
 * we do not have to create a separate (new) instance for each test class.
 */
public class BaseTestClass {

    protected static TheTVDBAPI theTVDBAPI;

    public BaseTestClass() throws IOException, AuthenticationException {
        /* Replace $USERNAME, $USERKEY and $APIKEY with your own keys (get them at https://api.thetvdb.com/swagger). */
        theTVDBAPI = TheTVDBAPI.getInstance("$USERNAME", "$USERKEY", "$APIKEY");
    }
}
