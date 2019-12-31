package com.example.fetchimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.fetchimage.Model.imagefile;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Http.ApiClient;
import Http.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<imagefile> Blog_List_Response;

    ArrayList<imagefile> image_list = new ArrayList<>();

    ApiInterface apiInterface = ApiClient.getBaseClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(getApplicationContext(),image_list);
        recyclerView.setAdapter(recyclerAdapter);

        loadImages();

    }

    private void loadImages()
    {
        Call<JsonElement> call = apiInterface.getImages();
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    if (response.isSuccessful() && response.code() == 200) {
                        Gson gson = new Gson();
                        Type listType = new TypeToken<List<imagefile>>() {
                        }.getType();
                        Blog_List_Response = gson.fromJson(response.body(), listType);
                        if (Blog_List_Response.size() > 0) {
                            image_list.addAll(Blog_List_Response);
                            Log.d("check", image_list.toString());
                            recyclerAdapter.setImageList(image_list);
                        }

                    }
                } catch (Exception ex) {
                    //Log.d("check", Log.getStackTraceString(ex));
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                // Log.d("check", t.toString());
            }
        });
    }

}
