package com.coursera.david.courseratarea2curso3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView txtNombre, txtTelefono, txtFecha, txtEmail, txtDescripcion;
    Button btnEditar;
    String nombre, descripcion, email, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtTelefono = (TextView)findViewById(R.id.txtTelefono);
        txtFecha = (TextView)findViewById(R.id.txtFecha);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtDescripcion = (TextView)findViewById(R.id.txtDescripcion);
        btnEditar = (Button)findViewById(R.id.btnEditar);

        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        telefono = extras.getString("telefono");
        email = extras.getString("email");
        descripcion = extras.getString("descripcion");

        txtNombre.setText(nombre);
        txtTelefono.setText(telefono);
        txtEmail.setText(email);
        txtDescripcion.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ConfirmarDatos.this, MainActivity.class);
                i.putExtra("nombre", nombre);
                i.putExtra("telefono", telefono);
                i.putExtra("email", email);
                i.putExtra("descripcion", descripcion);
                startActivity(i);
            }
        });

    }
}
