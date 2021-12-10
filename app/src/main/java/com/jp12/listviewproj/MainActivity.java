package com.jp12.listviewproj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textViewer;
    TextView textViewer2;
    ArrayList<String> stockSymbols;
    ArrayList<String> stockNames;
    ArrayList<Double> stockPrices;
    ArrayList<Drawable> stockImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateStockSymbols();
        populateStockNames();
        populateStockPrices();
        populateStockImages();
        listView = findViewById(R.id.id_list_view);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.adapter_custom, stockSymbols);
        listView.setAdapter(customAdapter);
        textViewer = findViewById(R.id.textView);
        textViewer2 = findViewById(R.id.textView2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textViewer.setText("Name: "+stockNames.get(i));
                textViewer2.setText("Price: "+stockPrices.get(i));
            }
        });
    }

    private void populateStockImages() {
        stockImages = new ArrayList<>();
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
        stockImages.add(getDrawable(R.drawable.irbt));
    }

    private void populateStockPrices() {
        stockPrices = new ArrayList<>();
        stockPrices.add(67.96);
        stockPrices.add(34.06);
        stockPrices.add(125.61);
        stockPrices.add(40.25);
        stockPrices.add(64.14);
        stockPrices.add(224.26);
        stockPrices.add(94.22);
        stockPrices.add(59.55);
        stockPrices.add(37.08);
        stockPrices.add(228.49);
        stockPrices.add(45.21);
        stockPrices.add(1146.50);
        stockPrices.add(344.46);
        stockPrices.add(180.55);
        stockPrices.add(238.86);
        stockPrices.add(90.03);
        stockPrices.add(265.21);
        stockPrices.add(152.46);
        stockPrices.add(287.53);
        stockPrices.add(3419.35);
    }

    private void populateStockNames() {
        stockNames = new ArrayList<>();
        stockNames.add("iRobot");
        stockNames.add("Upwork");
        stockNames.add("Fiverr");
        stockNames.add("Redfin");
        stockNames.add("Beyond Meat");
        stockNames.add("Etsy");
        stockNames.add("Teladoc Health");
        stockNames.add("Zillow Group");
        stockNames.add("Pinterest");
        stockNames.add("Roku");
        stockNames.add("Altria Group");
        stockNames.add("MercadoLibre");
        stockNames.add("Intuitive Surgical");
        stockNames.add("Square");
        stockNames.add("Sea Limited");
        stockNames.add("Philip Morris International");
        stockNames.add("salesforce.com");
        stockNames.add("Walt Disney");
        stockNames.add("Berkshire Hathaway B");
        stockNames.add("Amazon");
    }

    private void populateStockSymbols() {
        stockSymbols = new ArrayList<>();
        stockSymbols.add("IRBT");
        stockSymbols.add("UPWK");
        stockSymbols.add("FVRR");
        stockSymbols.add("RDFN");
        stockSymbols.add("BYND");
        stockSymbols.add("ETSY");
        stockSymbols.add("TDOC");
        stockSymbols.add("ZG");
        stockSymbols.add("PINS");
        stockSymbols.add("ROKU");
        stockSymbols.add("MO");
        stockSymbols.add("MELI");
        stockSymbols.add("ISRG");
        stockSymbols.add("SQ");
        stockSymbols.add("SE");
        stockSymbols.add("PM");
        stockSymbols.add("CRM");
        stockSymbols.add("DIS");
        stockSymbols.add("BRK.B");
        stockSymbols.add("AMZN");
    }

    public class CustomAdapter extends ArrayAdapter<String> {
        Context mainActivityContext;
        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            mainActivityContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ImageView imageView;
            TextView textView;

            LayoutInflater layoutInflater = (LayoutInflater) mainActivityContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.adapter_custom, null);
            textView = v.findViewById(R.id.id_adapter_textView);
            textView.setText(stockSymbols.get(position));
            imageView = v.findViewById(R.id.imageView);
            imageView.setImageDrawable(stockImages.get(position));
            return v;
        }
    }
}