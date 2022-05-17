import axios from 'axios'
import store from '../store'

//创建axios实例
const service = axios.create({
  baseURL: '/api', // api的api_url process.env.API_URL
  timeout: 0, // 请求超时时间
  withCredentials: true
})

// request拦截器
service.interceptors.request.use(config => {
  return config
}, () => {
})

// respone拦截器
service.interceptors.response.use(
  response => {
    return response
  },
)

export default service
