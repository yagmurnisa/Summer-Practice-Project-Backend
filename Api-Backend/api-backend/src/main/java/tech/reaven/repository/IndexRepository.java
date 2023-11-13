package tech.reaven.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.reaven.model.Index;
import java.util.List;

@Repository
public interface IndexRepository extends JpaRepository<Index, String> {
    @Query(value =
            "USE rv_is;\n" +
                    "SELECT *\n" +
                    "FROM [rv_is].[dbo].[Index]\n" +
                    "WHERE [isin_code] = :isinCode", nativeQuery = true)
    List<Index> findByISINCode(@Param("isinCode") String stock_isin);
}