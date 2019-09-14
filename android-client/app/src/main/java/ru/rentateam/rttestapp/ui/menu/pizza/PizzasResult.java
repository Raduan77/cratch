package ru.rentateam.rttestapp.ui.menu.pizza;

import androidx.annotation.Nullable;

import ru.rentateam.rttestapp.data.Result;

public class PizzasResult {



    @Nullable
    private PizzaView success;
    @Nullable
    private Result.Error error;

    public PizzasResult(@Nullable Result.Error error) {
        this.error = error;
    }

    public PizzasResult(@Nullable PizzaView success) {
        this.success = success;
    }

    @Nullable
    public PizzaView getSuccess() {
        return success;
    }

    @Nullable
    public Result.Error getError() {
        return error;
    }



}
