package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.List;

public class CombiningObservables {

  public static void main(String[] args) {

    List<String> list = List.of("Hello","Reactive","Programming");
    Observable.fromIterable(list)
        .flatMap(e -> Observable.fromArray(e.split("")))
        .subscribe(e -> System.out.println(":" +e));


  }

}
