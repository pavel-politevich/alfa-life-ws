package by.lifetech.alfalife.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import by.lifetech.alfalife.dto.AlfapayRequestDto;

public interface  AlfaLifeRequestRepository extends CrudRepository<AlfapayRequestDto, Long> {
    
    @Query(nativeQuery = true,value = "select case when count(*)> 0 then 'true' else 'false' end from tm_fm.ALFAPAY_REQUESTS t where t.doc_id = :docId and t.corr_number = :corrNum and t.amount = :amount and t.oper_date = to_date(:operDate,'yyyy-mm-dd')")
    boolean existsByCustomQuery(@Param("docId") String docId,
                                @Param("corrNum") String corrNum,
                                @Param("amount") double amount,
                                @Param("operDate") String operDate);
}
