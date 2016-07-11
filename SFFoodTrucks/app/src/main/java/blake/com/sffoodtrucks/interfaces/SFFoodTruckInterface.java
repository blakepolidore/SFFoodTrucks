package blake.com.sffoodtrucks.interfaces;

import blake.com.sffoodtrucks.models.FoodTruckRoot;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Raiders on 7/11/16.
 */
public interface SFFoodTruckInterface {

    @GET("bbb8-hzi6.json")
    Call<FoodTruckRoot[]> getFoodTrucks();
}
