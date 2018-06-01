package lu.dmi.icesi.studio;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Observable;

import leidercalvo.envio.Modelo;

public class ComtoMesa extends Observable implements Runnable {

    private Socket s;
    private InputStream is;
    private ObjectInputStream ois;
    private OutputStream os;
    private ObjectOutputStream oos;

    private ComtoMesa comtoMesa;

    private ComtoMesa(){

    }

    private void iniciar(String ip, int puerto) {
        comtoMesa = new ComtoMesa();
        try {
            s = new Socket(InetAddress.getByName(ip), puerto);
            is = s.getInputStream();
            ois = new ObjectInputStream(is);
            os = s.getOutputStream();
            oos = new ObjectOutputStream(os);
        } catch (IOException e) {
            e.printStackTrace();
            comtoMesa = null;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                recibir();
                Thread.sleep(100);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void recibir() throws IOException {
		/*byte[] buf = new byte[128];
		is.read(buf);
		setChanged();
		notifyObservers(new String(buf).trim());
		clearChanged();*/

        Modelo modelo;
        try {
            modelo = (Modelo)ois.readObject();
            setChanged();
            notifyObservers(modelo);
            clearChanged();
        } catch (ClassNotFoundException e) {
            System.out.println("No encuentra la clase modelo en controlcliente");
        }
    }

    public void enviar(Modelo modelo) {
		/*try {
			salida.write(mensaje.getBytes());
			salida.flush();
		} catch (IOException e) {
			System.out.println("error enviando un string");
		}*/
        try {
            oos.writeObject(modelo);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ComtoMesa getInstance(String ip, int puerto){
        if(comtoMesa==null){
            iniciar(ip,puerto);
        }
        return comtoMesa;
    }

}

