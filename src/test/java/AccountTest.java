import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@DisplayName("Проверка корректности имени для печати на карте банка")
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][] {
                { "Тимоти Шаламе", true}, //Позитивный кейс
                { "Т м", true}, //Позитивный кейс с двумя символами и пробелом
                { "Теймоте Шойломееек", true}, //18 символов
                { "Теймоте Шойломееекк", true}, //19 символов
                { "Теймоте Шойломееекек", false}, //20 символов
                { "Ти", false}, //кейс 2 символа
                { "Тима", false}, //кейс 4 символа без пробелов
                { " Тимоти Шаламе", false}, //кейс с началом с проблема
                { "Тимоти Шаламе ", false}, //кейс с окончанием пробела
                { " ТимотиШаламе ", false},
                { " ТимотиШаламе", false},
                { "ТимотиШаламе ", false},
                { "Тимоти Ша ламе", false}, //кейс с 3 пробелами внутри
                { "Тимоти  ламе", false}, //кейс с 2 пробелами подряд
                { null, false}, //null
                { "", false}, //ничего
        };
    }

    @Test
    @DisplayName("Проверка имени")
    public void checkCorrectNameTest() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }

}
