package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Buffering {

  //Buffer use collection.
  //Window buffer into other observable rather than collection. window yield observable from observables
  //Window emit emission as soon as they become available.

  public static void main(String[] args) throws InterruptedException {
    /*
    Observable.range(1,30)
        .buffer(4)
        .subscribe(System.out::println);

    Observable.interval(500, TimeUnit.MILLISECONDS)
        .buffer(1,TimeUnit.SECONDS,2) //as time based worked on computation based scheduler.
        .subscribe(System.out::println);

    Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
    Observable.interval(500, TimeUnit.MILLISECONDS)
        .buffer(intervalObservable)
        .subscribe(System.out::println);*/
    Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
    Observable.interval(500, TimeUnit.MILLISECONDS)
        .window(intervalObservable)
        .subscribe(System.out::println);
    Thread.sleep(6000);
  }

}
