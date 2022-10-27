package com.example.hufusdconverter.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hufusdconverter.BR;
import com.example.hufusdconverter.model.HufUsdConverter;


public class HufUsdViewModel extends BaseObservable{

    private HufUsdConverter hufUsdConverter;
    private PropertyChangeRegistry callbacks;
    private int huf;
    public ObservableInt usd;

    public HufUsdViewModel(HufUsdConverter hufUsdConverter, int huf, int usd) {
        callbacks = new PropertyChangeRegistry();
        this.hufUsdConverter = hufUsdConverter;
        this.huf = huf;
        this.usd = new ObservableInt(usd);
    }

    @Bindable
    public int getHuf() {
        return huf;
    }

    public void setHuf(int huf) {
        this.huf = huf;
    }

    @Bindable
    public ObservableInt getUsd() {
        return usd;
    }

    public void calculateButtonClicked() {
        convertCurrency(usd);
        notifyPropertyChanged(BR.usd);
    }

    public void convertCurrency(ObservableInt outCurrency){
        usd.set(hufUsdConverter.ConvertHUFtoUSD(huf));
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }
}
