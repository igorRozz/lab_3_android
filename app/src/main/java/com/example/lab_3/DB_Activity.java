package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class DB_Activity extends AppCompatActivity {
    private final static String FILE_NAME = "data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_activity);
    }

    @Override
    protected void onStart(){
        super.onStart();
        FileInputStream fin=null;
        TextView textView=(TextView) findViewById(R.id.open_text);

        try{
            fin=openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);

            textView.setText(text);
        }
        catch (IOException ex){
            Toast.makeText(this,"Дані відсутні", Toast.LENGTH_SHORT).show();
        }
        finally {
            {
                try{
                    if(fin!=null)
                        fin.close();
                }
                catch (IOException ex){
                    Toast.makeText(this,ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



}

