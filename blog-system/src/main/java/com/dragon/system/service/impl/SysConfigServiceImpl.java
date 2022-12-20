package com.dragon.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dragon.common.annotation.DataSource;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.constant.UserConstants;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.common.core.text.Convert;
import com.dragon.common.enums.DataSourceType;
import com.dragon.common.exception.ServiceException;
import com.dragon.common.utils.StringUtils;
import com.dragon.system.domain.SysConfig;
import com.dragon.system.mapper.SysConfigMapper;
import com.dragon.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

/**
 * 参数配置 服务层实现
 *
 * @author dragon
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {
    @Autowired
    private SysConfigMapper configMapper;

    @Autowired
    private RedisCache redisCache;

    /**
     * 项目启动时，初始化参数到缓存
     */
    @PostConstruct
    public void init() {
        loadingConfigCache();
    }

    /**
     * 查询参数配置信息
     *
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
    @Override
    @DataSource(DataSourceType.MASTER)
    public SysConfig selectConfigById(Long configId) {
        SysConfig config = new SysConfig();
        config.setConfigId(configId);
        return configMapper.selectConfig(config);
    }

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数key
     * @return 参数键值
     */
    @Override
    public String selectConfigByKey(String configKey) {
        String configValue = Convert.toStr(redisCache.getCacheObject(getCacheKey(configKey)));
        if (StringUtils.isNotEmpty(configValue)) {
            return configValue;
        }
        SysConfig config = new SysConfig();
        config.setConfigKey(configKey);
        SysConfig retConfig = configMapper.selectConfig(config);
        if (StringUtils.isNotNull(retConfig)) {
            redisCache.setCacheObject(getCacheKey(configKey), retConfig.getConfigValue());
            return retConfig.getConfigValue();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取验证码开关
     *
     * @return true开启，false关闭
     */
    @Override
    public boolean selectCaptchaEnabled() {
        String captchaEnabled = selectConfigByKey("sys.account.captchaEnabled");
        if (StringUtils.isEmpty(captchaEnabled)) {
            return true;
        }
        return Convert.toBool(captchaEnabled);
    }

    /**
     * 获取用户注册开关
     *
     * @return true开启，false关闭
     */
    @Override
    public boolean selectRegisterUser() {
        String registerUser = selectConfigByKey("sys.account.registerUser");
        if (StringUtils.isEmpty(registerUser)) {
            return false;
        }
        return Convert.toBool(registerUser);
    }

    /**
     * 获取网站底部-域名备案信息
     *
     * @return
     */
    @Override
    public JSONObject selectDomainNameIcp() {
        String registerUser = selectConfigByKey("sys.domainName.ICP");
        if(StringUtils.isEmpty(registerUser)){
            JSONObject obj = JSON.parseObject("{\"ICP\":\"粤ICP备20001307号\",\"domainName\":\"www.dragonwen.cn\",\"year\":\"2018-2022\",\"MIIT\":\"https://beian.miit.gov.cn/\"}");
            return obj;
        }
        return JSON.parseObject(registerUser);
    }

    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    @Override
    public List<SysConfig> selectConfigList(SysConfig config) {
        return configMapper.selectConfigList(config);
    }

    /**
     * 新增参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public int insertConfig(SysConfig config) {
        int row = configMapper.insertConfig(config);
        if (row > 0) {
            redisCache.setCacheObject(getCacheKey(config.getConfigKey()), config.getConfigValue());
        }
        return row;
    }

    /**
     * 修改参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public int updateConfig(SysConfig config) {
        SysConfig temp = configMapper.selectConfigById(config.getConfigId());
        if (!StringUtils.equals(temp.getConfigKey(), config.getConfigKey())) {
            redisCache.deleteObject(getCacheKey(temp.getConfigKey()));
        }
        int row = configMapper.updateConfig(config);
        if (row > 0) {
            redisCache.setCacheObject(getCacheKey(config.getConfigKey()), config.getConfigValue());
        }
        return row;
    }

    /**
     * 批量删除参数信息
     *
     * @param configIds 需要删除的参数ID
     */
    @Override
    public void deleteConfigByIds(Long[] configIds) {
        for (Long configId : configIds) {
            SysConfig config = selectConfigById(configId);
            if (StringUtils.equals(UserConstants.YES, config.getConfigType())) {
                throw new ServiceException(String.format("内置参数【%1$s】不能删除 ", config.getConfigKey()));
            }
            configMapper.deleteConfigById(configId);
            redisCache.deleteObject(getCacheKey(config.getConfigKey()));
        }
    }

    /**
     * 加载参数缓存数据
     */
    @Override
    public void loadingConfigCache() {
        List<SysConfig> configsList = configMapper.selectConfigList(new SysConfig());
        for (SysConfig config : configsList) {
            redisCache.setCacheObject(getCacheKey(config.getConfigKey()), config.getConfigValue());
        }
    }

    /**
     * 清空参数缓存数据
     */
    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisCache.keys(CacheConstants.SYS_CONFIG_KEY + "*");
        redisCache.deleteObject(keys);
    }

    /**
     * 重置参数缓存数据
     */
    @Override
    public void resetConfigCache() {
        clearConfigCache();
        loadingConfigCache();
    }

    /**
     * 校验参数键名是否唯一
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public String checkConfigKeyUnique(SysConfig config) {
        Long configId = StringUtils.isNull(config.getConfigId()) ? -1L : config.getConfigId();
        SysConfig info = configMapper.checkConfigKeyUnique(config.getConfigKey());
        if (StringUtils.isNotNull(info) && info.getConfigId().longValue() != configId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 获取账号自助-拼图验证码图片
     * @return 结果
     */
    @Override
    public JSONArray selectSliderCaptcha() {
        String sliderCaptcha = selectConfigByKey("sys.account.sliderCaptcha");
        if(StringUtils.isEmpty(sliderCaptcha)){
            JSONArray jsonArray = JSON.parseArray("[{\"imgUrl\":\"https://blog-dragon.oss-cn-shenzhen.aliyuncs.com/slider-captcha/slider_captcha_1.png\"},{\"imgUrl\":\"https://blog-dragon.oss-cn-shenzhen.aliyuncs.com/slider-captcha/slider_captcha_2.png\"},{\"imgUrl\":\"https://blog-dragon.oss-cn-shenzhen.aliyuncs.com/slider-captcha/slider_captcha_3.png\"},{\"imgUrl\":\"https://blog-dragon.oss-cn-shenzhen.aliyuncs.com/slider-captcha/slider_captcha_4.png\"}]");
            return jsonArray;
        }
        return JSON.parseArray(sliderCaptcha);
    }

    /**
     * 获取阿里云短信服务配置
     * @return 结果
     */
    @Override
    public JSONObject selectAliyunSms() {
        String aliyunSms = selectConfigByKey("sys.aliyun.sms");
        if(StringUtils.isEmpty(aliyunSms)){
            JSONObject obj = JSON.parseObject("{\"signature\":\"DragonWen\",\"templateCode\":\"SMS_248095388\"}");
            return obj;
        }
        return JSON.parseObject(aliyunSms);
    }

    /**
     *
     * @return
     */
    @Override
    public String selectEmailTemplateVerificationCode() {
        String emailTemplate = selectConfigByKey("sys.emailTemplate.verificationCode");
        if(StringUtils.isEmpty(emailTemplate)){
            emailTemplate = "【DragonWen】您的验证码#{[code]}，该验证码#{[expires]}分钟内有效，请勿泄露于他人！";
        }
        return emailTemplate;
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey) {
        return CacheConstants.SYS_CONFIG_KEY + configKey;
    }
}
