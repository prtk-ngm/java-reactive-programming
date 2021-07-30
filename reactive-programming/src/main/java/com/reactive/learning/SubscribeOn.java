package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Locale;

public class SubscribeOn {

  //subscribeOn operator - Let observer subscribe to observable on a particular thread.
  //1- Position does not matter - placed anywhere in observable stream
  //2- Position matter - when there are more than one subscribeOn call
  //subscribeOn call close to Observable get preference

  //observeOn - position matter -upstream operator not impacted
  //but downstream matter

  public static void main(String[] args) throws InterruptedException {
    String job = "1";
    Observable.just("Prateek","Nigam","Pratyang")

        .map(e -> e.toUpperCase())
        .doOnNext(e -> System.out.println("Before:" + Thread.currentThread().getName())) //not changed because
        //upstream
        .observeOn(Schedulers.newThread())
        //downstream changed because observeOn
        .doOnNext(e -> System.out.println("After:" + Thread.currentThread().getName()))

        .filter(e -> e.startsWith("P"))
        .subscribeOn(Schedulers.io())
        .subscribe(e -> print(e))
        ;
    Thread.sleep(6000);
  }

  public static void print(String element){
    System.out.println(element + ": Printed By " + Thread.currentThread().getName());
  }

}
