package CouchePresentation;


import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationMedecin extends InterfaceUtilisateur{

    String usrname;
    String pwd;
    
    
    JButton submit;

    public ApplicationMedecin() {

        this.setSize(400, 400);
        this.setTitle("Application Medecin");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(e -> connexion(usrname, pwd));

        //
    }
}
