import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofu.sharding.SpringbootShardingJdbcApplication;
import com.xiaofu.sharding.mapper.ConfigRepository;
import com.xiaofu.sharding.mapper.OrderItemRepository;
import com.xiaofu.sharding.mapper.OrderRepository;
import com.xiaofu.sharding.model.TConfig;
import com.xiaofu.sharding.model.TOrder;
import com.xiaofu.sharding.model.TOrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootShardingJdbcApplication.class)
public class testSharding {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderItemRepository orderItemRepository;

    @Resource
    private ConfigRepository configRepository;

    @Test
    public void testSelect(){
        TOrder order = new TOrder();
        order.setOrderNo("A00027");
        order.setCreateName("订单27");
        order.setPrice(new BigDecimal("27"));
        orderRepository.insert(order);

        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_no","A00027");
        TOrder tOrder = orderRepository.selectOne(queryWrapper);
        System.out.println(tOrder.toString());
    }

    @Test
    public void testShardingGb(){
        //测试广播表
        TConfig tConfig = new TConfig();
        tConfig.setRemark("我是广播表");
        tConfig.setCreateTime(new Date());
        tConfig.setLastModifyTime(new Date());
        configRepository.insert(tConfig);
    }


    @Test
    public void testSharding() {
        for (int i = 0; i < 5; i++) {
            TOrder order = new TOrder();
            order.setOrderNo("A000" + i);
            order.setCreateName("订单 " + i);
            order.setPrice(new BigDecimal("" + i));
            orderRepository.insert(order);

            TOrderItem orderItem = new TOrderItem();
            orderItem.setOrderNo("B000" + i);
            orderItem.setItemName("订单 " + i);
            orderItem.setPrice(new BigDecimal("" + i));
            orderItemRepository.insert(orderItem);
        }

    }

}
