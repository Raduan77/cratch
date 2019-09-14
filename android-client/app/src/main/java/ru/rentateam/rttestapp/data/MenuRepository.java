package ru.rentateam.rttestapp.data;

import javax.inject.Inject;

import static ru.rentateam.rttestapp.model.ErrorCode.*;

public class MenuRepository {

    private Result connectionError = new Result.Error(CONNECTION_ERROR, "Не удалось подключиться к серверу");
    private Result incorrectDataError = new Result.Error(INCORRECT_DATA, "Получены некорректные данные");


    private static final String TAG = "MenuRepository";
    private MenuDataSource menuDataSource;


    @Inject
    public MenuRepository(MenuDataSource menuDataSource){
        this.menuDataSource = menuDataSource;
    }


    public Result getPizzas(){
        Result result;

        String[] pizzas = menuDataSource.getPizzas();
        if (pizzas!=null && pizzas.length>0){
            result = new Result.Success<>(pizzas);
        } else {
            result = incorrectDataError;
        }

        return result;
    }

}
