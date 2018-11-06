package com.github.reneweb.androidasyncsocketexamples;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    // Added by Oom
    private TextView status;
    private EditText IPAddress,Port,Message;
    ListView listView;
    private static MainActivity instance;
    List<String> list = new ArrayList<String>();

    private String ipAdd,portString;
    private int port;

    //////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IPAddress = (EditText)findViewById(R.id.ip);
        Port = (EditText)findViewById(R.id.port);           // BM
        Message = (EditText)findViewById(R.id.message);         // BM
        status = (TextView) findViewById(R.id.status);
        instance = this;


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
//          TCP client and server (Client will automatically send welcome message after setup and server will respond)
//                new com.github.reneweb.androidasyncsocketexamples.tcp.Server("localhost", 7000);
//                new com.github.reneweb.androidasyncsocketexamples.tcp.Client("localhost", 7000);
//          UDP client and server (Here the client explicitly sends a message)
//                new com.github.reneweb.androidasyncsocketexamples.udp.Server("localhost", 7001);
//                new com.github.reneweb.androidasyncsocketexamples.udp.Client("localhost", 7001).send("Hello World");


                 //////////  Added by Oom ///////////
//                try {
//                    new com.github.reneweb.androidasyncsocketexamples.tcp.Server("10.10.186.197", 7000);
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }


//
//passed                 System.out.println("on Create B ");
                return null;
            }
        }.execute();
    }



    public void onClick(View v) {
//passed         System.out.println("Hello onClick Yeah !!! ");
        ipAdd = IPAddress.getText().toString();
//passed         System.out.println(ipAdd);
        portString = Port.getText().toString();
        port = Integer.parseInt(portString);
//passed         System.out.println(ipAdd + port);
        new com.github.reneweb.androidasyncsocketexamples.tcp.Client(ipAdd,port);
//passed         System.out.println(ipAdd + port);
        status.setText("connect");
//        value = txtName.getText().toString();
//        try {
//            new com.github.reneweb.androidasyncsocketexamples.tcp.Server(value, 7000);
//            status.setText("recieved !");
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }


///////////////////////////// Add //////////////////////////

    public static MainActivity getInstance() {
        return instance;
    }
    @Override
    protected void onStop(){
        super.onStop();
    }
    protected void onDestroy(){
        super.onDestroy();
    }
    public void ClickProcess(View view) {
        Message = (EditText) findViewById(R.id.message);
        final String msg = Message.getText().toString();
        list.add(0,msg);
        IPAddress = (EditText) findViewById(R.id.ip);
        final String ip = IPAddress.getText().toString();
        Port = (EditText) findViewById(R.id.port);
        final int prt = Integer.parseInt(Port.getText().toString());
//passed         System.out.println(ip + prt + msg + "///////////////");

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                new com.github.reneweb.androidasyncsocketexamples.tcp.Client(ip, prt ,msg);
 //passed               System.out.println(ip + " and" + prt);
                return null;
            }
        }.execute();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(itemsAdapter);
        Message.setText("");
    }
////////////////////////////////////////////////////////////////////////////////////////////////////







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        System.out.println("EiEi  onCreateOptionsMenu 88888888888 ");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("EiEi  onOptionsItemSelected 88888888888 ");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
