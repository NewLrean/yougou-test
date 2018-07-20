package yougou.shopping.controller.search;

import com.alibaba.dubbo.config.annotation.Reference;
import yougou.shopping.common.pojo.TaotaoResult;
import yougou.shopping.search.service.SolrItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 蒋志鹏 on 2018/7/4.
 */

@Controller
public class SolrImportController {

    @Reference
    private SolrItemsService solrItemsService;

    @RequestMapping("/solr/item/import")
    @ResponseBody
    private TaotaoResult importtoSolrj(){
        System.out.println("11111111111");
        TaotaoResult taotaoResult = solrItemsService.importAllItem();
        return taotaoResult;
    }
}
