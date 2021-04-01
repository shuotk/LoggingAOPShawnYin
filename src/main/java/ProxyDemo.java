public class ProxyDemo {
    public static void main(String[] args) {
        Beaconfire proxy = new Beaconfire(new You());
        proxy.getAJob();
    }
}

class You implements GetAJob{
    @Override
    public void getAJob() {
        System.out.println("Learn Java");
    }
}

class Beaconfire implements GetAJob{

    private GetAJob target;

    public Beaconfire(GetAJob target) {
        this.target = target;
    }

    @Override
    public void getAJob() {
        before();
        target.getAJob();
        after();
    }
    private void before(){
        System.out.println("Hire You");
    }
    private void after(){
        System.out.println("Find the Client");
    }
}