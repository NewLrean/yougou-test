package yougou.shopping.search.mapper;

import yougou.shopping.common.pojo.SolrItems;

import java.util.List;

/**
 * Created by 蒋志鹏 on 2018/7/4.
 */
public interface SolritemMapper {
    List<SolrItems> findAllItem();

    SolrItems findItemById(long itemId);
}
