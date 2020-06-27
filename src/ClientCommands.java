import java.io.Serializable;

/**
 * Перечисление команд, доступных клиенту для отправки на сервер.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */
public enum ClientCommands implements Serializable {
    HELP,
    INFO,
    SHOW,
    INSERT_NULL,
    UPDATE_ID,
    REMOVE_KEY,
    CLEAR,
    EXECUTE_SCRIPT,
    EXIT,
    REPLACE_IF_GREATER,
    REMOVE_GREATER_KEY,
    REMOVE_LOWER_KEY,
    COUNT_LESS_THAN_TYPE,
    PRINT_FIELD_ASCENDING_PERSON,
    PRINT_FIELD_DESCENDING_TYPE;

    /**
     * Возвращает ClientCommands объект из строкового его представления
     * @param c команда в виде строки
     * @return команду для упаковки.
     */
    public static ClientCommands getCommandFE(String c){
        switch (c.trim().toUpperCase()){
            case "HELP":
                return HELP;
            case "INFO":
                return INFO;
            case "SHOW":
                return SHOW;
            case "INSERT_NULL":
                return INSERT_NULL;
            case "UPDATE_ID":
                return UPDATE_ID;
            case "REMOVE_KEY":
                return REMOVE_KEY;
            case "CLEAR":
                return CLEAR;
            case "EXECUTE_SCRIPT":
                return EXECUTE_SCRIPT;
            case "EXIT":
                return EXIT;
            case "REPLACE_IF_GREATER":
                return REPLACE_IF_GREATER;
            case "REMOVE_GREATER_KEY":
                return REMOVE_GREATER_KEY;
            case "REMOVE_LOWER_KEY":
                return REMOVE_LOWER_KEY;
            case "COUNT_LESS_THAN_TYPE":
                return COUNT_LESS_THAN_TYPE;
            case "PRINT_FIELD_ASCENDING_PERSON":
                return PRINT_FIELD_ASCENDING_PERSON;
            case "PRINT_FIELD_DESCENDING_TYPE":
                return PRINT_FIELD_DESCENDING_TYPE;
            default:
                return null;
        }
    }

    private static final long serialVersionUID = 0;

    /**
     * Выводит на консоль клиента список всех доступных команд.
     */
    public static void showHelp(){
        System.out.println("\nhelp : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("insert null *ключ* : добавить новый элемент с заданным ключом");
        System.out.println("update id *id* : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_key null *ключ* : удалить элемент из коллекции по его ключу");
        System.out.println("clear : очистить коллекцию");
        System.out.println("execute_script *file_name* : считать и исполнить скрипт из указанного файла.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("replace_if_greater null *ключ* : заменить значение по ключу, если новое значение больше старого");
        System.out.println("remove_greater_key null *ключ* : удалить из коллекции все элементы, ключ которых превышает заданный");
        System.out.println("remove_lower_key null *ключ* : удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        System.out.println("count_less_than_type *type* : вывести количество элементов, значение поля type которых меньше заданного");
        System.out.println("print_field_ascending_person : вывести значения поля person всех элементов в порядке возрастания");
        System.out.println("exit : инициализировать остановку работы клиента");
        System.out.println("print_field_descending_type : вывести значения поля type всех элементов в порядке убывания\n");
    }
}
