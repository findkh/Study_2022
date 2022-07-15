package com.hyuncode.cafe24.controller;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OauthCode {
  @GET("oauth/authorize")
  public Call<Map<String,Object>> getOauthCode(
      @Query("response_type") String response_type,
      @Query("client_id") String client_id,
      @Query("redirect_uri") String redirect_uri,
      @Query("scope") String scope

      );
}
