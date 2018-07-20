package yougou.shopping.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yougou.shopping.common.pojo.EazyUIDataGridResult;
import yougou.shopping.common.pojo.TaotaoResult;
import yougou.shopping.pojo.TbItem;
import yougou.shopping.pojo.TbItemDesc;
import yougou.shopping.service.TbItemService;

@Controller
@RequestMapping("/item")
public class ItemController {


	
	@Reference
	private TbItemService itemService;


	/**
	 * 查询单个商品
	 * @param id 商品id
	 * @return 返回json数据
	 */
	@RequestMapping("/{itemid}")
	@ResponseBody
	public TbItem getItem(@PathVariable("itemid") Long id){
		
		TbItem selectByPrimaryKey = itemService.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	/**
	 * 查询所有商品并分页
	 * @param page 当前页数
	 * @param rows 显示条数
	 * @return 返回json数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	private EazyUIDataGridResult getItemList(Integer page, Integer rows){
		
		EazyUIDataGridResult result = itemService.selectAllItem(page, rows);
		return result;
		
	}

	/**
	 * 添加商品
	 * @param tbItem 商品信息
	 * @param tbItemDesc 商品描述
	 * @param itemParams 商品规格参数
	 * @return 返回json数据
	 */
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult itemSave(TbItem tbItem, TbItemDesc tbItemDesc, String itemParams){
		System.out.println(itemParams);
		
		TaotaoResult saveitem = itemService.saveitem(tbItem,tbItemDesc,itemParams);

		return saveitem;
	}



}
