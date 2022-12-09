package Interface;

import novel.com.Comment;
import novel.com.Novel;
import novel.com.NovelList;
import novel.com.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static novel.com.Comment.cAddToJson;

public class Judge {

    private JRadioButton notReadRadioButton;
    private JRadioButton readAllRadioButton;
    private JRadioButton readSomeRadioButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton submitButton;
    private JPanel Judge;
    static JFrame frame = new JFrame("Judge");

    public Judge() {

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user=Login.curUser;
                Novel novel= NovelShow.getCurNovel();
                Integer readStatus;
                if(notReadRadioButton.isSelected()){
                    readStatus=0;
                }else if(readAllRadioButton.isSelected()){
                    readStatus=1;
                } else if (readSomeRadioButton.isSelected()) {
                    readStatus=2;
                }else {
                    JOptionPane.showMessageDialog(null,
                            "Error:No read status!", "ERROR", JOptionPane. ERROR_MESSAGE);
                    return;
                }
                Integer rating=Integer.parseInt(textField1.getText());
                if(rating>10||rating<0){
                    JOptionPane.showMessageDialog(null,
                            "Error:Wrong Rating!", "ERROR", JOptionPane. ERROR_MESSAGE);
                    return;
                }
                String c_string=textArea1.getText();
                Comment comment=new Comment(user,novel,readStatus,rating,c_string);
                try {
                    cAddToJson(comment);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(false);

            }
        });
    }

    public static void init() {

        frame.setContentPane(new Judge().Judge);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
    }
}
