package com.subject;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitName {
    String value() default " ";
}

/**
 * 水果颜色注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BLUE, RED, GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}


/**
 * 水果供应商注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitProvider {
    /**
     * 供应商编号
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    public String name() default " ";

    /**
     * 供应商地址
     * @return
     */
    public String address() default " ";
}

@Report
public class Test{
    @FruitName("dsadasda")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;
    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西红富士大厦")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public void displayName(){
        System.out.println(getAppleName());
    }
    public static void main(String[] args) {
        System.out.println(new Test().appleName);
        Field[] fields = Test.class.getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field.getName().toString());
            if (field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println("水果的名称：" + fruitName.value());
            }else if (field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println("水果的颜色："+fruitColor.fruitColor());
            }else if (field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.println("水果供应商编号:" + fruitProvider.id() + " 名称:" + fruitProvider.name() + " 地址:" + fruitProvider.address());
            }
        }
    }
}
