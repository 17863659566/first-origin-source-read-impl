package com.zh.young.xmlserializableandparsedemo;

import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class XmlUtil {

    public static String xmlParse(InputStream origin) throws XmlPullParserException, JSONException, IOException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(origin,"utf-8");

        JSONArray jsonArray = null;

        int type = parser.getEventType();
        while(type != XmlPullParser.END_DOCUMENT){
            JSONObject object = null;
            if(type == XmlPullParser.START_DOCUMENT){
                jsonArray = new JSONArray();
            }
            else if(type == XmlPullParser.START_TAG){
                object = new JSONObject();
            }
            else if(type == XmlPullParser.TEXT){
                object.put("username",parser.getText());
            }
            else if(type == XmlPullParser.END_TAG){
                jsonArray.put(object);
            }

            type = parser.next();

        }

        return jsonArray.toString();
    }


    public static String XmlSerializable() throws IOException {
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        serializer.setOutput(writer);

        serializer.startDocument("utf-8",true);

        serializer.startTag(null,"start");
        serializer.text("hello");
        serializer.endTag(null,"end");

        serializer.endDocument();

        return writer.toString();
    }

}
