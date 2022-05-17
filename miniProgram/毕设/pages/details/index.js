// pages/details/index.js
import LsRequest from '../../service/index'
Page({

  /**
   * 页面的初始数据
   */
  data: {
   cardData:[],
  },
  showCourse:function(event){
    var listId = event.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/list-detail/index?cs_id='+ listId
    })
  },
  loadDetailsData:function(cid){
    LsRequest.get(`education/course/selectCourse?c_id=${cid}`).then(res=>{
      this.setData({cardData:res.data})
    })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.loadDetailsData(options.c_id)
   
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})