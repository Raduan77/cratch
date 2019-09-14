package ru.rentateam.rttestapp.ui.menu.pizza;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.rentateam.rttestapp.App;
import ru.rentateam.rttestapp.R;

public class PizzaFragment extends Fragment {

    private PizzaViewModel mViewModel;

    private RecyclerView recyclerView;
    private PizzaAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] tabTitles = {"Пицца", "Закуски", "Напитки", "Комбо"};

    public static PizzaFragment newInstance() {
        return new PizzaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pizza, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this).get(PizzaViewModel.class);
        App.getInstance().getComponent().inject(mViewModel);

        assert getActivity()!=null;
        recyclerView = getActivity().findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new PizzaAdapter(tabTitles);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.updatePizzasResult();
        mViewModel.getPizzasResult().observe(this, pizzasResult -> {
            if (pizzasResult == null)
                return;


            if (pizzasResult.getSuccess()!=null){
                mAdapter.setDataset(pizzasResult.getSuccess().items);
            }

            if (pizzasResult.getError()!=null){
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Ошибка")
                        .setMessage(pizzasResult.getError().getErrorMessage());
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewModel.getPizzasResult().removeObservers(this);
        if (mViewModel.getPizzasResult().getValue()!=null && mViewModel.getPizzasResult().getValue().getError()!=null){
            mViewModel.getPizzasResult().setValue(null);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
