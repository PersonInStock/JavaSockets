import java.io.*;
import java.util.ArrayList;


class ClientHandler implements Runnable {
    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;
    private final Server theServer;


    public ClientHandler(ObjectOutputStream oos, ObjectInputStream ois, Server ls) {
        this.oos = oos;
        this.ois = ois;
        this.theServer = ls;
    }

    public Thread start() {
        Thread t = new Thread(this);
        t.start();
        return t;
    }

    @Override
    public void run() {
        try {
            long key = (int) (Math.random() * 1E8);
            int l_no = 0;
            Object Name;
            Object last_name;


            ArrayList<Leg> ll = theServer.getLegs();
            Object lll = null;
            int counter=-1;
            for (int j = 0; j <ll.size() ; j++) {
                if (theServer.getLegs().get(j).isAvailable()) {
                    counter++;
                }
            }
            oos.writeObject(key);
            oos.flush();

            oos.writeObject(counter);
            oos.flush();
            for (int j = 0; j <ll.size() ; j++) {
                if (theServer.getLegs().get(j).isAvailable()) {
                    lll = theServer.getLegs().get(j);
                    oos.writeObject(lll);

                }
            } oos.flush();
            l_no = (int) ois.readObject();
            Name =  ois.readObject();
            last_name =  ois.readObject();
            if (theServer.getLegs().get(l_no).isAvailable()){
                oos.writeObject(true);
            }else {
                oos.writeObject(false);
            }
            oos.flush();
            long t_id = (long) ois.readObject();

            if (t_id != key) {
                System.out.println("Key sent back was: "+t_id+"supposed to be :" + key);
            } else {
                theServer.getLegs();
                System.out.println("corect personal key: "+ t_id);
                System.out.println("Name:" +Name);
                System.out.println("Last name:" +last_name);
                theServer.getLegs().get(l_no).setAvailable(false);
                System.out.println( "The seat changed is "+theServer.getLegs().get(l_no));
            }









        } catch (Exception e){
            e.printStackTrace();

        }
    }
}