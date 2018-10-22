package cn.mazekkkk.cloud.product.service.impl;

import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 管理地址
 *
 * @author maze
 * @createTime 18/10/15
 */
@Service
public class TxManagerHttpRequestServiceImpl implements TxManagerHttpRequestService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * txManager代理Http请求 get
     *
     * @param url 地址
     * @return
     */
    @Override
    public String httpGet(String url) {
        logger.info("start getMethod " + url);
        String res = HttpUtils.get(url);
        logger.info("end getMethod " + url);
        return res;
    }

    /**
     * txManager代理Http请求Post
     *
     * @param url   地址
     * @param param 参数
     * @return
     */
    @Override
    public String httpPost(String url, String param) {
        logger.info("start postMethod " + url);
        String res = HttpUtils.post(url, param);
        logger.info("end postMethod " + url);
        return res;
    }
}
