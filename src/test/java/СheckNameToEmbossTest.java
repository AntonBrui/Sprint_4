import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
    public class СheckNameToEmbossTest {
        private final String condition;
        private final boolean expected;

        public СheckNameToEmbossTest(String condition, boolean expected) {
            this.condition = condition;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getFullName() {
            return new Object[][]{
                    {"A i", true}, // Проверяем граничное значение в 3 символа + наличие одного пробела
                    {"A i2", true}, // Проверяем граничное значение в 4 символа
                    {"My", false}, // Проверяем граничное значение в 2 символа
                    {"Maksimka Vasilevsky", true}, // Проверяем граничное значение в 19 символов
                    {"Maksima Vasilevsky", true}, // Проверяем граничное значение в 18 символов
                    {"Maksimka Vasilevsky1", false}, // Проверяем граничное значение в 20 символов
                    {"Anton Petrovich ", false}, // Проверяем что имя не может быть с пробелом в конце строки
                    {" Anton Petrovich", false}, // Проверяем что имя не может быть с пробелом в начале строки
                    {"AntonPetrovich", false}, // Проверяем что имя не может быть без пробела
                    {"Anton  Petrovich", false}, // Проверяем что имя не может быть с более чем одним пробелом подряд
                    {"Anton Petro vich", false}, // Проверяем что имя не может быть с более чем одним пробелом
                    {"", false}, // Проверяем что нельзя передать пустую строку
                    {null, false} // Проверяем что нельзя передать null
            };
        }

        @Test
        public void testCardHolderValidation() {
            Account account = new Account(condition);
            boolean actual = account.checkNameToEmboss();
            assertEquals(expected, actual);
        }
}
