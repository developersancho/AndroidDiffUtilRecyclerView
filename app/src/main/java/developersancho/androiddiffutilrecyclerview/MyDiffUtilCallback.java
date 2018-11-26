package developersancho.androiddiffutilrecyclerview;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class MyDiffUtilCallback extends DiffUtil.Callback {

    private List<String> oldList;
    private List<String> newList;

    public MyDiffUtilCallback(List<String> oldList, List<String> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldPosition, int newPosition) {
        return oldPosition == newPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition) {
        return oldList.get(oldPosition) == newList.get(newPosition);
    }
}
