package me.luke.modules.po.repository;


import me.luke.modules.po.domain.BizPoInDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
* @author lukeWang
* @date 2020-04-18
*/
public interface BizPoInDetailRepository extends JpaRepository<BizPoInDetail, Long>, JpaSpecificationExecutor<BizPoInDetail> {
    @Modifying
    @Query(value = " update biz_po_in_detail " +
            " set is_delete = 1 ," +
            " version = version + 1 " +
            " where is_delete = 0   " +
            " and head_id = :headId ", nativeQuery = true)
    void deleteAllByHeadId(Long headId);
}