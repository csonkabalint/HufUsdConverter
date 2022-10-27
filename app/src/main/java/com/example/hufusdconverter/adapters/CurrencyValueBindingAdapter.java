package com.example.hufusdconverter.adapters;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class CurrencyValueBindingAdapter {

    @BindingAdapter("huf")
    public static void setHuf(EditText view, String value){
        view.setText(value);
    }

    @InverseBindingAdapter(attribute = "huf")
    public static String getHuf(EditText editText){
        return editText.getText().toString();
    }

    @BindingAdapter("hufAttrChanged")
    public static void setListener(EditText view, InverseBindingListener listener){
        view.setOnFocusChangeListener((focusedView, hasFocus) -> {
            TextView textView = (EditText)focusedView;
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                textView.setText("");
            } else {
                // If the focus left, update the listener
                listener.onChange();
            }
        });
    }

}
