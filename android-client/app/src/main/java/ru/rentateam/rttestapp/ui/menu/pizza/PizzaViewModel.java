package ru.rentateam.rttestapp.ui.menu.pizza;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import ru.rentateam.rttestapp.data.MenuRepository;
import ru.rentateam.rttestapp.data.Result;

public class PizzaViewModel extends ViewModel {

    @Inject
    MenuRepository menuRepository;

    private MutableLiveData<PizzasResult> pizzasResult = new MutableLiveData<>();

    public MutableLiveData<PizzasResult> getPizzasResult() {
        return pizzasResult;
    }


    public void updatePizzasResult(){
        Result result = menuRepository.getPizzas();

        if (result instanceof Result.Success) {
            String[] data = ((Result.Success<String[]>) result).getData();
            PizzaView pizzaView = new PizzaView(data);
            pizzasResult.setValue(new PizzasResult(pizzaView));
        } else {
            pizzasResult.setValue(new PizzasResult((Result.Error) result));
        }
    }
}
