package com.hurt.springit;

import com.hurt.springit.domain.Comment;
import com.hurt.springit.domain.Link;
import com.hurt.springit.repository.CommentRepository;
import com.hurt.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository)
    {
        return args -> {
            Link link = new Link("Youtube in PHP", "https://www.google.com");
            linkRepository.save(link);

            Comment comment = new Comment("This is php!", link);
            commentRepository.save(comment);
            link.addComment(comment);
            System.out.println("We just added alink and comment");
            System.out.println("================================");

            Link oldLink = linkRepository.findByTitle("Youtube in PHP");
            System.out.println("oldlink: " + oldLink.getTitle());
        };
    }
}
