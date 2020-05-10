package com.wesleyruede.androidarchitecture.model;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;

// Typical RetroFit interface for get method

public interface CountriesApi {
    @GET("all")
    Single<List<Country>> getCountries();
}
