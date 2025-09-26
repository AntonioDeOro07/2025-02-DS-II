package com.parcial.uno.parcial_uno.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parcial.uno.parcial_uno.model.Book;
import com.parcial.uno.parcial_uno.repository.BookRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Book("6600ab76-3", "0002005018", "Clara Callan", 5, true));
                repository.save(new Book("297c17d8-4", "0195153448", "Classical Mythology", 3, true));
                repository.save(new Book("11b553eb-b", "0399135782", "The kitchen God's wife", 8, true));
                repository.save(new Book("3c24c2fa-3", "0440234743", "The testament", 4, true));
                repository.save(new Book("eb25c2d4-7", "0393045218", "The mummies of Urumchi", 5, true));
                repository.save(new Book("1940136a-2", "0060973129", "Decision in Normandy", 3, true));
                repository.save(new Book("12a13228-0", "0345402871", "Airframe", 1, true));
                repository.save(new Book("51ed516f-a", "0375759778", "Prague: A Novel", 2, true));
            }
        };
    }
}
