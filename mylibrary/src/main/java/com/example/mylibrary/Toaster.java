package com.example.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class Toaster {

    public static void main(String[] args) {
        System.out.println("hey");
    }

    public static void show(Context c, String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();

    }
}
