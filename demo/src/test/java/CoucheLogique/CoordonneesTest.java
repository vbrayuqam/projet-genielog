package CoucheLogique;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CoordonneesTest {

    Coordonnees coords = new Coordonnees();

    @Test
    public void testAdresse() {
        coords.setAdresse("123 rue du test");
        assertTrue(new String("123 rue du test").equals(coords.getAdresse()));
        assertFalse(new String("456 rue du test").equals(coords.getAdresse()));
    }

    @Test
    public void testTelephone() {
        coords.setTelephone("666-666-6666");
        assertTrue(new String("666-666-6666").equals(coords.getTelephone()));
        assertFalse(new String("777-777-7777").equals(coords.getTelephone()));
    }

    @Test
    public void testCourriel() {
        coords.setCourriel("test@testerino.test");
        assertTrue(new String("test@testerino.test").equals(coords.getCourriel()));
        assertFalse(new String("fail@failerino.fail").equals(coords.getCourriel()));
    }

}