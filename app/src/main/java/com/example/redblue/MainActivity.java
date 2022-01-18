package com.example.redblue;
/**
 * Created by Harsh Ahuja on 18/01/22.
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private  Button submit_btn;
    private int data;
    private RecyclerView recyclerView;
    private Boolean prev = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit_btn = findViewById(R.id.submit_btn);
        input = findViewById(R.id.input);
        recyclerView = findViewById(R.id.recycler);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data =Integer.parseInt(input.getText().toString());
                putdatainRecycler(data,prev);
                prev =!prev;
            }
        });

    }

    private void putdatainRecycler(int data,Boolean prev) {
        Adapter adapter = new Adapter(this,data,prev);
        LinearLayoutManager manager = new LinearLayoutManager(this) {
            @Override
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted(state);

            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }




}