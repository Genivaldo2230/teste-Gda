package br.com.videos.dao;

import br.com.videos.model.Video;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoDao1 {

    private final String url = "jdbc:h2:~/test"; // URL de conexão com o banco de dados
    private final String user = "sa"; // Nome de usuário do banco de dados
    private final String password = "sa"; // Senha do banco de dados

    public void createVideo(Video video) {
        String SQL = "INSERT INTO VIDEOS (ID, TITLE, DESCRIPTION, URL) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            System.out.println("Success in database connection");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1,video.getId());
            preparedStatement.setString(2,video.getTitle());
            preparedStatement.setString(3,video.getDescription());
            preparedStatement.setString(4,video.getUrl());

            int affectedRows = preparedStatement.executeUpdate();
            if ( affectedRows == 0 ) {
                throw new SQLException("Creating video failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if ( generatedKeys.next() ) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Video created successfully! ID: " + id);
                } else {
                    throw new SQLException("Creating video failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Fail in database connection");
            e.printStackTrace();
        }
    }

    public void removeVideo(int id) {
        String SQL = "DELETE FROM VIDEOS WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            System.out.println("Success in database connection");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1,id);

            int affectedRows = preparedStatement.executeUpdate();
            if ( affectedRows == 0 ) {
                System.out.println("No video found with the provided ID.");
            } else {
                System.out.println("Video removed successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Fail in database connection");
            e.printStackTrace();
        }
    }
//
//    /**
//     * EXECURÇÃO DO TESTE AOBANCO DE DADOS H2
//     */
//    public class CarDao {
//        public void createCar(Video video) {            // código de inserção omitido
//        }
//
//        public boolean testConnection() {
//            String url = "jdbc:h2:~/test";
//            String user = "sa";
//            String password = "sa";
//
//            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa"); PreparedStatement stmt = connection.prepareStatement("SELECT 1+1"); ResultSet rs = stmt.executeQuery()) {
//                System.out.println("Connection successful!");
//                return true;
//            } catch (Exception e) {
//                System.out.println("Connection failed: " + e.getMessage());
//                return false;
//            }
//        }/*
//        Nesse exemplo, o método testConnection() tenta estabelecer uma conexão com o banco de dados usando as credenciais padrão ("sa" e "sa") e executa uma query simples (SELECT 1+1) para verificar se a conexão foi bem-sucedida. Se a conexão for bem-sucedida, a mensagem "Connection successful!" será impressa no console e o método retornará true. Caso contrário, a mensagem "Connection failed: <mensagem de erro>" será impressa e o método retornará false.
//
//Você pode chamar esse método de teste de conexão de outras partes do seu código para verificar se a conexão com o banco de dados está funcionando corretamente.
//        */
//
//    }


}
