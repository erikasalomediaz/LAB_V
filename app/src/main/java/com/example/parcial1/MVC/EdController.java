package com.example.parcial1.MVC;

import android.util.Log;

public class EdController {



   EdModel modelo;
   EdView view;

    public EdController(EdModel p) {
        this.modelo = p;
    }

    public void editarProducto(){

        this.modelo.setNombre((this.view.etNombre.getText().toString()));
        this.modelo.setCantidad(Integer.valueOf((this.view.etCantidad.getText()).toString()));
        this.modelo.setPrecio(Double.valueOf((this.view.etPrecio.getText()).toString()));

        this.view.mac.editarProducto(this.modelo.getNombre(), this.modelo.getCantidad(), this.modelo.getPrecio());
    }

    public void setView(EdView v){
        this.view = v;
    }
}
