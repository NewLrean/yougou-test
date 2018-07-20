package yougou.shopping.search.dao.impl;

import yougou.shopping.common.pojo.SolrItems;
import yougou.shopping.common.pojo.SolrResult;
import yougou.shopping.search.dao.SearchItemDao;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 蒋志鹏 on 2018/7/4.
 */

@Repository
public class SearchItemDaoImpl implements SearchItemDao{

    @Autowired
    private SolrClient solrClient;

    @Override
    public SolrResult findsolritem(SolrQuery query) {

        try {
            QueryResponse queryResponse = solrClient.query(query);
            SolrDocumentList results = queryResponse.getResults();
            List<SolrItems> solrItemlist=new ArrayList<SolrItems>();

            for (SolrDocument solrDocument :results) {
                SolrItems solrItems=new SolrItems();
                solrItems.setId(solrDocument.get("id").toString());
                Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
                List<String> strings = highlighting.get(solrDocument.get("id")).get("item_title");
                if(strings!=null&&strings.size()>0){
                    solrItems.setTitle(strings.get(0));
                }else {
                    solrItems.setTitle(solrDocument.get("item_title").toString());
                }
                List<String> strings1 = highlighting.get(solrDocument.get("id")).get("item_sellpoint");
                if(strings1!=null&&strings1.size()>0){
                    solrItems.setSellPoint(strings1.get(0));
                }else {
                    if(solrDocument.get("item_sellpoint")!=null)
                    solrItems.setSellPoint(solrDocument.get("item_sellpoint").toString());
                }

                solrItems.setPrice((Long) solrDocument.get("item_price"));


                solrItems.setImage(solrDocument.get("item_image")==null?"":solrDocument.get("item_image").toString());

                solrItems.setName(solrDocument.get("item_categoryName").toString());
                solrItemlist.add(solrItems);
            }

            SolrResult solrResult=new SolrResult();
            solrResult.setTotal(results.getNumFound());
            solrResult.setItems(solrItemlist);
            return solrResult;
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
