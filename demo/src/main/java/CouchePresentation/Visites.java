package CouchePresentation;
import CoucheLogique.SystemeDossier;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

public class Visites {

    SystemeDossier sd;
    // Elements interface graphique
    JFrame page = new JFrame("Visites");

    JLabel lVisites = new JLabel("VISITES");

    public Visites(SystemeDossier systemeDossier, String assuranceM){
        sd = systemeDossier;

        page.add(lVisites);
        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setSize(700, 700);
        page.setLayout(new GridLayout(2, 1));
        page.pack();
        page.setVisible(true);
    }
}
