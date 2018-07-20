package yougou.shopping.controller;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yougou.shopping.common.pojo.EUTreeNode;
import yougou.shopping.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {


	@Reference
	ItemCatService itemCatService;


	/**
	 * 查询一层类目
	 * @param parentId 节点id
	 * @return 返回json数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EUTreeNode> catList = itemCatService.getCatList(parentId);
		return catList;
	}
}
