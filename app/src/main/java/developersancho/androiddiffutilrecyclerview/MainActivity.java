package developersancho.androiddiffutilrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnUpdate;
    RecyclerView recyclerView;
    List<String> datasource = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnInsert = findViewById(R.id.btnInsertData);
        btnUpdate = findViewById(R.id.btnUpdateData);

        initData();
        adapter = new MyAdapter(datasource);
        recyclerView.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> insertList = new ArrayList<>();
                for (int i = 0; i < 3; i++)
                    insertList.add(UUID.randomUUID().toString());
                adapter.insertData(insertList);
                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> updateList = new ArrayList<>();
                for (int i = 0; i < 3; i++)
                    updateList.add(UUID.randomUUID().toString());
                adapter.updateData(updateList);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 3; i++)
            datasource.add(UUID.randomUUID().toString());
    }
}
