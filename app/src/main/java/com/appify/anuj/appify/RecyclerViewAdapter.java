package com.appify.anuj.appify;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewBolder>{
    private Context mcontext;
    private List<Anime> mData;
    RequestOptions option;
    public RecyclerViewAdapter(Context mcontext,List<Anime> mData) {
        this.mcontext = mcontext;
        this.mData=mData;
        option=new RequestOptions().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewBolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view=inflater.inflate(R.layout.anime_row_item,viewGroup,false);

        final MyViewBolder viewBolder1=new MyViewBolder(view);
        viewBolder1.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mcontext, AnimeActivity.class);
                i.putExtra("anime_name",mData.get(viewBolder1.getAdapterPosition()).getApp_name());
                i.putExtra("anime_icon",mData.get(viewBolder1.getAdapterPosition()).getIcon());
                i.putExtra("anime_desc",mData.get(viewBolder1.getAdapterPosition()).getDescription());
                i.putExtra("anime_ss1",mData.get(viewBolder1.getAdapterPosition()).getSs3());
                i.putExtra("anime_ss2",mData.get(viewBolder1.getAdapterPosition()).getSs2());
                i.putExtra("anime_ss3",mData.get(viewBolder1.getAdapterPosition()).getSs3());
                i.putExtra("anime_apk",mData.get(viewBolder1.getAdapterPosition()).getApk());

                mcontext.startActivity(i);
            }
        });

        return viewBolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewBolder myViewBolder, int i) {
        myViewBolder.t1.setText(mData.get(i).getApp_name());

        Glide.with(mcontext).load(mData.get(i).getIcon()).apply(option).into(myViewBolder.thumbnil);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewBolder extends RecyclerView.ViewHolder{
        ImageView thumbnil;
        TextView t1;
        LinearLayout l1;
        public MyViewBolder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.anime_name);
            thumbnil=(ImageView) itemView.findViewById(R.id.thumbnail);
            l1=(LinearLayout)itemView.findViewById(R.id.container);
        }
    }
}
