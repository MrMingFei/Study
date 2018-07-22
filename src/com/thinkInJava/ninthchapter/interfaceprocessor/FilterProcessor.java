package com.thinkInJava.ninthchapter.interfaceprocessor;

import com.thinkInJava.ninthchapter.filters.*;

public class FilterProcessor{
    public static void main(String[] args){
        Waveform w = new Waveform();
        Apply.porcess(new FilterAdapter(new LowPass(1.0)),w);
        Apply.porcess(new FilterAdapter(new HighPass(2.0)), w);
        Apply.porcess(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }
}
class FilterAdapter implements Processor {
    Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }
    public Waveform process(Object input){
        return filter.process((Waveform)input);
    }
}
