import java.io.*;
import java.net.*;
import java.util.Scanner;


 class MyClient  {
    public static void main(String[] args)
    {

        try (Socket socket = new Socket("localhost", 9090)) {

            Object seats;
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            boolean taken = true;
            long key=0;
            ObjectInputStream ois = new ObjectInputStream(is);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            System.out.println("sending request for seats");


               key = (long) ois.readObject();
                System.out.println("your key is:" + key);
                int size = (int) ois.readObject();
                if (size >= 0) {
                    System.out.println("size of available seats is:" + size);
                    for (int i = 0; i <= size; i++) {
                        seats = ois.readObject();
                        System.out.println(i + " " + seats);
                    }

                    System.out.println("select seat \n");
                    int input = sc.nextInt();
                    while (input > size || input < 0) {
                        System.out.println("Please insert a correct number");
                        input = sc.nextInt();

                    }

                    System.out.println("Enter your name ");
                    String name = sc.next();
                    System.out.println("Enter your last_name ");
                    Object last_name = sc.next();
                    oos.writeObject(input);
                    oos.flush();
                    oos.writeObject(name);
                    oos.flush();
                    oos.writeObject(last_name);
                    oos.flush();
                   taken= (boolean) ois.readObject();


                } else {
                    System.out.println("no more seats sorry");
                }
            oos.writeObject(key);
            oos.flush();
            if (!taken){
                System.out.println("Someone just got this seat");
            }
    }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }


    }
    }
