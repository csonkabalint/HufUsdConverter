package com.example.hufusdconverter.converter;

import android.content.Context;
import android.widget.EditText;

import androidx.databinding.InverseMethod;

public class Conv {


    @InverseMethod("StringToInt")
    public static String IntToString(Context context, int value) {
        return Integer.toString(value);
    }

    public static int StringToInt(Context context, String value) {
        if (value.isEmpty()) {
            return 0;
        }
        else{
            return Integer.parseInt(value);
        }
    }

}
