package novel.com;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Comment {
    private User user;
    private String c_string;
    private Novel novel;
    private Integer readStatus;//0--unread;1--read all;2--read some
    private Integer rating;

    public Comment(User user, Novel novel, Integer readStatus, Integer rating, String c_string){
        this.c_string=c_string;
        this.user=user;
        this.novel=novel;
        this.readStatus=readStatus;
        this.rating=rating;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public String getC_string() {
        return c_string;
    }

    public User getUser() {
        return user;
    }

    public void setC_string(String c_string) {
        this.c_string = c_string;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setReadStatus(Integer readerStatus) {
        this.readStatus = readerStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void cAddToJson(Comment curComment) throws IOException {
        List<Comment> commentList=cGetLists();
        commentList.add(curComment);
        //System.out.println(curComment);
        Gson gson = new Gson();
        String jsonObject = gson.toJson(commentList,new TypeToken<List<Comment>>(){}.getType());
        //String json = gson.toJson(list, typeToken.getType());
        System.out.println(jsonObject);
        System.out.println("jsonpbject");
        cWriteIntoJson(jsonObject);

    }
    public static List<Comment> cGetLists() {
        List<Comment> commentList=new ArrayList<>();
        try {
            commentList=cGetFromJson();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if(commentList==null)commentList=new ArrayList<>();
        return commentList;
    }

    static List<Comment> cGetFromJson() throws IOException {
        List<Comment> commentList;
        File file = new File("CommentList.json");
        if(!file.exists()){
            System.out.println("no file");
            file.createNewFile();
            return new ArrayList<>();
        }
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte bytes[] = new byte[length];
        inputStream.read(bytes);
        inputStream.close();
        String json =new String(bytes, StandardCharsets.UTF_8);
        //String json= new String(Files.readAllBytes(Paths.get("User.json")));
        //System.out.println(json);
        commentList = GsonUtils.listFromJson(json,new TypeToken<List<Comment>>(){}.getType());
        //System.out.println(commentList);
        return commentList;
    }

    static void cWriteIntoJson(String s) throws IOException {
        File file = new File("CommentList.json");
        if(!file.exists()){
            System.out.println("no file");
            return;
        }
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(s);
        fileWriter.flush();
        fileWriter.close();
    }

}
