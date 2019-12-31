package com.example.fetchimage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fetchimage.Model.imagefile;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    Context context;
    List<imagefile> imageList;

    public RecyclerAdapter(Context context, List<imagefile> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    public void setImageList(List<imagefile> imageList) {
        this.imageList = imageList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyviewHolder holder, int position) {
        final imagefile imagefile=imageList.get(position);
        holder.tvImageName.setText(imagefile.getImageList());

        Glide.with(context).load(imagefile.getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ImgPreviewActivity.class);
                intent.putExtra("ImageList",imagefile.getImageList());
                intent.putExtra("ImageUrl",imagefile.getImageUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(imageList != null){
            return imageList.size();
        }
        return 0;

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView tvImageName;
        ImageView image;

        public MyviewHolder(View itemView) {
            super(itemView);
            tvImageName = (TextView)itemView.findViewById(R.id.textViewImageName);
            image = (ImageView)itemView.findViewById(R.id.image1);
        }
    }
}