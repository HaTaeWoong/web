package kr.mjc.kwanghyun.web.servlets.mvc;

import kr.mjc.kwanghyun.web.dao.ArticleDao;
import kr.mjc.kwanghyun.web.dao.Article;
import kr.mjc.kwanghyun.web.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    private final ArticleDao articleDao;

    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * 기사 목록
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int count = NumberUtils.toInt(request.getParameter("count"), 20);
        int page = NumberUtils.toInt(request.getParameter("page"), 1);

        List<Article> articleList = articleDao.listArticles(count, page);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }

    public void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("ME");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/signin");
            return;
        }
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(user.getUserId());
        article.setName(user.getName());


        articleDao.addArticle(article);
        response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
    }


    public void getArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));

        Article article = articleDao.getArticle(articleId);
        request.setAttribute("article", article);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/getArticle.jsp")
                .forward(request, response);
    }

    public void articleEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));

        Article article = articleDao.getArticle(articleId);
        request.setAttribute("article", article);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleEdit.jsp")
                .forward(request, response);
    }

    public void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("ME");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/signin");
            return;
        }

        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
        article.setUserId(user.getUserId());

        try {
            articleDao.updateArticle(article);
            // 수정 성공하면 게시글 조회
            getArticle(request, response);
        } catch (DataAccessException e) {
            // 수정 실패하면 다시 수정 화면으로
            log.error(e.toString());
            response.sendRedirect(request.getContextPath() + "/mvc/article/updateArticle");
        }
    }

    public void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("ME");

        int userId = user.getUserId();
        int articleId = Integer.parseInt(request.getParameter("articleId"));

        articleDao.deleteArticle(articleId,userId);

        articleList(request, response);
    }
}
