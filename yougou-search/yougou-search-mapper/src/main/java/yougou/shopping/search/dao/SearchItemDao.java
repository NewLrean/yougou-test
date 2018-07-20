package yougou.shopping.search.dao;

import yougou.shopping.common.pojo.SolrResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by 蒋志鹏 on 2018/7/4.
 */


public interface SearchItemDao {

    SolrResult findsolritem(SolrQuery query);
}
