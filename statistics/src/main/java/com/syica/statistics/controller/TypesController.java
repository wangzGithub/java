package com.syica.statistics.controller;

import com.syica.statistics.bean.FundType;
import com.syica.statistics.bean.InOutSources;
import com.syica.statistics.bean.InOutType;
import com.syica.statistics.config.CheckToken;
import com.syica.statistics.service.FundTypeService;
import com.syica.statistics.service.InOutSourcesService;
import com.syica.statistics.service.InOutTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 和类型有关的api接口controller
 * 收支类型，资金类型
 */
@RestController
@RequestMapping("/types")
public class TypesController {

    @Autowired
    private InOutTypeService inOutTypeService;

    @Autowired
    private FundTypeService fundTypeService;

    @Autowired
    private InOutSourcesService inOutSourcesService;

    /**
     * 获取用户关联的所有收支类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "/getInOutTypeListByUserId", method = RequestMethod.POST)
    public List<InOutType> getInOutTypeListByUserId(@RequestBody Map params) {
        String userId = (String) params.get("userId");
        List<InOutType> list = this.inOutTypeService.getListByUserId(Integer.parseInt(userId));
        return list;
    }

    /**
     * 添加收支类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "/addInOutType", method = RequestMethod.POST)
    public int addInOutType(@RequestBody Map params) {
        String code = (String) params.get("code");
        String name = (String) params.get("name");
        String userId = (String) params.get("userId");
        InOutType inOutType = new InOutType();
        inOutType.setCode(code);
        inOutType.setName(name);
        inOutType.setUserId(Integer.parseInt(userId));
        int num = this.inOutTypeService.addInOutType(inOutType);
        return num;
    }

    /**
     * 删除收支类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "/deleteInOutType", method = RequestMethod.POST)
    public int deleteInOutType(@RequestBody Map params) {
        int id = (int) params.get("id");
        int num = this.inOutTypeService.deleteInOutType(id);
        return num;
    }

    /**
     * 获取用户的所有资金类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "/getFundTypeListByUserId", method = RequestMethod.POST)
    public List<FundType> getFundTypeListByUserId(@RequestBody Map params) {
        List<FundType> result = null;
        String userId = (String) params.get("userId");
        result = this.fundTypeService.getAllByUserId(Integer.parseInt(userId));
        return result;
    }

    /**
     * 增加资金类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "addFundType", method = RequestMethod.POST)
    public int addFundType(@RequestBody Map params) {
        String code = (String) params.get("code");
        String name = (String) params.get("name");
        String userId = (String) params.get("userId");
        FundType fundType = new FundType();
        fundType.setCode(code);
        fundType.setName(name);
        fundType.setStatus(0);
        fundType.setUserId(Integer.parseInt(userId));
        int result = this.fundTypeService.addFundType(fundType);
        return result;
    }

    /**
     * 获取用户的所有收支类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "getInOutSourcesListByUserId", method = RequestMethod.POST)
    public List<InOutSources> getInOutSourcesListByUserId(@RequestBody Map params) {
        List<InOutSources> result = null;
        String userId = (String) params.get("userId");
        result = this.inOutSourcesService.getListByUserId(Integer.parseInt(userId));
        return result;
    }

    /**
     * 新增收支类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "addInOutSources", method = RequestMethod.POST)
    public int addInOutSources(@RequestBody Map params) {
        int result = 0;
        String name = (String) params.get("name");
        int inOutTypeId = (Integer) params.get("inOutTypeId");
        int parentId = (Integer) params.get("parentId");
        String userId = (String) params.get("userId");
        System.out.println(parentId);
        // 先查询收支类型名称是否已存在 如果存在 返回2
        int count = this.inOutSourcesService.getIfHasByName(name);
        if (count > 0) {
            result = 2;
        } else {
            InOutSources ios = new InOutSources();
            ios.setName(name);
            ios.setInOutTypeId(inOutTypeId);
            ios.setParentId(parentId);
            ios.setUserId(Integer.parseInt(userId));
            ios.setStatus(0);
            result = this.inOutSourcesService.saveInOutSources(ios);
        }
        return result;
    }

    /**
     * 删除收支分类
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "/deleteInOutSource", method = RequestMethod.POST)
    public int deleteInOutSource(@RequestBody Map params) {
        int id = (int) params.get("id");
        int num = this.inOutSourcesService.deleteInOutSources(id);
        return num;
    }

    /**
     * 获取所有父类收支类型
     * @param params
     * @return
     */
    @CheckToken
    @RequestMapping(value = "getParentInOutSources", method = RequestMethod.POST)
    public List<InOutSources> getParentInOutSources(@RequestBody Map params) {
        String userId = (String) params.get("userId");
        List<InOutSources> list = this.inOutSourcesService.getParentInOutSources(Integer.parseInt(userId));
        return list;
    }
}
