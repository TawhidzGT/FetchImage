package Http;

import com.google.gson.JsonElement;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("image_url.json")
    Call<JsonElement> getImages();
}
