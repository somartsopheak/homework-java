package com.example.myhw5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.HashMap;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
//        String cities[] ={"PhnomPenh", "KompongSom", "SiemReap", "Kompong"};
        String cities[] = getProvinceName();
        String longView[] = getLong();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // TODO Auto-generated method stub


                String selectedProvice = (String) listView.getItemAtPosition(position);
                Location location = loadLocationsData().get(selectedProvice);

                Toast.makeText(getApplicationContext(), location.toString(), Toast.LENGTH_LONG).show();

//                Intent intent = new Intent(MainActivity.this, ListMenu.class);
//                intent.putExtra("select", selectedProvice);

//                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.addnew:
//                showAddNew();
//                return true;
//            case R.id.search:
//                showSearch();
//                return true;
//            case R.id.setting:
//                showsetting();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//    private void showAddNew(){
//        CharSequence text = "This is an Add New";
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(getApplicationContext(),text, duration);
//        toast.show();
//    }
//    private void showSearch(){
//        CharSequence text = "This is an Search";
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(getApplicationContext(),text, duration);
//        toast.show();
//    }
//    private void showsetting(){
//        CharSequence text = "This is an Settings";
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(getApplicationContext(),text, duration);
//        toast.show();
//    }




    private HashMap<String, Location> loadLocationsData (){
        HashMap<String, Location> locations = new HashMap<>();

        locations.put("phnompenh" , new Location(11.5564,104.9282));
        locations.put("sihanoukville", new Location( 10.627543,103.522141));
        locations.put("Kampot", new Location(10.594242,104.164032));
        locations.put("SiemReap", new Location(13.364047,103.860313));
        locations.put("Battambang", new Location(13.028697,102.989616));
        locations.put("KampongCham", new Location(11.99339,105.4635));
        locations.put("KampongChhnang", new Location(12.25,104.66667));
        locations.put("KampongThom", new Location(12.71112,104.88873));
        locations.put("KohKong", new Location(11.61531,102.9838));
        locations.put("Kep", new Location(10.48291,104.31672));
        locations.put("PreyVeng", new Location(11.48682,105.32533));
        locations.put("Takeo", new Location(10.99081,104.78498));
        locations.put("Pursat", new Location(12.53878,103.9192));
        locations.put("Mondolkiri", new Location( 12.45583,107.18811));
        locations.put("StungTreng", new Location(13.52586,105.9683));
        locations.put("SvayRieng", new Location( 11.08785,105.79935));
        locations.put("PreahVihear", new Location(13.80731,104.98046));
        locations.put("Kandal", new Location(11.48333,104.95));
        locations.put("BanteayMeanchey", new Location(13.58588,102.97369));
        locations.put("Ratanakiri", new Location( 13.73939,106.98727));
        locations.put("KampongSpeu", new Location(11.45332,104.52085));
        locations.put("Kratie", new Location(12.48811,106.01879));
        locations.put("Pailin", new Location( 12.84895,102.60928));
        locations.put("OddarMeanchey", new Location(14.18175,103.51761));
        locations.put("TbongKhmum", new Location( 11.8891,105.8760));
        return locations;

    }


    private String[] getProvinceName (){
        String[] provinces = new String[loadLocationsData().size()];
        provinces = loadLocationsData().keySet().toArray(provinces);
        return provinces;
    }

    private String[] getLong (){
        String[] Long = new String[loadLocationsData().size()];
        Long = loadLocationsData().keySet().toArray(Long);
        return Long;
    }

}