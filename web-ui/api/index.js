import request from '@/utils/request'

export default {
  // 查询轮播图数据
  getSlideshowList() {
    return request({
      url: '/publicApi/indexFront/getSlideshowList',
      method: 'get'
    })
  },
  // 查询轮播图数据
  getIndexData() {
    return request({
      url: '/publicApi/indexFront/getIndexData',
      method: 'get'
    })
  },
  // 查询网站配置信息
  getWebsiteConfigInfo() {
    return request({
      url: '/getWebsiteConfigInfo',
      method: 'get'
    })
  }
}