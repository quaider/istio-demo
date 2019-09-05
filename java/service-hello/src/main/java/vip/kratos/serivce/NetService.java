package vip.kratos.serivce;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetService {

    @GET("/hello")
    public Call<String> hello();

}
