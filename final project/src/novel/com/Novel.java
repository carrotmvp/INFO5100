package novel.com;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class Novel {

    private Integer id;
    private String name;
    private String address;
    private String writer;
    private LinkedList<String> category=new LinkedList<String>();
    private LinkedList<Integer> bookmark=new LinkedList<Integer>();

    Novel(String name,String writer,String address,LinkedList<String> category,LinkedList<Integer> bookmark) throws IOException {
        File file = new File("NovelID.json");
        String s;
        if(!file.exists()){
            file.createNewFile();
            s="0";
            id=0;
            System.out.println("no file");
        }
        else {
            FileInputStream inputStream = new FileInputStream("NovelID.json");
            int length = inputStream.available();
            byte bytes[] = new byte[length];
            inputStream.read(bytes);
            inputStream.close();
            s =new String(bytes, StandardCharsets.UTF_8);
            id=Integer.parseInt(s)+1;
            s = (id)+"";
            System.out.println(s);
            inputStream.close();
        }
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write(s);
        fileWriter.flush();
        fileWriter.close();
        //this.id=id;
        this.name=name;
        this.address=address;
        this.writer=writer;
        this.category=category;
        this.bookmark=bookmark;
    }

    public LinkedList<Integer> getBookmark() {
        return bookmark;
    }

    public LinkedList<String> getCategory() {
        return category;
    }

    public Integer getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBookmark(LinkedList<Integer> bookmark) {
        this.bookmark = bookmark;
    }

    public void setCategory(LinkedList<String> category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }



}
