package Interface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import novel.com.GsonUtils;
import novel.com.Novel;
import novel.com.User;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Registration {
    //public static int UserIDNow=10;
    static List<User> lists=new ArrayList<>();

    private static int s_width=80;
    private static int gap_width=20;
    private static int l_width=500;
    private static int s_height=25;
    private static int l_height=500;

    static JFrame r_frame = new JFrame("Registration");

    //@Test
    public static void placeComponents() {
        r_frame.setSize(300, 300);
        r_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r_frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        r_frame.add(panel);

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
        JTextField Text2 = new JTextField(20);
        Text2.setBounds(10+s_width,20+s_height,(l_width-s_width),s_height);
        Text2.setText("carrot");
        panel.add(Text2);

        JLabel label3=new JLabel("Email:");
        label3.setBounds(10,20+s_height*2,s_width,s_height);
        panel.add(label3);
        JTextField Text3 = new JTextField(20);
        Text3.setBounds(10+s_width,20+s_height*2,(l_width-s_width),s_height);
        Text3.setText("carrot");
        panel.add(Text3);



        JButton Button = new JButton("Registration");
        Button.setBounds(10, 20+s_height*3, l_width,s_height);
        panel.add(Button);


        Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String Rname="User1.json";
                try {
                    getFromJson();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(Rname));
                    String name=Text1.getText();
                    String password=Text2.getText();
                    String email=Text3.getText();
                    User user=new User(name,password,email);
                    if(lists==null){
                        lists=new ArrayList<>();
                        lists.add(user);
                        System.out.println("something");
                    }else lists.add(user);
                    Gson gson = new Gson();
                    String jsonObject = gson.toJson(lists,new TypeToken<List<User>>(){}.getType());
                    //String json = gson.toJson(list, typeToken.getType());
                    System.out.println(jsonObject);
                    writeIntoJson(jsonObject);

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                r_frame.setVisible(false);
                Login.placeComponents();

            }

        });


        r_frame.setVisible(true);
    }

    public static List<User> getLists() {
        try {
            getFromJson();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return lists;
    }

    static void writeIntoJson(String s) throws IOException {
        File file = new File("User1.json");
        if(!file.exists()){
            System.out.println("no file");
            return;
        }
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(s);
        fileWriter.flush();
        fileWriter.close();
    }

    static void getFromJson() throws IOException {
        File file = new File("User1.json");
        if(!file.exists()){
            System.out.println("no file");
            file.createNewFile();
            return;
        }
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte bytes[] = new byte[length];
        inputStream.read(bytes);
        inputStream.close();
        String json =new String(bytes, StandardCharsets.UTF_8);
        //String json= new String(Files.readAllBytes(Paths.get("User.json")));
        System.out.println(json);
        lists = GsonUtils.listFromJson(json,new TypeToken<List<User>>(){}.getType());
        System.out.println(lists.get(0).hashCode());
        System.out.println(lists.get(1).hashCode());

    }


}
