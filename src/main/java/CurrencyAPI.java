import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface CurrencyAPI {


    @GET("json/")
    Call<List<ExchangeBack>> exchange(@Query("info") String name);

}

