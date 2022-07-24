import axios from 'axios'
import { getToken } from '@/utils/auth'

export function uploadFileToOss(api, file) {
    var data = new FormData()
    data.append('file', file)
    const config = {
      headers: { 'Authorization': "Bearer " + getToken() }
    }
    return axios.post(api, data, config)
  }

export function uploadFilesToOss(api, file) {
  var data = new FormData()
  data.append('files', file)
  const config = {
    headers: { 'Authorization': "Bearer " + getToken() }
  }
  return axios.post(api, data, config)
}
