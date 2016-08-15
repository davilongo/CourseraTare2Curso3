package com.coursera.david.courseratarea2curso3;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edNombre, edTelefono, edEmail, edDescripcion;
    Button siguiente;
    String nombre, email, telefono, descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = (EditText)findViewById(R.id.nombre);
        edTelefono = (EditText)findViewById(R.id.telefono);
        edEmail = (EditText)findViewById(R.id.email);
        edDescripcion = (EditText)findViewById(R.id.descripcion);
        siguiente = (Button)findViewById(R.id.btnSiguiente);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String Bnombre = extras.getString("nombre");
            String Btelefono = extras.getString("telefono");
            String Bemail = extras.getString("email");
            String Bdescripcion = extras.getString("descripcion");

            edNombre.setText(Bnombre);
            edTelefono.setText(Btelefono);
            edEmail.setText(Bemail);
            edDescripcion.setText(Bdescripcion);

        }







        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nombre = edNombre.getText().toString();


                telefono = edTelefono.getText().toString();
                email = edEmail.getText().toString();
                descripcion = edDescripcion.getText().toString();

                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                i.putExtra("nombre", nombre);
                i.putExtra("telefono", telefono);
                i.putExtra("email", email);
                i.putExtra("descripcion", descripcion);
                startActivity(i);
            }
        });




    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"picker");
    }


}
