package ru.rentateam.rttestapp.ui.checksplitter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.rentateam.rttestapp.R;

public class CheckSplitterFragment extends Fragment {

    private RecyclerView recyclerView;
    private CheckSplitterAdapter mAdapter;

    public static CheckSplitterFragment newInstance() {
        return new CheckSplitterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        List<ProductModel> data = new ArrayList<>();
        data.add(new ProductModel());
        data.add(new ProductModel());
        data.add(new ProductModel());
        ProductModel[] arr = new ProductModel[data.size()];
        data.toArray(arr);
        mAdapter = new CheckSplitterAdapter(arr);
        return inflater.inflate(R.layout.fragment_checksplitter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.products_list);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

}
