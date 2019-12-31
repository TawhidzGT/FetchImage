package com.example.fetchimage.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class imagefile {

    @SerializedName("ImageList")
    @Expose
    private String ImageList;
    @SerializedName("ImageUrl")
    @Expose
    private String ImageUrl;

    public void setImageList(String imageList) {
        ImageList = imageList;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageList() {
        return ImageList;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    @Override
    public String toString() {
        return "imagefile{" +
                "ImageList='" + ImageList + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                '}';
    }
}
