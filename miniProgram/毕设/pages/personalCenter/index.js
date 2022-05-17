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
  login(){
    wx.getUserProfile({
      desc: '用于完善会员资料',
      success:res=>{
        let user = res.userInfo
        //把用户信息缓存到本地
        wx.setStorageSync('user', user)
        console.log("用户信息",user),
        this.setData({
          userInfo : user
        })
      },
      fail(res){
        console.log("授权失败",res)

      }
    })
  },
  //退出登录
  loginOut(){
    this.setData({
      userInfo : ''
    })
    wx.setStorageSync('user', null)
    // wx.navigateTo({
    //   url: '/pages/authorization/index',
    // })
  },
  getMyComment(){
    var user_id = wx.getStorageSync('u_id');
    console.log(user_id);
    wx.navigateTo({
      url: '/pages/myComment/index?user_id='+user_id,
    })
    
  },
  goShopping(){
    wx.navigateTo({
      url: '/pages/shopping/index',
    })
  }
})