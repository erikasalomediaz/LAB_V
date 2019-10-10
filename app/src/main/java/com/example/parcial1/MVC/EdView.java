package com.example.parcial1.MVC;

import android.widget.Button;
import android.widget.EditText;

import com.example.parcial1.R;

public class EdView {
    EditText etNombre;
    EditText etCantidad;
  EditText etPrecio;
    Button btn;
     EdModel modelo;
    EditActivity mac;
    EdController c;
    public EdView(EdModel modelo, EditActivity mac, EdListener listener,EdController c){
        this.c = c;
        this.mac = mac;
        this.etNombre = (EditText) mac.findViewById(R.id.etNombre);
        this.etCantidad = (EditText) mac.findViewById(R.id.etCantidad);
        this.etPrecio = (EditText) mac.findViewById(R.id.etPrecio);
        this.btn = (Button)mac.findViewById(R.id.btnEditar);

        this.btn.setOnClickListener(listener);
        this.modelo = modelo;
        //aca le seteo el dato que ya tiene cargado
        this.etNombre.setText(this.modelo.getNombre());
        this.etPrecio.setText(this.modelo.getPrecio() + "");
        this.etCantidad.setText(this.modelo.getCantidad() + "");

//+++++faltaria setear y traerme el controller en teoria
    }

    public void cargarProducto(EdModel modelo){
        modelo.setNombre((this.etNombre.getText().toString()));
        modelo.setCantidad(Integer.valueOf((this.etCantidad.getText()).toString()));
        modelo.setPrecio(Double.valueOf((this.etPrecio.getText()).toString()));

        //return modelo;
    }
}
