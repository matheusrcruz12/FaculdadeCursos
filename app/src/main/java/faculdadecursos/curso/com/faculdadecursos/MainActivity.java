package faculdadecursos.curso.com.faculdadecursos;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.LinkedList;

public class MainActivity extends Activity {

    CursoList cursos = new CursoList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cursos.getCursos();

        List<String> faculdades = cursos.returnAllFaculdades();


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, faculdades);

        final Spinner spinnerFaculdade = findViewById(R.id.spnFaculdade);

        final Spinner spinnerCurso = findViewById(R.id.spnCurso);

        spinnerFaculdade.setAdapter(adapter);

        spinnerFaculdade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedFaculdade = String.valueOf(spinnerFaculdade.getSelectedItem());

                List<String> cursoNomes = cursos.returnCursosByFaculdade(selectedFaculdade);

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, cursoNomes);


                spinnerCurso.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

            }

        });

        spinnerCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedFaculdade = String.valueOf(spinnerFaculdade.getSelectedItem());
                String selectedCurso = String.valueOf(spinnerCurso.getSelectedItem());

                String result = cursos.returnResumos(selectedFaculdade, selectedCurso);

                TextView resultArea = findViewById(R.id.result);

                resultArea.setText(result);

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

}
