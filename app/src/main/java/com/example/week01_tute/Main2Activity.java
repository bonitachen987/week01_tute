package com.example.week01_tute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;

    private static final String TAG = "Main2Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mName = findViewById(R.id.tvName);
        mSymbol = findViewById(R.id.tvSymbol);
        mValue = findViewById(R.id.tvValueField);
        mChange1h = findViewById(R.id.tvChange1hField);
        mChange24h = findViewById(R.id.tvChange24hField);
        mChange7d = findViewById(R.id.tvChange7hField);
        mMarketcap = findViewById(R.id.tvMarketcapField);
        mVolume = findViewById(R.id.tvVolumeField);
        mSearch = findViewById(R.id.ivSearch);


        Intent intent = getIntent();
        String coinSymbol = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.i(TAG, "Coin Symbol = " + coinSymbol);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        ArrayList<Coin> coins = Coin.getCoins();

        //first method
        //final Coin coin = Coin.searchCoin(coinSymbol);

        final Coin coin = Coin.getCoins().get(0);
        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());
        mValue.setText(formatter.format(coin.getValue()));
        mChange1h.setText((coin.getChange1h()) + "%" );
        mChange24h.setText((coin.getChange24h()) + "%");
        mChange7d.setText((coin.getChange7d()) + "%");
        mMarketcap.setText(formatter.format(coin.getMarketcap()));
        mVolume.setText(formatter.format(coin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(coin.getName());

            }
            private void searchCoin(String name) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?qm" + name));
                startActivity(intent);
            }
        });











        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //mDetailMessage = findViewById(R.id.tvDetailMessage);
       // mDetailMessage.setText(message);

       // mShowVideoButton = findViewById(R.id.btnShowVideo);
       // mShowVideoButton.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
                //showVideo("https://www.youtube.com/watch?v=TklUIoHkxp0");
          //  }
        //});



   // }
    //private void showVideo(String url){
     //   Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
       // startActivity(intent);
    }
}
