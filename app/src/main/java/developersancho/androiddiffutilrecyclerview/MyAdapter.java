package developersancho.androiddiffutilrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> dataSource;

    public MyAdapter(List<String> dataSource) {
        this.dataSource = dataSource;
    }

    public void insertData(List<String> insertList) {
        MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(dataSource, insertList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        dataSource.addAll(insertList);
        diffResult.dispatchUpdatesTo(this);
    }

    public void updateData(List<String> newList) {
        MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(dataSource, newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        dataSource.clear();
        dataSource.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.myTextView.setText(dataSource.get(i));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.my_text_view);
        }
    }
}
