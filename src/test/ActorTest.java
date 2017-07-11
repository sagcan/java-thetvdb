package test;

import model.Actor;
import org.junit.Test;
import org.junit.Assert;
import api.TheTVDBAPI;

public class ActorTest {
    @Test
    public void testAttributes() throws Exception {
        TheTVDBAPI wrapper = TheTVDBAPI.getInstance();
        Actor actor = wrapper.getActors(277165).get(0);

        int expectedSeriesId = 277165;
        int expectedActorId = 326385;
        int expectedImageAuthorId = 370954;
        String expectedImageUrl = "https://thetvdb.com/banners/actors/326385.jpg";
        String expectedImageAdded = "2014-04-29 01:41:43";
        String expectedImageLastUpdated = "2016-11-14 14:45:51";
        String expectedActorName = "Thomas Middleditch";
        String expectedActorRole = "Richard Hendricks";

        if (actor.getActorRole().equals(expectedActorName)) {
            throw new Exception("Actor name not in sync");
        }

        Assert.assertEquals("SeriesId",         expectedSeriesId,           actor.getSeriesId());
        Assert.assertEquals("ActorId",          expectedActorId,            actor.getActorId());
        Assert.assertEquals("ImageAuthorId",    expectedImageAuthorId,      actor.getImageAuthorId());
        Assert.assertEquals("ImageUrl",         expectedImageUrl,           actor.getImageUrl());
        Assert.assertEquals("ImageAdded",       expectedImageAdded,         actor.getImageAdded());
        Assert.assertEquals("ImageLastUpdated", expectedImageLastUpdated,   actor.getImageLastUpdated());
        Assert.assertEquals("ActorName",        expectedActorName,          actor.getActorName());
        Assert.assertEquals("ActorRole",        expectedActorRole,          actor.getActorRole());
    }
}
