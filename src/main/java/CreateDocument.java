import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class CreateDocument {
	
	public static void main(String[] args) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bancoDeDados = cliente.getDatabase("local");
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
		Document aluno = alunos.find().first();
		System.out.println(aluno);
		
		Document novoAluno = new Document("nome", "Joao")
			.append("data_nascimento" , new Date(2003, 10, 10))
			.append("curso" , new Document("nome", "Historia"))
			.append("notas" , Arrays.asList(10,9,8))
			.append("habilidades", Arrays.asList(new Document()
													.append("nome"  , "Ingles ")
													.append("nível" , "Básico"),
													new Document()
													.append("nome" , "Espanhol")
													.append("nível" , "Básico")));
		
		alunos.insertOne(novoAluno);
		
		
		
		cliente.close();
	}

}
