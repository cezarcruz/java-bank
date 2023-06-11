package br.com.cezarcruz.javabank.gateway.out.mongo;


import br.com.cezarcruz.javabank.gateway.out.mongo.entity.AccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMongoRepository extends MongoRepository<AccountEntity, String> {
}
