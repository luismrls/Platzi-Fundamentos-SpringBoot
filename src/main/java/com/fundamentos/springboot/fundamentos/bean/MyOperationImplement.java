package com.fundamentos.springboot.fundamentos.bean;

public class MyOperationImplement implements MyOperation{

    @Override
    public int suma(int numero) {
        return numero+1;
    }
}
