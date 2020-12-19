package com.syica.statistics.controller;

import com.syica.statistics.bean.InOutType;
import com.syica.statistics.config.CheckToken;
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

    @CheckToken
    @RequestMapping(value = "/getInOutTypeListByUserId", method = RequestMethod.POST)
    public List<InOutType> getInOutTypeListByUserId(@RequestBody Map params) {
        String userId = (String) params.get("userId");
        List<InOutType> list = this.inOutTypeService.getListByUserId(Integer.parseInt(userId));
        return list;
    }

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
}
