package ru.job4j.dream.tools;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AuthHelper {
    /**
     * Валидатор пользователя
     *
     * @param email
     * @param pass
     * @return найден и пароль совпал? user : null
     */
    public static User validateAuth(@NotNull String email, @NotNull String pass) {
        User user = PsqlStore.instOf().findUserByEmail(email);
        return Optional.ofNullable(user).filter(u -> u.getPassword().equals(pass))
                .orElse(null);
    }
}
