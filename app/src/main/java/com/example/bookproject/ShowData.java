package com.example.bookproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowData extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        listView=findViewById(R.id.datashowlist);
        Intent i=getIntent();


        HashMap<String,String> dataset=(HashMap<String, String>) i.getSerializableExtra("data");
        Log.e("testing",dataset.toString());


        ArrayList<String> keylist = new ArrayList<>(dataset.keySet());
        ArrayList<String> datalist=new ArrayList<>();
        for(int j=0;j<keylist.size();j++){
            datalist.add(dataset.get(keylist.get(j)));
        }


        ArrayList<dataset> mylist=new ArrayList<>();
        for(int p=0;p<keylist.size();p++){
            mylist.add(new dataset(keylist.get(p),datalist.get(p)));
        }


        arrayAdapter adapter=new arrayAdapter(this,mylist);

        listView.setAdapter(adapter);

    }
    private class dataset{
        private String title;
        private String body;

        public dataset(String title,String body){
            this.title=title;
            this.body=body;
        }
    }
    private class arrayAdapter extends ArrayAdapter<dataset>{

        public arrayAdapter(Context context, ArrayList<dataset> users) {
            super(context, 0, users);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            dataset dataset=getItem(position);
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.dataview, parent, false);
            }
            TextView title=convertView.findViewById(R.id.titile);
            TextView body=convertView.findViewById(R.id.body);
            title.setText(dataset.title);
            body.setText(dataset.body);
            return convertView;
        }
    }
}
