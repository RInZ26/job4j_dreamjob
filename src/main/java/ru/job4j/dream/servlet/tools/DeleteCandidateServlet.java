package ru.job4j.dream.servlet.tools;

import ru.job4j.dream.tools.CandidatePerformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidatePerformer candidatePerformer = CandidatePerformer.instOf();
        String candidateId = req.getParameter("id");
        if (Objects.nonNull(candidateId)) {
            int id = Integer.parseInt(req.getParameter("id"));
            candidatePerformer.removeCandidate(id, true);
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
