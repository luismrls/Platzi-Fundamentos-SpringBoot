package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependecy{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");
        int numero = 2;
        LOGGER.debug("el numero enviado como parametro es: " + numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
