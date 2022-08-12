
package Modelo;


public class DbDatajava {
    
   private final String driver = "com.mysql.cj.jdbc.Driver";
   private final String user = "root";
   private final String password = "";
   private final String url = "jdbc:mysql://localhost:3306/sitemade";
    
    
    // ahora le creo los metodos get para obtener luego estos valores peron no los set 
    // por que no necesito modificar nada ni debo permitirlo

   

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
    
    
}
