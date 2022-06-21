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
                { "Тимоти Шаламе", true},
                { "Теймоте Шойломее", true},
                { "ТимотейШевройле", false},
                { "Ти", false},
                { "Тимати Шойлойоменекен", false},
                { " Тимоти Шаламе", false},
                { "Тимоти Шаламе ", false},
                { " Тимоти Шаламе ", false},
        };
    }

    @Test
    @DisplayName("Проверка имени")
    public void checkCorrectNameTest() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }

}