package cn.enjoyedu.service;

import cn.enjoyedu.vo.GoodTransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@author Marvin
 *
 *类说明：
 */
@Service
public class DepotManager {

    @Autowired
    private Depot depot;

    public void operDepot(GoodTransferVo goodTransferVo){
        if(goodTransferVo.isInOrOut()){
            depot.inDepot(goodTransferVo.getGoodsId(),goodTransferVo.getChangeAmount());
        }else{
            depot.outDepot(goodTransferVo.getGoodsId(),goodTransferVo.getChangeAmount());
        }
    }

//    public boolean isEmpty(String goodsId){
//        return depot.getGoodsAmount(goodsId)==0?true:false;
//    }



}
