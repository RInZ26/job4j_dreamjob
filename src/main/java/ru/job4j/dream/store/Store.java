package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.Collection;

public interface Store {
    /**
     * Поиск всех заявок
     */
    Collection<Post> findAllPosts();

    /**
     * Поиск всех кандидатов
     *
     * @return
     */
    Collection<Candidate> findAllCandidates();

    /**
     * Сохрание заявки в БД
     *
     * @param post сохраняемая заявка
     */
    void savePost(Post post);

    /**
     * Сохранение кандидата в БД
     * @param candidate сохраняемый кандидат
     */
    void saveCandidate(Candidate candidate);

    /**
     * Поиск заявки по id
     *
     * @param id id
     * @return найденная заявка
     */
    Post findPostById(int id);

    /**
     * Поиск кандидата по id
     * @param id id
     * @return найденный кандидат
     */
    Candidate finCandidateById(int id);

    /**
     * Удаление кандидата
     * @param id
     * @return был ли такой кандидат вообще и удалён?
     */
    boolean deleteCandidateById(int id);
}
