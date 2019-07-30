package c346.rp.edu.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnG0;
    Spinner sp1;
    Spinner sp2;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnG0 = findViewById(R.id.buttonGO);
        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);

        alCategory = new ArrayList<>();

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //Your code for item 1 selected
                        alCategory.clear();
                        String[] strCategory1 = getResources().getStringArray(R.array.spinner_cat2);
                        alCategory.addAll(Arrays.asList(strCategory1));

                        break;
                    case 1:
                        //Your code for item 2 selected
                        alCategory.clear();
                        String[] strCategory2 = getResources().getStringArray(R.array.spinner_cat3);
                        alCategory.addAll(Arrays.asList(strCategory2));
                        break;
                }

                aaCategory.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnG0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = sp2.getSelectedItem().toString();
                String url = "";
                Intent intent = new Intent(getBaseContext(), WebPage.class);




                if (choice.equals("Homepage")){
                    intent.putExtra("url", "https://www.rp.edu.sg/");

                } else if (choice.equals("Student Life")){
                    intent.putExtra("url", "https://www.rp.edu.sg/student-life");

                } else if (choice.equals("DMSD")){
                    intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");

                } else {
                    intent.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");

                }

                startActivity(intent);
            }
        });

        aaCategory = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, alCategory);
        sp2.setAdapter(aaCategory);
    }
}
