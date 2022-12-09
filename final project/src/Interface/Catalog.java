package Interface;

import novel.com.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Catalog {

    static JFrame Cat_frame=new JFrame("Catalog");;
    //@Test
    public static void placeComponents() {
        Cat_frame.setBounds(400,100,400, 500);
        Cat_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        //panel.setBounds(100,100,200,200);
        panel.setLayout(new GridLayout(4,1,10,10));

        JButton LButton = new JButton("Catalog");
        LButton.setEnabled(false);
        panel.add(LButton);

        JButton SButton = new JButton("Search");
        panel.add(SButton);

        JButton IButton = new JButton("Import");
        panel.add(IButton);

        JButton CButton = new JButton("Comment");
        panel.add(CButton);

        Cat_frame.add(panel);

        SButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Search.placeComponents();
                Cat_frame.setVisible(false);
            }
        });

        IButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Import.placeComponents();
                Cat_frame.setVisible(false);
            }
        });

        CButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentShow commentShow=new CommentShow();
                commentShow.init();
                Cat_frame.setVisible(false);
            }
        });




        Cat_frame.setVisible(true);

    }

}
