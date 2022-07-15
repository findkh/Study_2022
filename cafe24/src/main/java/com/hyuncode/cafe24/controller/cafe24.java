package com.hyuncode.cafe24.controller;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController 
public class cafe24 {
  private final String cliendId = "클라이언트아이디";
  private final String clientSecretKey = "클라이언트시크릿키";

  private OkHttpClient okHttpClient = new OkHttpClient.Builder()
      .readTimeout(90, TimeUnit.SECONDS)
      .build();

  Gson gson = new GsonBuilder()
      .setLenient()
      .create();

  private Retrofit cafe24Rest = new Retrofit.Builder()
      .baseUrl("https://아이디.cafe24api.com/api/v2/")
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .build();
  OauthCode conn2 = cafe24Rest.create(OauthCode.class);
  //ConnectToCafe24 conn = cafe24Rest.create(ConnectToCafe24.class);



  @RequestMapping(value="/getAuthorizeCode")
  public String getAuthorizeCode(Code code) {
    Encoder encoder = Base64.getEncoder();
    String response_type = "code";
    String Authorization = "Basic " + new String(encoder.encode((cliendId+":"+clientSecretKey).getBytes()));
    String grant_type = "authorization_code";
    String client_id = "클라이언트아이디";
    String scope = "mall.read_category,mall.read_product,mall.read_collection,mall.read_supply,mall.read_personal,mall.read_order,mall.read_community,mall.read_customer,mall.read_notification,mall.read_store,mall.read_promotion,mall.read_design,mall.read_salesreport,mall.read_shipping";
    String redirect_uri = "https://mdaida.cafe24.com/";

    try {
      //Response<Map<String,Object>> result = conn.getAccessCode(Authorization,grant_type,code.getCode(),redirect_uri).execute();
      System.out.println(conn2.getOauthCode(response_type,client_id,redirect_uri,scope).toString());

      Response<Map<String,Object>> result = conn2.getOauthCode(response_type,client_id,redirect_uri,scope).execute();
      System.out.println(result);

      if(result.errorBody()!=null) {
        System.out.println("error : "+result.errorBody().string());
        return "{\"isSucess\":\"false\"}";
      }
      //System.out.println("result : " + result.body());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return "{\"isSucess\":\"true\"}";
  };

} 

