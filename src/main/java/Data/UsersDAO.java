package Data;
import Domain.Users;


import com.mongodb.Block;
import org.bson.Document;
import com.mongodb.client.FindIterable;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    Connection con=new Connection();
    public int register(Users u){
        try{
            con.getMongodb().getCollection("Usuarios").insertOne(
                    new Document()
                            .append("name", u.getUser_name())
                            .append("email", u.getUser_email())
                            .append("phone",u.getUser_phone())
                            .append("password",u.getUser_password())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    public List listUsers(){
        List<Users> datos=new ArrayList<>();
        try{
            con.connectDatabase();
            FindIterable<Document> iterable = con.getMongodb().getCollection("Usuarios").find();
            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    Users u=new Users();
                    String id =iterable.iterator().next().getString("id_");
                    String name =iterable.iterator().next().getString("name");

                    u.setUser_name(id);
                    u.setUser_name(name);
                    datos.add(u);
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        return datos;
    }
}
