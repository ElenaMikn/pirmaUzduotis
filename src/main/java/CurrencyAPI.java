import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

public interface CurrencyAPI {
    @GET("exchange") //!!!!!!!
    @Headers({"X-Mashape-Key:42c2a66ba4msh8b950e9f6c0b4fap14faa6jsn41370485862c",
            "X-Mashape-Host:currency-exchange.p.rapidapi.com"})
    Call<ExchangeBack> exchange(@Query("q") String q,@Query("from") String from,@Query("to") String to); //???????  @path???

    @GET("exchange?q=1.0&from=EUR&to=BGN") //!!!!!!!
    @Headers({"X-Mashape-Key:42c2a66ba4msh8b950e9f6c0b4fap14faa6jsn41370485862c",
            "X-Mashape-Host:currency-exchange.p.rapidapi.com"})
    Call<ExchangeBack> exchangeS(); //???????  @path???

}

