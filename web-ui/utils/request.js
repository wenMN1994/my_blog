import axios from 'axios'
import { Notification, MessageBox, Message, Loading } from 'element-ui'
import cookie from 'js-cookie'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// 创建axios实例
const service = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: process.env.BASE_URL,
  // 超时
  timeout: 10000
})

export default service