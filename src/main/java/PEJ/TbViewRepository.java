package PEJ;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TbViewRepository extends CrudRepository<TbView, Long> {

    List<TbView> findByTbId(Long tbId);
    List<TbView> findByPayId(Long payId);

}