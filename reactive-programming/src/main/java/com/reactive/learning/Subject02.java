package com.reactive.learning;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

//Type of subject
//publish subject - start to emit the source observable items from the moment observer subscribe it.
// uni-cast subject - buffers all the emission received by the sources, unt ill an observer subscribes to it.
// replay subject - emit all the items of the source observable, regardless of when subscriber subscribes
// behaviour subject - emit the most recent item with the subsequent items of the source observable from the point
//of subscription
// async subject - emits only last value of the source observable
public class Subject02 {

  public static void main(String[] args) throws InterruptedException {

    //Subject<String> subject = PublishSubject.create();
    //Subject<String> subject = ReplaySubject.create();
    //Subject<String> subject = BehaviorSubject.create();
    //Subject<String> subject = AsyncSubject.create();
    Subject<Long> subject = UnicastSubject.create();
    Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(subject);

    Thread.sleep(2000);

    subject.subscribe(e -> System.out.println("subscriber1:" + e));

    Thread.sleep(3000);
    //subject.onNext("a");
    //subject.onNext("b");
    //subject.onNext("c");
    //subject.subscribe(e -> System.out.println("subscriber2:" + e));
    //subject.onNext("d");
    //subject.onNext("e");
    //subject.onNext("f");

    //subject.onComplete(); //for async operator you must call onComplete.


  }

}
