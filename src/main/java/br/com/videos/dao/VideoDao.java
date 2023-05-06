package br.com.videos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDao {
    private Connection conn;

    public VideoDao(Connection conn) {
        this.conn = conn;
    }

    public void addVideo(br.com.videos.model.Video video) throws SQLException {
        String query = "INSERT INTO videos (title, url) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, video.getTitle());
        stmt.setString(2, video.getUrl());
        stmt.executeUpdate();
    }

    public List<br.com.videos.model.Video> getAllVideos() throws SQLException {
        List<br.com.videos.model.Video> videos = new ArrayList<br.com.videos.model.Video>();
        String query = "SELECT * FROM videos";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            br.com.videos.model.Video video = new br.com.videos.model.Video();
            video.setId(((ResultSet) rs).getInt("id"));
            video.setTitle(rs.getString("title"));
            video.setUrl(rs.getString("url"));
            videos.add(video);
        }
        return videos;
    }

    // Outros métodos para atualizar, excluir ou buscar um vídeo por ID
}
