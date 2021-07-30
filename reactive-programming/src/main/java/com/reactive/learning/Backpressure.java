package com.reactive.learning;



import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Backpressure {

  public static void main(String[] args) {
    Observable.range(1,10000000)
        .map(e -> {
            System.out.println("Produced item is : " + e + ":" +
              Thread.currentThread().getName());
              return e;
            }
        ).observeOn(Schedulers.io())
        .subscribe(e -> {
          sleep(100);
          System.out.println("Consumed item is :" + e + ":" +
              Thread.currentThread().getName());

        });
        sleep(100000000);

  }

  private  static void sleep(long ms){
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
