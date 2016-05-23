package org.swchalu.retrofitexample.service;

import android.database.Observable;

import org.swchalu.retrofitexample.model.LoginCallback;
import org.swchalu.retrofitexample.model.SZTCallback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by swc12 on 2016/5/16 0016.
 */
public interface ApiService {
    @GET("login.do")
    Call<LoginCallback> getLoginCallback(@Query("reqCode") String reqCode, @Query("username") String username, @Query("password") String password, @Query("checkcode") String checkcode);

    @GET("login.do")
    Call<SZTCallback> getSZTBalance(@Query("reqCode") String reqCode, @Query("sztid") String sztid);

    @GET("login.do")
    Observable<SZTCallback> _getSZTBalance(@Query("reqCode") String reqCode, @Query("sztid") String sztid);

}
