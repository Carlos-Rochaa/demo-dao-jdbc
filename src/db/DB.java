package db;


import java.sql.*;


public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/coursejdbc";
    private static final String USER = "root";
    private static final String SENHA = "root";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar ao banco " + e.getMessage());
        }
        return connection;
    }

    public static void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar conexão", e);
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
