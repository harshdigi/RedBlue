package com.example.redblue;
/**
 * Created by Harsh Ahuja on 18/01/22.
 */
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    int input;
    Boolean prev;
    private Context context;

    public Adapter( Context context, int input, Boolean prev) {
        this.context = context;
        this.input = input;
        this.prev =prev;
    }

    @NonNull
    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.item, parent, false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.AdapterViewHolder holder, int position) {
        if(prev){
       if(position%2==0){
           holder.layout.setBackgroundColor(Color.RED);

       }
       else{
           holder.layout.setBackgroundColor(Color.BLUE);
       }}
        else{
            if(position%2!=0){
                holder.layout.setBackgroundColor(Color.RED);

            }
            else{
                holder.layout.setBackgroundColor(Color.BLUE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return input;
    }

    public class AdapterViewHolder  extends  RecyclerView.ViewHolder{
        ConstraintLayout layout;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
