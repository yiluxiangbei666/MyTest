package com.subject;

public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "dasdasda";
}