package ru.job4j.dream.servlet.candidate;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class CandidateEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idFromReq = req.getParameter("id");
        String nameFromReq = req.getParameter("name");
        Candidate result = "null".equals(idFromReq) ? null : PsqlStore.instOf().finCandidateById(Integer.parseInt(idFromReq));
        if (!Objects.isNull(result) && !Objects.isNull(nameFromReq)) {
            result.setName(nameFromReq);
            PsqlStore.instOf().saveCandidate(result);
        } else {
            PsqlStore.instOf().saveCandidate(new Candidate(0, nameFromReq));
        }

        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
