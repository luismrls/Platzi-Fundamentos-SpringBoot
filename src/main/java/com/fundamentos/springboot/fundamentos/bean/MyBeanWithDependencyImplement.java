package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependecy{

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 2;
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
