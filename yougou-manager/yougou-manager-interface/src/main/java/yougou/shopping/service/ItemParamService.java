package yougou.shopping.service;

import yougou.shopping.common.pojo.EazyUIDataGridResult;
import yougou.shopping.common.pojo.TaotaoResult;
import yougou.shopping.pojo.TbItemParam;
import yougou.shopping.pojo.TbItemParamItem;

import java.util.ArrayList;

/**
 * Created by 蒋志鹏 on 2018/6/23.
 */
public interface ItemParamService {

    EazyUIDataGridResult selectAllItemParam(Integer pageNum, Integer pageSize);

    TbItemParamItem seItemParamItemById(Long id);

    TbItemParam queryItemCatParamById(Long id);

    TaotaoResult saveItemParamCat(Long id, String paramData);

    TaotaoResult deleteParams(ArrayList<Long> list);

    TbItemParam selectParamById(Long paramid);
}
