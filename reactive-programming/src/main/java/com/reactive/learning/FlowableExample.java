package com.reactive.learning;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

//Flowable is replacement of observable where we need backpressure.
//Flowable creation and Backpressure strategy.
public class FlowableExample {

  public static void main(String[] args) {
    Flowable.range(1,10000000)
        .map(e -> {
              System.out.println("Produced item is : " + e + ":" +
                  Thread.currentThread().getName());
              return e;
            }
        ).observeOn(Schedulers.io())
        .subscribe(new Subscriber<Integer>() {
          Subscription s;
          AtomicInteger count = new AtomicInteger(0);
          @Override
          public void onSubscribe(Subscription s) {
            this.s = s;
            System.out.println("Asking 20 items");
            s.request(20);

          }

          @Override
          public void onNext(Integer integer) {
            System.out.println("The subscriber consumed :" + integer);
            if(count.getAndIncrement() % 20 == 0){
              System.out.println("Asking for next 20 items");
              s.request(20);
            }
            sleep(100);
          }

          @Override
          public void onError(Throwable t) {
            t.printStackTrace();

          }

          @Override
          public void onComplete() {
            System.out.println("completed");

          }
        });
        /*.subscribe(e -> {
          sleep(100);
          System.out.println("Consumed item is :" + e + ":" +
              Thread.currentThread().getName());

        });*/
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


