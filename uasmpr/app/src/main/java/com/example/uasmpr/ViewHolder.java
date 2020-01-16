package com.example.uasmpr;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder{
    View mView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
//        item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view,getAdapterPosition());
            }
        });
//        item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view,getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx,String name,String detail,String image){
        TextView mName = mView.findViewById(R.id.name);
        TextView mDetail = mView.findViewById(R.id.detail);
        ImageView mImage = mView.findViewById(R.id.image);

        mName.setText(name);
        mDetail.setText(detail);
        Picasso.get().load(image).into(mImage);
    }

    private ViewHolder.ClickListener mClickListener;
    //    interface untuk mengirim callback
    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}