package org.cats.CATS.Repository;
import org.cats.CATS.Entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListasNegrasRepository extends CrudRepository<ListasNegras, Long> {

}
