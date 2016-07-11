package blake.com.sffoodtrucks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import blake.com.sffoodtrucks.interfaces.SFFoodTruckInterface;
import blake.com.sffoodtrucks.models.FoodTruckRoot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SFFoodTruckInterface sfFoodTruckInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeRetrofitCall();
    }

    private void makeRetrofitCall() {
        Retrofit retrofitFoodTrucks = new Retrofit.Builder()
                .baseUrl("https://data.sfgov.org/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sfFoodTruckInterface = retrofitFoodTrucks.create(SFFoodTruckInterface.class);
        Call<FoodTruckRoot[]> call = sfFoodTruckInterface.getFoodTrucks();
        call.enqueue(new Callback<FoodTruckRoot[]>() {
            @Override
            public void onResponse(Call<FoodTruckRoot[]> call, Response<FoodTruckRoot[]> response) {
                Log.d("onResponse", response.body()[0].getLatitude() + "");
            }

            @Override
            public void onFailure(Call<FoodTruckRoot[]> call, Throwable t) {
                Log.d("onFailure", "failed");
            }
        });
    }
}
