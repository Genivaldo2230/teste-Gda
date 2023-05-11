package br.com.videos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/creater-video")
public class CreateVideosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {


        String videoId = req.getParameter("video-id-input");
        String videoTitle = req.getParameter("video-title");
        String videoDescription = req.getParameter("video-description");
        String videoUrl = req.getParameter("video-url");


        System.out.println(videoId);
        System.out.println(videoTitle);
        System.out.println(videoDescription);
        System.out.println(videoUrl);

        req.getRequestDispatcher("index.html").forward(req,resp);

    }
}
