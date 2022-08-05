package CoucheLogique;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


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

        PosteTravail[] postes = new PosteTravail[2];
        postes[0] = poste1;
        postes[1] = poste2;

        salle.setPostes(postes);
        assertArrayEquals(postes, salle.getPostes());
    }
}
