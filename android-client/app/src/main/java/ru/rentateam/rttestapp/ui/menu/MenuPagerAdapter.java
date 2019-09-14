package ru.rentateam.rttestapp.ui.menu;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import ru.rentateam.rttestapp.ui.menu.combo.ComboFragment;
import ru.rentateam.rttestapp.ui.menu.drinks.DrinksFragment;
import ru.rentateam.rttestapp.ui.menu.pizza.PizzaFragment;
import ru.rentateam.rttestapp.ui.menu.snacks.SnacksFragment;

public class MenuPagerAdapter extends FragmentStatePagerAdapter {

    String[] tabTitles = {"Пицца", "Закуски", "Напитки", "Комбо"};
    Fragment[] fragments = {PizzaFragment.newInstance(), SnacksFragment.newInstance(), DrinksFragment.newInstance(), ComboFragment.newInstance()};


    MenuPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = fragments[i];
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
