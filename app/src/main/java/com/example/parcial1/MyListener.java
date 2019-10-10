package com.example.parcial1;

import android.content.Intent;
import android.view.View;

public class MyListener implements View.OnClickListener {

    MyViewHolder mvh;
    MainActivity mainAct;
    public MyListener(MyViewHolder mvh, MainActivity mainAct){
        this.mvh = mvh;
        this.mainAct = mainAct;
    }

    @Override
    public void onClick(View v){
this.mainAct.editarProducto(mvh.posicion);

    }
}
