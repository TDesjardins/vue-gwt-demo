package com.axellience.vuegwtdemo.client.components.counter;

import com.axellience.vuegwt.client.component.VueComponent;
import com.axellience.vuegwt.jsr69.component.annotations.Component;
import jsinterop.annotations.JsProperty;

@Component
public class CounterComponent extends VueComponent
{
    @JsProperty int counterValue;

    public CounterComponent()
    {
        this.counterValue = 0;
    }
}