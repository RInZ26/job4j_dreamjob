package ru.job4j.dream.tools;

import org.apache.commons.lang3.StringUtils;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class RegHelper {

    /**
     * Валидация регистрации пользователя на предмет совпадения почтовых ящиков
     *
     * @param email
     * @return true, если valid
     */
    public static boolean validateMail(String email) {
        return Objects.isNull(PsqlStore.instOf().findUserByEmail(email));
    }

    /**
     * Валидация паролей (отдельно, потому что можно накрутить логику проверки наличия цифрк и прочей шляпы)
     *
     * @param passFirst
     * @param passSecond
     * @return true, если valid
     */
    public static boolean validatePasswords(String passFirst, String passSecond) {
        return passFirst.equals(passSecond);
    }


    /**
     * Прослойка, чтобы не вызывать Store из сервлета
     *
     * @param name
     * @param email
     * @param pass
     * @return
     */
    public static void saveUser(String name, String email, String pass) {
        PsqlStore.instOf().saveUser(new User(0, name, email, pass));
    }
}
