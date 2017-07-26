package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ActorTest.class,
        EpisodeTest.class,
        EpisodeDetailedTest.class,
        ImageTest.class,
        SearchResultTest.class,
        SeriesTest.class
})
public class TestSuite {
}
