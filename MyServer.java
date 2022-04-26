
import java.io.*;
import java.net.*;
import java.util.ArrayList;


class Server {
    private final ArrayList<Leg> legs = new ArrayList<>();
    public Server() {
        legs.add(new Leg( "A015", true, 1,15 ));
        legs.add(new Leg("A016", true, 1, 16 ));
        legs.add(new Leg("A017", true, 2, 17 ));
        legs.add(new Leg("A018", true, 2, 18 ));
        legs.add(new Leg("A019", true, 2, 19 ));
        legs.add(new Leg( "A020", true, 1,20 ));
        legs.add(new Leg("A021", true, 2, 21 ));
        legs.add(new Leg("A022", true, 2, 22 ));
        legs.add(new Leg("A023", true, 2, 23 ));
        legs.add(new Leg("A024", true, 2, 24 ));
        legs.add(new Leg( "A115", true, 11,15 ));
        legs.add(new Leg("A215", true, 31, 13 ));
        legs.add(new Leg("A315", true, 41, 14 ));
        legs.add(new Leg("A415", true, 51, 15 ));
        legs.add(new Leg("A515", true, 61, 16 ));
        legs.add(new Leg( "A115", true, 12,15 ));
        legs.add(new Leg("A216", true, 13, 13 ));
        legs.add(new Leg("A317", true, 14, 14 ));
        legs.add(new Leg("A418", true, 15, 15 ));
        legs.add(new Leg("A519", true, 16, 16 ));
        try {
            ServerSocket server = new ServerSocket(9090);//


            while (true) {
                Socket socket = server.accept();
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                ObjectInputStream ois = new ObjectInputStream(is);
                System.out.println("Connected" + socket);
                Thread clientSock = new ClientHandler(oos, ois, this).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Leg> getLegs() {
        return legs;
    }
        public static void main (String[]args){
        new Server();

    }

}

  