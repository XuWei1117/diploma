// pages/home/index.js
import LsRequest from '../../service/index'
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    active: 0,
    newsDetialData:[]
  },

  // handleSearchClick:function(){
  //   wx.navigateTo({
  //     url: '/pages/search/index',
  //   })
  // },
  
  loadNewsDetailData:function(n_id){
    LsRequest.get(`education/news/selectNewsDetail?n_id=${n_id}`).then(res=>{
      this.setData({newsDetialData :res.data})
    })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.loadNewsDetailData(options.n_id)
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