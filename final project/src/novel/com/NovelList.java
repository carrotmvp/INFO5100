package novel.com;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class NovelList {
    public Integer id=10;
    private static List<Novel> novelList=new ArrayList<>();

    @Test
    public static void addToJson(
            String name, String writer, String Address, LinkedList<String> category, LinkedList<Integer> bookmark
    ) throws IOException {
        Novel novel = new Novel(name,writer,Address,category,bookmark);
        getLists1();
        novelList.add(novel);
        System.out.println(novelList);
        Gson gson = new Gson();
        String jsonObject = gson.toJson(novelList,new TypeToken<List<Novel>>(){}.getType());
        //String json = gson.toJson(list, typeToken.getType());
        System.out.println(jsonObject);
        System.out.println("jsonpbject");
        writeIntoJson1(jsonObject);

    }
    public static List<Novel> getLists1() {
        try {
            getFromJson1();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if(novelList==null)novelList=new ArrayList<>();
        return novelList;
    }

    static void getFromJson1() throws IOException {
        File file = new File("NovelList.json");
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
        novelList = GsonUtils.listFromJson(json,new TypeToken<List<Novel>>(){}.getType());
        System.out.println(novelList);


    }

    static void writeIntoJson1(String s) throws IOException {
        File file = new File("NovelList.json");
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
