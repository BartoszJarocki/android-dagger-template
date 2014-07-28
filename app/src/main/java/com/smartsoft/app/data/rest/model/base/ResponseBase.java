package com.smartsoft.app.data.rest.model.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bartoszjarocki on 6/30/13. 545 98 58
 */
public class ResponseBase<T> {
    @SerializedName("statusCode")
    public int errorCode;

    @SerializedName("errorString")
    public String errorString;

    @SerializedName("data")
    public T data;
}
