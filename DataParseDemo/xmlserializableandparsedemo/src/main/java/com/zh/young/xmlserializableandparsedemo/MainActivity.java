package com.zh.young.xmlserializableandparsedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    private EditText xmlStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xmlStream = (EditText) findViewById(R.id.xml_demo);
    }

    public void parse(View view){
        String string = xmlStream.getText().toString();
        StringBufferInputStream stream = new StringBufferInputStream(string);
        try {
            string = XmlUtil.xmlParse(stream);
            xmlStream.setText(string);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            Toast.makeText(this, "xml形式异常", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "IO异常", Toast.LENGTH_SHORT).show();
        }
    }
}
