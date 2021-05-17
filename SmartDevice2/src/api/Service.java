package api;

import java.sql.*;

public class Service {

    private Connection conn;

    public Service(ServiceBuilder builder) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + builder.name,
                    builder.username, builder.password);//veri tabanına bağlantı yapıyoruz
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean girisYap(String username, String password) {
        String query = String.format("SELECT * FROM public.\"User\" WHERE \"username\" = '%s' AND \"password\" = '%s'", username, password);
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String un = resultSet.getString("username");
                if (un.equals(username)) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }

    public double sicaklikGetir() {
        String query = "SELECT * FROM public.\"Temperature\" WHERE \"id\" = '1'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) return resultSet.getDouble("value");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        return 0;
    }

    public void sicaklikGuncelle(double val) {

        String query = "UPDATE public.\"Temperature\" SET \"value\"=? WHERE \"id\" = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setDouble(1, val);
            statement.setInt(2, 1);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }

    public boolean sogutucuDurumu() {
        String query = "SELECT * FROM public.\"Device\" WHERE \"id\" = '1'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) return resultSet.getBoolean("open");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }


    public void sogutucuGuncelle(boolean open) {
        String query = "UPDATE public.\"Device\" SET \"open\"=? WHERE \"id\" = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setBoolean(1, open);
            statement.setInt(2, 1);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static class ServiceBuilder {
        private String name; // database adı
        private String username; // database usernamei
        private String password; // database sifresi

        public ServiceBuilder(String name) {
            this.name = name;
        }

        public ServiceBuilder username(String username) {
            this.username = username;
            return this;
        }

        public ServiceBuilder password(String pass) {
            this.password = pass;
            return this;
        }

        public Service build() {
            return new Service(this);
        }
    }
}
