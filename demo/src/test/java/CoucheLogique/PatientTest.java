package CoucheLogique;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {

    Patient patient = new Patient();

    @Test
    public void testGenre() {
        patient.setGenre("homme");
        assertTrue(new String("homme").equals(patient.getGenre()));
        assertFalse(new String("femme").equals(patient.getGenre()));
    }

    @Test
    public void testCoord() {
        Coordonnees coordsPatient = new Coordonnees();
        coordsPatient.setCourriel("patient@test.io");
        coordsPatient.setTelephone("123-123-1234");
        coordsPatient.setAdresse("450 chemin du golfe");

        Coordonnees coordsDoublon = new Coordonnees();
        coordsPatient.setCourriel("patient@test.io");
        coordsPatient.setTelephone("123-123-1234");
        coordsPatient.setAdresse("450 chemin du golfe");

        patient.setCoords(coordsPatient);
        assertFalse(coordsPatient.equals(coordsDoublon));
        assertTrue(coordsPatient.equals(coordsPatient));
    }
}