package com.malang.bangash.customlistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;


public class MainActivity extends ActionBarActivity {
    TextView tvName;
    ListView lvItmes;
    Button btnDelete;
    ImageView ivShow;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow=(TextView)findViewById(R.id.tvShow);
        ivShow = (ImageView) findViewById(R.id.ivShow);
        ivShow.setVisibility(View.INVISIBLE);
        tvShow.setVisibility(View.INVISIBLE);
        //tvName=(TextView)findViewById(R.id.tvName);
        lvItmes = (ListView) findViewById(R.id.lvItmes);
        String arr[] = {"Pakistan", "Afghanistan", "Russia"};
        int[] images = {R.drawable.logo, R.drawable.download, R.drawable.im};
        CustomListViewAdapter adapter = new CustomListViewAdapter(MainActivity.this, arr, images);
        //  btnDelete=(Button)findViewById(R.id.Delete);
        lvItmes.setAdapter(adapter);
        ivShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivShow.setVisibility(View.INVISIBLE);
            }
        });
        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvShow.setVisibility(View.INVISIBLE);
            }
        });

    }

    private class CustomListViewAdapter extends ArrayAdapter<String> {


        Context context;
        String data[];
        int images[];

        public CustomListViewAdapter(Context context, String data[], int i[]) {


            super(context, R.layout.row_item, data);
            this.context = context;
            this.data = data;
            this.images = i;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.row_item, parent, false);
            TextView tvName = (TextView) v.findViewById(R.id.tvName);
            tvName.setText(data[position]);
            btnDelete = (Button) v.findViewById(R.id.Delete);
            ImageView iv = (ImageView) v.findViewById(R.id.iv);
            iv.setImageResource(images[position]);
            tvName.setTextColor(Color.RED);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ivShow.setImageResource(images[position]);
                    ivShow.setVisibility(View.VISIBLE);
                }
            });
          tvName.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  tvShow.setText(data[position]);
                  tvShow.setVisibility(View.VISIBLE);
              }
          });


            return v;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
