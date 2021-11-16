package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
//1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
//встречающееся;
//2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
//среднюю зарплату сотрудника;
//Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
//сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
// имя1, имя2, имяN;”.

   static void findTheMostCommonWord(String[] arrayStrings){

       List<?> list= Arrays.asList(arrayStrings);
       Map < String, Long > wordsByCount = list.stream()
               .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

       String prevalentWord = wordsByCount.entrySet().stream()
               .max(Map.Entry.comparingByValue()).get().getKey();

       System.out.println(prevalentWord);
   }
   static void findTheOldestEmployee( List<Employee> employees, int quantity){
       System.out.println("Самые старшие по возрасту " + quantity + " сотрудника из списка." );
       employees.stream()
               .sorted((o1, o2) -> o2.getAge() - o1.getAge())
               .limit(quantity)
               .forEach(System.out::println);


   }


    public static void main(String[] args) {
        String[] arrayStrings = {"One", "Two", "Two", "Three", "Three", "Three", "Four","Four","Four","Four"};
        findTheMostCommonWord(arrayStrings);
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee( "Bob1" , 35 , 10000),
                new Employee( "Bob2" , 44 , 20000),
                new Employee( "Bob3" , 25 , 30000),
                new Employee( "Bob4" , 42 , 40000),
                new Employee( "Bob5" , 55 , 50000),
                new Employee( "Bob6" , 19 , 60000),
                new Employee( "Bob7" , 33 , 70000),
                new Employee( "Bob8" , 37 , 80000)
        ));
            List <Integer> salaryEmployee = new ArrayList<>();
        for(Employee employee : employees){
                salaryEmployee.add(employee.getSalary());
        }

        int[] salaryEmployeeArray = salaryEmployee.stream().mapToInt(i->i).toArray();
        IntStream intStream = IntStream.of(salaryEmployeeArray);
        double res = intStream.average().getAsDouble();
        System.out.println("Средняя зарплата - " + res);
        findTheOldestEmployee(employees, 3);




    }
}
