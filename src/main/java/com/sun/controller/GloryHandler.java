package com.sun.controller;

import com.sun.entity.GloryCombo;
import com.sun.service.ComboService;
import com.sun.service.GloryService;
import com.sun.util.EtcUtil;
import com.sun.util.ResultVOUtil;
import com.sun.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shou
 * @Description:王者荣耀计算机计算价格接口
 * @date 2020/4/25 9:44
 */
@RestController
@RequestMapping("/glory")
@Slf4j
@Api(tags = "荣耀计算器计算相关接口")
public class GloryHandler {

    @Autowired
    private GloryService gloryService;

    @Autowired
    private ComboService comboService;

    /**
     * 王者荣耀计算器
     *
     * @param game        游戏
     * @param area        区服
     * @param cur         当前段位
     * @param tar         目标段位
     * @param inscription 铭文
     * @return
     */
    @GetMapping("/computed")
    @ApiOperation("荣耀计算接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "game", value = "游戏名"),
            @ApiImplicitParam(name = "area", value = "游戏区服"),
            @ApiImplicitParam(name = "cur", value = "当前段位星数"),
            @ApiImplicitParam(name = "tar", value = "目标段位星数"),
            @ApiImplicitParam(name = "inscription", value = "铭文数")
    })

    public ResultVO computed(String game, String area, String cur, String tar, String inscription) {
        try {
            if (!game.equals("王者荣耀")) {
                return ResultVOUtil.error("该游戏功能暂未开放.");

                //话术查询
            }
            String speechCraft = gloryService.getSpeechcraft(game);

            List<String> prices = new ArrayList<>();

            Map<String, Object> resultMap = new HashMap<>();

            //查询所有的套餐对应
            List<GloryCombo> combos = comboService.findAll();

            //首先判断初始值和目标值是否相同
            boolean flag = EtcUtil.checkIsSame(cur, tar);
            if (flag) {
                for (GloryCombo combo : combos) {
                    prices.add(new String(combo.getComboName() + ":0"));
                }
                resultMap.put("price",prices);
                resultMap.put("speechCraft", speechCraft);
                return ResultVOUtil.success(resultMap);
            }

            Map<String, String> proofEtc = EtcUtil.proof(cur, tar);
            cur = proofEtc.get("cur");
            tar = proofEtc.get("tar");

          /*  if(inscription==null||"".equals(inscription)){
                inscription="0";
            }*/
            //获取服务器以及铭文加成
            Map<String, Double> map = gloryService.getMultiplier(area, inscription, cur);
            //获取总价
            Long price = gloryService.computedPrice(cur, tar, map);
            if (-1 == price.longValue()) {
                return ResultVOUtil.error("计算失败请核查段位.");
            }



            //封装对应套餐的价格,字符串形式由前台解析
            for (GloryCombo combo : combos) {
                long money = Math.round(price * combo.getComboAddition());
                money = money - gloryService.getDiscount(money, game);
                prices.add(new String(combo.getComboName() + ":" + money));
            }
            //价格数组
            resultMap.put("price", prices);
            //话术
            resultMap.put("speechCraft", speechCraft);
            return ResultVOUtil.success(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("计算失败参数==>game:"+game+",area:"+area+",cur:"+cur+",tar:"+tar+",inscription:"+inscription);
            return ResultVOUtil.error("网络出现错误.");
        }
    }


}