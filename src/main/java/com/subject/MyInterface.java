package com.subject;

public interface MyInterface {
    void normalInterfaceMethod();

    default void interfaceMethodWithDefault() {  init(); }

    default void anotherDefaultMethod()
    {
        init();
    }

    private void init() {
        System.out.println( "Initializing" );
    }
}
