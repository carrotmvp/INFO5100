/*
 * Assignment 6
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * class
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 
public class graphical_interface {
    


    static void placeComponents(JPanel panel) {

        weight_grades ans_grade =  new weight_grades();
        
        panel.setLayout(null);

        //Total Assignment points:
        JLabel TAPLabel = new JLabel("Total Assignment points:");
        TAPLabel.setBounds(10,20,200,25);
        panel.add(TAPLabel);
       
        JTextField TAPText = new JTextField(20);
        TAPText.setBounds(250,20,165,25);
        panel.add(TAPText);
        
        
        //Earned Points
        JLabel EPLabel = new JLabel("Earned Points:");
        EPLabel.setBounds(10,50,200,25);
        panel.add(EPLabel);
        
        JTextField EPText = new JTextField(20);
        EPText.setBounds(250,50,165,25);
        panel.add(EPText);
        

        //Percentage on class
        JLabel AsLabel = new JLabel("Percentage on class");
        AsLabel.setBounds(10,80,200,25);
        panel.add(AsLabel);
        
        JTextField AsText = new JTextField(20);
        AsText.setBounds(250,80,165,25);
        panel.add(AsText);
        
        //caculate button
        JButton button = new JButton("caculate");
        button.setBounds(250, 120, 165, 25);
        panel.add(button);

        //place to show the answer
        JLabel Label1 = new JLabel("Weighted Score:");
        Label1.setBounds(10,150,200,25);
        panel.add(Label1);
        
        JLabel AnsLabel = new JLabel("");
        AnsLabel.setBounds(250,150,200,25);
        panel.add(AnsLabel);

        

        //button ActionListener
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ans_grade.setTpoint(Integer.valueOf(TAPText.getText()).intValue());
                ans_grade.setEpoint(Integer.valueOf(EPText.getText()).intValue());
                ans_grade.set_assignment(Integer.valueOf(AsText.getText()).intValue());
                ans_grade.myCaculate();
                AnsLabel.setText(String.valueOf(ans_grade.getAns()));
            }
            
        });
    }

}