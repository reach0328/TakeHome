package com.jpark.takehome.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JH on 2017-04-13.
 */

public abstract class ServiceWrapper {
    public abstract Observable<List<UserModel>> getUsersRx();

    public abstract Call<List<UserModel>> getUsers() ;

    interface UserApiRx {
        @GET("users")
        Observable<List<UserModel>> getUsers();
    }
    interface UserApi {
        @GET("users")
        Call<List<UserModel>> getUsers();
    }
}
