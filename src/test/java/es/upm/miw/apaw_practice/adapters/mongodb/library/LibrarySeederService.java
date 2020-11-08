package es.upm.miw.apaw_practice.adapters.mongodb.library;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.BookRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LibrarianRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.OrderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.ReaderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibrarianEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.OrderEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.ReaderEntity;
import es.upm.miw.apaw_practice.domain.models.library.Reader;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class LibrarySeederService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibrarianRepository librarianRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ReaderRepository readerRepository;

    public void seedDatabase(){
        LogManager.getLogger(this.getClass()).warn("----------Library Initial Load----------");
        BookEntity[] book={
                new BookEntity("1","java","Pablo",true,"9787111636663"),
                new BookEntity("2","python","Alex",true,"9787111636623"),
                new BookEntity("3","linux","Trump",true,"9787111635463"),
                new BookEntity("4","c#","Jaime",true,"978711163653"),
                new BookEntity("5","php","Maduro",true,"9787111654363")
        };
        this.bookRepository.saveAll(Arrays.asList(book));

        ReaderEntity[] reader={
                ReaderEntity.builder().name("Ana").sex("Woman").dni("01648463T").phone("695222111").email("waldujocnj@gmail.com").build(),
                ReaderEntity.builder().name("Maria").sex("Woman").dni("64986134T").phone("695223211").email("iouchaib@gmail.com").build(),
                ReaderEntity.builder().name("Jesus").sex("Man").dni("68746351T").phone("695226951").email("poeufjncg@mail.com").build(),
                ReaderEntity.builder().name("Luis").sex("Man").dni("97416346T").phone("695236711").email("rigbcaihg@mail.com").build(),
                ReaderEntity.builder().name("Hector").sex("Man").dni("69741329T").phone("695294811").email("iuvhaiwkbgy@gmail.com").build()
        };
        this.readerRepository.saveAll(Arrays.asList(reader));

        OrderEntity[] order={
                new OrderEntity("1", new BigDecimal(12.3), LocalDateTime.of(2020,10,4,15,25),LocalDateTime.of(2020,10,6,15,37),LocalDateTime.of(2020,10,7,15,37),book[0],reader[0]),
                new OrderEntity("2", BigDecimal.ZERO, LocalDateTime.of(2020,3,2,17,37),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37),book[1],reader[1]),
                new OrderEntity("3", BigDecimal.ONE, LocalDateTime.of(2020,2,3,8,35),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37),book[2],reader[2]),
                new OrderEntity("4", BigDecimal.TEN, LocalDateTime.of(2020,2,6,19,37),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37),book[3],reader[3]),
                new OrderEntity("5", BigDecimal.ONE, LocalDateTime.of(2020,5,8,13,37),LocalDateTime.of(2020,11,4,15,37),LocalDateTime.of(2020,11,4,15,37),book[4],reader[4])
        };
        this.orderRepository.saveAll(Arrays.asList(order));

        LibrarianEntity[] librarian={
                new LibrarianEntity("1","Isabel","695333666",Arrays.asList(order[1],order[2])),
                new LibrarianEntity("2","maduro","695859634",Arrays.asList(order[3],order[4]))
        };
        this.librarianRepository.saveAll(Arrays.asList(librarian));
    }
    public  void  deleteAll(){
        this.bookRepository.deleteAll();
        this.librarianRepository.deleteAll();
        this.orderRepository.deleteAll();
        this.readerRepository.deleteAll();
    }
}
