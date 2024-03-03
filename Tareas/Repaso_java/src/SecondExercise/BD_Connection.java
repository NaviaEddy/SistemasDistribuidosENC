package SecondExercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BD_Connection {

    private final String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    private final String user = "root";
    private final String password = "admin";
    public void Guardar(biblioteca biblioteca){

        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion realizada con exito");

                guardarBiblioteca(conn, biblioteca);

                for (Armario armario : biblioteca.getListaArmarios()) {
                    guardarArmario(conn, armario);

                    for (Libro libro : armario.getListaLibros()) {
                        guardarLibro(conn, libro);
                    }
                }
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error, "+e.getMessage());
        }
    }

    private void guardarBiblioteca(Connection connection, biblioteca biblioteca) throws SQLException {
        String query = "INSERT INTO biblioteca (nombre, tamanio) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, biblioteca.getNombre());
        statement.setDouble(2, biblioteca.getTamanio());
        statement.executeUpdate();
        statement.close();
    }

    private void guardarArmario(Connection connection, Armario armario) throws SQLException {
        String query = "INSERT INTO armario (tipoArmario, codigo) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, armario.getTipoArmario().name());
        statement.setString(2, armario.getCodigo());
        statement.executeUpdate();
        statement.close();
    }

    private void guardarLibro(Connection connection, Libro libro) throws SQLException {
        String query = "INSERT INTO libro (nombre, autor, editorial, anio) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, libro.getNombre());
        statement.setString(2, libro.getAutor());
        statement.setString(3, libro.getEditorial());
        statement.setInt(4, libro.getAnio());
        statement.executeUpdate();
        statement.close();
    }
}
