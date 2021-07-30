package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

//connectable observable use to make cold observable to hot observable.
public class ConnectableObservable{

  private static io.reactivex.rxjava3.observables.ConnectableObservable<Long> source;

  public static void main(String[] args) throws InterruptedException {

    source = Observable.interval(1, TimeUnit.SECONDS).publish();
    source.connect();
    source.subscribe(System.out::println);
    Thread.sleep(10000);
    source.subscribe(System.out::println);

    Thread.sleep(10000);

  }


}