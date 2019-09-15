package ru.cretch.app.ui.seecheck;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;

public class SeeCheckActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SeeCheckAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_checksplitter);
        List<ProductModel> data = new ArrayList<>();
        data.add(new ProductModel());
        data.add(new ProductModel());
        data.add(new ProductModel());
        ProductModel[] arr = new ProductModel[data.size()];
        data.toArray(arr);
        mAdapter = new SeeCheckAdapter(arr);

        recyclerView = findViewById(R.id.products_list);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
