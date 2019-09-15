package ru.rentateam.rttestapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class UserInfoResponse implements Serializable{

    @SerializedName("user")
    public User user;
}


//    "code": "1",
//    "client": {
//        "id": 20,
//        "phone": "79653855126",
//        "name": null,
//        "middle_name": null,
//        "surname": null,
//        "email": null,
//        "status": "NEW"
//    },
//    "codeMessage": "структура клиента"