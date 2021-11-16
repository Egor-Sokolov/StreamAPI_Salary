package com.company;

public class Employee {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Сотрудник-" +
                "Имя='" + name + '\'' +
                ", Возраст=" + age +
                ", Зарплата=" + salary
                ;
    }

    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
