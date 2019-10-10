package com.example.parcial1.MVC;

import android.view.View;

import com.example.parcial1.MainActivity;
import com.example.parcial1.MyViewHolder;

public class EdListener implements View.OnClickListener{

    private EdController controller;

    public EdListener(EdController con){
        this.controller = con;
    }
        @Override
        public void onClick(View v){
        //++++me falta la accion
            this.controller.editarProducto();

        }



}
