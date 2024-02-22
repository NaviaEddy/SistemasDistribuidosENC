package biblioteca;

import java.sql.*;

public class BD_Connection2 {

    private final String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    private final String user = "root";
    private final String password = "admin";

    private String query;
    public void Guardar(biblioteca biblioteca){

        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion realizada con exito");

                guardarBiblioteca(conn, biblioteca);

                for (Armario armario : biblioteca.getListaArmarios()) {
                    guardarArmario(conn, armario, biblioteca);

                    for (Libro libro : armario.getListaLibros()) {
                        guardarLibro(conn, libro, armario);
                    }
                }

                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error, "+e.getMessage());
        }
    }


    private void guardarBiblioteca(Connection connection, biblioteca biblioteca) throws SQLException {

        String query = "SELECT COUNT(*) FROM biblioteca WHERE nombre = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, biblioteca.getNombre());
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count == 0) {
                    // La biblioteca no existe, insertarla en la base de datos
                    query = "INSERT INTO biblioteca (nombre, tamaño) VALUES (?, ?)";
                    try (PreparedStatement insertStatement = connection.prepareStatement(query)) {
                        insertStatement.setString(1, biblioteca.getNombre());
                        insertStatement.setDouble(2, biblioteca.getTamanio());
                        insertStatement.executeUpdate();
                    }
                } else {
                    System.out.println("La biblioteca '" + biblioteca.getNombre() + "' ya existe en la base de datos.");
                }
            }
        }
    }


    private void guardarArmario(Connection connection, Armario armario, biblioteca biblioteca) throws SQLException {

        String query = "SELECT COUNT(*) FROM armario WHERE tipo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, armario.getTipoArmario().name());
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count == 0) {
                    // El tipo de armario no existe, insertarlo en la base de datos
                    query = "INSERT INTO armario (tipo, codigo, biblioteca_nombre) VALUES (?, ?, ?)";
                    try (PreparedStatement insertStatement = connection.prepareStatement(query)) {
                        insertStatement.setString(1, armario.getTipoArmario().name());
                        insertStatement.setString(2, armario.getCodigo());
                        insertStatement.setString(3, biblioteca.getNombre());
                        insertStatement.executeUpdate();
                    }
                } else {
                    System.out.println("El tipo de armario '" + armario.getTipoArmario().name() + "' ya existe en la base de datos.");
                }
            }
        }
    }


    private void guardarLibro(Connection connection, Libro libro, Armario armario) throws SQLException {
        query = "INSERT INTO libro (nombre, autor, editorial, año, armario_nombre) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, libro.getNombre());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getEditorial());
            statement.setInt(4, libro.getAnio());
            statement.setString(5, armario.getTipoArmario().name());
            statement.executeUpdate();
        }
    }

    public void verbiblioteca(){
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion realizada con exito");

                query = "SELECT * FROM biblioteca";
                Statement statement = conn.createStatement();
                ResultSet resultadoBiblioteca = statement.executeQuery(query);

                System.out.println("Datos de la tabla biblioteca:");
                while (resultadoBiblioteca.next()) {
                    System.out.println("Nombre: " + resultadoBiblioteca.getString("nombre"));
                    System.out.println("Tamaño: " + resultadoBiblioteca.getDouble("tamaño"));
                    System.out.println();
                }

                query = "SELECT * FROM armario";
                ResultSet resultadoArmario = statement.executeQuery(query);

                System.out.println("Datos de la tabla armario:");
                while (resultadoArmario.next()) {
                    System.out.println("Tipo de armario: " + resultadoArmario.getString("tipo"));
                    System.out.println("Código: " + resultadoArmario.getString("codigo"));
                    System.out.println("Biblioteca: " + resultadoArmario.getString("biblioteca_nombre"));
                    System.out.println();
                }

                query = "SELECT * FROM libro";
                ResultSet resultadoLibro = statement.executeQuery(query);

                System.out.println("Datos de la tabla libro:");
                while (resultadoLibro.next()) {
                    System.out.println("Nombre: " + resultadoLibro.getString("nombre"));
                    System.out.println("Autor: " + resultadoLibro.getString("autor"));
                    System.out.println("Editorial: " + resultadoLibro.getString("editorial"));
                    System.out.println("Año: " + resultadoLibro.getInt("año"));
                    System.out.println("Armario: " + resultadoLibro.getString("armario_nombre"));
                    System.out.println();
                }

                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error, "+e.getMessage());
        }


    }
}
