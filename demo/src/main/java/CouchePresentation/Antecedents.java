package CouchePresentation;
import CoucheLogique.SystemeDossier;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

public class Antecedents {

    SystemeDossier sd;
    // Elements interface graphique
    JFrame page = new JFrame("Antecedents");
    JLabel lAntecedents = new JLabel("Antecedents");

    public Antecedents(SystemeDossier systemeDossier, String assuranceM){
        sd = systemeDossier;

        page.add(lAntecedents);
        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setSize(700, 700);
        page.setLayout(new GridLayout(2, 1));
        page.pack();
        page.setVisible(true);
    }
    
}
