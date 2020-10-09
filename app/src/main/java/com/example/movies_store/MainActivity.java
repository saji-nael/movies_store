package com.example.movies_store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.movies_store.model.IMovieDa;
import com.example.movies_store.model.Movie;
import com.example.movies_store.model.MovieFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText result;
    private Spinner cat;
    private EditText title;
    private EditText year;
    static int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        cat = findViewById(R.id.cat);
        fillSpinner();
        title = findViewById(R.id.title);
        year = findViewById(R.id.year);
        //invisible all views
        cat.setVisibility(View.GONE);
        title.setVisibility(View.GONE);
        year.setVisibility(View.GONE);

    }

    public void fillSpinner() {
        List<String> userList = new ArrayList<>();
        userList.add("Action");
        userList.add("Fantasy");
        userList.add("Horror");
        userList.add("Romance");
        userList.add("Animation");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat.setAdapter(adapter);
    }


    public void btnSearchByCategory(View view) {
        result.setText("");
        //visible cat
        cat.setVisibility(View.VISIBLE);
        title.setVisibility(View.GONE);
        year.setVisibility(View.GONE);
        x = 1;
    }

    public void btnSearchByTitle(View view) {
        result.setText("");
        cat.setVisibility(View.GONE);
        //visible title
        title.setVisibility(View.VISIBLE);
        year.setVisibility(View.GONE);
        x = 2;
    }

    public void btnSearchByYear(View view) {
        result.setText("");
        cat.setVisibility(View.GONE);
        title.setVisibility(View.GONE);
        //visible year
        year.setVisibility(View.VISIBLE);
        x = 3;
    }

    public void btnSearch(View view) {
        switch (x) {
            case 1: {
                //clear data in edittext
                result.setText("");
                year.setText("");
                title.setText("");
                //get the data
                MovieFactory factory = new MovieFactory();
                IMovieDa movies = factory.getModel();
                //get the movie that searched by their category
                List<Movie> res = movies.getMovieByCategory(cat.getSelectedItem().toString());
                String str = "";

                for (Movie m : res) {
                    str += m.getMovieTitle().trim() + "\n";
                }
                //show the result
                result.setText(str);
                Toast.makeText(getApplicationContext(), "Movies=" + res.size(), Toast.LENGTH_SHORT).show();
                break;
            }
            case 2: { //clear data in edittext
                result.setText("");
                year.setText("");
                //get the data
                MovieFactory factory = new MovieFactory();
                IMovieDa movies = factory.getModel();


                if (title.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Title", Toast.LENGTH_SHORT).show();
                } else { //get the movie that searched by their title
                    List<Movie> res = movies.getMovieByTitle(title.getText().toString().trim());
                    String str = "";

                    for (Movie m : res) {
                        str += m.getMovieTitle().trim() + "\n";
                    }

                    //show the result
                    result.setText(str);
                    Toast.makeText(getApplicationContext(), "Movies=" + res.size(), Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case 3: { //clear data in edittext
                result.setText("");
                title.setText("");
                //get the data
                MovieFactory factory = new MovieFactory();
                IMovieDa movies = factory.getModel();
                //get the movie that searched by their year

                if (year.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Year" , Toast.LENGTH_SHORT).show();
                } else {
                    List<Movie> res = movies.getMovieByYear(Integer.parseInt(year.getText().toString().trim()));
                    String str = "";

                    for (Movie m : res) {
                        str += m.getMovieTitle().trim() + "\n";
                    }
                    //show the result
                    result.setText(str);
                    Toast.makeText(getApplicationContext(), "Movies=" + res.size(), Toast.LENGTH_SHORT).show();
                }

                break;
            }
        }
    }
}