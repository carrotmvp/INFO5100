package Interface;

import novel.com.Comment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static novel.com.Comment.cGetLists;

public class CommentShow {
    static JFrame frame = new JFrame("CommentShow");
    private JPanel CommentShow;
    private JList list1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton searchButton;
    private JButton backButton;
    private JScrollPane scrollPane;

    public CommentShow() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getShowList();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Catalog.Cat_frame.setVisible(true);
            }
        });
    }

    public void init() {
        frame.setContentPane(new CommentShow().CommentShow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,150,800,500);
        //frame.setLocationRelativeTo(null);
        //frame.setSize(800,500);
        getShowList();

        //frame.pack();
        frame.setVisible(true);

                //this.list1.setVisibleRowCount(3);





    }

    public void getShowList(){

        String name=textField1.getText();
        String writer=textField2.getText();
        List<Comment> commentList=cGetLists();
        DefaultListModel commonShow = new DefaultListModel();
        int cnt=0;
        if(name.isBlank()&&writer.isBlank())
        {
            cnt=commentList.size();
            for(int i=0;i<commentList.size();i++){
                String line=commentList.get(i).getUser().getName()+" TO "+
                        commentList.get(i).getNovel().getName()+" : "+
                        commentList.get(i).getRating()+ "♥\n"+
                        commentList.get(i).getC_string();
                //System.out.println(line);
                commonShow.addElement(line);
            }
        }
        else {
            for(int i=0;i<commentList.size();i++){
                if((name.isBlank()||name.equals(commentList.get(i).getNovel().getName()))&&
                        (writer.isBlank()||writer.equals(commentList.get(i).getNovel().getWriter()))){
                    String line=commentList.get(i).getUser().getName()+" TO "+
                            commentList.get(i).getNovel().getName()+" : "+
                            commentList.get(i).getRating()+ "♥\n"+
                            commentList.get(i).getC_string();
                    //System.out.println(line);
                    commonShow.addElement(line);
                    cnt++;
                }
            }
        }

        if(cnt==0)commonShow.addElement("No comment = =");

        this.list1.setModel(commonShow);

    }
}
