// pages/home/index.js
import LsRequest from '../../service/index'
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    historyData:[],
    active: 0,
    swiperData:[],
    RecommendData:[],
    NewsData:[]
  },
  onChange(event) {
    // event.detail 的值为当前选中项的索引
    console.log(event);
    this.setData({ active: event.detail });
  },
  handleSearchClick:function(){
    wx.navigateTo({
      url: '/pages/search/index',
    })
  },

  loadSwiperData:function(){
    LsRequest.get('education/swiper/selectSwiper').then(res=>{
      console.log(res)
      this.setData({swiperData:res.data})
    })
  },
  loadRecommendData:function(){
    LsRequest.get('education/category/selectCategory').then(res=>{
      this.setData({RecommendData:res.data})
    })
  },
  loadNewsData:function(){
    LsRequest.get('education/news/selectAllNews').then(res=>{
      this.setData({NewsData:res.data})
    })
  },
  handleImgClick:function(item){
    console.log(item);
    var c_id = item.currentTarget.dataset.imgdetail.c_id
  //  LsRequest.get('education/course/selectCourse',item.currentTarget.dataset.imgdetail.c_id).then(res=>{
  //     // console.log(res);
  //   })
  wx.navigateTo({
    url: '/pages/details/index?c_id='+c_id,
  })
      
    
  },

  handleSwiperClick:function(item){
      //console.log(item);
      var c_id = item.currentTarget.dataset.imgdetail.category_id;
      //将category_id赋值给c_id,点击轮播图跳转到分类对应的课程路径
      wx.navigateTo({
        url: '/pages/details/index?c_id='+c_id,
      })
  },
  

  handleNewsClick:function(item){
    var n_id = item.currentTarget.dataset.imgdetail.n_id;
    console.log(n_id);
    wx.navigateTo({
      url: '/pages/news1/index?n_id='+n_id,
    })
},

  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.loadSwiperData()
    this.loadRecommendData()
    this.loadNewsData()
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