package com.example.ecommerce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class Adapter extends android.support.v7.widget.RecyclerView.Adapter<Adapter.myViewHolder> {
    Context mContext;
    List<item> mData;

    public class myViewHolder extends ViewHolder {
        ImageView owner_image;
        ImageView shop_image;
        TextView shop_name;
        TextView shop_rating;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.owner_image = (ImageView) itemView.findViewById(R.id.shop_owner_image);
            this.shop_image = (ImageView) itemView.findViewById(R.id.card_shop_background);
            this.shop_name = (TextView) itemView.findViewById(R.id.shop_name);
            this.shop_rating = (TextView) itemView.findViewById(R.id.shop_rating);
        }
    }

    public Adapter(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        myViewHolder.shop_image.setImageResource(((item) this.mData.get(i)).getShopbackground());
        myViewHolder.owner_image.setImageResource(((item) this.mData.get(i)).getOwnerphoto());
        myViewHolder.shop_name.setText(((item) this.mData.get(i)).getShopname());
        TextView textView = myViewHolder.shop_rating;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((item) this.mData.get(i)).getRating());
        stringBuilder.append(" Stars");
        textView.setText(stringBuilder.toString());
    }

    @NonNull
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_item, viewGroup, false));
    }
}
