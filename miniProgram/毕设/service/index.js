const BASE_URL = 'http://192.168.1.4:8081/'

class lsRequest{
 request(url,method,params){
  
   return new Promise((resolve,reject)=>{
     wx.request({
       url:BASE_URL + url,
       method:method,
       data:params,
       success:function(res){
        resolve(res)
       },
       fail:function(err){
        reject(err)
       }
     })
   })
 }

 get(url,params){
  return this.request(url,"GET",params)
 }
 post(url,params){
  return this.request(url,"POST",params)
 }
 delete(url,params){
  return this.request(url,"DELETE",params)
 }

}

const LsRequest = new lsRequest()

export default LsRequest
