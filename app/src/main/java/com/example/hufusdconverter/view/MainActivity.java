package com.example.hufusdconverter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import androidx.databinding.library.baseAdapters.BR;

import android.os.Bundle;

import com.example.hufusdconverter.R;
import com.example.hufusdconverter.databinding.ActivityMainBinding;
import com.example.hufusdconverter.model.HufUsdConverter;
import com.example.hufusdconverter.viewmodel.HufUsdViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        HufUsdConverter hufUsdConverter = new HufUsdConverter();
        HufUsdViewModel hufUsdViewModel = new HufUsdViewModel(hufUsdConverter,0, 0);
        binding.setViewmodel(hufUsdViewModel);
    }
}