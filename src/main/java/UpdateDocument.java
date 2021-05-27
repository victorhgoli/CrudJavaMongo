import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class UpdateDocument {
	
	public static void main(String[] args) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("local");
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
		
		alunos.updateOne(Filters.eq("nome", "Joao"), 
				new Document("$set", new Document("nome", "Silveirinha")));
		
		
		
		cliente.close();
	}

}
