package Interface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import novel.com.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    static List<User> lists=new ArrayList<>();

    private static int s_width=80;
    private static int gap_width=20;
    private static int l_width=500;
    private static int s_height=25;
    private static int l_height=500;

    static JFrame login_frame = new JFrame("Login");
    static User curUser;

    //@Test
    public static void placeComponents() {
        //login_frame = new JFrame("Login");
        login_frame.setSize(300, 150);
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        login_frame.add(panel);

        JLabel label1=new JLabel("User Name:");
        label1.setBounds(10,20,s_width,s_height);
        panel.add(label1);
        JTextField Text1 = new JTextField(20);
        Text1.setBounds(10+s_width,20,(l_width-s_width),s_height);
        Text1.setText("carrot");
        panel.add(Text1);

        JLabel label2=new JLabel("Password:");
        label2.setBounds(10,20+s_height,s_width,s_height);
        panel.add(label2);
        JPasswordField Text2 = new JPasswordField(20);
        Text2.setBounds(10+s_width,20+s_height,(l_width-s_width),s_height);
        Text2.setText("carrot");
        panel.add(Text2);

        JButton LButton = new JButton("Login");
        LButton.setBounds(10, 20+s_height*2, l_width,s_height);
        panel.add(LButton);
        JButton Button = new JButton("Registration");
        Button.setBounds(10, 20+s_height*3, l_width,s_height);
        panel.add(Button);



        LButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                List<User> users = Registration.getLists();
                String name=Text1.getText();
                String password=Text2.getText();
                boolean flag1=false;
                for(int i=0;i<users.size();i+=1){
                    if(users.get(i).getName().equals(name)){
                        if(users.get(i).getPassword().equals(password)){
                            flag1=true;
                            System.out.println("Login Success!");
                            curUser=users.get(i);
                            Catalog.placeComponents();
                            login_frame.setVisible(false);
                            return;
                        }
                    }
                }
                if(flag1==false){
                    System.out.println("Login Error!");
                }
            }

        });

        Button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                login_frame.setVisible(false);
                Registration.placeComponents();
            }

        });


        login_frame.setVisible(true);
        login_frame.setLocationRelativeTo(null);
    }

}
