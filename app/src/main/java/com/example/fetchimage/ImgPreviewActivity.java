package com.example.fetchimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fetchimage.Model.imagefile;

public class ImgPreviewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    String imgName,imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_preview);
        imageView=findViewById(R.id.image1);
        textView=findViewById(R.id.textViewImageName);
        imgName=getIntent().getStringExtra("ImageList");
        imgUrl=getIntent().getStringExtra("ImageUrl");
        textView.setText(imgName);
        Log.d("er1",imgName+"  "+imgUrl);
        Glide.with(this).load(imgUrl).apply(RequestOptions.centerCropTransform()).into(imageView);
    }
}
