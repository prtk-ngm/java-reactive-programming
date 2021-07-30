package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class CreatingObservable {

  public static void main(String[] args) {
    Observable<Integer> source = Observable.create(e -> {
          e.onNext(10);
          e.onNext(11);
          e.onComplete();


        }

        );
    source.subscribe(System.out::println);
    Observable<Integer> just = Observable.just(1,2,3,4);
    just.subscribe(System.out::println);

    //create observable from iterable.
    List<String> list = List.of("Prateek","Nigam","Pratyang");
    Observable<String> fromIterable  = Observable.fromIterable(list);
    fromIterable.subscribe(System.out::println);


  }

}
