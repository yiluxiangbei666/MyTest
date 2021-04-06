package com.subject;

interface FilterProcess<T> {
    boolean process(T t);
}

public class Student {
    //名字
    private String name;
    //性别
    private String sex;
    //薪水
    private int salary;
    //年龄
    private int age;
    //星座
    private String star;

    public Student() {
    }

    public Student(String name, String sex, int salary, int age, String star) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        this.age = age;
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", star='" + star + '\'' +
                '}';
    }
}