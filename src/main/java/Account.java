import org.apache.commons.lang3.StringUtils;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name.length() >= 3 && name.length() <= 19) {

            if (name.charAt(0) != ' ' && name.charAt(name.length() - 1) != ' ') {

                if (StringUtils.countMatches(name, " ") == 1) {
                    return true;
                }
            }
        }
//        if (name == null) {
//
//            return false;
//        }

        return false;
    }
}


/*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

