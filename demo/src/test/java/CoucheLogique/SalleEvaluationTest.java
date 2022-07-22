package CoucheLogique;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class SalleEvaluationTest {

    SalleEvaluation salle = new SalleEvaluation();

    @Test
    public void testNumeroSalle() {
        salle.setNumeroSalle("1A");
        assertTrue(new String("1A").equals(salle.getNumeroSalle()));
        assertFalse(new String("2A").equals(salle.getNumeroSalle()));
    }

    @Test
    public void testPostes() {
        PosteTravail poste1 = new PosteTravail();
        PosteTravail poste2 = new PosteTravail();
        poste1.setNumeroPoste("1");
        poste1.setNumeroPoste("2");

        List<PosteTravail> listePostes = new ArrayList<>();
        listePostes.add(poste1);
        listePostes.add(poste2);

        List<PosteTravail> listeVide = new ArrayList<>();

        salle.setPostes(listePostes);
        assertTrue(listePostes.equals(salle.getPostes()));
        assertFalse(listeVide.equals(salle.getPostes()));
    }

    @Test
    public void testPoste() {
        List<PosteTravail> listeVide = new ArrayList<>();
        PosteTravail poste = new PosteTravail();
        PosteTravail posteBidon = new PosteTravail();

        salle.setPostes(listeVide);
        salle.ajouterPoste(poste);
        assertTrue(poste.equals(salle.extrairePoste(0)));
        assertFalse(posteBidon.equals(salle.extrairePoste(0)));
    }
}
