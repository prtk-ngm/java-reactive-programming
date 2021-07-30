package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HandleError {


  public static String fun1() throws Exception {
    throw new Exception();
  }

  public static void main(String[] args) {

    Map<String, String> m = new HashMap<String, String>();

    Observable.error(new IOException("Something went wrong"))
        .doOnError(error -> System.err.println("The error message is: " + error.getMessage()))
        .subscribe(
            x -> System.out.println("onNext should never be printed!"),
            Throwable::printStackTrace,
            () -> System.out.println("onComplete should never be printed!"));


    Single.just("2A")
        .map(v -> Integer.parseInt(v, 10))
        .onErrorReturn(error -> {
          if (error instanceof NumberFormatException) return 0;
          else throw new IllegalArgumentException();
        }).map(e -> m.put("1","1"))
        .subscribe(

            System.out::println,
            error -> System.err.println("onError should not be printed!"));

        m.remove("1");
        System.out.println(m.size());

    Observable<Long> source = Observable.interval(0, 1, TimeUnit.SECONDS)
        .flatMap(x -> {
          if (x >= 2) return Observable.error(new IOException("Something went wrong!"));
          else return Observable.just(x);
        });

    source.retryWhen(errors -> {
      return errors.map(error -> 1)

          // Count the number of errors.
          .scan(Math::addExact)

          .doOnNext(errorCount -> System.out.println("No. of errors: " + errorCount))

          // Limit the maximum number of retries.
          .takeWhile(errorCount -> errorCount < 3)

          // Signal resubscribe event after some delay.
          .flatMapSingle(errorCount -> Single.timer(errorCount, TimeUnit.SECONDS));
    }).blockingSubscribe(
        x -> System.out.println("onNext: " + x),
        Throwable::printStackTrace,
        () -> System.out.println("onComplete"));

  }

}
