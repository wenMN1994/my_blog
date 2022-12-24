import axios from 'axios'
import { Notification, MessageBox, Message, Loading } from 'element-ui'
import cookie from 'js-cookie'
import { tansParams } from "@/utils/commonUtils";

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// 创建axios实例
const service = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: process.env.BASE_URL,
  // 超时
  timeout: 30000
})

// request拦截器
service.interceptors.request.use(config => {
  // get请求映射params参数
  if (config.method === 'get' && config.params) {
    let url = config.url + '?' + tansParams(config.params);
    url = url.slice(0, -1);
    config.params = {};
    config.url = url;
  }
  return config
}, error => {
    console.log(error)
    Promise.reject(error)
})

export default service