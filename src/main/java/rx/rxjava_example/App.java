package rx.rxjava_example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
//    	for (int i=0; i<100; i++) {
//    		Integer index = new Integer(i);
//            Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);
//            values.subscribe(
//                v -> {
//                	System.out.println("Received and sleep "+index+": " + v);
//                	Thread.sleep(1000);
//                	System.out.println("Wake up "+index+": " + v);
//                },
//                e -> System.out.println("Error: " + e),
//                () -> System.out.println("Completed")
//            );
//    	}

        Observable<Long> values1 = Observable.interval(1000, TimeUnit.MILLISECONDS);
        values1.subscribe(
            v -> {
            	System.out.println("Received 1: " + v + ", Thread: " + Thread.currentThread().getName());
            },
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );
    	
        Observable<Long> values2 = Observable.interval(1000, TimeUnit.MILLISECONDS);
        values2.subscribe(
            v -> {
            	System.out.println("Received 2: " + v + ", Thread: " + Thread.currentThread().getName());
            },
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );

        values1.subscribe(
                v -> {
                	System.out.println("Received 3: " + v + ", Thread: " + Thread.currentThread().getName());
                },
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
        
        System.in.read();
        
        
    }
}
