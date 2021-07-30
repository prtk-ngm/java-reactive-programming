package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

//zip use to combine two observable.
//combineLatest to combine with latest emission.
public class ZipAndCombineLatest {

  public static void main(String[] args) throws InterruptedException {
    Observable<Long> ob1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
    Observable<Long> ob2 = Observable.interval(1, TimeUnit.SECONDS).take(10);
    //Observable.zip(ob1,ob2,(e1,e2) -> "ob1:" + e1 + ":ob2:" +e2).subscribe(System.out::println);
    Observable.combineLatest(ob1,ob2,(e1,e2) -> "ob1:" + e1 + ":ob2:" +e2).subscribe(System.out::println);
    Thread.sleep(100000);
  }

}
