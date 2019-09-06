package vip.kratos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vip.kratos.serivce.NetService;

import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Value("${DOMAIN:}")
    private String domain;

    @RequestMapping(value = {"/", ""})
    public String index() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.format("http://net%s:9090", !StringUtils.isEmpty(domain) ? ("." + domain) : ""))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetService service = retrofit.create(NetService.class);

        return "hello java" + ", and " + service.hello().execute().body();
    }
}
