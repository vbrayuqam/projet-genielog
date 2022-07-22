package CoucheLogique;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PosteTravailTest {

    PosteTravail poste = new PosteTravail();

    @Test
    public void testNumero() {
        poste.setNumeroPoste("2B");
        assertTrue(new String("2B").equals(poste.getNumeroPoste()));
        assertFalse(new String("9S").equals(poste.getNumeroPoste()));
    }

}