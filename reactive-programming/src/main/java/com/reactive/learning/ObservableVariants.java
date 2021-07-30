package com.reactive.learning;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ObservableVariants {

  //Maybe, Single, Completable
  public static void main(String[] args) {

    Observable<String> source = Observable.just("Prateek","Pratyang","Nigam");
    Observable<String> source1 = Observable.empty();

    source.first("Name").subscribe(System.out::println);

    Single.just("Alex").subscribe(System.out::println);

    //Maybe
    source1.firstElement().subscribe(System.out::println);

    //Completable
    Completable c = Completable.complete();
    c.subscribe(() -> {
      System.out.println("Completed");
    });

    //Completable
    Completable.fromRunnable(() -> {
      System.out.println("Process going on");
    }).subscribe(() -> System.out.println("Process executed successfully"));



  }

}
