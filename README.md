# super-java_Synchronization

Synchronization

• At times, you may find that more that one thread access the same set
of data.

• For example, in a banking application, a thread may be responsible
for updating the account balance while the other thread may be
responsible for displaying the total account balance.

• In such a situation, the thread execution needs to be coordinated or
synchronized to avoid inconsistency and deadlock.

• The synchronization of threads ensures that if two or more threads
need to access a shared resource then that resource is used by only
one thread at a time.

• You can synchronize your code by using the synchronized
keyword.

• You can invoke only one synchronized method for an object at any
given time.

• Synchronization is based on the concept of monitor.

• A monitor is an object that is used as a mutually exclusive lock.

• All objects and classes are associated with a monitor and only
one thread can own a monitor at a given time.

• When a thread is within a synchronized method, all the other threads
that try to call it on the same instance have to wait.

• During the execution of a synchronized method, the object is locked
so that other synchronized method can not be invoked.

• The monitor is automatically released when the method completes its
execution.

• The monitor can also be released when the synchronized method
executes the wait() method.

• When a thread calls the wait() method, it temporarily releases the
locks that it holds.


• Example:


class ThreadCreator_1{

synchronized void invoke(){

System.out.println("First Statement");

try{

Thread.sleep(2000);

}

catch(Exception e){

System.out.println("Error " + e);

}

System.out.println("Second Statement");

}

}

class ThreadCreator_2 extends Thread{

ThreadCreator_1 t;

public ThreadCreator_2(ThreadCreator_1 t){

this.t = t;

}

public void run(){

t.invoke();

}

}



public class SynchronizationTest {

public static void main(String args[]){

ThreadCreator_1 obj1 = new ThreadCreator_1();

ThreadCreator_2 Obj2 = new ThreadCreator_2(obj1);

ThreadCreator_2 Obj3 = new ThreadCreator_2(obj1);

Obj2.start();

Obj3.start();

}

}



<<< Output: will be>>

First Statement

Second Statement

First Statement

Second Statement

