import LsRequest from '../../service/index'
Page({
    data: {
      userInfo:''
    },
    onLoad(){
      let user =  wx.getStorageSync('user')
      console.log("进入小程序的index首页获取缓存",user)
      this.setData({
        userInfo : user
      })
     
    },
    //登录获取用户信息
    // login(){
    //   wx.getUserProfile({
    //     desc: '用于完善会员资料',
    //     success:res=>{
    //       let user = res.userInfo
    //       //把用户信息缓存到本地
    //       wx.setStorageSync('user', user)
    //       console.log("用户信息",user),
    //       this.setData({
    //         userInfo : user
    //       })
    //     },
    //     fail(res){
    //       console.log("授权失败",res)
  
    //     }
    //   })
    // },

    login(){
      wx.getUserProfile({
        desc: '用于完善会员资料',
        //点击允许授权，将用户信息存放到缓存
        success:res=>{
          let user = res.userInfo
          //把用户信息缓存到本地
          wx.setStorageSync('user', user)
          console.log("用户信息",user),
          this.setData({
            userInfo : user
          })
          //先调用wx.login方法获取到code
          wx.login({
            success(res){
              console.log(res);
             if(res.code){
                // console.log("获取到code",res.code)
                LsRequest.post('education/me/login',{
                  code:res.code,
                  u_name: user.nickName,
                  u_gender: user.gender,
                  u_city: user.city,
                  u_province: user.province,
                  u_img: user.avatarUrl
                }
                  
                ).then(res=>{
                  console.log(res);
                  wx.setStorageSync('u_id',res.data.u_id)
                })
                // wx.login({
                //   success (res) {
                //     if (res.code) {
                //       console.log(res.code);
                //       //发起网络请求
                //       wx.request({
                //         method:'POST',
                //         url: 'http://10.10.3.29:8081/education/me/login',
                //         data: {
                //           code: res.code
                //         }
                //       })
                //     } else {
                //       console.log('登录失败！' + res.errMsg)
                //     }
                //   }
                // })
                
              }else{
                console.log("登录失败"+res.errMsg)
              }
            }
          })

          //授权成功跳转到首页
          wx.switchTab({      
            url: '/pages/home/index',    //要跳转到的页面路径
          })
        },
        //授权失败也可以跳转到首页
        fail(res){
          console.log("授权失败",res)
          // wx.switchTab({      
          //   url: '/pages/home/index',    //要跳转到的页面路径
          // })  
  
        }
      })
    },
    //退出登录
    loginOut(){
      this.setData({
        userInfo : ''
      })
      wx.setStorageSync('user', null)
    },
    //点击go跳到首页
    //跳到首页的时候将用户信息存到数据库，或者从数据库中查询用户信息
    gotoPage(){
      wx.switchTab({      
        url: '/pages/home/index',    //要跳转到的页面路径
      })  

    }
  })
 