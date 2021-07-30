package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Throttle {

  public static void main(String[] args) {
    Observable<String> obs = Observable.create(emitter -> {
      emitter.onNext("A");
      Thread.sleep(200);
      emitter.onNext("B");
      Thread.sleep(300);
      emitter.onNext("C");
      Thread.sleep(200);
      emitter.onNext("D");
      Thread.sleep(300);
      emitter.onNext("E");

    });
    /*
    obs.throttleFirst(500, TimeUnit.MILLISECONDS)
        .subscribe(e -> System.out.println("OnNext:" + e),
        Throwable::printStackTrace,
        ()->System.out.println("Completed"));*/

    obs.throttleLast(500, TimeUnit.MILLISECONDS)
        .subscribe(e -> System.out.println("OnNext:" + e),
            Throwable::printStackTrace,
            ()->System.out.println("Completed"));

  }

}
