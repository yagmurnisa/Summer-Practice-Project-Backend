package tech.reaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.reaven.model.News;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {
    @Query(value =
            "USE rv_is;\n" +
                    "SELECT *\n" +
                    "FROM [rv_is].[dbo].[News]\n" +
                    "WHERE [isin_code] = :isinCode", nativeQuery = true)
    List<News> findByISINCode(@Param("isinCode") String stock_isin);
}