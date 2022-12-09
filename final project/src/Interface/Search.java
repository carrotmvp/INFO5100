package Interface;

import novel.com.Novel;
import novel.com.NovelList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Search {

    static JFrame Search_frame = new JFrame("Search");
    static List<Novel> search_List=new ArrayList<>();
    //@Test
    public static void placeComponents() {
        //JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        //panel.setLayout(null);
        Search_frame.setBounds(400,100,400, 300);

        panel1.setLayout(new GridLayout(4,2,10,10));


        JLabel Label1=new JLabel("Novel Name:",JLabel.CENTER);
        JLabel Label2=new JLabel("Writer:",JLabel.CENTER);
        JLabel Label3=new JLabel("Category:",JLabel.CENTER);

        JTextField textField1=new JTextField();
        JTextField textField2=new JTextField();
        JTextField textField3=new JTextField();

        panel1.add(Label1);
        panel1.add(textField1);
        panel1.add(Label2);
        panel1.add(textField2);
        panel1.add(Label3);
        panel1.add(textField3);

        JButton BButton = new JButton("<Back");
        panel1.add(BButton);
        JButton SButton = new JButton("Search");
        panel1.add(SButton);

        BButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Catalog.Cat_frame.setVisible(true);
                Search_frame.setVisible(false);

            }
        });

        SButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Novel> CurrList=NovelList.getLists1();
                String name=textField1.getText();
                String writer=textField2.getText();
                String category=textField3.getText();
                for (int i = 0; i < CurrList.size(); i++) {
                    if(name.isBlank()||CurrList.get(i).getName().equals(name)){
                        if(writer.isBlank()||CurrList.get(i).getWriter().equals(writer)){
                            if(category.isBlank()&&(!name.isBlank()||!writer.isBlank())){
                                search_List.add(CurrList.get(i));
                            }else if(!category.isBlank()){
                                LinkedList<String> cList=CurrList.get(i).getCategory();
                                for (int j = 0; j < cList.size(); j++) {
                                    if(cList.get(j).equals(category)){
                                        search_List.add(CurrList.get(i));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(search_List);
                if(search_List.size()<1)
                {
                    JOptionPane.showMessageDialog(null, "Error:No novel!", "Can't find X(", JOptionPane. ERROR_MESSAGE);
                }
                else {
                    SearchList.placeComponents();
                }




                Search_frame.setVisible(false);

            }
        });

        //Search_frame.add(panel);
        Search_frame.add(panel1);
        Search_frame.setVisible(true);
    }


}
