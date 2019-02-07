import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
//import retrofit2.http.Query;
import retrofit2.http.Path;

import java.util.List;

public interface CardsAPI {
    @GET("cards/{name}") //!!!!!!!
    @Headers({"X-Mashape-Key:x0hUDU7DhCmshRVICp9yc0BE0LQtp1CVXM0jsn9p2F2pQnLPbH",
            "X-Mashape-Host:omgvamp-hearthstone-v1.p.mashape.com"})
    Call<List<CardBack>> getCardBacks(@Path("name") String p); //???????  @path???
}