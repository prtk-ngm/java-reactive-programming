package com.reactive.learning;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.ThreadLocalRandom;
import org.reactivestreams.Publisher;

//subjects are hot.
public class Subject01 {

  public static void main(String[] args) throws InterruptedException {


    Observable<Integer> src1 = Observable.just(5,10,15,20).subscribeOn(Schedulers.computation());
    Observable<Integer> src2 = Observable.just(50,100,150,200).subscribeOn(Schedulers.computation());

    PublishSubject<Object> subject = PublishSubject.create();
    subject.subscribe(System.out::println);
    //subject.subscribe(e->System.out.println("Ob2:" + e));
    subject.onNext("Hello");
    subject.onNext("BasicString");




    src1.subscribe(subject);
    src2.subscribe(subject);

    subject.onComplete();

    Thread.sleep(100000);



  }

}
