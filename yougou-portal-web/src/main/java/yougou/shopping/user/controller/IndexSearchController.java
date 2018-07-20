package yougou.shopping.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import yougou.shopping.common.pojo.SolrResult;
import yougou.shopping.search.service.SearchItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

/**
 * Created by 蒋志鹏 on 2018/7/4.
 */

@Controller
public class IndexSearchController {


    @Reference
    private SearchItemService searchItemService;

    @RequestMapping("/search")
    private String IndexQueryItems(String q, @RequestParam(value="page",defaultValue="1")Integer page, Model model){

        try {
            q=new String(q.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(q);
        q=q.replace(" ", "");
        if(q==null||q.length()==0){
            return null;
        }
        SolrResult solrResult = searchItemService.queryitemList(q, page, 20);

        model.addAttribute("query",q);
        model.addAttribute("totalPages",solrResult.getPages());
        model.addAttribute("page",page);
        model.addAttribute("itemList", solrResult.getItems());
        return "search";
    }


}
