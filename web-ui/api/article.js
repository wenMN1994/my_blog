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
}