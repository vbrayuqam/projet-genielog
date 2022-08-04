package CouchePresentation;

import CoucheLogique.SystemeDossier;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PageConnexion {

    SystemeDossier sd;

    // Elements interface graphique
    JFrame page = new JFrame("Connexion Usager");

    JButton bConnexion = new JButton("Connexion");
    JButton bReset = new JButton("Reset");

    JLabel lUsager = new JLabel("Usager");
    JTextField usager = new JTextField();

    JLabel lmotDePasse = new JLabel("Mot de Passe");
    JPasswordField motDePasse = new JPasswordField();

    JLabel resultat = new JLabel();

    public PageConnexion(SystemeDossier systemeDossier) {

        sd = systemeDossier;

        // Creation de l'interface graphique
        lUsager.setBounds(50, 50, 150, 25);
        lmotDePasse.setBounds(50, 100, 150, 25);

        usager.setBounds(175, 50, 250, 25);
        motDePasse.setBounds(175, 100, 250, 25);

        bConnexion.setBounds(175, 150, 125, 25);
        bConnexion.addActionListener(e -> {
            String usr = usager.getText();
            String pwd = String.valueOf(motDePasse.getPassword());

            if (sd.connexion(usr, pwd)) {
                resultat.setText("Connexion Acceptee!!");
                page.dispose();
                ApplicationMedecin appMed = new ApplicationMedecin(sd);
            } else {
                resultat.setText("Connexion Refusee!!");
            }
        });

        resultat.setBounds(125, 200, 250, 35);
        resultat.setFont(new Font(null, Font.PLAIN, 14));

        page.add(lUsager);
        page.add(lmotDePasse);
        page.add(usager);
        page.add(motDePasse);
        page.add(bConnexion);
        page.add(resultat);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setSize(500, 300);
        page.setLayout(null);
        page.setVisible(true);

    }

}
