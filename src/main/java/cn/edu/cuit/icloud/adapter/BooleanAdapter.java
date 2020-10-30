package cn.edu.cuit.icloud.adapter;

import java.io.IOException;

import org.apache.http.util.TextUtils;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月18日
 */
public class BooleanAdapter extends TypeAdapter<Boolean>{

    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value);
        }
    }
 
    @Override
    public Boolean read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case STRING:
                return toBoolean(in.nextString());
            default:
                throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + peek);
        }
    }
 
    /**
     * true  TURE 都为true
     * "0" 为 false
     * "1" 为 true
     * @param name
     * @return
     */
    public static boolean toBoolean(String name) {
        if (TextUtils.isEmpty(name)){
            return false;
        }else{
            if (name.equalsIgnoreCase("on")){
                return true;
            }else if (name.equalsIgnoreCase("off")){
                return false;
            }else if (name.equals("1")){
                return true;
            }else if (name.equals("0")){
                return false;
            }
        }
        return false;
    }
    
    
}
