import request from '@/utils/request'

export default {
  // 分页查询文章数据数据
  getArticlePageList(query) {
    return request({
      url: '/publicApi/articleFront/getArticlePageList',
      method: 'get',
      params: query
    })
  },
  // 根据文章ID获取文章详细信息
  getArticleInfo(query) {
    return request({
      url: '/publicApi/articleFront/getArticleInfo',
      method: 'get',
      params: query
    })
  },
}
