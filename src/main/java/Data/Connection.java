package Data;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class Connection {
    private MongoClient mongoClient;
    private MongoDatabase mongodb;

    public void connectDatabase(){
        setMongoClient(new MongoClient());
        setMongodb(getMongoClient().getDatabase("AgroMarket"));
    }
    
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongodb() {
        return mongodb;
    }

    public void setMongodb(MongoDatabase mongodb) {
        this.mongodb = mongodb;
    }
}
