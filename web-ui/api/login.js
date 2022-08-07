import request from '@/utils/request'

export default {
    //登录的方法
  submitLoginUser(userInfo) {
    return request({
      url: `/web/member/login`,
      method: 'post',
      data: userInfo
    })
  },

  //根据token获取用户信息
  getLoginUserInfo() {
    return request({
      url: `/web/member/getMemberInfo`,
      method: 'get'
    })
  },

  // 获取滑块拼图验证码
  getSliderCaptcha(param) {
    return request({
      url: `/sliderCaptcha`,
      method: 'get',
      params: param
    })
  },

  // 验证滑块拼图验证码
  checkSliderCaptcha(params) {
    return request({
      url: `/checkSliderCaptcha`,
      method: 'post',
      data: params
    })
  }

}