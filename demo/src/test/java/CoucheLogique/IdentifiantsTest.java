package CoucheLogique;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class IdentifiantsTest {
    Identifiants id = new Identifiants();

    @Test
    public void testNomUtilisateur() {
        id.setNomUtilisateur("test-user");
        assertTrue(new String("test-user").equals(id.getNomUtilisateur()));
        assertFalse(new String("test-user-2").equals(id.getNomUtilisateur()));
    }

    @Test
    public void testMotDePasse() {
        id.setMotDePasse("test-mdp");
        assertTrue(new String("test-mdp").equals(id.getMotDePasse()));
        assertFalse(new String("test-mdp-2").equals(id.getMotDePasse()));
    }
}