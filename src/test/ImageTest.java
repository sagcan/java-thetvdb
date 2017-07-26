package test;

import model.Image;
import model.ImageType;
import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Volkan Sagcan
 * @version 1.0
 *
 * JUnit tests for the Image class.
 */
public class ImageTest extends BaseTestClass {

    public ImageTest() throws IOException, AuthenticationException {
    }

    @Test
    public void testImage() throws IOException, AuthenticationException {
        Image image = theTVDBAPI.getImages(121361, ImageType.SEASON).get(0);

        assertThat(image.getImageId()).isPositive();

        assertThat(image.getUrl()).isNotEmpty();
        assertThat(image.getKeyType()).isEqualTo("season");
        assertThat(image.getThumbnail()).isNotEmpty();
//        assertThat(image.getResolution()).isNotEmpty();
    }
}
