package blocking.volatilevariable;

/**
 * Created by dmarathe on 10/3/16.
 */
public class Consumer implements Runnable {
    private final Exchanger exchanger;

    public Consumer(final Exchanger sharedResource){
        this.exchanger = sharedResource;
    }

    @Override
    public void run() {
        while(true){
            Object o = exchanger.take();
            System.out.println("consumed object o : " + o);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
