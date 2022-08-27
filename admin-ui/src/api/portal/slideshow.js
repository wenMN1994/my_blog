import request from '@/utils/request'

// 查询轮播图管理列表
export function listSlideshow(query) {
  return request({
    url: '/portal/slideshow/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图管理详细
export function getSlideshow(slideshowId) {
  return request({
    url: '/portal/slideshow/' + slideshowId,
    method: 'get'
  })
}

// 新增轮播图管理
export function addSlideshow(data) {
  return request({
    url: '/portal/slideshow',
    method: 'post',
    data: data
  })
}

// 修改轮播图管理
export function updateSlideshow(data) {
  return request({
    url: '/portal/slideshow',
    method: 'put',
    data: data
  })
}

// 删除轮播图管理
export function delSlideshow(slideshowId) {
  return request({
    url: '/portal/slideshow/' + slideshowId,
    method: 'delete'
  })
}
