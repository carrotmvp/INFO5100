package Interface;
//E:\novel\flipped.txt
import novel.com.Novel;
import novel.com.NovelList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class Import {
     static JFrame Import_frame = new JFrame("Import");
    //@Test
    public static void placeComponents() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        Import_frame.setLayout(new BorderLayout());


        //panel.setLayout(null);
        Import_frame.setSize(500, 300);
        panel1.setLayout(new GridLayout(5,2,10,10));
        //panel1.setSize(500,500);


        JLabel Label1=new JLabel("Novel Name:",JLabel.CENTER);
        JLabel Label2=new JLabel("Writer:",JLabel.CENTER);
        JLabel Label3=new JLabel("Category:",JLabel.CENTER);
        JLabel Label4=new JLabel("Address",JLabel.CENTER);
        //JLabel Label5=new JLabel("Category:",JLabel.CENTER);

        JTextField textField1=new JTextField();
        JTextField textField2=new JTextField();
        JTextField textField3=new JTextField();
        JTextField textField4=new JTextField();

        JTextArea textArea = new JTextArea("");
        textArea.setMargin(new Insets(20, 20, 20, 20));
        //textArea.setSize(400,350);
        textArea.setLineWrap(true);
        panel.add(textArea);

        panel1.add(Label1);
        panel1.add(textField1);
        panel1.add(Label2);
        panel1.add(textField2);
        panel1.add(Label3);
        panel1.add(textField3);
        panel1.add(Label4);
        panel1.add(textField4);

        JButton BButton = new JButton("<Back");
        panel1.add(BButton);
        JButton IButton = new JButton("Import");
        panel1.add(IButton);

        BButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Catalog.Cat_frame.setVisible(true);
                Import_frame.setVisible(false);
            }
        });

        IButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=textField1.getText();
                String writer=textField2.getText();
                String address=textField4.getText();

                LinkedList<String> category=category_string_list(textField3.getText());
                LinkedList<Integer> bookmark=new LinkedList<>();

                if(name.isBlank()){
                    textArea.setText("ERROR: Please input the novel's name!");
                    return;
                }
                if(writer.isBlank()){
                    textArea.setText("ERROR: Please input the novel's writer!");
                    return;
                }
                if(address.isBlank()){
                    textArea.setText("ERROR: Please input the novel's address!");
                    return;
                }

                File file = new File(address);
                //System.out.println(address);
                if(!file.exists()){
                    textArea.setText("ERROR: Please input the correct address!");
                    return;
                }

                try {
                    NovelList.addToJson(name,writer,address,category,bookmark);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String s_out="Name:"+name+'\n'+"Writer:"+writer+'\n'+"Import Success!";
                textArea.setText(s_out);
            }
        });

        Import_frame.add(panel1, BorderLayout.CENTER);
        Import_frame.add(panel, BorderLayout.EAST);
        //Import_frame.pack();
        Import_frame.setVisible(true);
        Import_frame.setLocationRelativeTo(null);
    }

    public static LinkedList<String> category_string_list(String s){
        LinkedList<String> category=new LinkedList<>();
        if(s.isBlank())return category;
        String[] ss=s.split(",");
        for (int i = 0; i < ss.length; i++) {
            category.add(ss[i]);
        }
        return category;

    }

}
