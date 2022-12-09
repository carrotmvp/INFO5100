package Interface;

import novel.com.Novel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchList {
    static JFrame SList_frame = new JFrame("Catalog");
    ;

    //@Test
    public static void placeComponents() {
        SList_frame.setBounds(400, 100, 400, 500);
        SList_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        List<Novel> s_List= Search.search_List;
        int num=s_List.size();
        JPanel panel1 = new JPanel();
        JButton BButton = new JButton("<Back");
        panel1.add(BButton);
        BButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Search.Search_frame.setVisible(true);
                SList_frame.setVisible(false);
            }
        });
        JPanel panel = new JPanel();
        //panel.setBounds(100,100,200,200);
        panel.setLayout(new GridLayout(num, 1, 10, 10));

        for(int i=0;i<num;i++){
            String outshow="Name:"+s_List.get(i).getName()+' '+s_List.get(i).getWriter();
            JButton LButton = new JButton(outshow);
            panel.add(LButton);

            int finalI = i;
            LButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NovelShow.placeComponents(s_List.get(finalI));
                    SList_frame.setVisible(false);
                }
            });

        }


        SList_frame.add(panel1, BorderLayout.NORTH);
        SList_frame.add(panel, BorderLayout.CENTER);

        SList_frame.setVisible(true);




    }
}
