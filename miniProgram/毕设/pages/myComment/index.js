import LsRequest from '../../service/index'
Page({
  loadMyCommentData:function(user_id){
    LsRequest.get(`education/comment/selectAllByUserId?user_id=${user_id}`).then(res=>{
      console.log(res.data);
      this.setData({cardData:res.data})
    })

  },

  // /**
  //  * 生命周期函数--监听页面加载
  //  */
  onLoad: function (options) {
    console.log(options);
    this.loadMyCommentData(options.user_id)
   
  },

  })
 