import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Класс, реализующий сетевой обмен сервера и клиенте
 * @author Dima Tolochek
 * @version 1.0 Before Check
 */

public class Client {
    /**
     * Отправка запроса на сервер и получение ответа
     * @param pack
     * @param adress
     * @param port
     */
    public static void sendToServerAndGetAnswer(QuestionPack pack, String adress, Integer port){
        try {
            //Подключение
            SocketAddress a = new InetSocketAddress(adress, port);
            SocketChannel s = SocketChannel.open(a);

            //Отправка запроса
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(pack);

            byte[] data = baos.toByteArray();

            s.write(ByteBuffer.wrap(data));

            //Получение ответа
            ByteBuffer f = ByteBuffer.allocate(1024*1024);
            f.flip();
            f.compact();
            s.read(f);
            ByteArrayInputStream bais = new ByteArrayInputStream(f.array());
            ObjectInputStream ois = new ObjectInputStream(bais);
            AnswerPack ap = (AnswerPack) ois.readObject();
            UnPacker.UnPackAnswerFromServer(ap.answer);
            s.finishConnect();
            s.close();
        } catch (IOException e) {
            if(ClientMain.port <= 0){
                System.out.println("Перезапустите программу");
            } else {
                System.out.println("Произошла ошибка в ходе отправки запроса!");
                System.out.println("Retrying...");
                ClientMain.port --;
                System.out.println("Пробую порт: " + ClientMain.port);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                System.out.println("Ошибка в ходе ожидания.");
            }
            sendToServerAndGetAnswer(pack, adress, ClientMain.port);
        } catch (ClassNotFoundException e) {
            System.out.println("Ответ не удалось распаковать!");
        }
    }
}