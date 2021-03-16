package ru.job4j.dream.servlet.post;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idFromReq = req.getParameter("id");
        String nameFromReq = req.getParameter("name");
        Post result = "null".equals(idFromReq) ? null : Store.instOf().findPostById(Integer.parseInt(idFromReq));
        if (!Objects.isNull(result) && !Objects.isNull(nameFromReq)) {
            result.setName(nameFromReq);
            Store.instOf().savePost(result);
        } else {
            Store.instOf().savePost(new Post(0, nameFromReq));
        }

        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", Store.instOf().findAllPosts());
        req.getRequestDispatcher("post/posts.jsp").forward(req, resp);
    }
}