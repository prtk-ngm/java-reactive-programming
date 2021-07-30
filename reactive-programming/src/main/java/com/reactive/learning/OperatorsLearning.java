package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

class Employee{
  private long id;
  private String name;
  private long salary;
  private double rating;

  public Employee(long id, String name, long salary, double rating) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.rating = rating;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }



}

public class OperatorsLearning {
  //suppressing operator - filter(predicate), take(5) take first 5, skip, distinct, elementAt
  //reducing operator - count, reduce, contains, all, any, collection
  //transformation operator - map, cast, delay , delay subscription, scan, sorted, repeat
  //error recovery operator - onError, onErrorReturnItem, onErrorReturn, retry, onErrorResumeNext.
  //action operator - doOnNext, doOnError, doOnSubscribe, doOnComplete.

  public static void main(String[] args) {

    Observable<Employee> employeeObservable =
        Observable.just(
            new Employee(101L, "Prateek01", 10000L,3.1),
            new Employee(102L, "Prateek02", 20000L,3.2),
            new Employee(103L, "Prateek03", 30000L,3.3),
            new Employee(104L, "Prateek04", 40000L,3.4),
            new Employee(105L, "Prateek05", 50000L,3.5),
            new Employee(106L, "Prateek06", 60000L,4.1),
            new Employee(107L, "Prateek07", 70000L,4.1),
            new Employee(108L, "Prateek08", 80000L,4.3),
            new Employee(109L, "Prateek09", 90000L,4.4),
            new Employee(1010L, "Prateek10", 100000L,4.5)
        );

    employeeObservable.groupBy(e ->e.getRating())
        .flatMapSingle(e ->e.toMultimap(key -> e.getKey(), emp->emp.getName()))
        .subscribe(System.out::println);
    /*

    employeeObservable.filter(e -> e.getRating() > 4.0)
        .sorted((e1,e2) -> Double.compare (e1.getRating(),e2.getRating()))
        .map(e -> e.getName())
        .take(4)
        .toList()
        .subscribe(System.out::println);

    List<Integer> expenses = List.of(100,200,300,400,500,600,700,800,900,1000);
    Observable.fromIterable(expenses)
        //.scan((a,b) -> a+b)
        .reduce((a,b) -> a+b)
        .subscribe(System.out::println);*/



  }

}
