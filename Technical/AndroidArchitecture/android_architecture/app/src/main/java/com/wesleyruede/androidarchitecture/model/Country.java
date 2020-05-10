package com.wesleyruede.androidarchitecture.model;
import com.google.gson.annotations.SerializedName;

// Get just the name from the BASE_URL json array

public class Country {
    @SerializedName("name")
    public String countryName;
}
