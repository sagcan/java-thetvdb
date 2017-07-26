package test;

import model.Actor;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * JUnit tests for the Actor class.
 */
public class ActorTest extends BaseTestClass {

    public ActorTest() throws IOException, AuthenticationException {
    }

    @Test
    public void testActor() throws IOException, AuthenticationException {
        Actor actor = theTVDBAPI.getActors(121361).get(24);
        System.out.println(actor.toString());

        assertThat(actor.getActorId()).isPositive();
        assertThat(actor.getSeriesId()).isPositive();
        assertThat(actor.getImageAuthorId()).isPositive();

        assertThat(actor.getImageUrl()).isNotEmpty();
        assertThat(actor.getImageAdded()).isNotEmpty();
        assertThat(actor.getImageLastUpdated()).isNotEmpty();
        assertThat(actor.getActorName()).isNotEmpty();
        assertThat(actor.getActorRole()).isNotEmpty();
    }
}
