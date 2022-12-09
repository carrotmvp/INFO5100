package Interface;

import novel.com.Novel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class NovelShow {
    static JFrame NS_frame = new JFrame("Catalog");
    private static Novel curNovel;

    public static Novel getCurNovel() {
        return curNovel;
    }

    //@Test
    public static void placeComponents(Novel novel) {
        String address= novel.getAddress();
        curNovel=novel;
        NS_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        NS_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NS_frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        NS_frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(address);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setCaretPosition(0);
        panel.add(textArea);

        //scroll面板
        JScrollPane jScrollPane= new JScrollPane(textArea);

        File file = new File(address);
        //System.out.println(address);
        if(!file.exists()){
            textArea.setText("ERROR: Incorrect address!");
            return;
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int length = inputStream.available();
            byte bytes[] = new byte[length];
            inputStream.read(bytes);
            inputStream.close();
            String s_n=new String(bytes, StandardCharsets.UTF_8);
            System.out.println("s_n");
            //System.out.println(s_n);
            textArea.setText(s_n);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        textArea.setCaretPosition(0);//scroll to the top


        JButton BButton = new JButton("<<Back");
        panel1.add(BButton);
        JButton FButton = new JButton("Smaller");
        //FButton.setEnabled(false);
        panel1.add(FButton);
        JButton NButton = new JButton("Bigger");
        panel1.add(NButton);
        JButton CButton = new JButton("Comment");
        panel1.add(CButton);
//        JTextField jTextField=new JTextField("1000");
//        panel1.add(jTextField);



        BButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchList.SList_frame.setVisible(true);
                NS_frame.setVisible(false);
            }
        });

        NButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font=new Font(textArea.getFont().getName(),
                        textArea.getFont().getStyle(),textArea.getFont().getSize()+1);

                textArea.setFont(font);
//                textArea.setCaretPosition(textArea.getCaretPosition()+Integer.parseInt(jTextField.getText()));
//                FButton.setEnabled(true);

            }
        });

        FButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font=new Font(textArea.getFont().getName(),
                        textArea.getFont().getStyle(),textArea.getFont().getSize()-1);

                textArea.setFont(font);
            }
        });

        CButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Judge judge=new Judge();
                judge.init();
            }
        });



        NS_frame.add(panel1, BorderLayout.NORTH);
        NS_frame.add(jScrollPane, BorderLayout.CENTER);
        //NS_frame.pack();
        NS_frame.setVisible(true);

    }
}
