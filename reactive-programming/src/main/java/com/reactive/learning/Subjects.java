package com.reactive.learning;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.Flow.Publisher;

//Adding emission using subjects
public class Subjects {

  public static void main(String[] args) throws InterruptedException {
    @NonNull
    Observable<Integer> src1 = Observable.just(5,10,15,20).subscribeOn(Schedulers.computation());
    Observable<Integer> src2 = Observable.just(50,100,150,200).subscribeOn(Schedulers.computation());
    //src1.subscribe(System.out::println);
    //src2.subscribe(System.out::println);

    @NonNull
    Subject<Object> subject = PublishSubject.create();
    subject.subscribe(e ->System.out.println(e));
    src1.subscribe(subject);
    src2.subscribe(subject);

    Thread.sleep(10000);
  }

}
