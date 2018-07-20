package yougou.shopping.search.service;

import yougou.shopping.common.pojo.TaotaoResult;

/**
 * Created by 蒋志鹏 on 2018/7/4.
 */
public interface SolrItemsService {
    TaotaoResult importAllItem();

    void findItemById(long itemId);
}
