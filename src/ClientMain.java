import java.util.Scanner;

/**
 * Класс для запуска клиента
 * @author Dima Tolochek
 * @version 1.0 Before Check
 */

public class ClientMain {
    public static Boolean exitCode = false;

    //Для дебага
    public static int port = 9000;
    public static String addr = "localhost";

    /**
     * Главный метод клиента
     * @param args - адрес, порт
     */
    public static void main(String[] args) {
        try{
            addr = args[0];
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e ){
            System.out.println("Введен некорректный порт!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Параметры не обнаружены, за основу взяты базовые! (localhost, 9000)");
        }
        while (!exitCode){
            Scanner MainIn = new Scanner(System.in);
            String ve = MainIn.nextLine();
            QuestionPack send = Packer.CommandPicker(ve);
            if(send == null & !exitCode){
                System.out.println("Произошла ошибка чтения команды, либо такой команды не существует!");
            } else if(send.command == ClientCommands.HELP){
                continue;
            } else if (send.command == ClientCommands.EXIT) {
                Client.sendToServerAndGetAnswer(send, addr, port);
                exitCode = true;
            } else {
                Client.sendToServerAndGetAnswer(send, addr, port);
            }
        }
    }
}
