package ru.rentateam.rttestapp;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.rentateam.rttestapp.data.remote.CratchApi;
import ru.rentateam.rttestapp.di.AppComponent;
import ru.rentateam.rttestapp.di.AppModule;
import ru.rentateam.rttestapp.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;
    public AppComponent getComponent(){
        return appComponent;
    }

    protected static App instance;
    public static App getInstance() {
        return instance;
    }

    private CratchApi oppApi;
    public CratchApi getApi() {
        return oppApi;
    }
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = buildComponent();



        retrofit = new Retrofit.Builder()
                .baseUrl("https://backend.lifcar.ru") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
//        backend
        oppApi = retrofit.create(CratchApi.class);
    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}