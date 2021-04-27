package ru.job4j.dream.servlet.post;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class PostEditServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idFromReq = req.getParameter("id");
        String nameFromReq = req.getParameter("name");
        Post result = "null".equals(idFromReq) ? null : MemStore.instOf().findPostById(Integer.parseInt(idFromReq));
        if (!Objects.isNull(result) && !Objects.isNull(nameFromReq)) {
            result.setName(nameFromReq);
            MemStore.instOf().savePost(result);
        } else {
            MemStore.instOf().savePost(new Post(0, nameFromReq));
        }

        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }
}