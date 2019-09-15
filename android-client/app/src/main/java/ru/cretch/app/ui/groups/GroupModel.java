package ru.cretch.app.ui.groups;

import java.util.Random;
import ru.cretch.app.R;
import ru.cretch.app.model.Group;

public class GroupModel {
    private static Random rnd = new Random();
    public String title, subtitle;
    public Integer largeIcon, mediumItem, smallItem;

    public GroupModel(Group group) {
        this.title = group.name;
        this.subtitle = group.description;
        largeIcon = randomImgId();
        mediumItem = randomImgId();
        smallItem = randomImgId();
    }

    int randomImgId() {
        int id = rnd.nextInt();
        switch (id % 8) {
            case 0: return R.drawable.ic_boy1;
            case 1: return R.drawable.ic_boy2;
            case 2: return R.drawable.ic_girl1;
            case 3: return R.drawable.ic_girl2;
            case 4: return R.drawable.ic_man1;
            case 5: return R.drawable.ic_man2;
            case 6: return R.drawable.ic_man3;
            case 7: return R.drawable.ic_man4;
            default: return R.drawable.ic_man5;
        }
    }
}
