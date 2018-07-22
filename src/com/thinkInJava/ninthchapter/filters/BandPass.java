package com.thinkInJava.ninthchapter.filters;

public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCutoff, double highCutoff){
        this.highCutoff = highCutoff;
        this.lowCutoff = lowCutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
