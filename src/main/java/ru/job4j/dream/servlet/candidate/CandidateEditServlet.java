package ru.job4j.dream.servlet.candidate;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.Store;

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
        String nameFromReq = req.getParameter("name");
        String idFromReq = req.getParameter("id");
        if (!Objects.isNull(idFromReq)) {
            Candidate result = Store.instOf().finCandidateById(Integer.parseInt(idFromReq));
            if (!Objects.isNull(result)) {
                result.setName(nameFromReq);
                Store.instOf().saveCandidate(result);
            }
        } else {
            Store.instOf().saveCandidate(new Candidate(0, nameFromReq));
        }

        resp.sendRedirect(req.getContextPath() + "/candidates.jsp");
    }
}
