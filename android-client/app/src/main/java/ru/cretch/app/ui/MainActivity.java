package ru.cretch.app.ui;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;

import ru.cretch.app.R;
import ru.cretch.app.ui.checksplitter.CheckSplitterFragment;
import ru.cretch.app.ui.groups.GroupsFragment;
import ru.cretch.app.ui.meetups.MeetupsFragment;
import ru.cretch.app.ui.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private static final String MENU_TAG = "MENU";
    private static final String PROFILE_TAG = "PROFILE";
    private static final String BASKET_TAG = "BASKET";

    private final FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment menu = GroupsFragment.newInstance();
    private Fragment profile = MeetupsFragment.newInstance();
    private Fragment history = ProfileFragment.newInstance();

    private Fragment currentFragment = menu;
    private String currentTag = MENU_TAG;



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment newFragment;

        switch (menuItem.getItemId()) {
            case R.id.navigation_menu:
                newFragment = menu;
                currentTag = MENU_TAG;
                break;
            case R.id.navigation_basket:
                newFragment = profile;
                currentTag = PROFILE_TAG;
                break;
            case R.id.navigation_profile:
            default:
                newFragment = history;
                currentTag = BASKET_TAG;
                break;
        }

        if (!currentFragment.isResumed()){
            return false;
        }

        replaceFragment(newFragment);


        Log.d(TAG, "onNavigationItemSelected: " + fragmentManager.getFragments().size());

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        getFragments();
        replaceFragment(currentFragment);
    }

    private void getFragments(){
        for (Fragment fragment: fragmentManager.getFragments()){
            assert fragment.getTag() != null;
            switch (fragment.getTag()){
                case MENU_TAG:
                    menu = fragment;
                    currentFragment = menu;
                    currentTag = MENU_TAG;
                    break;
                case BASKET_TAG:
                    history = fragment;
                    currentFragment = history;
                    currentTag = BASKET_TAG;
                    break;
                default:
                case PROFILE_TAG:
                    profile = fragment;
                    currentFragment = profile;
                    currentTag = PROFILE_TAG;
                    break;
            }
        }
    }


    private void replaceFragment(Fragment newFrag){
        if (!newFrag.isAdded()){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.container, newFrag, currentTag).commitAllowingStateLoss();
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.detach(currentFragment);
        transaction.attach(newFrag);
        transaction.commit();

        currentFragment = newFrag;
    }
}
