/*
 * Assignment 7
 * [hu yaqi]
 * [002771356]
 * [section 8]
 * class
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField; 
public class graphical_interface {

    private static int s_width=80;
    private static int gap_width=20;
    private static int l_width=500;
    private static int m_height=25;
    private static int l_height=500;

    static void placeComponents(JPanel panel) {

        
        panel.setLayout(null);

        //read file part
        JLabel TAPLabel = new JLabel("File Name:");
        TAPLabel.setBounds(10,20,s_width,m_height);
        panel.add(TAPLabel);
       
        JTextField TAPText = new JTextField(20);
        TAPText.setBounds(10+s_width,20,(l_width-s_width),m_height);
        TAPText.setText("annual.csv");
        panel.add(TAPText);
        
        JButton Rbutton = new JButton("read from file");
        Rbutton.setBounds(10, 50, l_width,m_height);
        panel.add(Rbutton);

        JLabel Label1 = new JLabel("First five lines of file:");
        Label1.setBounds(10,80,l_width,m_height);
        panel.add(Label1);
        
        JTextArea AnsLabel = new JTextArea("");
        AnsLabel.setBounds(10,110,l_width,l_height);
        AnsLabel.setLineWrap(true);
        panel.add(AnsLabel);
        
        //write to file part
        JLabel WLabel = new JLabel("File Name:");
        WLabel.setBounds(10+l_width+gap_width,20,s_width,m_height);
        panel.add(WLabel);
       
        JTextField WText = new JTextField(20);
        WText.setBounds(10+s_width+l_width+gap_width,20,(l_width-s_width),m_height);
        WText.setText("example.csv");
        panel.add(WText);
        
        JButton Wbutton = new JButton("write into the file");
        Wbutton.setBounds(10+l_width+gap_width, 50, l_width,m_height);
        panel.add(Wbutton);

        JLabel Label2 = new JLabel("First five lines of the new file:");
        Label2.setBounds(10+l_width+gap_width,80,l_width,m_height);
        panel.add(Label2);
        
        JTextArea showText = new JTextArea("");
        showText.setBounds(10+l_width+gap_width,110,l_width,l_height);
        showText.setLineWrap(true);
        panel.add(showText);

        

        //Rbutton ActionListener
        Rbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                AnsLabel.setText("");
                String  Rname=TAPText.getText();
                //create BufferedReader to read csv file
            
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new FileReader(Rname));
                    
                        int num=0;
                        String line = null; 
                        while((line=reader.readLine())!=null&&num<5){ 
                        num++;
                        AnsLabel.setText(AnsLabel.getText()+line+"\n");
                        System.out.println(line); 
                    } 
                    } catch (IOException e1) {
                        AnsLabel.setText("Wrong file name!");
                        e1.printStackTrace();
                    }
                
            }
            
        });

        //Wbutton ActionListener
        Wbutton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                showText.setText("");
                String  Rname=WText.getText();
                //create BufferedReader to read csv file
                File csv = new File(Rname); // new file
                
                BufferedWriter bw;//new file
                BufferedReader reader;//annual.csv
                try {
                    bw = new BufferedWriter(new FileWriter(csv, true));
                    reader = new BufferedReader(new FileReader("annual.csv"));
                    String line = null; 
                    int num=0;//to print first five lines
                    while((line=reader.readLine())!=null){ 
                        String item[] = line.split(",");//seperate by ,
                        String last = item[0]+','+item[1]+','+item[2]+'\n';
                        bw.write(last);
                        if(num<5){
                            num++;
                            showText.setText(showText.getText()+last);
                        }
                    }
                    bw.close();
                } catch (IOException e2) {
                    showText.setText("Something wrong");
                    e2.printStackTrace();
                }           
                               
                
            }
            
        });

        


    }

}