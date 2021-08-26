package ru.job4j.dream.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Класс для обработки логики сервлетов завязанных на кандидате
 */
public class CandidatePerformer {
    private static final CandidatePerformer INST = new CandidatePerformer();
    private final Logger log = LogManager.getLogger(PsqlStore.class);
    private final Store psqlStore = PsqlStore.instOf();

    public static CandidatePerformer instOf() {
        return INST;
    }

    public boolean removeCandidate(int id, boolean isDeletePhoto) {
        Candidate candidate = psqlStore.finCandidateById(id);
        return Objects.nonNull(candidate) && removeCandidate(candidate, isDeletePhoto);
    }

    public boolean removeCandidate(@NotNull Candidate candidate, boolean isDeletePhoto) {
        boolean result = psqlStore.deleteCandidateById(candidate.getId());
        if (isDeletePhoto) {
            removeCandidateAvatar(candidate.getId());
        }
        return result;
    }

    private boolean removeCandidateAvatar(int id) {
        try {
            Files.deleteIfExists(Paths.get(System.getenv("photoStorage") + id + ".jpg"));
        } catch (IOException e) {
            log.error("id " + id, e);
        }
        return true;
    }
}