package com.example.galicia;

import java.io.Serializable;

public class MiVista implements Serializable {
        // Recurso ID de la imagen
        private int fotoSitio;

        // Nombre del lugar
        private String nombre;

        // Sitio donde se encuentra
        private String lugar;

        // Creamos el constructor
        public MiVista(int NumbersImageId, String NumbersInDigit, String NumbersInText) {
            fotoSitio = NumbersImageId;
            nombre = NumbersInDigit;
            lugar = NumbersInText;
        }

        // Creamos los métodos Get
        public int getImagen() {
            return fotoSitio;
        }

        public String getNombre() {
            return nombre;
        }

        public String getLugar() {
            return lugar;
        }


}
