package JUC;

public class AlternatePrint {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                synchronized(lock){
                    while(count <= 100){
                        while(count % 2 == 0){
                            try{
                                lock.wait();
                            }catch(Exception e){
                                break;
                            }
                        }
                        if (count <= 100)System.out.println("t1:"+count);
                        count++;
                        lock.notifyAll();
                    }
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run(){
                synchronized(lock){
                    while(count <= 100){
                        while(count % 2 == 1){
                            try{
                                lock.wait();
                            }catch(Exception e){
                                break;
                            }
                        }
                        if (count <= 100)System.out.println("t2:"+count);
                        // 编码错误1:从wait里面醒来不会立即进行while的判断，而是先执行这一部分，因此这里还是需要加if来限制的
                        count++;
                        lock.notifyAll();;
                    }
                }
            }
        };
        t1.start();
        t2.start();
        
    }

}
