package in.vishakak47.www.mynews;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   Button btntrnd,btnworld,btnindia,btnhealth,btnbus,btnsport,btnmov,btntech,btnauto;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbus=findViewById(R.id.btnbus);
        btnhealth=findViewById(R.id.btnhealth);
        btnworld=findViewById(R.id.btnworld);
        btnindia=findViewById(R.id.btnindia);
        btnsport=findViewById(R.id.btnsport);
        btnmov=findViewById(R.id.btnmov);
        btntrnd=findViewById(R.id.btntrnd);
        btnauto=findViewById(R.id.btnauto);
        btntech=findViewById(R.id.btntech);
        btntrnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",1);
                startActivity(i);
            }
        });
        btnworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",2);
                startActivity(i);
            }
        });
        btnsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",3);
                startActivity(i);
            }
        });
        btnbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",4);
                startActivity(i);
            }
        });
        btnmov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",5);
                startActivity(i);
            }
        });
        btnhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",6);
                startActivity(i);
            }
        });
        btnindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",7);
                startActivity(i);
            }
        });
        btntech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",8);
                startActivity(i);
            }
        });
        btnauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,first.class);
                i.putExtra("trend",9);
                startActivity(i);
            }
        });




    }
}
