package com.example.hufusdconverter.model;

public class HufUsdConverter {

    private final double HUFtoUSDConvRate = 0.0025;

    public int ConvertHUFtoUSD(int HufValue){
        return (int)(HufValue * HUFtoUSDConvRate);
    }
}