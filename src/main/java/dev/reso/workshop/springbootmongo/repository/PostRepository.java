package dev.reso.workshop.springbootmongo.repository;

import dev.reso.workshop.springbootmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findPostsByTitleContainingIgnoreCase(String title);

    List<Post> findByComments_TextContainingIgnoreCase(String comment);

    @Query("{ 'author.name' : { $regex :  ?0, $options: 'i'} }")
    List<Post> findByAuthor(String author);

    @Query("{$and : [{date: {$gte: ?1}}, {date: {$lte: ?2} }, " +
                "{$or: [{ 'title': {$regex: ?0, $options: 'i'}},{" +
                "'body': " +
                "{$regex: " +
                "?0, $options: 'i'}}, " +
                "{ 'comments.text': " +
                "{$regex: ?0, $options: 'i'}}]}" +
                "]" +
            "}"
    )
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
