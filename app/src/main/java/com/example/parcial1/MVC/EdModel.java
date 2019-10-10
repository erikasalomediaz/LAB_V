package com.example.parcial1.MVC;

public class EdModel {
        private String nombre;
        private int cantidad;
        private Double Precio;

        public EdModel(String nombre, int Cantidad, Double Precio){
            this.nombre = nombre;
            this.cantidad = Cantidad;
            this.Precio = Precio;
        }
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public Double getPrecio() {
            return Precio;
        }

        public void setPrecio(Double precio) {
            Precio = precio;
        }


}
