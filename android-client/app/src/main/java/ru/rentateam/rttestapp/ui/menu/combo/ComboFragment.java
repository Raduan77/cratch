package ru.rentateam.rttestapp.ui.menu.combo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.rentateam.rttestapp.R;

public class ComboFragment extends Fragment {

    public static ComboFragment newInstance() {
        return new ComboFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_combo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name = view.findViewById(R.id.name);
        assert getContext()!=null;
        String nameText = getContext().getResources().getString(R.string.base_fragment_name, getClass().getSimpleName());
        name.setText(nameText);
    }
}
