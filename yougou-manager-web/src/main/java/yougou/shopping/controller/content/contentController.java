package yougou.shopping.controller.content;

import com.alibaba.dubbo.config.annotation.Reference;
import yougou.shopping.common.pojo.EazyUIDataGridResult;
import yougou.shopping.common.pojo.TaotaoResult;
import yougou.shopping.pojo.TbContent;
import yougou.shopping.service.content.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蒋志鹏 on 2018/6/30.
 */


@Controller
public class contentController {


    @Reference
    ContentService contentService;

    @RequestMapping("/content/query/list")
    @ResponseBody
    public EazyUIDataGridResult queryContentList(long categoryId, Integer page, Integer rows){
        EazyUIDataGridResult result = contentService.queryContentsBycid(categoryId, page, rows);
        return result;
    }

    @RequestMapping("/content/save")
    @ResponseBody
    private TaotaoResult saveContentOne(TbContent tbContent){

        TaotaoResult taotaoResult = contentService.insertOneContent(tbContent);
        return taotaoResult;
    }

    @RequestMapping("/content/delete/{ids}")
    @ResponseBody
    private TaotaoResult deleteContents(@PathVariable String ids){
        String[] split = ids.split(",");
        List<Long> longs=new ArrayList<>();
        for (String string:split){
            longs.add(Long.valueOf(string));
        }
        TaotaoResult taotaoResult = contentService.deleteContentList(longs);
        return taotaoResult;
    }

    @RequestMapping("/rest/content/edit")
    @ResponseBody
    private TaotaoResult updateOContent(TbContent tbContent){
        TaotaoResult taotaoResult = contentService.updateOneContent(tbContent);
        return taotaoResult;
    }
}
