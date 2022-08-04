package CouchePresentation;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CoucheLogique.SystemeDossier;

public class PageConnexion implements ActionListener{

    SystemeDossier sd = new SystemeDossier();

    // Elements interface graphique
    JFrame frame = new JFrame("Connexion Usager");

    JButton bConnexion = new JButton("Connexion");
    JButton bReset = new JButton("Reset");

    JLabel lUsager = new JLabel("Usager");
    JTextField usager = new JTextField();

    JLabel lmotDePasse = new JLabel("Mot de Passe");
    JPasswordField motDePasse = new JPasswordField();

    JLabel resultat = new JLabel();

    public PageConnexion(SystemeDossier systemeDossier) {
        sd = systemeDossier;

        lUsager.setBounds(50, 50, 150, 25);
        lmotDePasse.setBounds(50, 100, 150, 25);

        usager.setBounds(175, 50, 250, 25);
        motDePasse.setBounds(175, 100, 250, 25);

        bConnexion.setBounds(175, 150, 125, 25);
        bConnexion.addActionListener(this);

        resultat.setBounds(125, 200, 250, 35);
        resultat.setFont(new Font(null, Font.PLAIN, 14));

        frame.add(lUsager);
        frame.add(lmotDePasse);
        frame.add(usager);
        frame.add(motDePasse);
        frame.add(bConnexion);
        frame.add(resultat);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bConnexion){

            String usr = usager.getText();
            String pwd = String.valueOf(motDePasse.getPassword());

            if (sd.connexion(usr,pwd)){
                resultat.setText("Connexion Acceptee!!");
            }
            else{
                resultat.setText("Connexion Refusee!!");
            }



        }
    }

}
