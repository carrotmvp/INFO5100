package novel.com;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonUtils {

    private GsonUtils() {

    }

    public static <T>T fromJson(FileReader json, Class<User> type){
        Gson gson = new Gson();
        return (T) gson.fromJson(json,type);

    }

    public static <T> List<T> listFromJson(String json, Type type){
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

}
