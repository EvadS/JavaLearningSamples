package hello;

import com.se.sample.cassandra.java.client.domain.Book;
import com.se.sample.cassandra.java.client.repository.BookRepository;
import com.se.sample.cassandra.java.client.repository.KeyspaceRepository;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;

public class HelloWorld {

	private static final Logger LOG = LoggerFactory.getLogger(CassandraClient.class);

	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());


		CassandraConnector connector = new CassandraConnector();
		connector.connect("127.0.0.1", null);
		Session session = connector.getSession();

		KeyspaceRepository sr = new KeyspaceRepository(session);
		sr.createKeyspace("library", "SimpleStrategy", 1);
		sr.useKeyspace("library");

		BookRepository br = new BookRepository(session);
		br.createTable();
		br.alterTablebooks("publisher", "text");

		br.createTableBooksByTitle();

		Book book = new Book(UUIDs.timeBased(), "Effective Java", "Joshua Bloch", "Programming");
		br.insertBookBatch(book);

		br.selectAll().forEach(o -> LOG.info("Title in books: " + o.getTitle()));
		br.selectAllBookByTitle().forEach(o -> LOG.info("Title in booksByTitle: " + o.getTitle()));

		br.deletebookByTitle("Effective Java");
		br.deleteTable("books");
		br.deleteTable("booksByTitle");

		sr.deleteKeyspace("library");

		connector.close();
	}
}
