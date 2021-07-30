package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

  public static void main(String[] args) throws InterruptedException {
    Observable<String>  source = Observable.just("Hello","World").subscribeOn(
        Schedulers.computation());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    source.subscribe(e -> compute());
    Thread.sleep(5000);


  }

  public static void compute() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Computation done by:" + Thread.currentThread().getName());
  }


}
