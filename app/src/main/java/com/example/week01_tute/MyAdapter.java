package com.example.week01_tute;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.text.NumberFormat;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CoinViewHolder> {
    private ArrayList<Coin> mCoins;
    private RecyclerViewClickListener mListener;

    public MyAdapter(ArrayList<Coin> coins, RecyclerViewClickListener listener) {
        mCoins = coins;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class CoinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, value, change;
        private RecyclerViewClickListener mListener;

        public CoinViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.tvName);
            value = v.findViewById(R.id.tvValue);
            change = v.findViewById(R.id.tvChange);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public MyAdapter.CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_list_row, parent, false);
        return new CoinViewHolder(v, mListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CoinViewHolder holder, int position) {
        Coin coin = mCoins.get(position);
        holder.name.setText(coin.getName());
        holder.value.setText(NumberFormat.getCurrencyInstance().format(coin.getValue()));
        holder.change.setText(String.valueOf(coin.getChange1h()) + " %");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mCoins.size();
    }
}
