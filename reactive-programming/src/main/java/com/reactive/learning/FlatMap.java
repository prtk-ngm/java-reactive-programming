package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.LocalTime;

public class FlatMap {

  public static void main(String[] args) throws InterruptedException {
    Observable.just("Prateek","Nigam","Pratyang")
        .flatMap(e -> Observable.just(e))
        .subscribeOn(Schedulers.computation())
        .map(s -> compute(s))
        .subscribe(System.out::println);

    Thread.sleep(6000);


  }

  public static String compute(String s){
    return s + ": Printed By " + Thread.currentThread().getName() + " at local time:" + LocalTime.now();
  }

}
