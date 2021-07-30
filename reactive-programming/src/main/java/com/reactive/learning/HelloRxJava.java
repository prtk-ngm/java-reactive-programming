package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {

  public static void main(String[] args) {
    Observable<String> source = Observable.create(e -> {
      e.onNext("Hello");
      e.onNext("World");
    });
    source.subscribe(e -> System.out.println("Observer1:" + e));
    source.subscribe(e -> System.out.println("Observer2:" + e));
  }


}
